package src;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
    /**
    * Prompts user for a date.
    * @author Xavier Jones
    * @author Brianna Soto
    * @author Jamel Clarke
    */
    public class EnterDateFrame extends JFrame  implements ActionListener{

        /** Label prompting user ot enter a date */
        private JLabel lblEnterDate = new JLabel("Enter a date (XX/XX/XXXX): ");

        /** Text field capturing date that the user enters. */
        private JTextField txtEnterDate = new JTextField();

        /** Button to cancel process */
        private JButton btnCancel = new JButton("Cancel");

        /** Button to submit date */
        private JButton btnSubmit = new JButton("Submit");

        /** String holding date to be sent */
        public String date;

        /** Constructor intiializing Date Frame */
        public EnterDateFrame() {
            super("Date Entry");
            setSize(500,150);
            setResizable(false);
            Container c = getContentPane();
            c.setBackground(Color.pink);
            c.setForeground(Color.white);
            c.setLayout(new GridLayout(2,2));

            c.add(lblEnterDate);
            lblEnterDate.setForeground(Color.white);

            c.add(txtEnterDate);
            txtEnterDate.setForeground(Color.pink);

            c.add(btnSubmit);
            btnSubmit.setForeground(Color.pink);

            c.add(btnCancel);
            btnCancel.setForeground(Color.pink);

            setVisible(true);
        }

    /**
    * Implements actionPerformed for buttons in the program
    * @param event
    */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == btnCancel){
            this.dispose();
        }

        if (event.getSource() == btnSubmit){
            this.date = txtEnterDate.getText();
            this.dispose();
        }

    }
}
