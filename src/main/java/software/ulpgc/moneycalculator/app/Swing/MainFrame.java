package software.ulpgc.moneycalculator.app.Swing;

import software.ulpgc.moneycalculator.architecture.control.Command;
import software.ulpgc.moneycalculator.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalculator.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public MainFrame() throws HeadlessException{
        this.setTitle("Money Calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(toolBar());
        this.add(createMoneyDisplay());
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;

        return display;
    }

    private Component toolBar() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    public void add(String name, Command command){commands.put(name, command);}

    public MoneyDisplay moneyDisplay(){return moneyDisplay;}
    public CurrencyDialog currencyDialog(){return currencyDialog;}
    public MoneyDialog moneyDialog(){return moneyDialog;}
}
