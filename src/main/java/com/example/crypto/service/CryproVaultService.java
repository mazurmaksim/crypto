package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CryproVaultService {
    CryptoVault findMinPriceByVault(String currency);
    CryptoVault findMaxPriceByVault(String currency);
    Page<CryptoVault> getAllVaults(Pageable paging);
}
