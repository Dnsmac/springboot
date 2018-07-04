package org.qidian.dto;

import java.io.Serializable;

import org.qidian.modal.smartkit.TContents;
import org.qidian.modal.smartkit.UserInfo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-08
 */
public class TContentsDto extends  TContents implements Serializable {

    /** @Fields serialVersionUID : */
    private static final long serialVersionUID = 1L;
    
    
    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        return userInfo;
    }


    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    
    

}