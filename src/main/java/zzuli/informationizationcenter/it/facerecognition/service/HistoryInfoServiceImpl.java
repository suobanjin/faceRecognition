package zzuli.informationizationcenter.it.facerecognition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;
import zzuli.informationizationcenter.it.facerecognition.mapper.HistoryInfoMapper;

import java.util.Date;
import java.util.List;

/**
 * @ClassName HistoryInfoServiceImpl
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 15:22
 * @Version 1.0
 */
@Service
public class HistoryInfoServiceImpl implements HistoryInfoService {
    private HistoryInfoMapper historyInfoMapper;
    @Autowired
    public void setHistoryInfoMapper(HistoryInfoMapper historyInfoMapper) {
        this.historyInfoMapper = historyInfoMapper;
    }

    @Override
    public List<UserAndHistoryInfo> findUserAndHistoryInfo(String grade, String username, Date date) {
        return historyInfoMapper.findHistoryInfo(grade, username, date);
    }
}
