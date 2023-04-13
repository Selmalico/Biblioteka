import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class RegjistroAdmin {
	private JFrame Regjistroadmin;
	private JTextField user;
	private JPasswordField passwordField;
	private JTextField id;
	private JTextField email;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegjistroAdmin window=new RegjistroAdmin();
					window.Regjistroadmin.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RegjistroAdmin() {
		initialize();
	}
	
	private void initialize() {
		Regjistroadmin=new JFrame();
		Regjistroadmin.setTitle("Regjistro Administrator");
		Regjistroadmin.setBounds(100, 100, 625, 502);
		Regjistroadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Regjistroadmin.getContentPane().setLayout(null);
		Regjistroadmin.setLocationRelativeTo(null);
		
		JLabel lnlNewLabel=new JLabel("Regjisto Admin");
		lnlNewLabel.setForeground(Color.GRAY);
		lnlNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lnlNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lnlNewLabel.setBounds(211, 20, 160, 28);
		Regjistroadmin.getContentPane().add(lnlNewLabel);
		
		JLabel idad=new JLabel("ID-ja: ");
		idad.setFont(new Font("Tahoma", Font.BOLD, 12));
		idad.setBounds(64, 69, 141, 22);        
		Regjistroadmin.getContentPane().add(idad);
		
		JLabel emaili=new JLabel("Email-i: ");
		emaili.setFont(new Font("Tahoma", Font.BOLD, 12));
		emaili.setBounds(64, 127, 141, 22);
		Regjistroadmin.getContentPane().add(emaili);
		
		JLabel username=new JLabel("Emri: ");
		username.setFont(new Font("Tahoma", Font.BOLD, 12));
		username.setBounds(64, 183, 141, 22);
		Regjistroadmin.getContentPane().add(username);
		
		JLabel lblEnterPassword=new JLabel("Password-i: ");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterPassword.setBounds(64, 240, 141, 22);
		Regjistroadmin.getContentPane().add(lblEnterPassword);
		
		id = new JTextField();
		id.setBounds(265, 67, 189, 28);
		Regjistroadmin.getContentPane().add(id);
		id.setColumns(10);
		
		email = new JTextField();
		email.setBounds(265, 124, 189, 28);
		Regjistroadmin.getContentPane().add(email);
		email.setColumns(10);
		
		user = new JTextField();
		user.setBounds(265, 181, 189, 28);
		Regjistroadmin.getContentPane().add(user);
		user.setColumns(10);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(265, 238, 189, 28);
		Regjistroadmin.getContentPane().add(passwordField);
		
		JCheckBox chckbx=new JCheckBox("Show Password");
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
		Regjistroadmin.getContentPane().add(chckbx);
		
		JButton Cancel =new JButton("Kthehu pas");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[] {});
				Regjistroadmin.dispose();
		}
	});
		Cancel.setBounds(141, 372, 136, 40);
		Regjistroadmin.getContentPane().add(Cancel);
		
		JButton btn =new JButton("Ruaj");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=user.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				String idadmin=id.getText();
				String em=email.getText();
				 try {  
				        Class.forName("com.mysql.jdbc.Driver");  
				        // establish connection  
				        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");  
				        Statement statement = con.createStatement();  
				        statement.executeUpdate("INSERT INTO regjistroadmin VALUES("+"\""+ idadmin +"\""+"," +"\"" +em+ "\""+","+"\""+name +"\""+","+"\""+password +"\""+")");
				       
				        JOptionPane.showMessageDialog(null, "Ju u shtuat si administrator."); 
				        AdminKryesore.main(new String[] {});
				        Regjistroadmin.dispose();
				        statement.close();  
				        con.close();  
				     
				    } catch (SQLException | ClassNotFoundException e1) {  
				        JOptionPane.showMessageDialog(null, e1);  
				    }
		}
	});
		btn.setBounds(378, 372, 136, 40);
		Regjistroadmin.getContentPane().add(btn);
		
	}

}
