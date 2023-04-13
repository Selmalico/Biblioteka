import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminKryesore {
	private JFrame kornizamenu;

	public static void main(String[] strings) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminKryesore window=new AdminKryesore();
					window.kornizamenu.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminKryesore() {
		initialize();
	}
	private void initialize() {
		kornizamenu=new JFrame();
		kornizamenu.setTitle("Faqja e Administratorit");
		kornizamenu.setBounds(100, 100, 625, 502);
		kornizamenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kornizamenu.getContentPane().setLayout(null);
		kornizamenu.setLocationRelativeTo(null);
		
		JLabel lnlNewLabel=new JLabel("MENAXHIMI I TE DHENAVE");
		lnlNewLabel.setForeground(Color.BLACK);
		lnlNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lnlNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lnlNewLabel.setBounds(163, 35, 289, 56);
		kornizamenu.getContentPane().add(lnlNewLabel);
		
		JButton btn =new JButton("Menaxho Librat");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenaxhoLibrat.main(new String[] {});
				kornizamenu.dispose();
		}
	});
		btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn.setBounds(173, 102, 281, 56);
		kornizamenu.getContentPane().add(btn);
		
		JButton btn1 =new JButton("Menaxho Studentet");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenaxhoStudentet.main(new String[] {});
				kornizamenu.dispose();
		}
	});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn1.setBounds(173, 199, 281, 56);
		kornizamenu.getContentPane().add(btn1);
		
		JButton btn2 =new JButton("Log out");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hyrje.main(new String[] {});
				kornizamenu.dispose();
		}
	});
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn2.setBounds(171, 365, 281, 56);
		kornizamenu.getContentPane().add(btn2);
		
		JButton btn3 =new JButton("Lesho/Kthe Liber");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeshoKtheLiber.main(new String[] {});
				kornizamenu.dispose();
		}
	});
		btn3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn3.setBounds(173, 286, 281, 56);
		kornizamenu.getContentPane().add(btn3);
}
}
