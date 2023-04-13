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
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
public class MenaxhoLibrat {
	
	private JFrame frmlibrat;
	private JTextField id;
	private JTextField titull;
	private JTextField autor;
	private JTextField shbotuese;
	private JTextField edicioni;
	private JTextField cmimi;
	private JTable table;
	private JTextField sasi;
	private JComboBox<String> cbox;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenaxhoLibrat window=new MenaxhoLibrat();
					window.frmlibrat.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public MenaxhoLibrat() {
		initialize();
		tableupdate();
		randomnumbers();
	}
	public String randomnumbers() {
		Random ran=new Random();
		int n=ran.nextInt(1000000)+1;
		String vl=String.valueOf(n);
		return vl;
	}
	 Connection Con=null;
	    Statement St=null;
	    ResultSet Rs=null;
	    private void tableupdate()
	    {
	        try{
	            Con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
	            St=Con.createStatement();
	            Rs=St.executeQuery("Select * from projektlibraria.regjistroliber");
	            table.setModel(DbUtils.resultSetToTableModel(Rs));
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	private void initialize() {
		frmlibrat=new JFrame();
		frmlibrat.setTitle("Librat e Bibliotekes");
		frmlibrat.setBackground(Color.cyan);
		frmlibrat.setBounds(100, 100, 625, 502);
		frmlibrat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmlibrat.getContentPane().setLayout(null);
		frmlibrat.setLocationRelativeTo(null);
		
		JLabel lb=new JLabel("Titulli: ");
		lb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lb.setBounds(10, 126, 74, 14);
		frmlibrat.getContentPane().add(lb);
		
		JLabel tit=new JLabel("Autori: ");
		tit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tit.setBounds(10, 171, 74, 14);
		frmlibrat.getContentPane().add(tit);
		
		JLabel aut=new JLabel("Sh.Botuese: ");
		aut.setFont(new Font("Times New Roman", Font.BOLD, 12));
		aut.setBounds(10, 218, 74, 14);
		frmlibrat.getContentPane().add(aut);
		
		JLabel shb=new JLabel("Edicioni: ");
		shb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		shb.setBounds(346, 86, 74, 14);
		frmlibrat.getContentPane().add(shb);
		
		JLabel ed=new JLabel("Cmimi: ");
		ed.setFont(new Font("Times New Roman", Font.BOLD, 12));
		ed.setBounds(346, 126, 68, 14);
		frmlibrat.getContentPane().add(ed);
		
		JLabel cm=new JLabel("Sasia: ");
		cm.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cm.setBounds(346, 171, 74, 14);
		frmlibrat.getContentPane().add(cm);
		
		titull= new JTextField();
		titull.setBounds(90, 121, 130, 27);
		frmlibrat.getContentPane().add(titull);
		titull.setColumns(10);
		
		shbotuese= new JTextField();
		shbotuese.setBounds(90, 213, 130, 27);
		shbotuese.setColumns(10);
		frmlibrat.getContentPane().add(shbotuese);
		
		
		edicioni= new JTextField();
		edicioni.setBounds(426, 78, 130, 27);
		frmlibrat.getContentPane().add(edicioni);
		edicioni.setColumns(10);
		
		cmimi= new JTextField();
		cmimi.setBounds(426, 121, 130, 27);
		cmimi.setColumns(10);
		frmlibrat.getContentPane().add(cmimi);
		
		sasi = new JTextField();
		sasi.setBounds(426, 162, 130, 34);
		sasi.setColumns(10);
		frmlibrat.getContentPane().add(sasi);
		
		autor = new JTextField();
		autor.setBounds(90, 166, 130, 34);
		autor.setColumns(10);
		frmlibrat.getContentPane().add(autor);
		
		JLabel l=new JLabel("Shto-Fshi-Kerko-Ndrysho Libra");
		l.setBounds(30, 33, 333, 34);
		l.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmlibrat.getContentPane().add(l);
		DefaultTableModel dtm=new DefaultTableModel();
		
		id= new JTextField();
		id.setBounds(90, 78, 130, 27);
		frmlibrat.getContentPane().add(id);
		id.setText(randomnumbers());
		id.setColumns(10);
		id.setBackground(Color.white);
		
		JLabel l2=new JLabel("ID");
		l2.setBounds(10, 81, 74, 14);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frmlibrat.getContentPane().add(l2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 256, 568, 151);
		frmlibrat.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(dtm);
		
		JButton buton =new JButton("Shto Liber");
		buton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new String [] {id.getText(),titull.getText(),autor.getText(),shbotuese.getText(),edicioni.getText(),cmimi.getText(),sasi.getText(),(String) cbox.getSelectedItem()});
				int idl=0;
				try {
					idl=Integer.parseInt(id.getText());
					if (idl<0) {
						throw new RuntimeException("Kujdes! ID duhet te jete nje numer pozitiv");
					}
				}catch(NumberFormatException el) {
					JOptionPane.showMessageDialog(null, "Kujdes ID duhet numer.");
					return;
				}catch(RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
				String t=titull.getText();
				String a=autor.getText();
				String sh=shbotuese.getText();
				int ed=0;
				try {
					ed=Integer.parseInt(edicioni.getText());
					if (ed<0) {
						throw new RuntimeException("Kujdes! Edicioni duhet te jete nje numer pozitiv");
					}
				}catch(NumberFormatException el) {
					JOptionPane.showMessageDialog(null, "Kujdes edicioni duhet numer.");
					return;
				}catch(RuntimeException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
				float c= 0;
				try {
					c=Float.parseFloat(cmimi.getText());
					if(c<=0) {
						throw new RuntimeException("Kujdes! Cmimi duhet te jete nje numer pozitiv.");
					}
				}catch(NumberFormatException el) {
					JOptionPane.showMessageDialog(null, "Kujdes cmimi duhet nje numer.");
					return;
				}catch(RuntimeException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
				
				String k=(String) cbox.getSelectedItem();
				int sas = 0;
				
				try{
				  sas=Integer.parseInt(sasi.getText());
				  // is an integer!
				  
				  if (sas <= 0) {
					  throw new RuntimeException("Kujdes! Sasia duhet te jete nje numer pozitiv");
				  }
				} catch (NumberFormatException e1) {
				  // not an integer!
				    JOptionPane.showMessageDialog(null, "Kujdes! Sasia duhet nje numer.");
				    return;
			    } catch (RuntimeException ex) {
				    JOptionPane.showMessageDialog(null, ex.getMessage());
				    return;
			    }
				
				try {  
			        Class.forName("com.mysql.jdbc.Driver");   
			        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");  
			        Statement st = con.createStatement();  
			        st.executeUpdate("INSERT INTO regjistroliber VALUES("+"\""+ idl +"\""+"," +"\"" +t + "\""+"," +"\"" +a + "\""+"," +"\"" +sh + "\""+"," +"\"" +ed + "\""+"," +"\"" +c + "\""+"," +"\"" +sas + "\""+"," +"\"" +k+ "\""+")");
			       
			        JOptionPane.showMessageDialog(null, "Ju shtuat nje liber te ri"); 
			        tableupdate();
			        st.close();  
			        con.close();
			     
			    } catch (SQLException | ClassNotFoundException f) { 
			        JOptionPane.showMessageDialog(null, f);  
			    }
		}
	});
		buton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buton.setBounds(10, 418, 118, 34);
		frmlibrat.getContentPane().add(buton);
	
		JButton fshi=new JButton("Fshi Liber");
		fshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idlb=Integer.parseInt(id.getText());
				try{
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
		            Statement statement = con.createStatement();
		            statement.executeUpdate("DELETE FROM regjistroliber WHERE Id = "+"\""+idlb+"\""+"");
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
		frmlibrat.getContentPane().add(fshi);
		
		JButton pastro =new JButton("Pastro");
		pastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText(randomnumbers());
				titull.setText("");
				autor.setText("");
				shbotuese.setText("");
				edicioni.setText("");
				cmimi.setText("");
				sasi.setText("");
				cbox.setSelectedItem("");
				
		}
	});
		pastro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pastro.setBounds(486, 418, 113, 34);
		frmlibrat.getContentPane().add(pastro);
		
