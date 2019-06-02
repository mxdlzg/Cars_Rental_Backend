package com.mxdlzg.rental.controller.management;

import com.mxdlzg.rental.dao.respository.RtvCarRepo;
import com.mxdlzg.rental.dao.respository.StoreRepository;
import com.mxdlzg.rental.dao.service.CarService;
import com.mxdlzg.rental.domain.entity.RtvCarEntity;
import com.mxdlzg.rental.domain.model.AddCarForm;
import com.mxdlzg.rental.domain.model.OrderSubmitForm;
import com.mxdlzg.rental.domain.model.OrderSubmitResult;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    RtvCarRepo rtvCarRepo;
    @Autowired
    CarService carService;
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/api/assets/storeCarList")
    public RestResult<List<RtvCarEntity>> carList(@RequestHeader("Authorization") String token,
                                                  @RequestParam("store") int storeId,
                                                  @RequestParam(value = "name", required = false,defaultValue = "") String name,
                                                  @RequestParam(value = "status", required = false,defaultValue = "") String status) {
        List<RtvCarEntity> res = null;
        if (name.equals("") && status.equals("")){
            res = rtvCarRepo.findAllByStoreId(storeId);
        }else if (!name.equals("") && status.equals("")){
            res = rtvCarRepo.findAllByStoreIdAndTypeNameLike(storeId,name);
        }else {
            res = rtvCarRepo.findAllByStoreIdAndRentAbleAndTypeNameLike(storeId,status.equals("1"),"%"+name+"%");
        }
        return new RestResult<>(res);
    }

    @PostMapping("/api/assets/addCar")
    public RestResult<?> addCar(@RequestHeader("Authorization") String token,
                                @Validated
                                @RequestBody AddCarForm form, BindingResult validatorResult) {
        if (!validatorResult.hasErrors()) {
            if (carService.addCar(form)) {
                return new RestResult<>(true, ResponseEnums.INSERT_SUCCESS);
            }
        }
        return new RestResult<>(false, ResponseEnums.PARAMS_ERROR);
    }

    @DeleteMapping("/api/assets/removeCar")
    public RestResult<?> removeCar(@RequestHeader("Authorization") String token,
                                   @RequestParam("carId") int id) {
        int userId = JwtTokenUtils.getUserId(token);
        int res = carService.removeCar(userId, id, false);
        if (res > 0) {
            return new RestResult<>("删除成功");
        }
        return new RestResult<>(false, ResponseEnums.INVALID_USER);
    }

    @PutMapping("/api/assets/removeCars")
    public RestResult<?> removeCar(@RequestHeader("Authorization") String token,
                                   @RequestParam("ids") String s_id,
                                   @RequestParam("op") String op) {
        String[] ids = s_id.split(",");
        int userId = JwtTokenUtils.getUserId(token);
        if (carService.removeCars(userId, ids, op)) {
            return new RestResult<>("操作成功");
        }
        return new RestResult<>(false, ResponseEnums.INVALID_USER);
    }

    @GetMapping("/api/assets/storeRanking")
    public RestResult<?> storeRanking(@RequestHeader("Authorization") String token,
                                      @RequestParam("storeId")int id){
        List<Long> data = storeRepository.fetchRanking(id);
        return new RestResult<>(data);
    }

}
