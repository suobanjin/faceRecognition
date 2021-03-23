package zzuli.informationizationcenter.it.facerecognition.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:03
 * @Version 1.0
 */
@ApiModel(value = "用户信息实体类")
public class UserInfo implements Serializable {
    @ApiModelProperty(value = "主键",example = "1")
    private int id;
    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank
    private String username;
    @ApiModelProperty(value = "性别")
    private int gender;
    @ApiModelProperty(value = "学院")
    @NotBlank
    private String college;
    @ApiModelProperty(value = "年级")
    @NotBlank
    private String grade;
    @ApiModelProperty(value = "录入时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    @ApiModelProperty(value = "人脸特征值")
    private String feature;
    @ApiModelProperty(value = "人脸图片url地址")
    private String imageUrl;
    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", date=" + date +
                ", feature='" + feature + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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
