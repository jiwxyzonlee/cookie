package java0116;

import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		// Map 인스턴스 생성
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		// 데이터 저장
		map.put("baseball", "야구");
		map.put("football", "축구");
		map.put("volleyball", "배구");
		
		// 데이터 가져오기
		// 출력만 할 때는 강제 형 변환이 필요 없지만
		// 다른 용도로 사용할 때에는 강제 형 변환 필요
		String obj = (String)map.get("football");
		System.out.println(obj.toUpperCase());
		
		// 없는 key 값 가져오기 (언어마다 다르므로 주의)
		Object value = map.get("basketball");
		System.out.println(value);
		// Java는 null이 나오고 Python은 튕김
		
		map.put("football", "발로 하는 축구");
		obj = (String)map.get("football");
		System.out.println(obj.toUpperCase());
		// 발로 하는 축구 로 수정된 value가 출력
		
		// Map의 모든 데이터를 출력 - key의 이름을 사용하지 않음
		System.out.println();
		System.out.println("===Map의 모든 데이터 출력===");
		
		// 모든 key 값 가져오기
		Set<String> keys = map.keySet();
		// Set 순회
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}

	}

}
