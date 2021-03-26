package zzuli.informationizationcenter.it.facerecognition.service;

import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserInfoService
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/22 20:40
 * @Version 1.0
 */
public interface UserInfoService {
    boolean insert(UserInfo userInfo);
    List<UserInfo> findUserInfos(int pageNum,int pageSize,String grade, String username, Date date);
}
