package ua.edu.ucu.tempseries;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TempSummaryStatistics {
    private double avgTemperature;
    private double devTemperature;
    private double minTemperature;
    private double maxTemperature;

    TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp){
        avgTemp = avgTemperature;
        devTemp = devTemperature;
        minTemp = minTemperature;
        maxTemp = maxTemperature;
    }
}
