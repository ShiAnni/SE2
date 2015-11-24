package businesslogic.fundbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.fundblservice.BankAccountBLService;
import state.ConfirmState;
import state.FindTypeAccount;
import state.ResultMessage;
import vo.BankAccountVO;

public class BankAccountController implements BankAccountBLService{
    BankAccount BankAccountBL;
	@Override
	public ConfirmState confirmOperation() {
		return BankAccountBL.confirmOperation();
	}

	@Override
	public String getID() {
		try {
			return BankAccountBL.getID();
		} catch (RemoteException e) {
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> show() {
		try {
			return BankAccountBL.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(BankAccountVO vo) {
		try {
			return BankAccountBL.add(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage delete(String ID) {
		try {
			return BankAccountBL.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage update(BankAccountVO vo) {
		try {
			return BankAccountBL.update(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BankAccountVO> find(String keywords, FindTypeAccount type) {
		try {
			return BankAccountBL.find(keywords, type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
