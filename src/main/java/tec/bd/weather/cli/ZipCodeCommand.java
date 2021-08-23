package tec.bd.weather.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import retrofit2.Call;
import retrofit2.Retrofit;
import tec.bd.weather.ApplicationContext;
import tec.bd.weather.openweather.OpenWeatherReport;
import retrofit2.converter.gson.GsonConverterFactory;
import tec.bd.weather.openweather.IOpenWeatherResource;

import java.io.IOException;
import java.util.Map;

@Command(name = "zip", description = "Get weather forecast for zip code")
public class ZipCodeCommand implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCommand.class);

    private static ApplicationContext APP_CONTEXT = ApplicationContext.init();

    @Parameters(paramLabel = "<zip code>", description = "zip code to be resolved")
    private String zipCode;

    @Override
    public void run() {

        var weatherReport = APP_CONTEXT.getWeatherReport();
        var report = weatherReport.getByZipCode(zipCode);
        System.out.println(report);

    }
}
