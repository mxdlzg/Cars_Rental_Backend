package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCustomerEntity;
import com.mxdlzg.rental.domain.entity.RtOrderCustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<RtCustomerEntity, Integer> {
    boolean existsByCardId(String id);

    RtCustomerEntity findByCardId(String id);


    @Query("select new RtCustomerEntity(customer.name,customer.cardId,customer.mobile,customer.email) from RtCustomerEntity customer,RtOrderCustomerEntity orderCustomer " +
            "where customer.id=orderCustomer.customerId and orderCustomer.orderId=:orderId")
    List<RtCustomerEntity> findAllByOrderId(@Param("orderId") int orderId);
}
