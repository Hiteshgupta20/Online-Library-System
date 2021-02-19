package onlineLibrary;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public LibraryManagementSystem() {
        		super("Library Management System");
                setSize(900,390);
                setLayout(null);
                setLocationRelativeTo(null);
            	setResizable(false);
                l1 = new JLabel("");
                b1 = new JButton("Next");
                b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("onlinelibrary/icons/first.jpg"));
                Image i3 = i1.getImage().getScaledInstance(900, 390,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                b1.setBounds(650,250,100,40);
                l1.setBounds(0, 0, 900,390);
                l1.add(b1);
                add(l1);
                b1.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
