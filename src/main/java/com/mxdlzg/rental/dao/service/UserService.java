package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.domain.entity.RtUser;
import com.mxdlzg.rental.domain.model.JwtUser;
import com.mxdlzg.rental.dao.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RtUser userBean = userRepository.findByUsername(s);
        return new JwtUser(userBean);
    }

    public boolean isExist(String username) {
        return userRepository.findByUsername(username)!=null;
    }

    public RtUser addNewUser(RtUser userBean) {
        return userRepository.save(userBean);
    }
}
