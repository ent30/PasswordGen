/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anbr
 */
public class GeneratorUI implements ActionListener{
    
    private JFrame mainWindow ;
    private JPanel mainPanel ;
    private JButton button ;
    private JTextField txt ;
    private Character[] leftChars = {'q','Q','w','W','e','E','r','R','t','z','a','A','s','S','d','D','f','F','g','h','y','x','X','c','C','v','V','b'} ;
    private Character[] rightChars = {'u','U','i','I','o','O','p','P','+','j','J','k','K','l','L','#','n','N','m','M','?','/','=','*','B','Z','H','G'} ;
    
    /**
     * 
     */
    public void showUI() {
        
        mainWindow  = new JFrame("Passwort-o-mat") ;
        mainWindow.setBounds(400, 400, 220, 100);
        
        mainWindow.setIconImage(new ImageIcon(GeneratorUI.class.getResource("secret.png")).getImage());
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlowLayout layout = new FlowLayout();
        mainPanel = new JPanel() ;
        mainPanel.setLayout(layout);
        mainPanel.setBackground(new Color(255, 236, 217));
        
        
            txt = new JTextField(10);
            txt.setPreferredSize(new Dimension(125, 22)) ;
            mainPanel.add(txt) ;
            
            button = new JButton("Generiere!") ;
            button.addActionListener(this); 
            mainPanel.add(button) ;
        
        mainWindow.add(mainPanel) ;
        mainWindow.setVisible(true); 
    }
    
    
    /**
     * 
     */
    private void generatePasswort() {
        
        int pwLength = 7 ;
        StringBuilder password = new StringBuilder() ;
        Character[] charArray ;
        
        
        for(int i=0 ; i<pwLength; i++){
            
            if(i == 0 || i%2 == 0)
                charArray = leftChars ;
            else 
                charArray = rightChars ;
            
          password.append(charArray[myRandomWithHigh(0, charArray.length)]) ;
            
        }
        
       txt.setText(password.toString());
        
        
        
    }
    
    
    
    /**
     * 
     * @param low
     * @param high
     * @return 
     */
    public static int myRandomWithHigh(int low, int high) {
		//high++;
		return (int) (Math.random() * (high - low) + low);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.button){
            generatePasswort();
        }
            
        
    }

    

    
    
}
