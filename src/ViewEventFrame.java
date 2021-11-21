package src;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.*;

/**
* The ViewEventFrame class creates a JFrame that allows for an event and its details (description,
* duration, and date) to be displayed.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
*/
public class ViewEventFrame extends JFrame implements ActionListener{

    /** 'Events:' label */
    private JLabel lblDescriptionTitle = new JLabel("Events:");

    /** [] */
    private JLabel lblDateRundown = new JLabel();

    /** Back button */
    private JButton btnBack = new JButton("Back");

    /** Exit button */
    private JButton btnExit = new JButton("Exit");


    //TODO - Add action listeners for buttons
    //TODO - setDefaultCloseOperation should return to main menu, not exit
    /**
     * Creates a view Event frame that will display the details of an inputted Event
     * @param event the Event that will have its details displayed in the view Event frame
     */
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

    /**
    * Implements actionPerformed for buttons in the program
    * @param event
    */
    @Override
    public void actionPerformed(ActionEvent event) {



    }

    public static void main(String[] args) {
        ViewEventFrame editFrame = new ViewEventFrame(new Event("05/20/2003","Xavier's Birthday"));
    }
}
