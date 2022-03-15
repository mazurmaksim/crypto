package com.example.crypto.repository;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.enums.CryptoVaultEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CryptoVaultRepository extends MongoRepository<CryptoVault, String> {
    CryptoVault findCryptoVaultByVault(CryptoVaultEnum vaultEnum);
    //min
    CryptoVault findTopByVaultOrderByValueDesc(CryptoVaultEnum vaultEnum);
    //max
    CryptoVault findTopByVaultOrderByValueAsc(CryptoVaultEnum vaultEnum);
}
