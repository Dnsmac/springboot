package org.qidian.service.admin;

import java.util.List;

import org.qidian.constant.WebConst;
import org.qidian.dao.smartkit.CategoryTypeMapper;
import org.qidian.dao.smartkit.ProjectTitleMapper;
import org.qidian.dao.smartkit.SeriesTypeMapper;
import org.qidian.dao.smartkit.UserInfoMapper;
import org.qidian.dao.smartkit.YearMonthMapper;
import org.qidian.dto.BaseDto;
import org.qidian.dto.SeriesTypeVo;
import org.qidian.dto.UserInfoDto;
import org.qidian.modal.smartkit.ProjectTitle;
import org.qidian.modal.smartkit.UserInfo;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    
    @Autowired
    private SeriesTypeMapper seriesTypeMapper;
    
    @Autowired
    private YearMonthMapper yearMonthMapper;
    
    @Autowired
    private CategoryTypeMapper categoryTypeMapper;
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Autowired
    private ProjectTitleMapper projectTitleMapper;
    
    
    
    /**
     * 列表
    * @author 骆峰
    * @date 2018年4月8日 下午8:58:55
    * @param projectId
    * @return
     */
    public List<SeriesTypeVo> LookListView(int projectId, Integer sort, String msg) {
        
        
        SeriesTypeVo vo = new SeriesTypeVo();
        vo.setMsg(msg);
        vo.setProjectId(projectId);
        
        if (sort ==0){
            return seriesTypeMapper.selectByprojectId(vo);
        }else{
            if (msg==null ||msg.length()==0) {
                vo.setMsg("all");
            }
            return yearMonthMapper.selectByYearMod(vo);
        }
    }
    
    /**
     * 查找系列id
    * @author 骆峰
    * @date 2018年6月14日 下午2:07:00
    * @param url
    * @return
     */
    public Integer getCategoryId(String url){
       return categoryTypeMapper.selectByUrl(url);
    }

    public List<SeriesTypeVo> LookListDocView(int projectId, String msg, String dataType) {
        SeriesTypeVo vo = new SeriesTypeVo();
        vo.setProjectId(projectId);
        vo.setMsg(msg);
        vo.setDataType(dataType);
        if (msg==null ||msg.length()==0) {
            vo.setMsg("all");
        }
        if (dataType==null ||dataType.length()==0) {
            vo.setDataType("all");
        }
        return yearMonthMapper.selectByYearModDoc(vo);
    }

    /**
     * 技术文档
    * @author 骆峰
    * @date 2018年6月19日 上午11:00:27
    * @param projectId
    * @param msg
    * @param dataType
    * @return
     */
    public List<SeriesTypeVo> LookListTeclgView(int projectId, String msg, String dataType) {
        SeriesTypeVo vo = new SeriesTypeVo();
        vo.setProjectId(projectId);
        vo.setMsg(msg);
        vo.setDataType(dataType);
        if (msg==null ||msg.length()==0) {
            vo.setMsg("all");
        }
        if (dataType==null ||dataType.length()==0) {
            vo.setDataType("全部");
        }
        return yearMonthMapper.LookListTeclgView(vo);
    }

    /**
     * 按作者
    * @author 骆峰
    * @date 2018年6月19日 下午6:45:52
    * @param projectId
    * @param msg
    * @param dataType
    * @return
     */
    public List<SeriesTypeVo> LookNameTeclgView(int projectId, String msg, String dataType) {
        UserInfoDto vo = new UserInfoDto();
        vo.setProjectId(projectId);
        vo.setMsg(msg);
        vo.setDataType(dataType);
        if (msg==null ||msg.length()==0) {
            vo.setMsg("all");
        }
        if (dataType==null ||dataType.length()==0) {
            vo.setDataType("all");
        }
        return userInfoMapper.LookNameTeclgView(vo);
    }

    public ProjectTitle selectByProjectId(int projectId) {
        return projectTitleMapper.selectByPrimaryKey(projectId);
    }

    public BaseDto updatePwd(UserInfo user, String newPwd, String oldPwd) {
		if (user.getPassWord().equals(TaleUtils.MD5encode(user.getUserName()+oldPwd))) {
			UserInfo userinfo = new UserInfo();
	    	userinfo.setPassWord(TaleUtils.MD5encode(user.getUserName()+newPwd));
			if (userInfoMapper.updateByPrimaryKeySelective(userinfo)>0) {
				return WebConst.resultSuccess();
			}
			return WebConst.resultError();
		}else{
			return new BaseDto(500, "修改失败，原因：旧密码错误");
		}
		
	}
}
