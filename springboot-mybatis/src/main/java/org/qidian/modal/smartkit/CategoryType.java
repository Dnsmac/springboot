package org.qidian.modal.smartkit;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-08
 */
public class CategoryType implements Serializable {
    private Integer categoryId;

    /**
     * 名称
     */
    private String categoryName;
    /**
     * 图片
     */
    private String categoryImg;
    /**
     * Url
     */
    private String categoryUrl;

    private static final long serialVersionUID = 1L;
    
    
    

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}