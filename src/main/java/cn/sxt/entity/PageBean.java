package cn.sxt.entity;

/**
 * Created by Administrator on 2017/4/29.
 */
public class PageBean {
    private Integer currentPage;//当前页数
    private Integer pageSize;//每页显示行数
    private Integer startNum;//从第几条数据开始
    private Integer total;//查询总条数
    private Integer totalPage;//总页数

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startNum=" + startNum +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }

    public void init() {
        this.startNum = (this.currentPage - 1) * this.pageSize;
        if (this.total != null) {
            this.totalPage = this.total % this.pageSize != 0 ? this.total / this.pageSize + 1 : this.total /
                this.pageSize;
        }
    }
}
