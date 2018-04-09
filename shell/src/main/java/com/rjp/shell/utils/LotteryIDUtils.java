package com.rjp.shell.utils;

/**
 * 彩种的lotteryID
 */
public class LotteryIDUtils {
    /** 全部彩种 */
    public static final int LOTTERY_ID_ALL_INT = -1;

    /** 双色球 **/
    public static final int SSQ_LOTTERY_ID_INT = 1001;
    public static final int SSQ_LOTTERY_COMMON_DAN_ID_INT = 100101;
    public static final int SSQ_LOTTERY_COMMON_FU_ID_INT = 100102;
    public static final int SSQ_LOTTERY_TOWED_ID_INT = 100103;
    public static final int SSQ_LOTTERY_COMMON_HUN_ID_INT = 100104;

    /** 福彩3D **/
    public static final int FC3D_LOTTERY_ID_INT = 1002;
    public static final int FC3D_LOTTERY_COMMON_DAN_ID_INT = 100201;
    public static final int FC3D_LOTTERY_COMMON_FU_ID_INT = 100211;
    public static final int FC3D_LOTTERY_ZHIXUAN_SUM_ID_INT = 100221;
    public static final int FC3D_LOTTERY_ZUSAN_DAN_ID_INT = 100202;
    public static final int FC3D_LOTTERY_ZUSAN_FU_ID_INT = 100212;
    public static final int FC3D_LOTTERY_ZUSAN_SUM_ID_INT = 100222;
    public static final int FC3D_LOTTERY_ZULIU_DAN_ID_INT = 100203;
    public static final int FC3D_LOTTERY_ZULIU_FU_ID_INT = 100213;
    public static final int FC3D_LOTTERY_ZULIU_SUM_ID_INT = 100223;

    public static final int FC3D_LOTTERY_COMMON_HUN_ID_INT = 200100;
    public static final int FC3D_LOTTERY_ZULIU_HUN_ID_INT = 200500;

    /** 天津快乐十分 **/
    public static final int KLSF_LOTTERY_ID_INT = 1004;
    public static final int KLSF_LOTTERY_RENER_DAN_ID_INT = 100412;// 任二单式
    public static final int KLSF_LOTTERY_RENER_FU_ID_INT = 100422;// 任二复式
    public static final int KLSF_LOTTERY_RENER_TOWED_ID_INT = 100432;// 任选二胆拖
    public static final int KLSF_LOTTERY_RENSAN_DAN_ID_INT = 100413;// 任选三单式
    public static final int KLSF_LOTTERY_RENSAN_FU_ID_INT = 100423;// 任选三复式
    public static final int KLSF_LOTTERY_RENSAN_TOWED_ID_INT = 100433;// 任选三胆拖
    public static final int KLSF_LOTTERY_RENSI_DAN_ID_INT = 100414;// 任选四单式
    public static final int KLSF_LOTTERY_RENSI_FU_ID_INT = 100424;// 任选四复式
    public static final int KLSF_LOTTERY_RENSI_TOWED_ID_INT = 100434;// 任选四胆拖
    public static final int KLSF_LOTTERY_RENWU_DAN_ID_INT = 100415;// 任选五单式
    public static final int KLSF_LOTTERY_RENWU_FU_ID_INT = 100425;// 任选五复式
    public static final int KLSF_LOTTERY_RENWU_TOWED_ID_INT = 100435;// 任选五胆拖
    public static final int KLSF_LOTTERY_XUANYI_SHU_DAN_ID_INT = 100411;// 选一数投
    // 单式
    public static final int KLSF_LOTTERY_XUANYI_SHU_FU_ID_INT = 100421;// 选一数投
    // 复式
    public static final int KLSF_LOTTERY_XUANYI_HONG_DAN_ID_INT = 100410;// 选一红投单式
    public static final int KLSF_LOTTERY_XUANYI_HONG_FU_ID_INT = 100410;// 选一红投复式（与单式一样）

    public static final int KLSF_LOTTERY_XUANER_LIANZHI_DAN_ID_INT = 100416;// 选二连直单式
    public static final int KLSF_LOTTERY_XUANER_LIANZHI_FU_ID_INT = 100446;// 选二连直复式
    public static final int KLSF_LOTTERY_XUANER_LIANZHI_TOWED_ID_INT = 100436;// 选二连直胆拖

    public static final int KLSF_LOTTERY_XUANER_LIANZU_DAN_ID_INT = 100418;// 选二连组单式
    public static final int KLSF_LOTTERY_XUANER_LIANZU_FU_ID_INT = 100428;// 选二连组复式
    public static final int KLSF_LOTTERY_XUANER_LIANZU_TOWED_ID_INT = 100438;// 选二连组胆拖

    public static final int KLSF_LOTTERY_XUANSAN_QIANZHI_DAN_ID_INT = 100417;// 选三前直
    public static final int KLSF_LOTTERY_XUANSAN_QIANZHI_FU_ID_INT = 100447;// 选三前直
    public static final int KLSF_LOTTERY_XUANSAN_QIANZHI_TOWED_ID_INT = 100437;// 选三前直胆拖

    public static final int KLSF_LOTTERY_XUANSAN_QIANZU_DAN_ID_INT = 100419;// 组选前三
    // 单式
    public static final int KLSF_LOTTERY_XUANSAN_QIANZU_FU_ID_INT = 100429;// 组选前三
    // 复式
    public static final int KLSF_LOTTERY_XUANSAN_QIANZU_TOWED_ID_INT = 100439;// 组选前三
    // 复式

