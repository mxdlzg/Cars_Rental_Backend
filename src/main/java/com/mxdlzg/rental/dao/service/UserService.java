package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.CurrentUserRepo;
import com.mxdlzg.rental.dao.respository.UserStoreRepo;
import com.mxdlzg.rental.domain.entity.RtCurrentUserEntity;
import com.mxdlzg.rental.domain.entity.RtUserEntity;
import com.mxdlzg.rental.domain.entity.RtvUserStoreEntity;
import com.mxdlzg.rental.domain.model.JwtUser;
import com.mxdlzg.rental.dao.respository.UserRepository;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    CurrentUserRepo currentUserRepo;
    @Autowired
    UserStoreRepo userStoreRepo;

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

    public RtCurrentUserEntity queryUserProfile(int userId) {
        return currentUserRepo.findByUserId(userId);
    }

    @Transactional
    public void increaseIntegral(int userId, int integral) {
        RtUserEntity userEntity = userRepository.findById(userId);
        userEntity.setIntegral(userEntity.getIntegral()==null?integral:userEntity.getIntegral()+integral);
        //userRepository.save(userEntity);
    }

    public List<RtvUserStoreEntity> queryUserMI(int userId) {
        return userStoreRepo.findAllByUserId(userId);
    }
}
