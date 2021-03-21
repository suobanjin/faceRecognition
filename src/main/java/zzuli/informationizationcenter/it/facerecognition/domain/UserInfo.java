package zzuli.informationizationcenter.it.facerecognition.domain;

import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:03
 * @Version 1.0
 */
public class UserInfo {
    private int id;
    private String username;
    private String gender;
    private String college;
    private String grade;
    private Date date;
    private String feature;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", date=" + date +
                ", feature='" + feature + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if (gender == 0)this.gender = "女";
        else if (gender == 1)this.gender = "男";
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
