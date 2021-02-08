/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brunamedeiros
 */
public class WeatherStation {
    double[][][] temperatures = new double[10][12][30];
    
    private double getMean(double[] data){
        double sum = 0;
        for(int i = 0; i < data.length; sum += data[i++]);
        return sum/(data.length);
    }
    
    private double getMin(double[] data){
        double minValue = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] < minValue) minValue = data[i];
        }
        return minValue;
    }
    
    private double getMax(double[] data){
        double maxValue = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] > maxValue) maxValue = data[i];
        }
        return maxValue;
    }
    
    public void setMonthTemperatures(int year, int month, double[] temperatures){
        int yearIdx = year - 2011;       
        this.temperatures[yearIdx][month] = temperatures;
    }
    
    public void getTemperatureAverage(int year, int month){
        int yearIdx = year - 2011;
        double mean = getMean(temperatures[yearIdx][month]);
        
        System.out.printf("Temperature Average (%d/%d): " + mean);
    }

    public void getTemperatureMin(int year, int month){
        int yearIdx = year - 2011;
        double minValue = getMin(temperatures[yearIdx][month]);
        
        System.out.printf("Minimum Temperature for this month (%d/%d): " + minValue);
    }

    public void getTemperatureMax(int year, int month){
        int yearIdx = year - 2011;
        double maxValue = getMax(temperatures[yearIdx][month]);
        
        System.out.printf("Maximum Temperature for this month (%d/%d): " + maxValue);
    }
    
    public void getMonthReport(int year, int month){
        int yearIdx = year - 2011;
        for(int i = 0; i < 30; i++){
            System.out.println("Day " + (i+1) + ": " + temperatures[yearIdx][month][i++]);
        }
        
        getTemperatureAverage(year, month);
        getTemperatureMin(year, month);
        getTemperatureMax(year, month);
    }
}
