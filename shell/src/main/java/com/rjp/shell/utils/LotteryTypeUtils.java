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
                return "欢乐快三";
            case "1013":
                return "幸运快三";
            case "1014":
                return "快三";
            case "2006":
                return "多乐彩";
            case "2007":
                return "老11选5";
            case "2005":
                return "新11选5";
            case "2010":
                return "湖北11选5";
            case "1007":
                return "时时彩";
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
                return "足彩胜负彩";
            case "4002":
                return "足彩任选九";
            case "4003":
                return "足球进球彩";
            case "4004":
                return "足彩六场半";
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

    public static String getLotterySimpleName(int lotteryType) {
        return getLotterySimpleName(String.valueOf(lotteryType));
    }

    /**
     * 获取彩种简称
     *
     * @param lotteryType
     * @return
     */
    public static String getLotterySimpleName(String lotteryType) {
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
            case "4003":
                return "进球彩";
            case "4004":
                return "足球六场半";
            case "4001":
                return "足球胜负彩";
            case "4002":
                return "足球任九";
            case "1004":
                return "天津快乐十分";
            case "1104":
                return "黑龙江快乐十分";
            case "1105":
                return "广西快乐十分";
            case "1008":
                return "安徽快三";
            case "1009":
                return "江苏快三";
            case "1010":
                return "欢乐快三";
            case "1005":
                return "宁夏快三";
            case "1013":
                return "幸运快三";
            case "1014":
                return "快三";
            case "2006":
                return "多乐彩";
            case "2007":
                return "老11选5";
            case "2005":
                return "新11选5";
            case "2010":
                return "开心11选5";
            case "2009":
                return "山东快乐扑克3";
            case "1011":
                return "江西时时彩";
            case "1006":
                return "黑龙江时时彩";
            case "1007":
                return "时时彩";
            case "1106":
                return "天津时时彩";
            case "jclq":
                return "竞彩篮球";
            case "jczq":
                return "竞彩足球";
            case "3012":
                return "竞彩冠军";
            case "3013":
                return "竞彩冠亚军";
            case "ZC":
                return "足彩";
            case "3001":
                return "竞篮-胜负";
            case "3002":
                return "竞篮-让分胜负";
            case "3003":
                return "竞篮-胜分差";
            case "3004":
                return "竞篮-大小分";
            case "3006":
                return "竞足-让球胜平负";
            case "3010":
                return "竞足-胜平负";
            case "3008":
                return "竞足-进球数";
            case "3007":
                return "竞足-比分";
            case "3009":
                return "竞足-半全场";
            case "3005":
                return "竞篮-混合";
            case "3011":
                return "竞足-混合";
            case "bjdc":
                return "北京单场";
            case "5006":
                return "北单-胜负";
            case "5001":
                return "北单-让球胜负";
            case "5002":
                return "北单-进球数";
            case "5003":
                return "北单-半全场";
            case "5004":
                return "北单-上下单双";
            case "5005":
                return "北单-比分";
        }
        return "未知彩种";
    }

    /**
     * 获取彩种简称
     *
     * @param lotteryType
     * @return
     */
    public static String getLotteryTitle(String lotteryType) {
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
            case "4003":
                return "进球彩";
            case "4004":
                return "足球六场半";
            case "4001":
                return "足球胜负彩";
            case "4002":
                return "足球任九";
            case "1004":
                return "天津快乐十分";
            case "1104":
                return "黑龙江快乐十分";
            case "1105":
                return "广西快乐十分";
            case "1008":
                return "安徽快三";
            case "1009":
                return "江苏快三";
            case "1010":
                return "欢乐快三";
            case "1005":
                return "宁夏快三";
            case "1013":
                return "幸运快三";
            case "1014":
                return "快三";
            case "2006":
                return "多乐彩";
            case "2007":
                return "老11选5";
            case "2005":
                return "新11选5";
            case "2010":
                return "开心11选5";
            case "2009":
                return "山东快乐扑克3";
            case "1011":
                return "江西时时彩";
            case "1006":
                return "黑龙江时时彩";
            case "1007":
                return "时时彩";
            case "1106":
                return "天津时时彩";
            case "jclq":
                return "竞篮";
            case "jczq":
                return "竞足";
            case "3012":
                return "竞彩冠军";
            case "3013":
                return "竞彩冠亚军";
            case "ZC":
                return "足彩";
            case "3001":
                return "竞篮-胜负";
            case "3002":
                return "竞篮-让分胜负";
            case "3003":
                return "竞篮-胜分差";
            case "3004":
                return "竞篮-大小分";
            case "3006":
                return "竞足-让球胜平负";
            case "3010":
                return "竞足-胜平负";
            case "3008":
                return "竞足-总进球";
            case "3007":
                return "竞足-比分";
            case "3009":
                return "竞足-半全场";
            case "3005":
                return "竞篮-混合";
            case "3011":
                return "竞足-混合";
            case "bjdc":
                return "北单";
            case "5006":
                return "北单-胜负";
            case "5001":
                return "北单-让球胜负";
            case "5002":
                return "北单-总进球";
            case "5003":
                return "北单-半全场";
            case "5004":
                return "北单-上下单双";
            case "5005":
                return "北单-比分";
        }
        return "未知彩种";
    }

    public static String getLotterySignName(int lotteryType) {
        return getLotterySignName(String.valueOf(lotteryType));
    }

    /**
     * 晒单 获取彩种 极简称
     *
     * @param lotteryType
     * @return
     */
    public static String getLotterySignName(String lotteryType) {
        switch (lotteryType) {
            case "4003":
                return "进球彩";
            case "4004":
                return "六场半";
            case "4001":
                return "胜负彩";
            case "4002":
                return "任选九";

            case "3001":
            case "3002":
            case "3003":
            case "3004":
            case "3005":
                return "竞篮";

            case "3006":
            case "3007":
            case "3008":
            case "3009":
            case "3010":
            case "3011":
                return "竞足";

            case "5001":
            case "5002":
            case "5003":
            case "5004":
            case "5005":
            case "5006":
                return "北单";
        }
        return "未知彩种";
    }

    public static String getLotteryMiddleName(int lotteryType) {
        return getLotteryMiddleName(String.valueOf(lotteryType));
    }

    /**
     * 晒单 获取彩种 极简称
     *
     * @param lotteryType
     * @return
     */
    public static String getLotteryMiddleName(String lotteryType) {
        switch (lotteryType) {
            case "4003":
                return "足球进球彩";
            case "4004":
                return "足球六场半";
            case "4001":
                return "足球胜负彩";
            case "4002":
                return "足球任选九";

            case "3001":
            case "3002":
            case "3003":
            case "3004":
            case "3005":
                return "竞彩篮球";

            case "3006":
            case "3007":
            case "3008":
            case "3009":
            case "3010":
            case "3011":
                return "竞彩足球";

            case "5001":
            case "5002":
            case "5003":
            case "5004":
            case "5005":
            case "5006":
                return "北京单场";
        }
        return "未知彩种";
    }
}
