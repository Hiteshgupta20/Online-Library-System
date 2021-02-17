package onlineLibrary;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public  class Login_user extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
    private JButton b1;


	public Login_user() {
    super("Login");
	setBackground(new Color(169, 169, 169));	
    setBounds(600, 400, 550, 300);
	setLocation(400,200);
    panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230));
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(250, 250, 210));
	b1.setBounds(190, 160, 113, 39);
	panel.add(b1);
		
   /* b2 = new JButton("SignUp");
	b2.addActionListener(this);
	b2.setForeground(new Color(139, 69, 19));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 39);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
    b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 231, 179, 39);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(70, 240, 130, 20);
	panel.add(l5);*/

	JPanel panel2 = new JPanel();
	panel2.setBackground(new Color(176, 224, 230));
	panel2.setBounds(24, 40, 434, 263);
	panel.add(panel2);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			if(textField.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Fill the required fields");
			else{
			
			try {
				//Connection class
				Conn con=new Conn();
				//Sql statement as string
				String sql ="select * from account where username=? and password=?";
				//Prepare statement for executing query from database
				PreparedStatement st = con.c.prepareStatement(sql);
				
				//Replace the ? in sql string  with th username and password from the database
				st.setString(1,textField.getText());
				st.setString(2, passwordField.getText());
				
				//ResultSet = Execute data line by line 
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					this.setVisible(false);
					new Loading().setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Invalid username and password");
			}catch (Exception e2) {
				e2.printStackTrace();
			}}
		}
			}
		
	
	public static void main(String[] args) {
		new Login_user().setVisible(true);
	}
}