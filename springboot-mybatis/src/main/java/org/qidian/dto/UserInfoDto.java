package org.qidian.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-12
 */
public class UserInfoDto implements Serializable {
    private Integer uid;

    private String userName;

    private String passWord;

    private String email;

    private Integer created;

    private String groupName;

    /**
     * 真实姓名
     */
    private String name;
    
    /**
     * 内容
     */
    private List<TContentsDto> tContents;
    
    /**
     * 搜索内容
     */
    private String msg;
    /**
     * 搜索类型
     */
    private String dataType;
    
    
    /**
     * 项目
     */
    private Integer projectId;

    private static final long serialVersionUID = 1L;

    
    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<TContentsDto> gettContents() {
        return tContents;
    }

    public void settContents(List<TContentsDto> tContents) {
        this.tContents = tContents;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}