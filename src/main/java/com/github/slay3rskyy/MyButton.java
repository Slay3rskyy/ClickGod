package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JButton {

	public static MyButton makeButton(Dimension size, int x, int y) {
		MyButton button = new MyButton();
		button.setBounds(x, y, size.width, size.height);
		button.setForeground(new Color(200, 200, 200));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setRolloverEnabled(false);
		button.setFocusable(false);
		button.setModel(new FixedStateButtonModel());
		button.setBorder(BorderFactory.createEmptyBorder());
		button.ChangeColor(new Color(75,75,75),new Color(30,30,30));
		return button;
	}
//	public static MyButton makeButton(int x, int y, int width, int height){
//		Dimension size = new Dimension(width, height);
//		return makeButton(size,x,y);
//
//	}

	public void shopButtonLogic (TrueShop shop, Main mainRef, int index, double costMultiplier, MyLabel gold){

		this.addActionListener(e -> {

			if(mainRef.getPoints() >= shop.getCostArray(index)){
				mainRef.setPoints(mainRef.getPoints() - shop.getCostArray(index));
				shop.setCostArray(shop.getCostArray(index)*costMultiplier,index);
				shop.getLabelList(index).setText(Utils.formatGold(shop.getCostArray(index)));
				gold.setText(String.format("Gold: %.3E",mainRef.getPoints()));
			}

		});
	}
	public void ChangeColor(Color baseColor, Color colorChangeOnClick){
		this.setBackground(baseColor);

		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorChangeOnClick);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setBackground(baseColor);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

	}
}
