package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrueShop extends JPanel {
	public double getBoost1() {
		return boost1;
	}

	public void setBoost1(double boost1) {this.boost1 = boost1;}

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

	public double getCostArray(int index) {return costArray[index];}

	public void setCostArray(double newCost,int index) {costArray[index] = newCost;}

	public MyLabel getLabelList(int index){return labelList[index];}

	public void setLabelList(MyLabel label,int index){labelList[index] = label;}

	public int getAutoClickAmmount() {return autoClickAmmount;}

	public void setAutoClickAmmount(int autoClickAmmount) {this.autoClickAmmount = autoClickAmmount;}

	private final MyLabel[] labelList = new MyLabel[16];
	private final double[] costArray = {100, 10, 2500, 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private double boost1 = 1;
	private double boost2 = 0;
	private double boost3 = 1;
	private int autoClickAmmount = 0;

	TrueShop() {
		super();
	}

	static TrueShop makeShop(Main mainRef, MyLabel gold){
		TrueShop shop = new TrueShop();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//MyLabel[] labelList = new MyLabel[16];
		MyButton[] Burray = new MyButton[16];
		String[] nameArray = {"Click multiplier", "Click adder", "Click power", "AutoClicker", "First Booster", "Second Booster", "", "", "", "", "", "", "", "", ""};
		shop.setBackground(new Color(45, 45, 45));
		shop.setBounds(0, 0, screenSize.width, screenSize.height);
		shop.setLayout(null);

		Dimension buttonDim = new Dimension();
		buttonDim.setSize(screenSize.width / 4 - 50, screenSize.height / 4 - 50);
		int y = screenSize.height / 4;
		int x = screenSize.width / 4;
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
				Burray[buttonIndex].setLayout(null);
				//Burray[buttonIndex].setBackground(new Color(100,100,100));
				shop.add(Burray[buttonIndex]);
				Burray[buttonIndex].setFocusable(false);
				shop.setLabelList( new MyLabel(String.format("cost \n %.0f",shop.getCostArray(buttonIndex))),buttonIndex);
				shop.getLabelList(buttonIndex).setBounds(buttonDim.width/2 - shop.getLabelList(buttonIndex).getLength()/2,buttonDim.height - 100, shop.getLabelList(buttonIndex).getLength(),100);
				Burray[buttonIndex].add(shop.getLabelList(buttonIndex));
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

		Burray[0].shopButtonLogic(shop,mainRef,0,4, gold);
		Burray[0].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= shop.getCostArray(0)) {
				shop.setBoost1(shop.getBoost1()*1.5);

			}
		});

		Burray[1].shopButtonLogic(shop,mainRef,1, 2.5, gold);
		Burray[1].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= shop.getCostArray(1)) {
				shop.setBoost2(shop.getBoost2()+1);
			}
		});

		Burray[2].shopButtonLogic(shop, mainRef, 2,100, gold);
		Burray[2].addActionListener(actionEvent -> {
			if (mainRef.getPoints() >= shop.getCostArray(2)) {
				shop.setBoost3(shop.getBoost3()*10);
			}
		});

		Burray[3].shopButtonLogic(shop,mainRef, 3,7,gold);
		Timer timer = new Timer();
		Burray[3].addActionListener(e -> {

			if (mainRef.getPoints() >= shop.getCostArray(3)) {
				shop.setAutoClickAmmount(shop.getAutoClickAmmount()+1);
			}
			if(shop.getAutoClickAmmount() == 1){
				timer.schedule(new TimerTask() {
					@Override
					public void run() {

						mainRef.setPoints((mainRef.getPoints() + (shop.getBoost2() + 1) * shop.getBoost1() * shop.getBoost3()));
						gold.setText(String.format("Gold: %.3E",mainRef.getPoints()));
						SwingUtilities.updateComponentTreeUI(mainRef.getMainPanel());
					}

				},1,shop.getAutoClickAmmount());

			}

		});

		return shop;
	}
}
