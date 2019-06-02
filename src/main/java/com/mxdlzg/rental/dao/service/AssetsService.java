package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.UserCouponsRepo;
import com.mxdlzg.rental.dao.respository.UserRepository;
import com.mxdlzg.rental.domain.entity.RtUserEntity;
import com.mxdlzg.rental.domain.entity.RtvUserCouponsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    @Autowired
    UserCouponsRepo userCouponsRepo;
    @Autowired
    UserRepository userRepository;

    public Page<RtvUserCouponsEntity> queryCouponsList(String name, int page) {
        RtUserEntity userEntity = userRepository.findByUsername(name);
        return userCouponsRepo.findAllByUserIdOrderByEndDateDesc(userEntity.getId(), PageRequest.of(page,10));
    }
}
