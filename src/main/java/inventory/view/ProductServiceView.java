package inventory.view;

import inventory.dao.ProductDao;
import inventory.dao.impl.ProductDaoImpl;
import inventory.service.ProductService;
import inventory.service.impl.ProductServiceImpl;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import inventory.config.DBManage;
public class ProductServiceView extends JFrame{
	ProductServiceView p = this;
	JFrame mFrame;
	JTable commodityTable;
	static DefaultTableModel defaultModel;	
	private ProductService productService;
	
	public ProductServiceView(ProductService pService){
		productService = pService;
		
		mFrame = new JFrame();
		mFrame.getContentPane().setLayout(null);
		mFrame.setVisible(true);
		mFrame.setSize(500, 400);
		mFrame.setLocation(300, 300);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, 91, 321);
		mFrame.getContentPane().add(panel);
		
		JButton addCommodityButton = new JButton("添加商品");
		addCommodityButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddCommodityView acv = new AddCommodityView(p);	
				acv.setProductService(productService);
			}
		});
		
		JButton deleteCommodityButton = new JButton("删除商品");
		deleteCommodityButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(addCommodityButton);
		panel.add(deleteCommodityButton);
		
		JLabel label = new JLabel("添加商品");
		label.setBounds(0, 0, 434, 21);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		mFrame.getContentPane().add(label);
		
		Vector vColumns = new Vector();
		vColumns.add("商品编号");
		vColumns.add("商品名称");
		vColumns.add("商品型号");
		vColumns.add("单价");
		Vector vData = new Vector();
		

		defaultModel = new DefaultTableModel(vData, vColumns);
		commodityTable = new JTable(defaultModel);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(commodityTable);
		commodityTable.setFillsViewportHeight(true);
		scrollPane.setBounds(101, 31, 373, 321);
		mFrame.getContentPane().add(scrollPane);
	}
	
	public static void main(String[] args) {	
		//首先要初始化数据库，创建数据库连接（因为DaoImpl类在初始化的时候会用到数据库连接）
		DBManage dbManage = new DBManage();
		dbManage.createConnection();
		
		ProductDao pDao = new ProductDaoImpl();
		ProductService pService = new ProductServiceImpl();		
		pService.setProductDao(pDao);
		
		new ProductServiceView(pService);
	}
}
