package zzuli.informationizationcenter.it.facerecognition.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName HttpUtilsTest
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 20:42
 * @Version 1.0
 */
@SpringBootTest
public class HttpUtilsTest {
    @Autowired
    private HttpUtils httpUtils;
    @Test
    public void fun01(){
        String post = httpUtils.post("C:\\Users\\wu2we\\Pictures\\Camera Roll\\WIN_20210320_20_54_07_Pro.jpg");
        System.out.println(post);
    }
}
