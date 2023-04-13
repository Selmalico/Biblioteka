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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
public class MenaxhoStudentet {
	
	private JFrame frmstudentet;
	private JTextField em;
	private JTextField emailtxt;
	private JTextField dega;
	private JTextField kontakt;
	private JTextField adres;
	private JPasswordField password;
	private JTextField idstudent;
	private JTable table;
	private JTextField dataregj;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenaxhoStudentet window=new MenaxhoStudentet();
					window.frmstudentet.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public MenaxhoStudentet() {
		initialize();
		tableupdate();
	}
	 Connection Con=null;
	    Statement St=null;
	    ResultSet Rs=null;
	    private void tableupdate()
	    {
	        try{
	            Con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
	            St=Con.createStatement();
	            Rs=St.executeQuery("Select * from projektlibraria.regjistrostudente");
	            table.setModel(DbUtils.resultSetToTableModel(Rs));
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	private void initialize() {
		frmstudentet=new JFrame();
		frmstudentet.setTitle("STUDENTET E FE");
		frmstudentet.setBackground(Color.cyan);
		frmstudentet.setBounds(100, 100, 625, 502);
		frmstudentet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmstudentet.getContentPane().setLayout(null);
		frmstudentet.setLocationRelativeTo(null);
		
		JLabel lb=new JLabel("Emri: ");
		lb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lb.setBounds(10, 126, 74, 14);
		frmstudentet.getContentPane().add(lb);
		
		JLabel lblPassword=new JLabel("Password: ");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(10, 171, 74, 14);
		frmstudentet.getContentPane().add(lblPassword);
		
		JLabel lbemail=new JLabel("Email: ");
		lbemail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbemail.setBounds(10, 218, 74, 14);
		frmstudentet.getContentPane().add(lbemail);
		
		JLabel lbdega=new JLabel("Dega: ");
		lbdega.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbdega.setBounds(346, 86, 74, 14);
		frmstudentet.getContentPane().add(lbdega);
		
		JLabel lbkontakt=new JLabel("Kontakti: ");
		lbkontakt.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbkontakt.setBounds(346, 126, 68, 14);
		frmstudentet.getContentPane().add(lbkontakt);
		
		JLabel lbadres=new JLabel("Adresa: ");
		lbadres.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbadres.setBounds(346, 171, 74, 14);
		frmstudentet.getContentPane().add(lbadres);
		
		em= new JTextField();
		em.setBounds(90, 121, 130, 27);
		frmstudentet.getContentPane().add(em);
		em.setColumns(10);
		
		emailtxt= new JTextField();
		emailtxt.setBounds(90, 213, 130, 27);
		emailtxt.setColumns(10);
		frmstudentet.getContentPane().add(emailtxt);
		
		
		dega= new JTextField();
		dega.setBounds(426, 78, 130, 27);
		frmstudentet.getContentPane().add(dega);
		dega.setColumns(10);
		
		kontakt= new JTextField();
		kontakt.setBounds(426, 121, 130, 27);
		kontakt.setColumns(10);
		frmstudentet.getContentPane().add(kontakt);
		
		adres = new JTextField();
		adres.setBounds(426, 162, 130, 34);
		adres.setColumns(10);
		frmstudentet.getContentPane().add(adres);
		
		password = new JPasswordField();
		password.setBounds(90, 166, 130, 34);
		frmstudentet.getContentPane().add(password);
		
		JLabel l=new JLabel("Shto-Fshi-Kerko Studente");
		l.setBounds(180, 33, 333, 34);
		l.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmstudentet.getContentPane().add(l);
		DefaultTableModel dtm=new DefaultTableModel();
		
		idstudent= new JTextField();
		idstudent.setBounds(90, 78, 130, 27);
		frmstudentet.getContentPane().add(idstudent);
		idstudent.setColumns(10);
		idstudent.setBackground(Color.white);
		
		JLabel l2=new JLabel("ID");
		l2.setBounds(10, 81, 74, 14);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frmstudentet.getContentPane().add(l2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 256, 568, 151);
		frmstudentet.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(dtm);
		
		JButton buton =new JButton("Shto Student");
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new String [] {idstudent.getText(),em.getText(),password.getText(),emailtxt.getText(),adres.getText(),dega.getText(),kontakt.getText(),dataregj.getText()});
				String id=idstudent.getText();
				String emr=em.getText();
				String pass=password.getText();
				String eml=emailtxt.getText();
				String adr=adres.getText();
				String degst=dega.getText();
				int ko=Integer.parseInt(kontakt.getText());
				String data=dataregj.getText();
				if (!data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) { 
			        JOptionPane.showMessageDialog(null, "Kujdes! Data duhet te kete formatin dd/mm/yyyy");
			        return;
				}
			try {  
		        Class.forName("com.mysql.jdbc.Driver");   
		        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");  
		        Statement st = con.createStatement();  
		        try {
		        	 st.executeUpdate("INSERT INTO regjistrostudente VALUES("+"\""+ id +"\""+"," +"\"" +emr + "\""+"," +"\"" +pass + "\""+"," +"\"" +eml + "\""+"," +"\"" +adr + "\""+"," +"\"" +degst + "\""+"," +"\"" +ko + "\""+"," +"\"" +data+ "\""+")");
		        }catch(SQLException ex) {
		        	JOptionPane.showMessageDialog(null, "Kjo ID studenti ekziston! Vendosni nje id unike.");
		        	return;
		        }
		       
		       
		        JOptionPane.showMessageDialog(null, "Ju shtuat nje student te ri"); 
		        tableupdate();
		        st.close();  
		        con.close();
		     
		    } catch (SQLException | ClassNotFoundException f) { 
		        JOptionPane.showMessageDialog(null,f);  
		    }
		}
			
	});
		
		buton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buton.setBounds(10, 418, 118, 34);
		frmstudentet.getContentPane().add(buton);
	
		JButton fshi=new JButton("Fshi Student");
		fshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idstudent.getText();
				String emr=em.getText();
				try{
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
		            Statement statement = con.createStatement();
		            statement.executeUpdate("DELETE FROM regjistrostudente WHERE Id = "+"\""+id+"\""+" AND Emri="+"\""+emr+"\""+"");
		            JOptionPane.showMessageDialog(null, "Te dhenat u fshine");
		             statement.close();
		            con.close();
		            tableupdate();

		        }
		        catch(SQLException | ClassNotFoundException e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
	});
		fshi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		fshi.setBounds(335, 418, 123, 34);
		frmstudentet.getContentPane().add(fshi);
		
		JButton pastro =new JButton("Pastro");
		pastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idstudent.setText("");
				em.setText("");
				password.setText("");
				emailtxt.setText("");
				adres.setText("");
				dega.setText("");
				kontakt.setText("");
				dataregj.setText("dd/mm/yyyy");
				
		}
	});
		pastro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pastro.setBounds(486, 418, 113, 34);
		frmstudentet.getContentPane().add(pastro);
		
		JButton kerko =new JButton("Kerko Student");
		kerko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String idst=idstudent.getText();
				 try{
					 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
					 Statement stmt = con.createStatement();
					 String query= ("SELECT * FROM regjistrostudente WHERE Id= "+"\""+ idst +"\""+"");
					           stmt.execute(query);
					           ResultSet rs= stmt.executeQuery(query);
					          if(rs.next()){
					    JOptionPane.showMessageDialog(null, "te dhenat u gjenden / ");
					           idstudent.setText(rs.getString("Id"));
					           em.setText(rs.getString("Emri"));
					           emailtxt.setText(rs.getString("Email"));
					           dega.setText(rs.getString("Dega"));
					           kontakt.setText(rs.getString("Kontakt"));
					           adres.setText(rs.getString("Adresa"));
					           password.setText(rs.getString("Password"));
					           dataregj.setText(rs.getString("Data"));
					           
					          }
					          else
					          {
					            JOptionPane.showMessageDialog(null,"Nuk u gjet studenti / ");  
					          }
					     }                                        
					 catch (SQLException sqlException) {
					                     sqlException.printStackTrace();
					                 }
			}
		
	});
		kerko.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kerko.setBounds(180, 418, 130, 34);
		frmstudentet.getContentPane().add(kerko);
		
		JLabel date=new JLabel("Date");
		date.setFont(new Font("Times New Roman", Font.BOLD, 14));
		date.setBounds(346, 219, 46, 14);
		frmstudentet.getContentPane().add(date);
		
		dataregj= new JTextField();
		dataregj.setText("dd/mm/yyyy");
		dataregj.setBounds(426, 216, 130, 27);
		frmstudentet.getContentPane().add(dataregj);
		dataregj.setColumns(10);
		
		JButton kthehu =new JButton("Kthehu pas");
		kthehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminKryesore.main(new String[] {});
				frmstudentet.dispose();
		}
	});
		kthehu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kthehu.setBounds(480, 10, 110, 34);
		frmstudentet.getContentPane().add(kthehu);
		
		dtm.setColumnIdentifiers(new String[] {"ID","Emri","Password","Email","Adresa","Dega","Kontakt","Data regj"});
	}
}

