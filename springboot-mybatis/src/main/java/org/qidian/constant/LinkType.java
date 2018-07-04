package org.qidian.constant;

/**
 * navigate_link表中type字段
* @Project: smartKit-api   
* @Description: TODO
* @author vito-吴晓鹏 
* @date 2018年7月4日 下午12:00:41
* @version V3.0
 */
public enum LinkType {

	noDivide(0);//暂时默认不分类
	
	private int code;

	private LinkType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
