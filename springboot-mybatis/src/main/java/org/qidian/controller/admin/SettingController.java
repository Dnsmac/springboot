package org.qidian.controller.admin;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qidian.constant.Url;
import org.qidian.constant.WebConst;
import org.qidian.controller.BaseController;
import org.qidian.dto.BaseDto;
import org.qidian.dto.Types;
import org.qidian.modal.smartkit.CategoryType;
import org.qidian.modal.smartkit.SeriesType;
import org.qidian.service.admin.SettingService;
import org.qidian.utils.MapCache;
import org.qidian.utils.QiniuUploadUtils;
import org.qidian.utils.QinniuKongjian;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 
   * 设置项 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午6:43:57
 */
@Controller
public class SettingController extends BaseController {

    /**
     * 缓存
     */
    private MapCache cache = MapCache.single();

    /**
     * 设置模块
     */
    @Autowired
    private SettingService settingService;

    /**
     * 设置接口类型
    * @author 骆峰
    * @date 2018年4月9日 下午8:39:28
    * @param request
    * @param response
    * @param name
    * @return
     */
    @PostMapping(value = Url.Setting.SETTING_SERIES_SAVE)
    @ResponseBody
    public BaseDto saveSeriesSetting(HttpServletRequest request, HttpServletResponse response, @RequestBody SeriesType seriesType) {
        settingService.saveSeriesSetting(seriesType);
        return WebConst.resultSuccess();
    }

    /**
     *  设置接口模块
    * @author 骆峰
    * @date 2018年4月9日 下午8:39:48
    * @param request
    * @param response
    * @param name
    * @return
     */
    @PostMapping(value = Url.Setting.SETTING_PROJECTTITLE_SAVE)
    @ResponseBody
    public BaseDto saveProjectSetting(HttpServletRequest request, HttpServletResponse response, String name) {
        Integer uid = TaleUtils.getCookieUid(request);
        Integer categoryId = cache.hget(String.valueOf(uid), Types.CATEGORY_ID.getType());
        settingService.saveProjectSetting(name, categoryId);
        return WebConst.resultSuccess();
    }

    /**
     * 
    * @author 骆峰
    * @date 2018年6月14日 下午3:10:38
    * @param request
    * @param response
    * @param category
    * @return
     */
    @PostMapping(value = Url.Setting.SETTING_CATEGORY_SAVE)
    @ResponseBody
    public BaseDto saveCategorySetting(HttpServletRequest request, HttpServletResponse response, @RequestBody CategoryType category) {
        settingService.saveCategorySetting(category);
        Integer uid = TaleUtils.getCookieUid(request);
        cache.hdel(String.valueOf(uid), Types.TITLE_TYPE.getType());
        return WebConst.resultSuccess();
    }

    /**
     * 上传图片
    * @author 骆峰
    * @date 2018年7月4日 下午4:41:30
    * @param file
    * @param request
    * @param response
    * @return
    * @throws Exception
     */
    @PostMapping(value = Url.Setting.SETTING_UPLOAD_FILE)
    @ResponseBody
    public JSONObject editormdPic(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String trueFileName = file.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "_"+trueFileName;
        String path = request.getSession().getServletContext().getRealPath("/static/admin/images/temporary/");
        File targetFile = new File(path, fileName);  
        try {  
           file.transferTo(targetFile);  
        } catch (Exception e) {  
           e.printStackTrace();  
        }  
        JSONObject res = new JSONObject();
        res.put("success", 0);
        if (QiniuUploadUtils.upload(path+fileName, fileName, QinniuKongjian.qidianVip)) {
         
            res.put("url", "http://img.qidianla.com/" + fileName);
            res.put("success", 1);
        }
        res.put("message", "upload success!");
        return res;
    }
}
