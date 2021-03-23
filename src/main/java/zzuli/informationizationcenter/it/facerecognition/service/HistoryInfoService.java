package zzuli.informationizationcenter.it.facerecognition.service;

import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.Date;
import java.util.List;

/**
 * @ClassName HistroyInfoService
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 15:20
 * @Version 1.0
 */
public interface HistoryInfoService {
    List<UserAndHistoryInfo> findUserAndHistoryInfo(String grade, String username, Date date);
}
