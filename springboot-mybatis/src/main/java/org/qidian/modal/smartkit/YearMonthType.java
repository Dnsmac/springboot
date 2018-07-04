package org.qidian.modal.smartkit;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-07
 */
public class YearMonthType implements Serializable {
    private Integer yearMothId;

    /**
     * 年月
     */
    private String yearMonthChar;

    private static final long serialVersionUID = 1L;

    public Integer getYearMothId() {
        return yearMothId;
    }

    public void setYearMothId(Integer yearMothId) {
        this.yearMothId = yearMothId;
    }

    public String getYearMonthChar() {
        return yearMonthChar;
    }

    public void setYearMonthChar(String yearMonthChar) {
        this.yearMonthChar = yearMonthChar;
    }

}