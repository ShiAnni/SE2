package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelWin;

import businesslogicservice.receiptblservice.ReceiptBLService;
import dataservice.receiptdataservice.ReceiptDataService;
import po.receiptpo.ReceiptPO;
import state.ReceiptState;
import state.ReceiptType;
import state.ResultMessage;
import vo.receiptvo.ReceiptVO;

public class Receipt  {
	private ReceiptDataService  receiptData;

	public Receipt() {
		try {
			receiptData = (ReceiptDataService ) Naming
					.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/" + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) throws RemoteException {
		ReceiptPO po=new ReceiptPO(receiptVO.getID());
		receiptData.modify(po);
		return receiptData.modify(po);
	}

	
	public ArrayList<ReceiptPO> passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		ArrayList<ReceiptPO> POs=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:VOs){
			ReceiptPO po=new ReceiptPO(vo.getID());
			po.setReceiptState(ReceiptState.SUCCESS);
			POs.add(po);
		}
		return POs;
	}

	
	public ArrayList<ReceiptPO> dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		ArrayList<ReceiptPO> POs=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:VOs){
			ReceiptPO po=new ReceiptPO(vo.getID());
			po.setReceiptState(ReceiptState.FAILURE);
			POs.add(po);
		}
		return POs;
	}

	
	public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) {
		ArrayList<ReceiptVO> VOs=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptPO> POs=receiptData.showReceipt(receiptStates);
		for(ReceiptPO po:POs){
			ReceiptVO vo=new ReceiptVO(po.getID());
			 VOs.add(vo);
		}
		return VOs;
	}
    
}
