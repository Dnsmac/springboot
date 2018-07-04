package org.qidian.constant;

/**
 * project_title对相应
* @Project: smartKit-api   
* @Description: TODO
* @author vito-吴晓鹏 
* @date 2018年6月26日 下午4:18:34
* @version V3.0
 */
public enum ProjectType {

	qidianMember(9,"起点社员"),
	passport(11,"passport"),
	globalDefine(12,"全局定义"),
	projectNorm(13,"项目规范"),
	techSummarize(14,"技术总结"),
	portTimeOut(15,"接口超时"),
	ExceptionInfo(16,"异常信息"),
	woshipmAPP(18,"人人app"),
	tiantianwen(19,"天天问"),
	miapin(20,"秒聘网"),
	businesFramework(21,"业务架构"),
	techFramework(22,"技术架构"),
	database(23,"数据库"),
	accidentDiary(24,"事故日记"),
	articleShare(25,"文章分享");
	
	private ProjectType(int code, String name) {
		this.code = code;
		this.name = name;
	}
	private int code;
	private String name;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
