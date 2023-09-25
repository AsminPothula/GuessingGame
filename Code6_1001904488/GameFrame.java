/*
 *  Asmin Pothula 1001904488
 */
package code6_1001904488;

import javax.swing.JFrame;
//////import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameFrame extends JFrame
{
    private final JLabel label1;
    private final JButton OKButton;
    private final JButton CancelButton;
    private final JTextField textField;
    String CCName = "";
    //String userValue = "";
    
    public GameFrame()
    {
        super("Guess the Characters Game!!");
        setLayout(new FlowLayout());
        
        Random random = new Random();
        int rand = random.nextInt(4) + 1;
        
        switch(rand)
        {
            case 1:
            {
                CCName = "eleven";
                break;
            }
            case 2:
            {
                CCName = "max";
                break;
            }
            case 3:
            {
                CCName = "nancy";
                break;
            }
            case 4:
            {
                CCName = "robin";
                break;
            }
            default: 
            {
                System.out.print("Something went wrong");
                break;
            }    
        }
        
        Icon CC = new ImageIcon(getClass().getResource(CCName + ".png"));
        
        
        label1 = new JLabel();
        label1.setText("Guess the shown character");
        label1.setIcon(CC);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.BOTTOM);
        label1.setToolTipText("Character from Stranger Things");
        add(label1);
        
        EventHandler handle = new EventHandler ();
        textField = new JTextField("Enter your answer here");
        textField.addActionListener(handle);
        textField.selectAll();
        add(textField);
        
        OKButton = new JButton("OK");
        OKButton.addActionListener(handle);
        add(OKButton);
        
        CancelButton = new JButton("CANCEL");
        CancelButton.addActionListener(handle);
        add(CancelButton);
        
    }
    
    private class EventHandler implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
            boolean boo = false;
            String str= textField.getText();
            
            /*if (event.getSource() == textField)
            {
                userValue = event.getActionCommand();
            }*/
           
            if (CCName.equalsIgnoreCase(str))
            {
                str = "Guessed Correctly!!";
                boo = true;
            }
            else
            {
                str = "Guessed Incorrectly, guess again!";
            }
           
            if ((event.getSource() == OKButton) || (event.getSource() == textField))
            {
                JOptionPane.showMessageDialog (null, str);
                if(boo == true)
                {
                    System.exit(0);
                }
            }
            else if (event.getSource() == CancelButton)
            {
               System.exit(0);
            }
        }
   }    
}




//ok button nor enter works
//and the hint doesnt appear everytime...it does only sometimes 