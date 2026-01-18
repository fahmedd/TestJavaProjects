package org.example.Service;

import org.example.Exception.CurrencyNotFoundException;
import org.example.Model.Currency;
import org.example.Repository.CurrencyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
