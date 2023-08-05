/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;

import static org.jfree.chart.demo.MinMaxCategoryPlotDemo1.createChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

import org.jfree.data.category.DefaultCategoryDataset;
import service.HoaDonService;

/**
 *
 * @author ACER
 */
public class ThongKeTongTien extends JPanel {

    private static final int NUM_MONTHS = 12;
    private static HoaDonService hoaDonService = new HoaDonService();

    public static void main(String[] args) {
        List<Double> dataList = new ArrayList<>();
        for (int i = 1; i <= NUM_MONTHS; i++) {
            dataList.addAll(hoaDonService.thongKeTongTienThang(i));
        }

        DefaultCategoryDataset dataset = createDataset(dataList);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        JFrame frame = new JFrame("Biểu đồ đường");
        frame.getContentPane().add(chartPanel);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static DefaultCategoryDataset createDataset(List<Double> dataList) {
        String[] monthNames = new String[]{"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
            double value = (i < dataList.size()) ? dataList.get(i) : 0;
            dataset.addValue(value, "Số Tiền", monthNames[i]);
        }
        return dataset;
    }

    static JFreeChart createChart(DefaultCategoryDataset dataset) {
        String chartTitle = "Tổng tiền bán hàng trong năm";
        String categoryAxisLabel = "Tháng";
        String valueAxisLabel = "Tổng Tiền";
        JFreeChart chart = ChartFactory.createBarChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        CategoryAxis categoryAxis = plot.getDomainAxis();
        categoryAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);

        return chart;
    }
}
