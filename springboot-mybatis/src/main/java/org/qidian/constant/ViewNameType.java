package org.qidian.constant;

public enum ViewNameType {

    View_API(1, "api"),
    View_WD(2, "document"),
    View_GF(3, "morn"),
    View_JS(4, "technical"),
    View_JK(5, "monitor"),
	View_UPDATE_PWD(6,"updatePwd");
    
    ViewNameType(Integer c, String m){
        this.msg=m;
        this.code=c;
    }

    
    private String msg;
    
    private Integer code;
    
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    
    
    
}
