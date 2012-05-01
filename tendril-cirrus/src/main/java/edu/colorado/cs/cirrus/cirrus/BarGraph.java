package edu.colorado.cs.cirrus.cirrus;

import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;

import org.achartengine.chart.BarChart.Type;

import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;

import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import edu.colorado.cs.cirrus.domain.model.CostAndConsumptionComponent;

import android.content.Context;
import android.graphics.Color;

public class BarGraph {
    
    public static GraphicalView getBarGraphView(Context context, float[] ySeries, String title, String xLabel, String yLabel) {
        
 
        
        CategorySeries series = new CategorySeries("BarGraph");
        int max = 0;
        int min = (int) ySeries[0];
        for (int i = 0; i < ySeries.length; i++) {
            series.add((i+1) + "", ySeries[i]);
            if(ySeries[i] > max)
            	max = (int) ySeries[i];
            if(ySeries[i] < min)
            	min = (int) ySeries[i];
        }
        
        
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series.toXYSeries());
        
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        
        renderer.setDisplayChartValues(false);
        renderer.setChartValuesSpacing((float) 0.5);
        renderer.setColor(Color.parseColor("#8DC63F"));
        renderer.setChartValuesTextSize(16);
        
        mRenderer.setMarginsColor(Color.WHITE);
        mRenderer.setChartTitle(title);
        mRenderer.setXTitle(xLabel);
        mRenderer.setYTitle(yLabel);
        mRenderer.setChartTitleTextSize(22);
        mRenderer.setAxisTitleTextSize(18);
        mRenderer.setLabelsTextSize(18);
        mRenderer.setShowLegend(false);
        mRenderer.setPanEnabled(false, false);
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setLabelsColor(Color.BLACK);
        mRenderer.setShowLabels(true);
        mRenderer.setYAxisMin(.8*min);
        mRenderer.setYAxisMax(max + (max*.1));
        mRenderer.setXLabels(12);
        mRenderer.setMargins(new int[]{10, 30, 10, 10});
        mRenderer.setBarSpacing(0.1);
        
        mRenderer.addSeriesRenderer(renderer);
        
        GraphicalView view = ChartFactory.getBarChartView(context, dataset,
                                    mRenderer, Type.DEFAULT);
        
        
        
        return view;
    }
    
    public static GraphicalView getYearlyCostView(Context context, List<CostAndConsumptionComponent> componentList, String title){
    	
    	
    	float[] costArray = new float[componentList.size()];
    	int i = 0;
    	
    	for (CostAndConsumptionComponent c: componentList){
    		costArray[i] = c.getCost();
    		i++;
    	}
    	
    	return getBarGraphView(context, costArray, title, "Month", "USD");
    	
    }
    
    public static GraphicalView getYearlyConsumptionView(Context context, List<CostAndConsumptionComponent> componentList, String title){
    	
    	float[] consumptionArray = new float[componentList.size()];
    	int i = 0;
    	
    	for (CostAndConsumptionComponent c: componentList){
    		consumptionArray[i] = c.getConsumption();
    		i++;
    	}
    	
    	return getBarGraphView(context, consumptionArray, title, "Month", "kW");
    }
    
    
}
