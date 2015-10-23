package businesslogicservice.inventoryblservice;

import po.receiptpo.ReceiptPO;
import vo.InventoryCheckVO;
import vo.InventoryExportReceiptVO;
import vo.InventoryImportReceiptVO;
import vo.InventoryViewVO;
import vo.receiptpvo.ReceiptVO;

public interface InventoryBLService {
	/**缁崵绮洪弰鍓с仛濮濄倖妞傞梻瀛橆唽閸愬懐娈戦崙鍝勫弳鎼存挻鏆熼柌蹇嬶拷渚�鍣炬０婵勶拷浣哥氨鐎涙ü缍呯純锟�**/
	public InventoryViewVO viewInventory(String beginDate, String endDate);
	
	/**閺勫墽銇氶幋顏囧殾閻╂鍋ｉ弮鍫曟？閻ㄥ嫬绨辩�涙ê鎻╅悡锟�**/
	public InventoryCheckVO checkRecord( );
	
	/*閸忋儱绨�*/
	/**瀵版鍩岀拠銉ュ弳鎼存挸宕熼惃鍕椽閸欙拷**/
	public String getImportID ();
	
	/**闁瀚ㄦ潻娑滎攽閸忋儱绨遍惃鍕彛閻椻晜鍧婇崝鐘变繆閹垰鍩屾潻娑滄彛閸楋拷**/
	public void addCommodities(ReceiptVO receipt);
	
	/**闁瀚ㄩ獮鑸靛潑閸旂姷娴夋惔鏃傛畱閺佺増宓侀敍鍫ｎ吂閸楁洘澧潻鎰椽閸欐灚锟戒礁鍙嗘惔鎾存）閺堢喆锟戒胶娲伴惃鍕勾閵嗕礁灏崣鏋拷浣瑰笓閸欐灚锟戒焦鐏﹂崣鏋拷浣风秴閸欏嚖绱氶崚鎷岀箻鐠愌冨礋娑擃厾鏁撻幋鎰箻鐠愌冨礋PO**/
	public ReceiptPO   buildImport();
	
	/**閸楁洘宓佺悮顐ｅ絹娴溿倕褰傞柅浣虹舶缂佸繒鎮婃潻娑滎攽鐎光剝澹�**/
	public InventoryImportReceiptVO submitImport();
	
	/*閸戝搫绨�*/
	/**瀵版鍩岀拠銉ュ毉鎼存挸宕熼惃鍕椽閸欙拷**/
	public String getExportID ();
	
	/**闁瀚ㄦ潻娑滎攽閸戝搫绨遍惃鍕彛閻椻晜鍧婇崝鐘变繆閹垰鍩岄崙鍝勭氨閸楋拷**/
	public void minusCommodities(ReceiptVO receipt);
	
	/**闁瀚ㄩ獮鑸靛潑閸旂姷娴夋惔鏃傛畱閺佺増宓侀敍鍫ｎ吂閸楁洘澧潻鎰椽閸欐灚锟戒礁鍤惔鎾存）閺堢喆锟戒胶娲伴惃鍕勾閵嗕浇顥婃潻鎰埌瀵繈锟戒椒鑵戞潪顒�宕熺紓鏍у娇閿涘鍩岄崙鍝勭氨閸楁洑鑵戦悽鐔稿灇閸戝搫绨遍崡鏄塐**/
	public ReceiptPO buildExport();
	
	/**閸楁洘宓佺悮顐ｅ絹娴溿倕褰傞柅浣虹舶缂佸繒鎮婃潻娑滎攽鐎癸拷**/
	public InventoryExportReceiptVO submitExport();
	
	/*鐠嬪啯鏆�*/
	/**瀵版鍩岀拠銉ㄧ殶閺佹潙宕熼惃鍕椽閸欙拷**/
	public String getAdjustID ();
	
	/**鏉堟挸鍙嗙悮顐ョ殶閺佺鎻ｉ悧鈺冩畱鐠併垹宕熼幍妯跨箥缂傛牕褰块妴浣稿斧閸忓牆灏崣鏋拷浣瑰笓閸欐灚锟戒焦鐏﹂崣鏋拷浣风秴閸欏嘲寮风拫鍐╂殻閸氬海娈戦崠鍝勫娇閵嗕焦甯撻崣鏋拷浣圭仸閸欐灚锟戒椒缍呴崣锟�**/
	public ReceiptPO adjust( );

}
