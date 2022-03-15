package com.example.crypto.controller;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.enums.CryptoVaultEnum;
import com.example.crypto.repository.CryptoVaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CryptoCurrencyController {

    @Autowired
    CryptoVaultRepository repository;

    @GetMapping("/cryptocurrencies/minprice{name}")
    public ResponseEntity<CryptoVault> getVaultMinPrice(@PathVariable(value = "name") String currencyName) {
        CryptoVault cryptoVault = repository.findTopByVaultOrderByValueDesc(CryptoVaultEnum.valueOf(currencyName));
        return ResponseEntity.ok(cryptoVault);
    }

//    @Resource(name = "cryptoVaultRepository")
//    public void setRepository(CryptoVaultRepository repository) {
//        this.repository = repository;
//    }
}
