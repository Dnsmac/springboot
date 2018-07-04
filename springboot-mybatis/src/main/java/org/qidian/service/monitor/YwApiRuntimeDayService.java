package org.qidian.service.monitor;

import java.util.List;

import org.qidian.dao.logCenter.YwApiRuntimeDayMapper;
import org.qidian.modal.logCenter.YwApiRuntimeDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

@Service
public class YwApiRuntimeDayService {

	@Autowired
	YwApiRuntimeDayMapper ywApiRuntimeDayMapper;

	/**
	 * 查询接口超时列表
	* @Description: TODO
	* @author vito-吴晓鹏 
	* @date 2018年7月4日 上午9:49:59
	 */
	public List<YwApiRuntimeDay> selectSelective(String msg, String dataType, int pageNow, int pageNum) {
		try {
			PageHelper.startPage(pageNow, pageNum);//分页，自动拦截下一次sql查询
			YwApiRuntimeDay yard = new YwApiRuntimeDay();
			yard.setPlatType(StringUtils.isEmpty(msg)?-1:Integer.valueOf(msg));
			if (dataType.equals("全部") || StringUtils.isEmpty(dataType)){
				yard.setLogDate(Long.valueOf(0));
			}else{
				yard.setLogDate(Long.valueOf(dataType.replaceAll("-", "")));
			}
			
			return ywApiRuntimeDayMapper.selectSelective(yard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询获取总数量
	* @Description: TODO
	* @author vito-吴晓鹏 
	* @date 2018年7月4日 上午9:49:47
	 */
	public int selectCount(String msg, String dataType) {
		YwApiRuntimeDay yard = new YwApiRuntimeDay();
		yard.setPlatType(StringUtils.isEmpty(msg)?-1:Integer.valueOf(msg));
		if (dataType.equals("全部") || StringUtils.isEmpty(dataType)){
			yard.setLogDate(Long.valueOf(0));
		}else{
			yard.setLogDate(Long.valueOf(dataType.replaceAll("-", "")));
		}
		
		return ywApiRuntimeDayMapper.selectCount(yard);
	}
}
