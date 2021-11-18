package src;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.*;

public class ViewEventFrame extends JFrame{

    private JLabel lblDescriptionTitle = new JLabel("Events:");
    private JLabel lblDateRundown = new JLabel();
    private JButton btnBack = new JButton("Back");
    private JButton btnExit = new JButton("Exit");
   
    //TODO - Add action listeners for buttons
    //TODO - setDefaultCloseOperation should return to main menu, not exit
    public ViewEventFrame(Event event){
        super(event.getDate());
        setSize(300,150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);
        c.setLayout(new GridLayout(2,2));

        c.add(lblDescriptionTitle);
        lblDescriptionTitle.setForeground(Color.white);

        c.add(lblDateRundown);
        lblDateRundown.setForeground(Color.white);

        c.add(btnBack);
        btnBack.setForeground(Color.pink);

        c.add(btnExit);
        btnExit.setForeground(Color.pink);

        setVisible(true);
    }

    public static void main(String[] args) {
        ViewEventFrame editFrame = new ViewEventFrame(new Event("05/20/2003","Xavier's Birthday"));
    }
}
