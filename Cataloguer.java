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

public class Cataloguer{
    
    //creating objects
    JFrame window;
    JPanel buttons, textFields; 
    JLabel title, publisher, condition, issPub, issOwn;
    JTextField fieldOne, fieldTwo, fieldThree, fieldFour, fieldFive;
    JButton save, clear;
    
   Cataloguer(){
       
       //assigning info to variables
       window = new JFrame("Cataloguer");
       window.setPreferredSize(new Dimension(400, 270));
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
       
       //Creating a Dialog box to ask for the user to type the filename they want to store their catalogue in 
       String inputFileName = JOptionPane.showInputDialog(null, "Please type your catalogue filename");
       
       buttons.add(save);
       
       //adding action listener to the save button, which performs the saction of saving all the text stored in the textFields and saves them to a txt file
       save.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             String txtOne = fieldOne.getText();
             String txtTwo = fieldTwo.getText();
             String txtThree = fieldThree.getText();
             String txtFour = fieldFour.getText();
             String txtFive = fieldFive.getText();
             
             try{
                 //Opening file and setting it to append on a new line
                 //applying dialog box inputFileName value to the filename
                 FileWriter fw = new FileWriter(inputFileName+".txt", true);
                 while(true){
                    //adding a new line before writing text to file
                    fw.write("\r\n");
                    //writing all data entered into text field to file
                    fw.write("NAME: "+txtOne+" ");
                    fw.write("PUBLISHER: "+txtTwo+" ");
                    fw.write("CONDITION: "+txtThree+" ");
                    fw.write("NO OF ISSUES: "+txtFour+" ");
                    fw.write("ISSUES OWNED: "+txtFive);
                    //closing file
                    fw.close();
                 }
            }catch(IOException error){
                 System.out.println("Error - file could not be opened");
             }
             
           }
       });
       //adding button 'clear'
       buttons.add(clear);
       //adding action listener to the clear button, so it can erase and reset all data typed into text field
       clear.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //reseting all text fields to empty and clearing all data entered out 
               fieldOne.setText("");
               fieldTwo.setText("");
               fieldThree.setText("");
               fieldFour.setText("");
               fieldFive.setText("");
           }           
       });
       
       //adjusting window layout
       window.add(textFields, BorderLayout.PAGE_START);
       window.add(buttons, BorderLayout.PAGE_END);
       
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.pack();
       window.setVisible(true);
       window.setResizable(true);     
      
   }
   
   public static void main(String args[]){
       new Cataloguer();
   }

}
