package com.springbootstore.apifundamental.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class  Response {
    private Object data;
}