    public static final int KLSF_LOTTERY_RENSAN_HUN_ID_INT = 300200;
    public static final int KLSF_LOTTERY_RENSI_HUN_ID_INT = 300300;
    public static final int KLSF_LOTTERY_XUANYI_SHU_HUN_ID_INT = 300500;
    public static final int KLSF_LOTTERY_RENWU_HUN_ID_INT = 300400;
    public static final int KLSF_LOTTERY_XUANYI_HONG_HUN_ID_INT = 300600;
    public static final int KLSF_LOTTERY_XUANER_LIANZU_HUN_ID_INT = 300800;
    public static final int KLSF_LOTTERY_XUANSAN_QIANZHI_HUN_ID_INT = 300900;
    public static final int KLSF_LOTTERY_XUANSAN_QIANZU_HUN_ID_INT = 301000;
    public static final int KLSF_LOTTERY_RENER_HUN_ID_INT = 300100;
    public static final int KLSF_LOTTERY_XUANER_LIANZHI_HUN_ID_INT = 300700;

    /** 七乐彩 **/
    public static final int QLC_LOTTERY_ID_INT = 1003;
    public static final int QLC_LOTTERY_COMMON_DAN_ID_INT = 100301;
    public static final int QLC_LOTTERY_COMMON_FU_ID_INT = 100302;
    public static final int QLC_LOTTERY_TOWED_ID_INT = 100303;

    public static final int QLC_LOTTERY_COMMON_HUN_ID_INT = 400100;

    /** 宁夏快三 **/
    public static final int NXK3_LOTTERY_ID_INT = 1005;
    public static final int NXK3_LOTTERY_SUMGROUP_ID_INT = 100561;
    public static final int NXK3_LOTTERY_SUMZHI_ID_INT = 100560;//和值
    public static final int NXK3_LOTTERY_ERTONGHAO_DAN_ID_INT = 100510;//二同号单式
    public static final int NXK3_LOTTERY_ERTONGHAO_FU_ID_INT = 100511;//二同号复选
    public static final int NXK3_LOTTERY_ERTONGHAO_ZU_ID_INT = 100512;//二同号单选组合
    public static final int NXK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT = 100520;//二不同单式
    public static final int NXK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT = 100521;//二不同组合
    public static final int NXK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT = 100522;//二不同号胆拖
    public static final int NXK3_LOTTERY_SANTONGHAO_ID_INT = 100530;//三同号单式
    public static final int NXK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT = 100540;//三不同单式
    public static final int NXK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT = 100541;//三不同组合
    public static final int NXK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT = 100542;//三不同胆拖
    public static final int NXK3_LOTTERY_SANTONGHAO_TONG_ID_INT = 100532;//三同号通选
    public static final int NXK3_LOTTERY_SANLIANHAO_TONG_ID_INT = 100550;//三连号通选

    /** 安徽快三 **/
    public static final int ANHUIK3_LOTTERY_ID_INT = 1008;
    public static final int ANHUIK3_LOTTERY_SUMGROUP_ID_INT = 100861;
    public static final int ANHUIK3_LOTTERY_SUMZHI_ID_INT = 100860;//和值
    public static final int ANHUIK3_LOTTERY_ERTONGHAO_DAN_ID_INT = 100810;//二同号单式
    public static final int ANHUIK3_LOTTERY_ERTONGHAO_FU_ID_INT = 100811;//二同号复选
    public static final int ANHUIK3_LOTTERY_ERTONGHAO_ZU_ID_INT = 100812;//二同号单选组合
    public static final int ANHUIK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT = 100820;//二不同单式
    public static final int ANHUIK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT = 100821;//二不同组合
    public static final int ANHUIK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT = 100822;//二不同号胆拖
    public static final int ANHUIK3_LOTTERY_SANTONGHAO_ID_INT = 100830;//三同号单式
    public static final int ANHUIK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT = 100840;//三不同单式
    public static final int ANHUIK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT = 100841;//三不同组合
    public static final int ANHUIK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT = 100842;//三不同胆拖
    public static final int ANHUIK3_LOTTERY_SANTONGHAO_TONG_ID_INT = 100832;//三同号通选
    public static final int ANHUIK3_LOTTERY_SANLIANHAO_TONG_ID_INT = 100850;//三连号通选

    /** 江西快三 **/
    public static final int JIANGXIK3_LOTTERY_ID_INT = 1013;
    public static final int JIANGXIK3_LOTTERY_SUMGROUP_ID_INT = 101361;
    public static final int JIANGXIK3_LOTTERY_SUMZHI_ID_INT = 101360;//和值
    public static final int JIANGXIK3_LOTTERY_SANTONGHAO_ID_INT = 101330;//三同号单式
    public static final int JIANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT = 101332;//三同号通选
    public static final int JIANGXIK3_LOTTERY_ERTONGHAO_DAN_ID_INT = 101310;//二同号单式
    public static final int JIANGXIK3_LOTTERY_ERTONGHAO_ZU_ID_INT = 101312;//二同号单选组合
    public static final int JIANGXIK3_LOTTERY_ERTONGHAO_FU_ID_INT = 101311;//二同号复选
    public static final int JIANGXIK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT = 101320;//二不同单式
    public static final int JIANGXIK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT = 101321;//二不同组合
    public static final int JIANGXIK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT = 101340;//三不同单式
    public static final int JIANGXIK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT = 101341;//三不同组合
    public static final int JIANGXIK3_LOTTERY_SANLIANHAO_TONG_ID_INT = 101350;//三连号通选
    public static final int JIANGXIK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT = 101342;//三不同胆拖
    public static final int JIANGXIK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT = 101322;//二不同号胆拖

    /** 吉林快三 **/
    public static final int JILINK3_LOTTERY_ID_INT = 1014;
    public static final int JILINK3_LOTTERY_SUMGROUP_ID_INT = 101461;
    public static final int JILINK3_LOTTERY_SUMZHI_ID_INT = 101460;//和值
    public static final int JILINK3_LOTTERY_ERTONGHAO_DAN_ID_INT = 101410;//二同号单式
    public static final int JILINK3_LOTTERY_ERTONGHAO_FU_ID_INT = 101411;//二同号复选
    public static final int JILINK3_LOTTERY_ERTONGHAO_ZU_ID_INT = 101412;//二同号单选组合
    public static final int JILINK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT = 101420;//二不同单式
    public static final int JILINK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT = 101421;//二不同组合
    public static final int JILINK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT = 101422;//二不同号胆拖
    public static final int JILINK3_LOTTERY_SANTONGHAO_ID_INT = 101430;//三同号单式
    public static final int JILINK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT = 101440;//三不同单式
    public static final int JILINK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT = 101441;//三不同组合
    public static final int JILINK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT = 101442;//三不同胆拖
    public static final int JILINK3_LOTTERY_SANTONGHAO_TONG_ID_INT = 101432;//三同号通选
    public static final int JILINK3_LOTTERY_SANLIANHAO_TONG_ID_INT = 101450;//三连号通选

