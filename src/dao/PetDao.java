package dao;

import java.util.List;
import java.util.Map;

import util.CommonDAO;

public class PetDao {
	CommonDAO commonDAO = new CommonDAO();
	public List<Map<String, Object>> queryAllPets(){
		
		String sql = "SELECT * FROM pet  JOIN customer WHERE pet.masterid = customer.customerCode";
		try {
			return commonDAO.excuteQuery(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();	
		}
		return null;
		
	}
}
