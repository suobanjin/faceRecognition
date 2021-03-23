package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import zzuli.informationizationcenter.it.facerecognition.domain.HistoryInfo;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.Date;
import java.util.List;

/**
 * @ClassName HistoryInfoMapper
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 11:03
 * @Version 1.0
 */
@Repository
@Mapper
public interface HistoryInfoMapper {

    @Select("select * from historyinfo where history_id = #{id}")
    @Results({
            @Result(id = true, property = "historyId", column = "history_id"),
            @Result(property = "historyDate",column = "history_date"),
            @Result(property = "type",column = "type")
    })
    HistoryInfo findOneHistoryInfoById(int id);

    @Select("select * from historyinfo where user_id = #{id}")
    @Results({
            @Result(id = true, property = "historyId", column = "history_id"),
            @Result(property = "historyDate",column = "history_date"),
            @Result(property = "type",column = "type")
    })
    List<HistoryInfo> findManyHistoryInfoById(int id);

    //@SelectProvider(value = SelectHistoryInfoProvider.class,method = "findHistoryInfo")
    @SelectProvider(value = SelectUserInfoProvider.class,method = "selectUserInfo")
    @Results({
            @Result(id = true, property = "id", column = "id"),
           /* @Result(id = true, property = "historyId", column = "history_id"),
            @Result(property = "historyDate",column = "history_date"),
            @Result(property = "type",column = "type"),*/
            @Result(property = "username",column = "username"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "college",column = "college"),
            @Result(property = "date",column = "date"),
            @Result(property = "feature",column = "feature"),
            @Result(property = "imageUrl",column = "image_url"),
            @Result(property = "historyInfos",column = "id",
            many = @Many(select = "zzuli.informationizationcenter.it.facerecognition.mapper.HistoryInfoMapper.findManyHistoryInfoById"))
    })
    List<UserAndHistoryInfo> findHistoryInfo(String grade, String username, Date date);
}
