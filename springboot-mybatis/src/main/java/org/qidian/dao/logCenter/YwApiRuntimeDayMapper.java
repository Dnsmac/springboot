package org.qidian.dao.logCenter;

import java.util.List;

import org.qidian.modal.logCenter.YwApiRuntimeDay;

public interface YwApiRuntimeDayMapper {
    int insert(YwApiRuntimeDay record);

    int insertSelective(YwApiRuntimeDay record);

    /**
     * 
    * @Description: TODO
    * @author vito-吴晓鹏 
    * @date 2018年6月21日 下午8:39:16
     */
	List<YwApiRuntimeDay> selectSelective(YwApiRuntimeDay yard);

	int selectCount(YwApiRuntimeDay yard);
}