    /** 广西快三 欢乐快三 **/
    public static final int GUANGXIK3_LOTTERY_ID_INT = 1010;
    public static final int GUANGXIK3_LOTTERY_SUMGROUP_ID_INT = 101061;
    public static final int GUANGXIK3_LOTTERY_SUMZHI_ID_INT = 101060;//和值
    public static final int GUANGXIK3_LOTTERY_ERTONGHAO_DAN_ID_INT = 101010;//二同号单式
    public static final int GUANGXIK3_LOTTERY_ERTONGHAO_FU_ID_INT = 101011;//二同号复选
    public static final int GUANGXIK3_LOTTERY_ERTONGHAO_ZU_ID_INT = 101012;//二同号单选组合
    public static final int GUANGXIK3_LOTTERY_ERBUTONGHAO_DAN_ID_INT = 101020;//二不同单式
    public static final int GUANGXIK3_LOTTERY_ERBUTONGHAO_ZU_ID_INT = 101021;//二不同组合
    public static final int GUANGXIK3_LOTTERY_ERBUTONGHAO_TOWED_ID_INT = 101022;//二不同号胆拖
    public static final int GUANGXIK3_LOTTERY_SANTONGHAO_ID_INT = 101030;//三同号单式
    public static final int GUANGXIK3_LOTTERY_SANBUTONGHAO_DAN_ID_INT = 101040;//三不同单式
    public static final int GUANGXIK3_LOTTERY_SANBUTONGHAO_ZU_ID_INT = 101041;//三不同组合
    public static final int GUANGXIK3_LOTTERY_SANBUTONGHAO_TOWED_ID_INT = 101042;//三不同胆拖
    public static final int GUANGXIK3_LOTTERY_SANTONGHAO_TONG_ID_INT = 101032;//三同号通选
    public static final int GUANGXIK3_LOTTERY_SANLIANHAO_TONG_ID_INT = 101050;//三连号通选

    /** 七星彩 **/
    public static final int QXC_LOTTERY_ID_INT = 2004;
    public static final int QXC_LOTTERY_COMMON_DAN_ID_INT = 200401;
    public static final int QXC_LOTTERY_COMMON_FU_ID_INT = 200402;

    /** 排列五 ** */
    public static final int PL5_LOTTERY_ID_INT = 2003;
    public static final int PL5_LOTTERY_COMMON_DAN_ID_INT = 200301;
    public static final int PL5_LOTTERY_COMMON_FU_ID_INT = 200302;

    /** 排列三 **/
    public static final int PL3_LOTTERY_ID_INT = 2002;
    public static final int PL3_LOTTERY_COMMON_DAN_ID_INT = 200201;// 直选单式
    public static final int PL3_LOTTERY_COMMON_FU_ID_INT = 200211;// 直选复式
    public static final int PL3_LOTTERY_ZHIXUAN_SUM_ID_INT = 200221;// 直选和值
    public static final int PL3_LOTTERY_ZUSAN_DAN_ID_INT = 200202;// 组三单式
    public static final int PL3_LOTTERY_ZUSAN_FU_ID_INT = 200212;// 组三复式
    public static final int PL3_LOTTERY_ZUSAN_SUM_ID_INT = 200222;// 组三和值
    public static final int PL3_LOTTERY_ZULIU_DAN_ID_INT = 200203;// 组六单式
    public static final int PL3_LOTTERY_ZULIU_FU_ID_INT = 200213;// 组六复式
    public static final int PL3_LOTTERY_ZULIU_SUM_ID_INT = 200223;// 组六和值

    public static final int PL3_LOTTERY_COMMON_HUN_ID_INT = 200280;
    public static final int PL3_LOTTERY_ZULIU_HUN_ID_INT = 200290;

    /* 大乐透******************* */
    public static final int DLT_LOTTERY_ID_INT = 2001;
    public static final int DLT_LOTTERY_COMMON_DAN_ID_INT = 200101;
    public static final int DLT_LOTTERY_COMMON_FU_ID_INT = 200102;
    public static final int DLT_LOTTERY_TOWED_ID_INT = 200103;

    public static final int[] currentIDs = {SSQ_LOTTERY_ID_INT, FC3D_LOTTERY_ID_INT, KLSF_LOTTERY_ID_INT, QLC_LOTTERY_ID_INT, NXK3_LOTTERY_ID_INT, QXC_LOTTERY_ID_INT, PL5_LOTTERY_ID_INT, PL3_LOTTERY_ID_INT, DLT_LOTTERY_ID_INT};


	/* 竞彩蓝球********************** */

    public static final int JLSF_LOTTERY_ID_INT = 3001;
    public static final int JLRSF_LOTTERY_ID_INT = 3002;
    public static final int JLSFC_LOTTERY_ID_INT = 3003;
    public static final int JLDXF_LOTTERY_ID_INT = 3004;
    public static final int JLHG_LOTTERY_ID_INT = 3005;

    /* 竞彩足球********************** */
    public static final int JZ_LOTTERY_ID_INT = 3011;

