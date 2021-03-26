package zzuli.informationizationcenter.it.facerecognition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;
import zzuli.informationizationcenter.it.facerecognition.mapper.UserInfoMapper;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/22 21:29
 * @Version 1.0
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
    private UserInfoMapper userInfoMapper;
    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo) >= 1;
    }

    @Override
    public List<UserInfo> findUserInfos(int pageNum, int pageSize, String grade, String username, Date date) {
        return userInfoMapper.findUserByCondition(pageNum, pageSize, grade, username, date);
    }
}
