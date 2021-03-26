package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zzuli.informationizationcenter.it.facerecognition.domain.HistoryInfo;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName HistoryInfoMapper
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 11:24
 * @Version 1.0
 */
@SpringBootTest
public class HistoryInfoMapperTest {
    @Autowired
    private HistoryInfoMapper historyInfoMapper;
    @Test
    public void test01(){
        List<UserAndHistoryInfo> historyInfo =  historyInfoMapper.findHistoryInfo(0,1,"", "", null);
        List<UserAndHistoryInfo> collect = historyInfo.stream().distinct().collect(Collectors.toList());
        for (UserAndHistoryInfo userAndHistoryInfo : collect) {
            System.out.println(userAndHistoryInfo);
        }
    }
    @Test
    public void test02(){
        HistoryInfo oneHistoryInfoById = historyInfoMapper.findOneHistoryInfoById(2);
        System.out.println(oneHistoryInfoById);
    }

    @Test
    public void test03(){
        //historyInfoMapper.findHistoryInfo()
    }
}