    public static final int JZRFSPF_LOTTERY_ID_INT = 3006;
    public static final int JZBF_LOTTERY_ID_INT = 3007;
    public static final int JZZJQ_LOTTERY_ID_INT = 3008;
    public static final int JZBQC_LOTTERY_ID_INT = 3009;
    public static final int JZSPF_LOTTERY_ID_INT = 3010;
    public static final int JZHH_LOTTERY_ID_INT = 3011;
    public static final int JZGJ_LOTTERY_ID_INT = 3012;
    public static final int JZGYJ_LOTTERY_ID_INT = 3013;

    public static final int JZEXY_LOTTERY_ID_INT = 3014; // 竞足二选一玩法（前端自定义）
    public static final int JZDCP_LOTTERY_ID_INT = 3015; // 竞足单关配玩法（前端自定义）

    /* 足彩************************ */
    public static final int ZCSFC_LOTTERY_ID_INT = 4001;
    public static final int ZCSFC_LOTTERY_COMMON_DAN_INT = 400101;
    public static final int ZCSFC_LOTTERY_COMMON_FU_INT = 400102;

    public static final int ZCRXJ_LOTTERY_ID_INT = 4002;
    public static final int ZCRXJ_LOTTERY_COMMON_DAN_INT = 400201;
    public static final int ZCRXJ_LOTTERY_COMMON_FU_INT = 400202;
    public static final int ZCRXJ_LOTTERY_COMMON_TOWED_INT = 400203;

    /**
     * 足彩进球彩
     */
    public static final int ZCJQC_LOTTERY_ID_INT = 4003;
    public static final int ZCJQC_LOTTERY_COMMON_DAN_INT = 400301;
    public static final int ZCJQC_LOTTERY_COMMON_FU_INT = 400302;

    /**
     * 足彩六场半
     */
    public static final int ZCLCB_LOTTERY_ID_INT = 4004;
    public static final int ZCLCB_LOTTERY_COMMON_DAN_INT = 400401;
    public static final int ZCLCB_LOTTERY_COMMON_FU_INT = 400402;

    /* 单场************************ */
    public static final int DCSPF_LOTTERY_ID_INT = 5001;
    public static final int DCZJQ_LOTTERY_ID_INT = 5002;
    public static final int DCBQC_LOTTERY_ID_INT = 5003;
    public static final int DCSXDS_LOTTERY_ID_INT = 5004;
    public static final int DCBF_LOTTERY_ID_INT = 5005;

    /**
     * 北单胜负过关（只会在PC端投注）
     */
    public static final int DCSFGG_LOTTERY_ID_INT = 5006;

    /* 高频彩 山东11选5************************ */
    public static final int GP11XUAN5_LOTTERY_ID_INT = 2007;
    public static final int GP11XUAN5_LOTTERY_RENER_DAN_ID_INT = 200702;// 任二单式
    public static final int GP11XUAN5_LOTTERY_RENER_FU_ID_INT = 200712;// 任二复式
    public static final int GP11XUAN5_LOTTERY_RENER_TOWED_ID_INT = 200722;// 任选二胆拖
    public static final int GP11XUAN5_LOTTERY_RENSAN_DAN_ID_INT = 200703;// 任选三单式
    public static final int GP11XUAN5_LOTTERY_RENSAN_FU_ID_INT = 200713;// 任选三复式
    public static final int GP11XUAN5_LOTTERY_RENSAN_TOWED_ID_INT = 200723;// 任选三胆拖
    public static final int GP11XUAN5_LOTTERY_RENSI_DAN_ID_INT = 200704;// 任选四单式
    public static final int GP11XUAN5_LOTTERY_RENSI_FU_ID_INT = 200714;// 任选四复式
    public static final int GP11XUAN5_LOTTERY_RENSI_TOWED_ID_INT = 200724;// 任选四胆拖
    public static final int GP11XUAN5_LOTTERY_RENWU_DAN_ID_INT = 200705;// 任选五单式
    public static final int GP11XUAN5_LOTTERY_RENWU_FU_ID_INT = 200715;// 任选五复式
    public static final int GP11XUAN5_LOTTERY_RENWU_TOWED_ID_INT = 200725;// 任选五胆拖
    public static final int GP11XUAN5_LOTTERY_RENLIU_DAN_ID_INT = 200706;// 任选六单式
    public static final int GP11XUAN5_LOTTERY_RENLIU_FU_ID_INT = 200716;// 任选六复式
    public static final int GP11XUAN5_LOTTERY_RENLIU_TOWED_ID_INT = 200726;// 任选六胆拖
    public static final int GP11XUAN5_LOTTERY_RENQI_DAN_ID_INT = 200707;// 任选七单式
    public static final int GP11XUAN5_LOTTERY_RENQI_FU_ID_INT = 200717;// 任选七复式
    public static final int GP11XUAN5_LOTTERY_RENQI_TOWED_ID_INT = 200727;// 任选七胆拖
    public static final int GP11XUAN5_LOTTERY_RENBA_DAN_ID_INT = 200708;// 任选八单式
    public static final int GP11XUAN5_LOTTERY_RENBA_FU_ID_INT = 200718;// 任选八复式
    public static final int GP11XUAN5_LOTTERY_RENBA_TOWED_ID_INT = 200728;// 任选八胆拖
    public static final int GP11XUAN5_LOTTERY_QIANYI_DAN_ID_INT = 200731;// 前一单式
    public static final int GP11XUAN5_LOTTERY_QIANYI_FU_ID_INT = 200741;// 前一复式
    public static final int GP11XUAN5_LOTTERY_QIANER_DAN_ID_INT = 200732;// 前二单式
    public static final int GP11XUAN5_LOTTERY_QIANER_FU_ID_INT = 200742;// 前二复式
    public static final int GP11XUAN5_LOTTERY_QIANER_ZU_DAN_ID_INT = 200734;// 前二组选单式
    public static final int GP11XUAN5_LOTTERY_QIANER_ZU_FU_ID_INT = 200744;// 前二组选复式
    public static final int GP11XUAN5_LOTTERY_QIANER_ZU_TOWED_ID_INT = 200754;// 前二组选胆拖
    public static final int GP11XUAN5_LOTTERY_QIANSAN_DAN_ID_INT = 200733;// 前三单式
    public static final int GP11XUAN5_LOTTERY_QIANSAN_FU_ID_INT = 200743;// 前三复式
    public static final int GP11XUAN5_LOTTERY_QIANSAN_ZU_DAN_ID_INT = 200735;// 前三组选单式
    public static final int GP11XUAN5_LOTTERY_QIANSAN_ZU_FU_ID_INT = 200745;// 前三组选复式
    public static final int GP11XUAN5_LOTTERY_QIANSAN_ZU_TOWED_ID_INT = 200755;// 前三组选胆拖

