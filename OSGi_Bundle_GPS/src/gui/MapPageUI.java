package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	public MapPageUI()
	{
		setTitle("Peta Kota Jakmania");
		setBounds(100, 100, 500, 350);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
		back = new JButton("Kembali");
		back.setBounds(40, 250, 100, 50);
		panelUtama.add(back);
		
		aKota = new JButton("A");
		aKota.setBounds(200, 50, 50, 50);
		panelUtama.add(aKota);
		
		bKota = new JButton("B");
		bKota.setBounds(250, 50, 50, 50);
		panelUtama.add(bKota);
		
		cKota = new JButton("C");
		cKota.setBounds(150, 100, 50, 50);
		panelUtama.add(cKota);
		
		dKota = new JButton("D");
		dKota.setBounds(200, 100, 50, 50);
		panelUtama.add(dKota);
		
		eKota = new JButton("E");
		eKota.setBounds(250, 100, 50, 50);
		panelUtama.add(eKota);
		
		fKota = new JButton("F");
		fKota.setBounds(250, 150, 50, 50);
		panelUtama.add(fKota);
		
		gKota = new JButton("G");
		gKota.setBounds(300, 150, 50, 50);
		panelUtama.add(gKota);
		
		hKota = new JButton("H");
		hKota.setBounds(200, 200, 50, 50);
		panelUtama.add(hKota);
		
		iKota = new JButton("I");
		iKota.setBounds(250, 200, 50, 50);
		panelUtama.add(iKota);
		
	}
}
