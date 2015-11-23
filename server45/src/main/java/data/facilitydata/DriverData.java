package data.facilitydata;

import java.rmi.RemoteException;

import data.ManageData;
import dataservice.facilitydataservice.DriverDataService;
import po.accountpo.DriverPO;
import util.SerSaveAndLoad;

public class DriverData  extends ManageData<DriverPO> implements DriverDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//poList在Data里,虽然每个Data的继承类都以Data为父类，但他们拥有不同的poList
	public DriverData() throws RemoteException {
		//TODO 什么Name待考虑
		poList=new SerSaveAndLoad<DriverPO>("data/"+NAME+".ser");
	}

}
