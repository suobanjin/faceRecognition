package zzuli.informationizationcenter.it.facerecognition.service;

import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zzuli.informationizationcenter.it.facerecognition.domain.PageBean;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.List;

/**
 * @ClassName HistoryInfoServiceTest
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/26 9:16
 * @Version 1.0
 */
@SpringBootTest
public class HistoryInfoServiceTest {
    @Autowired
    private HistoryInfoService historyInfoService;

    @Test
    public void test01(){
        PageBean<UserAndHistoryInfo> userAndHistoryInfo = historyInfoService.findUserAndHistoryInfo(1, 2, "", "", null);
        System.out.println(userAndHistoryInfo);
        //userAndHistoryInfo.forEach(System.out::println);
    }
}
