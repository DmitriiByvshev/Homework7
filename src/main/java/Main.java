import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(CityNumber.sendCityIdRequest("Saint Petersburg"));
        System.out.println(WeatherDays.sendTempRequest("295212"));
    }

}
