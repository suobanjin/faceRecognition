package zzuli.informationizationcenter.it.facerecognition.service;

import zzuli.informationizationcenter.it.facerecognition.domain.PageBean;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.Date;

/**
 * @ClassName HistoryInfoService
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 15:20
 * @Version 1.0
 */
public interface HistoryInfoService {
    PageBean<UserAndHistoryInfo> findUserAndHistoryInfo(int pageNum, int pageSize, String grade, String username, Date date);
}
