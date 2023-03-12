import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

	MainPanel(){super();}


	static MainPanel makeMainPanel(JLabel gold, ShopButton shopButton, Color color1, Clicker clicker, int x, int y, Dimension dim){
		MainPanel main = new MainPanel();

		main.setVisible(false);
		main.setLayout(null);
		main.add(gold);
		main.add(shopButton);
		main.setBackground(color1);
		main.setBounds(x,y, dim.width, dim.height);
		main.add(clicker);
		main.setVisible(true);
		return main;
	}

}
