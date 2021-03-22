package zzuli.informationizationcenter.it.facerecognition.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AdminInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:07
 * @Version 1.0
 */
@ApiModel(value = "管理员操作")
public class AdminInfo {
    @ApiModelProperty(value = "id主键",example = "1")
    private int id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;

    @Override
    public String toString() {
        return "AdminInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
