package gui;

import javax.swing.JFrame;

public class PelihatGUI
{
	public static void main(String[] args)
	{
		JFrame layar = new MainPageUI();
		layar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                layar.setResizable(false);
		layar.setVisible(true);
	}
        
}
