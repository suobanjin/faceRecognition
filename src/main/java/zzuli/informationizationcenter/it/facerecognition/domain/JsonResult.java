package zzuli.informationizationcenter.it.facerecognition.domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "统一json返回值")
public class JsonResult<T> implements Serializable {
    @ApiModelProperty(value = "提示信息")
    private String msg;
    @ApiModelProperty(value = "相应码",example = "200")
    private int code;
    @ApiModelProperty(value = "数据集合")
    private List<T> data;
    @ApiModelProperty(value = "数据数量")
    private int count;
    @ApiModelProperty(value = "分页数据pageBean")
    private T page;

    @Override
    public String toString() {
        return "JsonResult{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                '}';
    }

    public T getPage() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void ok(String message){
        setCode(1);
        setMsg(message);
    }
    public void ok(String message, List<T> data){
        setCode(1);
        setMsg(message);
        setData(data);
    }
    public void ok(List<T> data){
        setCode(1);
        setData(data);
    }
    /*public void ok(T data){
        setCode(1);
        List<T> blogList = new ArrayList<>();
        blogList.add(data);
        setData(blogList);
    }*/
    public void ok(){
        setCode(1);
    }
    public void fail(){
        setCode(2);
    }
    public void fail(String message){
        setCode(2);
        setMsg(message);
    }
}
