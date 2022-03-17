package com.example.crypto.processor;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.mapper.CryptoJsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HttpGetData {
    private static final Logger LOGGER = LogManager.getLogger(CryptoJsonMapper.class);

    public List<CryptoVault> vaultsToDocument() {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map;
        List<CryptoVault> result;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://cex.io/api/last_prices/BTC/USD/ETH/USD/")).build();
        String json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        LOGGER.info("received data from API {}", json);
        try {
            map = mapper.readValue(json, HashMap.class);
            result = mapper.readValue(mapper.writeValueAsString(map.get("data")), new TypeReference<List<CryptoVault>>() {
            });
        } catch (JsonProcessingException e) {
            LOGGER.error("Can't map data from API ", e);
            return Collections.emptyList();
        }
        return result;
    }
}
