package service;

import java.util.List;
import java.util.Map;

import dao.PetDao;

public class PetService {
	PetDao petDao = new PetDao();
	public List<Map<String, Object>> queryAllPets(){
		try {
			return petDao.queryAllPets();
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();	
			return null;
		} 
	}
}
