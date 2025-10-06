package com.springbootstore.apifundamental.dtos.users;

import com.springbootstore.apifundamental.dtos.PageRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {
    private String sortBy;
    private PageRequest pageRequest;
}
