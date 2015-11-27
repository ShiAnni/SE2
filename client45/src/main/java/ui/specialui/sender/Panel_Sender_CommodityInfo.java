package ui.specialui.sender;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.myui.MyFont;
import ui.myui.MyJComboBox;
import ui.myui.MyJLabel;
import ui.myui.MyJTextField;
import ui.myui.MyJTable;
import ui.myui.MyTranslucentPanel;
/**
 * 订单货物信息显示面板
 * @author zsq
 * @time 2015/11/18 19:32
 */
public class Panel_Sender_CommodityInfo extends MyTranslucentPanel{
	private MyJTable table;
	public Panel_Sender_CommodityInfo() {
		super(10, 220, 620, 490);
		this.initComponent();
	}

	

	private void initComponent() {
		this.add(new MyJLabel(250,10,170,40,"订单信息",18,true));
		//the table

				String[] headers = {"订单号","寄件人","收件人","费用","预计到达时间"};
				table = new MyJTable(headers,false);

				
				table.setBackground(new Color(40, 42, 66));
				table.setForeground(Color.WHITE);
				table.setFont(new MyFont(14));
							
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
				tcr.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, tcr);
									  	
				JScrollPane jsp=new JScrollPane(table);
				JTableHeader head = table.getTableHeader();
				head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
				head.setFont(new MyFont(14));
				head.setForeground(Color.BLACK);
				head.setResizingAllowed(false);
								
				jsp.setBounds(10, 50, 610, 430);
				jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
				jsp.setOpaque(false);
				jsp.setBorder(BorderFactory.createEmptyBorder());
				jsp.setVisible(true);
				this.add(jsp);
	}
	private static final long serialVersionUID = 1L;

}
