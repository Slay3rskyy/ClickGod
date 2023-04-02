package com.github.slay3rskyy;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

	private int length;
	public void setLength(int length) {
		this.length = length;
	}

	//Constructor accept a text strin

	public int getLength() {
		return length;
	}

	MyLabel(String text) {
		//super();
		setLength( text.length() * 100);
		setBounds(1980 / 2 - length / 2, 1, length, 50);
		setText(text);
		setForeground(Color.black);
		setFont(new Font("Arial", Font.PLAIN, 30));
		setHorizontalAlignment(CENTER);
	}

}