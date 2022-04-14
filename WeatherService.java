package com.techtalentsouth.WeatherApp; 

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${api_key}")//lets us inject the API key we have under properties 
    private String apiKey;

	
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
            zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Response.class);//We are returning on the getforObject
        //We are not returning the restTemplate itself. It's returning a response class with the values inside the JSON
    }
    
}