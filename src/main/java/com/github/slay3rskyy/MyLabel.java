package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

	//Constructor accept a text string
	MyLabel(String text) {
		//super();
		int length = text.length() * 100;
		setBounds(1980 / 2 - length / 2, 1, length, 50);
		setText(text);
		setForeground(Color.black);
		setFont(new Font("Arial", Font.PLAIN, 30));
		setHorizontalAlignment(CENTER);
	}

	void setBottomCenter(JComponent container){
		container.add(this);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
}