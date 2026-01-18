package org.example.Controller;


import org.example.Exception.CurrencyNotFoundException;
import org.example.Model.Currency;
import org.example.Service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyExchangeController {

    CurrencyService currencyService;

    public CurrencyExchangeController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }


    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("I am ok...");
    }


    //Global exception handler example
    @GetMapping("/allCurrencies")
    public ResponseEntity<List<Currency>> getAllCurrencies() throws CurrencyNotFoundException {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.ok(currencies);
    }



}
