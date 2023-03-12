import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	static MainPanel makeMainPanel(JLabel gold, ShopButton shopButton, Color color1, Clicker clicker, int x, int y, Dimension dim){
		MainPanel main = new MainPanel();

		main.setVisible(false);
		main.setLayout(null);
		main.add(gold);
		main.add(shopButton);
		main.setBounds(x,y, dim.width, dim.height);
		main.setBackground(color1);
		main.add(clicker);
		main.setVisible(true);
		return main;
	}

}
