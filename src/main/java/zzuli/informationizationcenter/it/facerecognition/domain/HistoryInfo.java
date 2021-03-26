package zzuli.informationizationcenter.it.facerecognition.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName HistoryInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 10:59
 * @Version 1.0
 */
public class HistoryInfo implements Serializable {
    private int historyId;      //主键id，自增
    private Date historyDate;   //用户出入时间
    private int type;    // 用户出入类型
    private int userId;  //外键，用户id

    @Override
    public String toString() {
        return "HistoryInfo{" +
                "id=" + historyId +
                ", date=" + historyDate +
                ", type=" + type +
                '}';
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Date getDate() {
        return historyDate;
    }

    public void setDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
