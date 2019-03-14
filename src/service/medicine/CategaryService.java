package service.medicine;

import java.util.List;
import java.util.Map;

import dao.medicine.CategaryDao;
import entity.medicine.Categary;

public class CategaryService {
	CategaryDao categaryDao = new CategaryDao();
	public List<Map<String, Object>> queryAllCategary(int page, int limit){
		try {
			return categaryDao.queryAllCategary(page,limit);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
			return null;
		}
	}
	public void deleteCategary(String id){
		try {
			 categaryDao.deleteCategary(id);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
	public void updateCategary(Categary categary){
		try {
			 categaryDao.updateCategary(categary);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
	public void addCategary(String categary){
		try {
			 categaryDao.addCategary(categary);
		} catch (Exception e) { 
			new Exception("�������ݿ����").printStackTrace();
		}
	}
public List<Map<String, Object>> selectCategary(String selItem,String selContent) {
		
		try {
			return categaryDao.selectCategary(selItem, selContent);
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null; 
	}
}
