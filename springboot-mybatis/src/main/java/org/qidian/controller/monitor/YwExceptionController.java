package org.qidian.controller.monitor;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.qidian.constant.Url;
import org.qidian.constant.View;
import org.qidian.constant.WebConst;
import org.qidian.dto.BaseDto;
import org.qidian.exception.TipException;
import org.qidian.modal.logCenter.YwExceptionDay;
import org.qidian.modal.smartkit.UserInfo;
import org.qidian.service.monitor.YwExceptionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YwExceptionController {

	@Autowired
	YwExceptionDayService ywExceptionDayService;
	
	@GetMapping(value=Url.Monitor.MONITOR_PREVIEW)
	public String preview(@PathVariable int id, Model model){
		try {
			YwExceptionDay yed = ywExceptionDayService.selectByPrimaryKey(id);
			model.addAttribute("content", yed.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return View.Monitor.MONITOR_PREVIEW;
	}
	
	@PostMapping(value=Url.Monitor.MONITOR_DEAL)
	@ResponseBody
	public BaseDto deal(@RequestParam(defaultValue="0") int id, HttpServletRequest request, Model model){
		
		try {
			YwExceptionDay yed = new YwExceptionDay();
			yed.setId(id);
			yed.setDealTime(System.currentTimeMillis());
			UserInfo user = (UserInfo) request.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);
			yed.setProcessor(user.getName());
			ywExceptionDayService.updateByPrimaryKeySelective(yed);
		} catch (Exception e) {
			String msg = WebConst.ERROR_RESULT;
            e.printStackTrace();
            if (e instanceof TipException) {
                msg = e.getMessage();
            }
            return new BaseDto(WebConst.ERROR_CODE,  msg);
		}
		return WebConst.resultSuccess();
	}
}
