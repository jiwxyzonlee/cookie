package java0117;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUse {

	public static void main(String[] args) {
		// Property를 저장할 수 있는 인스턴스를 생성하고 데이터를 저장
		Properties props = new Properties();
		
		// Property 저장
		props.setProperty("name", "베르캄프");
		props.setProperty("nation", "Holland");
		
		// Property 혹은  Map(dictionary, hashtable이라고도 함)
		// Property 혹은 Map에 없는 key 값을 주었을 때 동작방식
		String name = props.getProperty("name");
		
		// Java는 부재 key를 사용하면 null
		String age = props.getProperty("age");
		
		System.out.println(name);
		System.out.println(age);
		
		// props를 현재 디렉토리에서 temp.xml 파일로 내보내기
		System.out.println("== props를 현재 디렉토리에서 ./temp.xml 파일로 내보내기 ==");
		// 예외처리
		try {
			props.storeToXML(new FileOutputStream("temp.xml"), "주석");
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.getMessage());
		}

	}

}
