package com.example.crypto.controller;

import com.example.crypto.VaultHelper;
import com.example.crypto.service.CryproVaultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CryptoCurrencyController.class,  useDefaultFilters = false)
@Import(CryptoCurrencyController.class)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration("classpath:spring/test-context.xml")
public class CryptoCurrencyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean(name = "cryptoVaultService")
    CryproVaultService cryptoVaultService;

    @Test
    public void should_return_record_with_the_lowest_price_BTC() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMinPriceByVault("BTC")).willReturn(helper.createVaultObject().get(0));

        mvc.perform(get("/cryptocurrencies/minprice?name=BTC")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(0).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(0).getPrice())));
    }

    @Test
    public void should_return_record_with_the_lowest_price_XRP() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMinPriceByVault("XRP")).willReturn(helper.createVaultObject().get(1));

        mvc.perform(get("/cryptocurrencies/minprice?name=XRP")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(1).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(1).getPrice())));
    }

    @Test
    public void should_return_record_with_the_lowest_price_ETH() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMinPriceByVault("ETH")).willReturn(helper.createVaultObject().get(2));

        mvc.perform(get("/cryptocurrencies/minprice?name=ETH")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(2).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(2).getPrice())));
    }

    @Test
    public void should_return_record_with_the_max_price_BTC() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMaxPriceByVault("BTC")).willReturn(helper.createVaultObject().get(0));

        mvc.perform(get("/cryptocurrencies/maxprice?name=BTC")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(0).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(0).getPrice())));
    }

    @Test
    public void should_return_record_with_the_max_price_XRP() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMaxPriceByVault("XRP")).willReturn(helper.createVaultObject().get(1));

        mvc.perform(get("/cryptocurrencies/maxprice?name=XRP")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(1).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(1).getPrice())));
    }

    @Test
    public void should_return_record_with_the_max_price_ETH() throws Exception {
        VaultHelper helper = new VaultHelper();
        BDDMockito.given(cryptoVaultService.findMaxPriceByVault("ETH")).willReturn(helper.createVaultObject().get(2));

        mvc.perform(get("/cryptocurrencies/maxprice?name=ETH")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(5)))
                .andExpect(jsonPath("$.symbol1", is(helper.createVaultObject().get(2).getCurrency())))
                .andExpect(jsonPath("$.lprice", is(helper.createVaultObject().get(2).getPrice())));
    }

    @Test
    public void should_return_record_with_the_pageble_object() throws Exception {
        VaultHelper helper = new VaultHelper();
        Pageable paging = PageRequest.of(0, 10);
        BDDMockito.given(cryptoVaultService.getCurrencyByName("BTC", paging)).willReturn(new PageImpl<>(helper.createVaultObject()));

        mvc.perform(get("/cryptocurrencies?name=BTC")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", aMapWithSize(11)));
    }

}
