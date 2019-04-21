package com.mxdlzg.rental.dao.exception;

import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.domain.model.exception.RentalRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.sql.SQLException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 请求参数类型错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={BindException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public RestResult<ResponseEnums> badRequest(BindException e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResult<>(false, ResponseEnums.BAD_REQUEST);
    }

    /**
     * 404错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public RestResult<ResponseEnums> badRequestNotFound(BindException e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResult<>(false, ResponseEnums.NOT_FOUND);
    }

//    /**
//     * mybatis未绑定异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(BindingException.class)
//    @ResponseBody
//    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseBean<String> mybatis(Exception e){
//        logger.error("occurs error when execute method ,message {}",e.getMessage());
//        return new ResponseBean<>(false,ResponseEnums.BOUND_STATEMENT_NOT_FOUNT);
//    }

    /**
     * 自定义异常的捕获
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value={RentalRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> RestResult<ResponseEnums> sendError(RentalRuntimeException exception, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        logger.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMsg());
        return new RestResult<>(false,exception.getCode(),exception.getMsg());
    }
    /**
     * 数据库操作出现异常
     * @param e
     * @return
     */
    @ExceptionHandler(value={SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult<ResponseEnums> systemError(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResult<>(false, ResponseEnums.DATABASE_ERROR);
    }

    /**
     * 网络连接失败！
     * @param e
     * @return
     */
    @ExceptionHandler(value={ConnectException.class})
    @ResponseBody
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult<ResponseEnums> connect(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResult<>(false, ResponseEnums.CONNECTION_ERROR);
    }

    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
    public RestResult<ResponseEnums> notAllowed(Exception e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResult<>(false, ResponseEnums.METHOD_NOT_ALLOWED);
    }

}
