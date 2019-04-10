package util;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Common {
	public static String getRandomCard() {
		Random rand = new Random();// ���������
		String cardNnumer = "";
		for (int a = 0; a < 6; a++) {
			cardNnumer += rand.nextInt(10);// ����6λ����
		}
		return cardNnumer;
	}
	public String getNow(){ 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
         return  df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ�� 
	}
	
	public List<Map<String, Object>> toBase64(List<Map<String, Object>> listMaps,String param) {
		for (Map<String, Object> map : listMaps) {
			String imgHeader = "data:image/png;base64,";
			String s = imgHeader + getImageStr(map.get(param).toString());
			map.put(param, s); 
		}
		return listMaps;
	}
	public Map<String, Object> toBase64(Map<String, Object> listMaps,String param) { 
	 
			String imgHeader = "data:image/png;base64,";
			String s = imgHeader + getImageStr(listMaps.get(param).toString());
			listMaps.put(param, s); 
	 
		return listMaps;
	}
	/**
	 * ȥ��base64ԭ���Ķ���
	 * @param imgStr
	 * @return
	 */
	public String processImgStr(String imgStr){
		int headIndex = imgStr.indexOf(',') + 1;
		return imgStr.substring(headIndex);
	}
	/**
	 * @Description: ��base64�����ַ���ת��ΪͼƬ
	 * @Author: 
	 * @CreateTime: 
	 * @param imgStr base64�����ַ���
	 * @param path ͼƬ·��-���嵽�ļ�
	 * @return
	 */
	
	public boolean  generatorImage(String imgStr,String filePath){
		if(imgStr==null){
			return false;
		}
		else {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				//���ܹ���
				byte[] imgByte = decoder.decodeBuffer(imgStr);
				//��������
				for(int i = 0; i < imgByte.length; i ++){
					if(imgByte[i] < 0){
						imgByte[i] += 256;
					}
				}
				OutputStream out = new FileOutputStream(filePath);
				out.write(imgByte);
				out.flush();
				out.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	
	/**
	 * @Description: ����ͼƬ��ַת��Ϊbase64�����ַ���
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public String getImageStr(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // ����
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
} 