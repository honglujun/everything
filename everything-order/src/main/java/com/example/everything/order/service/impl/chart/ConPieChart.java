package com.example.everything.order.service.impl.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.util.CollectionUtils;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;


/**
 * 饼状图
 *
 * @author win10
 */
public class ConPieChart {
    private DefaultPieDataset dataSet;

    public ConPieChart(LinkedHashMap<String, Integer> dataSet) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        if (!CollectionUtils.isEmpty(dataSet)) {
            dataSet.forEach((key, value) -> {
                String v = value == null ? "0" : value.toString();
                defaultPieDataset.setValue(key, Double.parseDouble(v));
            });
        }
        this.dataSet = defaultPieDataset;
    }

    public ByteArrayOutputStream createChart(String title) {
        ChartFactory.setChartTheme(JFreeChartUtils.getChartTheme());
        JFreeChart chart = ChartFactory.createPieChart(title, this.dataSet, false, false, false);
        //抗锯齿
        JFreeChartUtils.setAntiAlias(chart);
        //渲染饼图
        JFreeChartUtils.setPieRender(chart.getPlot());
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("新闻", new Color(91, 155, 213));
        plot.setSectionPaint("论坛", Color.RED);
        plot.setSectionPaint("微博", new Color(112, 173, 71));
        plot.setSectionPaint("微信", Color.YELLOW);
        plot.setSectionPaint("电视", Color.PINK);
        plot.setSectionPaint("信访", Color.CYAN);
        //设置饼图连接线
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0},{1},{2}",
                NumberFormat.getInstance(),
                new DecimalFormat("0%")
        ));
        //5. 生成图片字节流
        return JFreeChartUtils.createByteArrayOutputStream(chart);
    }

    public static void main(String[] args) throws IOException {
        //1.创建图形
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("新闻", 72);
        map.put("论坛", 28);
        map.put("微博", 63);
        map.put("微信", 45);
        map.put("电视", 23);
        map.put("信访", 9);
        ByteArrayOutputStream bos = new ConPieChart(map).createChart("信息源占比图");
        byte[] bytes = bos.toByteArray();
        OutputStream outputStream = new FileOutputStream(new File("D:/pie.png"));
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        /*Base64.Encoder encoder = Base64.getEncoder();
        String img = encoder.encodeToString(bytes);
        System.out.println(img);*/

    }
}