    /* 高频彩 广东11选5************************ */
    public static final int GP11XUAN5_GD_LOTTERY_ID_INT = 2005;
    public static final int GP11XUAN5_GD_LOTTERY_RENER_DAN_ID_INT = 200502;// 任二单式
    public static final int GP11XUAN5_GD_LOTTERY_RENER_FU_ID_INT = 200512;// 任二复式
    public static final int GP11XUAN5_GD_LOTTERY_RENER_TOWED_ID_INT = 200522;// 任选二胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENSAN_DAN_ID_INT = 200503;// 任选三单式
    public static final int GP11XUAN5_GD_LOTTERY_RENSAN_FU_ID_INT = 200513;// 任选三复式
    public static final int GP11XUAN5_GD_LOTTERY_RENSAN_TOWED_ID_INT = 200523;// 任选三胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENSI_DAN_ID_INT = 200504;// 任选四单式
    public static final int GP11XUAN5_GD_LOTTERY_RENSI_FU_ID_INT = 200514;// 任选四复式
    public static final int GP11XUAN5_GD_LOTTERY_RENSI_TOWED_ID_INT = 200524;// 任选四胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENWU_DAN_ID_INT = 200505;// 任选五单式
    public static final int GP11XUAN5_GD_LOTTERY_RENWU_FU_ID_INT = 200515;// 任选五复式
    public static final int GP11XUAN5_GD_LOTTERY_RENWU_TOWED_ID_INT = 200525;// 任选五胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENLIU_DAN_ID_INT = 200506;// 任选六单式
    public static final int GP11XUAN5_GD_LOTTERY_RENLIU_FU_ID_INT = 200516;// 任选六复式
    public static final int GP11XUAN5_GD_LOTTERY_RENLIU_TOWED_ID_INT = 200526;// 任选六胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENQI_DAN_ID_INT = 200507;// 任选七单式
    public static final int GP11XUAN5_GD_LOTTERY_RENQI_FU_ID_INT = 200517;// 任选七复式
    public static final int GP11XUAN5_GD_LOTTERY_RENQI_TOWED_ID_INT = 200527;// 任选七胆拖
    public static final int GP11XUAN5_GD_LOTTERY_RENBA_DAN_ID_INT = 200508;// 任选八单式
    public static final int GP11XUAN5_GD_LOTTERY_RENBA_FU_ID_INT = 200518;// 任选八复式
    public static final int GP11XUAN5_GD_LOTTERY_RENBA_TOWED_ID_INT = 200528;// 任选八胆拖
    public static final int GP11XUAN5_GD_LOTTERY_QIANYI_DAN_ID_INT = 200531;// 前一单式
    public static final int GP11XUAN5_GD_LOTTERY_QIANYI_FU_ID_INT = 200541;// 前一复式
    public static final int GP11XUAN5_GD_LOTTERY_QIANER_DAN_ID_INT = 200532;// 前二单式
    public static final int GP11XUAN5_GD_LOTTERY_QIANER_FU_ID_INT = 200542;// 前二复式
    public static final int GP11XUAN5_GD_LOTTERY_QIANER_ZU_DAN_ID_INT = 200534;// 前二组选单式
    public static final int GP11XUAN5_GD_LOTTERY_QIANER_ZU_FU_ID_INT = 200544;// 前二组选复式
    public static final int GP11XUAN5_GD_LOTTERY_QIANER_ZU_TOWED_ID_INT = 200554;// 前二组选胆拖
    public static final int GP11XUAN5_GD_LOTTERY_QIANSAN_DAN_ID_INT = 200533;// 前三单式
    public static final int GP11XUAN5_GD_LOTTERY_QIANSAN_FU_ID_INT = 200543;// 前三复式
    public static final int GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_DAN_ID_INT = 200535;// 前三组选单式
    public static final int GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_FU_ID_INT = 200545;// 前三组选复式
    public static final int GP11XUAN5_GD_LOTTERY_QIANSAN_ZU_TOWED_ID_INT = 200555;// 前三组选胆拖

