import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class StudentKryesore {
	private JFrame frmstkryesore;
	private JTextField idst;
	private JTable table;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentKryesore window=new StudentKryesore();
					window.frmstkryesore.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public StudentKryesore() {
		initialize();
		
	}
	
	private void initialize() {
		frmstkryesore=new JFrame();
		frmstkryesore.setTitle("FAQJA E STUDENTIT");
		frmstkryesore.setBounds(100, 100, 625, 502);
		frmstkryesore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmstkryesore.getContentPane().setLayout(null);
		frmstkryesore.setLocationRelativeTo(null);
		
		JLabel lnl = new JLabel("Faqja e Studentit");
		lnl.setForeground(Color.red);
		lnl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lnl.setHorizontalAlignment(SwingConstants.CENTER);
		lnl.setBounds(211, 10, 200, 28);
		frmstkryesore.getContentPane().add(lnl);
		
		JLabel id=new JLabel("Shkruani ID-ne:");
		id.setFont(new Font("Times New Roman", Font.BOLD, 14));
		id.setBounds(64, 69, 141, 22);
		frmstkryesore.getContentPane().add(id);
		
		idst= new JTextField();
		idst.setBounds(265, 67, 189, 28);
		frmstkryesore.getContentPane().add(idst);
		idst.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 200, 568, 151);
		frmstkryesore.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		JButton lesho =new JButton("Shfaq Te Dhenat");
		lesho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=idst.getText();
				 try{
					 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
					 Statement stmt = con.createStatement();
					 String query= ("SELECT * FROM leshoktheliber WHERE Idstudenti= "+"\""+ i +"\""+"");
					           stmt.execute(query);
					           ResultSet rs1= stmt.executeQuery(query);
					           table.setModel(DbUtils.resultSetToTableModel(rs1));
					     }                                        
					 catch (SQLException sqlException) {
					                     sqlException.printStackTrace();
					                 }
				
				
		}
	});
		lesho.setBounds(10, 372, 136, 34);
		frmstkryesore.getContentPane().add(lesho);
		
		
		JButton kthehu =new JButton("Kthehu pas");
		kthehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin.main(new String[] {});
				frmstkryesore.dispose();
		}
	});
		kthehu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kthehu.setBounds(463, 372, 136, 34);
		frmstkryesore.getContentPane().add(kthehu);
		

  }
}
