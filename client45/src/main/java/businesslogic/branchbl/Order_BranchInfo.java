package businesslogic.branchbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.Order;
import businesslogic.orderbl.OrderTrans;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import vo.OrderVO;

public class Order_BranchInfo {
	Order order;
	OrderDataService orderData;
	public Order_BranchInfo() {
		order = new Order();
		orderData = order.getOrderData();
	}
	/**
	 * 当总经理审批后，修改订单的信息（主要是历史轨迹）
	 * @param message 历史轨迹信息
	 * @return
	 * @throws RemoteException 
	 */
	public void changeOrderState(ArrayList<OrderVO> orders,String message) throws RemoteException{
		for (OrderVO orderVO : orders) {
			addHitoryMessage(orderVO, message);
		}
	}
	
	private void addHitoryMessage(OrderVO order,String message) throws RemoteException{
		ArrayList<String> historyMessage = order.midAddres;
		historyMessage.add(message);
		OrderPO po = OrderTrans.convertVOtoPO(order);
		po.setMidAddres(historyMessage);
		orderData.modify(po);
	}
}
