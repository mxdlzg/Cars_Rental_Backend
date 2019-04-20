package com.mxdlzg.rental.controller.account;

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
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public RestResult register(@RequestBody Map<String,String> rUser){
        RtUser userBean = new RtUser();
        userBean.setUsername(rUser.getOrDefault("email",""));
        userBean.setPassword(bCryptPasswordEncoder.encode(rUser.get("password")));
        userBean.setRole("ROLE_USER");
        userBean.setPhone(rUser.getOrDefault("mobile",""));
        userBean = userRepository.save(userBean);
        return new RestResult("ok","200","注册成功,ID:"+userBean.getId(),null);
    }
}
