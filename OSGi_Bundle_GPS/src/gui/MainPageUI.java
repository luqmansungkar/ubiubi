package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPageUI extends JFrame{
	private JPanel panelUtama;
	public MainPageUI()
	{
		setTitle("Tour Guide");
		setBounds(100, 100, 500, 350);
		panelUtama = new JPanel();
		panelUtama.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelUtama);
		panelUtama.setLayout(null);
		
	}
}
