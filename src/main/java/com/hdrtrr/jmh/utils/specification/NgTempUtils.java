package com.hdrtrr.jmh.utils.specification;

import com.hdrtrr.jmh.utils.SysConstants;
import com.hdrtrr.jmh.utils.page.NgMathMode;
import com.hdrtrr.jmh.utils.page.NgPager;
import com.hdrtrr.jmh.utils.page.SearchFilter;
import com.sun.istack.internal.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ���� 2:35
 * ��ѯģ�幤����
 * @Version 1.0
 */
public class NgTempUtils {
    public static final String DESC = "desc";
    public static final String ASC = "asc";

    /**
     * ���� NgPage ���ɳ�  Collection<SearchFilter>����
     *
     * @param pager ��ҳ
     * @return Collection<SearchFilter>
     */
    public static Collection<SearchFilter> buildWhereClause(NgPager pager) {
        Set<SearchFilter> searchFilters = new HashSet<>();

        if (pager == null || CollectionUtils.isEmpty(pager.getFilters())) {
            return searchFilters;
        }

        pager.getFilters().forEach((k, v) -> searchFilters.add(new SearchFilter(k, parse(v.getMatchMode()), v.getValue())));
        return searchFilters;
    }

    /**
     * ���÷�ҳ
     *
     * @param pager fenye
     * @return #
     */
    public static PageRequest buildPageRequest(NgPager pager) {
        Assert.notNull(pager, SysConstants.ENTITY_MUST_NOT_BE_NULL);
        if (null != pager.getMultiSortMeta() && pager.getMultiSortMeta().length > 0) {
            List<Sort.Order> orders = java.util.Arrays.stream(pager.getMultiSortMeta())
                    .map(k -> new Sort.Order(Sort.Direction.fromString(k.getOrder() == -1 ? DESC : ASC), k.getField()))
                    .collect(Collectors.toList());
            return buildPageRequest(pager.getFirst() / pager.getRows(), pager.getRows(), Sort.by(orders));
        }
        if (pager.getSortField() != null) {
            Sort sort = new Sort(Sort.Direction.fromString(pager.getSortOrder() == -1 ? DESC : ASC), pager.getSortField());
            return buildPageRequest(pager.getFirst() / pager.getRows(), pager.getRows(), sort);
        }
        return PageRequest.of(pager.getFirst() / pager.getRows(), pager.getRows());
    }

    /**
     * ���÷�ҳ
     *
     * @return #
     */
    public static PageRequest buildPageRequest(@NotNull Integer startRow, @NotNull Integer rows, Sort sort) {
        return PageRequest.of(startRow, rows, sort);
    }

    /**
     * ������ѯ ��ǰ�˴����Ĳ�ѯģʽ�����ڣ�����...��ת��Ϊ��̨��Ӧ�Ĳ�ѯ����
     *
     * @param matchMode NgMathMode
     * @return Operatorö�ٶ���
     */
    private static SearchFilter.Operator parse(String matchMode) {
        if (matchMode == null) {
            return SearchFilter.Operator.EQ;
        }
        SearchFilter.Operator op;
        switch (matchMode) {
            case NgMathMode.CONTAINS:
                op = SearchFilter.Operator.LIKE;
                break;
            case NgMathMode.EQUALS:
                op = SearchFilter.Operator.EQ;
                break;
            case NgMathMode.IN:
                op = SearchFilter.Operator.IN;
                break;
            case NgMathMode.STARTS_WITH:
                op = SearchFilter.Operator.RLIKE;
                break;
            case NgMathMode.ENDS_WITH:
                op = SearchFilter.Operator.LLIKE;
                break;
            case NgMathMode.ISNULL:
                op = SearchFilter.Operator.ISNULL;
                break;
            case NgMathMode.ISNOTNULL:
                op = SearchFilter.Operator.ISNOTNULL;
                break;
            case NgMathMode.LT:
                op = SearchFilter.Operator.LT;
                break;
            case NgMathMode.GT:
                op = SearchFilter.Operator.GT;
                break;
            case NgMathMode.GTE:
                op = SearchFilter.Operator.GTE;
                break;
            case NgMathMode.LTE:
                op = SearchFilter.Operator.LTE;
                break;
            case NgMathMode.BETWEEN:
                op = SearchFilter.Operator.BETWEEN;
                break;
            default:
                op = SearchFilter.Operator.EQ;
        }
        return op;
    }
}