    /* 高频彩 湖北11选5************************ */
    public static final int GP11XUAN5_HB_LOTTERY_ID_INT = 2010;
    public static final int GP11XUAN5_HB_LOTTERY_RENER_DAN_ID_INT = 201002;// 任二单式
    public static final int GP11XUAN5_HB_LOTTERY_RENER_FU_ID_INT = 201012;// 任二复式
    public static final int GP11XUAN5_HB_LOTTERY_RENER_TOWED_ID_INT = 201022;// 任选二胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENSAN_DAN_ID_INT = 201003;// 任选三单式
    public static final int GP11XUAN5_HB_LOTTERY_RENSAN_FU_ID_INT = 201013;// 任选三复式
    public static final int GP11XUAN5_HB_LOTTERY_RENSAN_TOWED_ID_INT = 201023;// 任选三胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENSI_DAN_ID_INT = 201004;// 任选四单式
    public static final int GP11XUAN5_HB_LOTTERY_RENSI_FU_ID_INT = 201014;// 任选四复式
    public static final int GP11XUAN5_HB_LOTTERY_RENSI_TOWED_ID_INT = 201024;// 任选四胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENWU_DAN_ID_INT = 201005;// 任选五单式
    public static final int GP11XUAN5_HB_LOTTERY_RENWU_FU_ID_INT = 201015;// 任选五复式
    public static final int GP11XUAN5_HB_LOTTERY_RENWU_TOWED_ID_INT = 201025;// 任选五胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENLIU_DAN_ID_INT = 201006;// 任选六单式
    public static final int GP11XUAN5_HB_LOTTERY_RENLIU_FU_ID_INT = 201016;// 任选六复式
    public static final int GP11XUAN5_HB_LOTTERY_RENLIU_TOWED_ID_INT = 201026;// 任选六胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENQI_DAN_ID_INT = 201007;// 任选七单式
    public static final int GP11XUAN5_HB_LOTTERY_RENQI_FU_ID_INT = 201017;// 任选七复式
    public static final int GP11XUAN5_HB_LOTTERY_RENQI_TOWED_ID_INT = 201027;// 任选七胆拖
    public static final int GP11XUAN5_HB_LOTTERY_RENBA_DAN_ID_INT = 201008;// 任选八单式
    public static final int GP11XUAN5_HB_LOTTERY_RENBA_FU_ID_INT = 201018;// 任选八复式
    public static final int GP11XUAN5_HB_LOTTERY_RENBA_TOWED_ID_INT = 201028;// 任选八胆拖
    public static final int GP11XUAN5_HB_LOTTERY_QIANYI_DAN_ID_INT = 201031;// 前一单式
    public static final int GP11XUAN5_HB_LOTTERY_QIANYI_FU_ID_INT = 201041;// 前一复式
    public static final int GP11XUAN5_HB_LOTTERY_QIANER_DAN_ID_INT = 201032;// 前二单式
    public static final int GP11XUAN5_HB_LOTTERY_QIANER_FU_ID_INT = 201042;// 前二复式
    public static final int GP11XUAN5_HB_LOTTERY_QIANER_ZU_DAN_ID_INT = 201034;// 前二组选单式
    public static final int GP11XUAN5_HB_LOTTERY_QIANER_ZU_FU_ID_INT = 201044;// 前二组选复式
    public static final int GP11XUAN5_HB_LOTTERY_QIANER_ZU_TOWED_ID_INT = 201054;// 前二组选胆拖
    public static final int GP11XUAN5_HB_LOTTERY_QIANSAN_DAN_ID_INT = 201033;// 前三单式
    public static final int GP11XUAN5_HB_LOTTERY_QIANSAN_FU_ID_INT = 201043;// 前三复式
    public static final int GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_DAN_ID_INT = 201035;// 前三组选单式
    public static final int GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_FU_ID_INT = 201045;// 前三组选复式
    public static final int GP11XUAN5_HB_LOTTERY_QIANSAN_ZU_TOWED_ID_INT = 201055;// 前三组选胆拖

    /* 高频彩 江西11选5************************ */
    public static final int GP11XUAN5_JX_LOTTERY_ID_INT = 2006;
    public static final int GP11XUAN5_JX_LOTTERY_RENER_DAN_ID_INT = 200602;// 任二单式
    public static final int GP11XUAN5_JX_LOTTERY_RENER_FU_ID_INT = 200612;// 任二复式
    public static final int GP11XUAN5_JX_LOTTERY_RENER_TOWED_ID_INT = 200622;// 任选二胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENSAN_DAN_ID_INT = 200603;// 任选三单式
    public static final int GP11XUAN5_JX_LOTTERY_RENSAN_FU_ID_INT = 200613;// 任选三复式
    public static final int GP11XUAN5_JX_LOTTERY_RENSAN_TOWED_ID_INT = 200623;// 任选三胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENSI_DAN_ID_INT = 200604;// 任选四单式
    public static final int GP11XUAN5_JX_LOTTERY_RENSI_FU_ID_INT = 200614;// 任选四复式
    public static final int GP11XUAN5_JX_LOTTERY_RENSI_TOWED_ID_INT = 200624;// 任选四胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENWU_DAN_ID_INT = 200605;// 任选五单式
    public static final int GP11XUAN5_JX_LOTTERY_RENWU_FU_ID_INT = 200615;// 任选五复式
    public static final int GP11XUAN5_JX_LOTTERY_RENWU_TOWED_ID_INT = 200625;// 任选五胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENLIU_DAN_ID_INT = 200606;// 任选六单式
    public static final int GP11XUAN5_JX_LOTTERY_RENLIU_FU_ID_INT = 200616;// 任选六复式
    public static final int GP11XUAN5_JX_LOTTERY_RENLIU_TOWED_ID_INT = 200626;// 任选六胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENQI_DAN_ID_INT = 200607;// 任选七单式
    public static final int GP11XUAN5_JX_LOTTERY_RENQI_FU_ID_INT = 200617;// 任选七复式
    public static final int GP11XUAN5_JX_LOTTERY_RENQI_TOWED_ID_INT = 200627;// 任选七胆拖
    public static final int GP11XUAN5_JX_LOTTERY_RENBA_DAN_ID_INT = 200608;// 任选八单式
    public static final int GP11XUAN5_JX_LOTTERY_RENBA_FU_ID_INT = 200618;// 任选八复式
    public static final int GP11XUAN5_JX_LOTTERY_RENBA_TOWED_ID_INT = 200628;// 任选八胆拖
    public static final int GP11XUAN5_JX_LOTTERY_QIANYI_DAN_ID_INT = 200631;// 前一单式
    public static final int GP11XUAN5_JX_LOTTERY_QIANYI_FU_ID_INT = 200641;// 前一复式
    public static final int GP11XUAN5_JX_LOTTERY_QIANER_DAN_ID_INT = 200632;// 前二单式
    public static final int GP11XUAN5_JX_LOTTERY_QIANER_FU_ID_INT = 200642;// 前二复式
    public static final int GP11XUAN5_JX_LOTTERY_QIANER_ZU_DAN_ID_INT = 200634;// 前二组选单式
    public static final int GP11XUAN5_JX_LOTTERY_QIANER_ZU_FU_ID_INT = 200644;// 前二组选复式
    public static final int GP11XUAN5_JX_LOTTERY_QIANER_ZU_TOWED_ID_INT = 200654;// 前二组选胆拖
    public static final int GP11XUAN5_JX_LOTTERY_QIANSAN_DAN_ID_INT = 200633;// 前三单式
    public static final int GP11XUAN5_JX_LOTTERY_QIANSAN_FU_ID_INT = 200643;// 前三复式
    public static final int GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_DAN_ID_INT = 200635;// 前三组选单式
    public static final int GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_FU_ID_INT = 200645;// 前三组选复式
    public static final int GP11XUAN5_JX_LOTTERY_QIANSAN_ZU_TOWED_ID_INT = 200655;// 前三组选胆拖

