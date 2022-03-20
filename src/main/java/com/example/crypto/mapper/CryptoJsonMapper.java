package com.example.crypto.mapper;

import com.example.crypto.entity.CryptoVault;
import com.example.crypto.processor.HttpGetData;
import com.example.crypto.repository.CryptoVaultRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Lazy(false)
public class CryptoJsonMapper implements Mapper {
    private static final Logger LOGGER = LogManager.getLogger(CryptoJsonMapper.class);
    HttpGetData data;
    CryptoVaultRepository repository;

/**
 * For some reason API gives for many currencies, so I made filter to parse needed currencies.
 **/
    @Override
    public List<CryptoVault> vaults() {
        data = new HttpGetData();
        List<CryptoVault> list;
        list = data.vaultsToDocument().stream().filter(cryptoVault -> cryptoVault.getCurrency().equals("BTC")
                && cryptoVault.getCurrencyUsd().equals("USD")
                || cryptoVault.getCurrency().equals("ETH")
                && cryptoVault.getCurrencyUsd().equals("USD")
                || cryptoVault.getCurrency().equals("XRP")
                && cryptoVault.getCurrencyUsd().equals("USD")).collect(Collectors.toList());
        LOGGER.info("Currencies data {} mapped successfully", list);
        return list;
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void execute() {
        repository.saveAll(vaults());
        LOGGER.info("Currencies is wrote to database {}", vaults());
    }

    @Resource(name = "cryptoVaultRepository")
    public void setRepository(CryptoVaultRepository repository) {
        this.repository = repository;
    }
}
