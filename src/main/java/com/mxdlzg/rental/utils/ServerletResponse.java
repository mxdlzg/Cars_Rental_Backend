package com.mxdlzg.rental.utils;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mxdlzg.rental.domain.model.LoginResult;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerletResponse {
    public static void doResponse(HttpServletResponse response, ResponseEnums enums,LoginResult loginResult, String status, boolean success) throws IOException {
        RestResult<LoginResult> result = new RestResult<>(enums,loginResult);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(result));
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
