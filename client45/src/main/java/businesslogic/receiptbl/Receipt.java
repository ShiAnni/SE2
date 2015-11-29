package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
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
					.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	
	public ResultMessage updateReceipt(ReceiptVO receiptVO, ReceiptType receiptType) throws RemoteException {
		ReceiptPO po=new ReceiptPO(receiptVO.ID, receiptType);
		receiptData.modify(po);
		return receiptData.modify(po);
	}

	
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		ArrayList<ReceiptPO> POs=new ArrayList<ReceiptPO>();
		for(ReceiptVO vo:VOs){
			ReceiptPO po=new ReceiptPO(vo.ID, receiptTypes);
			po.setReceiptState(ReceiptState.SUCCESS);
			POs.add(po);
		}
//		return POs;
		return null;
	}

	
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs, ReceiptType receiptTypes) {
		//TODO 写的不对 应该找相应的单据类型
		ArrayList<ReceiptPO> POs=ReceiptTrans.convertVOstoPOs(VOs);
		for (ReceiptPO receiptPO : POs) {
			receiptPO.setReceiptState(ReceiptState.FAILURE);
		}
//		return POs
		return null;
	}
	
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type,ReceiptState state) throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
			if(receiptPO.getReceiptType().equals(type)||receiptPO.getReceiptState().equals(state)){
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				vos.add(vo);
			}
		}
		return vos;
	}
	/*public static void main(String[] args) throws RemoteException {
		Receipt receipt = new Receipt();
		ArrayList<TransferOrderVO> vos = receipt.show(ReceiptType.TRANS_PLANE, null);
		System.out.println(vos);
	}*/
	/*public ArrayList<ReceiptVO> showReceipt(ReceiptState receiptStates) throws RemoteException {
		ArrayList<ReceiptPO> pos=receiptData.showReceipt(receiptStates);
		ArrayList<ReceiptVO> vos=ReceiptTrans.convertPOstoVOs(pos);
		return vos;
	}*/
}
