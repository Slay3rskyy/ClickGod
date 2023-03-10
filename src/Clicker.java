import javax.swing.*;
import java.awt.*;

public class Clicker extends JButton {


	static Clicker clickerMake(Main main,TrueShop shop, JLabel gold,int x, int y){
		Dimension clickerDim = new Dimension(500,500);
		Clicker clicker = new Clicker();
		clicker.setBounds(x, y, clickerDim.width, clickerDim.height);
		clicker.setBorderPainted(false);
		clicker.setBorder(null);
		clicker.setFocusPainted(false);
		clicker.setRolloverEnabled(false);
		clicker.setFocusable(false);
		clicker.setIcon(new ImageIcon("FunkyIcon.png"));
		clicker.setModel(new DefaultButtonModel());
		clicker.setPressedIcon(new ImageIcon("FunkyIconPress.png"));
		clicker.clickLogic(main, shop, gold);

		return clicker;
	}

	private void clickLogic(Main main,TrueShop shop, JLabel gold){
		this.addActionListener(Click -> {
			main.setPoints((main.getPoints() + Math.pow((shop.getBoost2() + 1) * shop.getBoost1(), shop.getBoost3())));
			gold.setText("Gold: " + Math.floor(main.getPoints()));
		});
	}
}
