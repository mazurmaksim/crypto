package com.example.crypto.processor;

import com.example.crypto.entity.CryptoVault;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

public class HttpGetData {

    public List<CryptoVault> vaultsToDocument() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://cex.io/api/last_prices/BTC/USD/ETH/USD/")).build();
        String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        HashMap<String,String> map = mapper.readValue(json, HashMap.class);
        return mapper.readValue(mapper.writeValueAsString(map.get("data")), new TypeReference<List<CryptoVault>>() {});
    }
}
