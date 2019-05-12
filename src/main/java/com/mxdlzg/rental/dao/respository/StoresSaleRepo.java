package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvStoresSalesEntity;
import com.mxdlzg.rental.domain.model.StoreSalesChartData;
import com.mxdlzg.rental.utils.Pair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StoresSaleRepo extends BaseRepository<RtvStoresSalesEntity,Integer>{
    @Query("select new com.mxdlzg.rental.utils.Pair(r.storeName,count (r)) from RtvStoresSalesEntity r group by r.startStoreId order by r.startStoreId")
    List<Pair<String, Long>> totalSale();

    @Query(value = "select start_store_id as id,store_name as name,SUM(if(type_name='完成订单',1,0)) as amount from rtv_stores_sales group by start_store_id order by start_store_id",nativeQuery = true)
    List<FinishedSaleResult> finishedSale();
    public static interface FinishedSaleResult{
        String getName();
        Long getAmount();
        Long getId();
    }

    @Query(value = "select UNIX_TIMESTAMP(created_date)*1000 as x," +
            "COUNT(order_id) as y1, " +
            "SUM(if(type_name='完成订单',1,0)) as y2 " +
            "from rtv_stores_sales " +
            "where start_store_id=?1 and created_date>=MONTH(NOW()) " +
            "group by created_date ",nativeQuery = true)
    List<FinishedSaleDetailResult> storeSaleDetail(Long id);
    public static interface FinishedSaleDetailResult{
        Long getX();
        Long getY1();
        Long getY2();
    }


}
