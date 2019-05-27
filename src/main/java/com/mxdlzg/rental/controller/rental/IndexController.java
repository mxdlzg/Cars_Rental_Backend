package com.mxdlzg.rental.controller.rental;

import com.mxdlzg.rental.dao.respository.LfmIndexCarRepo;
import com.mxdlzg.rental.dao.respository.StrategyPostRepo;
import com.mxdlzg.rental.domain.model.IndexBundle;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    LfmIndexCarRepo lfmIndexCarRepo;
    @Autowired
    StrategyPostRepo strategyPostRepo;

    @GetMapping("/api/indexList")
    public RestResult<?> indexList(@RequestHeader("Authorization") String token){
        int userId = token.equals("undefined") ? 1: JwtTokenUtils.getUserId(token);
        IndexBundle indexBundle = new IndexBundle(lfmIndexCarRepo.findByUserIdOrderByUpdateAtDesc(userId, PageRequest.of(0,5)));
        indexBundle.setStrategy(strategyPostRepo.findByOrderByUpadteAtDesc(PageRequest.of(0,4)));
        return new RestResult<>(indexBundle);
    }

    @GetMapping("/api/indexList/more")
    public RestResult<?> indexListMore(@RequestHeader("Authorization") String token,
                                       @RequestParam("page")int page,
                                       @RequestParam("from")int from){
        int userId = token.equals("undefined") ? 1: JwtTokenUtils.getUserId(token);
        IndexBundle indexBundle = new IndexBundle();
        switch (from){
            case 0:
                indexBundle.setData(lfmIndexCarRepo.findByUserIdOrderByUpdateAtDesc(userId, PageRequest.of(page,5)));
                break;
            case 1:
                indexBundle.setData(strategyPostRepo.findByOrderByUpadteAtDesc(PageRequest.of(page,4)));
                break;
            case 2:
                break;
            default:
                break;
        }

        return new RestResult<>(indexBundle);
    }
}
