package businesslogic;

import businesslogic.accountbl.AccountController;
import businesslogic.basebl.BaseController;
import businesslogic.branchbl.BranchController;
import businesslogic.facilitybl.DriverController;
import businesslogic.facilitybl.FacilityController;
import businesslogic.fundbl.BankAccountController;
import businesslogic.fundbl.DebitAndPayBillController;
import businesslogic.fundbl.DebitAndPayBillShowController;
import businesslogic.fundbl.ExpenseController;
import businesslogic.inventorybl.InventoryController;
import businesslogic.orderbl.OrderController;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.receiptbl.ReceiptController;
import businesslogic.recordbl.RecordController;
import businesslogic.userbl.UserController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
	
	public static DriverController getDriverController(){
		return new DriverController();
	}

	public static UserController getUserController(){
		return new UserController();
	}
	
	
	public static AccountController getAccountController() {
		return new AccountController();
	}
	
	public static BaseController getBaseController() {
		return new BaseController();
	}
	
	public static BranchController getBranchController() {
		return new BranchController();
	}
	
	public static 	BankAccountController getBankAccountController() {
		return new BankAccountController();
	}
	public static 	DebitAndPayBillController getDebitAndPayBillController() {
		return new DebitAndPayBillController();
	}
	
	public static 	DebitAndPayBillShowController getDebitAndPayBillShowController() {
		return new DebitAndPayBillShowController();
	}
	public static 	ExpenseController getExpenseController() {
		return new ExpenseController();
	}
	
	
	public static InventoryController getInventoryController() {
		return new InventoryController();
	}
	
	public static OrganizationController getOrganizationController() {
		return new OrganizationController();
	}
	
	public static RecordController getRecordController() {
		return new RecordController();
	}

	public static ReceiptController getReceiptController() {
		return new ReceiptController();
	}
	
	public static OrderController getOrderController(){
		return new OrderController();
	}

	
}
