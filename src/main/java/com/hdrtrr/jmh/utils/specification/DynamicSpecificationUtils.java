package com.hdrtrr.jmh.utils.specification;

import com.hdrtrr.jmh.utils.page.SearchFilter;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 2:15
 *  基于JPA的Specification动态查询
 * @Version 1.0
 */
public class DynamicSpecificationUtils {

    /**
     * 日期格式
     */
    private static final String DATE = "yyyy-MM-dd";
    /**
     * 日期时间格式
     */
    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式
     */
    private static final String TIME = "HH:mm:ss";

    /**
     * 构建查询
     *
     * @param filterSet 条件
     * @param <T>       数据
     * @return .
     */
    private static <T> Specification<T> bySearchFilter(final Set<SearchFilter> filterSet) {
        return (Root<T> r, CriteriaQuery<?> q, CriteriaBuilder b) -> {
            if (filterSet != null && !filterSet.isEmpty()) {
                List<Predicate> predicates = new ArrayList<>();
                for (SearchFilter filter : filterSet) {
                    String[] names = StringUtils.split(filter.getFieldName(), ".");
                    Path expression = r.get(names[0]);
                    for (int i = 1; i < names.length; i++) {
                        expression = expression.get(names[i]);
                    }
                    // 自动进行enum和date的转换。
                    Class clazz = expression.getJavaType();
                    if (Date.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
                        filter.setValue(convert2Date((String) filter.getValue()));
                    } else if (Enum.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
                        filter.setValue(convert2Enum(clazz, (String) filter.getValue()));
                    } else if (LocalDateTime.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
                        String value = (String) filter.getValue();
                        if (!value.contains(",")) {
                            filter.setValue(convert2LocalDateTime(value));
                        }
                    } else if (LocalDate.class.isAssignableFrom(clazz) && !filter.getValue().getClass().equals(clazz)) {
                        String value = (String) filter.getValue();
                        if (!value.contains(",")) {
                            filter.setValue(convert2LocalDateTime(value));
                        }
                    }

                    switch (filter.getOperator()) {
                        case EQ:
                            predicates.add(b.equal(expression, filter.getValue()));
                            break;
                        case LIKE:
                            predicates.add(b.like(expression, "%" + filter.getValue() + "%"));
                            break;
                        case LLIKE:

                            predicates.add(b.like(expression, "%" + filter.getValue()));
                            break;
                        case RLIKE:
                            predicates.add(b.like(expression, filter.getValue() + "%"));
                            break;
                        case GT:
                            predicates.add(b.greaterThan(expression, (Comparable) filter.getValue()));
                            break;
                        case LT:
                            predicates.add(b.lessThan(expression, (Comparable) filter.getValue()));
                            break;
                        case GTE:
                            predicates.add(b.greaterThanOrEqualTo(expression, (Comparable) filter.getValue()));
                            break;
                        case LTE:
                            predicates.add(b.lessThanOrEqualTo(expression, (Comparable) filter.getValue()));
                            break;
                        case IN:
                            predicates.add(b.and(expression.in((Object[]) filter.getValue().toString().split(","))));
                            break;
                        case ISNULL:
                            predicates.add(b.isNull(expression));
                            break;
                        case BETWEEN:

                            if (LocalDateTime.class.isAssignableFrom(clazz)) {
                                predicates.add(b.between(expression, getDate(filter.getValue(), 0), getDate(filter.getValue(), 1)));
                            } else if (LocalDate.class.isAssignableFrom(clazz)) {
                                predicates.add(b.between(expression, convert2LocalDate(((String) filter.getValue()).split(",")[0])
                                        , convert2LocalDate(((String) filter.getValue()).split(",")[1])));
                            } else if (String.class.isAssignableFrom(clazz)) {
                                if (filter.getValue() != null) {
                                    predicates.add(b.between(expression, ((String) filter.getValue()).split(",")[0]
                                            , ((String) filter.getValue()).split(",")[1]));
                                }
                            }
                            break;
                        case NOTEQ:
                            predicates.add(b.notEqual(expression, filter.getValue()));
                            break;
                        case ISNOTNULL:
                            predicates.add(b.isNotNull(expression));
                            break;
                        default:
                            predicates.add(b.equal(expression, filter.getValue()));
                    }
                }
                // 将所有条件用 and 联合起来
                if (predicates.size() > 0) {
                    return b.and(predicates.toArray(new Predicate[0]));
                }
            }
            return b.conjunction();
        };
    }

    /**
     * 构建Specification复杂查询条件
     *
     * @param searchFilters 查询条件
     * @param <T>           t
     * @return Specification
     */
    public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> searchFilters) {
        SearchFilter[] toArray = searchFilters.toArray(new SearchFilter[]{});
        final Set<SearchFilter> filterSet = new HashSet<>(Arrays.asList(toArray));
        return bySearchFilter(filterSet);
    }

    private static LocalDateTime getDate(Object value, int i) {
        String s = value == null ? "" : (String) value;
        String s1 = s.split(",")[i];
        if ("undefined".equals(s1) || "null".equals(s1)) {
            return LocalDateTime.now();
        }
        System.out.println("s1 = " + s1);
        if (s1.length() == 10) {
            return LocalDateTime.of(LocalDate.parse(s1), LocalTime.MIN);
        }
        return LocalDateTime.parse(s1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    private static LocalDate convert2LocalDate(String value) {
        return LocalDate.parse(value);
    }

    private static <E extends Enum<E>> E convert2Enum(Class<E> enumClass, String enumString) {
        return EnumUtils.getEnum(enumClass, enumString);
    }

    private static Date convert2Date(String dateString) {
        SimpleDateFormat sFormat = new SimpleDateFormat(DATE);
        try {
            return sFormat.parse(dateString);
        } catch (ParseException e) {
            try {
                return sFormat.parse(DATE_TIME);
            } catch (ParseException e1) {
                e1.printStackTrace();
                try {
                    return sFormat.parse(TIME);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    private static LocalDateTime convert2LocalDateTime(String value) {
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(DATE_TIME));
    }
}
