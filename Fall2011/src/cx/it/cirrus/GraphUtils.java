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
    
    public static void initalizePlot(XYPlot myXYPlot) {
        myXYPlot.getGraphWidget().getGridBackgroundPaint().setColor(Color.GRAY);
        myXYPlot.getGraphWidget().getGridLinePaint().setColor(Color.BLACK);
        myXYPlot.getGraphWidget().getGridLinePaint()
                .setPathEffect(new DashPathEffect(new float[] { 1, 1 }, 1));
        myXYPlot.getGraphWidget().getDomainOriginLinePaint()
                .setColor(Color.BLACK);
        myXYPlot.getGraphWidget().getRangeOriginLinePaint()
                .setColor(Color.BLACK);
        
        myXYPlot.setBorderStyle(Plot.BorderStyle.SQUARE, null, null);
        myXYPlot.getBorderPaint().setStrokeWidth(1);
        myXYPlot.getBorderPaint().setAntiAlias(false);
        myXYPlot.getBorderPaint().setColor(Color.WHITE);
        
        myXYPlot.getGraphWidget().setPaddingRight(2);
        
        // draw a domain ticks:
        myXYPlot.setDomainStep(XYStepMode.SUBDIVIDE, 5);
        
        // customize our domain/range labels
        myXYPlot.setDomainLabel("Time");
        myXYPlot.setRangeLabel("MeterUsage");
        
        // round to 2 decimal points
        myXYPlot.setRangeValueFormat(new DecimalFormat("2"));
        
        myXYPlot.setDomainValueFormat(new myDateFormat());
        
        // by default, AndroidPlot displays developer guides to aid in laying
        // out your plot.
        // To get rid of them call disableAllMarkup():
        myXYPlot.disableAllMarkup();
        
        myXYPlot.redraw();
        
    }
    
    public static void setXYPlot(XYPlot myXYPlot,
            Number[][] myArray, String legandName ) {
        
        if (myArray == null) {
            System.out.println("Got null myArray");
            return;
        }
        if (myArray.length != 2) {
            System.out.println("Got malformed myArray");
            return;
        }
        
        removeAllXYSeries(myXYPlot);
        
        Number[] myVals = myArray[0];
        Number[] myTimestamps = myArray[1];
        
        // create our series from our Arrays:
        XYSeries mySeries = new SimpleXYSeries(
                Arrays.asList(myTimestamps), Arrays.asList(myVals),
                legandName);
        
        Paint myLineFill = new Paint();
        
        // setup our line fill paint to be a slightly transparent gradient:
        myLineFill.setAlpha(500);
        myLineFill.setShader(new LinearGradient(0, 0, 0, 250, Color.WHITE,
                Color.GREEN, Shader.TileMode.MIRROR));
        
        LineAndPointFormatter myFormatter = new LineAndPointFormatter(
                Color.rgb(0, 0, 0), Color.BLUE, Color.RED);
        myFormatter.setFillPaint(myLineFill);
        
        // add series to plot
        myXYPlot.addSeries(mySeries, myFormatter);
        
        // Redraw
        myXYPlot.redraw();
    }
    
    private static class myDateFormat extends Format {
        
        private static final long serialVersionUID = 0;
        // create a simple date format that draws on the month and year
        // portion of our timestamp.
        private static SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd/yy HH:mm");
        
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
    
    public static void removeAllXYSeries(XYPlot myXYPlot) {
        
        Set<XYSeries> seriesSet = myXYPlot.getSeriesSet();
        Iterator<XYSeries> it = seriesSet.iterator();
        while (it.hasNext()) {
            myXYPlot.removeSeries(it.next());
        }
        
    }
    
}
