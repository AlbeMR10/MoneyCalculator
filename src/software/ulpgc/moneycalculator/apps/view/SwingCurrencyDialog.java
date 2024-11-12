package software.ulpgc.moneycalculator.apps.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.view.CurrencyDialog;

import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private final List<Currency> currencies;
    private final JComboBox<Currency> selector;

    public SwingCurrencyDialog(List<Currency> currencies, JComboBox<Currency> selector) {
        this.currencies = currencies;
        this.selector = selector;
    }

    private JComboBox<Currency> createSelector(){
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies)
            comboBox.addItem(currency);
        return comboBox;
    }

    @Override
    public Currency get() {
        return null;
    }
}
