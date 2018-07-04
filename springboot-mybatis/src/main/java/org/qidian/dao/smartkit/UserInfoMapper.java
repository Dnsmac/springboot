package org.qidian.dao.smartkit;

import java.util.List;

import org.qidian.dto.SeriesTypeVo;
import org.qidian.dto.UserInfoDto;
import org.qidian.modal.smartkit.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    int countByName(UserInfo userInfoVo);

    List<UserInfo> selectByUserInfo(UserInfo userInfoVo);

    List<SeriesTypeVo> LookNameTeclgView(UserInfoDto vo);

    List<UserInfo> selectByall();
}