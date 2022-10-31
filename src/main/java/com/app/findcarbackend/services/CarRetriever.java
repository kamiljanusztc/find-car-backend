package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.ApiCar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarRetriever {

//    public List<ApiCar> getCarsFromApi() {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://car-api2.p.rapidapi.com/api/makes?direction=asc&sort=id"))
//                .header("X-RapidAPI-Key", "de683e7487mshdeb25bef4087c8fp100e6ejsn0035b5f30453")
//                .header("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = null;
//        try {
//            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(response.body());
//
//        Type listType = new TypeToken<ArrayList<ApiCar>>(){}.getType();
//        List<ApiCar> yourClassList = new Gson().fromJson(JSONObject(response.body()), listType);
//        return yourClassList;
//    }

//    public List<ApiCar> getCarsFromApi() {
//        Gson gson = new Gson();
//
//        JsonObject json = gson.fromJson(jsonStr, JsonObject.class)
//                .get("quoteResponse")
//                .getAsJsonObject()
//                .get("result")
//                .getAsJsonArray()
//                .get(0) // only one object in the array
//                .getAsJsonObject();
//
//        String symbol = json.get("symbol").getAsString();
//        String displayName = json.get("displayName").getAsString();
//        String quoteType = json.get("quoteType").getAsString();
//
//        Stock stock = new Stock(symbol, displayName, quoteType);
//    }

}
