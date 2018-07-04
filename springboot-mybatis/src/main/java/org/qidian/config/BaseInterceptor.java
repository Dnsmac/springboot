package org.qidian.config;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qidian.constant.WebConst;
import org.qidian.dto.Types;
import org.qidian.modal.smartkit.UserInfo;
import org.qidian.service.login.LoginService;
import org.qidian.utils.Commons;
import org.qidian.utils.IPKit;
import org.qidian.utils.MapCache;
import org.qidian.utils.TaleUtils;
import org.qidian.utils.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义拦截器
 * Created by BlueT on 2017/3/9.
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    @Autowired
    private LoginService loginService;


    /**
     * 缓存
     */
    private MapCache cache = MapCache.single();

    @Resource
    private Commons commons;

    /**
     * 
     * 前置拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        LOGGE.info("UserAgent: {}", request.getHeader(USER_AGENT));
        LOGGE.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));
        if( "/".equals(request.getRequestURI()) || "/admin/login".equals(uri) || uri.startsWith("/Editor/look")){
            return true;
        }
       
        //请求拦截处理
       UserInfo user = TaleUtils.getLoginUser(request);
       Integer uid = TaleUtils.getCookieUid(request);
        if (null == user) {
            if (null != uid) {
                //这里还是有安全隐患,cookie是可以伪造的 重新冲刷
                user = loginService.queryUserById(uid);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }else {
            TaleUtils.setCookie(response, user.getUid());
        }
        if (null == uid) {
            response.sendRedirect("/");
            return false;
        }
       // 设置get请求的token
        if (request.getMethod().equals("GET")) {
            String csrf_token = UUID.UU64();
            // 默认存储30分钟
            cache.hset(Types.CSRF_TOKEN.getType(), csrf_token, uri, 30 * 60);
            request.setAttribute("_csrf_token", csrf_token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletRequest.setAttribute("commons", commons);//一些工具类和公共方法
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
