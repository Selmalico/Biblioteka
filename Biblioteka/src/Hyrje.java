import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Hyrje {
	private JFrame kornizahyrje;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hyrje window=new Hyrje();
					window.kornizahyrje.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Hyrje() {
		initialize();
	}
	private void initialize() {
		kornizahyrje=new JFrame();
		kornizahyrje.setTitle("Biblioteka FE");
		kornizahyrje.setBounds(100, 100, 625, 502);
		kornizahyrje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kornizahyrje.getContentPane().setLayout(null);
		kornizahyrje.setLocationRelativeTo(null);
		
		JLabel titull=new JLabel("SISTEMI I MENAXHIMIT TE LIBRARISE");
		titull.setForeground(Color.red);
		titull.setFont(new Font("Tahoma", Font.BOLD, 18));
		titull.setHorizontalAlignment(SwingConstants.CENTER);
		titull.setBounds(100, 120, 400, 60);
		kornizahyrje.getContentPane().add(titull);
		
		JButton adlog =new JButton("Administrator Log In");
		adlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[] {});
				kornizahyrje.dispose();
		}
	});
		adlog.setFont(new Font("Times New Roman", Font.BOLD, 14));
		adlog.setBounds(183, 262, 276, 66);
		kornizahyrje.getContentPane().add(adlog);
		
		JButton buton =new JButton("Student Log In");
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin.main(new String[] {});
				kornizahyrje.dispose();
		}
	});
		buton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buton.setBounds(183, 367, 276, 66);
		kornizahyrje.getContentPane().add(buton);
		
	}

}
