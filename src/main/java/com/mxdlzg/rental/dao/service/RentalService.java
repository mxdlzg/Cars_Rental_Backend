package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.RtvCarEntity;
import com.mxdlzg.rental.domain.model.FilterParams;
import com.mxdlzg.rental.domain.model.OptionsCar;
import com.mxdlzg.rental.domain.model.OptionsKV;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.DMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    CarStructureRepository structureRepository;
    @Autowired
    CarMakerRepository carMakerRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    RtvCarRepo rtvCarRepo;

    /**
     * @return FilterParams
     */
    public FilterParams queryFilter() {
        List<OptionsCar> optionsCars = new ArrayList<>();
        initOptionsCar(optionsCars);
        List<OptionsKV> structures = structureRepository.findStructures();
        List<OptionsKV> optionsPrice = new ArrayList<>();
        initOptionsPrice(optionsPrice);
        List<OptionsKV> optionsBrand = carMakerRepository.findAllMakers();

        return new FilterParams(optionsCars,structures,optionsPrice,optionsBrand);
    }
    private void initOptionsCar(List<OptionsCar> objects){
        objects.add(new OptionsCar("所有","所有","icon-car",true));
        objects.add(new OptionsCar("SUV","SUV","icon-suv",false));
        objects.add(new OptionsCar("轿车","轿车","icon-jiaocheqiche",false));
        objects.add(new OptionsCar("卡车","卡车","icon-icon3",false));
    }
    private void initOptionsPrice(List<OptionsKV> list){
        list.add(new OptionsKV("0-150",new int[]{0,150}));
        list.add(new OptionsKV("150-300",new int[]{150,300}));
        list.add(new OptionsKV("300-500",new int[]{300,500}));
        list.add(new OptionsKV("500+",new int[]{500,9999}));
    }


    /**
     * @param start start location
     * @param end end
     * @param d1 start date
     * @param d2 end date
     * @param type
     * @return cars
     */
    public Page<RtvCarEntity> findCars(int start, int end, Long d1, Long d2, int type) {
        return prepareData(start,end,d1,d2,type,0);
    }

    public Page<RtvCarEntity> findCarsMore(int start, int end, Long d1, Long d2,int type, int page) {
        return prepareData(start,end,d1,d2,type,page);
    }

    private PageImpl<RtvCarEntity> prepareData(int start, int end, Long d1, Long d2, int type, int page){
        Timestamp startDate = Converter.toTimestamp(d1);
        int days = Converter.diffDays(d1,d2);

        Page<DMap<String,Object>> res = carRepository.findRtCarEntitiesAvailableMore(startDate,days,start,type,PageRequest.of(page,3));
        List<RtvCarEntity> list = new ArrayList<>();
        for (DMap<String, Object> om : res.getContent()) {
            list.add(new RtvCarEntity(
                    Integer.parseInt(om.getWith("id","").toString()),
                    Boolean.valueOf(om.getWith("book_able","").toString()),
                    Timestamp.valueOf(om.getWith("buy_date","").toString()),
                    om.getWith("carcase_id","").toString(),
                    Double.valueOf(om.getWith("default_rent_price","").toString()),
                    om.getWith("engine_id","").toString(),
                    Integer.valueOf(om.getWith("insurance_id","0").toString()),
                    Timestamp.valueOf(om.getWith("manufacture_date","").toString()),
                    Boolean.valueOf(om.getWith("rent_able","").toString()),
                    Integer.valueOf(om.getWith("type_id","0").toString()),
                    om.getWith("description","").toString(),
                    om.getWith("brand_name","").toString(),
                    Integer.valueOf(om.getWith("fuel_id","0").toString()),
                    om.getWith("type_name","").toString(),
                    Integer.valueOf(om.getWith("store_id","0").toString()),
                    Integer.valueOf(om.getWith("capability","0").toString()),
                    Timestamp.valueOf(om.getWith("latest_available_date","").toString()),
                    Integer.valueOf(om.getWith("service_type_id","0").toString()),
                    om.getWith("maker","").toString(),
                    om.getWith("structure","").toString(),
                    om.getWith("color","").toString(),
                    Integer.valueOf(om.getWith("passenger_num","0").toString()),
                    om.getWith("image_src","").toString(),
                    om.getWith("introduce","").toString(),
                    om.getWith("label","").toString(),
                    om.getWith("brand","").toString(),
                    om.getWith("type","").toString()
            ));
        }
        return new PageImpl<RtvCarEntity>(list,res.getPageable(),res.getTotalElements());
    }

    public RtvCarEntity queryCarDetail(int id){
        return rtvCarRepo.findById(id);
    }
}
