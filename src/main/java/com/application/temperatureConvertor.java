package com.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class temperatureConvertor extends JFrame implements ActionListener {
    private JTextField inputText;
    private JPanel panelMain;
    private JTextField outputText;
    private JButton convertButton;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JComboBox inputComboBox;
    private JLabel outcomeLabel;
    private JLabel titleLabel;
    private JComboBox outputComboBox;

    public temperatureConvertor() {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == convertButton) {
                    convertTemperature();
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("temperatureConvertor");
        frame.setTitle("Temperature Converter");
        frame.setContentPane(new temperatureConvertor().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void convertTemperature() {
        try {
            double inputTemperature = Double.parseDouble(inputText.getText());
            String selectedUnit = (String) inputComboBox.getSelectedItem();
            double result = (selectedUnit.equals("Celsius")) ? convertToFahrenheit(inputTemperature) : convertToCelsius(inputTemperature);
            outputText.setText(String.valueOf(result));
            if (selectedUnit.equals("Celsius")) {
                outcomeLabel.setText("Celsius");
            } else {
                outcomeLabel.setText("Fahrenheit");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(temperatureConvertor.this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double convertToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}


