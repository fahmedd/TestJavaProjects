package org.example.Repository;


import org.example.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
    String findCurrencyBySymbol(String symbol);

    boolean existsCurrencyBySymbol(String symbol);
}