/*
 * Name: Ralph Pereira
 * Assign 3
 * A modified assing 2, basically dynamic valadation, done with action and focus listeners on the text field
 * If all the fields are correct it writes the information to a queue file
 */

import java.awt.*;
import javax.swing.*;
import java.io.*;

import java.awt.event.*;

public class CheckedForm extends javax.swing.JFrame {

    JPanel pan = new JPanel(new BorderLayout());
    JButton ok = new JButton("Okay");
    JButton quit = new JButton("Quit");

    JLabel lblDate = new JLabel("Date: ", JLabel.RIGHT);
    JTextField txtDate = new JTextField("dd/mm/yyyy", 10);

    JLabel lblTime = new JLabel("Time: ", JLabel.RIGHT);
    JTextField txtTime = new JTextField("HH:MM AM/PM ", 12);

    JLabel lblOrder = new JLabel("Order: ", JLabel.RIGHT);
    JTextField txtOrder = new JTextField("##-####-#", 10);

    JLabel lblItem = new JLabel("Item: ", JLabel.RIGHT);
    JTextField txtItem = new JTextField("##-##", 10);

    JLabel lblQuantity = new JLabel("Quantity: ", JLabel.RIGHT);
    JTextField txtQuantity = new JTextField("(1-99)", 10);

    JLabel lblAddress = new JLabel("Address: ", JLabel.RIGHT);
    JTextArea txtAddress = new JTextArea("123 Fake Street \n POSTAL, STATE");

    public Boolean checked = false;

    public CheckedForm() {
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Welcome to the queue app");

        pan.add(getButtonPanel(), BorderLayout.PAGE_END);
        pan.add(getTextPanel(), BorderLayout.NORTH);
        pan.add(getCenterPanel(), BorderLayout.CENTER);

        this.add(pan);
        this.setVisible(true);
    }

