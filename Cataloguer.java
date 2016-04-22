package Cataloguer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;

public class Cataloguer {

    //creating objects
    JFrame window;
    JPanel buttons, textFields;
    JLabel title, publisher, condition, issPub, issOwn;
    JTextField fieldOne, fieldTwo, fieldThree, fieldFour, fieldFive;
    JButton save, clear;
    JMenuItem newTab, helpTab;
    FileWriter fw;
    //String x takes the name of the file created in the 'File menu' to then be used by the save button, so it can periodically save when needed by the user
    String x;

    Cataloguer() {

        //Creating JFrame
        window = new JFrame("Cataloguer");

        //creating and adding the JMenuBar	   
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menu.add(fileMenu);

        //Creating and adding the drop down tabs of the JMenuBar
        newTab = new JMenuItem("New", KeyEvent.VK_N);
        helpTab = new JMenuItem("Help", KeyEvent.VK_N);
        fileMenu.add(newTab);
        fileMenu.add(helpTab);

        window.setJMenuBar(menu);

        //assigning info to variables
        window.setPreferredSize(new Dimension(400, 290));
        buttons = new JPanel();
        textFields = new JPanel();
        title = new JLabel("Title");
        publisher = new JLabel("Publisher");
        condition = new JLabel("Condition");
        issPub = new JLabel("Issues Published");
        issOwn = new JLabel("Issues Owned");
        fieldOne = new JTextField("");
        fieldTwo = new JTextField("");
        fieldThree = new JTextField("");
        fieldFour = new JTextField("");
        fieldFive = new JTextField("");
        save = new JButton("Save");
        clear = new JButton("Clear");

        //setting layout of text fields
        textFields.setLayout(new BoxLayout(textFields, BoxLayout.PAGE_AXIS));
        buttons.setLayout(new FlowLayout());

        //assembling the jlabels and text fields in order
        textFields.add(title);
        textFields.add(fieldOne);
        textFields.add(publisher);
        textFields.add(fieldTwo);
        textFields.add(condition);
        textFields.add(fieldThree);
        textFields.add(issPub);
        textFields.add(fieldFour);
        textFields.add(issOwn);
        textFields.add(fieldFive);

        buttons.add(save);

        //importing the objects and their ActionListeners for the buttons and tabs 
        newTabAction();
        helpTabAction();
        saveButton();
        clearButton();

        //adjusting window layout
        window.add(textFields, BorderLayout.PAGE_START);
        window.add(buttons, BorderLayout.PAGE_END);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        window.setResizable(true);

    }

    //adding Action listener to the new tab under FILE > NEW
    public void newTabAction() {
        newTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Creating a Dialog box to ask for the user to type the filename they want to store their catalogue in 
                String t = JOptionPane.showInputDialog(null, "Please type your catalogue filename");

                try {
                    FileWriter fw = new FileWriter(t + ".txt", true);
                    //assigning the filename created of t to x so x can be used outside of the public void block and used in the save button
                    x = t;
                    System.out.println(x);

                } catch (IOException exception) {
                    System.out.println(x);
                    System.out.println(exception);
                }
            }
        });
    }

    public void helpTabAction() {
        helpTab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Message Dialog with help information on how to use the software
                JOptionPane.showMessageDialog(null, "Welcome to Cataloguer.\n"
                        + "To begin and start cataloguing your own Books, Comics, Graphic Novel and much more,\n"
                        + "simply click File > New, then name the file which will hold your catalogue.\n"
                        + "Next, fill-in all of the fields from Titles to Issues Owned, then simply click the\n"
                        + "big 'Save' button at the bottom. Well done, you have now made your first catalogue\n"
                        + "entry! Next, if you want to add more entries to your catalogue then simply click on\n"
                        + "the big 'Clear' button which will clear the text fields (Dont worry, it wont delete\n"
                        + "your previous entry, since you have just saved it!) and begin filling in all the\n"
                        + "fields in again from Titles to Issues Owned, and click on the big 'Save' button at\n"
                        + "the bottom again. Repeat this process for everything you wish to catalogue.\n"
                        + "Remember to save each entry!");
            }
        });
    }

    //adding action listener to the save button
    public void saveButton() {
        //adding action listener to the save button, which performs the saction of saving all the text stored in the textFields and saves them to a txt file
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txtOne = fieldOne.getText();
                String txtTwo = fieldTwo.getText();
                String txtThree = fieldThree.getText();
                String txtFour = fieldFour.getText();
                String txtFive = fieldFive.getText();

                try {
                    //Opening file and setting it to append on a new line
                    //applying dialog box inputFileName value to the filename
                    FileWriter fw = new FileWriter(x + ".txt", true);
                    while (true) {

                        //adding a new line before writing text to file
                        fw.write("\r\n");
                        //writing all data entered into text field to file
                        fw.write("NAME: " + txtOne + " ");
                        fw.write("PUBLISHER: " + txtTwo + " ");
                        fw.write("CONDITION: " + txtThree + " ");
                        fw.write("NO OF ISSUES: " + txtFour + " ");
                        fw.write("ISSUES OWNED: " + txtFive);
                        //closing file
                        fw.close();
                    }
                } catch (IOException error) {
                    System.out.println(x);
                    System.out.println(error);
                }
            }
        });
    }

    //adding action listener to the clear button
    public void clearButton() {
        //adding button 'clear'
        buttons.add(clear);
        //adding action listener to the clear button, so it can erase and reset all data typed into text field
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //reseting all text fields to empty and clearing all data entered out 
                fieldOne.setText("");
                fieldTwo.setText("");
                fieldThree.setText("");
                fieldFour.setText("");
                fieldFive.setText("");
            }
        });
    }

    public static void main(String args[]) {
        new Cataloguer();
    }

}
