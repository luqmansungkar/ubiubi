package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import osgi_bundle_contextmanager.ContextManagerService;

public class MainPageUI extends JFrame{
	private MapPageUI mpUI;
	private JPanel panelUtama;
	private JLabel judulL;
	private JButton petaB;
	
	private JLabel namaL;
	private String namaU;
	
	private JLabel lokasiL;
	private String lokasiU;
	
	private JLabel kondisiL;

	private JLabel suhuL;
	private JLabel cuacaLL;
	private JLabel jamL;
	
	private JTextField suhuTF;
	private JLabel cuacaL;
	private JTextField jamTF;
	
	private JLabel saranL;
	private JTextArea infoSaran;
	private JTextArea deskripsiTF;
	private JComboBox<String> saranCB;
	private String[] pilSaran;
	private JButton detil;
	private ContextManagerService cms;
	
	private Timer timer;
	
	public MainPageUI(final String namaU, final ContextManagerService cms)
	{
		this.cms = cms;
		timer = new Timer();
		this.namaU = namaU;
		setTitle("Tour Guide");
		setBounds(100, 100, 500, 500);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
		judulL = new JLabel("Tour Guide");
		judulL.setBounds(200,10,100,50);
		panelUtama.add(judulL);
		
		namaL = new JLabel("Hai, "+namaU);
		namaL.setBounds(25, 50, 100, 25);
		panelUtama.add(namaL);
		
		lokasiU = cms.getCurrentLocation();
		
		lokasiL = new JLabel("Anda sedang berada di kota " + lokasiU);
		lokasiL.setBounds(25, 75, 200, 25);
		panelUtama.add(lokasiL);
		
		kondisiL = new JLabel("Kondisi hari ini ");
		kondisiL.setBounds(25, 100, 150, 25);
		panelUtama.add(kondisiL);
		
		suhuL = new JLabel("Suhu");
		suhuL.setBounds(125, 140,50,50);
		panelUtama.add(suhuL);
		
		suhuTF = new JTextField();
		suhuTF.setBounds(100, 190, 75, 75);
		suhuTF.setEditable(false);
		suhuTF.setText(cms.getTemperatur());
		suhuTF.setHorizontalAlignment(SwingConstants.RIGHT);
		panelUtama.add(suhuTF);

		Font font = new Font("Arial", Font.BOLD, 60);
        suhuTF.setFont(font);
		
		cuacaLL = new JLabel("Cuaca");
		cuacaLL.setBounds(225, 140,50,50);
		panelUtama.add(cuacaLL);
		
		cuacaL = new JLabel();
		cuacaL.setBounds(210, 190, 75, 75);
//		System.out.print(getClass().getResource("/"));
		switch (cms.getCuaca()) {
		case "berawan":
			cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/sunny5.png")));
			break;
		case "hujan":
			cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/rainy12.png")));
			break;
		case "cerah":
			cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/sun79.png")));
			break;

		default:
			break;
		}
		
		panelUtama.add(cuacaL);
		
		
		jamL = new JLabel("Jam");
		jamL.setBounds(340, 140,50,50);
		panelUtama.add(jamL);
		
		jamTF = new JTextField();
		jamTF.setBounds(325, 190, 75, 75);
		jamTF.setEditable(false);
		jamTF.setText(cms.getWaktu());
		panelUtama.add(jamTF);
		
		Font font2 = new Font("Arial", Font.BOLD, 27);
		jamTF.setFont(font2);
		
		petaB = new JButton("Peta");
		petaB.setBounds(350, 75, 100, 25);
		petaB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(mpUI == null)
				{
					mpUI = new MapPageUI(cms, namaU);
					mpUI.setVisible(true);
				}
				dispose();
			}
		});
		panelUtama.add(petaB);
		
		saranL = new JLabel("Saran Tempat");
		saranL.setBounds(25, 275, 100, 25);
		panelUtama.add(saranL);
		
		infoSaran = new JTextArea("Berikut tempat menarik sesuai preferensi anda");
		infoSaran.setBounds(25, 300, 400, 50);
		infoSaran.setEditable(false);
		infoSaran.setLineWrap(true);
		infoSaran.setWrapStyleWord(true);
		panelUtama.add(infoSaran);
		
		ArrayList<String> tempat = cms.getLokasiBySaran(cms.getSaran(), cms.getCurrentLocation());
		
		if (tempat.size() == 0) {
			tempat = cms.getItemOfInterest(cms.getCurrentLocation());
			infoSaran.setText("Tidak ada saran berdasarkan preferensi anda.\nBerikut"
					+ " adalah tempat menarik di kota ini");
		}
		String[] pilTempatMenarik2 = new String[tempat.size()];
		pilTempatMenarik2 = tempat.toArray(pilTempatMenarik2);
		
		
		//pilSaran = new String[]{"Pemadam", "Musholla"};
		saranCB = new JComboBox<String>(pilTempatMenarik2);
		saranCB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deskripsiTF.setText(cms.getIoiInformation(saranCB.getSelectedItem().toString()));
			}
		});
		saranCB.setBounds(25, 360, 420, 25);
		panelUtama.add(saranCB);
		
		deskripsiTF = new JTextArea("detail");
		deskripsiTF.setBounds(25, 390, 400, 40);
		deskripsiTF.setEditable(false);
		deskripsiTF.setLineWrap(true);
		deskripsiTF.setWrapStyleWord(true);
		panelUtama.add(deskripsiTF);
		deskripsiTF.setText(cms.getIoiInformation(saranCB.getSelectedItem().toString()));
		
		/*
		detil = new JButton("Lihat");
		detil.setBounds(350, 330, 100, 25);
		panelUtama.add(detil);*/
		run();
	}
	
	public void run(){
		timer.schedule(new TimerTask(){
			public void run() {
				lokasiU = cms.getCurrentLocation();
				lokasiL.setText("Anda sedang berada di kota " + lokasiU);
				suhuTF.setText(cms.getTemperatur());
				jamTF.setText(cms.getWaktu());
				
				ArrayList<String> tempat = cms.getLokasiBySaran(cms.getSaran(), cms.getCurrentLocation());
				System.out.println(tempat.size()+","+tempat.toString());
				infoSaran.setText("Berikut tempat menarik sesuai preferensi anda");
				if (tempat.size() == 0) {
					tempat = cms.getItemOfInterest(cms.getCurrentLocation());
					infoSaran.setText("Tidak ada saran berdasarkan preferensi anda.\nBerikut"
							+ " adalah tempat menarik di kota ini");
				}
				
				String[] pilTempatMenarik2 = new String[tempat.size()];
				pilTempatMenarik2 = tempat.toArray(pilTempatMenarik2);
				saranCB.setModel(new DefaultComboBoxModel<String>(pilTempatMenarik2));
				
				deskripsiTF.setText(cms.getIoiInformation(saranCB.getSelectedItem().toString()));
				
				switch (cms.getCuaca()) {
				case "berawan":
					cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/sunny5.png")));
					break;
				case "hujan":
					cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/rainy12.png")));
					break;
				case "cerah":
					cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/sun79.png")));
					break;

				default:
					break;
				}
				
			}
		},0,5000);
	}

}
