package businesslogic.transfer;

import java.util.ArrayList;

import businesslogicservice.transferblservice.TransferBLService;
import po.receiptpo.ReceiptPO;
import state.CommodityState;
import state.ConfirmState;
import state.ResultMessage;
import vo.CommodityVO;
import vo.receiptvo.TransferArrivalListVO;
import vo.receiptvo.TransferOrderVO;

public class Transfer implements TransferBLService {
	
	@Override
	public ConfirmState confirmOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CommodityVO> getAllCommodities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO planeTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO truckTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferOrderVO trainTransfer(String facilityID, String departure, String destination, String courierName,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(ReceiptPO receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferArrivalListVO receiptList(String transferID, String departure, CommodityState state,
			ArrayList<String> orders) {
		// TODO Auto-generated method stub
		return null;
	}

}
