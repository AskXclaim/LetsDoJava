package com.springbootstore.apifundamental.utilities;

import com.springbootstore.apifundamental.dtos.responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtility {


    public static Response getResponse(Object item) {
        return Response.builder().data(item).build();
    }

    public static ResponseEntity<Response> getExceptionCaseResponseEntity(Exception exception) {
        return new ResponseEntity<>(getResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

