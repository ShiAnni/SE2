package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.funddataservice.BankAccountDataService;
import po.BankAccountPO;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccount  {
	private BankAccountDataService bankAccountData;
	public BankAccount() {try {
			bankAccountData = (BankAccountDataService) Naming.lookup("rmi://" + "127.0.0.1" + ":" + "8888" + "/"+BankAccountDataService.NAME);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
	} catch (NotBoundException e) {
		e.printStackTrace();
	}}

	
	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	
	public String getID(){
		return bankAccountData.getID();
		
	}

	
	public ArrayList<BankAccountVO> show(){
		return bankAccountData.show();
	}

	
	public ResultMessage add(BankAccountVO vo) {
		try {
			return bankAccountData.add(FundTrans.convertVOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	public ResultMessage delete(String ID) {
		try {
			return bankAccountData.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	public ResultMessage update(BankAccountVO vo) {
		try {
			return bankAccountData.modify(FundTrans.convertVOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) throws RemoteException {
		ArrayList<BankAccountPO> pos=bankAccountData.find(keywords,type);
		ArrayList<BankAccountVO> vos=FundTrans.convertBankAccountPOstoVOs(pos);
			return vos;
	}
    
}
