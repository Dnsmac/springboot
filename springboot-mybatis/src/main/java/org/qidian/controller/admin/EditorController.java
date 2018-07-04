package org.qidian.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qidian.constant.ProjectType;
import org.qidian.constant.Url;
import org.qidian.constant.View;
import org.qidian.controller.BaseController;
import org.qidian.dao.smartkit.CategoryTypeMapper;
import org.qidian.dao.smartkit.UserInfoMapper;
import org.qidian.dto.BaseDto;
import org.qidian.modal.smartkit.CategoryType;
import org.qidian.modal.smartkit.TContents;
import org.qidian.modal.smartkit.UserInfo;
import org.qidian.service.admin.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EditorController extends BaseController {
        
    @Autowired
    private EditorService editorService;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private CategoryTypeMapper categoryTypeMapper;
    /**
     * 新增
    * @author 骆峰
    * @date 2018年4月8日 下午8:34:19
    * @param request
    * @param response
    * @return
     */
    @GetMapping(value=Url.Editor.View)
    public String editorView(HttpServletRequest request, HttpServletResponse response,
            @PathVariable(value = "seriesId") int seriesId,
            @PathVariable(value = "projectId") int projectId , Model map){
        map.addAttribute("seriesId", seriesId);
        map.addAttribute("projectId", projectId);
        CategoryType categoryType = categoryTypeMapper.selectByprojectId(projectId);
        map.addAttribute("categoryType", categoryType);
        return View.Editor.View;
    }
    
    /**
     * 修改
     * @author 骆峰
     * @date 2018年4月8日 下午8:34:19
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value=Url.Editor.UPDATE_View)
    public String editorUpdateView(HttpServletRequest request, HttpServletResponse response,
            @PathVariable(value = "cid") int cid,  Model map){
        TContents TContents = editorService.editorUpdateView(cid);
        map.addAttribute("tContents", TContents);
        CategoryType categoryType = categoryTypeMapper.selectByprojectId(TContents.getProjectId());
        map.addAttribute("categoryType", categoryType);
        return View.Editor.UPDATE_View;
    }
    
    
    /**
     * 接口新增保存
    * @author 骆峰
    * @date 2018年4月8日 下午2:40:15
    * @param request
    * @param content
    * @return
     */
    @PostMapping(value=Url.Editor.Save)
    @ResponseBody
    public BaseDto saveEditorContent(HttpServletRequest request, @RequestBody TContents content){
        Integer uid = getUid(request);
        content.setAuthorId(uid);
        return editorService.saveEditorContent(content);
    }
    
    /**
     * 预览接口
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value=Url.Editor.LookView)
    public String LookEditorView(@PathVariable(value = "id") int id, Model map) {
        TContents tContents = editorService.LookEditorView(id, null);
        map.addAttribute("tContents", tContents);
        boolean flag = false;
        if (tContents.getProjectId()!=ProjectType.qidianMember.getCode() && tContents.getProjectId()!=ProjectType.passport.getCode()&& tContents.getProjectId()!=ProjectType.miapin.getCode()&& tContents.getProjectId()!=ProjectType.passport.getCode()&& tContents.getProjectId()!=ProjectType.tiantianwen.getCode()&& tContents.getProjectId()!=ProjectType.woshipmAPP.getCode()) {
        	flag = true;
		}
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(tContents.getAuthorId());
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("flag", flag);
        return View.Editor.LookView;
    }
    
 
    
}
