package vo;

import vo.receiptvo.ReceiptVO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class InventoryVO extends ReceiptVO {
    //区
	public int a;
	//排;
	public int b;
	//架
	public int c;
	//位
	public int d;
	//空或满
	public String EmptyOrFull;

	public InventoryVO(String id, int a, int b, int c, int d, String emptyOrFull) {
		super(id);
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		EmptyOrFull = emptyOrFull;
	}


}
