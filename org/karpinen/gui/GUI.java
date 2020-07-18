package org.karpinen.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Number System Tool");
    JTextField inputField = new JTextField();
    JTextArea outputArea = new JTextArea("Operation Output displays here.");
    JButton convertButton = new JButton("Convert");
    JComboBox startNS = new JComboBox();
    JComboBox targetNS = new JComboBox();
    JLabel startBase = new JLabel("StartNS");
    JLabel targetBase = new JLabel("TargetNS");

    public GUI() {
        init();
    }

    private void init() {
        setTextAreaProperties();
        setLabelProperties();
        setBoxProperties();
        setFieldProperties();
        setButtonProperties();
        setFrameProperties();
        addComponents();
    }

    private void setFrameProperties() {
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addComponents() {
        frame.add(convertButton);
        frame.add(inputField);
        frame.add(startNS);
        frame.add(targetNS);
        frame.add(startBase);
        frame.add(targetBase);
        frame.add(outputArea);
    }

    private void setLabelProperties() {
        //Sets properties for the starting base.
        startBase.setBounds(10, 10, 60, 12);
        startBase.setText("StartNS");
        startBase.setVisible(true);

        //Sets properties for the target base.
        targetBase.setBounds(200, 10, 60, 12);
        targetBase.setText("TargetNS");
        targetBase.setVisible(true);
    }

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

    private void setFieldProperties() {
        inputField.setBounds(10, 60, 280, 30);
        inputField.setVisible(true);
    }

    private void setButtonProperties() {
        convertButton.setBounds(295, 60, 85, 30);
        convertButton.addActionListener(this);
        convertButton.setVisible(true);
    }

    private void setTextAreaProperties() {
        outputArea.setBounds(10, 100, 370, 50);
        outputArea.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
