package org.qidian.modal.logCenter;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-21
 */
public class ActiveUser implements Serializable {
    /**
     * 日志时间
     */
    private Integer logDate;

    /**
     * uid
     */
    private Integer uid;

    /**
     * 用户UID对应的访问量
     */
    private Integer pv;

    /**
     * 平台类型，对应的passport的PlatTypeEnum类
     */
    private Integer platType;

    /**
     * 客户端类型，对应UserCenter的ClientTypeEnum类
     */
    private Integer clientType;

    private static final long serialVersionUID = 1L;

    public Integer getLogDate() {
        return logDate;
    }

    public void setLogDate(Integer logDate) {
        this.logDate = logDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getPlatType() {
        return platType;
    }

    public void setPlatType(Integer platType) {
        this.platType = platType;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }
}