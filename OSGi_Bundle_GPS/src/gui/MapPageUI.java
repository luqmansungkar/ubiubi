package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StreamCorruptedException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import osgi_bundle_contextmanager.ContextManagerService;

public class MapPageUI extends JFrame{
	private JPanel panelUtama;
	private JButton aKota;
	private JButton bKota;
	private JButton cKota;
	private JButton dKota;
	private JButton eKota;
	private JButton fKota;
	private JButton gKota;
	private JButton hKota;
	private JButton iKota;
	
	private JButton back;
	private JButton cari;
	private JButton semua;
	
	private JTextField deskripsiTF;
	private JComboBox<String> tempatMenarikCB;
	private String[] pilTempatMenarik;
	private MainPageUI mainPUI;
	
	ContextManagerService cm_service;
	public MapPageUI()
	{
		pilTempatMenarik = new String[]{"Toko Kelontong", "Toko Lontong Sayur", "Menoy Berisik"};
		
		setTitle("Peta Kota Jakmania");
		setBounds(100, 100, 500, 500);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
		semua = new JButton("<html>Semua </br> Kota</html>");
		semua.setBounds(375,75,75,50);
		panelUtama.add(semua);
		
		back = new JButton("Kembali");
		back.setBounds(30, 75, 100, 25);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainPUI == null)
				{
					mainPUI = new MainPageUI("");
					mainPUI.setVisible(true);
				}
				dispose();
			}
		});
		panelUtama.add(back);
		
		aKota = new JButton("A");
		aKota.setBounds(200, 75, 50, 50);
		panelUtama.add(aKota);
		
		bKota = new JButton("B");
		bKota.setBounds(250, 75, 50, 50);
		panelUtama.add(bKota);
		
		cKota = new JButton("C");
		cKota.setBounds(150, 125, 50, 50);
		panelUtama.add(cKota);
		
		dKota = new JButton("D");
		dKota.setBounds(200, 125, 50, 50);
		panelUtama.add(dKota);
		
		eKota = new JButton("E");
		eKota.setBounds(250, 125, 50, 50);
		panelUtama.add(eKota);
		
		fKota = new JButton("F");
		fKota.setBounds(250, 175, 50, 50);
		panelUtama.add(fKota);
		
		gKota = new JButton("G");
		gKota.setBounds(300, 175, 50, 50);
		panelUtama.add(gKota);
		
		hKota = new JButton("H");
		hKota.setBounds(200, 225, 50, 50);
		panelUtama.add(hKota);
		
		iKota = new JButton("I");
		iKota.setBounds(250, 225, 50, 50);
		panelUtama.add(iKota);
		
		cari = new JButton("Lihat");
		cari.setBounds(325, 300, 100, 25);
		panelUtama.add(cari);
		
		tempatMenarikCB = new JComboBox<String>(pilTempatMenarik);
		tempatMenarikCB.setBounds(50,300,300,25);
		panelUtama.add(tempatMenarikCB);
		
		deskripsiTF = new JTextField("haha");
		deskripsiTF.setBounds(50, 350, 375, 50);
		deskripsiTF.setEditable(false);
		panelUtama.add(deskripsiTF);
	}
}
