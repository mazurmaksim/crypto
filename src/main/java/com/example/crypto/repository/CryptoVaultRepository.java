package com.example.crypto.repository;

import com.example.crypto.entity.CryptoVault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "cryptoVaultRepository")
public interface CryptoVaultRepository extends MongoRepository<CryptoVault, String> {
    Optional<CryptoVault> findTopByCurrencyOrderByPriceDesc(String currencyName);
    Optional<CryptoVault> findTopByCurrencyOrderByPriceAsc(String currencyName);
    Page<CryptoVault> findCryptoVaultByCurrencyOrderByPrice(String currencyName, Pageable pageable);
}
