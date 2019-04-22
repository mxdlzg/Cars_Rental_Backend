package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.StoreRepository;
import com.mxdlzg.rental.domain.entity.RtCar;
import com.mxdlzg.rental.domain.entity.RtStoresEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreService extends BaseServiceImpl<RtStoresEntity,Long, StoreRepository>{
    @Autowired
    StoreRepository storeRepository;

    public List<RtStoresEntity> fetchStores(int areaNum){
        List<RtStoresEntity> list = null;
        if (areaNum>0){
             list = storeRepository.findRtStoresEntitiesByAreaId(areaNum);
        }
        return list;
    }
}
