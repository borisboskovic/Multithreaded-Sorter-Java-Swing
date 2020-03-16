package view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.RectangleInsets;

import global.Themes;
import settings.ColorTheme;

@SuppressWarnings("serial")
public class LineChartWindow extends JFrame {

	public LineChartWindow(DefaultXYDataset dataSet, String title, String xName, String yName) {
		JFreeChart chart = ChartFactory.createXYLineChart(title, xName, yName, dataSet, PlotOrientation.VERTICAL, true,
				true, false);

		ColorTheme th = Themes.getCurrentTheme();

		XYPlot plot = (XYPlot) chart.getPlot();

		XYSplineRenderer renderer = new XYSplineRenderer();
		renderer.setSeriesPaint(0, Themes.getCurrentTheme().getAccentColor());
		renderer.setSeriesStroke(0, new BasicStroke(3));
		plot.setRenderer(renderer);

		Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 2, 3 }, 0);
		plot.setDomainGridlineStroke(dashed);
		plot.setRangeGridlineStroke(dashed);
		plot.setRangeGridlinePaint(th.getThemeColor());
		plot.setDomainGridlinePaint(th.getThemeColor());
		plot.setBackgroundPaint(th.getTextSecondaryColor());

		ChartPanel chartPanel = new ChartPanel(chart);
		chart.setPadding(new RectangleInsets(10, 10, 10, 10));

		add(chartPanel);

		setTitle("Prikaz grafikona");	//TODO: Lokalizacija
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\images\\graph-icon.png"));
		setSize(new Dimension(800, 600));
		Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(new Point(scrnSize.width / 2 - getSize().width / 2, scrnSize.height / 2 - getSize().height / 2));
		setVisible(true);
	}

}
