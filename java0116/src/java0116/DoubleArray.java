package java0116;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoubleArray {

	public static void main(String[] args) {
		System.out.println("====== List의 List ======");
		// 각 팀별 선수명단
		ArrayList<String> kia = new ArrayList<String>();
		kia.add("최형우");
		kia.add("김주찬");
		kia.add("김선빈");
		
		ArrayList<String> dusan = new ArrayList<String>();
		dusan.add("권 혁");
		dusan.add("정수빈");
		dusan.add("최주환");
		
		ArrayList<String> hanhwa = new ArrayList<String>();
		hanhwa.add("김태균");
		hanhwa.add("이성열");
		
		// 팀별 명단을 다시 List로 만들기 (List의 List)
		ArrayList<ArrayList<String>> players = 
				new ArrayList<ArrayList<String>>();
		players.add(kia);
		players.add(dusan);
		// 팀이 추가되는 경우 팀이름을 출력하기 위해 출력로직을 수정해야 함
		players.add(hanhwa);
		
		// 데이터 출력하기
		// 전체의 리스트를 하나 하나의 리스트로 imsi에 대입
		for (int i = 0; i < players.size(); i++) {
			if(i == 0) {
				System.out.print("기아 : ");
			}else {
				System.out.print("두산 : ");
			}
			
			ArrayList<String> imsi = players.get(i);
			// imsi의 데이터를 하나씩 temp에 대입
			for(String temp : imsi) {
				System.out.printf(temp + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("======= Map의 List =======");
		// 위 식의 문제는 List의 List를 만들 때 각 List의 특징을 같이 저장하지 못하는 것
		// 팀 이름은 문자열, 팀의 선수 명단은 배열
		// 같이 List에 저장 못함  => Map은 해결 가능!
		
		// List와 팀 이름을 갖는 Map 생성
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("team", "기아");
		map1.put("player", kia);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("team", "두산");
		map2.put("player", dusan);
		
		// 출력부분 손 안대도 추가 가능
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("team", "한화");
		map3.put("player", hanhwa);
		
		// Map의 List를 생성
		ArrayList<Map<String, Object>> kbo = 
				new ArrayList<Map<String, Object>>();
		kbo.add(map1);
		kbo.add(map2);
		kbo.add(map3);
		
		// 출력
		for(Map<String, Object> map : kbo) {
			System.out.print(map.get("team") + " : ");
			ArrayList<String> p = (ArrayList<String>)map.get("player");
			// 원래의 자료로 형 변환 필요
			
			for (String temp : p) {
				System.out.print(temp + "\t");
			}
			System.out.println();
		}

	}

}
