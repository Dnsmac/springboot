package org.qidian.service.admin;

import java.time.LocalDate;

import org.qidian.constant.WebConst;
import org.qidian.dao.smartkit.TContentHistoryMapper;
import org.qidian.dao.smartkit.TContentsMapper;
import org.qidian.dao.smartkit.YearMonthMapper;
import org.qidian.dto.BaseDto;
import org.qidian.modal.smartkit.TContentHistory;
import org.qidian.modal.smartkit.TContents;
import org.qidian.modal.smartkit.YearMonthType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorService {
    
    
    @Autowired
    private TContentsMapper tContentsMapper;
    @Autowired
    private TContentHistoryMapper tContentHistoryMapper;
    @Autowired
    private YearMonthMapper yearMonthMapper;
    /**
     * 新增保存
    * @author 骆峰
    * @date 2018年4月8日 下午2:39:49
    * @param content
    * @return
     */
    public BaseDto saveEditorContent( TContents content) {
        LocalDate now = LocalDate.now();
        String data = now.toString();
        if (content.getCid() != null){
            Integer count = tContentHistoryMapper.selectByHistoryCount(content.getCid());
            content.setVersions((count+1)+"");
            content.setModified(data);
            tContentsMapper.updateByPrimaryKeySelective(content);
        }
        else{
            content.setVersions("1");
            content.setCreated(data);
            content.setYearMonthId(getYearMonthId(data.substring(0, 7)));
            tContentsMapper.insertSelective(content);
        }
        content.setCreated(data);
        tContentHistoryMapper.insertContent(content);
        return WebConst.resultSuccess();
    }

    /**
     * 查询接口信息
    * @author 骆峰
    * @date 2018年4月8日 下午5:35:49
    * @param id
    * @return
     */
    public TContents LookEditorView(int id, String versions) {
        if (null ==versions){
            return tContentsMapper.selectByPrimaryKey(id);
        } else {
            TContentHistory tHistory = new TContentHistory();
            tHistory.setCid(id);
            tHistory.setVersions(versions);
            return tContentHistoryMapper.selectByHistory(tHistory);
        }
    }

    
    public TContents editorUpdateView(int cid) {
        return tContentsMapper.selectByPrimaryKey(cid);
    }

    /**
     * 返回年月id
    * @author 骆峰
    * @date 2018年6月7日 下午4:57:03
    * @param yearMonth
    * @return
     */
    public int getYearMonthId(String ymonth){
        YearMonthType yearMonth =  yearMonthMapper.selectByYearMonth(ymonth);
        if (yearMonth ==null || yearMonth.getYearMothId() ==null){
            yearMonth = new YearMonthType();
            yearMonth.setYearMonthChar(ymonth);
            yearMonthMapper.insert(yearMonth);
        }
        return yearMonth.getYearMothId();
    }
    
}
