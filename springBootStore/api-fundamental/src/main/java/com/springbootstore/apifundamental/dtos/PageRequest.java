package com.springbootstore.apifundamental.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequest {
    private int page;
    private int size;
}
