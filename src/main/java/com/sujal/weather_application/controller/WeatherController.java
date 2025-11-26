package com.sujal.weather_application.controller;
import com.sujal.weather_application.model.AirQualityResponse;
import com.sujal.weather_application.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {
    @Value("${api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String baseUrl;
    @Value("${openweather.api.airquality}")
    private String airQualityUrl;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }


    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        try {

            String url = baseUrl + city + "&appid=" + apiKey + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            WeatherResponse weatherResponse = new RestTemplate().getForObject(url, WeatherResponse.class);

            if (weatherResponse == null || weatherResponse.getCod() == 404) {
                model.addAttribute("error", "City not found!");
                return "weather";
            }

            if (weatherResponse != null) {
                model.addAttribute("city", weatherResponse.getName());
                model.addAttribute("country", weatherResponse.getSys().getCountry());
                model.addAttribute("temperature", weatherResponse.getMain().getTemp());
                model.addAttribute("description", weatherResponse.getWeather().get(0).getDescription());
                model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
                model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());

                String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
                model.addAttribute("weatherIcon", weatherIcon);
            }

            double lat = weatherResponse.getCoord().getLat();
            double lon = weatherResponse.getCoord().getLon();

            String url2 = airQualityUrl + "lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;


            AirQualityResponse airQualityResponse = restTemplate.getForObject(url2, AirQualityResponse.class);


            if (airQualityResponse != null && airQualityResponse.getList() != null) {
                var aqiData = airQualityResponse.getList().get(0);

                model.addAttribute("aqi", aqiData.getMain().getAqi());
                model.addAttribute("pm25", aqiData.getComponents().getPm2_5());
                model.addAttribute("pm10", aqiData.getComponents().getPm10());
                model.addAttribute("o3", aqiData.getComponents().getO3());
                model.addAttribute("so2", aqiData.getComponents().getSo2());
                model.addAttribute("no2", aqiData.getComponents().getNo2());
//                System.out.println(aqiData.getMain().getAqi());
//                System.out.println(aqiData.getComponents().getPm2_5());
//                System.out.println(aqiData.getComponents().getPm10());

            }

        }catch(Exception e){
                e.printStackTrace();
                model.addAttribute("error", "City not found");
        }

        return "weather";
    }


}