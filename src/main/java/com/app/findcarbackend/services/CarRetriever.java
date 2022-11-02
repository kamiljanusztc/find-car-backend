package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.ApiCarResponseObject;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class CarRetriever {

    private static ApiCarResponseObject carsFromApi;

    public ApiCarResponseObject getCarsFromApi() {
        return (carsFromApi != null && !carsFromApi.getData().isEmpty()) ? carsFromApi : pullData();
    }

    public ApiCarResponseObject pullData() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://car-api2.p.rapidapi.com/api/makes?direction=asc&sort=id"))
                .header("X-RapidAPI-Key", "de683e7487mshdeb25bef4087c8fp100e6ejsn0035b5f30453")
                .header("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            carsFromApi = new Gson().fromJson(response.body(), ApiCarResponseObject.class);
            return carsFromApi;
        } catch (Exception e) {
            return carsFromApi;
        }
    }
}
