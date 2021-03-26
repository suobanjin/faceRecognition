package zzuli.informationizationcenter.it.facerecognition.domain;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PageBean
 * @Description TODO
 * @Author 索半斤
 * @Date 2021/3/26 9:52
 * @Version 1.0
 */
public class PageBean<T> {
    private int thisPage;  //当前页的页码
    private int totalRecords;  //总的记录数（通过从数据库中查询得到）
    private int everyPage;     //每个页面显示的记录数（自己定义）
    private int previousPage;  //上一页的页码
    private int nextPage;      //下一页的页码
    private List<T> records;   //查询到的实体类的集合
    private int totalPage;     //总的页数（只有get方法，没有set方法，通过计算得到）

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getTotalPage() {
        //总页数=总的记录数/每页显示的记录数，如果可以整除就直接返回，否则就加一后返回
        totalPage=totalRecords/everyPage;
        return totalRecords%everyPage==0 ? totalPage:totalPage+1;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "thisPage=" + thisPage +
                ", totalRecords=" + totalRecords +
                ", everyPage=" + everyPage +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                ", records=" + Arrays.toString(records.toArray()) +
                ", totalPage=" + getTotalPage() +
                '}';
    }
}
