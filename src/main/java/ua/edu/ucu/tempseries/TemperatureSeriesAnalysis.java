package ua.edu.ucu.tempseries;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class TemperatureSeriesAnalysis {

    double [] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries.clone();
    }

    public double average() {
        if(temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for(double temperature: temperatureSeries){
            sum += temperature;
        }
        return sum / temperatureSeries.length;
    }


    public double deviation() {
        if(temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double square_diff = 0;
        double mean = this.average();
        for(double temperature: temperatureSeries) {
            double curr = 0;
            curr = (mean - temperature) * (mean - temperature);
            square_diff += curr;
        }
        return sqrt(square_diff/(temperatureSeries.length-1));
    }


    public double min() {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double min = Double.POSITIVE_INFINITY;
        for(double temperature: temperatureSeries) {
            if(temperature < min){
                min = temperature;
            }
        }
        return min;
    }

    public double max() {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double max = Double.NEGATIVE_INFINITY;
        for(double temperature: temperatureSeries) {
            if(temperature > max){
                max = temperature;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double result = temperatureSeries[0];
        double diff = Double.POSITIVE_INFINITY;
        for(double temperature: temperatureSeries){
            if(abs(tempValue-temperature) < diff){
                diff = abs(temperature - tempValue);
                result = temperature;
            }
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] arr = new double[temperatureSeries.length];
        for(int temperature = 0; temperature < temperatureSeries.length; temperature++){
            if(temperatureSeries[temperature] < tempValue){
                arr[temperature] = temperatureSeries[temperature];
            }
        }
        return arr;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] arr = new double[temperatureSeries.length];
        for(int temperature = 0; temperature < temperatureSeries.length; temperature++){
            if(temperatureSeries[temperature] >= tempValue){
                arr[temperature] = temperatureSeries[temperature];
            }
        }
        return arr;
    }

    public TempSummaryStatistics summaryStatistics() {
        if(temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(this.average(), this.deviation(),
                this.min(), this.max());
    }

    public int addTemps(double... temps) {
        int index = temperatureSeries.length;
        for (double temp : temps){
            if(index == temperatureSeries.length) {
                int new_size = temperatureSeries.length*2;
                temperatureSeries = Arrays.copyOf(temperatureSeries, new_size);
            }
            temperatureSeries[index] = temp;
            index++;
        }
        return index;
    }
}
