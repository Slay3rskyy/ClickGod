import java.awt.*;


public class Main {

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
		Main main = new Main();
		Dimension size = new Dimension(200,100);
		Dimension clickerDim = new Dimension(500,500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		MyLabel gold = new MyLabel("Gold: " + main.getPoints());


		MainFrame mainFrame = MainFrame.mainFrameMake();
		TrueShop shop = TrueShop.makeShop(main,main.mainPanel);
		MyButton prestige = MyButton.makeButton(size,screenSize.width/3,screenSize.height/2);
		Clicker clicker = Clicker.clickerMake(main,shop,gold,(screenSize.width-clickerDim.width)/2 , (screenSize.height-clickerDim.height)/2);
		ShopButton shopButton = ShopButton.makeShopButton(main,mainFrame,shop,(screenSize.width-size.width)/2,screenSize.height-size.height, size);

		main.setMainPanel(MainPanel.makeMainPanel(gold,shopButton,new Color(85,85,85), clicker,0,0 , screenSize));
		mainFrame.add(main.mainPanel);
		main.getMainPanel().setVisible(true);
		mainFrame.add(shop);
		shop.setVisible(false);
		gold.setText("Gold: " + Math.floor(main.getPoints()));





	}
}