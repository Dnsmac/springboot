package org.qidian.dto;

import java.io.Serializable;
import java.util.List;

import org.qidian.modal.smartkit.CategoryType;
import org.qidian.modal.smartkit.ProjectTitle;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-08
 */
public class CategoryTypeDto  extends CategoryType implements Serializable {
    
    
    /** @Fields serialVersionUID : */
    private static final long serialVersionUID = 1L;
    
    private List<ProjectTitle> projectTitle;

    public List<ProjectTitle> getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(List<ProjectTitle> projectTitle) {
        this.projectTitle = projectTitle;
    }
    
    

}