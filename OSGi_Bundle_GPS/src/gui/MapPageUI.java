package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import osgi_bundle_contextmanager.ContextManagerService;
import osgi_bundle_gps.GPS_Service;

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
//	private String[] pilTempatMenarik;
	private ArrayList<String> pilTempatMenarik;
	private MainPageUI mainPUI;
	private ContextManagerService cms;
	
	public MapPageUI(final ContextManagerService cm_service, final String namaU)
	{
		this.cms = cm_service;
		pilTempatMenarik = cm_service.getAllItemOfInterest();
		String[] pilTempatMenarik2 = new String[pilTempatMenarik.size()];
		pilTempatMenarik2 = pilTempatMenarik.toArray(pilTempatMenarik2);
		tempatMenarikCB = new JComboBox<String>(pilTempatMenarik2);
		
		tempatMenarikCB.setBounds(50,300,300,25);
		panelUtama.add(tempatMenarikCB);
		
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
					mainPUI = new MainPageUI(namaU, cm_service);
					mainPUI.setVisible(true);
				}
				dispose();
			}
		});
		panelUtama.add(back);
		
		aKota = new JButton("A");
		aKota.setBounds(200, 75, 50, 50);
		aKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(aKota.getText());
			}
		});
		panelUtama.add(aKota);
		
		bKota = new JButton("B");
		bKota.setBounds(250, 75, 50, 50);
		bKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(bKota.getText());
			}
		});
		panelUtama.add(bKota);
		
		cKota = new JButton("C");
		cKota.setBounds(150, 125, 50, 50);
		cKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(cKota.getText());
			}
		});
		panelUtama.add(cKota);
		
		dKota = new JButton("D");
		dKota.setBounds(200, 125, 50, 50);
		dKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(dKota.getText());
			}
		});
		panelUtama.add(dKota);
		
		eKota = new JButton("E");
		eKota.setBounds(250, 125, 50, 50);
		eKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(eKota.getText());
			}
		});
		panelUtama.add(eKota);
		
		fKota = new JButton("F");
		fKota.setBounds(250, 175, 50, 50);
		fKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(fKota.getText());
			}
		});
		panelUtama.add(fKota);
		
		gKota = new JButton("G");
		gKota.setBounds(300, 175, 50, 50);
		gKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(gKota.getText());
			}
		});
		panelUtama.add(gKota);
		
		hKota = new JButton("H");
		hKota.setBounds(200, 225, 50, 50);
		hKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(hKota.getText());
			}
		});
		panelUtama.add(hKota);
		
		iKota = new JButton("I");
		iKota.setBounds(250, 225, 50, 50);
		iKota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pilihKota(iKota.getText());
			}
		});
		panelUtama.add(iKota);
		
		cari = new JButton("Lihat");
		cari.setBounds(350, 300, 100, 25);
		panelUtama.add(cari);
		
		
		
		deskripsiTF = new JTextField("");
		deskripsiTF.setBounds(50, 350, 400, 50);
		deskripsiTF.setEditable(false);
		panelUtama.add(deskripsiTF);
	}
	
	public void pilihKota(String kota)
	{
		deskripsiTF.setText(cms.getIoiInformation(kota));
	}
}
