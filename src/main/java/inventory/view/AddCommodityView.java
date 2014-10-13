package inventory.view;

import inventory.dao.ProductDao;
import inventory.dao.impl.ProductDaoImpl;
import inventory.service.ProductService;
import inventory.service.impl.ProductServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import inventory.config.DBManage;


public class AddCommodityView extends JFrame{
	private JTextField commodityIndexInput;
	private JTextField commodityNameInput;
	private JTextField commodityTypeInput;
	private JTextField commodityPriceInput;
	private ProductService productService;
	
	private ProductServiceView mainView; //主窗口的引用
	
	AddListener addListener = new AddListener();
	
	//接收到主窗口的引用，就可以直接操作主窗口的控件或变量了
	public AddCommodityView(final ProductServiceView mainView){
		JFrame mFrame;
		mFrame = new JFrame();
		mFrame.getContentPane().setLayout(null);
		mFrame.setVisible(true);
		mFrame.setSize(280, 260);
		mFrame.setLocation(450, 460);
		
		JLabel commodityIndexLabel = new JLabel("商品编号");
		commodityIndexLabel.setBounds(45, 30, 54, 15);
		mFrame.getContentPane().add(commodityIndexLabel);
		
		JLabel commodityNameLabel = new JLabel("商品名称");
		commodityNameLabel.setBounds(45, 65, 54, 15);
		mFrame.getContentPane().add(commodityNameLabel);
		
		JLabel commodityTypeLabel = new JLabel("商品型号");
		commodityTypeLabel.setBounds(45, 100, 54, 15);
		mFrame.getContentPane().add(commodityTypeLabel);
		
		JLabel commodityPriceLabel = new JLabel("商品单价");
		commodityPriceLabel.setBounds(45, 135, 54, 15);
		mFrame.getContentPane().add(commodityPriceLabel);
		
		commodityIndexInput = new JTextField();
		commodityIndexInput.setEditable(false);
		commodityIndexInput.setBounds(109, 27, 110, 21);
		mFrame.getContentPane().add(commodityIndexInput);
		commodityIndexInput.setColumns(10);
		commodityIndexInput.setText(getAutoIndex());
		
		commodityNameInput = new JTextField();
		commodityNameInput.setBounds(109, 62, 110, 21);
		mFrame.getContentPane().add(commodityNameInput);
		commodityNameInput.setColumns(10);
		
		commodityTypeInput = new JTextField();
		commodityTypeInput.setBounds(109, 97, 110, 21);
		mFrame.getContentPane().add(commodityTypeInput);
		commodityTypeInput.setColumns(10);
		
		commodityPriceInput = new JTextField();
		commodityPriceInput.setBounds(109, 132, 110, 18);
		mFrame.getContentPane().add(commodityPriceInput);
		commodityPriceInput.setColumns(10);
		
		JButton addCommotidyButton = new JButton("添加商品");
		addCommotidyButton.setBounds(91, 175, 93, 23);
		mFrame.getContentPane().add(addCommotidyButton);
		addCommotidyButton.addActionListener(addListener);
	}
	
	private String getAutoIndex(){
		return "00001";
	}
	
	public Commodity submitAddedCommodity(){
		String index = commodityIndexInput.getText();
		String name = commodityNameInput.getText();
		String type = commodityTypeInput.getText();
		double price = Double.parseDouble(commodityPriceInput.getText());
		
		Commodity newCommodity = new Commodity(index, name, type, price);
		return newCommodity;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String index = commodityIndexInput.getText();
			String name = commodityNameInput.getText();
			String type = commodityTypeInput.getText();
			String price = commodityPriceInput.getText();
						
			Vector row = new Vector();
			row.add(index);
			row.add(name);
			row.add(type);
			row.add(price);
			mainView.defaultModel.addRow(row);
			
			productService.addProduct(index, name, Double.valueOf(price), type);
			
			commodityIndexInput.setText("");
			commodityNameInput.setText("");
			commodityTypeInput.setText("");
			commodityPriceInput.setText("");
		}
	}
	
}
