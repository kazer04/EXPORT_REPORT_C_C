/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP PC
 */
import java.awt.Color;
import java.awt.Font;
import net.sf.jasperreports.engine.JRAbstractChartCustomizer;

import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.TextAnchor;
import java.awt.Paint;
import java.awt.Color;
import java.awt.Paint;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
public class BarChartCustomizer extends JRAbstractChartCustomizer implements
        JRChartCustomizer {

    class CustomRenderer extends BarRenderer {

        /**
         * The colors.
         */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item. Overrides the default behaviour
         * inherited from AbstractSeriesRenderer.
         *
         * @param row the series.
         * @param column the category.
         *
         * @return The item color.
         */
        @Override
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }

    public void customize(JFreeChart chart, JRChart jasperChart) {
        /*
         BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
         renderer.setSeriesPaint(0, Color.green);
         renderer.setSeriesPaint(1, Color.orange);
         */
        if (jasperChart.getChartType() == JRChart.CHART_TYPE_PIE3D) {
            CategoryPlot catPlot = (CategoryPlot) chart.getPlot();
            CategoryDataset catDS = catPlot.getDataset();

            int columnCount = catDS.getColumnCount();
            Paint[] paint = new Paint[columnCount];

            for (int i = 0; i < catDS.getColumnCount(); i++) {

                //?????????????????
                if (catDS.getValue(0, i).floatValue() < 0) {
                    paint[i] = Color.red;
                } else {
                    paint[i] = Color.blue;
                }
            }
            CategoryItemRenderer categoryRenderer = new CustomRenderer(paint);
            catPlot.setRenderer(categoryRenderer);
        }
        //Chart is a bar chart
        if (jasperChart.getChartType() == JRChart.CHART_TYPE_BAR3D) {
            BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();

            //Remove shadow effect from bar
            renderer.setShadowVisible(false);

            //Set maximum bar width
            renderer.setMaximumBarWidth(0.10);
            renderer.setItemMargin(0.00);

            renderer.setSeriesPaint(0, new Color(0, 153, 0));
            renderer.setSeriesPaint(1, new Color(0, 255, 51));
//0 -255- 51
            //Create no data message
            CategoryPlot categoryplot = (CategoryPlot) chart.getCategoryPlot();
//categoryplot.setWeight(weight);
            categoryplot.setNoDataMessage("No data available");
            categoryplot.setNoDataMessageFont(new Font("SansSerif", Font.BOLD, 14));
            categoryplot.setNoDataMessagePaint(Color.WHITE);

            //Set background as transparent
            categoryplot.setBackgroundPaint(null);
            /*
             //Set left margin before first bar and right margin after last bar
             CategoryAxis OCategoryAxis = (CategoryAxis) chart.getCategoryPlot().getDomainAxis();

             OCategoryAxis.setLowerMargin(0.02f);
             OCategoryAxis.setUpperMargin(0.02f);
             */
            // log.debug("################## DEBUG info from BetterBarLabels ##################");
            // Gather all of the properties set on the chart object

            try {
                //  JRPropertiesMap pm = jasperChart.getPropertiesMap();
                double upperMargin = 0.02f;//(pm.getProperty("UpperMargin") == null) ? -1 : Double.parseDouble(pm.getProperty("UpperMargin"));
                float maximumCategoryLabelWidthRatio = 5;// (pm.getProperty("MaximumCategoryLabelWidthRatio") == null) ? -1 : Float.parseFloat(pm.getProperty("MaximumCategoryLabelWidthRatio"));
                float itemMargin = 0.00f;//(pm.getProperty("ItemMargin") == null) ? -1 : Float.parseFloat(pm.getProperty("ItemMargin"));
                int maximumCategoryLabelLines = 2;// (pm.getProperty("MaximumCategoryLabelLines") == null) ? -1 : Integer.parseInt(pm.getProperty("MaximumCategoryLabelLines"));
                boolean useIntegerTickUnits = true;//(pm.getProperty("IntegerTickUnits") == null || !pm.getProperty("IntegerTickUnits").equals("true")) ? false : true;
                //log.debug(pm);
                // System.out.println(pm);

                // This customizer works only with Category Plots (like Line Charts and Bar Charts).
                // It silently ignores all other chart types.
                Plot plot = chart.getPlot();
                if (plot instanceof CategoryPlot) {
                    CategoryPlot categoryPlot = (CategoryPlot) plot;
                    ValueAxis valueAxis = categoryPlot.getRangeAxis();
                    CategoryAxis categoryAxis = categoryPlot.getDomainAxis();

                    if (useIntegerTickUnits) {
                        valueAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                    }

                    // The default upper margin is 5%.
                    // This is nearly always no good if labels are displayed.
                    // We should calculate the height needed for the top label
                    // and then set the upper margin appropriately.
                    // Instead of doing that, we let the report designer choose a value.
                    // The value must be a percentage between 0 and 1.
                    if (upperMargin >= 0 && upperMargin <= 1) {
                        valueAxis.setUpperMargin(upperMargin);
                    }

                    // I don't know what the default MaximumCategoryLabelWidthRatio is,
                    // but it's too small in many cases.
                    if (maximumCategoryLabelWidthRatio > 0) {
                        categoryAxis.setMaximumCategoryLabelWidthRatio(maximumCategoryLabelWidthRatio);

                    }

                    // The ItemMargin is the space between bars within a single category.
                    // The default value is 10% (0.10).
                    // It's common to want this smaller.
                    if (categoryPlot.getRenderer() instanceof BarRenderer) {
                        BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
                        if (itemMargin >= 0 && itemMargin <= 1) {
                            barRenderer.setItemMargin(itemMargin);
                        }
                    }

                    // By default category labels are a single line.
                    if (maximumCategoryLabelLines > 0) {
                        categoryAxis.setMaximumCategoryLabelLines(maximumCategoryLabelLines);
                    }

                    renderer.setItemLabelsVisible(true);
                    final ItemLabelPosition p = new ItemLabelPosition(
                            ItemLabelAnchor.INSIDE12, TextAnchor.CENTER_RIGHT,
                            TextAnchor.CENTER_RIGHT, -Math.PI / 2.0
                    );
                    renderer.setPositiveItemLabelPosition(p);

                    final ItemLabelPosition p2 = new ItemLabelPosition(
                            ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT,
                            TextAnchor.CENTER_LEFT, -Math.PI / 2.0
                    );
                    renderer.setPositiveItemLabelPositionFallback(p2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
