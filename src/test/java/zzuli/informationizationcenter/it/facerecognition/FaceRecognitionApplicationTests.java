package zzuli.informationizationcenter.it.facerecognition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zzuli.informationizationcenter.it.facerecognition.utils.HttpUtils;

@SpringBootTest
class FaceRecognitionApplicationTests {
    @Autowired
    private HttpUtils httpUtils;

    @Test
    void contextLoads() {
        httpUtils.post("122");
    }

}
