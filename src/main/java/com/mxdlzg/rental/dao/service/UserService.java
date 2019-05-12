package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.domain.entity.RtUserEntity;
import com.mxdlzg.rental.domain.model.JwtUser;
import com.mxdlzg.rental.dao.respository.UserRepository;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RtUserEntity userBean = userRepository.findByUsername(s);
        return new JwtUser(userBean);
    }

    public boolean isExist(String username) {
        return userRepository.findByUsername(username)!=null;
    }

    public RtUserEntity addNewUser(RtUserEntity userBean) {
        return userRepository.save(userBean);
    }

    public ResponseEnums verify(RtUserEntity userBean) {
        return ResponseEnums.VALID_USER;
    }

    public RtUserEntity queryUserProfile(int userId) {
        return userRepository.findUserBeanById(userId);
    }

    @Transactional
    public void increaseIntegral(int userId, int integral) {
        RtUserEntity userEntity = userRepository.findById(userId);
        userEntity.setIntegral(userEntity.getIntegral()+integral);
        //userRepository.save(userEntity);
    }
}
