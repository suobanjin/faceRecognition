package zzuli.informationizationcenter.it.facerecognition.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserAndHistoryInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/23 11:04
 * @Version 1.0
 */
public class UserAndHistoryInfo extends UserInfo implements Serializable{
    private List<HistoryInfo> historyInfos;

    @Override
    public String toString() {
        return "UserAndHistoryInfo{" +
                "historyInfos=" + historyInfos +
                '}';
    }

    public List<HistoryInfo> getHistoryInfos() {
        return historyInfos;
    }

    public void setHistoryInfos(List<HistoryInfo> historyInfos) {
        this.historyInfos = historyInfos;
    }
}
