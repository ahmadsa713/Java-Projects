
package textapp;

import javax.swing.JFrame;


public class TextApp {

  
    public static void main(String[] args) {
        
        TextEditGUI obj = new TextEditGUI();
        obj.setBounds(0,0,800,800);
        obj.setTitle("TextPad");
        obj.setVisible(true);
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
       
    }
    

