package org.qidian.dao.smartkit;

import java.util.List;

import org.qidian.dto.SeriesTypeVo;
import org.qidian.modal.smartkit.YearMonthType;

public interface YearMonthMapper {
    int deleteByPrimaryKey(Integer yearMothId);

    int insert(YearMonthType record);

    int insertSelective(YearMonthType record);

    YearMonthType selectByPrimaryKey(Integer yearMothId);

    int updateByPrimaryKeySelective(YearMonthType record);

    int updateByPrimaryKey(YearMonthType record);

    YearMonthType selectByYearMonth(String yearMothchar);

    //api 月份排序
    List<SeriesTypeVo> selectByYearMod(SeriesTypeVo vo);
    //
    List<SeriesTypeVo> selectByYearModDoc(SeriesTypeVo vo);

    List<SeriesTypeVo> LookListTeclgView(SeriesTypeVo vo);
}