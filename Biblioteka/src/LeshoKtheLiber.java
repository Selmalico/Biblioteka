import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class LeshoKtheLiber {
	private JFrame frmleshokthe;
	private JTextField idl;
	private JTextField ids;
	private JTextField tit;
	private JTextField data;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeshoKtheLiber window=new LeshoKtheLiber();
					window.frmleshokthe.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LeshoKtheLiber() {
		initialize();
	}
	
	private int kontrollsasi() {
		int i=Integer.parseInt(idl.getText());
		int a=0;
		try{      
			  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
			  Statement stmt = con.createStatement();
			  String query = ("SELECT * FROM regjistroliber WHERE Id = "+"\"" + i + "\""+" AND Sasi > "+"\"" + 0 + "\""+"");
			          ResultSet rs= stmt.executeQuery(query);  
			         if(rs.next())
			         {
			          a=1;  
			         }
			         else
			         {JOptionPane.showMessageDialog(null, "Nuk ka gjendje te librit. ");
			         }
			    }                                        
			catch (SQLException sqlException) {
			                    sqlException.printStackTrace();
			                }  
			     return a;
	}
	
	private int kontroll() {
		int i=Integer.parseInt(idl.getText());
		int b=0;
		try{
			 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
			 Statement stmt = con.createStatement();
			 String query= ("SELECT * FROM regjistroliber WHERE Id= "+"\""+ i +"\""+"");
			           stmt.execute(query);
			           ResultSet rs= stmt.executeQuery(query);
			          if(rs.next()){
			    JOptionPane.showMessageDialog(null, "te dhenat u gjenden. ");
			           tit.setText(rs.getString("Titulli"));
			           b=1;
			          }
			          else
			          {
			            JOptionPane.showMessageDialog(null,"Nuk u gjet libri . "); 
			          }
			     }                                        
			 catch (SQLException sqlException) {
			                     sqlException.printStackTrace();
			                 }
		return b;
		
	}
	
	private void initialize() {
		frmleshokthe=new JFrame();
		frmleshokthe.setTitle("LIBRI");
		frmleshokthe.setBounds(100, 100, 625, 502);
		frmleshokthe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmleshokthe.getContentPane().setLayout(null);
		frmleshokthe.setLocationRelativeTo(null);
		
		JLabel lnl = new JLabel("Lesho/Kthe Liber");
		lnl.setForeground(Color.red);
		lnl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lnl.setHorizontalAlignment(SwingConstants.CENTER);
		lnl.setBounds(211, 10, 200, 28);
		frmleshokthe.getContentPane().add(lnl);
		
		JLabel idlibri=new JLabel("Id e librit: ");
		idlibri.setFont(new Font("Tahoma", Font.BOLD, 12));
		idlibri.setBounds(64, 126, 141, 22);
		frmleshokthe.getContentPane().add(idlibri);
		
		JLabel idstudenti=new JLabel("Id Studenti: ");
		idstudenti.setFont(new Font("Tahoma", Font.BOLD, 12));
		idstudenti.setBounds(64, 183, 141, 22);
		frmleshokthe.getContentPane().add(idstudenti);
		
		JLabel titull=new JLabel("Titull libri: ");
		titull.setFont(new Font("Tahoma", Font.BOLD, 12));
		titull.setBounds(64, 240, 141, 22);
		frmleshokthe.getContentPane().add(titull);
		
		JLabel date=new JLabel("Data:");
		date.setFont(new Font("Times New Roman", Font.BOLD, 14));
		date.setBounds(64, 69, 141, 22);
		frmleshokthe.getContentPane().add(date);
		
		data= new JTextField();
		data.setText("dd/mm/yyyy");
		data.setBounds(265, 67, 189, 28);
		frmleshokthe.getContentPane().add(data);
		data.setColumns(10);
		
		idl=new JTextField();
		idl.setBounds(265, 124, 189, 28);
		frmleshokthe.getContentPane().add(idl);
		
		ids = new JTextField();
		ids.setBounds(265, 181, 189, 28);
		frmleshokthe.getContentPane().add(ids);
		ids.setColumns(10);
		
		tit=new JTextField();
		tit.setBounds(265, 238, 189, 28);
		tit.setEditable(false);
		frmleshokthe.getContentPane().add(tit);
		
		JButton lesho =new JButton("Lesho liber");
		lesho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=Integer.parseInt(idl.getText());
				String status="I pa kthyer";
				String  idst= ids.getText();
				String dt=data.getText();
				// kontroll formatit te dates
				if (!dt.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) { 
			        JOptionPane.showMessageDialog(null, "Kujdes! Data duhet te kete formatin dd/mm/yyyy");
			        return;
				}
				String t =tit.getText(); 
				
				if(kontroll() == 1 && kontrollsasi()== 1) {
					try{
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
			            Statement statement = con.createStatement();
			            statement.executeUpdate("UPDATE regjistroliber SET Sasi=Sasi-"+"\""+ 1+"\""+" WHERE Id= "+"\""+ i +"\""+"");
			            JOptionPane.showMessageDialog(null, "te dhenat e librit u perditesuan.");
			             statement.close();
			            con.close();
	
			        }
			        catch(SQLException | ClassNotFoundException e1){
			            JOptionPane.showMessageDialog(null, e1);
			        }
			         
					try {  
				        Class.forName("com.mysql.jdbc.Driver");   
				        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");  
				        Statement st = con.createStatement();  
				        st.executeUpdate("INSERT INTO leshoktheliber VALUES("+"\""+ dt +"\""+"," +"\"" +i + "\""+"," +"\"" +idst + "\""+"," +"\"" +t + "\""+","+"\""+status+"\""+")");
				       
				        JOptionPane.showMessageDialog(null, "Ju shtuat te dhenat e karteles."); 
				        st.close();  
				        con.close();
				     
				    } catch (SQLException | ClassNotFoundException f) { 
				        JOptionPane.showMessageDialog(null, f);  
				    }
				}	
			}
		});
		lesho.setBounds(10, 372, 136, 34);
		frmleshokthe.getContentPane().add(lesho);
		
		JButton kthe =new JButton("Kthe liber");
		kthe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=Integer.parseInt(idl.getText());
				String  idst= ids.getText();
				String statusiri="Eshte kthyer";
				
				try{
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
		            Statement statement = con.createStatement();
		            statement.executeUpdate("UPDATE regjistroliber SET Sasi=Sasi+"+"\""+ 1+"\""+" WHERE Id= "+"\""+ i +"\""+"");
		            JOptionPane.showMessageDialog(null, "Gjendja e librit u rikthye.");
		             statement.close();
		            con.close();

		        }
		        catch(SQLException | ClassNotFoundException e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
		         
		         try{
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
		            Statement statement = con.createStatement();
		            statement.executeUpdate("UPDATE leshoktheliber SET Statusi= "+"\""+statusiri+"\""+" WHERE Idlibri= "+"\""+ i +"\""+" AND Idstudenti= "+"\""+idst+"\""+"");
		            JOptionPane.showMessageDialog(null, "Statusi u perditesua.");
		             statement.close();
		            con.close();

		        }
		        catch(SQLException | ClassNotFoundException e1){
		            JOptionPane.showMessageDialog(null, e1);
		        }
				
			}
	});
	
		kthe.setBounds(160, 372, 136, 34);
		frmleshokthe.getContentPane().add(kthe);
		
		JButton pastro =new JButton("Pastro");
		pastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idl.setText("");
				ids.setText("");
				tit.setText("");
				data.setText("d/m/v");
				
		}
	});
		pastro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pastro.setBounds(315, 372, 136, 34);
		frmleshokthe.getContentPane().add(pastro);
		
		JButton kthehu =new JButton("Kthehu pas");
		kthehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminKryesore.main(new String[] {});
				frmleshokthe.dispose();
		}
	});
		kthehu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kthehu.setBounds(463, 372, 136, 34);
		frmleshokthe.getContentPane().add(kthehu);
		

  }
}
