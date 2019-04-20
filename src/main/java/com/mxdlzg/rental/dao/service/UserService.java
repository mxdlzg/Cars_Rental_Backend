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

    public RtUser savePerson(String name){
        RtUser userBean = new RtUser();
        userBean.setUsername(name);
        return userRepository.save(userBean);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RtUser userBean = userRepository.findByUsername(s);
        return new JwtUser(userBean);
    }
}
