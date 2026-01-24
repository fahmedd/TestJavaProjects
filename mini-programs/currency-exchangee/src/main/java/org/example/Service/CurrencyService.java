package org.example.Service;

import jdk.nashorn.internal.ir.Symbol;
import org.example.Exception.CurrencyNotFoundException;
import org.example.Model.Currency;
import org.example.Repository.CurrencyRepo;
import org.example.dto.RatesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class CurrencyService {

    private final CurrencyRepo currencyRepo;

    private static final Logger log =
            LoggerFactory.getLogger(CurrencyService.class);

    public CurrencyService(CurrencyRepo currencyRepo){
        this.currencyRepo = currencyRepo;
    }

    public List<Currency> getAllCurrencies() throws CurrencyNotFoundException {
      List<Currency> currencies = currencyRepo.findAll();

      try {
          if (currencies.isEmpty()) {
              throw new CurrencyNotFoundException("Unable to find currencies");
          }
          return currencies;
      } catch (DataAccessException e){
          log.error("Issue whilst connecting to data layer ", e);
          throw e;
      }
    }



    public boolean saveCurrenciesV2(List<String> symbols){
        //To avoid doing multiple findbysymbol db calls
        Set<String> existingSymbols = currencyRepo.findAllSymbols()
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        Set<String> currencySymbols = new HashSet<>();

        for(String symbol:  symbols){
            symbol = symbol.trim().toUpperCase();
            if (existingSymbols.contains(symbol)){
                continue;
            }
            currencySymbols.add(symbol);
        }

        if (currencySymbols.isEmpty()){
            return false;
        }

        currencyRepo.saveAll(currencySymbols
                .stream()
                .map(Currency::new)
                .collect(Collectors.toList()));

        log.info("New currencies being added:{}", currencySymbols.size());
        return true;
    }



}
