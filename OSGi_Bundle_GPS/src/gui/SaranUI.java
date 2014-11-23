package gui;

import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import osgi_bundle_gps.GPS_Activator;

public class SaranUI extends JFrame {
	private JPanel PanelUtama;
	private TextArea TAUtama;
	
	public SaranUI (final GPS_Activator GPS)
	{
		setBackground(Color.WHITE);
		setTitle("Saran Tempat");
		setBounds(100, 100, 500, 300);
		
		PanelUtama = new JPanel();
		PanelUtama.setBackground(Color.WHITE);
		PanelUtama.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelUtama);
		PanelUtama.setLayout(null);
		
	}
}
