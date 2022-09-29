package pt.mankings.ies;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeatherForecastApp {
    private static Scanner sc = new Scanner(System.in);
    private static IpmaApiClient client = new IpmaApiClient();

    public static void  main(String[] args) {
        int op = 0;
        boolean loop = true;

        while(loop) {
            System.out.println("--==[ IPMA API Client ]==--");
            System.out.println("  1. List available cities");
            System.out.println("  2. Get city forecast");
            System.out.println("  3. Quit");
            System.out.print(" Choose an option: ");
            
            try {
                op = sc.nextInt();
                sc.nextLine();
    
                switch(op) {
                    case 1:
                        client.displayCities();
                        break;
                    case 2:
                        System.out.print("Enter city name: ");
                        String cityName = sc.nextLine();
                        client.displayCityForecast(cityName);
                        break;
                    case 3:
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option!");
                sc.nextLine();
            }

        }
    }
}