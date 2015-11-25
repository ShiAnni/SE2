package ui.specialui.sender;

import ui.myui.MyJLabel;
import ui.myui.MyJPanel;


/**
 * 物流信息显示面板
 * @author zsq
 * @time 2015/11/18 19:34
 */
public class Panel_Sender_Total extends MyJPanel{
	private Panel_Sender_CommodityInfo commodityPanel ;
	private Panel_Sender_logisticInfo logisticPanel;
	public Panel_Sender_Total(Frame_Sender frame_Sender) {
		super(0, 0, 1280, 720);
		this.setOpaque(false);
		this.initComponent(frame_Sender);
	}

	private void initComponent(Frame_Sender frame_Sender) {
		
		commodityPanel = new Panel_Sender_CommodityInfo();
		logisticPanel = new Panel_Sender_logisticInfo();
		
		this.add(commodityPanel);
		this.add(logisticPanel);
		this.add(new MyJLabel(560,30,150,40,"物流信息查询",22,true));
		
		
		
	}

	
	private static final long serialVersionUID = 1L;

}
