package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import osgi_bundle_contextmanager.ContextManagerService;
import osgi_bundle_gps.GPS_Service;

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
	private JComboBox<String> saranCB;
	private String[] pilSaran;
	private JButton detil;
	
	public MainPageUI(final String namaU, final ContextManagerService cms)
	{
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
		namaL.setBounds(25, 100, 100, 25);
		panelUtama.add(namaL);
		
		lokasiU = cms.getCurrentLocation();
		
		lokasiL = new JLabel("Anda lagi ada di kota " + lokasiU);
		lokasiL.setBounds(25, 125, 150, 25);
		panelUtama.add(lokasiL);
		
		kondisiL = new JLabel("Kondisi hari ini ");
		kondisiL.setBounds(25, 150, 150, 25);
		panelUtama.add(kondisiL);
		
		suhuL = new JLabel("Suhu");
		suhuL.setBounds(125, 190,50,50);
		panelUtama.add(suhuL);
		
		suhuTF = new JTextField();
		suhuTF.setBounds(100, 240, 75, 75);
		suhuTF.setEditable(false);
		panelUtama.add(suhuTF);
		
		cuacaLL = new JLabel("Cuaca");
		cuacaLL.setBounds(225, 190,50,50);
		panelUtama.add(cuacaLL);
		
		cuacaL = new JLabel();
		cuacaL.setBounds(210, 240, 75, 75);
//		System.out.print(getClass().getResource("/"));
		cuacaL.setIcon(new ImageIcon(getClass().getResource("/image/sunny5.png")));
		panelUtama.add(cuacaL);
		
		
		jamL = new JLabel("Jam");
		jamL.setBounds(340, 190,50,50);
		panelUtama.add(jamL);
		
		jamTF = new JTextField();
		jamTF.setBounds(325, 240, 75, 75);
		jamTF.setEditable(false);
		panelUtama.add(jamTF);
		
		petaB = new JButton("Peta");
		petaB.setBounds(125, 400, 100, 25);
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
		saranL.setBounds(25, 350, 100, 25);
		panelUtama.add(saranL);
		
		pilSaran = new String[]{"Pemadam", "Musholla"};
		saranCB = new JComboBox<String>(pilSaran);
		saranCB.setBounds(125, 350, 200, 25);
		panelUtama.add(saranCB);
		
		detil = new JButton("Lihat");
		detil.setBounds(350, 350, 100, 25);
		panelUtama.add(detil);
	}
}
