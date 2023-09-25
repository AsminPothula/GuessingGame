/*
 *  Asmin Pothula 1001904488
 */
package code6_1001904488;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Password extends JFrame
{
    private final JPasswordField passwordField;
    
    String password = " ";
    final String actualPassword = "uta";
    
    public Password()
    {
        super("Enter Password");
        
        setLayout(new FlowLayout());
        
        passwordField = new JPasswordField(25);
        passwordField.setEchoChar('X');
        add(passwordField);
        
        EventHandler handle = new EventHandler();
        passwordField.addActionListener(handle);
    }
    
    private class EventHandler implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
            if(event.getSource() == passwordField)
            {
                password = event.getActionCommand();
            }
            
            if(password.equals(actualPassword))
            {
                setVisible(false);
                
                GameFrame gframe = new GameFrame();
                gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gframe.setSize(2000, 1500);
                gframe.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Entered password is incorrect");
            }
        }
       
    }
          
}
