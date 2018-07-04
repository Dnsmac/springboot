package org.qidian.service.monitor;

import java.util.List;

import org.qidian.dao.logCenter.YwExceptionDayMapper;
import org.qidian.modal.logCenter.YwExceptionDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

@Service
public class YwExceptionDayService {

	@Autowired
	YwExceptionDayMapper ywExceptionDayMapper;

	/**
	 * 查询异常信息列表
	* @Description: TODO
	* @author vito-吴晓鹏 
	* @date 2018年7月4日 上午9:48:17
	 */
	public List<YwExceptionDay> selectSelective(String msg, String dataType, int pageNow, int pageSize, int isDeal) {
		PageHelper.startPage(pageNow, pageSize);//分页，自动拦截下一次sql查询
		YwExceptionDay yed = new YwExceptionDay();
		yed.setPlatType(StringUtils.isEmpty(msg)?-1:Integer.valueOf(msg));
		if (dataType.equals("全部") || StringUtils.isEmpty(dataType)){
			yed.setLogDate(Long.valueOf(0));
		}else{
			yed.setLogDate(Long.valueOf(dataType.replaceAll("-", "")));
		}
		yed.setDealTime((long)isDeal);
		return ywExceptionDayMapper.selectSelective(yed);
	}

	public YwExceptionDay selectByPrimaryKey(int id) {
		return ywExceptionDayMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 标记为已处理
	* @Description: TODO
	* @author vito-吴晓鹏 
	* @date 2018年7月4日 上午9:47:53
	 */
	public int updateByPrimaryKeySelective(YwExceptionDay yed){
		return ywExceptionDayMapper.updateByPrimaryKeySelective(yed);
	}

	/**
	 * 查询获取总数量
	* @Description: TODO
	* @author vito-吴晓鹏 
	* @date 2018年7月4日 上午9:49:25
	 */
	public int selectCount(String msg, String dataType, int isDeal) {
		YwExceptionDay yed = new YwExceptionDay();
		yed.setPlatType(StringUtils.isEmpty(msg)?-1:Integer.valueOf(msg));
		if (dataType.equals("全部") || StringUtils.isEmpty(dataType)){
			yed.setLogDate(Long.valueOf(0));
		}else{
			yed.setLogDate(Long.valueOf(dataType.replaceAll("-", "")));
		}
		yed.setDealTime((long)isDeal);
		return ywExceptionDayMapper.selectCount(yed);
	}
}
