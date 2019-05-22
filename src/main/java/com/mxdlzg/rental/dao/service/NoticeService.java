package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.NoticeRepository;
import com.mxdlzg.rental.domain.entity.RtNotifyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeRepository noticeRepository;

    public List<RtNotifyEntity> queryNotices(int userId){
        return noticeRepository.findAllByUserIdAndClearedOrderByDatetimeDesc(userId,false);
    }

    @Transactional
    public Boolean clearNotices(int userId, String type) {
        int res = noticeRepository.deleteByUserIdAndType(userId,type);
        return res != 0;
    }

    @Transactional
    public Boolean changeNoticeRead(int userId, int msgId, boolean read) {
        return noticeRepository.updateNoticeRead(userId,msgId,read) != 0;
    }
}
