package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;

/**
 * @ClassName UserInfoMapper
 * @Description UserInfoMapper
 * @Author wu2we
 * @Date 2021/3/22 20:41
 * @Version 1.0
 */
@Mapper
@Repository
public interface UserInfoMapper {
    /**
     * @Date: 2021/3/23 10:32
     * @Author 索半斤
     * @Description: 向数据库中插入录入的用户信息
     * @MethodName: insert
     */
    @Insert("insert into user(username,gender,college,grade,date,feature,image_url) values(" +
            "#{username},#{gender},#{college},#{grade},#{date},#{feature},#{imageUrl})")
    int insert(UserInfo userInfo);
}
