package org.qidian.dao.smartkit;

import org.qidian.modal.smartkit.TContents;

public interface TContentsMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TContents record);

    int insertSelective(TContents record);

    TContents selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TContents record);

    int updateByPrimaryKey(TContents record);

}