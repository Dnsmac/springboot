package org.qidian.dao.logCenter;

import org.qidian.modal.logCenter.ActiveUser;

public interface ActiveUserMapper {
    int insert(ActiveUser record);

    int insertSelective(ActiveUser record);
}