package com.example.crypto.repository;

import com.example.crypto.entity.CryptoVault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "cryptoVaultRepository")
public interface CryptoVaultRepository extends MongoRepository<CryptoVault, String> {
    CryptoVault findTopByCurrencyOrderByPriceDesc(String currencyName);
    CryptoVault findTopByCurrencyOrderByPriceAsc(String currencyName);
}
