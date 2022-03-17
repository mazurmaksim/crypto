package com.example.crypto;

import com.example.crypto.entity.CryptoVault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VaultHelper {

    public List<CryptoVault> createVaultObject() {
        List<CryptoVault> list = new ArrayList<>();

        CryptoVault ethCurrency = new CryptoVault();
        ethCurrency.setCurrency("ETH");
        ethCurrency.setDate(LocalDateTime.now());
        ethCurrency.setPrice(10.47);

        CryptoVault xrpCurrency = new CryptoVault();
        xrpCurrency.setCurrency("XRP");
        xrpCurrency.setDate(LocalDateTime.now());
        xrpCurrency.setPrice(585.47);

        CryptoVault btcCurrency = new CryptoVault();
        btcCurrency.setCurrency("BTC");
        btcCurrency.setCurrencyUsd("USD");
        btcCurrency.setDate(LocalDateTime.now());
        btcCurrency.setPrice(325.47);

        list.add(btcCurrency);
        list.add(xrpCurrency);
        list.add(ethCurrency);

        return list;
    }
}
