import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class CityNumber {

   private static OkHttpClient okHttpClient = new OkHttpClient();
   private static ObjectMapper objectMapper = new ObjectMapper();
   private static final String API_Key = "IXgzURErrEJJTvm6yZcwwsPO2HoAvcFP";

      public static String sendCityIdRequest(String cityName) throws IOException {

          String cityId;

          HttpUrl httpUrl = new HttpUrl.Builder()
                  .scheme("http")
                  .host("dataservice.accuweather.com")
                  .addPathSegment("locations")
                  .addPathSegment("v1")
                  .addPathSegment("cities")
                  .addPathSegment("search")
                  .addQueryParameter("apikey", API_Key)
                  .addQueryParameter("q", cityName)
                  .build();

          Request request = new Request.Builder()
                  .addHeader("accept", "application/json")
                  .url(httpUrl)
                  .build();
          Response response = okHttpClient.newCall(request).execute();

          String responseJson = response.body().string();
          JsonNode cityIdNode = objectMapper
                  .readTree(responseJson)
                  .at("/0/Key");

          cityId = cityIdNode.asText();

          return cityId;
      }



}