    /* 高频彩 广西11选5************************ */
    public static final int GP11XUAN5_GX_LOTTERY_ID_INT = 2011;
    public static final int GP11XUAN5_GX_LOTTERY_RENER_DAN_ID_INT = 201102;// 任二单式
    public static final int GP11XUAN5_GX_LOTTERY_RENER_FU_ID_INT = 201112;// 任二复式
    public static final int GP11XUAN5_GX_LOTTERY_RENER_TOWED_ID_INT = 201122;// 任选二胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENSAN_DAN_ID_INT = 201103;// 任选三单式
    public static final int GP11XUAN5_GX_LOTTERY_RENSAN_FU_ID_INT = 201113;// 任选三复式
    public static final int GP11XUAN5_GX_LOTTERY_RENSAN_TOWED_ID_INT = 201123;// 任选三胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENSI_DAN_ID_INT = 201104;// 任选四单式
    public static final int GP11XUAN5_GX_LOTTERY_RENSI_FU_ID_INT = 201114;// 任选四复式
    public static final int GP11XUAN5_GX_LOTTERY_RENSI_TOWED_ID_INT = 201124;// 任选四胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENWU_DAN_ID_INT = 201105;// 任选五单式
    public static final int GP11XUAN5_GX_LOTTERY_RENWU_FU_ID_INT = 201115;// 任选五复式
    public static final int GP11XUAN5_GX_LOTTERY_RENWU_TOWED_ID_INT = 201125;// 任选五胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENLIU_DAN_ID_INT = 201106;// 任选六单式
    public static final int GP11XUAN5_GX_LOTTERY_RENLIU_FU_ID_INT = 201116;// 任选六复式
    public static final int GP11XUAN5_GX_LOTTERY_RENLIU_TOWED_ID_INT = 201126;// 任选六胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENQI_DAN_ID_INT = 201107;// 任选七单式
    public static final int GP11XUAN5_GX_LOTTERY_RENQI_FU_ID_INT = 201117;// 任选七复式
    public static final int GP11XUAN5_GX_LOTTERY_RENQI_TOWED_ID_INT = 201127;// 任选七胆拖
    public static final int GP11XUAN5_GX_LOTTERY_RENBA_DAN_ID_INT = 201108;// 任选八单式
    public static final int GP11XUAN5_GX_LOTTERY_RENBA_FU_ID_INT = 201118;// 任选八复式
    public static final int GP11XUAN5_GX_LOTTERY_RENBA_TOWED_ID_INT = 201128;// 任选八胆拖
    public static final int GP11XUAN5_GX_LOTTERY_QIANYI_DAN_ID_INT = 201131;// 前一单式
    public static final int GP11XUAN5_GX_LOTTERY_QIANYI_FU_ID_INT = 201141;// 前一复式
    public static final int GP11XUAN5_GX_LOTTERY_QIANER_DAN_ID_INT = 201132;// 前二单式
    public static final int GP11XUAN5_GX_LOTTERY_QIANER_FU_ID_INT = 201142;// 前二复式
    public static final int GP11XUAN5_GX_LOTTERY_QIANER_ZU_DAN_ID_INT = 201134;// 前二组选单式
    public static final int GP11XUAN5_GX_LOTTERY_QIANER_ZU_FU_ID_INT = 201144;// 前二组选复式
    public static final int GP11XUAN5_GX_LOTTERY_QIANER_ZU_TOWED_ID_INT = 201154;// 前二组选胆拖
    public static final int GP11XUAN5_GX_LOTTERY_QIANSAN_DAN_ID_INT = 201133;// 前三单式
    public static final int GP11XUAN5_GX_LOTTERY_QIANSAN_FU_ID_INT = 201143;// 前三复式
    public static final int GP11XUAN5_GX_LOTTERY_QIANSAN_ZU_DAN_ID_INT = 201135;// 前三组选单式
    public static final int GP11XUAN5_GX_LOTTERY_QIANSAN_ZU_FU_ID_INT = 201145;// 前三组选复式
    public static final int GP11XUAN5_GX_LOTTERY_QIANSAN_ZU_TOWED_ID_INT = 201155;// 前三组选胆拖

