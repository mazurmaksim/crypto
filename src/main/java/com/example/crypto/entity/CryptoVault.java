package com.example.crypto.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document("crypto_vaults")
@Getter
@Setter
public class CryptoVault {

    @Id
    private String id;

    @Field("date")
    private LocalDateTime date;
    @Field("vault")
    private CryptoVault vault;
    @Field("price")
    private Double value;
}
