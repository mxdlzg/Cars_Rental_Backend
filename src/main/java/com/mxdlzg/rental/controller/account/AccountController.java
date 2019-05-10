package com.mxdlzg.rental.controller.account;

import com.mxdlzg.rental.dao.service.UserService;
import com.mxdlzg.rental.domain.entity.RtUserEntity;
import com.mxdlzg.rental.domain.model.JwtUser;
import com.mxdlzg.rental.domain.model.LoginResult;
import com.mxdlzg.rental.domain.model.OrderSubmitForm;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/api/register")
    public ResponseEntity<RestResult> register(@RequestBody Map<String,String> rUser){
        RtUserEntity userBean = new RtUserEntity();
        userBean.setUsername(rUser.getOrDefault("email",""));
        RestResult restResult;
        if (!userService.isExist(userBean.getUsername())){
            userBean.setPassword(bCryptPasswordEncoder.encode(rUser.get("password")));
            userBean.setRole(RtUserEntity.ROLE_USER);
            userBean.setPhone(rUser.getOrDefault("mobile",""));
            //Check user info
            ResponseEnums state = userService.verify(userBean);
            if (state == ResponseEnums.VALID_USER){
                userBean = userService.addNewUser(userBean);
                restResult = new RestResult<String>(ResponseEnums.SUCCESS_OPTION,null);
            }else {
                //invalid
                restResult = RestResult.fail(state);
            }
        }else {
            //repeat register
            restResult = RestResult.fail(ResponseEnums.REPEAT_REGISTER);
        }
        return new ResponseEntity<RestResult>(restResult, restResult.isSuccess()?HttpStatus.CREATED:HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/login/account")
    public RestResult<LoginResult> login(
            @Validated
            @RequestBody JwtUser user,
            BindingResult validatorResult){


        return null;
    }

    @GetMapping("/api/currentUser")
    public RestResult<RtUserEntity> queryUser(@RequestHeader("Authorization") String token){
        int userId = JwtTokenUtils.getUserId(token);
        return new RestResult<>(userService.queryUserProfile(userId));
    }

}
