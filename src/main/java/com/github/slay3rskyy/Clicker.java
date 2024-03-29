package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;

public class Clicker extends JButton {


	static Clicker clickerMake(Main main, TrueShop shop, JLabel gold, int x, int y,Dimension size){
		Dimension clickerDim = new Dimension(size.width, size.height);
		Clicker clicker = new Clicker();
		clicker.setBounds(x, y, clickerDim.width, clickerDim.height);
		clicker.setBorderPainted(false);
		clicker.setBorder(null);
		clicker.setFocusPainted(false);
		clicker.setRolloverEnabled(false);
		clicker.setFocusable(false);
		clicker.setIcon(new ImageIcon(Utils.load("FunkyIcon.png")));
		clicker.setModel(new DefaultButtonModel());
		clicker.setPressedIcon(new ImageIcon(Utils.load("FunkyIconPress.png")));
		clicker.clickLogic(main, shop, gold);

//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//
//				main.setPoints((main.getPoints() + (shop.getBoost2()+1)* shop.getBoost1()* shop.getBoost3()));
//				gold.setText(String.format("Gold: %.3E",main.getPoints()));
//				SwingUtilities.updateComponentTreeUI(main.getMainPanel());
//			}
//		}, 1, 1);


		return clicker;
	}

	private void clickLogic(Main main, TrueShop shop, JLabel gold){
		this.addActionListener(Click -> {
			main.setPoints((main.getPoints() + (shop.getBoost2()+1)* shop.getBoost1()* shop.getBoost3()));
			gold.setText(String.format("Gold: %.3E",main.getPoints()));
			SwingUtilities.updateComponentTreeUI(main.getMainPanel());
		});

	}
}