    /* 高频彩 重庆时时彩************************ */
    public static final int CQSSC_LOTTERY_ID_INT = 1007;
    public static final int CQSSC_LOTTERY_ID_YX_DAN_INT = 100701;// 一星单式
    public static final int CQSSC_LOTTERY_ID_YX_FU_INT = 100711;// 一星复式
    public static final int CQSSC_LOTTERY_ID_EX_DAN_INT = 100702;// 二星单式
    public static final int CQSSC_LOTTERY_ID_EX_FU_INT = 100712;// 二星复式
    public static final int CQSSC_LOTTERY_ID_SX_DAN_INT = 100703;// 三星单式
    public static final int CQSSC_LOTTERY_ID_SX_FU_INT = 100713;// 三星复式
    public static final int CQSSC_LOTTERY_ID_ZS_DAN_INT = 100706;// 组三单式
    public static final int CQSSC_LOTTERY_ID_ZL_DAN_INT = 100707;// 组六单式
    public static final int CQSSC_LOTTERY_ID_EX_HE_INT = 100721;// 二星直选和值
    public static final int CQSSC_LOTTERY_ID_EXZU_HE_INT = 100720;// 二星组选和值
    public static final int CQSSC_LOTTERY_ID_SX_HE_INT = 100722;// 三星直选和值
    public static final int CQSSC_LOTTERY_ID_EX_ZU_INT = 100723;// 二星组选
    public static final int CQSSC_LOTTERY_ID_ZUSAN_BAO_INT = 100724;// 组三包号
    public static final int CQSSC_LOTTERY_ID_ZULIU_BAO_INT = 100725;// 组六包号
    public static final int CQSSC_LOTTERY_ID_WXTX_INT = 100727;// 五星通选
    public static final int CQSSC_LOTTERY_ID_WX_DAN_INT = 100705;// 五星单式
    public static final int CQSSC_LOTTERY_ID_WX_FU_INT = 100715;// 五星复式
    public static final int CQSSC_LOTTERY_ID_DXDS_INT = 100726;// 大小单双

    /* 高频彩 江西时时彩************************ */
    public static final int JXSSC_LOTTERY_ID_INT = 1011;
    public static final int JXSSC_LOTTERY_ID_YX_DAN_INT = 101101;// 一星单式
    public static final int JXSSC_LOTTERY_ID_YX_FU_INT = 101111;// 一星复式
    public static final int JXSSC_LOTTERY_ID_EX_DAN_INT = 101102;// 二星单式
    public static final int JXSSC_LOTTERY_ID_EX_FU_INT = 101112;// 二星复式
    public static final int JXSSC_LOTTERY_ID_SX_DAN_INT = 101103;// 三星单式
    public static final int JXSSC_LOTTERY_ID_SX_FU_INT = 101113;// 三星复式
    public static final int JXSSC_LOTTERY_ID_ZS_DAN_INT = 101106;// 组三单式
    public static final int JXSSC_LOTTERY_ID_ZL_DAN_INT = 101107;// 组六单式
    public static final int JXSSC_LOTTERY_ID_EX_HE_INT = 101121;// 二星直选和值
    public static final int JXSSC_LOTTERY_ID_EX_ZU_INT = 101123;// 二星组选
    public static final int JXSSC_LOTTERY_ID_ZUSAN_BAO_INT = 101124;// 组三包号
    public static final int JXSSC_LOTTERY_ID_ZULIU_BAO_INT = 101125;// 组六包号
    public static final int JXSSC_LOTTERY_ID_WXTX_INT = 101127;// 五星通选
    public static final int JXSSC_LOTTERY_ID_WX_DAN_INT = 101105;// 五星单式
    public static final int JXSSC_LOTTERY_ID_WX_FU_INT = 101115;// 五星复式
    public static final int JXSSC_LOTTERY_ID_DXDS_INT = 101126;// 大小单双

    /* 高频彩 时时彩************************ */
    public static int GPSSC_LOTTERY_ID_INT = 1007;
    public static int GPSSC_LOTTERY_ID_YX_DAN_INT = 100701;// 一星单式
    public static int GPSSC_LOTTERY_ID_YX_FU_INT = 100711;// 一星复式
    public static int GPSSC_LOTTERY_ID_EX_DAN_INT = 100702;// 二星单式
    public static int GPSSC_LOTTERY_ID_EX_FU_INT = 100712;// 二星复式
    public static int GPSSC_LOTTERY_ID_SX_DAN_INT = 100703;// 三星单式
    public static int GPSSC_LOTTERY_ID_SX_FU_INT = 100713;// 三星复式
    public static int GPSSC_LOTTERY_ID_ZS_DAN_INT = 100706;// 组三单式
    public static int GPSSC_LOTTERY_ID_ZL_DAN_INT = 100707;// 组六单式
    public static int GPSSC_LOTTERY_ID_EX_HE_INT = 100721;// 二星直选和值
    public static int GPSSC_LOTTERY_ID_EXZU_HE_INT = 100720;// 二星组选和值
    public static int GPSSC_LOTTERY_ID_SX_HE_INT = 100722;// 三星直选和值
    public static int GPSSC_LOTTERY_ID_EX_ZU_INT = 100723;// 二星组选
    public static int GPSSC_LOTTERY_ID_ZUSAN_BAO_INT = 100724;// 组三包号
    public static int GPSSC_LOTTERY_ID_ZULIU_BAO_INT = 100725;// 组六包号
    public static int GPSSC_LOTTERY_ID_WXTX_INT = 100727;// 五星通选
    public static int GPSSC_LOTTERY_ID_WX_DAN_INT = 100705;// 五星单式
    public static int GPSSC_LOTTERY_ID_WX_FU_INT = 100715;// 五星复式
    public static int GPSSC_LOTTERY_ID_DXDS_INT = 100726;// 大小单双


    /* 其它************************ */
    public static final int LOTTERY_MORE_INT = 999910;
    /* 合买************************ */
    public static final int HEMAI_LOTTERY_ID_INT = 999911;// 待修改


    public static final String SSQ_LOTTERY_TYPE_STRING = "1001";
    public static final String JCZQ_LOTTERY_TYPE_STRING = "jczq";   // 竞彩足球
    public static final String JCLQ_LOTTERY_TYPE_STRING = "jclq";   // 竞彩篮球
    public static final String BJDC_LOTTERY_TYPE_STRING = "bjdc";   // 北京单场


    public boolean isSSq(int lotteryId) {
        if (lotteryId == SSQ_LOTTERY_ID_INT || lotteryId == SSQ_LOTTERY_COMMON_DAN_ID_INT //
                || lotteryId == SSQ_LOTTERY_COMMON_FU_ID_INT || lotteryId == SSQ_LOTTERY_TOWED_ID_INT //
                || lotteryId == SSQ_LOTTERY_COMMON_HUN_ID_INT) {
            return true;
        }
        return false;
    }
}
