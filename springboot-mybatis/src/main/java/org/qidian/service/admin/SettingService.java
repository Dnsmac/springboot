package org.qidian.service.admin;

import org.qidian.dao.smartkit.CategoryTypeMapper;
import org.qidian.dao.smartkit.ProjectTitleMapper;
import org.qidian.dao.smartkit.SeriesTypeMapper;
import org.qidian.modal.smartkit.CategoryType;
import org.qidian.modal.smartkit.ProjectTitle;
import org.qidian.modal.smartkit.SeriesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
   * 设置模块
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午7:09:16
 */
@Component
public class SettingService {

    
    @Autowired
    private SeriesTypeMapper seriesTypeMapper;
    
    @Autowired
    private ProjectTitleMapper projectTitleMapper;
    @Autowired
    private CategoryTypeMapper categoryTypeMapper;
    
    /**
     * 新增接口类型
    * @author 骆峰
    * @date 2018年6月14日 下午3:15:29
    * @param name
    * @param projectId
     */
    public void saveSeriesSetting(SeriesType record) {
        seriesTypeMapper.insertSelective(record);
    }


    public void saveProjectSetting(String name, Integer categoryId) {
        ProjectTitle project = new ProjectTitle();
        project.setCategoryId(categoryId);
        project.setProjectName(name);
        projectTitleMapper.insert(project);
    }


    public void saveCategorySetting(CategoryType category) {
        categoryTypeMapper.insertSelective(category);
    }

    

}
