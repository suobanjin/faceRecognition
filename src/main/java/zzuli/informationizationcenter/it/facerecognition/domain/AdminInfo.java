package zzuli.informationizationcenter.it.facerecognition.domain;

/**
 * @ClassName AdminInfo
 * @Description TODO
 * @Author wu2we
 * @Date 2021/3/21 21:07
 * @Version 1.0
 */
public class AdminInfo {
    private int id;
    private String username;
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
