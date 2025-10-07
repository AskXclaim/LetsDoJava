package com.springbootstore.apifundamental.utilities;

import com.springbootstore.apifundamental.dtos.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Set;

public class RequestParams {
    public static org.springframework.data.domain.PageRequest
    getReposPageRequest(String sortBy, PageRequest pageRequest) {
        sortBy = getSortBy(sortBy);
        pageRequest = getPageRequest(pageRequest);

        var repoSortBy = Sort.by(Sort.Direction.ASC, sortBy);
        return org.springframework.data.domain.PageRequest.of(
                pageRequest.getPage(), pageRequest.getSize(), repoSortBy);
    }

    private static PageRequest getPageRequest(PageRequest pageRequest) {
        if (pageRequest == null) {
            pageRequest = PageRequest.builder().page(0).size(10).build();
        }
        return pageRequest;
    }

    private static String getSortBy(String sortBy) {
        if (sortBy == null || sortBy.isEmpty() || !Set.of( "name", "email").contains(sortBy) ) {
            sortBy = "name";
        }
        return sortBy;
    }
}
