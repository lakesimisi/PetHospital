package dao;

import java.util.List;
import java.util.Map;

import entity.AdoptPet;
import entity.Pet;
import util.CommonDAO;

public class PetDao {
	CommonDAO commonDAO = new CommonDAO();
	AdoptPetDao adoptPetDao = new AdoptPetDao();
	/***
	 * ����Ա��ѯ���г���
	 * @return
	 */
	public List<Map<String, Object>> queryAllPets() {

		String sql = "SELECT * FROM pet  JOIN customer WHERE pet.masterid = customer.customerCode";
		try {
			return commonDAO.excuteQuery(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
		}
		return null; 
	}
	/**
	 * ����Ա��ҳ��ѯ���г���
	 * @param page
	 * @param limits
	 * @return
	 */
	 public List<Map<String, Object>> queryAllByLimits(int page, int limits){
		 int startIndex = (page - 1) * limits;
			try {
				String sql = "SELECT * FROM pet order by id desc limit " + startIndex + "," + limits;
				return this.commonDAO.excuteQuery(sql, null);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;  
	}
		/**
		 * �û���ѯ���г���(�����ĺ��Լ���)
		 * @param page
		 * @param limits
		 * @return
		 */
	 public List<Map<String, Object>> queryAllByMaster(String masterId) {

			try {
				String sql = "SELECT * FROM pet WHERE masterid = '"+masterId+"' UNION select a.id,a.masterid,a.age,a.nickname,a.gender,a.sterilization,a.immunity,a.species,a.color,a.weight,a.adoptPetCode as petCode,a.photo AS petImg,a.state,a.inHospital FROM adoptpet AS a where a.masterid = '"+masterId+"'";
				return commonDAO.excuteQuery(sql, null);
			} catch (Exception e) {
				new Exception("�������ݿ����").printStackTrace();
			}
			return null; 
		}
	 /**
	  *  �û���ҳ��ѯ���г���(�����ĺ��Լ���)
	  * @param page
	  * @param limits
	  * @return
	  */
		 public List<Map<String, Object>> queryAllByMasterLimits(int page, int limits, String masterId){
			 int startIndex = (page - 1) * limits;
				try {
					String sql = "SELECT * FROM pet WHERE masterid = '"+masterId+"' UNION select a.id,a.masterid,a.age,a.nickname,a.gender,a.sterilization,a.immunity,a.species,a.color,a.weight,a.adoptPetCode as petCode,a.photo AS petImg,a.state,a.inHospital FROM adoptpet AS a where a.masterid = '"+masterId+"' order by id desc limit " + startIndex + "," + limits;
					return this.commonDAO.excuteQuery(sql, null);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return null;  
		}
	 
	 public List<Map<String, Object>> selectPet(String selItem, String selContent){ 
		   try {
			   String sql = "select * FROM pet WHERE "+selItem+" like '%"+selContent+"%' order by id DESC";
				
				return this.commonDAO.excuteQuery(sql, null); 
				 
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			} 
	  }
	 

	 
	 public List<Map<String, Object>> selectPetByLimits(String selItem,String selContent,int pageSize,int currPage){ 
		 int startIndex = (currPage - 1) * pageSize; 
		 try {
			   String sql = "select * FROM pet WHERE "+selItem+" like '%"+selContent+"%' order by id DESC limit " +startIndex+","+pageSize;
				
				return this.commonDAO.excuteQuery(sql, null); 
				 
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			} 
	  }
	public List<Map<String, Object>> queryByCusId(String masterId) {

		String sql = "SELECT * FROM pet WHERE masterid = '"+masterId+"' UNION select a.id,a.masterid,a.age,a.nickname,a.gender,a.sterilization,a.immunity,a.species,a.color,a.weight,a.adoptPetCode as petCode,a.photo AS petImg,a.state,a.inHospital FROM adoptpet AS a where a.masterid = '"+masterId+"' order by id desc ";
		try {
			return commonDAO.excuteQuery(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
		}
		return null; 
	}
	public void addPet(Pet pet) {

		String sql = "insert into pet (masterid,age,nickname,gender,sterilization,immunity,species,color,weight,petCode,petImg,state,inHospital)"
						+ "values('"+pet.getMasterId()+"','"+pet.getAge()+"','"+pet.getNickname()+"','"+pet.getGender()+"'"
								+ ",'"+pet.getSterilization()+"','"+pet.getImmunity()+"','"+pet.getSpecies()+"','"+pet.getColor()+"','"+pet.getWeight()+"','"+pet.getPetCode()+"','"+pet.getPetImg()+"','����','��');";
		try {
			commonDAO.executeUpdate(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
		} 

	}
	
	public void deleteByCode(String petCode) {
		String sql = "DELETE FROM pet WHERE petCode =  "+petCode;
		try {
			commonDAO.executeUpdate(sql, null);
		} catch (Exception e) {
			new Exception("�������ݿ����").printStackTrace();
		}
	}
	
	 public void updatePet(Pet pet){ 
		  
		 try {
			   String sql = "update pet SET age = '"+pet.getAge() +"',nickname = '"+pet.getNickname()+"',sterilization = '"+pet.getSterilization()+"',immunity = '"+pet.getImmunity()+"',species = '"+pet.getSpecies()+"',color = '"+pet.getColor()+"',weight = '"+pet.getWeight()+"',petImg = '"+pet.getPetImg()+"' WHERE petCode = '"+ pet.getPetCode()+"'";
			this.commonDAO.executeUpdate(sql, null);  
			}
			catch(Exception e){
				e.printStackTrace(); 
			} 
	  }
	 
		public List<Map<String, Object>> selectPetByPetId(String petId) {
			
			try {
				String sql = "select * FROM pet WHERE petCode = '"+petId+"'";
				List<Map<String, Object>> pet = this.commonDAO.excuteQuery(sql, null);
				return pet;
			}
			catch(Exception e){
				System.out.println("�������ݿ����");
			}
			return null; 
		}
}
