package pt.mankings.ies;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ListIterator;
import java.util.Iterator;

import pt.mankings.ies.ipma_client.CityForecast;
import pt.mankings.ies.ipma_client.IpmaCityForecast;
import pt.mankings.ies.ipma_client.IpmaDistritsIslands;
import pt.mankings.ies.ipma_client.IpmaService;
import pt.mankings.ies.ipma_client.PlaceData;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    public static void  main(String[] args) {
        if(args.length != 1) {
            System.err.println("Argument error! Please specify a valid city ID or city name.");
            System.exit(1);
        }

        int city_id = Integer.parseInt(args[0]);

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync1 = service.getForecastForACity(city_id);
        Call<IpmaDistritsIslands> callSync2 = service.getDistritsIslands();

        try {
            Response<IpmaCityForecast> apiResponse1 = callSync1.execute();
            Response<IpmaDistritsIslands> apiResponse2 = callSync2.execute();
            IpmaCityForecast forecast = apiResponse1.body();
            IpmaDistritsIslands places = apiResponse2.body();

            String city_name = null;
            ListIterator<PlaceData> placeIterator = places.getData().listIterator();
            while(placeIterator.hasNext()) {
                PlaceData place = placeIterator.next();
                if(place.getGlobalIdLocal() == city_id) {
                    city_name = place.getLocal();
                    break;
                }
            }

            if (forecast != null && city_name != null) {
                System.out.println("\n-------- Weather Forecast for " + city_name + " --------");
                ListIterator<CityForecast> dayIterator = forecast.getData().listIterator();
                for(int i = 0; i < 5; i++) {
                    CityForecast dayData = dayIterator.next();

                    System.out.println("    --- " + dayData.getForecastDate() + " ---");
                    System.out.printf("MaxTemp: %4.1f ºC%n", Double.parseDouble(dayData.getTMax()));
                    System.out.printf("MinTemp: %4.1f ºC%n", Double.parseDouble(dayData.getTMin()));
                    System.out.printf("ProbPrecip: %2.1f %% %n", Double.parseDouble(dayData.getPrecipitaProb()));
                    System.out.println();
                }
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}