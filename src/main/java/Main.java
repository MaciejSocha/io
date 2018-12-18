import importdata.Curl;
import importdata.JsonRead;
import org.apache.commons.io.FileUtils;
import plot.DrawPlot;
import plot.Plot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Curl curl = new Curl("https://gnuplot.000webhostapp.com/ballotResult/0.json");
        curl.getData(null);

        File f = new File("out.json");
        String in = null;
        try {
            in = FileUtils.readFileToString(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonRead jsonRead = new JsonRead(in);

        Map<String, Double> map = jsonRead.read();

        DrawPlot dp = new DrawPlot(map);
        dp.draw("obr");
    }

    private void plotTest() {
        System.out.println("Hello World!");
        Plot plot = Plot.plot(null).series("test1", Plot.data().xy(1,2).xy(2,3), null);
        try {
            plot.save("test1", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Plot plot2 = Plot.plot(Plot.plotOpts().
                title("TEST2").
                legend(Plot.LegendFormat.BOTTOM)).
                xAxis("x", Plot.axisOpts().
                        range(0, 5)).
                yAxis("y", Plot.axisOpts().
                        range(0, 5)).
                series("Data", Plot.data().
                                xy(1, 2).
                                xy(3, 4),
                        Plot.seriesOpts().
                                marker(Plot.Marker.DIAMOND).
                                markerColor(Color.GREEN).
                                color(Color.BLACK));

        try {
            plot2.save("test2", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
