import org.sqlite.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHandler {

    private final String PATH_TO_BD = "jdbc:sqlite:src/main/resources/Weather.db";
    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_BD);
    }

    public void addWeather(WeatherDays weatherDays) throws SQLException {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "INSERT INTO weatherDay('City', 'Local Date','Weather Text', 'Temperature') VALUES(?, ?, ?, ?) "
        )){
            preparedStatement.setObject(1, WeatherDays.sendTempRequest("295212"));
            preparedStatement.execute();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
