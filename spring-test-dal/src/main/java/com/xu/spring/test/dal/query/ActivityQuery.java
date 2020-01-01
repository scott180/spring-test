package com.xu.spring.test.dal.query;

import lombok.Data;

import java.util.List;

/**
 * @author xu
 * @date 2020/1/1 18:50
 */
@Data
public class ActivityQuery extends BaseQuery {
    /**
     * 开始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 是否删除
     */
    private Integer del;

    /**
     * 是否取消
     */
    private String cancel;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户id列表
     */
    private List<Long> idList;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
