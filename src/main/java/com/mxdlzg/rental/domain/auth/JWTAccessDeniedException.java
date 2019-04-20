package com.mxdlzg.rental.domain.auth;

import java.nio.file.AccessDeniedException;

public class JWTAccessDeniedException extends AccessDeniedException {
    public JWTAccessDeniedException(String file) {
        super(file);
    }
}
