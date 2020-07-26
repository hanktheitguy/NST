package org.karpinen.nst.gui;

import javax.swing.*;
import java.awt.*;

public class NST extends JFrame {
    private JFrame frame = new JFrame("Number System Tool");

    private JToolBar toolBar = new JToolBar();

    private JTextField inputField = new JTextField();
    private JTextArea outputField = new JTextArea();

    private JComboBox mode = new JComboBox();

    public NST() {
        init();
    }

    private void init() {
        setFrame();
        setToolBar();
        setInputField();
        setOutputField();
        setMode();
        addComponents();
    }

    private void addComponents() {
        frame.add(toolBar);
        frame.add(inputField);
        frame.add(outputField);
    }

    private void setFrame() {
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 250);
        frame.setVisible(true);
    }

    private void setToolBar() {
        toolBar.setFloatable(false);
        toolBar.setBounds(0, 0, 500, 40);
        toolBar.setVisible(true);
    }

    private void setInputField() {
        inputField.setBounds(0, 35, 500, 35);
        inputField.setToolTipText("Input");
        inputField.setVisible(true);
    }

    private void setOutputField() {
        outputField.setBounds(0, 72, 500, 136);
        outputField.setVisible(true);
    }

    private void setMode() {
        Dimension d = new Dimension();
        d.setSize(40, 20);
        mode.setPreferredSize(d);
    }
}
