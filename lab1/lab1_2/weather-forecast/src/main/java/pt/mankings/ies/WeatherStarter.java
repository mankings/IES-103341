package pt.mankings.ies;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import pt.mankings.ies.ipma_client.CityForecast;
import pt.mankings.ies.ipma_client.IpmaCityForecast;
import pt.mankings.ies.ipma_client.IpmaDistritsIslands;
import pt.mankings.ies.ipma_client.IpmaService;
import pt.mankings.ies.ipma_client.PlaceData;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ListIterator;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void  main(String[] args) {
        if(args.length != 1) {
            System.err.println("Argument error! Please specify a city ID as the only argument.");
            logger.error("Didn't provide a single argument");
            System.exit(1);
        }

        int city_id = 0;
        try {
            city_id = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
            System.err.println("Argument error! Expected and integer value.");
            logger.error("Didn't provide an integer");
            System.exit(1);
        }

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
            logger.info("Got response1");
            Response<IpmaDistritsIslands> apiResponse2 = callSync2.execute();
            logger.info("Got response2");
            IpmaCityForecast forecast = apiResponse1.body();
            IpmaDistritsIslands places = apiResponse2.body();

            String city_name = null;
            ListIterator<PlaceData> placeIterator = places.getData().listIterator();
            while(placeIterator.hasNext()) {
                PlaceData place = placeIterator.next();
                if(place.getGlobalIdLocal() == city_id) {
                    logger.info("Got an id match");
                    city_name = place.getLocal();
                    break;
                }
            }

            if (forecast != null && city_name != null) {
                System.out.println("\n-------- Weather Forecast for " + city_name + " --------");
                ListIterator<CityForecast> dayIterator = forecast.getData().listIterator();
                while(dayIterator.hasNext()) {
                    CityForecast dayData = dayIterator.next();

                    System.out.println("    --- " + dayData.getForecastDate() + " ---");
                    System.out.printf("MaxTemp: %4.1f ºC%n", Double.parseDouble(dayData.getTMax()));
                    System.out.printf("MinTemp: %4.1f ºC%n", Double.parseDouble(dayData.getTMin()));
                    System.out.printf("ProbPrecip: %2.1f %% %n", Double.parseDouble(dayData.getPrecipitaProb()));
                    System.out.println();
                }
            } else {
                logger.info("Didn't get an id match");
                System.out.printf("-----------%nNo results for this request!%n");
                System.out.printf("%n   Available places:%n");
                placeIterator = places.getData().listIterator();
                while(placeIterator.hasNext()) {
                    PlaceData place = placeIterator.next();
                    System.out.printf("%-25s %8d %n", place.getLocal(), place.getGlobalIdLocal());
                }
                System.out.printf("-----------%n%n");
            }
        } catch (Exception ex) {
            logger.error("Exception error");
            ex.printStackTrace();
        }
    }
}