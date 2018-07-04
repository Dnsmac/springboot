package org.qidian.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.qidian.dao.logCenter.YwExceptionDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class ClearJobs {

	@Autowired
	private YwExceptionDayMapper ywExceptionDayMapper;
	
	@Scheduled(cron = "0 30 1 * * ?")
	public void earserJob(){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String logDate = sdf.format(calendar.getTime());
        ywExceptionDayMapper.deleteByLogDate(Long.valueOf(logDate));
	}
	public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String logDate = sdf.format(calendar.getTime());
        System.out.println(logDate);
	}
}
