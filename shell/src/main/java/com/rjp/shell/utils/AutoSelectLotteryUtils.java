package com.rjp.shell.utils;

import com.rjp.shell.model.LotteryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static com.rjp.shell.utils.LotteryIDUtils.*;


/**
 * 机选单例
 *
 * @author Gimpo create on 2017/11/9 16:28
 * @email : jimbo922@163.com
 */

public class AutoSelectLotteryUtils {

    //排列三和值计算
    public static int[] PL3_ZX_HEZHI = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    public static int[] PL3_ZS_HEZHI = {1, 2, 1, 3, 3, 3, 4, 5, 4, 5, 5, 4, 5, 5, 4, 5, 5, 4, 5, 4, 3, 3, 3, 1, 2, 1};
    public static int[] PL3_ZL_HEZHI = {1, 1, 2, 3, 4, 5, 7, 8, 9, 10, 10, 10, 10, 9, 8, 7, 5, 4, 3, 2, 1, 1};

    protected static int[] OTHER_2ZUH_ZHUSHU = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1};
    protected static int[] OTHER_2H_ZHUSHU = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    protected static int[] OTHER_3H_ZHUSHU = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};


    private static AutoSelectLotteryUtils mInstance;

    public static AutoSelectLotteryUtils getInstance() {
        if (mInstance == null) {
            synchronized (AutoSelectLotteryUtils.class) {
                if (mInstance == null) {
                    mInstance = new AutoSelectLotteryUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 机选一注
     */
    public LotteryModel roll1(LotteryModel lotteryModel) {
        String lotteryType = lotteryModel.getLotteryType();
        switch (lotteryType) {
            case JIANGXIK3_LOTTERY_ID_INT + "":
            case GUANGXIK3_LOTTERY_ID_INT + "":
            case JILINK3_LOTTERY_ID_INT + "":
                return rollK3(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case CQSSC_LOTTERY_ID_INT + "":
                return rollSSC(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case GP11XUAN5_LOTTERY_ID_INT + "":
            case GP11XUAN5_GD_LOTTERY_ID_INT + "":
            case GP11XUAN5_HB_LOTTERY_ID_INT + "":
            case GP11XUAN5_JX_LOTTERY_ID_INT + "":
            case GP11XUAN5_GX_LOTTERY_ID_INT + "":
                return rollX5(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case DLT_LOTTERY_ID_INT + "":
                return rollDLT(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case FC3D_LOTTERY_ID_INT + "":
                return rollFC3D(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case PL3_LOTTERY_ID_INT + "":
                return rollPL3(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case PL5_LOTTERY_ID_INT + "":
                return rollPL5(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case QLC_LOTTERY_ID_INT + "":
                return rollQLC(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case QXC_LOTTERY_ID_INT + "":
                return rollQXC(lotteryType, lotteryType + lotteryModel.getWanfaId());
            case SSQ_LOTTERY_ID_INT + "":
                return rollSSQ(lotteryType, lotteryType + lotteryModel.getWanfaId());
        }
        return null;
    }

    /**
     * 双色球机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollSSQ(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case SSQ_LOTTERY_COMMON_DAN_ID_INT:
            case SSQ_LOTTERY_COMMON_FU_ID_INT:
            case SSQ_LOTTERY_TOWED_ID_INT:
                List<Integer> redList = getRandomIntNoRepeat(1, 33, 6);
                List<Integer> blueList = getRandomIntNoRepeat(1, 16, 1);
                for (Integer red : redList) {
                    sb.append(AppUtils.ten(red)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("|");
                for (Integer blue : blueList) {
                    sb.append(AppUtils.ten(blue)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
//            case SSQ_LOTTERY_TOWED_ID_INT:
//                List<Integer> reds = getRandomIntNoRepeat(1, 33, 7);
//                List<Integer> blues = getRandomIntNoRepeat(1, 16, 1);
//                for (int i = 0; i < 5; i++) {
//                    sb.append(AppUtils.ten(reds.get(i))).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                sb.append("#");
//                for (int i = 5; i < 7; i++) {
//                    sb.append(AppUtils.ten(reds.get(i))).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                sb.append("|");
//                for (Integer blue : blues) {
//                    sb.append(AppUtils.ten(blue)).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                lotteryModel = new LotteryModel(lotteryType, "03", 2, sb.toString());
//                break;

        }
        return lotteryModel;
    }

    /**
     * 七星彩机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollQXC(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case QXC_LOTTERY_COMMON_DAN_ID_INT:
            case QXC_LOTTERY_COMMON_FU_ID_INT:
                List<Integer> numList = getRandomIntNoSort(0, 9, 7);
                for (Integer integer : numList) {
                    sb.append(AppUtils.ten(integer)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
        }
        return lotteryModel;
    }

    /**
     * 七乐彩机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollQLC(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case QLC_LOTTERY_COMMON_DAN_ID_INT:
            case QLC_LOTTERY_COMMON_FU_ID_INT:
            case QLC_LOTTERY_TOWED_ID_INT:
                List<Integer> numList = getRandomIntNoRepeat(1, 30, 7);
                for (Integer integer : numList) {
                    sb.append(AppUtils.ten(integer)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
//            case QLC_LOTTERY_TOWED_ID_INT:
//                List<Integer> nums = getRandomIntNoRepeat(1, 30, 8);
//                for (int i = 0; i < 6; i++) {
//                    sb.append(AppUtils.ten(nums.get(i))).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                sb.append("#");
//                for (int i = 6; i < 8; i++) {
//                    sb.append(AppUtils.ten(nums.get(i))).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                lotteryModel = new LotteryModel(lotteryType, "03", 2, sb.toString());
//                break;
        }
        return lotteryModel;
    }

    /**
     * 排列5机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollPL5(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case PL5_LOTTERY_COMMON_DAN_ID_INT:
            case PL5_LOTTERY_COMMON_FU_ID_INT:
                List<Integer> numList = getRandomIntNoSort(0, 9, 5);
                for (Integer integer : numList) {
                    sb.append(AppUtils.ten(integer)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
        }
        return lotteryModel;
    }

    /**
     * 排列3机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollPL3(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case PL3_LOTTERY_COMMON_DAN_ID_INT:
            case PL3_LOTTERY_COMMON_FU_ID_INT:
                List<Integer> numList = getRandomInt(0, 9, 3);
                for (Integer integer : numList) {
                    sb.append(AppUtils.ten(integer)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
            case PL3_LOTTERY_ZUSAN_DAN_ID_INT:
                List<Integer> nums = getRandomIntNoRepeat(0, 9, 2);
                sb.append(AppUtils.ten(nums.get(0))).append(",");
                sb.append(AppUtils.ten(nums.get(0))).append(",");
                sb.append(AppUtils.ten(nums.get(1))).append(",");
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "02", 1, sb.toString());
                break;
            case PL3_LOTTERY_ZUSAN_FU_ID_INT:
                List<Integer> nums1 = getRandomIntNoRepeat(0, 9, 2);
                for (Integer num : nums1) {
                    sb.append(AppUtils.ten(num)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "12", 2, sb.toString());
                break;
            case PL3_LOTTERY_ZULIU_DAN_ID_INT:
            case PL3_LOTTERY_ZULIU_FU_ID_INT:
                List<Integer> list = getRandomIntNoRepeat(0, 9, 3);
                for (Integer num : list) {
                    sb.append(AppUtils.ten(num)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "03", 1, sb.toString());
                break;
            case PL3_LOTTERY_ZHIXUAN_SUM_ID_INT:
                List<Integer> list1 = getRandomIntNoRepeat(0, 27, 1);
                Integer number = list1.get(0);
                lotteryModel = new LotteryModel(lotteryType, "21", PL3_ZX_HEZHI[number], AppUtils.ten(number));
                break;
            case PL3_LOTTERY_ZUSAN_SUM_ID_INT:
                List<Integer> list2 = getRandomIntNoRepeat(1, 26, 1);
                Integer number1 = list2.get(0);
                lotteryModel = new LotteryModel(lotteryType, "22", PL3_ZS_HEZHI[number1 - 1], AppUtils.ten(number1));
                break;
            case PL3_LOTTERY_ZULIU_SUM_ID_INT:
                List<Integer> list3 = getRandomIntNoRepeat(3, 24, 1);
                Integer number2 = list3.get(0);
                lotteryModel = new LotteryModel(lotteryType, "23", PL3_ZL_HEZHI[number2 - 1], AppUtils.ten(number2));
                break;
        }
        return lotteryModel;
    }

    /**
     * 福彩3D机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollFC3D(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        StringBuilder sb = new StringBuilder();
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case FC3D_LOTTERY_COMMON_DAN_ID_INT:
            case FC3D_LOTTERY_COMMON_FU_ID_INT:
                List<Integer> numList = getRandomInt(0, 9, 3);
                for (Integer integer : numList) {
                    sb.append(AppUtils.ten(integer)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
                break;
            case FC3D_LOTTERY_ZUSAN_DAN_ID_INT:
                List<Integer> nums = getRandomIntNoRepeat(0, 9, 2);
                sb.append(AppUtils.ten(nums.get(0))).append(",");
                sb.append(AppUtils.ten(nums.get(0))).append(",");
                sb.append(AppUtils.ten(nums.get(1))).append(",");
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "02", 1, sb.toString());
                break;
            case FC3D_LOTTERY_ZUSAN_FU_ID_INT:
                List<Integer> nums1 = getRandomIntNoRepeat(0, 9, 2);
                for (Integer num : nums1) {
                    sb.append(AppUtils.ten(num)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "12", 2, sb.toString());
                break;
            case FC3D_LOTTERY_ZULIU_DAN_ID_INT:
            case FC3D_LOTTERY_ZULIU_FU_ID_INT:
                List<Integer> list = getRandomIntNoRepeat(0, 9, 3);
                for (Integer num : list) {
                    sb.append(AppUtils.ten(num)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "03", 1, sb.toString());
                break;
            case FC3D_LOTTERY_ZHIXUAN_SUM_ID_INT:
                List<Integer> list1 = getRandomIntNoRepeat(0, 27, 1);
                Integer number = list1.get(0);
                lotteryModel = new LotteryModel(lotteryType, "21", PL3_ZX_HEZHI[number], AppUtils.ten(number));
                break;
            case FC3D_LOTTERY_ZUSAN_SUM_ID_INT:
                List<Integer> list2 = getRandomIntNoRepeat(1, 26, 1);
                Integer number1 = list2.get(0);
                lotteryModel = new LotteryModel(lotteryType, "22", PL3_ZS_HEZHI[number1 - 1], AppUtils.ten(number1));
                break;
            case FC3D_LOTTERY_ZULIU_SUM_ID_INT:
                List<Integer> list3 = getRandomIntNoRepeat(3, 24, 1);
                Integer number2 = list3.get(0);
                lotteryModel = new LotteryModel(lotteryType, "23", PL3_ZL_HEZHI[number2 - 3], AppUtils.ten(number2));
                break;
        }
        return lotteryModel;
    }

    /**
     * 大乐透机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollDLT(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case DLT_LOTTERY_COMMON_DAN_ID_INT:
            case DLT_LOTTERY_COMMON_FU_ID_INT:
            case DLT_LOTTERY_TOWED_ID_INT:{
                StringBuilder sb = new StringBuilder();
                List<Integer> redList = getRandomIntNoRepeat(1, 35, 5);
                for (Integer code : redList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("|");
                List<Integer> blueList = getRandomIntNoRepeat(1, 12, 2);
                for (Integer code : blueList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "01", 1, sb.toString());
            }
                break;
//            case DLT_LOTTERY_TOWED_ID_INT: {
//                StringBuilder sb = new StringBuilder();
//                List<Integer> redList = getRandomIntNoRepeat(1, 35, 6);
//                List<Integer> dans = redList.subList(0, 2);
//                List<Integer> reds = redList.subList(2, 6);
//                List<Integer> blues = getRandomIntNoRepeat(1, 12, 2);
//                for (Integer code : dans) {
//                    sb.append(AppUtils.ten(code)).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                sb.append("#");
//                for (Integer red : reds) {
//                    sb.append(AppUtils.ten(red)).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                sb.append("|");
//                for (Integer blue : blues) {
//                    sb.append(AppUtils.ten(blue)).append(",");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                lotteryModel = new LotteryModel(lotteryType, "03", 2, sb.toString());
//            }
//                break;
        }
        return lotteryModel;
    }

    /**
     * 11选5机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollX5(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case GP11XUAN5_LOTTERY_RENER_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENER_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENER_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENER_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENER_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENER_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENER_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENER_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENER_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENER_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENER_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENER_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 2);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "02", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENSAN_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENSAN_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSAN_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSAN_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSAN_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSAN_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSAN_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSAN_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENSAN_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSAN_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSAN_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSAN_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 3);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "03", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENSI_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENSI_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSI_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSI_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSI_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSI_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSI_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSI_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENSI_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENSI_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENSI_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENSI_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 4);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "04", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENWU_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENWU_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENWU_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENWU_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENWU_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENWU_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENWU_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENWU_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENWU_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENWU_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENWU_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENWU_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 5);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "05", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENLIU_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENLIU_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENLIU_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENLIU_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENLIU_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENLIU_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENLIU_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENLIU_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENLIU_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENLIU_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENLIU_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENLIU_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 6);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "06", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENQI_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENQI_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENQI_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENQI_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENQI_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENQI_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENQI_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENQI_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENQI_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENQI_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENQI_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENQI_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 7);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "07", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_RENBA_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_RENBA_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENBA_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENBA_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENBA_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENBA_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENBA_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENBA_FU_ID_INT:
            case GP11XUAN5_LOTTERY_RENBA_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_RENBA_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_RENBA_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_RENBA_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 8);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "08", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_QIANYI_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_QIANYI_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANYI_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANYI_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANYI_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANYI_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANYI_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANYI_FU_ID_INT:
                int num1 = getRandomInt(1, 11);
                lotteryModel = new LotteryModel(lotteryType, "31", 1, AppUtils.ten(num1));
                break;
            case GP11XUAN5_LOTTERY_QIANER_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_QIANER_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANER_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANER_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANER_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANER_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANER_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANER_FU_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 2);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "32", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_QIANER_ZU_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_QIANER_ZU_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANER_ZU_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANER_ZU_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANER_ZU_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANER_ZU_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANER_ZU_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANER_ZU_FU_ID_INT:
            case GP11XUAN5_LOTTERY_QIANER_ZU_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANER_ZU_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANER_ZU_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANER_ZU_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 2);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "34", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_QIANSAN_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_QIANSAN_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANSAN_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANSAN_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANSAN_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANSAN_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANSAN_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANSAN_FU_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 3);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "33", 1, sb.toString());
            }
                break;
            case GP11XUAN5_LOTTERY_QIANSAN_ZU_DAN_ID_INT:
            case GP11XUAN5_LOTTERY_QIANSAN_ZU_FU_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_DAN_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_FU_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_DAN_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_FU_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_DAN_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_FU_ID_INT:
            case GP11XUAN5_LOTTERY_QIANSAN_ZU_TOWED_ID_INT:
            case GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_TOWED_ID_INT:
            case GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_TOWED_ID_INT:
            case GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_TOWED_ID_INT:
            {
                StringBuilder sb = new StringBuilder();
                List<Integer> codeList = getRandomIntNoRepeat(1, 11, 3);
                for (Integer code : codeList) {
                    sb.append(AppUtils.ten(code)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "35", 1, sb.toString());
            }
                break;
        }
        return lotteryModel;
    }

    /**
     * 机选时时彩
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollSSC(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case CQSSC_LOTTERY_ID_WX_DAN_INT:
            case CQSSC_LOTTERY_ID_WX_FU_INT:
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    sb.append(getRandomInt(0, 9)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "05", 1, sb.toString());
                break;
            case CQSSC_LOTTERY_ID_WXTX_INT:
                StringBuilder sb1 = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    sb1.append(getRandomInt(0, 9)).append(";");
                }
                sb1.deleteCharAt(sb1.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "27", 1, sb1.toString());
                break;
            case CQSSC_LOTTERY_ID_DXDS_INT:
                String[] dxds = new String[]{"2", "1", "5", "4"};
                int index1 = getRandomInt(0, 3);
                int index2 = getRandomInt(0, 3);
                lotteryModel = new LotteryModel(lotteryType, "26", 1, dxds[index1] + ";" + dxds[index2]);
                break;
            case CQSSC_LOTTERY_ID_SX_DAN_INT:
            case CQSSC_LOTTERY_ID_SX_FU_INT:
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb2.append(getRandomInt(0, 9)).append(",");
                }
                sb2.deleteCharAt(sb2.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "03", 1, sb2.toString());
                break;
            case CQSSC_LOTTERY_ID_ZS_DAN_INT:
                int num1 = getRandomInt(0, 9);
                int num2 = getRandomInt(0, 9);
                while (num1 == num2) {
                    num2 = getRandomInt(0, 9);
                }
                lotteryModel = new LotteryModel(lotteryType, "06", 1, num1 + "," + num1 + "," + num2);
                break;
            case CQSSC_LOTTERY_ID_ZUSAN_BAO_INT:
                int num3 = getRandomInt(0, 9);
                int num4 = getRandomInt(0, 9);
                while (num3 == num4) {
                    num4 = getRandomInt(0, 9);
                }
                lotteryModel = new LotteryModel(lotteryType, "24", 2, num3 + "," + num4);
                break;
            case CQSSC_LOTTERY_ID_ZL_DAN_INT:
            case CQSSC_LOTTERY_ID_ZULIU_BAO_INT:
                List<Integer> numList = getRandomIntNoRepeat(0, 9, 3);
                StringBuilder sb3 = new StringBuilder();
                for (Integer num : numList) {
                    sb3.append(num).append(",");
                }
                sb3.deleteCharAt(sb3.length() - 1);
                lotteryModel = new LotteryModel(lotteryType, "07", 1, sb3.toString());
                break;
            case CQSSC_LOTTERY_ID_SX_HE_INT:
                int num5 = getRandomInt(0, 27);
                lotteryModel = new LotteryModel(lotteryType, "22", 1, String.valueOf(num5));
                break;
            case CQSSC_LOTTERY_ID_EX_DAN_INT:
            case CQSSC_LOTTERY_ID_EX_FU_INT:
                int num6 = getRandomInt(0, 9);
                int num7 = getRandomInt(0, 9);
                lotteryModel = new LotteryModel(lotteryType, "02", 1, num6 + "," + num7);
                break;
            case CQSSC_LOTTERY_ID_EX_ZU_INT:
                List<Integer> num8 = getRandomIntNoRepeat(0, 9, 2);
                lotteryModel = new LotteryModel(lotteryType, "23", 1, num8.get(0) + "," + num8.get(1));
                break;
            case CQSSC_LOTTERY_ID_EX_HE_INT:
                lotteryModel = new LotteryModel(lotteryType, "21", 1, String.valueOf(getRandomInt(0, 18)));
                break;
            case CQSSC_LOTTERY_ID_EXZU_HE_INT:
                lotteryModel = new LotteryModel(lotteryType, "20", 1, String.valueOf(getRandomInt(0, 18)));
                break;
            case CQSSC_LOTTERY_ID_YX_DAN_INT:
            case CQSSC_LOTTERY_ID_YX_FU_INT:
                lotteryModel = new LotteryModel(lotteryType, "01", 1, String.valueOf(getRandomInt(0, 9)));
                break;
        }
        return lotteryModel;
    }

    /**
     * 快三机选
     *
     * @param lotteryType
     * @param wanfaID
     */
    public LotteryModel rollK3(String lotteryType, String wanfaID) {
        LotteryModel lotteryModel = null;
        int wanfaId = Integer.parseInt(wanfaID);
        switch (wanfaId) {
            case GUANGXIK3_LOTTERY_SUMZHI_ID_INT:
            case JIANGXIK3_LOTTERY_SUMZHI_ID_INT:
            case JILINK3_LOTTERY_SUMZHI_ID_INT:
                int number = getRandomInt(3, 18);
                lotteryModel = new LotteryModel(lotteryType, "60", 1, String.valueOf(number));
                break;
            case GUANGXIK3_LOTTERY_SANTONGHAO_ID_INT:
            case JIANGXIK3_LOTTERY_SANTONGHAO_ID_INT:
            case JILINK3_LOTTERY_SANTONGHAO_ID_INT:
            case JILINK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
            case JIANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
            case GUANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
                int number1 = getRandomInt(1, 6);
                String codeTemp = String.valueOf(number1) + "," + String.valueOf(number1) + "," + String.valueOf(number1);
                lotteryModel = new LotteryModel(lotteryType, "30", 1, codeTemp);
                break;
//            case JILINK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
//            case JIANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
//            case GUANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT:
//                lotteryModel = new LotteryModel(lotteryType, "32", 1, "1");
//                break;
            case GUANGXIK3_LOTTERY_ERTONGHAO_ZU_ID_INT:
            case JIANGXIK3_LOTTERY_ERTONGHAO_ZU_ID_INT:
            case JILINK3_LOTTERY_ERTONGHAO_ZU_ID_INT:
            case GUANGXIK3_LOTTERY_ERTONGHAO_DAN_ID_INT:
            case JIANGXIK3_LOTTERY_ERTONGHAO_DAN_ID_INT:
            case JILINK3_LOTTERY_ERTONGHAO_DAN_ID_INT:
                List<Integer> numList = getRandomIntNoRepeat(1, 6, 2);
                lotteryModel = new LotteryModel(lotteryType, "12", 1, String.valueOf(numList.get(0)) + "*" + String.valueOf(numList.get(1)));
                break;
            case GUANGXIK3_LOTTERY_ERTONGHAO_FU_ID_INT:
            case JIANGXIK3_LOTTERY_ERTONGHAO_FU_ID_INT:
            case JILINK3_LOTTERY_ERTONGHAO_FU_ID_INT:
                int number4 = getRandomInt(1, 6);
                lotteryModel = new LotteryModel(lotteryType, "11", 1, String.valueOf(number4));
                break;
            case GUANGXIK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT:
            case JIANGXIK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT:
            case JILINK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT:
            case GUANGXIK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT:
            case JIANGXIK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT:
            case JILINK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT:
            case GUANGXIK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT:
            case JIANGXIK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT:
            case JILINK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT:
                List<Integer> randomInt = getRandomIntNoRepeat(1, 6, 3);
                StringBuilder sb = new StringBuilder();
                for (Integer integer : randomInt) {
                    sb.append(integer).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                String code3 = sb.toString();
                lotteryModel = new LotteryModel(lotteryType, "40", 1, code3);
                break;
            case JILINK3_LOTTERY_SANLIANHAO_TONG_ID_INT:
            case JIANGXIK3_LOTTERY_SANLIANHAO_TONG_ID_INT:
            case GUANGXIK3_LOTTERY_SANLIANHAO_TONG_ID_INT:
                int num = getRandomInt(1, 4);
                lotteryModel = new LotteryModel(lotteryType, "40", 1, num + "," + (num + 1) + "," + (num + 2));
                break;
            case GUANGXIK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT:
            case JIANGXIK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT:
            case JILINK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT:
            case GUANGXIK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT:
            case JIANGXIK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT:
            case JILINK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT:
            case GUANGXIK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT:
            case JIANGXIK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT:
            case JILINK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT:
                List<Integer> randomInt1 = getRandomIntNoRepeat(1, 6, 2);
                StringBuilder sb1 = new StringBuilder();
                for (Integer integer : randomInt1) {
                    sb1.append(integer).append(",");
                }
                sb1.deleteCharAt(sb1.length() - 1);
                String code4 = sb1.toString();
                lotteryModel = new LotteryModel(lotteryType, "20", 1, code4);
                break;

        }
        return lotteryModel;
    }

    /**
     * 获取一个范围内的随机值随机值
     *
     * @param min
     * @param max
     */
    private int getRandomInt(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max + 1);
        while (num > max || num < min) {
            num = random.nextInt(max + 1);
        }
        return num;
    }

    /**
     * 在一个区间内获取count个号码  可以重复 默认排序
     *
     * @param min
     * @param max
     * @param count 个数
     * @return
     */
    private List<Integer> getRandomInt(int min, int max, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getRandomInt(min, max));
        }
        Collections.sort(list);
        return list;
    }

    /**
     * 在一个区间内获取count个号码  可以重复 不需要排序
     *
     * @param min
     * @param max
     * @param count 个数
     * @return
     */
    private List<Integer> getRandomIntNoSort(int min, int max, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(getRandomInt(min, max));
        }
        return list;
    }

    /**
     * 在一个区间内获取count个号码  不可以重复
     *
     * @param min
     * @param max
     * @param count
     * @return
     */
    private List<Integer> getRandomIntNoRepeat(int min, int max, int count) {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < count) {
            set.add(getRandomInt(min, max));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set) {
            list.add(integer);
        }
        Collections.sort(list);
        return list;
    }

    /**
     * 机选五注
     */
    public List<LotteryModel> roll5(LotteryModel lotteryModel) {
        List<LotteryModel> models = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            models.add(roll1(lotteryModel));
        }
        return models;
    }
}
