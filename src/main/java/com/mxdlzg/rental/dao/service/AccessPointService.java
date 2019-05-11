package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.BaseRepository;
import com.mxdlzg.rental.dao.respository.PageAccessRepository;
import com.mxdlzg.rental.domain.entity.RtPageAccessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessPointService extends BaseServiceImpl<RtPageAccessEntity,Integer>{
    @Autowired
    PageAccessRepository pageAccessRepository;

    public void addAccess(String name,int id,int userId){
        pageAccessRepository.save(new RtPageAccessEntity(name,id,userId));
    }
}
