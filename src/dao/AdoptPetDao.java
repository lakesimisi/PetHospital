package dao;

import java.util.List;
import java.util.Map;

import entity.AdoptPet;
import entity.Medicine;
import entity.Pet;
import util.CommonDAO;

public class AdoptPetDao {
	
	CommonDAO commonDAO = new CommonDAO();
	public void addAdoptPet(AdoptPet adoptPet) throws Exception{ 
		try {
			String sql = "INSERT INTO adoptPet(adoptPetCode,masterid,age,nickname,gender,sterilization,immunity,species,color,weight,photo,state,inHospital) "
					+ "VALUES('"+adoptPet.getAdoptPetCode()+"','"+null+"','"+adoptPet.getAge()+"','"+adoptPet.getNickname()+"','"+adoptPet.getGender()+"'"
					+ ",'"+adoptPet.getSterilization()+"','"+adoptPet.getImmunity()+"','"+adoptPet.getSpecies()+"','"+adoptPet.getColor()+"','"+adoptPet.getWeight()+"'"
							+ ",'"+adoptPet.getPhoto()+"','������','��')";
			this.commonDAO.executeUpdate(sql, null); 
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace(); 
		}
	}
	/***
	 * ����Ա��ѯ���г���
	 * @param state
	 * @return
	 */
	public List<Map<String, Object>> queryAllPets(String state) {

		String sql = "SELECT * FROM adoptPet where state = '" +state+ "'";
		try {
			return commonDAO.excuteQuery(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
		}
		return null; 
	}
	/***
	 * ����Ա��ҳ��ѯ���г���
	 * @param page
	 * @param limits
	 * @param state
	 * @return
	 */
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
	 /***
	  * ����Ա
	  * @param selItem
	  * @param selContent
	  * @param state
	  * @return
	  */
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
 /***
  * ����Ա
  * @param selItem
  * @param selContent
  * @param pageSize
  * @param currPage
  * @param state
  * @return
  */
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
	 /***
	  * �û���ѯ������������
	  * @param masterId
	  * @return
	  */
	 public List<Map<String, Object>> queryAllByMaster(String masterId) {

			try {
				String sql = "select * from adoptPet where masterId =" + masterId;
				return commonDAO.excuteQuery(sql, null);
			} catch (Exception e) {
				new Exception("�������ݿ����").printStackTrace();
			}
			return null; 
		}
	 /**
	  *  �û���ҳ��ѯ������������
	  * @param page
	  * @param limits
	  * @return
	  */
		 public List<Map<String, Object>> queryAllByMasterLimits(int page, int limits, String masterId){
			 int startIndex = (page - 1) * limits;
				try {
					String sql = "select *  FROM adoptpet where masterid = '"+masterId+"' order by id desc limit " + startIndex + "," + limits;
					return this.commonDAO.excuteQuery(sql, null);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return null;  
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
	 public void updateState(String petCode,String masterid){ 
		  
		 try {
			 String sql = "UPDATE adoptPet SET state='������', masterid = "+masterid+" where adoptPetCode = "+petCode+""; 
			 this.commonDAO.executeUpdate(sql, null);  
			}
			catch(Exception e){
				e.printStackTrace(); 
			} 
	  }
}
