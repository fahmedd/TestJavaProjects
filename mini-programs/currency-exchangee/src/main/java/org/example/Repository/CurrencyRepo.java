package org.example.Repository;


import org.example.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
    String findCurrencyBySymbol(String symbol);

    boolean existsCurrencyBySymbol(String symbol);

    @Query("select c.symbol from Currency c")
    Set<String> findAllSymbols();
}