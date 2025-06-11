package software.ulpgc.moneycalculator.app.Swing;

import software.ulpgc.moneycalculator.architecture.control.Command;
import software.ulpgc.moneycalculator.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.app.fixerApi.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.app.fixerApi.FixerExchangeRateLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame  = new MainFrame();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeCommand(
                mainFrame.moneyDialog().define(currencies),
                mainFrame.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                mainFrame.moneyDisplay()
        );
        mainFrame.add("exchange money", command);
        mainFrame.setVisible(true);
    }
}
