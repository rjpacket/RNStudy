package com.rjp.shell.utils;

import android.content.Context;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.model.Cell;
import com.rjp.shell.model.CellGroup;
import com.rjp.shell.model.OpenPrizeModel;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.type;
import static com.rjp.shell.utils.LotteryTypeUtils.DLT;
import static com.rjp.shell.utils.LotteryTypeUtils.FC3D;
import static com.rjp.shell.utils.LotteryTypeUtils.K3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL5;
import static com.rjp.shell.utils.LotteryTypeUtils.QLC;
import static com.rjp.shell.utils.LotteryTypeUtils.QXC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSQ;
import static com.rjp.shell.utils.LotteryTypeUtils.X115;

/**
 * author : Gimpo create on 2018/4/11 11:45
 * email  : jimbo922@163.com
 */

public class TrendUtils {

    @Deprecated
    private static List<Cell> getTopCells(int redColor, int blueColor) {
        switch (type) {
            case SSQ:
                return ssqTopCells(redColor, blueColor);
            case DLT:
                return dltTopCells(redColor, blueColor);
            case SSC:
                return sscTopCells(redColor);
            case K3:
                return k3TopCells(redColor);
            case FC3D:
                return fc3dTopCells(redColor);
            case X115:
                return x115TopCells(redColor);
            case PL3:
                return pl3TopCells(redColor);
            case PL5:
                return pl5TopCells(redColor);
            case QXC:
                return qxcTopCells(redColor);
            case QLC:
                return qlcTopCells(redColor);
        }
        return null;
    }

    /**
     * 七乐彩
     */
    public static List<Cell> qlcTopCells(int color) {
        return getTopCells(1, 30, true, color);
    }

    /**
     * 七星彩
     */
    public static List<Cell> qxcTopCells(int color) {
        return getTopCells(0, 9, true, color);
    }

    /**
     * 排列五
     */
    public static List<Cell> pl5TopCells(int color) {
        return getTopCells(0, 9, true, color);
    }

    /**
     * 排列三
     */
    public static List<Cell> pl3TopCells(int color) {
        return getTopCells(0, 9, true, color);
    }

    /**
     * 11选5
     */
    public static List<Cell> x115TopCells(int color) {
        return getTopCells(1, 11, true, color);
    }

    /**
     * 福彩3D
     */
    public static List<Cell> fc3dTopCells(int color) {
        return getTopCells(0, 9, true, color);
    }

    /**
     * 快三
     */
    public static List<Cell> k3TopCells(int color) {
        return getTopCells(1, 6, false, color);
    }

    /**
     * 大乐透
     */
    public static List<Cell> dltTopCells(int redColor, int blueColor) {
        List<Cell> topCells = new ArrayList<>();
        topCells.addAll(dltRedTopCells(redColor));
        topCells.add(new Cell());
        topCells.addAll(dltBlueTopCells(blueColor));
        return topCells;
    }

    /**
     * 大乐透红球
     *
     * @param color
     * @return
     */
    public static List<Cell> dltRedTopCells(int color) {
        return getTopCells(1, 35, true, color);
    }

    /**
     * 大乐透蓝球
     *
     * @param color
     * @return
     */
    public static List<Cell> dltBlueTopCells(int color) {
        return getTopCells(1, 12, true, color);
    }

    /**
     * 时时彩
     *
     * @param color
     * @return
     */
    public static List<Cell> sscTopCells(int color) {
        return getTopCells(0, 9, false, color);
    }

    /**
     * 双色球顶部cells集合
     *
     * @return
     */
    public static List<Cell> ssqTopCells(int redColor, int blueColor) {
        List<Cell> topCells = new ArrayList<>();
        topCells.addAll(ssqRedTopCells(redColor));
        topCells.add(new Cell());
        topCells.addAll(ssqBlueTopCells(blueColor));
        return topCells;
    }

    /**
     * 双色球红球
     *
     * @param redColor
     * @return
     */
    public static List<Cell> ssqRedTopCells(int redColor) {
        return getTopCells(1, 33, true, redColor);
    }

    /**
     * 双色球蓝球
     *
     * @param blueColor
     * @return
     */
    public static List<Cell> ssqBlueTopCells(int blueColor) {
        return getTopCells(1, 16, true, blueColor);
    }

