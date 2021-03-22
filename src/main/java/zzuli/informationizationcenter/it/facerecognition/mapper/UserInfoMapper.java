package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;

/**
 * @ClassName UserInfoMapper
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/22 20:41
 * @Version 1.0
 */
@Mapper
@Repository
public interface UserInfoMapper {
    @Insert("insert into user(username,gender,college,grade,date,feature) values(" +
            "#{username},#{gender},#{date},#{feature})")
    int insert(UserInfo userInfo);
}
