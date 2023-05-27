package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {

	public static Settings makeSettings(Clicker clicker, MyButton settingButton){
		Settings mySetting = new Settings();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		mySetting.setBounds(screenSize.width / 2 - 300, screenSize.height / 2 - 400, 600, 800);
		mySetting.setBackground(new Color(119, 119, 119));
		mySetting.setLayout(null);

		MyButton settingTest = MyButton.makeButton(new Dimension(100,100), mySetting.getWidth()-100,0);
		mySetting.add(settingTest);

		MyButton topLabel = MyButton.makeButton(new Dimension(mySetting.getWidth()-100, 100),0,0);
		mySetting.add(topLabel);
		topLabel.ChangeColor(new Color(98, 98, 98),new Color(98, 98, 98));
		topLabel.setVisible(true);
		MyLabel panelLabel = new MyLabel("SETTINGS");
		panelLabel.setBounds(mySetting.getWidth()/2-250,25 , 400, 50);
		topLabel.add(panelLabel);
		topLabel.setLayout(null);

		MyButton button_1 = MyButton.makeButton(new Dimension(mySetting.getWidth()-50,70),50/2,mySetting.getHeight()*2/10);
		mySetting.add(button_1);

		MyButton button_2 = MyButton.makeButton(new Dimension(mySetting.getWidth()-50,70),50/2,mySetting.getHeight()*3/10);
		mySetting.add(button_2);



		settingButton.addActionListener(actionEvent->{

			mySetting.setVisible(true);
			clicker.setVisible(false);
		});
		settingTest.setVisible(true);

		settingTest.addActionListener(actionEvent->{
			mySetting.setVisible(false);
			clicker.setVisible(true);
		});


		return mySetting;
	}

}
