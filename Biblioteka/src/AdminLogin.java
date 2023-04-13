import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminLogin {
	private JFrame frmAdminLogin;
	private JTextField email;
	private JPasswordField passwordField;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window=new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminLogin() {
		initialize();
	}
	
	private void initialize() {
		frmAdminLogin=new JFrame();
		frmAdminLogin.setTitle("Administrator Login");
		frmAdminLogin.setBounds(100, 100, 625, 502);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		frmAdminLogin.setLocationRelativeTo(null);
		
		JLabel lnlNewLabel=new JLabel("Admin Login");
		lnlNewLabel.setForeground(Color.GRAY);
		lnlNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lnlNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lnlNewLabel.setBounds(211, 113, 160, 28);
		frmAdminLogin.getContentPane().add(lnlNewLabel);
		
		JLabel useremail=new JLabel("Email-i: ");
		useremail.setFont(new Font("Tahoma", Font.BOLD, 12));
		useremail.setBounds(64, 183, 141, 22);
		frmAdminLogin.getContentPane().add(useremail);
		
		JLabel lblEnterPassword=new JLabel("Password-i: ");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterPassword.setBounds(64, 240, 141, 22);
		frmAdminLogin.getContentPane().add(lblEnterPassword);
		
		email = new JTextField();
		email.setBounds(265, 181, 189, 28);
		frmAdminLogin.getContentPane().add(email);
		email.setColumns(10);
		
		passwordField=new JPasswordField();
		passwordField.setBounds(265, 238, 189, 28);
		frmAdminLogin.getContentPane().add(passwordField);
		
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
		frmAdminLogin.getContentPane().add(chckbx);
		
		JButton kthehu =new JButton("Kthehu pas");
		kthehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hyrje.main(new String[] {});
				frmAdminLogin.dispose();
		}
	});
		kthehu.setBounds(141, 372, 136, 40);
		frmAdminLogin.getContentPane().add(kthehu);
		
		JButton btn =new JButton("Log In");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eml=email.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				
				if(eml.equals("admin@gmail.com")&& password.equals("admin123")) {
					AdminKryesore.main(new String[] {});
					frmAdminLogin.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frmAdminLogin, "Gabim! Email ose Password i gabuar!",null, JOptionPane.ERROR_MESSAGE);
				}
			}
	});
	
		btn.setBounds(378, 372, 136, 40);
		frmAdminLogin.getContentPane().add(btn);
		

}
}
