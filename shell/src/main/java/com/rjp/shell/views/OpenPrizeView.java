package com.rjp.shell.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.rjp.shell.model.Cell;
import com.rjp.shell.model.WYOpenPrizeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Gimpo create on 2018/4/12 18:01
 * email  : jimbo922@163.com
 */

public class OpenPrizeView extends View {
    private WYOpenPrizeModel prizeModel;
    private List<Cell> cells = new ArrayList<>();
    private int space = 20;
    private int cellWidth = 80;
    private int cellHeight = 80;
    private int viewWidth;
    private int viewHeight;
    private Paint ballPaint;
    private Paint textPaint;
    private float txtMidValue;

    public OpenPrizeView(Context context) {
        this(context, null);
    }

    public OpenPrizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        ballPaint = new Paint();
        ballPaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(36);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        txtMidValue = (fontMetrics.top + fontMetrics.bottom) / 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(getPrizeModel() != null) {
            int size = cells.size();
            viewWidth = cellWidth * size + space * (size - 1);
            viewHeight = cellHeight;
            setMeasuredDimension(viewWidth, viewHeight);
            computeLocation();
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * 计算位置信息
     */
    private void computeLocation() {
        int size = cells.size();
        for (int i = 0; i < size; i++) {
            Cell cell = cells.get(i);
            int left = i * (cellWidth + space);
            cell.setLocation(left, left + cellWidth, 0, cellHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Cell cell : cells) {
            ballPaint.setColor(cell.getColor());
            canvas.drawCircle(cell.getCenterX(), cell.getCenterY(), cellWidth / 2, ballPaint);
            canvas.drawText(cell.getNumber(), cell.getCenterX(), cell.getCenterY() - txtMidValue, textPaint);
        }
    }

    public WYOpenPrizeModel getPrizeModel() {
        return prizeModel;
    }

    public void setPrizeModel(WYOpenPrizeModel prizeModel) {
        this.prizeModel = prizeModel;
        cells.clear();
        String awardNo = getPrizeModel().getAwardNo();
        if(awardNo.contains(":")){
            String[] split = awardNo.split(":");
            String[] reds = split[0].split(" ");
            String[] blues = split[1].split(" ");
            for (String red : reds) {
                cells.add(new Cell(red, Color.parseColor("#e03939")));
            }
            for (String blue : blues) {
                cells.add(new Cell(blue, Color.parseColor("#537bc9")));
            }
        }else{
            String[] nums = awardNo.split(" ");
            for (String num : nums) {
                cells.add(new Cell(num, Color.parseColor("#e03939")));
            }
        }
        requestLayout();
    }
}
