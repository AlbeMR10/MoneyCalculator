package software.ulpgc.moneycalculator.app.fixerApi;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.util.List;

public class FixerMain {
    public static void main(String[] args){
        FixerCurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        for(Currency currency : currencies){
            System.out.println(currency);
        }
    }
}
