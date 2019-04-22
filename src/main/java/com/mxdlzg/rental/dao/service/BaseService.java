package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable,R extends BaseRepository<T,ID>> {
    /**
     * 获取Repository
     */
    R getRepository();
    T updateOne(ID id, T entity);
    T updateOne(T entity, T db);
    <TT,TID extends Serializable> TT updateOne(BaseRepository<TT, TID> baseRepository, TID id, TT entity);
    T saveOne(T entity);
    <TT,TID extends Serializable> TT saveOne(BaseRepository<TT, TID> baseRepository, TT entity);
    T findOne(ID id);
    void deleteById(ID id);
    boolean exists(ID id);
    List<T> findAll();
    List<T> findAll(Example<T> example);
    Page<T> findAll(Pageable pageable);

    T saveOrUpdate(ID id, T t);
}
