package businesslogic.accountbl;
/**
 * @author LIUXUANLIN
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.accountblservice.AccountBLService;
import vo.accountvo.AccountVO;

public class AccountController implements AccountBLService{
     Account AccountBL;
	@Override
	public ArrayList<AccountVO> show() {
		// TODO Auto-generated method stub
		try {
			return AccountBL.show();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
