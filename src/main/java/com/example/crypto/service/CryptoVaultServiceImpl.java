package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.repository.CryptoVaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cryptoVaultService")
public class CryptoVaultServiceImpl implements CryproVaultService {

    private CryptoVaultRepository cryptoVaultRepository;

    @Override
    public CryptoVault findMinPriceByVault(String currencyName) {
        return cryptoVaultRepository.findTopByCurrencyOrderByPriceDesc(currencyName);
    }

    @Override
    public CryptoVault findMaxPriceByVault(String currencyName) {
        return cryptoVaultRepository.findTopByCurrencyOrderByPriceAsc(currencyName);
    }

    @Override
    public Page<CryptoVault> getCurrencyByName(String currency, Pageable paging) {
        return cryptoVaultRepository.findCryptoVaultByCurrencyOrderByPrice(currency, paging);
    }

    @Resource(name = "cryptoVaultRepository")
    public void setCryptoVaultRepository(CryptoVaultRepository cryptoVaultRepository) {
        this.cryptoVaultRepository = cryptoVaultRepository;
    }
}
