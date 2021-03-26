package zzuli.informationizationcenter.it.facerecognition.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.img.Img;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import net.sf.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName HttpUtils
 * @Description TODO
 * @Author 哆啦是只小猫咪
 * @Date 2021/3/20 15:52
 * @Version 1.0
 */
@Configuration
public class HttpUtils {
    @Value("${featureRequestUrl}")
    private  String POST_URL;
    @Value("${tempImagePrefix}")
    private  String IMAGE_PREFIX;
    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String SERVER_FAIL = "500";
    private static final String SERVER_SUCCESS = "200";
    private static final String UTF8 = "utf-8";
    private static final String NOT_FIND_FACE = "-1";
    /**
     * @Date: 2021/3/20 15:55
     * @Author 哆啦是只小猫咪
     * @Description: 该类通过HTTP和python进行交互获取人脸信息特征值
     * @MethodName: post
     * @param imagePath 表示某张图片的路径，并且该路径应为绝对路径
     */
    public  String post(String imagePath){
        System.out.println(imagePath);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString;
        try {
            String tempImageName = IMAGE_PREFIX + "temp" + RandomUtil.randomString(6) + ".jpg";
            Img.from(FileUtil.file(imagePath))
                    .setQuality(7)//压缩比率
                    .write(FileUtil.file(tempImageName));
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(POST_URL);
            // 创建请求内容
            String encode = Base64.encode(new File(tempImageName));
            StringEntity entity = new StringEntity(encode, ContentType.TEXT_PLAIN);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), UTF8);
            if (resultString != null && resultString.length() > 1){
                JSONObject jsonObject = JSONObject.fromObject(resultString);
                String code = jsonObject.getString(CODE);
                if (code.equals(SERVER_FAIL) || resultString.equals(NOT_FIND_FACE)){
                    resultString = null;
                }else if (code.equals(SERVER_SUCCESS)){
                    resultString = jsonObject.getString(DATA);
                    if (resultString.equals(NOT_FIND_FACE))resultString = null;
                }
            }
            File file = new File(tempImageName);
            file.delete();
            return resultString;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
