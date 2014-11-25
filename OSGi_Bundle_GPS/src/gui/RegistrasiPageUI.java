package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistrasiPageUI extends JFrame{
	private JPanel panelUtama;
	private JLabel judul;
	private JButton daftarTombol;
	private JLabel namaL;
	private JLabel suhuL;
	private JLabel cuacaL;
	private JLabel jamL;
	private JLabel keinginanL;
	private JTextField namaTF;
	private JComboBox<String> keinginanCBC;
	private JComboBox<String> keinginanCBJ;
	private JComboBox<String> keinginanCBS;
	private JComboBox<String> cuacaCB;
	
	
	
	
	public RegistrasiPageUI()
	{
		String[] pilCuacaCB = {"Cerah", "Berawan","Hujan","Badai"};
		String[] pilKeinginanCB = {"Hiburan","Olahraga", "Wisata Pemerintah"};
		setTitle("Halaman Pendaftaran");
		setBounds(100, 100, 500, 350);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
		daftarTombol = new JButton("Daftar");
		daftarTombol.setBounds(200, 275, 100, 25);
		panelUtama.add(daftarTombol);
		
		namaL = new JLabel("Nama ");
		namaL.setBounds(25, 80, 100, 25);
		panelUtama.add(namaL);
		
		namaTF = new JTextField();
		namaTF.setBounds(90, 80, 100, 25);
		panelUtama.add(namaTF);
		
		suhuL = new JLabel("Suhu ");
		suhuL.setBounds(23, 120, 100, 25);
		panelUtama.add(suhuL);
		
		cuacaL = new JLabel("Cuaca ");
		cuacaL.setBounds(25, 160, 100, 25);
		panelUtama.add(cuacaL);
		
		jamL = new JLabel("Jam ");
		jamL.setBounds(25, 200, 100, 25);
		panelUtama.add(jamL);
		
		keinginanL = new JLabel("Ingin");
		keinginanL.setBounds(220,120,100,25);
		panelUtama.add(keinginanL);
		
		keinginanL = new JLabel("Ingin");
		keinginanL.setBounds(220,160,100,25);
		panelUtama.add(keinginanL);
		
		keinginanL = new JLabel("Ingin");
		keinginanL.setBounds(220,200,100,25);
		panelUtama.add(keinginanL);
		
		keinginanCBS = new JComboBox<String>(pilKeinginanCB);
		keinginanCBS.setBounds(280, 120, 150, 25);
		panelUtama.add(keinginanCBS);
		
		keinginanCBC = new JComboBox<String>(pilKeinginanCB);
		keinginanCBC.setBounds(280, 160, 150, 25);
		panelUtama.add(keinginanCBC);
		
		keinginanCBJ = new JComboBox<String>(pilKeinginanCB);
		keinginanCBJ.setBounds(280, 200, 150, 25);
		panelUtama.add(keinginanCBJ);
	}

}
