package dataservice.recorddataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.BussinessConditionPO;
import po.BussinessProcessPO;
import po.PersistentObject;
import po.receiptpo.DebitAndPayBillPO;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public interface RecordDataService extends DataService<PersistentObject> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "RecordData";
	/**返回1. 收款单2.付款单**/
	public String getBegin() throws RemoteException;

}
