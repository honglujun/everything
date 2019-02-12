package com.example.everything.order.service.impl.chart;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;


/**
 * 使用JFreeChart生成图表
 *
 * @author win10
 */
public class JFreeChartUtils {
    private static String NO_DATA_MSG = "无数据";
    /**
     * 配置统计图表的默认字体
     */
    private final static Font DEFAULT_FONT = new Font("宋体", Font.PLAIN, 17);
    private final static Font X_FONT = new Font("宋体", Font.BOLD, 14);
    private final static Font Y_FONT = new Font("宋体", Font.BOLD, 14);
    private final static Font KEY_FONT = new Font("宋体", Font.PLAIN, 14);
    private final static Font TITLE_FONT = new Font("宋体", Font.BOLD, 30);

    /**
     * 设置颜色
     */
    private static Color[] CHART_COLORS = {
            new Color(31, 129, 188), new Color(92, 92, 97), new Color(144, 237, 125), new Color(255, 188, 117),
            new Color(153, 158, 255), new Color(255, 117, 153), new Color(253, 236, 109), new Color(128, 133, 232),
            new Color(158, 90, 102), new Color(255, 204, 102)
    };

    public JFreeChartUtils() {
    }

    /**
     * 设置chartTheme，解决中文乱码
     *
     * @return
     */
    public static StandardChartTheme getChartTheme() {
        // 设置中文主题样式 解决乱码
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        // 设置标题字体
        chartTheme.setExtraLargeFont(TITLE_FONT);
        // 设置图例的字体
        chartTheme.setRegularFont(DEFAULT_FONT);
        // 设置轴向的字体
        chartTheme.setLargeFont(DEFAULT_FONT);
        chartTheme.setSmallFont(DEFAULT_FONT);
        chartTheme.setTitlePaint(new Color(51, 51, 51));
        chartTheme.setSubtitlePaint(new Color(85, 85, 85));
        // 设置标注
        chartTheme.setLegendBackgroundPaint(Color.WHITE);
        chartTheme.setLegendItemPaint(Color.BLACK);
        chartTheme.setChartBackgroundPaint(Color.WHITE);

        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
        // 绘制器颜色源
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS, OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        chartTheme.setDrawingSupplier(drawingSupplier);

        // 绘制区域
        chartTheme.setPlotBackgroundPaint(Color.WHITE);
        // 绘制区域外边框
        chartTheme.setPlotOutlinePaint(Color.WHITE);
        // 链接标签颜色
        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));
        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

        chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
        // X坐标轴垂直网格颜色
        chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));
        // Y坐标轴水平网格颜色
        chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));

        chartTheme.setBaselinePaint(Color.WHITE);
        // 不确定含义
        chartTheme.setCrosshairPaint(Color.BLUE);
        // 坐标轴标题文字颜色
        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));
        // 刻度数字
        chartTheme.setTickLabelPaint(new Color(67, 67, 72));
        // 设置柱状图渲染
        chartTheme.setBarPainter(new StandardBarPainter());
        // XYBar 渲染
        chartTheme.setXYBarPainter(new StandardXYBarPainter());

        chartTheme.setItemLabelPaint(Color.black);
        // 温度计
        chartTheme.setThermometerPaint(Color.white);

        return chartTheme;
    }

    /**
     * 必须设置文本抗锯齿
     */
    public static void setAntiAlias(JFreeChart chart) {
        chart.setTextAntiAlias(true);

    }


    /**
     * 设置图例无边框，默认黑色边框
     */
    public static void setLegendEmptyBorder(JFreeChart chart) {
        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));

    }

    /**
     * 是不是一个%形式的百分比
     *
     * @param str
     * @return
     */
    public static boolean isPercent(String str) {
        return str != null && (str.endsWith("%") && isNumber(str.substring(0, str.length() - 1)));
    }

    /**
     * 是不是一个数字
     */
    private static boolean isNumber(String str) {
        return str != null && str.matches("^[-+]?(([0-9]+)((([.]{0})([0-9]*))|(([.]{1})([0-9]+))))$");
    }

    /**
     * 设置 折线图样式
     *
     * @param plot             plot
     * @param isShowDataLabels 是否显示数据标签 默认不显示节点形状
     */
    public static void setLineRender(CategoryPlot plot, boolean isShowDataLabels) {
        setLineRender(plot, isShowDataLabels, false, 1.5F);
    }

    /**
     * 设置折线图样式
     *
     * @param plot             plot
     * @param isShowDataLabels 是否显示数据标签
     */
    public static void setLineRender(CategoryPlot plot, boolean isShowDataLabels, boolean isShapesVisible, Float width) {
        plot.setNoDataMessage(NO_DATA_MSG);
        plot.setNoDataMessageFont(DEFAULT_FONT);
        plot.setInsets(new RectangleInsets(10, 10, 0, 10), false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesStroke(0, new BasicStroke(width));
        if (isShowDataLabels) {
            renderer.setDefaultItemLabelsVisible(true);
            renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator(StandardCategoryItemLabelGenerator.DEFAULT_LABEL_FORMAT_STRING,
                    NumberFormat.getInstance()));
            // 位置
            renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BOTTOM_CENTER));
        }
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        TickUnitSource integerTickUnits = NumberAxis.createIntegerTickUnits();
        rangeAxis.setStandardTickUnits(integerTickUnits);
        // 数据点绘制形状
        renderer.setDefaultShapesVisible(isShapesVisible);
        setAxisX(plot);
        setAxisY(plot);

    }

    /**
     * 设置柱状图渲染
     */
    public static void setBarRenderer(CategoryPlot plot, boolean isShowDataLabels) {
        plot.setNoDataMessage(NO_DATA_MSG);
        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
        //使用自定义的render替换默认的
        CustomBarRender renderer = new CustomBarRender();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        // 设置柱子最大宽度
        renderer.setMaximumBarWidth(0.075);
        renderer.setItemMargin(0.1);
        if (isShowDataLabels) {
            renderer.setDefaultItemLabelsVisible(true);
        }
        renderer.setShadowVisible(false);
        plot.setRenderer(renderer);
        setAxisX(plot);
        setAxisY(plot);
    }


    /**
     * 设置饼状图渲染
     */
    public static void setPieRender(Plot plot) {
        plot.setNoDataMessage(NO_DATA_MSG);
        plot.setInsets(new RectangleInsets(10, 10, 5, 10));
        PiePlot piePlot = (PiePlot) plot;
        piePlot.setInsets(new RectangleInsets(0, 0, 0, 0));
        // 圆形
        piePlot.setCircular(true);
        // 简单标签(不设置的话是连接线)
        piePlot.setSimpleLabels(true);
        piePlot.setLabelGap(0.01);
        piePlot.setInteriorGap(0.05D);
        // 图例形状
        piePlot.setLegendItemShape(new Rectangle(10, 10));
        piePlot.setIgnoreNullValues(true);
        // 去掉背景色
        piePlot.setLabelBackgroundPaint(null);
        // 去掉阴影
        piePlot.setLabelShadowPaint(null);
        // 去掉边框
        piePlot.setLabelOutlinePaint(null);
        piePlot.setShadowPaint(null);
        // 0:category 1:value:2 :percentage
        // 显示标签数据
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0},{1},{2}"));
    }


    /**
     * 设置类别图表(CategoryPlot) X坐标轴线条颜色和样式
     */
    public static void setAxisX(CategoryPlot plot) {
        Color lineColor = new Color(31, 121, 170);
        // X坐标轴颜色
        plot.getDomainAxis().setAxisLinePaint(lineColor);
        // X坐标轴标记|竖线颜色
        plot.getDomainAxis().setTickMarkPaint(lineColor);

    }


    /**
     * 设置类别图表(CategoryPlot) Y坐标轴线条颜色和样式 同时防止数据无法显示
     */
    public static void setAxisY(CategoryPlot plot) {
        Color lineColor = new Color(192, 208, 224);
        ValueAxis axis = plot.getRangeAxis();
        // Y坐标轴颜色
        axis.setAxisLinePaint(lineColor);
        // Y坐标轴标记|竖线颜色
        axis.setTickMarkPaint(lineColor);
        // 隐藏Y刻度
        axis.setAxisLineVisible(false);
        axis.setTickMarksVisible(false);
        // Y轴网格线条
        plot.setRangeGridlinePaint(new Color(192, 192, 192));
        plot.setRangeGridlineStroke(new BasicStroke(1));
        // 设置顶部Y坐标轴间距,防止数据无法显示
        plot.getRangeAxis().setUpperMargin(0.1);
        // 设置底部Y坐标轴间距
        plot.getRangeAxis().setLowerMargin(0.1);

    }

    /**
     * 生成图片字节流
     *
     * @param chart
     * @return
     */
    public static ByteArrayOutputStream createByteArrayOutputStream(JFreeChart chart) {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        try {
            ChartUtils.writeChartAsJPEG(bas, 1.0f, chart, 800, 400, null);
            bas.flush();
            bas.close();
        } catch (IOException e) {
            try {
                bas.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return bas;
    }

}
