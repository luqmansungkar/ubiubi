package gui;

import java.awt.Button;

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
	
//	public LoginPageUI(ContextManagerService cm_service, GPS_Service gps_service)
	public LoginPageUI()
	{
		setTitle("Halaman Login");
		setBounds(100, 100, 500, 350);
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
		panelUtama.add(masukTombol);
		
//		daftarTombol = new JButton("Daftar");
//		daftarTombol.setBounds(200,275,100,25);
//		panelUtama.add(daftarTombol);
		
		String[] userB = {"Judin Sang Admin", "Luqman Sang User Biasa"};
		user = new JComboBox<String>(userB);
		user.setBounds(165, 150, 150, 30);
		panelUtama.add(user);
	}
}