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
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:37:50
 */
public class Receipt  {
	private ReceiptDataService  receiptData;

	public Receipt() {
		receiptData = getData();
	}
	
	public ReceiptDataService getData(){
		try {
			return   (ReceiptDataService ) Naming
					.lookup(RMIConfig.PREFIX + ReceiptDataService.NAME);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ResultMessage updateReceipt(ReceiptVO receiptVO) throws RemoteException {
		ReceiptPO po=ReceiptTrans.convertVOtoPO(receiptVO);
		return receiptData.modify(po);
	}

	
	public ResultMessage passReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		ResultMessage message = ResultMessage.SUCCESS;
		for(ReceiptVO vo:VOs){
			ReceiptPO po= ReceiptTrans.convertVOtoPO(vo);
			po.setReceiptState(ReceiptState.SUCCESS);
			ResultMessage messagePass = receiptData.modify(po);
			if(messagePass==ResultMessage.FAIL)
				message=ResultMessage.FAIL;
		}
		return message;
	}

	
	public ResultMessage dontPassReceipt(ArrayList<ReceiptVO> VOs) throws RemoteException {
		ResultMessage message = ResultMessage.SUCCESS;
		for(ReceiptVO vo:VOs){
			ReceiptPO po= ReceiptTrans.convertVOtoPO(vo);
			po.setReceiptState(ReceiptState.FAILURE);
			ResultMessage messagePass = receiptData.modify(po);
			if(messagePass==ResultMessage.FAIL)
				message=ResultMessage.FAIL;
		}
		return message;
	}
	/**
	 * 根据type的类型返回特定类型的单据ArrayList
	 * @author Ann
	 * @param type 单据类型
	 * @param state 单据状态
	 * @return 特定类型的单据ArrayList
	 * @throws RemoteException
	 */
	public <T extends ReceiptVO> ArrayList<T> show(ReceiptType type,ReceiptState state) throws RemoteException {
		ArrayList<ReceiptPO> pos = receiptData.find();
		ArrayList<T> vos = new ArrayList<>();
		for (ReceiptPO receiptPO : pos) {
//			System.out.println(receiptPO.getID());
//			System.out.println(receiptPO.getReceiptState());
			boolean isCorrectType = receiptPO.getReceiptType().equals(type);
			boolean isCorrectState  = receiptPO.getReceiptState().equals(state);
			if(isCorrectType)
				System.out.println("state "+isCorrectState+" "+state);
			if(isCorrectType&&isCorrectState){
				@SuppressWarnings("unchecked")
				T vo = (T) ReceiptTrans.convertPOtoVO(receiptPO);
				System.out.println(vo.toString());
				vos.add(vo);
			}
		}
		return vos;
	}
}
