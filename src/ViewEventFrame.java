package src;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* The ViewEventFrame class creates a JFrame that allows for an event and its details (description,
* duration, and date) to be displayed.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
*/
public class ViewEventFrame extends JFrame implements ActionListener {

    /** Holds event that may be viewed */
    private Event viewedEvent;

    /** 'Events:' label */
    private JLabel lblDescriptionTitle = new JLabel("\t\tEvents:");

    /** [] */
    private JLabel lblDateRundown = new JLabel();

    /** Back button */
    private JButton btnBack = new JButton("Back");

    /** Exit button */
    private JButton btnExit = new JButton("Exit");

    /** Delete button */
    private JButton btnDelete = new JButton("Delete");

    /** Width of Frame */
    public static final int WIDTH = 400;

    /** Length of Frame */
    public static final int LENGTH = 300;

    /**
     * Creates a view Event frame that will display the details of an inputted Event
     * @param event the Event that will have its details displayed in the view Event frame
     */
    public ViewEventFrame(Event event) {
        super(event.getDescription());
        viewedEvent = event;
        setSize(WIDTH,LENGTH);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);
        c.setLayout(new GridLayout(3,2));

        //Adds action listeners
        btnBack.addActionListener(this);
        btnExit.addActionListener(this);
        btnDelete.addActionListener(this);

        c.add(lblDescriptionTitle);
        lblDescriptionTitle.setForeground(Color.white);

        c.add(lblDateRundown);
        lblDateRundown.setForeground(Color.white);
        lblDateRundown.setText(viewedEvent.toString());
        c.add(btnDelete);
        btnDelete.setForeground(Color.pink);

        c.add(btnBack);
        btnBack.setForeground(Color.pink);

        c.add(btnExit);
        btnExit.setForeground(Color.pink);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnExit) {
            System.exit(0);
        }

        if (event.getSource() == btnBack) {
            this.setVisible(false);
        }

        if (event.getSource() == btnDelete) {
            Event.events.remove(viewedEvent);
            this.setVisible(false);
        }
    }
}
