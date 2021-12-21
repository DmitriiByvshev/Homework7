import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class WeatherDays {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_Key = "IXgzURErrEJJTvm6yZcwwsPO2HoAvcFP";

    public static String sendTempRequest(String cityId) throws IOException {

        String TempDay;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_Key)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

//        Response response = okHttpClient.newCall(request).execute();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();
        JsonNode tempNode = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Temperature");

        TempDay = tempNode.asText();

        return TempDay;
    }

}
