package com.mxdlzg.rental.domain.auth;

import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.ServerletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ServerletResponse.doResponse(httpServletResponse,HttpServletResponse.SC_FORBIDDEN, ResponseEnums.BAD_REQUEST,"error",false);
    }
}
