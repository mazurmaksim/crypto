package com.example.crypto.mapper


import com.example.crypto.repository.CryptoVaultRepository
import spock.lang.Specification

class CryptoJsonMapperSpec extends Specification {

    CryptoJsonMapper mapper

    def "Mapper vaults should not throw exception"() {
        given:
        mapper = new CryptoJsonMapper()
        when:
        mapper.vaults()
        then:
        noExceptionThrown()
    }

    def "Mapper return Lis of CryptoVault with BTC, ETH, XRP"() {
        given:
        mapper = new CryptoJsonMapper()
        when:
        def list = mapper.vaults()
        then:
        list.get(0).getCurrency() == "BTC"
        list.get(1).getCurrency() == "ETH"
        list.get(2).getCurrency() == "XRP"
    }

    def "Mapped data should be writing to database - no exceptions thrown"() {
        given:
        mapper = new CryptoJsonMapper(repository: Mock(CryptoVaultRepository))
        when:
        mapper.execute()
        then:
        noExceptionThrown()
    }
}
