package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CryproVaultService {
    CryptoVault findMinPriceByVault(String currency);
    CryptoVault findMaxPriceByVault(String currency);
    Page<CryptoVault> getCurrencyByName(String currency, Pageable paging);
    List<CryptoVault> getAll();
    void saveAll(List<CryptoVault> list);
}
