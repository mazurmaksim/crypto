package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.exception.currency.CurrencyNotFoundException;
import com.example.crypto.repository.CryptoVaultRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("cryptoVaultService")
public class CryptoVaultServiceImpl implements CryproVaultService {

    private CryptoVaultRepository cryptoVaultRepository;

    @Override
    public CryptoVault findMinPriceByVault(String currencyName) {
        return Optional.ofNullable(cryptoVaultRepository
                .findTopByCurrencyOrderByPriceDesc(currencyName))
                .orElseThrow(()-> new CurrencyNotFoundException("Currency Not Present in database"));
    }

    @Override
    public CryptoVault findMaxPriceByVault(String currencyName) {
        return Optional.ofNullable(cryptoVaultRepository.findTopByCurrencyOrderByPriceAsc(currencyName))
                .orElseThrow(()-> new CurrencyNotFoundException("Currency Not Present in database"));
    }

    @Override
    public Page<CryptoVault> getCurrencyByName(String currency, Pageable paging) {
        return Optional.ofNullable(cryptoVaultRepository.findCryptoVaultByCurrencyOrderByPrice(currency, paging))
                .orElseThrow(()-> new CurrencyNotFoundException("Currency Not Present in database"));
    }

    @Override
    public List<CryptoVault> getAll() {
        return cryptoVaultRepository.findAll();
    }

    @Resource(name = "cryptoVaultRepository")
    public void setCryptoVaultRepository(CryptoVaultRepository cryptoVaultRepository) {
        this.cryptoVaultRepository = cryptoVaultRepository;
    }
}
