package com.mxdlzg.rental.controller.account;

import com.mxdlzg.rental.dao.service.UserService;
import com.mxdlzg.rental.domain.entity.RtUser;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.dao.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/api/register")
    public RestResult register(@RequestBody Map<String,String> rUser){
        RtUser userBean = new RtUser();
        userBean.setUsername(rUser.getOrDefault("email",""));
        RestResult restResult;
        if (!userService.isExist(userBean.getUsername())){
            userBean.setPassword(bCryptPasswordEncoder.encode(rUser.get("password")));
            userBean.setRole(RtUser.ROLE_USER);
            userBean.setPhone(rUser.getOrDefault("mobile",""));
            userBean = userService.addNewUser(userBean);
            restResult = new RestResult<String>("ok",200,"注册成功,ID:"+userBean.getId());
        }else {
            restResult = RestResult.fail("用户已存在");
        }
        return restResult;
    }
}
