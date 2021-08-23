package tec.bd.weather.imn;

import tec.bd.weather.model.Report;
import tec.bd.weather.openweather.OpenWeatherReport;
import tec.bd.weather.provider.BaseWeatherProvider;

public class IMNProvider extends BaseWeatherProvider<Report> {
    @Override
    protected Report fromProviderReport(Report providerReport) {
        return null;
    }

    @Override
    public Report byCity(String city) {
        var report = new Report();
        report.setCity("Heredia");
        report.setHumidity(86.65f);
        report.setPressure(1012.0f);
        report.setTemperature(294.9f);
        report.setMaxTemperature(295.44f);
        report.setMinTemperature(294.58f);
        return report;

    }

    @Override
    public Report byZipCode(String zipCode) {
        var report = new Report();
        report.setCity("Paris");
        report.setHumidity(86.0f);
        report.setPressure(1023.0f);
        report.setTemperature(289.49f);
        report.setMaxTemperature(291.05f);
        report.setMinTemperature(287.18f);
        return report;
    }

    protected Report fromProviderReport(IMNReport providerReport) {
        var report = new Report();
        report.setCity(providerReport.getCity());
        report.setHumidity(providerReport.getHumidity());
        report.setTemperature(providerReport.getPressure());
        report.setMaxTemperature(providerReport.getMaxTemperature());
        report.setMinTemperature(providerReport.getMinTemperature());
        return report;
    }

}
