package service.medicine;

import java.util.List;
import java.util.Map;
 

import dao.medicine.SupplierDao; 
import entity.medicine.Supplier;

public class SupplierService {
	SupplierDao supplierDao = new SupplierDao();
	public List<Map<String, Object>> queryAllSupplier(int page, int limit){
		try {
			return supplierDao.queryAllSupplier(page, limit);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
			return null;
		}
	}
	public void deleteSupplier(String id){
		try {
			supplierDao.deleteSupplier(id);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
	public void updateSupplier(Supplier supplier ){
		try {
			supplierDao.updateSupplier(supplier);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
	public void addSupplier(Supplier supplier){
		try {
			supplierDao.addSupplier(supplier);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
public List<Map<String, Object>> selectSupplier(String selItem,String selContent) {
		
		try {
			return supplierDao.selectSupplier(selItem, selContent);
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null; 
	}
}
