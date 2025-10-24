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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Coffee Shop GUI demonstrating Decorator Pattern.
 */
public class CoffeeShopGUI extends JFrame 
{
    private static final Font courier = new Font("Courier", Font.PLAIN, 18);
    
    private JComboBox<String> baseBox, sizeBox;
    private JCheckBox[] condiments;
    private JTextArea summaryArea;
    private JButton clearBtn, checkoutBtn, helpBtn;
    private Beverage currentBeverage;

    public CoffeeShopGUI() {
        setTitle("Coffee Shop Decorator GUI");
        setSize(1280, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        // Left panel: Base & Size
        JPanel leftPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Base & Size"));
        leftPanel.setPreferredSize(new Dimension(250, 800));
        baseBox = new JComboBox<>(new String[]{"Select Base", "Espresso", "House Blend", "Dark Roast", "Decaf"});
        baseBox.addActionListener(e -> updateOrder());
        sizeBox = new JComboBox<>(new String[]{"Select Size", "Small", "Medium", "Large"});
        sizeBox.addActionListener(e -> updateOrder());
        leftPanel.add(new JLabel("Base:"));
        leftPanel.add(baseBox);
        leftPanel.add(new JLabel("Size:"));
        leftPanel.add(sizeBox);

        // Middle panel: Condiments
        JPanel middlePanel = new JPanel(new GridLayout(6, 1, 5, 5));
        middlePanel.setBorder(BorderFactory.createTitledBorder("Condiments"));
        middlePanel.setPreferredSize(new Dimension(250, 800));
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
        summaryArea.setFont(courier);
        rightPanel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> clearOrder());
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(e -> checkout());
        helpBtn = new JButton("Help");
        helpBtn.addActionListener(e -> {
          JOptionPane.showMessageDialog(this,
            "\tThe decorator pattern uses a combination of inheritance and composition to allow for classes which are the same overall type\n" + 
            "as their parents and contain the same methods and also provide additional functionality to the objects contained within, “decorating”\n" +
            "them with new functionality.\n" + //
            "\tIn this program, the Beverage abstract class is extended by concrete beverages, which act as base beverages (e.g. Espresso, Dark Roast).\n" +
            "The BeverageDecorator abstract class is a subclass of Beverage. It also contains a beverage as a field. Instances of beverage decorators\n" + 
            "contain methods which call the same method for the interior beverage that it’s decorating and then perform additional actions that the\n" + 
            "decorator itself uniquely provides.\n"
          );
        });
        buttonPanel.add(clearBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(helpBtn);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(leftPanel);
        add(middlePanel);
        add(rightPanel);
    }

    /** Updates the part of the UI which shows the subtotal and cost calculation. */
    private void updateOrder() 
    {
        String base = (String) baseBox.getSelectedItem();
        String sizeString = (String) sizeBox.getSelectedItem();
        Size size = Size.SMALL;

        if (base == null || base.equals("Select Base")) 
        {
            summaryArea.setText("Please select a base coffee.");
            return;
        }

        if (sizeString == "null" || sizeString.equals("Select Size")) {
            summaryArea.setText("Please select a size.");
            return;
        }

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
        summaryArea.append(String.format("%1$-35s $%2$-6.2f", "Total", currentBeverage.cost()));
    }

    /** Resets the order to the default state. */
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
