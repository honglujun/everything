package com.example.everything.order.service.impl.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;

/**
 * 折线图
 *
 * @author win10
 */
public class ConLineChart {
    private DefaultCategoryDataset dataSet;

    /**
     * 传入基本数据集合，key为横坐标值，value为纵坐标值
     *
     * @param dataSet
     */
    public ConLineChart(LinkedHashMap<String, Integer> dataSet) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        if (!CollectionUtils.isEmpty(dataSet)) {
            dataSet.forEach((key, value) -> {
                String v = value == null ? "0" : value.toString();
                //rowKey为分类信息
                defaultCategoryDataset.setValue(Double.parseDouble(v), "", key);
            });
        }
        this.dataSet = defaultCategoryDataset;
    }

    /**
     * 生成图片的ByteArrayInputStream
     *
     * @param title            标题
     * @param isShowDataLabels 是否显示数值
     * @return
     */
    public ByteArrayOutputStream createChart(String title, Boolean isShowDataLabels) {
        //1. 创建Chart,legend表示底部信息
        ChartFactory.setChartTheme(JFreeChartUtils.getChartTheme());
        JFreeChart chart = ChartFactory.createLineChart(title, "", "", this.dataSet, PlotOrientation.VERTICAL, false, false, false);
        //2. 设置抗锯齿，防止字体不清楚
        JFreeChartUtils.setAntiAlias(chart);
        //3. 对折线点或者柱子进行渲染，并设置是否显示折线点和数量值
        JFreeChartUtils.setLineRender(chart.getCategoryPlot(), isShowDataLabels, false, 4F);
        //4. 对其他部分渲染
        JFreeChartUtils.setAxisX(chart.getCategoryPlot());
        JFreeChartUtils.setAxisY(chart.getCategoryPlot());
        //5. 生成图片字节流
        return JFreeChartUtils.createByteArrayOutputStream(chart);
    }


    public static void main(String[] args) throws IOException {

        // 创建图形
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("11月19日", 22);
        map.put("11月20日", 31);
        map.put("11月21日", 21);
        map.put("11月22日", 36);
        map.put("11月23日", 25);
        map.put("11月24日", 13);
        map.put("11月25日", 15);
        ByteArrayOutputStream bos = new ConLineChart(map).createChart("舆情走势图", true);
        byte[] bytes = bos.toByteArray();
        OutputStream outputStream = new FileOutputStream(new File("D:/line.png"));
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        /*Base64.Encoder encoder = Base64.getEncoder();
        String img = encoder.encodeToString(bytes);
        System.out.println(img);*/
    }
}
