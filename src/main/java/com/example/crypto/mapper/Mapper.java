package com.example.crypto.mapper;

import com.example.crypto.entity.CryptoVault;

import java.util.List;

public interface Mapper {
    List<CryptoVault> vaults();
    void execute();
}
