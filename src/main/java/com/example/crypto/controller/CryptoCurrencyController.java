package com.example.crypto.controller;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.repository.CryptoVaultRepository;
import com.example.crypto.service.CryproVaultService;
import com.example.crypto.service.CryptoVaultServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CryptoCurrencyController {

    CryproVaultService service;

    @GetMapping("/cryptocurrencies/minprice")
    public ResponseEntity<CryptoVault> getVaultMinPrice(@RequestParam(value = "name") String currencyName) {
        CryptoVault cryptoVault =  service.findMinPriceByVault(currencyName);
        return ResponseEntity.ok(cryptoVault);
    }

    @GetMapping("/cryptocurrencies/maxprice")
    public ResponseEntity<CryptoVault> getVaultMaxPrice(@RequestParam(value = "name") String currencyName) {
        CryptoVault cryptoVault = service.findMaxPriceByVault(currencyName);
        return ResponseEntity.ok(cryptoVault);
    }

    @GetMapping("/cryptocurrencies")
    public ResponseEntity getAllCurrencies(@RequestParam(value = "name") String currencyName,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getCurrencyByName(currencyName, paging));
    }

    @Resource(name = "cryptoVaultService")
    public void setRepository(CryproVaultService service) {
        this.service = service;
    }
}
