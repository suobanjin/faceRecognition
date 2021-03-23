package zzuli.informationizationcenter.it.facerecognition.mapper;

import org.springframework.util.StringUtils;
import zzuli.informationizationcenter.it.facerecognition.domain.UserAndHistoryInfo;

import java.util.Date;

/**
 * @ClassName SelectHistoryInfoProvider
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 11:12
 * @Version 1.0
 */
public class SelectHistoryInfoProvider {
    public String findHistoryInfo(String grade, String username, Date date) {
        StringBuilder sql = new StringBuilder("select DISTINCT * from user u left join historyinfo h on u.id = h.user_id where 1=1  ");
        if (StringUtils.hasLength(grade)){
            sql.append("and u.grade = ").append(grade).append(" ");
        }
        if (StringUtils.hasLength(username)){
            sql.append("and u.username = ").append(username).append(" ");
        }
        if (date != null){
            sql.append("and h.history_date = ").append(date);
        }
        return sql.toString();
    }
}
