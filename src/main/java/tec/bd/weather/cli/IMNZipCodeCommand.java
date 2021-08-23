package tec.bd.weather.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import tec.bd.weather.ApplicationContext;

@CommandLine.Command(name = "imn-zip", description = "Get weather forecast for zip code by IMN")
    public class IMNZipCodeCommand implements Runnable {

        private static final Logger LOGGER = LoggerFactory.getLogger(WeatherCommand.class);

        private static ApplicationContext APP_CONTEXT = ApplicationContext.initIMN();

        @CommandLine.Parameters(paramLabel = "<imn-zip code>", description = "zip code to be resolved")
        private String zipCode;

        @Override
        public void run() {

            var weatherReport = APP_CONTEXT.getWeatherReport();
            var report = weatherReport.getByZipCode(zipCode);
            System.out.println(report);

        }
}