package software.ulpgc.moneycalculator.architecture.model;

import java.text.DecimalFormat;

public record Money(double amount, Currency currency) {
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#,##0.0000");
        return df.format(amount) + " " + currency.code();
    }
}
