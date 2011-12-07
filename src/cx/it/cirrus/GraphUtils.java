package cx.it.cirrus;

import java.util.Iterator;
import java.util.Set;

import com.androidplot.Plot;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.series.XYSeries;
import com.androidplot.xy.*;

import java.text.*;
import java.util.Arrays;
import java.util.Date;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

public class GraphUtils {
    
    public static void initalizePlot(XYPlot mySimpleXYPlot){
        mySimpleXYPlot.getGraphWidget().getGridBackgroundPaint()
                .setColor(Color.GRAY);
        mySimpleXYPlot.getGraphWidget().getGridLinePaint()
                .setColor(Color.BLACK);
        mySimpleXYPlot.getGraphWidget().getGridLinePaint()
                .setPathEffect(new DashPathEffect(new float[] { 1, 1 }, 1));
        mySimpleXYPlot.getGraphWidget().getDomainOriginLinePaint()
                .setColor(Color.BLACK);
        mySimpleXYPlot.getGraphWidget().getRangeOriginLinePaint()
                .setColor(Color.BLACK);
        
        mySimpleXYPlot.setBorderStyle(Plot.BorderStyle.SQUARE, null, null);
        mySimpleXYPlot.getBorderPaint().setStrokeWidth(1);
        mySimpleXYPlot.getBorderPaint().setAntiAlias(false);
        mySimpleXYPlot.getBorderPaint().setColor(Color.WHITE);
        
        // Create a formatter to use for drawing a series using
        // LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 100, 0), // line color
                Color.rgb(0, 100, 0), // point color
                Color.rgb(100, 200, 0)); // fill color
        
        
        mySimpleXYPlot.getGraphWidget().setPaddingRight(2);
        
        // draw a domain ticks:
        mySimpleXYPlot.setDomainStep(XYStepMode.SUBDIVIDE, 10);
        
        // customize our domain/range labels
        mySimpleXYPlot.setDomainLabel("Time");
        mySimpleXYPlot.setRangeLabel("MeterUsage");
        
        // round to 2 decimal points
        mySimpleXYPlot.setRangeValueFormat(new DecimalFormat("2"));
        
        mySimpleXYPlot.setDomainValueFormat(new myDateFormat());
        
        // by default, AndroidPlot displays developer guides to aid in laying
        // out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
        
        mySimpleXYPlot.redraw();
        
    }

    public static void setMeterConsumptionPlot(XYPlot mySimpleXYPlot, Number[][] meterArray, Number[][] consumptionArray) {
         
        if( meterArray == null ){
            System.out.println("Got null meterData");
            return;
        }
        if( meterArray[0] == null){
            System.out.println("Got null meterArray[0]");
            return;
        }
        if( meterArray[0] == null){
            System.out.println("Got null meterArray[1]");
            return;
        }

        removeAllXYSeries(mySimpleXYPlot);

        Number[] vals = meterArray[0];
        Number[] timestamps = meterArray[1];
        
        // create our series from our Arrays:
        XYSeries series1 = new SimpleXYSeries(Arrays.asList(timestamps),
                Arrays.asList(vals), "Meter Reading");
        
        Paint lineFill = new Paint();
        // setup our line fill paint to be a slightly transparent gradient:
        lineFill.setAlpha(200);
        lineFill.setShader(new LinearGradient(0, 0, 0, 250, Color.WHITE,
                Color.GREEN, Shader.TileMode.MIRROR));


        LineAndPointFormatter formatter = new LineAndPointFormatter(Color.rgb(
                0, 0, 0), Color.BLUE, Color.RED);
        formatter.setFillPaint(lineFill);

        mySimpleXYPlot.addSeries(series1, formatter);
        
        mySimpleXYPlot.redraw();
    }
    
    private static class myDateFormat extends Format {
        
        private static final long serialVersionUID = 0;
        // create a simple date format that draws on the month and year
        // portion of our timestamp.
        private static SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/yy");
        
        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo,
                FieldPosition pos) {
            long timestamp = ((Number) obj).longValue();
            Date date = new Date(timestamp);
            return dateFormat.format(date, toAppendTo, pos);
        }
        
        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
            
        }
        
    }

    public static void removeAllXYSeries(XYPlot myXYPlot){
        
        Set<XYSeries> seriesSet = myXYPlot.getSeriesSet();
        Iterator<XYSeries> it = seriesSet.iterator();
        while (it.hasNext()){
            myXYPlot.removeSeries(it.next());
        }

    } 
    
}
