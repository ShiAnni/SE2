package businesslogic.receiptbl;

import java.util.ArrayList;

import po.receiptpo.AdjustReceiptPO;
import po.receiptpo.DebitBillPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import po.receiptpo.PaymentBillPO;
import po.receiptpo.ReceiptPO;
import po.receiptpo.orderreceiptpo.BranchArrivalListPO;
import po.receiptpo.orderreceiptpo.DeliveryListPO;
import po.receiptpo.orderreceiptpo.LoadingListPO;
import po.receiptpo.orderreceiptpo.TransferArrivalListPO;
import po.receiptpo.orderreceiptpo.TransferOrderPO;
import state.CommodityState;
import state.ExpressType;
import state.PayBillItem;
import state.ReceiptType;
import vo.receiptvo.AdjustReceiptVO;
import vo.receiptvo.DebitBillVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;
import vo.receiptvo.PaymentBillVO;
import vo.receiptvo.ReceiptVO;
import vo.receiptvo.orderreceiptvo.BranchArrivalListVO;
import vo.receiptvo.orderreceiptvo.DeliveryListVO;
import vo.receiptvo.orderreceiptvo.LoadingListVO;
import vo.receiptvo.orderreceiptvo.TransferArrivalListVO;
import vo.receiptvo.orderreceiptvo.TransferOrderVO;

public class ReceiptTrans {
	public static ReceiptPO convertVOtoPO(ReceiptVO vo){
		if(vo==null)
			return null;
		else {
			ReceiptType type = vo.type;
			switch (type) {
			case value:
				
				break;

			default:
				break;
			return null;
//			}
		}
	}
	
	
	public static ReceiptVO convertPOtoVO(ReceiptPO po){
		if(po==null)
			return null;
		else {
			ReceiptType type = po.getReceiptType();
			switch (type) {
			case BRANCH_ARRIVAL:		return convertSpecialPOtoVO((BranchArrivalListPO) po);
			case BRANCH_DELIVER: 		return convertSpecialPOtoVO((DeliveryListPO)po);
			case BRANCH_TRUCK:			return convertSpecialPOtoVO((LoadingListPO)po);
			case TRANS_ARRIVAL:		return convertSpecialPOtoVO((TransferArrivalListPO)po);
			case TRANS_PLANE:
			case TRANS_TRAIN:
			case TRANS_TRUCK:			return convertSpecialPOtoVO((TransferOrderPO)po);
			case EXPENSE:						return convertSpecialPOtoVO((DebitBillPO)po);
			case PAY:								return convertSpecialPOtoVO((PaymentBillPO)po);
			case TAKINGSTOCK:			return convertSpecialPOtoVO((AdjustReceiptPO)po);
			case OUTSTOCK:					return convertSpecialPOtoVO((InventoryExportReceiptPO)po);
			case INSTOCK:					return convertSpecialPOtoVO((InventoryImportReceiptPO)po);
			default:  		return null;
			}
		}
	}
	
	public static ReceiptVO convertSpecialPOtoVO(BranchArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String transferListID = po.getTransferListID();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		ArrayList<String> orders = po.getOrders();
		return new BranchArrivalListVO(id, type, transferListID, departure, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(DeliveryListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new DeliveryListVO(id, type, orders, courierName);
	}
	public static ReceiptVO convertSpecialPOtoVO(LoadingListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String branchID = po.getBranchID();
		String transferNumber = po.getTransferNumber();
		String distination = po.getDistination();
		String carID = po.getCarID();
		String monitorName = po.getMonitorName();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		double money = po.getMoney();
		return new LoadingListVO(id, type, branchID, transferNumber, distination, carID, monitorName, courierName, orders, money);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferArrivalListPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		ArrayList<String> orders = po.getOrders();
		String transferCenterID = po.getTransferCenterID();
		String destination = po.getDestination();
		String departure = po.getDeparture();
		CommodityState state = po.getState();
		return new TransferArrivalListVO(id, type, transferCenterID,
				destination, departure, state, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(TransferOrderPO po){
		String facilityID = po.getFacilityID();
		ReceiptType type = po.getReceiptType();
		String departure = po.getDeparture();
		String destination = po.getDestination();
		ArrayList<String> orders = po.getOrders();
		String courierName = po.getCourierName();
		return new TransferOrderVO(facilityID, type, departure, destination, courierName, orders);
	}
	public static ReceiptVO convertSpecialPOtoVO(AdjustReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		int exA = po.getExA();
		int exB = po.getExB();
		int exC = po.getExC();
		int exD = po.getExD();
		int aftA = po.getAftA();
		int aftB = po.getAftB();
		int aftC = po.getAftC();
		int aftD = po.getAftD();
		return new AdjustReceiptVO(id, type, exA, exB, exC, exD, aftA, aftB, aftC, aftD);
	}
	public static ReceiptVO convertSpecialPOtoVO(DebitBillPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String courierID = po.getCourierID();
		double money = po.getMoney();
		ArrayList<String> orderNumbers = po.getOrderNumbers();
		return new DebitBillVO(id, type, courierID, money, orderNumbers);
	}
	public static ReceiptVO convertSpecialPOtoVO(PaymentBillPO po){
		String iD = po.getID();
		String date = po.getDate();
		ReceiptType type = po.getReceiptType();
		double money = po.getMoney();
		String payerName = po.getPayerName();
		String accountID = po.getAccountID();
		PayBillItem items = po.getPayBillItem();
		String remarks = po.getRemarks();
		return new PaymentBillVO(iD, date, type, money, payerName, accountID, items, remarks);
	}
	public static ReceiptVO convertSpecialPOtoVO(InventoryExportReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String destination = po.getDestination();
		String depture = po.getDepture();
		ExpressType expressType = po.getExpressType();
		String transferID = po.getTransferID();
		String commoditiesID = po.getCommoditiesID();
		int a = po.getA();
		int b =po.getB();
		int c = po.getC();
		int d = po.getD();
		return new InventoryExportReceiptVO(
				id, type, destination, depture, expressType, transferID, commoditiesID, a, b, c, d);
	}
	public static ReceiptVO convertSpecialPOtoVO(InventoryImportReceiptPO po){
		String id = po.getID();
		ReceiptType type = po.getReceiptType();
		String destination = po.getDestination();
		String depture = po.getDepture();
		String commoditiesID = po.getCommoditiesID();
		int a = po.getA();
		int b =po.getB();
		int c = po.getC();
		int d = po.getD();
		return new InventoryImportReceiptVO(id, type, depture, destination, commoditiesID, a, b, c, d);
	}
	
	public static ArrayList<ReceiptVO> convertPOstoVOs(ArrayList<ReceiptPO> pos){
		ArrayList<ReceiptVO> vos=new ArrayList<ReceiptVO>();
		for(ReceiptPO po:pos){
			ReceiptVO vo=convertPOtoVO(po);
			 vos.add(vo);
		}
		return vos;
	}
	
	public static ArrayList<ReceiptPO> convertVOstoPOs(ArrayList<ReceiptVO> vos){
		ArrayList<ReceiptPO> pos=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:vos){
			ReceiptPO po=convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}
}
