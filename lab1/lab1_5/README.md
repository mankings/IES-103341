# Lab 1.5 Notes

## Weather Forecast App
Made from two small independent Java Maven Projects.

The first one is **IpmaApiClient**, responsible for the remote API client logic, and the second one is **WeatherForecastByCity**, which handles the user interaction.

In **IpmaApiClient**, we have the following dependencies:
* Square's **Retrofit** is a type-safe HTTP client for Java, that allows mapping an external REST API into a local (Java) interface;
* Google's **Gson** is a Java library that can be used to convert Java Objects into their JSON representation.

In **WeatherForecastByCity**, the only dependency is the **IpmaApiClient**.

The jar can be built with:
```
$ mvn package
```

and can be ran using:
```
$ mvn exec:java -Dexec.mainClass="WeatherForecastByCity" -Dexec.args="[city name]"
```