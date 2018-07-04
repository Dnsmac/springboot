package org.qidian.controller.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.qidian.constant.ProjectType;
import org.qidian.constant.Url;
import org.qidian.constant.View;
import org.qidian.constant.ViewNameType;
import org.qidian.constant.WebConst;
import org.qidian.controller.BaseController;
import org.qidian.dao.smartkit.NavigateLinkMapper;
import org.qidian.dto.BaseDto;
import org.qidian.dto.CategoryTypeDto;
import org.qidian.dto.SeriesTypeVo;
import org.qidian.dto.Types;
import org.qidian.modal.logCenter.YwApiRuntimeDay;
import org.qidian.modal.logCenter.YwExceptionDay;
import org.qidian.modal.smartkit.NavigateLink;
import org.qidian.modal.smartkit.UserInfo;
import org.qidian.service.admin.AdminService;
import org.qidian.service.login.LoginService;
import org.qidian.service.monitor.YwApiRuntimeDayService;
import org.qidian.service.monitor.YwExceptionDayService;
import org.qidian.utils.MapCache;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController  extends BaseController {
    
    /**
     * 缓存
     */
    private MapCache cache = MapCache.single();
    
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private YwExceptionDayService ywExceptionDayService;
    
    @Autowired
    private YwApiRuntimeDayService ywApiRuntimeDayService;
    
    @Autowired
    NavigateLinkMapper navigateLinkMapper;
    /**
     * 列表
    * @author 骆峰
    * @date 2018年4月8日 下午8:42:39
    * @param id
    * @param map
    * @return
     */
    @GetMapping(value=Url.Admin.View)
    public String lookListView(HttpServletRequest request,  @PathVariable(value = "categoryUrl") String categoryUrl,  
            @PathVariable(value = "projectId") int projectId, @RequestParam(defaultValue="0") Integer sort, String msg, 
            @RequestParam(defaultValue="全部")String dataType, @RequestParam(defaultValue="1") int pageNow,
            @RequestParam(defaultValue="-1") int isDeal, @RequestParam(defaultValue="15") int pageSize, Model map){
        map.addAttribute("projectId", projectId);
        map.addAttribute("msg", msg);
        map.addAttribute("sort", sort);
        map.addAttribute("dataType", dataType);
        map.addAttribute("pageNow", pageNow);
        map.addAttribute("project",  adminService.selectByProjectId(projectId));
        map.addAttribute("isDeal", isDeal);
       
        if (categoryUrl.equals(ViewNameType.View_API.getMsg())){

            List<SeriesTypeVo> vo =  adminService.LookListView(projectId, sort, msg);
            map.addAttribute("vo", vo);
            return View.Admin.View_TYPE ;
        }else if(categoryUrl.equals(ViewNameType.View_WD.getMsg())){
            List<SeriesTypeVo> vo =  adminService.LookListDocView(projectId, msg, dataType);
            for(int i=0; i<vo.size(); i++){
            	if(vo.get(i).gettContents().size()<1){
            		vo.remove(i);
            	}
            }
            map.addAttribute("vo", vo);
            return View.Admin.View_DOC ;
        }else if(categoryUrl.equals(ViewNameType.View_GF.getMsg())){
            List<SeriesTypeVo> vo =  adminService.LookListDocView(projectId, msg, dataType);
            for(int i=0; i<vo.size(); i++){
            	if(vo.get(i).gettContents().size()<1){
            		vo.remove(i);
            	}
            }
            map.addAttribute("vo", vo);
            return View.Admin.View_MORN ;
        }else if(categoryUrl.equals(ViewNameType.View_JS.getMsg())){
            List<SeriesTypeVo> vo =  adminService.LookListTeclgView(projectId, msg, dataType);
            for(int i=0; i<vo.size(); i++){
            	if(vo.get(i).gettContents().size()<1){
            		vo.remove(i);
            	}
            }
            map.addAttribute("vo", vo);
            return View.Admin.View_TECLG ;
        }else if (categoryUrl.equals(ViewNameType.View_JK.getMsg())) {
        	int pageTotal=0;
			if (projectId == ProjectType.portTimeOut.getCode()){
				int count = ywApiRuntimeDayService.selectCount(msg,dataType);
				if(count%pageSize > 0){
					pageTotal = (count/pageSize)+1;
				}else{
					pageTotal = count/pageSize;
				}
				map.addAttribute("pageTotal",pageTotal);
				
				List<YwApiRuntimeDay> yardList = ywApiRuntimeDayService.selectSelective(msg,dataType,pageNow,pageSize);
				map.addAttribute("list", yardList);
				return View.Monitor.MONITOR_RUNTIME_DATE;
			}else if (projectId == ProjectType.ExceptionInfo.getCode()) {
				
				int count = ywExceptionDayService.selectCount(msg, dataType,isDeal);
				if(count%pageSize > 0){
					pageTotal = (count/pageSize)+1;
				}else{
					pageTotal = count/pageSize;
				}
				map.addAttribute("pageTotal", pageTotal);
				List<YwExceptionDay>yedList = ywExceptionDayService.selectSelective(msg,dataType,pageNow,pageSize,isDeal);
				map.addAttribute("list", yedList);
				return View.Monitor.MONITOR_EXCEPTION_DAY;
			}
		}else if (categoryUrl.equals(ViewNameType.View_UPDATE_PWD.getMsg())) {
			return View.Login.UPDATE_PWD_VIEW;
		}
        
        
        Object hget = cache.get(Types.CATEGORY_ID.getType());
        if(hget==null){
            cache.set(Types.CATEGORY_ID.getType(), adminService.getCategoryId(categoryUrl));
        }
        return View.Admin.View_TYPE ;
    }
    
    /**
     * API搜索
    * @author 骆峰
    * @date 2018年6月13日 下午3:35:10
    * @param request
    * @param map
    * @return
     */
    @PostMapping(value=Url.Admin.View_API_SEARCH)
    public String apiSearchType(HttpServletRequest request, Model map,  int projectId,@RequestParam(defaultValue="0")   Integer sort, String msg){
        map.addAttribute("projectId", projectId);
        map.addAttribute("sort", sort);
        map.addAttribute("msg", msg);
        map.addAttribute("project",  adminService.selectByProjectId(projectId));
        List<SeriesTypeVo> vo =  adminService.LookListView(projectId, sort, msg);
        
        List<SeriesTypeVo> collect = vo.stream().filter(f ->!f.gettContents().isEmpty()).collect(Collectors.toList());
        map.addAttribute("vo", collect);
        return sort==0? View.Admin.View_TYPE : View.Admin.View_TIME;
    }
    
    /**
     * 技术总结搜索
     * @author 骆峰
     * @date 2018年6月13日 下午3:35:10
     * @param request
     * @param map
     * @return
     */
    @PostMapping(value=Url.Admin.View_TECLG_SEARCH)
    public String teclgSearchType(HttpServletRequest request, Model map, 
            int projectId,@RequestParam(defaultValue="全部")   String dataType, String msg, Integer sort){
        map.addAttribute("projectId", projectId);
        map.addAttribute("dataType", dataType);
        map.addAttribute("msg", msg);
        map.addAttribute("sort", sort);
        map.addAttribute("project",  adminService.selectByProjectId(projectId));
        if(sort==0){
            List<SeriesTypeVo> vo =  adminService.LookListTeclgView(projectId, msg, dataType);
            List<SeriesTypeVo> collect = vo.stream().filter(f ->!f.gettContents().isEmpty()).collect(Collectors.toList());
            map.addAttribute("vo", collect);
            return View.Admin.View_TECLG ;
        }
        else{
            List<SeriesTypeVo> vo =  adminService.LookNameTeclgView(projectId, msg, dataType);
            List<SeriesTypeVo> collect = vo.stream().filter(f ->!f.gettContents().isEmpty()).collect(Collectors.toList());
            map.addAttribute("vo", collect);
            return View.Admin.View_TECLG_AUTHER ;
        }
    }
    
    
    
    /**
     * 文档搜索搜索
     * @author 骆峰
     * @date 2018年6月13日 下午3:35:10
     * @param request
     * @param map
     * @return
     */
    @PostMapping(value=Url.Admin.View_DOC_SEARCH)
    public String docSearchType(HttpServletRequest request, Model map,  int projectId,@RequestParam(defaultValue="all")   String dataType, String msg){
        map.addAttribute("projectId", projectId);
        map.addAttribute("dataType", dataType);
        map.addAttribute("msg", msg);
        map.addAttribute("project",  adminService.selectByProjectId(projectId));
        List<SeriesTypeVo> vo =  adminService.LookListDocView(projectId, msg, dataType);
        List<SeriesTypeVo> collect = vo.stream().filter(f ->!f.gettContents().isEmpty()).collect(Collectors.toList());
        map.addAttribute("vo", collect);
        return View.Admin.View_DOC ;
    }
    
    /**
     * 文档搜索搜索
     * @author 骆峰
     * @date 2018年6月13日 下午3:35:10
     * @param request
     * @param map
     * @return
     */
    @PostMapping(value=Url.Admin.View_MORN_SEARCH)
    public String mornSearchType(HttpServletRequest request, Model map,  int projectId,@RequestParam(defaultValue="all")   String dataType, String msg){
        map.addAttribute("projectId", projectId);
        map.addAttribute("dataType", dataType);
        map.addAttribute("msg", msg);
        map.addAttribute("project",  adminService.selectByProjectId(projectId));
        List<SeriesTypeVo> vo =  adminService.LookListDocView(projectId, msg, dataType);
        List<SeriesTypeVo> collect = vo.stream().filter(f ->!f.gettContents().isEmpty()).collect(Collectors.toList());
        map.addAttribute("vo", collect);
        return View.Admin.View_MORN ;
    }
    
    
    
    
    
    
//    /**
//     * 项目
//    * @author 骆峰
//    * @date 2018年4月9日 下午7:39:21
//    * @param request
//    * @param categoryId
//    * @return
//     */
//    @GetMapping(value=Url.Admin.VIEW_PROJECT)
//    public String projectView(HttpServletRequest request, @PathVariable(value = "categoryId") int categoryId){
//        Integer uid = TaleUtils.getCookieUid(request);
//        List<ProjectTitle> project = loginService.getProject(categoryId);
//        cache.hset(String.valueOf(uid), Types.CATEGORY_ID.getType(), categoryId);
//        if (project.size() != 0){
//            return "redirect:" +request.getContextPath()+"/admin/view/"+project.get(0).getProjectId();
//        }
//        cache.hdel(String.valueOf(uid), Types.PROJECT_TYPE.getType());
//        cache.hdel(String.valueOf(uid), Types.PROJECT_ID.getType());
//        return View.Admin.View_TYPE ;
//    }
//    
    
    
    /**
     * 导航页
    * @author 骆峰
    * @date 2018年4月9日 下午7:39:36
    * @return
     */
    @GetMapping(value=Url.Admin.VIEW_INDEX)
    public String indexView(HttpServletRequest request, Model model){
        List<CategoryTypeDto> categoryDto = loginService.getCategoryDto();
        Integer uid = TaleUtils.getCookieUid(request);
       UserInfo user = loginService.queryUserById(uid);
        model.addAttribute("cate", categoryDto);
        model.addAttribute("userInfo", user);
        try {
        	List<NavigateLink> linkList = navigateLinkMapper.selectForList();
        	model.addAttribute("linkList", linkList);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return View.Admin.VIEW_INDEX ;
    }
    
    @PostMapping(value=Url.Login.UPDATE_PWD)
    public BaseDto updatePwd(HttpServletRequest request, @RequestParam(defaultValue="")String newPwd,
    		@RequestParam(defaultValue="")String oldPwd){
    	UserInfo user = (UserInfo) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
    	if (user != null) {
    		return adminService.updatePwd(user,newPwd,oldPwd);
    	}else{
    		return new BaseDto(500, "修改失败，原因：session存储失效");
    	}
    	
    	
    }
}
