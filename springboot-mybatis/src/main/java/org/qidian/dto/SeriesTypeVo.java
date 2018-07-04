package org.qidian.dto;

import java.io.Serializable;
import java.util.List;

public class SeriesTypeVo  implements Serializable{

    /** @Fields serialVersionUID : */
    private static final long serialVersionUID = 1L;
    
    private Integer seriesId;

    /**
     * 项目
     */
    private Integer projectId;
    /**
     * 项目
     */
    private Integer uid;
    /**
     * 项目
     */
    private Integer yearMothId;

    /**
     * 名称
     */
    private String name;
    /**
     * 年月
     */
    private String yearMonthChar;
    /**
     * 搜索内容
     */
    private String msg;
    /**
     * 搜索类型
     */
    private String dataType;
    /**
     * 接口类型图片
     */
    private String seriesImg;
    
    /**
     * 内容
     */
    private List<TContentsDto> tContents;
    /**
     * 接口类型图片
     */
    private String userName;
    
    
    
    
    
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getSeriesImg() {
        return seriesImg;
    }

    public void setSeriesImg(String seriesImg) {
        this.seriesImg = seriesImg;
    }

    public Integer getYearMothId() {
        return yearMothId;
    }

    public void setYearMothId(Integer yearMothId) {
        this.yearMothId = yearMothId;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getYearMonthChar() {
        return yearMonthChar;
    }

    public void setYearMonthChar(String yearMonthChar) {
        this.yearMonthChar = yearMonthChar;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TContentsDto> gettContents() {
        return tContents;
    }

    public void settContents(List<TContentsDto> tContents) {
        this.tContents = tContents;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    

}
