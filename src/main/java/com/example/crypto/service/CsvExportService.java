package com.example.crypto.service;

import com.example.crypto.entity.CryptoVault;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.IntStream;

@Service("csvExportService")
public class CsvExportService {

    private static final Logger LOGGER = LogManager.getLogger(CsvExportService.class);

    private final CryproVaultService service;

    public CsvExportService(CryproVaultService service) {
        this.service = service;
    }

    public void writeStatisticToCsv(Writer writer) {
        List<List<CryptoVault>> vaultList = getStatisticFromDb();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Cryptocurrency Name", "Min Price", "Max Price");
            IntStream.range(0, vaultList.size())
                    .forEach(i -> {
                        try {
                            csvPrinter.printRecord(vaultList.get(i).get(0).getCurrency(),
                                    vaultList.get(i).get(0).getPrice(),
                                    vaultList.get(i).get(1).getPrice());
                        } catch (IOException e) {
                            LOGGER.error("Can't write data to CSV ", e);
                        }
                    });
        } catch (IOException e) {
            LOGGER.error("Can't write title to CSV ", e);
        }
    }

    public List<List<CryptoVault>> getStatisticFromDb() {
        List<List<CryptoVault>> data = new ArrayList<>();
        List<String> statistic = Arrays.asList("BTC", "ETH", "XRP");
        statistic.forEach(s -> data.add(Arrays.asList(service.findMaxPriceByVault(s), service.findMinPriceByVault(s))));
        return data;
    }
}
