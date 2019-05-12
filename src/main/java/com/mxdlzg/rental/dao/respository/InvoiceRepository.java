package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtInvoiceEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<RtInvoiceEntity,Integer> {
}
