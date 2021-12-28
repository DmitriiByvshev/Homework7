import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println(CityNumber.sendCityIdRequest("Saint Petersburg"));
        System.out.println(WeatherDays.sendTempRequest("295212"));
        DbHandler dbHandler = new DbHandler();
    }

}
