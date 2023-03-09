import javax.swing.*;
import java.awt.*;

public class ShopButton extends JButton{
	static ShopButton makeShopButton(Main main,MainFrame mainFrame, TrueShop shop, int x, int y, Dimension size){
		ShopButton shopButton = new ShopButton();

		shopButton.setBounds(x, y, size.width, size.height);
		shopButton.setForeground(new Color(200, 200, 200));
		shopButton.setBorderPainted(false);
		shopButton.setFocusPainted(false);
		shopButton.setFocusable(false);
		shopButton.setBorder(null);
		shopButton.setIcon(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\Ramka_2.png"));
		shopButton.setContentAreaFilled(false);
		shopButton.setBorder(BorderFactory.createEmptyBorder());


		shopButton.addActionListener(actionEvent -> {
			Color shopColor = new Color(45, 45, 45);
			main.getMainPanel().setVisible(false);
			shop.setBackground(shopColor);
			shop.setVisible(true);
			SwingUtilities.updateComponentTreeUI(mainFrame);
		});


		return shopButton;
	}
}