    protected JComponent getTextPanel() {

        JPanel textPan = new JPanel();
        textPan.setLayout(new GridLayout(0, 4));
        //setting the initial labels to red
        lblDate.setForeground(Color.RED);
        lblTime.setForeground(Color.RED);
        lblOrder.setForeground(Color.RED);
        lblItem.setForeground(Color.RED);
        lblQuantity.setForeground(Color.RED);
        /*
        The action listeners check for the user hitting enter and calls the respective
        checker methods. If the format matches it turns the label black and
        it moves on. If not it keeps the label red. 
         */
        //action listner for date
        txtDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!dateCheck(txtDate.getText())) {
                    lblDate.setForeground(Color.RED);
                } else {
                    lblDate.setForeground(Color.BLACK);
                }

            }
        });
        //action listener for time
        txtTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!timeCheck(txtTime.getText())) {
                    lblTime.setForeground(Color.RED);
                } else {
                    lblTime.setForeground(Color.BLACK);
                }

            }
        });
        //action listener for order number
        txtOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!orderCheck(txtOrder.getText())) {
                    lblOrder.setForeground(Color.RED);
                } else {
                    lblOrder.setForeground(Color.BLACK);
                }

            }
        });
        //action listener for item number
        txtItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!itemCheck(txtItem.getText())) {
                    lblItem.setForeground(Color.RED);
                } else {
                    lblItem.setForeground(Color.BLACK);
                }

            }
        });
        //action listener for quantity
        txtQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!qCheck(txtQuantity.getText())) {
                    lblQuantity.setForeground(Color.RED);
                } else {
                    lblQuantity.setForeground(Color.BLACK);
                }

            }
        });
        /*
        The following focus listeners basically do the same thing as the
        action listeners do, but it checks the field each time it
        comes into and out of focus
         */
        //focus listener for Date
        txtDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!dateCheck(txtDate.getText())) {
                    lblDate.setForeground(Color.RED);
                } else {
                    lblDate.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!dateCheck(txtDate.getText())) {
                    lblDate.setForeground(Color.RED);
                } else {
                    lblDate.setForeground(Color.BLACK);
                }
            }

        });
        //focus listener for Time
        txtTime.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!timeCheck(txtTime.getText())) {
                    lblTime.setForeground(Color.RED);
                } else {
                    lblTime.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!timeCheck(txtTime.getText())) {
                    lblTime.setForeground(Color.RED);
                } else {
                    lblTime.setForeground(Color.BLACK);
                }
            }

        });
        //focus listener for order
        txtOrder.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!orderCheck(txtOrder.getText())) {
                    lblOrder.setForeground(Color.RED);
                } else {
                    lblOrder.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!orderCheck(txtOrder.getText())) {
                    lblOrder.setForeground(Color.RED);
                } else {
                    lblOrder.setForeground(Color.BLACK);
                }
            }

        });
        //focus listener for item
        txtItem.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!itemCheck(txtItem.getText())) {
                    lblItem.setForeground(Color.RED);
                } else {
                    lblItem.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!itemCheck(txtItem.getText())) {
                    lblItem.setForeground(Color.RED);
                } else {
                    lblItem.setForeground(Color.BLACK);
                }
            }

        });
        //focus listener for quantity
        txtQuantity.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!qCheck(txtQuantity.getText())) {
                    lblQuantity.setForeground(Color.RED);
                } else {
                    lblQuantity.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!qCheck(txtQuantity.getText())) {
                    lblQuantity.setForeground(Color.RED);
                } else {
                    lblQuantity.setForeground(Color.BLACK);
                }
            }

        });
        //add all the fields on to the jplane
        textPan.add(lblDate);
        textPan.add(txtDate);
        textPan.add(lblTime);
        textPan.add(txtTime);
        textPan.add(lblOrder);
        textPan.add(txtOrder);
        textPan.add(lblItem);
        textPan.add(txtItem);
        textPan.add(lblQuantity);
        textPan.add(txtQuantity);
        return textPan;
    }

    protected JComponent getCenterPanel() {
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout());
        textArea.add(lblAddress);
        txtAddress.setLineWrap(true);
        txtAddress.setPreferredSize(new Dimension(350, 50));
        JScrollPane scrollPane = new JScrollPane(txtAddress);

        textArea.add(scrollPane);
        return textArea;
    }

    protected JComponent getButtonPanel() {
        JPanel buttonPan = new JPanel();
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (checked) {
                    writeQueue();
                    txtDate.setText("");
                    txtTime.setText("");
                    txtOrder.setText("");
                    txtItem.setText("");
                    txtQuantity.setText("");
                    txtAddress.setText("");
                }
            }
        });
        buttonPan.add(ok);
        buttonPan.add(quit);
        return buttonPan;
    }

    /*
    The following checker methods check each type of field
    it checks passed strings with the respective regex and returns true if 
    it matches, false if not. It also turns a boolean true or false if it matches or not
    The boolean is used for the OK button at the end. 
     */
    public Boolean dateCheck(String date) {
        if (date.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")) {
            checked = true;
            return true;
        } else {
            checked = false;
            return false;
        }
    }

    public Boolean timeCheck(String time) {
        if (time.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)")) {
            checked = true;
            return true;
        } else {
            checked = false;
            return false;
        }
    }

    public Boolean orderCheck(String order) {
        if (order.matches("([0-9][0-9])-([0-9][0-9][0-9][0-9])-([0-9])")) {
            checked = true;
            return true;
        } else {
            checked = false;
            return false;
        }
    }

    public Boolean itemCheck(String item) {
        if (item.matches("([0-9][0-9])-([0-9][0-9])")) {
            checked = true;
            return true;
        } else {
            checked = false;
            return false;
        }
    }

    public Boolean qCheck(String q) {
        if (q.matches("([0-9][0-9])")) {
            checked = true;
            return true;
        } else {
            checked = false;
            return false;
        }
    }

    public void writeQueue() {
        try {
            File file = new File("queue.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter print = new PrintWriter(bw);

            print.print("Date: " + txtDate.getText() + "\t");
            print.print("Time: " + txtTime.getText() + "\t");
            print.print("Order: " + txtOrder.getText() + "\t");
            print.print("Item: " + txtItem.getText() + "\t");
            print.print("Quantity: " + txtQuantity.getText() + "\t");
            print.print("Address: " + txtAddress.getText() + "\t");
            print.println("\n");
            print.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CheckedForm();

    }
}
