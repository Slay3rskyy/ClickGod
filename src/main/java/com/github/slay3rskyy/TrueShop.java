package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;

public class TrueShop extends JPanel {
	public double getBoost1() {
		return boost1;
	}

	public void setBoost1(double boost1) {
		this.boost1 = boost1;
	}

	public double getBoost2() {
		return boost2;
	}

	public void setBoost2(double boost2) {
		this.boost2 = boost2;
	}

	public double getBoost3() {
		return boost3;
	}

	public void setBoost3(double boost3) {
		this.boost3 = boost3;
	}

	private double boost1 = 1;
	private double boost2 = 0;
	private double boost3 = 1;
	TrueShop() {
		super();
	}

	static TrueShop makeShop(Main mainRef, MainPanel mainPanel){
		TrueShop shop = new TrueShop();
		MyLabel[] labelList = new MyLabel[16];
		MyButton[] Burray = new MyButton[16];
		String[] nameArray = {"Click multiplier", "Click adder", "Click power", "AutoClicker", "First Booster", "Second Booster", "", "", "", "", "", "", "", "", ""};
		shop.setBackground(new Color(45, 45, 45));
		shop.setBounds(0, 0, 1960, 1080);
		shop.setLayout(null);
		double[] costArray = {100, 10, 2500, 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		Dimension buttonDim = new Dimension();
		buttonDim.setSize(400, 200);
		int y = 980 / 4;
		int x = 1960 / 4;
		int buttonIndex = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j < 3; j++) {
				Burray[buttonIndex] = MyButton.makeButton(buttonDim, x * j + 25, y * i + 25);
				if (nameArray[buttonIndex].length() != 0) {
					Burray[buttonIndex].setText(nameArray[buttonIndex]);
				} else {
					Burray[buttonIndex].setText("Button " + (buttonIndex + 1));
				}

				Burray[buttonIndex].setFont(new Font("Monospace", Font.PLAIN, 30));
				//Burray[buttonIndex].setBackground(new Color(100,100,100));
				shop.add(Burray[buttonIndex]);
				Burray[buttonIndex].setFocusable(false);
				labelList[buttonIndex] = new MyLabel(Double.toString(costArray[buttonIndex]));
				Burray[buttonIndex].add(labelList[buttonIndex]);
				labelList[buttonIndex].setBottomCenter(Burray[buttonIndex]);
				buttonIndex++;
			}
		}
		Burray[buttonIndex] = MyButton.makeButton(buttonDim, x * 3 + 25, 25);
		Burray[buttonIndex].setText("Main Menu");
		Burray[buttonIndex].setFont(new Font("Monospace", Font.PLAIN, 30));
		//Burray[buttonIndex].setBackground(new Color(100,100,100));
		shop.add(Burray[buttonIndex]);
		Burray[12].addActionListener(actionEvent -> {
			mainRef.getMainPanel().setVisible(true);
			shop.setVisible(false);
		});

		Burray[0].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= costArray[0]) {

				shop.boost1 = shop.boost1 * 1.58;
				mainRef.setPoints(mainRef.getPoints()-costArray[0]);
				costArray[0] = costArray[0] * 4;
				labelList[0].setText(Double.toString(costArray[0]));
				//System.out.println(Math.pow((Main.clickPower + boost2) * boost1, boost3));
			} else {
				//System.out.println(Math.pow((boost2 + Main.clickPower) * boost1, boost3));
				System.out.println(costArray[0]);
			}
		});

		Burray[1].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= costArray[1]) {
				shop.boost2 = shop.boost2 + 1;
				mainRef.setPoints(mainRef.getPoints() - costArray[1]);
				costArray[1] *= 2.5;
				labelList[1].setText(String.format("cost %.2f",costArray[1]));

			} else {
				System.out.println(costArray[1]);
			}

		});

		Burray[2].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= costArray[2]) {
				shop.boost3 = shop.boost3 + 0.01;
				mainRef.setPoints(mainRef.getPoints()-costArray[2]);
				costArray[2] *= 25;
				labelList[2].setText(Double.toString(costArray[2]));
			} else {
				System.out.println(costArray[3]);
			}
		});
		return shop;
	}
}
