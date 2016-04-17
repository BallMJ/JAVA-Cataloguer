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


public class Cataloguer{
    
    JFrame window;
    JPanel buttons, textFields; 
    JLabel first, second, third, fourth, fifth;
    JTextField textOne, textTwo, textThree, textFour, textFive;
    JButton save, clear;
  
    
    
    
   Cataloguer(){
       window = new JFrame("Cataloguer");
       buttons = new JPanel();
       textFields = new JPanel();
       first = new JLabel("Title");
       second = new JLabel("Publisher");
       third = new JLabel("Condition");
       fourth = new JLabel("Issues Published");
       fifth = new JLabel("Issues Owned");
       textOne = new JTextField("");
       textTwo = new JTextField("");
       textThree = new JTextField("");
       textFour = new JTextField("");
       textFive = new JTextField("");
       save = new JButton("Save");
       clear = new JButton("Clear");
       
       textFields.setLayout(new BoxLayout(textFields, BoxLayout.PAGE_AXIS));
       buttons.setLayout(new FlowLayout());
       
       textFields.add(first);
       textFields.add(textOne);
       textFields.add(second);
       textFields.add(textTwo);
       textFields.add(third);
       textFields.add(textThree);
       textFields.add(fourth);
       textFields.add(textFour);
       textFields.add(fifth);
       textFields.add(textFive);
       
       buttons.add(save);
       
       //adding action listener to the save button, which performs the saction of saving all the text stored in the textFields and saves them to a txt file
       save.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             String txtOne = textOne.getText();
             String txtTwo = textTwo.getText();
             String txtThree = textThree.getText();
             String txtFour = textFour.getText();
             String txtFive = textFive.getText();
             
             try{
                 FileWriter fw = new FileWriter("catalogue.txt", true);
                 fw.write("\r\n");
                 fw.write("NAME: "+txtOne+".");
                 fw.write("PUBLISHER: "+txtTwo+".");
                 fw.write("CONDITION: "+txtThree+".");
                 fw.write("NO OF ISSUES: "+txtFour+".");
                 fw.write("ISSUES OWNED: "+txtFive);
                 fw.close();
             }catch(IOException error){
                 System.out.println("error");
             }
             
           }
       });
       
       
       
       buttons.add(clear);
       
       clear.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               textOne.setText("");
               textTwo.setText("");
               textThree.setText("");
               textFour.setText("");
               textFive.setText("");
           }           
       });
       
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
