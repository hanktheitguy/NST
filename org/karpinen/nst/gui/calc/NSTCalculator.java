package org.karpinen.nst.gui.calc;

import org.karpinen.nst.number.core.NumberConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NSTCalculator extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Number System Tool");
    JTextField inputField = new JTextField();
    JTextArea outputArea = new JTextArea("Operation Output displays here.");
    JButton convertButton = new JButton("Convert");
    JComboBox startNS = new JComboBox();
    JComboBox targetNS = new JComboBox();
    JLabel startBase = new JLabel("StartNS");
    JLabel targetBase = new JLabel("TargetNS");

    public NSTCalculator() {
        init();
    }

    //Initiation.
    private void init() {
        setTextAreaProperties();
        setLabelProperties();
        setBoxProperties();
        setFieldProperties();
        setButtonProperties();
        setFrameProperties();
        addComponents();
    }

    //Sets the JFrame properties.
    private void setFrameProperties() {
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //Adds the components to the JFrame.
    private void addComponents() {
        frame.add(convertButton);
        frame.add(inputField);
        frame.add(startNS);
        frame.add(targetNS);
        frame.add(startBase);
        frame.add(targetBase);
        frame.add(outputArea);
    }

    //Set's the ComboBox(s) label properties.
    private void setLabelProperties() {
        //Sets properties for the starting base label.
        startBase.setBounds(10, 10, 60, 12);
        startBase.setText("StartNS");
        startBase.setVisible(true);

        //Sets properties for the target base label.
        targetBase.setBounds(200, 10, 60, 12);
        targetBase.setText("TargetNS");
        targetBase.setVisible(true);
    }

    //Sets the ComboBox Properties.
    private void setBoxProperties() {
        //StartingNS properties.
        startNS.setBounds(10, 25,180 , 30);
        startNS.addItem("Binary");
        startNS.addItem("Decimal");
        startNS.addItem("Hexadecimal");
        startNS.addItem("Octal");
        startNS.setVisible(true);

        //TargetNS properties.
        targetNS.setBounds(200, 25, 180, 30);
        targetNS.addItem("Binary");
        targetNS.addItem("Decimal");
        targetNS.addItem("Hexadecimal");
        targetNS.addItem("Octal");
        targetNS.setVisible(true);
    }

    //Set the inputField properties.
    private void setFieldProperties() {
        inputField.setBounds(10, 60, 280, 30);
        inputField.setVisible(true);
    }

    //Set the convertButton properties.
    private void setButtonProperties() {
        convertButton.setBounds(295, 60, 85, 30);
        convertButton.addActionListener(this);
        convertButton.setVisible(true);
    }

    //Set the outputArea properties.
    private void setTextAreaProperties() {
        outputArea.setBounds(10, 100, 370, 50);
        outputArea.setVisible(true);
    }

    @Override
    //Listener for convertButton interaction.
    public void actionPerformed(ActionEvent e) {
        String startSys = (String) startNS.getSelectedItem();
        String targetSys = (String) targetNS.getSelectedItem();
        String input = inputField.getText();
        NumberConverter nc = new NumberConverter(startSys, targetSys, input);
        outputArea.setText(nc.getResult());
    }
}
