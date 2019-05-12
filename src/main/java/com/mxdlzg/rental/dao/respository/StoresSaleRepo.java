package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvStoresSalesEntity;
import com.mxdlzg.rental.utils.Pair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresSaleRepo extends BaseRepository<RtvStoresSalesEntity,Integer>{
    @Query("select new com.mxdlzg.rental.utils.Pair(r.storeName,count (r)) from RtvStoresSalesEntity r group by r.startStoreId order by r.startStoreId")
    List<Pair<String, Long>> totalSale();

    @Query(value = "select store_name,SUM(if(type_name='完成订单',1,0)) as amount from rtv_stores_sales group by start_store_id order by start_store_id",nativeQuery = true)
    List<FinishedSaleResult> finishedSale();

    public static interface FinishedSaleResult{
        String getStoreName();
        Long getAmount();
    }
}
