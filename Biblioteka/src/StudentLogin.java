import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StudentLogin {
	private JFrame frmstlogin;
	private JTextField user;
	private JPasswordField passwordField;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window=new StudentLogin();
					window.frmstlogin.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public StudentLogin() {
		initialize();
	}
	
	private void initialize() {
		frmstlogin=new JFrame();
		frmstlogin.setTitle("Login Studenti");
		frmstlogin.setBounds(100, 100, 625, 502);
		frmstlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmstlogin.getContentPane().setLayout(null);
		frmstlogin.setLocationRelativeTo(null);
		
		JLabel lb=new JLabel("Student Login");
		lb.setForeground(Color.GRAY);
		lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setBounds(211, 113, 160, 28);
		frmstlogin.getContentPane().add(lb);
		
		JLabel userem=new JLabel("Email-i juaj: ");
		userem.setFont(new Font("Tahoma", Font.BOLD, 12));
		userem.setBounds(64, 183, 141, 22);
		frmstlogin.getContentPane().add(userem);
		
		JLabel Password=new JLabel("Password-i juaj: ");
		Password.setFont(new Font("Tahoma", Font.BOLD, 12));
		Password.setBounds(64, 240, 141, 22);
		frmstlogin.getContentPane().add(Password);
		
		user = new JTextField();
		user.setBounds(265, 181, 189, 28);
		frmstlogin.getContentPane().add(user);
		user.setColumns(10);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(265, 238, 189, 28);
		frmstlogin.getContentPane().add(passwordField);
		
		JCheckBox chckbx=new JCheckBox("Shfaq Password-in");
		chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
		}
	});
		chckbx.setBounds(318, 291, 136, 23);
		frmstlogin.getContentPane().add(chckbx);
		
		JButton pas =new JButton("Kthehu Pas");
		pas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hyrje.main(new String[] {});
				frmstlogin.dispose();
		}
	});
		pas.setBounds(141, 372, 136, 40);
		frmstlogin.getContentPane().add(pas);
		
		JButton btn =new JButton("Log In");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email=user.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				 try{
			            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
			            Statement statement = con.createStatement();  
			            String query=("SELECT* FROM regjistrostudente WHERE Email="+"\""+email+"\""+" AND Password="+"\""+password+"\""+"");
			            ResultSet rs= statement.executeQuery(query);
			            if(rs.next()){
			                JOptionPane.showMessageDialog(null, "Gjendet Studenti..");
			                StudentKryesore.main(new String[] {});
			                frmstlogin.dispose();
			            }
			            else
			            {
			                JOptionPane.showMessageDialog(null, "Nuk gjendet Studenti..");
			            }
			            
			        }
			        catch (SQLException sqlException){
			            sqlException.printStackTrace();
			        }
			}
	});
	
		btn.setBounds(378, 372, 136, 40);
		frmstlogin.getContentPane().add(btn);
		

}
}
