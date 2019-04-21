package com.mxdlzg.rental.utils;

import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerletResponse {
    public static void doResponse(HttpServletResponse response, ResponseEnums enums, String status, boolean success) throws IOException {
        RestResult<ResponseEnums> restResult = new RestResult<>(success,enums);
        restResult.setStatus(status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(restResult.toString());
    }

    public static void doResponse(HttpServletResponse response,int httpStatus, ResponseEnums enums, String status, boolean success) throws IOException {
        RestResult<ResponseEnums> restResult = new RestResult<>(success,enums);
        restResult.setStatus(status);
        response.setStatus(httpStatus);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(restResult.toString());
    }
}
