package com.example.crypto.enums;

public enum CryptoVaultEnum {
    BTC("BTC"),
    ETH("ETH"),
    XRP("XRP");

    final String vault;

    CryptoVaultEnum(String vault) {
        this.vault = vault;
    }
}
