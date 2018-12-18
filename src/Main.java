import plot.Plot;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
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
