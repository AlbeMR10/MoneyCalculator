package software.ulpgc.moneycalculator.app.persistence;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculator.architecture.persistence.ExchangeRateLoader;

import java.time.LocalDate;

public class MainExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to, LocalDate date) {
        return new ExchangeRate(from,to, 1.2, LocalDate.now());
    }
}
