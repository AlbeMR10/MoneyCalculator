package software.ulpgc.moneycalculator.app;

import software.ulpgc.moneycalculator.app.persistence.MainCurrencyLoader;
import software.ulpgc.moneycalculator.app.persistence.MainExchangeRateLoader;
import software.ulpgc.moneycalculator.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = new MainCurrencyLoader().load();
        MainFrame mainFrame = new MainFrame(currencies);

        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.moneyDialog(),
                mainFrame.currencyDialog(),
                new MainExchangeRateLoader(),
                mainFrame.moneyDisplay()
        );

        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);
    }
}
