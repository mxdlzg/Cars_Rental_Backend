package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.CarRepository;
import com.mxdlzg.rental.dao.respository.UserStoreRepo;
import com.mxdlzg.rental.domain.entity.RtCar;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import com.mxdlzg.rental.domain.entity.RtvUserStoreEntity;
import com.mxdlzg.rental.domain.model.AddCarForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    UserStoreRepo userStoreRepo;

    @Transactional
    public boolean addCar(AddCarForm form) {
        RtCarEntity carEntity = new RtCarEntity(form.getBookAble(),new Timestamp(form.getBuyDate().getTime()),
                form.getDefaultRentPrice(),new Timestamp(form.getManufactureDate().getTime()),
                form.getBookAble(),form.getTypeId(),form.getDescription(),form.getTypeName(),form.getTypeName(),
                form.getStoreId(),form.getServiceTypeId());
        carEntity.setLatestAvailableDate(carEntity.getBuyDate());

        RtCarEntity res = carRepository.save(carEntity);

        return res.getId()>0;
    }

    @Transactional
    public int removeCar(int userId, int id,boolean bp) {
        RtCarEntity carEntity = carRepository.getOne(id);
        RtvUserStoreEntity storeEntity = userStoreRepo.findByStoreIdAndUserId(carEntity.getStoreId(),userId);
        if (storeEntity.getId()>0){
            carEntity.setBookAble(bp);
            carEntity.setRentAble(bp);
            carRepository.save(carEntity);
            return 1;
        }
        return 0;
    }
    @Transactional
    public boolean removeCars(int userId, String[] ids, String op) {
        int res = 1;
        boolean bp = op.equals("online");
        for (int i = 0; i < ids.length; i++) {
            res = res & removeCar(userId,Integer.valueOf(ids[i]),bp);
        }
        return res == 1;
    }
}
