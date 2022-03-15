package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.enums.CryptoVaultEnum;

public interface CryproVaultService {
    CryptoVault findMinPriceAndVault(CryptoVaultEnum vaultEnum);
}
