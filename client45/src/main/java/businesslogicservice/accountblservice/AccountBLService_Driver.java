package businesslogicservice.accountblservice;

import java.rmi.RemoteException;

public class AccountBLService_Driver {
	public void drive(AccountBLService accountBLService) throws RemoteException{
		
	  accountBLService.show();
	 System.out.println("输出全部员工账户信息列表");
		
	}
	public static void main(String[] args) throws RemoteException{
		AccountBLService_Stub accountblservice_stub=new AccountBLService_Stub(null, null, null, null, null, null, 0, null, 0);
		AccountBLService_Driver accountblservice_driver=new AccountBLService_Driver();
		accountblservice_driver.drive(accountblservice_stub);
	}
}

