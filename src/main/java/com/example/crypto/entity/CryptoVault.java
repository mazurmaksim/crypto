package com.example.crypto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "crypto_vaults")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoVault {

    @Id
    private String id;

    @Field("date")
    private LocalDateTime date = LocalDateTime.now();
    @Field("vault")
    @JsonProperty("symbol1")
    private String currency;
    @JsonProperty("symbol2")
    private String currencyUsd;
    @Field("price")
    @JsonProperty("lprice")
    private Double price;
}
