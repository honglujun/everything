package com.example.everything.order.service.impl.chart;

import org.jfree.chart.renderer.category.BarRenderer;

import java.awt.Color;
import java.awt.Paint;


/**
 * 设置柱状图颜色
 *
 * @author win10
 */
public class CustomBarRender extends BarRenderer {
    private Paint[] colors = new Paint[5];

    /**
     * 自定义柱状图的颜色
     */
    public CustomBarRender() {
        Color blue = new Color(31, 121, 170);
        Color green = new Color(146, 208, 80);
        Color red = new Color(192, 0, 0);
        Color pink = new Color(244, 177, 131);
        Color yellow = new Color(255, 192, 0);
        colors[0] = blue;
        colors[1] = green;
        colors[2] = red;
        colors[3] = pink;
        colors[4] = yellow;
    }

    @Override
    public Paint getItemPaint(int row, int column) {
        return colors[column % colors.length];
    }

}
