package org.qidian.dao.smartkit;

import java.util.List;

import org.qidian.modal.smartkit.NavigateLink;

public interface NavigateLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NavigateLink record);

    int insertSelective(NavigateLink record);

    NavigateLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NavigateLink record);

    int updateByPrimaryKey(NavigateLink record);

	List<NavigateLink> selectForList();
}