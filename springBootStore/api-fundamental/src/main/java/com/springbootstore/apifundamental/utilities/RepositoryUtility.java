package com.springbootstore.apifundamental.utilities;

import org.springframework.data.domain.Page;

import java.util.List;

public class RepositoryUtility {

    public static <T> List<T> getEntities(Page<T> entities) {
        if (entities.isEmpty()) {
            return List.of();
        }
        return entities.getContent();
    }
}
