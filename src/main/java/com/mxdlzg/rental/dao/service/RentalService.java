package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.BaseRepository;
import com.mxdlzg.rental.dao.respository.CarMakerRepository;
import com.mxdlzg.rental.dao.respository.CarRepository;
import com.mxdlzg.rental.dao.respository.CarStructureRepository;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import com.mxdlzg.rental.domain.entity.RtCarStructureEntity;
import com.mxdlzg.rental.domain.model.FilterParams;
import com.mxdlzg.rental.domain.model.OptionsCar;
import com.mxdlzg.rental.domain.model.OptionsKV;
import com.mxdlzg.rental.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        list.add(new OptionsKV("0-150","0-150"));
        list.add(new OptionsKV("150-300","150-300"));
        list.add(new OptionsKV("300-500","300-500"));
        list.add(new OptionsKV("500+","500+"));
    }


    /**
     * @param start start location
     * @param end end
     * @param d1 start date
     * @param d2 end date
     * @return cars
     */
    public List<RtCarEntity> findCars(int start, int end, Long d1, Long d2) {
        Timestamp startDate = Converter.toTimestamp(d1);
        int days = Converter.diffDays(d1,d2);

        return carRepository.findRtCarEntitiesAvailable(startDate,days,start);
    }
}
