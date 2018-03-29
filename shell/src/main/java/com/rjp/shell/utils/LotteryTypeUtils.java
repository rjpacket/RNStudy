package com.rjp.shell.utils;

public class LotteryTypeUtils {

    private LotteryTypeUtils() {

    }

    public static String getLotteryName(int lotteryType) {
        return getLotteryName(String.valueOf(lotteryType));
    }

    /**
     * 获取彩种名称
     *
     * @param lotteryType
     * @return
     */
    public static String getLotteryName(String lotteryType) {
        switch (lotteryType) {
            case "1001":
                return "双色球";
            case "1002":
                return "福彩3D";
            case "1003":
                return "七乐彩";
            case "2001":
                return "大乐透";
            case "2002":
                return "排列三";
            case "2004":
                return "七星彩";
            case "2003":
                return "排列五";
            case "1010":
                return "广西快三";
            case "1013":
                return "江西快三";
            case "1014":
                return "吉林快三";
            case "2006":
                return "江西十一选五";
            case "2007":
                return "山东十一选五";
            case "2005":
                return "广东十一选五";
            case "2010":
                return "湖北十一选五";
            case "1007":
                return "重庆时时彩";
            case "3001":
                return "竞彩篮球胜负";
            case "3002":
                return "竞彩篮球让分胜负";
            case "3003":
                return "竞彩篮球胜分差";
            case "3004":
                return "竞彩篮球大小分";
            case "3005":
                return "竞彩篮球混合";
            case "3006":
                return "竞彩足球让球胜平负";
            case "3007":
                return "竞彩足球比分";
            case "3008":
                return "竞彩足球总进球";
            case "3009":
                return "竞彩足球半全场";
            case "3010":
                return "竞彩足球胜平负";
            case "3011":
                return "竞彩足球混合";
            case "3012":
                return "竞彩冠军";
            case "3013":
                return "竞彩冠亚军";
            case "5001":
                return "北京单场让球胜平负";
            case "5002":
                return "北京单场进球数";
            case "5003":
                return "北京单场半全场";
            case "5004":
                return "北京单场上下单双";
            case "5005":
                return "北京单场比分";
            case "4001":
                return "足球胜负彩";
            case "4002":
                return "足球任选九";
            case "4003":
                return "足球进球彩";
            case "4004":
                return "足球六场半";
            case "ZC":
                return "足彩";
            case "jclq":
                return "竞彩篮球";
            case "jczq":
                return "竞彩足球";
            case "bjdc":
                return "北京单场";
        }
        return "";
    }

    public static String getFileName(String lotteryType) {
        switch (lotteryType){
            case "1001":
                return "open_ssq.json";
            case "1002":
                return "open_fc3d.json";
            case "1003":
                return "open_qlc.json";
            case "2001":
                return "open_dlt.json";
            case "2002":
                return "open_pl3.json";
            case "2004":
                return "open_qxc.json";
            case "2003":
                return "open_pl5.json";
            case "1010":
                return "open_guangxik3.json";
            case "1013":
                return "open_jiangxik3.json";
            case "1014":
                return "open_jilink3.json";
            case "2006":
                return "open_jiangxi115.json";
            case "2007":
                return "open_shandong115.json";
            case "2005":
                return "open_guangdong115.json";
            case "2010":
                return "open_hubei115.json";
            case "1007":
                return "open_chongqingssc.json";
            case "4001":
                return "open_zcsfc.json";
            case "4002":
                return "open_zcsfc.json";
            case "4003":
                return "open_zcjqc.json";
            case "4004":
                return "open_zclcb.json";
        }
        return null;
    }
}
