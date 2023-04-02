package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;


public class Main {

	public boolean isInTest() {
		return isInTest;
	}

	public void setInTest(boolean inTest) {
		isInTest = inTest;
	}

	public boolean isInTest;


	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	private MainPanel mainPanel = new MainPanel();
	private double points = 0;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(()-> {


			Main main = new Main();
			Dimension size = new Dimension(200, 100);
			Dimension clickerDim = new Dimension(500, 500);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			MyLabel gold = new MyLabel("Gold: " + main.getPoints());
			MyButton settingButton = MyButton.makeButton(new Dimension(100,100), screenSize.width-100, 0);
			main.setInTest(true);

			MainFrame mainFrame = MainFrame.mainFrameMake();
			TrueShop shop = TrueShop.makeShop(main);
			MyButton prestige = MyButton.makeButton(size, screenSize.width / 3, screenSize.height / 2);
			Clicker clicker = Clicker.clickerMake(main, shop, gold, (screenSize.width - clickerDim.width) / 2, (screenSize.height - clickerDim.height) / 2, clickerDim);
			ShopButton shopButton = ShopButton.makeShopButton(main, mainFrame, shop, (screenSize.width - size.width) / 2, screenSize.height - size.height, size);
			settingButton.setVisible(true);

			JPanel settingPanel = new JPanel();

			settingPanel.setBounds(screenSize.width / 2 - 300, screenSize.height / 2 - 400, 600, 800);
			settingPanel.setBackground(new Color(119, 119, 119));
			settingPanel.setLayout(null);

			MyButton settingTest = MyButton.makeButton(new Dimension(120,100), settingPanel.getWidth()-120,0);
			settingPanel.add(settingTest);
			settingButton.addActionListener(actionEvent->{

				settingPanel.setVisible(true);
				clicker.setVisible(false);
			});
			settingTest.setVisible(true);

			settingTest.addActionListener(actionEvent->{
				settingPanel.setVisible(false);
				clicker.setVisible(true);
			});


			main.setMainPanel(MainPanel.makeMainPanel(gold, shopButton, new Color(85, 85, 85), clicker, 0, 0, screenSize));
			mainFrame.add(main.mainPanel,0);
			main.getMainPanel().setVisible(true);
			mainFrame.add(shop,1);
			shop.setVisible(false);
			settingPanel.setVisible(false);
			gold.setText(String.format("Gold: %4.3E",main.getPoints()));
			main.getMainPanel().add(settingButton);
			mainFrame.add(settingPanel,0);

			main.mainPanel.setComponentZOrder(settingPanel, 0);


		});
	}
}