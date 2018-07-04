package org.qidian.modal.logCenter;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-21
 */
public class YwApiRuntimeDay implements Serializable {
    /**
     * 日志时间
     */
    private Long logDate;

    /**
     * 异常接口
     */
    private String url;

    /**
     * 异常次数
     */
    private Integer count;

    /**
     * 最长反应时间（异常时）
     */
    private Integer maxUseTime;

    /**
     * 平均反应时间（异常时）
     */
    private Integer aveUseTime;

    /**
     * 平台类型（0passport;1人人;2问答;3活动;4起点;5秒聘）
     */
    private Integer platType;

    private static final long serialVersionUID = 1L;

    public Long getLogDate() {
        return logDate;
    }

    public void setLogDate(Long logDate) {
        this.logDate = logDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxUseTime() {
        return maxUseTime;
    }

    public void setMaxUseTime(Integer maxUseTime) {
        this.maxUseTime = maxUseTime;
    }

    public Integer getAveUseTime() {
        return aveUseTime;
    }

    public void setAveUseTime(Integer aveUseTime) {
        this.aveUseTime = aveUseTime;
    }

    public Integer getPlatType() {
        return platType;
    }

    public void setPlatType(Integer platType) {
        this.platType = platType;
    }
}