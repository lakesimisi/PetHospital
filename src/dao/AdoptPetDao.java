package dao;

import java.util.List;
import java.util.Map;

import entity.AdoptPet;
import entity.Pet;
import util.CommonDAO;

public class AdoptPetDao {
	
	CommonDAO commonDAO = new CommonDAO();

	public List<Map<String, Object>> queryAllPets(String state) {

		String sql = "SELECT * FROM adoptPet where state = '" +state+ "'";
		try {
			return commonDAO.excuteQuery(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ������").printStackTrace();
		}
		return null; 
	}
	
	 public List<Map<String, Object>> queryAllByLimits(int page, int limits, String state){
		 int startIndex = (page - 1) * limits;
			try {
				String sql = "SELECT * FROM adoptPet where state = '"+state+"' order by id desc limit " + startIndex + "," + limits;
				return this.commonDAO.excuteQuery(sql, null);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;  
	}
	 
	 public List<Map<String, Object>> selectPet(String selItem, String selContent, String state){ 
		   try {
			   String sql = "select * FROM adoptPet WHERE "+selItem+" like '%"+selContent+"%' and state = '"+state+"' order by id DESC";
				
				return this.commonDAO.excuteQuery(sql, null); 
				 
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			} 
	  } 
 
	 public List<Map<String, Object>> selectPetByLimits(String selItem,String selContent,int pageSize,int currPage, String state){ 
		 int startIndex = (currPage - 1) * pageSize; 
		 try {
			   String sql = "select * FROM adoptPet WHERE "+selItem+" like '%"+selContent+"%' and state = '"+state+"' order by id DESC limit " +startIndex+","+pageSize;
				
				return this.commonDAO.excuteQuery(sql, null); 
				 
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			} 
	  }
	 
	 public void updatePet(AdoptPet pet){ 
		  
		 try {
			   String sql = "update adoptpet SET age = '"+pet.getAge() +"',nickname = '"+pet.getNickname()+"',sterilization = '"+pet.getSterilization()+"',immunity = '"+pet.getImmunity()+"',species = '"+pet.getSpecies()+"',color = '"+pet.getColor()+"',weight = '"+pet.getWeight()+"',photo = '"+pet.getPhoto()+"' WHERE adoptPetCode = '"+ pet.getAdoptPetCode()+"'";
				  this.commonDAO.executeUpdate(sql, null);  
			}
			catch(Exception e){
				e.printStackTrace(); 
			} 
	  }
	 
	 public void deletePet(String code){ 
		  
		 try {
			 String sql = "delete from adoptpet where adoptPetCode ='" +code+ "'"; 
			 this.commonDAO.executeUpdate(sql, null);  
			}
			catch(Exception e){
				e.printStackTrace(); 
			} 
	  }
}
