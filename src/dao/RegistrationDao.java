package dao;

import java.util.List;
import java.util.Map;

import util.CommonDAO;

public class RegistrationDao {
	CommonDAO commonDAO = new CommonDAO();
	public List<Map<String, Object>> findRegistrationByDoctorId(String doctorId) {
		try {
			String sql = "select * from  registration where state='������' and doctorId = '"+ doctorId +"'order by date DESC";
			List<Map<String, Object>> registrations = this.commonDAO.excuteQuery(sql, null);
			return registrations;
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null;
	}
	public List<Map<String, Object>> findRegistrationDealed(String doctorId) {
		try {
			String sql = "select * from  registration where state='�Ѵ���' and doctorId = '"+ doctorId +"' order by date DESC";
			List<Map<String, Object>> registrations = this.commonDAO.excuteQuery(sql, null);
			return registrations;
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null;
	}
	public List<Map<String, Object>> findRegistrationByCode(String registrationCode) {
		
		try {
			String sql = "SELECT doctor.*,customer.*,registration.*,pet.* FROM doctor ,customer ,registration ,pet where registration.doctorId = doctor.doctorCode AND registration.customerId = customer.customerCode AND registration.petId = pet.petCode AND registrationCode='"+registrationCode+"'";
			List<Map<String, Object>> registrations = this.commonDAO.excuteQuery(sql, null);
			return registrations;
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null;
	}
	public void updateState(String registrationCode){
		try {
			String sql = "update registration SET state='�Ѵ���' WHERE registrationCode='"+registrationCode+"'";
			this.commonDAO.executeUpdate(sql, null);
			
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		
	} 
	public List<Map<String, Object>> selectRegistration(String selItem,String doctorId, String selContent) {
		
		try {
			String sql = "select * FROM registration WHERE state = '������' AND doctorId='"+doctorId+"' AND "+selItem+" like '%"+selContent+"%' order by date DESC";
			List<Map<String, Object>> registrations = this.commonDAO.excuteQuery(sql, null);
			return registrations;
		}
		catch(Exception e){
			System.out.println("�������ݿ����");
		}
		return null; 
	}
 
}
