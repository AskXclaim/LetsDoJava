package com.springbootstore.apifundamental.dtos.products;

import com.springbootstore.apifundamental.dtos.PageRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductRequest {
    private Byte categoryId;
    private String sortBy;
    private PageRequest pageRequest;
}
