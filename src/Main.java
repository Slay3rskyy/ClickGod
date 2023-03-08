import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main {

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	private double points = 0;

	public JPanel getMainPanel(){return mainPanel;}

	private JPanel mainPanel = new JPanel();
	public static void main(String[] args) {
		Main main = new Main();
		Dimension size = new Dimension(200,100);
		Dimension clickerDim = new Dimension(500,500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		MyLabel gold = new MyLabel("Gold: " + main.getPoints());


		MainFrame mainFrame = MainFrame.mainFrameMaker();
		TrueShop shop = new TrueShop(main);
		MyButton prestige = MyButton.makeButton(size,screenSize.width/3,screenSize.height/2);
		Clicker clicker = Clicker.clickerMaker(main,shop,gold,(screenSize.width-clickerDim.width)/2 , (screenSize.height-clickerDim.height)/2);

		Color color1 = new Color(85, 85, 85);
		//JPanel mainPanel = new JPanel();
		MyButton shopButton = MyButton.makeButton(size,(screenSize.width-size.width)/2,screenSize.height-size.height);
		System.out.println(screenSize.height);
		
		//MyButton clicker = MyButton.makeButton(clickerDim,(screenSize.width-clickerDim.width)/2, 960/2-clickerDim.height/2);
		shopButton.setIcon(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\Ramka_2.png"));
		shopButton.setContentAreaFilled(false);
		shopButton.setBorder(BorderFactory.createEmptyBorder());


		//shopButton.setBounds(1980 / 2 - size.width / 2, 900, size.width, size.height);
		//shopButton.setHorizontalTextPosition(JButton.CENTER);
		//shopButton.setVerticalTextPosition(JButton.CENTER);
		mainFrame.add(shop);
		shop.setVisible(false);
		main.getMainPanel().setLayout(null);
		main.getMainPanel().add(gold);
		main.getMainPanel().setVisible(true);
		main.getMainPanel().add(shopButton);
		main.getMainPanel().setBounds(0, 0, 1950, 1080);
		main.getMainPanel().setBackground(color1);
		main.getMainPanel().add(clicker);
		mainFrame.add(main.getMainPanel());

		gold.setText("Gold: " + Math.floor(main.getPoints()));


		shopButton.addActionListener(actionEvent -> {
			Color shopColor = new Color(45, 45, 45);
			main.getMainPanel().setVisible(false);
			shop.setBackground(shopColor);
			shop.setVisible(true);
			SwingUtilities.updateComponentTreeUI(mainFrame);
		});

	}
}