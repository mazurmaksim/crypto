package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.enums.CryptoVaultEnum;
import com.example.crypto.repository.CryptoVaultRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CryptoVaultServiceImpl implements CryproVaultService {

    private CryptoVaultRepository cryptoVaultRepository;

    @Override
    public CryptoVault findMinPriceAndVault(CryptoVaultEnum vaultEnum) {
        return null;
    }

    @Resource(name = "cryptoVaultRepository")
    public void setCryptoVaultRepository(CryptoVaultRepository cryptoVaultRepository) {
        this.cryptoVaultRepository = cryptoVaultRepository;
    }
}
