package zzuli.informationizationcenter.it.facerecognition.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateConverter
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/22 22:04
 * @Version 1.0
 */
@Configuration
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        //实现将字符串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //如果参数绑定失败返回null
        return null;
    }

}

