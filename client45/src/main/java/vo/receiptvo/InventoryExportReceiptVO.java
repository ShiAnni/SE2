package vo.receiptvo;

import state.ExpressType;
import state.ReceiptType;

public class InventoryExportReceiptVO extends ReceiptVO {
	/**目的地**/
	public String destination;
	//出发地
	public String depture;
	/**装运形式**/
	public ExpressType expressType;
	//装运编号
	public String TransferID;
	//货物编号
	public String CommoditiesID;
	//区
	public int a;
	//排
	public int b;
	//架
	public int c;
	//位
	public int d;
	public InventoryExportReceiptVO(String id, ReceiptType type, String destination, String depture, ExpressType expressType,
			String transferID, String commoditiesID, int a, int b, int c, int d) {
		super(id, type);
		this.destination = destination;
		this.depture = depture;
		this.expressType=expressType;
		this.TransferID = transferID;
		this.CommoditiesID = commoditiesID;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
}
