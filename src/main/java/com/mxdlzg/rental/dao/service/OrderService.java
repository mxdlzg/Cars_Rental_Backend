package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.PriceRepository;
import com.mxdlzg.rental.dao.respository.StoreRepository;
import com.mxdlzg.rental.dao.respository.UserRepository;
import com.mxdlzg.rental.domain.entity.RtPriceEntity;
import com.mxdlzg.rental.domain.entity.RtStoresEntity;
import com.mxdlzg.rental.domain.entity.RtUserEntity;
import com.mxdlzg.rental.domain.model.OrderPriceDetail;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    UserRepository userRepository;

    public OrderPriceDetail queryOrderDetail(int carId, Long startDate, Long endDate, int start, int end) {
        //定价条目
        List<RtPriceEntity> detail = priceRepository.findAllByCarId(carId);
        //amount
        int days = Converter.diffDays(startDate, endDate);
        float amount = 0;
        detail.forEach(rtPriceEntity -> {
            rtPriceEntity.setNum(rtPriceEntity.getPriceByDay() ? days : 1);
            rtPriceEntity.setAmount(rtPriceEntity.getPriceByDay() ? rtPriceEntity.getPrice() : days * rtPriceEntity.getPrice());
        });
        for (RtPriceEntity rtPriceEntity : detail) {
            amount += rtPriceEntity.getAmount();
        }
        //time
        Timestamp startTime = Converter.toTimestamp(startDate);
        Timestamp endTime = Converter.toTimestamp(endDate);
        //location
        RtStoresEntity startStore = storeRepository.findById(start).orElse(null);
        RtStoresEntity endStore = storeRepository.findById(end).orElse(null);

        return new OrderPriceDetail(detail, amount, startTime, endTime, startStore.getLocation(), endStore.getLocation());
    }

    @Transactional
    boolean submit() {
        return false;
    }

    public void submitOrder(String token, Map<String, Object> map) {
        String username = JwtTokenUtils.getUsername(token);
        RtUserEntity userEntity = userRepository.findByUsername(username);
    }
}
