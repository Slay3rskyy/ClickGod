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

	public double getClickPower() {
		return clickPower;
	}

	public void setClickPower(double clickPower) {
		this.clickPower = clickPower;
	}

	private double points = 0;
	static JPanel mainPanel = new JPanel();
	private double clickPower = 1;
	public static void main(String[] args) {
		Main main = new Main();
		Dimension size = new Dimension(200,100);
		Dimension clickerDim = new Dimension(500,500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		MyLabel gold = new MyLabel("Gold: " + main.getPoints());
		MyButton prestige = MyButton.makeButton(size,screenSize.width/3,screenSize.height/2);
		Color color1 = new Color(85, 85, 85);
		//JPanel mainPanel = new JPanel();
		JFrame mainFrame = new JFrame("Let it run");
		mainFrame.setUndecorated(true);
		MyButton shopButton = MyButton.makeButton(size,(screenSize.width-size.width)/2,screenSize.height-size.height);
		System.out.println(screenSize.height);
		
		MyButton clicker = MyButton.makeButton(clickerDim,(screenSize.width-clickerDim.width)/2, 960/2-clickerDim.height/2);
		shopButton.setIcon(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\Ramka_2.png"));
		shopButton.setContentAreaFilled(false);
		shopButton.setBorder(BorderFactory.createEmptyBorder());
		clicker.setIcon(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\FunkyIcon.png"));
		clicker.setModel(new DefaultButtonModel());
		mainPanel.setLayout(null);
		mainPanel.add(gold);
		//shopButton.setBounds(1980 / 2 - size.width / 2, 900, size.width, size.height);
		//shopButton.setHorizontalTextPosition(JButton.CENTER);
		//shopButton.setVerticalTextPosition(JButton.CENTER);
		TrueShop shop = new TrueShop(main);
		mainFrame.add(shop);
		shop.setVisible(false);
		mainPanel.add(shopButton);
		mainPanel.setBounds(0, 0, 1950, 1080);
		mainPanel.setBackground(color1);
		mainFrame.add(mainPanel);
		mainFrame.setIconImage(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\UmmIconIGuess.png").getImage());
		mainFrame.setSize(1960, 1080);
		//mainFrame.setBackground(color1);

		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.addKeyListener(new KeyAdapter() {
									 @Override
									 public void keyTyped(KeyEvent e) {

									 }

									 @Override
									 public void keyPressed(KeyEvent e) {

									 }

									 @Override
									 public void keyReleased(KeyEvent e) {
										 if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
										 {
											 System.exit(0);
										 }
									 }
		});
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainPanel.add(clicker);

		gold.setText("Gold: " + Math.floor(main.getPoints()));
		clicker.setPressedIcon(new ImageIcon("C:\\Users\\Mateusz\\Documents\\graphics for projects\\FunkyIconPress.png"));
		clicker.addActionListener(Click -> {
			main.setPoints((main.getPoints() + Math.pow((shop.getBoost2() + main.getClickPower()) * shop.getBoost1(), shop.getBoost3())));
			gold.setText("Gold: " + Math.floor(main.getPoints()));
		});


		shopButton.addActionListener(actionEvent -> {
			Color shopColor = new Color(45, 45, 45);
			JPanel testPanel = new JPanel();
			testPanel.setBackground(shopColor);
			testPanel.setBounds(0, 0, 1960, 1080);
			/*JLayeredPane pane1 = new JLayeredPane();
			pane1.setBackground(color1);
			pane1.setBounds(0,0,1960,1080);
			pane1.add(mainPanel,1);
			pane1.add(testPanel,2);*/
			//newShop.ShopPanel().setVisible(true);
			mainPanel.setVisible(false);
			shop.setVisible(true);
			SwingUtilities.updateComponentTreeUI(mainFrame);
		});

	}
}