package org.karpinen.nst.gui;

import org.karpinen.nst.number.convert.Converter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NSTConvert extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField inputField = new JTextField();
    private JTextArea outputArea = new JTextArea("Operation Output displays here.");
    private JButton runButton = new JButton("Convert");
    private JComboBox startNS = new JComboBox();
    private JComboBox targetNS = new JComboBox();
    private JLabel startBase = new JLabel("StartNS");
    private JLabel targetBase = new JLabel("TargetNS");
    private Converter converter = new Converter();

    public NSTConvert() {

        init();
    }

    //Initiation.
    private void init() {
        frame = new JFrame("NST");
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
        frame.setSize(565, 300);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //Adds the components to the JFrame.
    private void addComponents() {
        frame.add(runButton);
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
        startBase.setBounds(10, 10, 120, 12);
        startBase.setText("StartNS");
        startBase.setVisible(true);

        //Sets properties for the target base label.
        targetBase.setBounds(235, 10, 120, 12);
        targetBase.setText("TargetNS");
        targetBase.setVisible(true);
    }

    //Sets the ComboBox Properties.
    private void setBoxProperties() {
        //StartingNS properties.
        startNS.setBounds(10, 25,220 , 30);
        startNS.addItem("Binary");
        startNS.addItem("Decimal");
        startNS.addItem("Hexadecimal");
        startNS.addItem("Octal");
        startNS.setVisible(true);

        //TargetNS properties.
        targetNS.setBounds(235, 25, 220, 30);
        targetNS.addItem("Binary");
        targetNS.addItem("Decimal");
        targetNS.addItem("Hexadecimal");
        targetNS.addItem("Octal");
        targetNS.setVisible(true);
    }

    //Set the inputField properties.
    private void setFieldProperties() {
        inputField.setBounds(10, 60, 536, 30);
        inputField.setVisible(true);
    }

    //Set the convertButton properties.
    private void setButtonProperties() {
        runButton.setBounds(460, 25, 85, 30);
        runButton.addActionListener(this);
        runButton.setVisible(true);
    }

    //Set the outputArea properties.
    private void setTextAreaProperties() {
        outputArea.setBounds(10, 95, 535, 160);
        outputArea.setVisible(true);
    }

    @Override
    //Listener for convertButton interaction.
    public void actionPerformed(ActionEvent e) {
        int startID = converter.resolveBaseID(startNS.getSelectedItem().toString());
        int endID = converter.resolveBaseID(targetNS.getSelectedItem().toString());
        String input = inputField.getText();
        String output = converter.convert(input, startID, endID);
        if(output != null) {
            outputArea.setText(output);
        }else{
            outputArea.setText("Error: Type Mismatch.");
        }
    }
}
