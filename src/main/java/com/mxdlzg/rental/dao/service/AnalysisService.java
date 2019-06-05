package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.*;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

@Service
public class AnalysisService {
    @Autowired
    AnalysisRepository analysisRepository;
    @Autowired
    PageAccessRepository pageAccessRepository;
    @Autowired
    AccessAnalysisRepo accessAnalysisRepo;
    @Autowired
    OrderCarInfoRepo orderCarInfoRepo;
    @Autowired
    StoresSaleRepo storesSaleRepo;
    @Autowired
    CarRepository carRepository;


    public AnalysisOverview queryOverview(){
        RtvAnalysisDaySaleEntity saleEntity = analysisRepository.findTopByDayTime();
        AnalysisOverview overview = analysisRepository.statisticTotal();
        if (saleEntity == null){
            saleEntity = new RtvAnalysisDaySaleEntity();
        }
        overview.setTodaySale(saleEntity.getDayTotal());
        overview.setTodayPaidCount(saleEntity.getDayPaidCount());
        overview.setTodayAccess(pageAccessRepository.todayCount());
        overview.setTotalAccess(pageAccessRepository.count());

        //detail
        overview.setAccessDetailList(accessAnalysisRepo.findTop14ByOrderByDate());
        overview.setPaidDetailList(analysisRepository.findTop14ByOrderByDayTime());
        return overview;
    }

    public SalesCard querySalesCard(String type, Long start, Long end) {
        //sales
        List<OptionsXY> sales = null;
        //ranking
        List<OptionsKV<Double>> storesRanking = null;
        switch (type){
            case "week":
                sales = analysisRepository.statisticDetailWeek();
                storesRanking = orderCarInfoRepo.statisticDetailRankingWeek();
                break;
            case "month":
                sales = analysisRepository.statisticDetailMonth();
                storesRanking = orderCarInfoRepo.statisticDetailRankingMonth();
                break;
            case "year":
                sales = analysisRepository.statisticDetailYear();
                storesRanking = orderCarInfoRepo.statisticDetailRankingYear();
                break;
            default:
                Timestamp timestamp = Converter.toTimestamp(start);
                Timestamp timestamp1 = Converter.toTimestamp(end);
                sales = analysisRepository.statisticDetailBetween(timestamp,timestamp1);
                storesRanking = orderCarInfoRepo.statisticDetailRankingBetween(timestamp,timestamp1);
                break;
        }
        storesRanking.sort(new Comparator<OptionsKV<Double>>() {
            @Override
            public int compare(OptionsKV<Double> o1, OptionsKV<Double> o2) {
                return o1.getValue()>o2.getValue()?1:0;
            }
        });

        return new SalesCard(sales,storesRanking);
    }

    public List<OptionsXY<Long>> querySalesType() {
        return orderCarInfoRepo.querySalesType();
    }

    public List<OptionsKV<Float>> queryStoreSale(){
        //finish/total
        List<OptionsKV<Float>> storeData = new ArrayList<>();
        List<Pair<String,Long>> totalSale = storesSaleRepo.totalSale();
        List<StoresSaleRepo.FinishedSaleResult> finishedSale = storesSaleRepo.finishedSale();
        for (int i = 0; i < totalSale.size(); i++) {
            storeData.add(new OptionsKV<Float>(totalSale.get(i).getFirst()+"("+finishedSale.get(i).getId()+")",
                    ((float) (finishedSale.get(i).getAmount()))/totalSale.get(i).getSecond()));
        }
        totalSale.clear();
        finishedSale.clear();
        return storeData;
    }

    public List<StoreSalesChartData> queryStoreSale(Long storeId) {
        List<StoresSaleRepo.FinishedSaleDetailResult> list = storesSaleRepo.storeSaleDetail(storeId);
        List<StoreSalesChartData> rsList= new ArrayList<>();
        for (StoresSaleRepo.FinishedSaleDetailResult finishedSaleDetailResult : list) {
            rsList.add(new StoreSalesChartData(finishedSaleDetailResult.getX(),finishedSaleDetailResult.getY1(),finishedSaleDetailResult.getY2()));
        }
        return rsList;
    }

    public List<RtCarEntity> queryRecommendation(int userId) {
        //comm
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8001/api/recommend";
        HttpEntity<LocalRequest> entity = new HttpEntity<>(new LocalRequest("lfm",userId));
        LocalResponse response = restTemplate.exchange(url, HttpMethod.POST,entity,LocalResponse.class).getBody();

        //check
        if (response.getData() != null && response.getData().isSuccess()){
            List<RtCarEntity> cars = carRepository.findRcmds(response.getData().getUser_id());
            return cars;
        }
        return null;
    }
}


