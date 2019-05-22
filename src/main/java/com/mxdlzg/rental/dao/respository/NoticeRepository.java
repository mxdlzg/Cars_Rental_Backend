package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtNotifyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends BaseRepository<RtNotifyEntity,Integer> {
    List<RtNotifyEntity> findAllByUserIdAndClearedOrderByDatetimeDesc(int userId,Boolean cleared);

    @Modifying
    @Query(value = "update rt_notify set cleared=true where rental.rt_notify.user_id=:id and type=:type",nativeQuery = true)
    int deleteByUserIdAndType(@Param("id") int userId,@Param("type") String type);

    @Modifying
    @Query(value = "update rt_notify set rental.rt_notify.is_read=:read where rental.rt_notify.user_id=:userId and rental.rt_notify.id=:id",nativeQuery = true)
    int updateNoticeRead(@Param("userId")int userId,@Param("id") int msgId,@Param("read") boolean read);
}