		JButton kerko =new JButton("Kerko Liber");
		kerko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=Integer.parseInt(id.getText());
				 try{
					 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projektlibraria", "root", "");
					 Statement stmt = con.createStatement();
					 String query= ("SELECT * FROM regjistroliber WHERE Id= "+"\""+ i +"\""+"");
					           stmt.execute(query);
					           ResultSet rs= stmt.executeQuery(query);
					          if(rs.next()){
					    JOptionPane.showMessageDialog(null, "te dhenat u gjenden... ");
					           id.setText(rs.getString("Id"));
					           titull.setText(rs.getString("Titulli"));
					           autor.setText(rs.getString("Autori"));
					           shbotuese.setText(rs.getString("ShtepiaBotuese"));
					           cmimi.setText(rs.getString("Cmim"));
					           sasi.setText(rs.getString("Sasi"));
					           edicioni.setText(rs.getString("Edicioni"));
					           cbox.setSelectedItem(rs.getString("Kategori"));
					           
					          }
					          else
					          {
					            JOptionPane.showMessageDialog(null,"Nuk u gjet libri. ");  
					          }
					     }                                        
					 catch (SQLException sqlException) {
					                     sqlException.printStackTrace();
					                 }
			}
		
	});
		kerko.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kerko.setBounds(180, 418, 130, 34);
		frmlibrat.getContentPane().add(kerko);
		
		JLabel k=new JLabel("Kategoria:");
		k.setFont(new Font("Times New Roman", Font.BOLD, 12));
		k.setBounds(346, 219, 46, 14);
		frmlibrat.getContentPane().add(k);
		
		String[] vlerat= {"Finance","Informatike ekonomike","Ekonomiks","Biznes"};
		cbox=new JComboBox<String>(vlerat);
		cbox.setBounds(426, 216, 130, 27);
		frmlibrat.getContentPane().add(cbox);
		
		JButton kthehu =new JButton("Kthehu pas");
		kthehu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminKryesore.main(new String[] {});
				frmlibrat.dispose();
		}
	});
		kthehu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		kthehu.setBounds(480, 10, 110, 34);
		frmlibrat.getContentPane().add(kthehu);
		
		JButton ndrysho =new JButton("Ndrysho sasi");
		ndrysho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idl=Integer.parseInt(id.getText());
				int sas=Integer.parseInt(sasi.getText());
				 try{
			            Class.forName("com.mysql.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projektlibraria", "root", "");
			            Statement statement = con.createStatement();
			            statement.executeUpdate("UPDATE regjistroliber SET Sasi = " +"\""+ sas+"\"" + "WHERE Id = "+"\""+ idl +"\""+"");
			            JOptionPane.showMessageDialog(null, "Te dhenat u perditesuan.");
			            statement.close();
			            con.close();
			            tableupdate();

			        }
			        catch(SQLException | ClassNotFoundException e1){
			            JOptionPane.showMessageDialog(null, e1);
			        }
				
		}
	});
		ndrysho.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ndrysho.setBounds(335, 10, 123, 34);
		frmlibrat.getContentPane().add(ndrysho);
		
		dtm.setColumnIdentifiers(new String[] {"ID","Titulli","Autori","Sh.botuese","Edicioni","Cmimi","Sasia","Kategoria"});
	}
}

