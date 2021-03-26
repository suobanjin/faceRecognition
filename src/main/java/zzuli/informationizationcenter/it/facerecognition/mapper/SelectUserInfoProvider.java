package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @ClassName SelectUserInfoProvider
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 14:46
 * @Version 1.0
 */
public class SelectUserInfoProvider {
    public String selectUserInfo(int pageNum,int pageSize,String grade, String username, Date date){
        StringBuilder sql = new StringBuilder("select  * from user  where 1=1  ");
        if (StringUtils.hasLength(grade)){
            sql.append("and grade = ").append(grade).append(" ");
        }
        if (StringUtils.hasLength(username)){
            sql.append("and username = ").append(username).append(" ");
        }
        if (date != null){
            sql.append("and date = ").append(date).append(" ");
        }
        sql.append("limit").append(" ").append((pageSize-1)*pageNum).append(",").append(pageSize);
        return sql.toString();
    }

    public String selectCountUserInfo(int pageNum,int pageSize,String grade,String username,Date date){
        StringBuilder sql = new StringBuilder("select  count(*) from user  where 1=1  ");
        if (StringUtils.hasLength(grade)){
            sql.append("and grade = ").append(grade).append(" ");
        }
        if (StringUtils.hasLength(username)){
            sql.append("and username = ").append(username).append(" ");
        }
        if (date != null){
            sql.append("and date = ").append(date).append(" ");
        }
        sql.append("limit").append(" ").append((pageSize-1)*pageNum).append(",").append(pageSize);
        return sql.toString();
    }
}
