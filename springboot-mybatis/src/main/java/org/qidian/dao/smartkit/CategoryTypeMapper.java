package org.qidian.dao.smartkit;

import java.util.List;

import org.qidian.dto.CategoryTypeDto;
import org.qidian.modal.smartkit.CategoryType;

public interface CategoryTypeMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

    /**
     * 
    * @author 骆峰
    * @date 2018年4月9日 下午3:06:04
    * @return
     */
    List<CategoryType> selectByList();

    List<CategoryTypeDto> selectByListDto();

    /**
     * 
    * @author 骆峰
    * @date 2018年6月14日 下午2:07:20
    * @param url
    * @return
     */
    Integer selectByUrl(String url);

	CategoryType selectByprojectId(Integer projectId);
}