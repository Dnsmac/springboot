package org.qidian.dao.logCenter;

import java.util.List;

import org.qidian.modal.logCenter.YwExceptionDay;

public interface YwExceptionDayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YwExceptionDay record);

    int insertSelective(YwExceptionDay record);

    YwExceptionDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YwExceptionDay record);

    int updateByPrimaryKey(YwExceptionDay record);

	List<YwExceptionDay> selectSelective(YwExceptionDay yed);

	int selectCount(YwExceptionDay yed);

	int deleteByLogDate(Long valueOf);
}