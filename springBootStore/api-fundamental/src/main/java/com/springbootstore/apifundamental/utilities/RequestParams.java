package com.springbootstore.apifundamental.utilities;

import com.springbootstore.apifundamental.dtos.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.LinkedHashSet;

public class RequestParams {
    public static org.springframework.data.domain.PageRequest
    getReposPageRequest(String sortBy,LinkedHashSet<String> sortByValues, PageRequest pageRequest) {
        sortBy = getSortBy(sortBy, sortByValues);
        pageRequest = getPageRequest(pageRequest);

        var repoSortBy = Sort.by(Sort.Direction.ASC, sortBy);
        return org.springframework.data.domain.PageRequest.of(
                pageRequest.getPage(), pageRequest.getSize(), repoSortBy);
    }

    private static String getSortBy(String sortBy, LinkedHashSet<String> sortByValues) {
        if (sortBy == null || sortBy.isEmpty() || !sortByValues.contains(sortBy)) {
            sortBy = sortByValues.stream().findFirst().orElseThrow();
        }
        return sortBy;
    }
    private static PageRequest getPageRequest(PageRequest pageRequest) {
        return pageRequest == null ? PageRequest.builder().page(0).size(10).build()
                : pageRequest;
    }


}
