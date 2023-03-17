package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame{
	static MainFrame mainFrameMake(){
		MainFrame mainFrame = new MainFrame();

		//settings from Jframe set to MainFrame
		mainFrame.setIconImage(new ImageIcon(Utils.load("UmmIconIGuess.png")).getImage());
		mainFrame.setBackground(new Color(85,85,85));
		mainFrame.setSize(1960, 1080);
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		mainFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return mainFrame;
	}
}
