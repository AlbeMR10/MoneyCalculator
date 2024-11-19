package software.ulpgc.moneycalculator.app.persistence;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.persistence.CurrencyLoader;

import java.util.List;

public class MainCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        return List.of(
                new Currency("USD", "Dólar americano", "$"),
                new Currency("EUR", "Euro", "€")
        );
    }
}
