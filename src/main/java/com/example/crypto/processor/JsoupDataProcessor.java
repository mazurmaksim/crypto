package com.example.crypto.processor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupDataProcessor {
    public static final String BTC_USD_PRICE = "ticker-BTC-USD-price";
    public static final String ETH_USD_PRICE = "ticker-ETH-USD-price";
    public static final String XRP_USD_PRICE = "ticker-XRP-USD-price";
    public static final String HREF = "https://cex.io/eth-usd";

    public static void vaultsToDocument() {
        Document eventInfo = null;
        try {
            eventInfo = Jsoup.connect(HREF).timeout(10*1000).userAgent
                    ("Mozilla").ignoreHttpErrors(true).get();
        } catch (IOException e) {
            //Your exception handling here
        }
        String info = eventInfo.getElementById(ETH_USD_PRICE).outerHtml();
        System.out.println(info);
    }

    public static void main(String[] args) {
        vaultsToDocument();
    }
}
