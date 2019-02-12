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
 * 柱状图
 * @author win10
 */
public class ConBarChart {
    private DefaultCategoryDataset dataSet;


    public ConBarChart(LinkedHashMap<String, Integer> dataSet) {
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

    public ByteArrayOutputStream createChart(String title) {
        //1.创建Chart,legend表示底部信息
        ChartFactory.setChartTheme(JFreeChartUtils.getChartTheme());
        JFreeChart chart = ChartFactory.createBarChart(title, "", "", this.dataSet, PlotOrientation.VERTICAL, false, false, false);
        //2. 设置抗锯齿，防止字体不清楚
        JFreeChartUtils.setAntiAlias(chart);
        //3. 对折线点或者柱子进行渲染，并设置是否显示折线点和数量值
        JFreeChartUtils.setBarRenderer(chart.getCategoryPlot(), true);
        //4. 对其他部分渲染
        JFreeChartUtils.setAxisX(chart.getCategoryPlot());
        JFreeChartUtils.setAxisY(chart.getCategoryPlot());
        //5. 生成图片字节流
        return JFreeChartUtils.createByteArrayOutputStream(chart);
    }

    public static void main(String[] args) throws IOException {
        // 创建图形
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("水体问题", 12);
        map.put("大气问题", 17);
        map.put("噪声问题", 60);
        map.put("固废危废", 30);
        map.put("其他", 110);
        ByteArrayOutputStream bos = new ConBarChart(map).createChart("舆情信息类别分布图");
        OutputStream outputStream = new FileOutputStream(new File("D:/bar.png"));
        outputStream.write(bos.toByteArray(), 0, bos.toByteArray().length);
        outputStream.flush();
        outputStream.close();
        /*byte[] bytes = bos.toByteArray();
        Base64.Encoder encoder = Base64.getEncoder();
        String img = encoder.encodeToString(bytes);
        System.out.println(img);*/
    }
}
