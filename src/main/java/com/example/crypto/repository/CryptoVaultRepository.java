package com.example.crypto.repository;

import com.example.crypto.entity.CryptoVault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "cryptoVaultRepository")
public interface CryptoVaultRepository extends MongoRepository<CryptoVault, String> {
    CryptoVault findTopByCurrencyOrderByPriceDesc(String currencyName);
    CryptoVault findTopByCurrencyOrderByPriceAsc(String currencyName);
    Page<CryptoVault> findCryptoVaultByCurrencyOrderByPrice(String currencyName, Pageable pageable);
}
