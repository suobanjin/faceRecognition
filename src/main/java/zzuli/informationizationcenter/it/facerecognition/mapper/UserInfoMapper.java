package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import zzuli.informationizationcenter.it.facerecognition.domain.UserInfo;

import java.util.Date;
import java.util.List;

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

    @SelectProvider(value = SelectUserInfoProvider.class,method = "selectUserInfo")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "college",column = "college"),
            @Result(property = "date",column = "date"),
            @Result(property = "feature",column = "feature"),
            @Result(property = "imageUrl",column = "image_url")
    })
    List<UserInfo> findUserByCondition(int pageNum, int pageSize, String grade, String username, Date date);
}
