package dataservice.receiptdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataService;
import po.receiptpo.ReceiptPO;
import state.ResultMessage;
/**
 * 提供单据信息的查看、单据修改和单据审批的服务
 * @author zsq
 * @version Oct 22,2015
 * @param <ReceiptPO>
 */
public interface ReceiptDataService extends DataService<ReceiptPO> {
	/** 接口的名称，RMI绑定时候的名称 */
	public static final String NAME = "ReceiptData";
	/**
	 * 进行一条单据信息的修改或者一条单据的审批
	 * @param PO
	 * @return 
	 */
	public ResultMessage update(ReceiptPO PO) throws RemoteException;
	/**
	 * 进行一条单据信息的查看
	 * @param PO
	 * @return 
	 */
	public ArrayList<ReceiptPO> find() throws RemoteException;
	/**
	 * 得到
	 * @return
	 */
	public String getID() throws RemoteException;
}
