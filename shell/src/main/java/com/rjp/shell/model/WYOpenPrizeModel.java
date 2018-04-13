package com.rjp.shell.model;

/**
 * author : Gimpo create on 2018/4/12 18:13
 * email  : jimbo922@163.com
 */

public class WYOpenPrizeModel {
    /**
     * awardNo : 01 23 25 31 33:01 12
     * awardTime : 2018-04-11 20:35:00
     * extra :
     * gameEn : dlt
     * luckyBlue :
     * periodName : 18041
     * totalPool : 5445163138.00
     * totalSale : 253422570.00
     */

    private String awardNo;
    private String awardTime;
    private String extra;
    private String gameEn;
    private String luckyBlue;
    private String periodName;
    private String totalPool;
    private String totalSale;

    public String getAwardNo() {
        return awardNo;
    }

    public void setAwardNo(String awardNo) {
        this.awardNo = awardNo;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getGameEn() {
        return gameEn;
    }

    public void setGameEn(String gameEn) {
        this.gameEn = gameEn;
    }

    public String getLuckyBlue() {
        return luckyBlue;
    }

    public void setLuckyBlue(String luckyBlue) {
        this.luckyBlue = luckyBlue;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getTotalPool() {
        return totalPool;
    }

    public void setTotalPool(String totalPool) {
        this.totalPool = totalPool;
    }

    public String getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(String totalSale) {
        this.totalSale = totalSale;
    }
}
