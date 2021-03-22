package zzuli.informationizationcenter.it.facerecognition.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:03
 * @Version 1.0
 */
@ApiModel(value = "用户信息实体类")
public class UserInfo {
    @ApiModelProperty(value = "主键",example = "1")
    private int id;
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "学院")
    private String college;
    @ApiModelProperty(value = "年级")
    private String grade;
    @ApiModelProperty(value = "录入时间")
    private Date date;
    @ApiModelProperty(value = "人脸特征值")
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
