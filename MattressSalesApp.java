package mattresssales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MattressSalesApp extends JFrame implements ActionListener
{
    JLabel lblCustomer, lblProduct, lblPrice;

    JTextField txtCustomer, txtPrice;

    JComboBox<String> cmbProduct;

    JButton btnProcess;

    JMenuItem exitItem, processItem, clearItem;

    public MattressSalesApp()
    {
        setTitle("Product App");

        lblCustomer = new JLabel("Customer Name:");
        txtCustomer = new JTextField(20);

        lblProduct = new JLabel("Select Product:");

        String products[] = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        lblPrice = new JLabel("Enter Price:");
        txtPrice = new JTextField(20);

        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(this);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        exitItem = new JMenuItem("Exit");
        processItem = new JMenuItem("Process");
        clearItem = new JMenuItem("Clear");

        exitItem.addActionListener(this);
        processItem.addActionListener(this);
        clearItem.addActionListener(this);

        fileMenu.add(exitItem);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        setLayout(new GridLayout(4, 2, 10, 10));

        add(lblCustomer);
        add(txtCustomer);

        add(lblProduct);
        add(cmbProduct);

        add(lblPrice);
        add(txtPrice);

        add(new JLabel(""));
        add(btnProcess);

        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnProcess ||
           e.getSource() == processItem)
        {
            processSale();
        }

        if(e.getSource() == clearItem)
        {
            txtCustomer.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        }

        if(e.getSource() == exitItem)
        {
            System.exit(0);
        }
    }


    public void processSale()
    {
        try
        {
            String customer = txtCustomer.getText();

            String product =
                cmbProduct.getSelectedItem().toString();

            if(customer.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this,
                    "Please enter customer name.");
                return;
            }

            double price =
                Double.parseDouble(txtPrice.getText());

            if(price <= 0)
            {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid price.");
                return;
            }

            ProductCalculations calculation =
                new ProductCalculations(price);

            double vat = calculation.GetVat();

            double commission =
                calculation.GetCommission();

            double total = calculation.GetTotal();

            String result =
                "Customer Name: " + customer +
                "\nProduct: " + product +
                "\nVAT: R " + vat +
                "\nCOMMISSION: R " + commission +
                "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, result);

            PrintWriter output = new PrintWriter(
                new FileWriter("data.txt", true));

            output.println("DATA LOG");
            
            output.println("Customer Name: " + customer);
            output.println("Product: " + product);
            output.println("VAT: R " + vat);
            output.println("COMMISSION: R " + commission);
            output.println("TOTAL: R " + total);
            

            output.close();
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this,
                "Please enter a valid price.");
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this,
                "Error saving data to file.");
        }
    }

    public static void main(String[] args)
    {
        new MattressSalesApp();
    }
}