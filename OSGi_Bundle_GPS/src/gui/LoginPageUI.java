package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import osgi_bundle_contextmanager.ContextManagerService;
import osgi_bundle_gps.GPS_Service;

public class LoginPageUI extends JFrame{
	private JPanel panelUtama;
	private JLabel judul;
	private JLabel label1;
	private JButton masukTombol;
	private JButton daftarTombol;
	private JComboBox<String> user;
	private ContextManagerService cms;
	
	private MainPageUI mainPUI;
//	public LoginPageUI(ContextManagerService cm_service, GPS_Service gps_service)
	public LoginPageUI(final ContextManagerService cms)
	{
		this.cms = cms;
		setTitle("Halaman Login");
		setBounds(100, 100, 500, 500);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
		judul = new JLabel("Kota JakMania");
		judul.setBounds(200, 5, 150, 75);
		panelUtama.add(judul);
		
		label1 = new JLabel("Anda Bingung, Kami Cari!");
		label1.setBounds(170,25,200,75);
		panelUtama.add(label1);
		
		masukTombol = new JButton("Masuk");
		masukTombol.setBounds(185,185,100,25);
		
		masukTombol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(mainPUI == null)
				{
					
					mainPUI = new MainPageUI(user.getSelectedItem().toString(), cms);
					mainPUI.setVisible(true);
				}
				dispose();
			}
		});
		panelUtama.add(masukTombol);
		
//		daftarTombol = new JButton("Daftar");
//		daftarTombol.setBounds(200,275,100,25);
//		panelUtama.add(daftarTombol);
		
		String[] userB = {"Izza", "Bela","Luqman","Judin"};
		user = new JComboBox<String>(userB);
		user.setBounds(165, 150, 150, 30);
		panelUtama.add(user);
	}
	public ContextManagerService getCms() {
		return cms;
	}
	public void setCms(ContextManagerService cms) {
		this.cms = cms;
	}
	
	
}
