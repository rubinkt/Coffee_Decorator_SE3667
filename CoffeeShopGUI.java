import javax.swing.*;

import Beverages.Beverage;
import Beverages.Beverage.Size;
import Beverages.DarkRoast;
import Beverages.Decaf;
import Beverages.Espresso;
import Beverages.HouseBlend;
import Decorators.Caramel;
import Decorators.Milk;
import Decorators.Mocha;
import Decorators.Sugar;
import Decorators.Vanilla;
import Decorators.Whip;

import java.awt.*;

/**
 * Coffee Shop GUI demonstrating Decorator Pattern.
 */
public class CoffeeShopGUI extends JFrame 
{
    private JComboBox<String> baseBox, sizeBox;
    private JCheckBox[] condiments;
    private JTextArea summaryArea;
    private JButton clearBtn, checkoutBtn;
    private Beverage currentBeverage;

    public CoffeeShopGUI() {
        setTitle("Coffee Shop Decorator GUI");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Left panel: Base & Size
        JPanel leftPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Base & Size"));
        baseBox = new JComboBox<>(new String[]{"Select Base", "Espresso", "House Blend", "Dark Roast", "Decaf"});
        baseBox.addActionListener(e -> updateOrder());
        sizeBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        sizeBox.addActionListener(e -> updateOrder());
        leftPanel.add(new JLabel("Base:"));
        leftPanel.add(baseBox);
        leftPanel.add(new JLabel("Size:"));
        leftPanel.add(sizeBox);

        // Middle panel: Condiments
        JPanel middlePanel = new JPanel(new GridLayout(6, 1, 5, 5));
        middlePanel.setBorder(BorderFactory.createTitledBorder("Condiments"));
        String[] condNames = {"Milk", "Mocha", "Sugar", "Whip", "Caramel", "Vanilla"};
        condiments = new JCheckBox[condNames.length];
        for (int i = 0; i < condNames.length; i++) 
        {
            condiments[i] = new JCheckBox(condNames[i]);
            condiments[i].addActionListener(e -> updateOrder());
            middlePanel.add(condiments[i]);
        }

        // Right panel: Summary
        JPanel rightPanel = new JPanel(new BorderLayout(5,5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Your Coffee"));
        summaryArea = new JTextArea(10, 25);
        summaryArea.setEditable(false);
        rightPanel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> clearOrder());
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(e -> checkout());
        buttonPanel.add(clearBtn);
        buttonPanel.add(checkoutBtn);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.WEST);
        add(middlePanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    private void updateOrder() 
    {
        String base = (String) baseBox.getSelectedItem();
        String sizeString = (String) sizeBox.getSelectedItem();
        Size size = Size.SMALL;
        switch (sizeString) {
            case "Small":
                break;
            case "Medium":
                size = Size.MEDIUM;
                break;
            case "Large":
                size = Size.LARGE;
                break;
        }

        if (base == null || base.equals("Select Base")) 
        {
            summaryArea.setText("Please select a base coffee.");
            return;
        }

        switch(base) 
        {
            case "Espresso": currentBeverage = new Espresso(size); break;
            case "House Blend": currentBeverage = new HouseBlend(size); break;
            case "Dark Roast": currentBeverage = new DarkRoast(size); break;
            case "Decaf": currentBeverage = new Decaf(size); break;
        }

        for (JCheckBox box : condiments) 
        {
            if (box.isSelected()) 
            {
                switch (box.getText()) 
                {
                    case "Milk": currentBeverage = new Milk(currentBeverage); break;
                    case "Mocha": currentBeverage = new Mocha(currentBeverage); break;
                    case "Sugar": currentBeverage = new Sugar(currentBeverage); break;
                    case "Whip": currentBeverage = new Whip(currentBeverage); break;
                    case "Caramel": currentBeverage = new Caramel(currentBeverage); break;
                    case "Vanilla": currentBeverage = new Vanilla(currentBeverage); break;
                }
            }
        }

        summaryArea.setText(currentBeverage.getName() + ":\n\n" + currentBeverage.getCalcString() + "\n");
        String bar = "";
        for (int n = 1; n <= 42; n++) {
            bar += "_";
        }
        summaryArea.append(bar + "\n");
        summaryArea.append(String.format("%1$-16s $%2$-6.2f", "Total", currentBeverage.cost()));
    }

    private void clearOrder() 
    {
        baseBox.setSelectedIndex(0);
        sizeBox.setSelectedIndex(0);
        for (JCheckBox box : condiments) box.setSelected(false);
        summaryArea.setText("");
    }

    private void checkout() 
    {
        if (summaryArea.getText().isEmpty() || baseBox.getSelectedIndex() == 0) 
        {
            JOptionPane.showMessageDialog(this, "Please select a base coffee before checkout.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Order placed successfully!");
        clearOrder();
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new CoffeeShopGUI().setVisible(true));
    }
}
