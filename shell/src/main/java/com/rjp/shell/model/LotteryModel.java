package com.rjp.shell.model;

/**
 * 选择的彩种
 * @author Gimpo create on 2017/11/6 16:08
 * @email : jimbo922@163.com
 */

public class LotteryModel {
    private String lotteryType;
    private String wanfaId;
    private long zhuShu;
    private String betCode;

    public LotteryModel(String lotteryType){
        this.lotteryType = lotteryType;
    }

    public LotteryModel(String lotteryType, String wanfaId, long zhuShu, String betCode){
        this.lotteryType = lotteryType;
        this.setWanfaId(wanfaId);
        this.zhuShu = zhuShu;
        this.setBetCode(betCode);
    }

    public long getZhuShu() {
        return zhuShu;
    }

    public void setZhuShu(long zhuShu) {
        this.zhuShu = zhuShu;
    }

    public String getWanfaId() {
        return wanfaId;
    }

    public void setWanfaId(String wanfaId) {
        this.wanfaId = wanfaId;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getBetCode() {
        return betCode;
    }

    public void setBetCode(String betCode) {
        this.betCode = betCode;
    }
}
