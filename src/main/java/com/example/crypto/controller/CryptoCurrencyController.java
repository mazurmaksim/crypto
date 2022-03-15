package com.example.crypto.controller;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.enums.CryptoVaultEnum;
import com.example.crypto.repository.CryptoVaultRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CryptoCurrencyController {

    CryptoVaultRepository repository;

    @GetMapping("/cryptocurrencies/minprice")
    public ResponseEntity<String> getVaultMinPrice(@RequestParam(value = "name") CryptoVaultEnum currencyName) {
        //todo fix connection to db
        CryptoVault cryptoVault = repository.findTopByVaultOrderByValueDesc(currencyName);
        return ResponseEntity.ok("cryptoVault");
    }

    @GetMapping("/cryptocurrencies/maxprice")
    public ResponseEntity<String> getVaultMaxPrice(@RequestParam(value = "name") CryptoVaultEnum currencyName) {
        //todo fix connection to db
        CryptoVault cryptoVault = repository.findTopByVaultOrderByValueAsc(currencyName);
        return ResponseEntity.ok("cryptoVault");
    }

    @Resource(name = "cryptoVaultRepository")
    public void setRepository(CryptoVaultRepository repository) {
        this.repository = repository;
    }
}
