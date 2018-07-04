package org.qidian.dao.smartkit;

import java.util.List;

import org.qidian.dto.SeriesTypeVo;
import org.qidian.modal.smartkit.SeriesType;

public interface SeriesTypeMapper {
    int deleteByPrimaryKey(Integer seriesId);

    int insert(SeriesType record);

    int insertSelective(SeriesType record);

    SeriesType selectByPrimaryKey(Integer seriesId);

    int updateByPrimaryKeySelective(SeriesType record);

    int updateByPrimaryKey(SeriesType record);

    List<SeriesTypeVo> selectByprojectId( SeriesTypeVo vo );

}