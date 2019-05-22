package com.mxdlzg.rental.controller.notice;

import com.mxdlzg.rental.dao.service.NoticeService;
import com.mxdlzg.rental.domain.entity.RtNotifyEntity;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("/api/notices")
    public RestResult<List<RtNotifyEntity>> notices(@RequestHeader("Authorization") String token) {
        int userId = JwtTokenUtils.getUserId(token);
        return new RestResult<>(noticeService.queryNotices(userId));
    }

    @DeleteMapping("/api/clearNotices")
    public RestResult<?> clearNotices(@RequestHeader("Authorization") String token,
                                      @RequestParam("type") String type) {
        int userId = JwtTokenUtils.getUserId(token);
        return new RestResult<>(noticeService.clearNotices(userId, type));
    }

    @PutMapping("/api/changeNoticeRead")
    public RestResult<?> changeNoticeRead(@RequestHeader("Authorization") String token,
                                          @RequestParam("id") int msgId,
                                          @RequestParam("read") boolean read) {
        int userId = JwtTokenUtils.getUserId(token);
        return new RestResult<>(noticeService.changeNoticeRead(userId, msgId,read));
    }
}
