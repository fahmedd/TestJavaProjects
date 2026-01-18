package org.example.Controller;

import org.example.Model.Currency;
import org.example.Model.ExchangeRate;
import org.example.Repository.CurrencyRepo;
import org.example.Repository.ExchangeRateRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CurrencyExchangeControllerV2 {

    private final CurrencyRepo currencyRepo;
    private final ExchangeRateRepo exchangeRateRepo;

    public CurrencyExchangeControllerV2(CurrencyRepo currencyRepo, ExchangeRateRepo exchangeRateRepo){
        this.currencyRepo = currencyRepo;
        this.exchangeRateRepo=exchangeRateRepo;
    }

    //This returns a list of all the symbols - doesnt handle exception but we could use the globalExceptionHandler
    @GetMapping("/currencies")
    public List<String> getCurrencies() {
        return currencyRepo.findAll()
                .stream()
                .map(Currency::getSymbol)
                .collect(Collectors.toList());
    }

    //exchange-rate?from=USD&to=EUR
    @GetMapping("/exchange-rate")
        public ResponseEntity<Double> getRate(@RequestParam String from, @RequestParam String to) {
            Optional<ExchangeRate> rate = exchangeRateRepo.getExchangeRate(from, to);
            return rate.map(exchangeRate -> ResponseEntity.ok(exchangeRate.getRate()))
                    .orElse(ResponseEntity.notFound().build());
     }

     //preload currency and rates
     //AddCurrency
    //Add currency exchange rate
    //retun 404 if missing
    //validate rate is > 0
    //getExchangeRateFromSymbol
    //convert this currency and amount to this currency
    //

/*
Preload the exchange rates and currencies

    Validate currency before exchange rate

    Get exchange rate

    Input: from & to currency

    Output: exchange rate or 404

    Convert amount

    Input: from, to, amount

    Output: converted value

    List supported currencies

    Output: all currency symbols

    Add / update exchange rate

    Input: from, to, rate

    Update DB

    Handle invalid input

    Non-existent currency → return 404

    Negative rate → reject

    Optional: Implement batch conversion

    Convert 100 USD to all other currencies

    Return a map of symbol -> converted value*/


}