    /**
     * 通用写法
     *
     * @param start  开始数字
     * @param end    结束数字
     * @param isZero 是否补零
     * @param color  颜色
     * @return 返回cells
     */
    private static List<Cell> getTopCells(int start, int end, boolean isZero, int color) {
        List<Cell> topCells = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            Cell cell = new Cell();
            cell.setNumber(isZero ? String.format("%02d", i) : String.valueOf(i));
            cell.setColor(color);
            topCells.add(cell);
        }
        return topCells;
    }

    /**
     * 七星彩第7位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc7CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 6);
    }

    /**
     * 七星彩第6位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc6CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 5);
    }

    /**
     * 七星彩第5位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc5CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 4);
    }

    /**
     * 七星彩第4位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc4CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 3);
    }

    /**
     * 七星彩第3位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc3CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 2);
    }

    /**
     * 七星彩第2位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc2CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 1);
    }

    /**
     * 七星彩第1位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> qxc1CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_qxc.json", 0);
    }

    /**
     * 排列五个位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl5GeCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl5.json", 4);
    }

    /**
     * 排列五十位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl5ShiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl5.json", 3);
    }

    /**
     * 排列五百位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl5BaiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl5.json", 2);
    }

    /**
     * 排列五千位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl5QianCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl5.json", 1);
    }

    /**
     * 排列五万位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl5WanCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl5.json", 0);
    }

    /**
     * 排列三个位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl3GeCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl3.json", 2);
    }

    /**
     * 排列三十位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl3ShiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl3.json", 1);
    }

    /**
     * 排列三百位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> pl3BaiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_pl3.json", 0);
    }

    /**
     * 115个位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> x115GeCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 11, true, color, "open_hubei115.json", 4);
    }

    /**
     * 115十位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> x115ShiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 11, true, color, "open_hubei115.json", 3);
    }

    /**
     * 115百位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> x115BaiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 11, true, color, "open_hubei115.json", 2);
    }

    /**
     * 115千位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> x115QianCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 11, true, color, "open_hubei115.json", 1);
    }

    /**
     * 115万位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> x115WanCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 11, true, color, "open_hubei115.json", 0);
    }

    /**
     * 福彩个位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> fc3dGeCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_fc3d.json", 2);
    }

    /**
     * 福彩十位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> fc3dShiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_fc3d.json", 1);
    }

    /**
     * 福彩百位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> fc3dBaiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, true, color, "open_fc3d.json", 0);
    }

    /**
     * 快三第三位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> k33CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 6, false, color, "open_jilink3.json", 2);
    }

    /**
     * 快三第二位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> k32CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 6, false, color, "open_jilink3.json", 1);
    }

    /**
     * 快三第一位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> k31CellGroups(Context mContext, int color){
        return getCellGroups(mContext, 1, 6, false, color, "open_jilink3.json", 0);
    }

    /**
     * 时时彩个位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> sscGeCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, false, color, "open_ssc.json", 4);
    }

    /**
     * 时时彩十位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> sscShiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, false, color, "open_ssc.json", 3);
    }

    /**
     * 时时彩百位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> sscBaiCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, false, color, "open_ssc.json", 2);
    }

    /**
     * 时时彩千位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> sscQianCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, false, color, "open_ssc.json", 1);
    }

    /**
     * 时时彩万位走势图
     * @param mContext
     * @param color
     * @return
     */
    public static List<CellGroup> sscWanCellGroups(Context mContext, int color){
        return getCellGroups(mContext, 0, 9, false, color, "open_ssc.json", 0);
    }

    /**
     * 通用的获取cellGroup的方法
     *
     * @param mContext
     * @param start
     * @param end
     * @param isZero
     * @param color
     * @param assetsName
     * @param index
     * @return
     */
    private static List<CellGroup> getCellGroups(Context mContext, int start, int end, boolean isZero, int color, String assetsName, int index) {
        String assets = FileUtils.getAssets(mContext, assetsName);
        List<OpenPrizeModel> models = JSONArray.parseArray(assets, OpenPrizeModel.class);
        List<CellGroup> cellGroups = new ArrayList<>();
        Cell preCell = null;
        for (OpenPrizeModel model : models) {
            List<Cell> cells = new ArrayList<>();
            CellGroup group = new CellGroup();
            group.setTitle("第" + model.getPhase() + "期");
            String wincode = model.getWincode();
            String[] redNum = wincode.split(",");

            for (int i = start; i < end; i++) {
                Cell cell = new Cell();
                String format = isZero ? String.format("%02d", i) : String.valueOf(i);
                cell.setNumber(format);
                cell.setColor(color);
                if (format.equals(redNum[index])) {
                    cell.setSelected(true);
                    cell.setNextCell(preCell);
                    preCell = cell;
                }
                cells.add(cell);
            }
            group.setCells(cells);
            cellGroups.add(group);
        }
        return cellGroups;
    }

    /**
     * 大乐透
     * @param mContext
     * @return
     */
    private static List<CellGroup> dltCellGroups(Context mContext) {
        String assets = FileUtils.getAssets(mContext, "open_dlt.json");
        List<OpenPrizeModel> models = JSONArray.parseArray(assets, OpenPrizeModel.class);
        List<CellGroup> cellGroups = new ArrayList<>();
        Cell preCell = null;
        for (OpenPrizeModel model : models) {
            List<Cell> cells = new ArrayList<>();
            CellGroup group = new CellGroup();
            group.setTitle("第" + model.getPhase() + "期");
            String wincode = model.getWincode();
            String[] split = wincode.split("\\|");
            String[] redNum = split[0].split(",");

            for (int i = 1; i <= 35; i++) {
                Cell cell = new Cell();
                String format = String.format("%02d", i);
                cell.setNumber(format);
                cell.setColor(mContext.getResources().getColor(R.color.number_red));
                for (String zhong : redNum) {
                    if (format.equals(zhong)) {
                        cell.setSelected(true);
                        break;
                    }
                }
                cells.add(cell);
            }
            cells.add(new Cell());
            for (int i = 1; i <= 12; i++) {
                Cell cell = new Cell();
                String format = String.format("%02d", i);
                cell.setNumber(format);
                cell.setColor(mContext.getResources().getColor(R.color.number_blue));
                cell.setSelected(format.equals(split[1]));
                if (cell.isSelected()) {
                    cell.setNextCell(preCell);
                    preCell = cell;
                }
                cells.add(cell);
            }
            group.setCells(cells);
            cellGroups.add(group);
        }
        return cellGroups;
    }

    /**
     * 双色球走势图数据集合
     *
     * @param mContext
     * @return
     */
    public static List<CellGroup> ssqCellGroups(Context mContext) {
        String assets = FileUtils.getAssets(mContext, "open_ssq.json");
        List<OpenPrizeModel> models = JSONArray.parseArray(assets, OpenPrizeModel.class);
        List<CellGroup> cellGroups = new ArrayList<>();
        Cell preCell = null;
        for (OpenPrizeModel model : models) {
            List<Cell> cells = new ArrayList<>();
            CellGroup group = new CellGroup();
            group.setTitle("第" + model.getPhase() + "期");
            String wincode = model.getWincode();
            String[] split = wincode.split("\\|");
            String[] redNum = split[0].split(",");

            for (int i = 1; i <= 33; i++) {
                Cell cell = new Cell();
                String format = String.format("%02d", i);
                cell.setNumber(format);
                cell.setColor(mContext.getResources().getColor(R.color.number_red));
                for (String zhong : redNum) {
                    if (format.equals(zhong)) {
                        cell.setSelected(true);
                        break;
                    }
                }
                cells.add(cell);
            }
            cells.add(new Cell());
            for (int i = 1; i <= 16; i++) {
                Cell cell = new Cell();
                String format = String.format("%02d", i);
                cell.setNumber(format);
                cell.setColor(mContext.getResources().getColor(R.color.number_blue));
                cell.setSelected(format.equals(split[1]));
                if (cell.isSelected()) {
                    cell.setNextCell(preCell);
                    preCell = cell;
                }
                cells.add(cell);
            }
            group.setCells(cells);
            cellGroups.add(group);
        }
        return cellGroups;
    }

    /**
     * 七乐彩
     * @param mContext
     * @return
     */
    private static List<CellGroup> qlcCellGroups(Context mContext) {
        String assets = FileUtils.getAssets(mContext, "open_qlc.json");
        List<OpenPrizeModel> models = JSONArray.parseArray(assets, OpenPrizeModel.class);
        List<CellGroup> cellGroups = new ArrayList<>();
        Cell preCell = null;
        for (OpenPrizeModel model : models) {
            List<Cell> cells = new ArrayList<>();
            CellGroup group = new CellGroup();
            group.setTitle("第" + model.getPhase() + "期");
            String wincode = model.getWincode();
            String[] split = wincode.split("\\|");
            String[] redNum = split[0].split(",");

            for (int i = 1; i <= 30; i++) {
                Cell cell = new Cell();
                String format = String.format("%02d", i);
                cell.setNumber(format);
                for (String zhong : redNum) {
                    if (format.equals(zhong)) {
                        cell.setColor(mContext.getResources().getColor(R.color.number_red));
                        cell.setSelected(true);
                        break;
                    }
                }
                if (format.equals(split[1])) {
                    cell.setColor(mContext.getResources().getColor(R.color.number_blue));
                    cell.setSelected(true);
                }
                cells.add(cell);
            }
            group.setCells(cells);
            cellGroups.add(group);
        }
        return cellGroups;
    }
}
