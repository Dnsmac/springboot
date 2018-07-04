package org.qidian.constant;

public interface View {

    /**
     * 
        *  登录 首页模板
       * @author 骆峰
       * @date 2018年3月28日 下午3:02:46
     */
     class Login{
         /** 首页 */
         public static final String LOGIN_VIEW = "admin/login";
         /** 修改密码*/
         public static final String UPDATE_PWD_VIEW = "admin/updatePwd";
    }
     
     /**
      * 内容详情
        * 
        * @Project: smartKit-api   
        * @Description: TODO
        * @author 骆峰
        * @date 2018年4月8日 上午11:44:22
      */
     class Editor{
         public static final String View = "admin/add";//11
         
         public static final String UPDATE_View = "admin/update";//11
         
         public static final String LookView = "admin/interfaceDetail";//
     }

     class Admin {
         
         public static final String View_TYPE = "admin/api-type";//1
         public static final String View_TIME = "admin/api-time";//2
         public static final String View_DOC = "admin/doc";//2
         public static final String View_MORN = "admin/morn";//2
         public static final String View_TECLG = "admin/teclg";//2
         public static final String View_TECLG_AUTHER = "admin/teclg_auther";//2
         
         
         public static final String VIEW_INDEX = "admin/index";
         
         public static final String LookView = "admin/showEdit";
     }
     
     //监控
     class Monitor{
    	 
    	 public static final String MONITOR_EXCEPTION_DAY = "monitor/exception-day";
         public static final String MONITOR_RUNTIME_DATE = "monitor/runtime-day";
    	 public static final String MONITOR_PREVIEW = "monitor/preview";
     }
}
