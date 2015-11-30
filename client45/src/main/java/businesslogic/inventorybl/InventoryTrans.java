package businesslogic.inventorybl;

import java.util.ArrayList;
import po.InventoryPO;
import po.receiptpo.InventoryExportReceiptPO;
import po.receiptpo.InventoryImportReceiptPO;
import state.ReceiptType;
import vo.InventoryVO;
import vo.receiptvo.InventoryExportReceiptVO;
import vo.receiptvo.InventoryImportReceiptVO;

public class InventoryTrans {
	public static InventoryPO convertVOtoPO(InventoryVO vo) {
		InventoryPO po = new InventoryPO(vo.ID, vo.area, vo.row, vo.frame, vo.position, vo.isEmpty);
		return po;
	}

	public static InventoryVO convertPOtoVO(InventoryPO po) {
		InventoryVO vo = new InventoryVO(po.getArea(), po.getRow(), po.getFrame(), po.getPosition());
		return vo;
	}

	public static InventoryImportReceiptVO convertPOtoVO(InventoryImportReceiptPO po) {
		InventoryImportReceiptVO vo = new InventoryImportReceiptVO(po.getCommoditiesID(), ReceiptType.INSTOCK,po.getDepture(),
				po.getDestination(),po.getCommoditiesID(),po.getArea(),po.getRow(),po.getFrame(),po.getPosition());
		return vo;
	}
	
	public static InventoryImportReceiptPO convertVOtoPO(InventoryImportReceiptVO vo) {
		InventoryImportReceiptPO po = new InventoryImportReceiptPO(vo.ID, ReceiptType.INSTOCK,vo.depture,
		vo.destination,vo.CommoditiesID,vo.area, vo.row ,vo.frame, vo.position);
		return po;
	}
	
	
	public static InventoryExportReceiptPO convertVOtoPO(InventoryExportReceiptVO vo){
		InventoryExportReceiptPO po = new InventoryExportReceiptPO(vo.ID, ReceiptType.OUTSTOCK,vo.destination, vo.depture, vo.expressType,vo. TransferID,
				vo.CommoditiesID,vo.area, vo.row ,vo.frame, vo.position);
				return po;
	}
	public static InventoryExportReceiptVO convertPOtoVO(InventoryExportReceiptPO po){
		InventoryExportReceiptVO vo = new InventoryExportReceiptVO(po.getID(), ReceiptType.OUTSTOCK,po.destination, po.depture, po.expressType,po. TransferID,
				po.CommoditiesID, po.area, po.row ,po.frame, po.position);
				return vo;
	}
	
	public static ArrayList<InventoryVO> convertInventoryPOstoVOs(ArrayList<InventoryPO> pos) {
		ArrayList<InventoryVO> vos = new ArrayList<InventoryVO>();
		for (InventoryPO po : pos) {
			InventoryVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}

	public static ArrayList<InventoryPO> convertInventoryVOstoPOs(ArrayList<InventoryVO> vos) {
		ArrayList<InventoryPO> pos = new ArrayList<InventoryPO>();
		for (InventoryVO vo : vos) {
			InventoryPO po = InventoryTrans.convertVOtoPO(vo);
			pos.add(po);
		}
		return pos;
	}

	public static ArrayList<InventoryImportReceiptVO> convertInventoryImportReceiptPOstoVOs(
			ArrayList<InventoryImportReceiptPO> pos) {
		ArrayList<InventoryImportReceiptVO> vos = new ArrayList<InventoryImportReceiptVO>();
		for (InventoryImportReceiptPO po : pos) {
			InventoryImportReceiptVO vo = InventoryTrans.convertPOtoVO(po);
			vos.add(vo);
		}
		return vos;
	}
}
