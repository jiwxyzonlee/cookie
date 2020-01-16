package java0116;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassAndMap {

	public static void main(String[] args) {
		// 번호, 이름, 타율을 저장하는 Play클래스의 인스턴스를 만들어서 저장
		Player player = new Player(1, "이종범", 0.393);
		
		// 3개를 저장하는  Map 인스턴스 생성해서 데이터 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", 2);
		map.put("name", "장효조");
		map.put("hitrate", 0.387);
		
		// 대부분의 IDE에서 일반 인스턴스를 사용할 때 Code Sense가 동작
		String name = player.getName(); // 자동생성, 오타 방지
		// 하나의 속성을 가져올 때는 클래스가 유용
		
		// map은 변수가 아닌 문자열은 자동생성 안 됨, 형 변환도 해야 함
		// map은 key를 기억해야 함
		name = (String)map.get("name"); 
		
		// 전체를 출력할 때나 속성을 확장할 때는 Map이 유리!!
		// DTO 클래스의 인스턴스는 속성 확장이 안됨
		// DTO 클래스의 인스턴스는 속성을 확장하려면 클래스 구조를 변경해야 함
		// -> Table 가서 확장
		// map은 제한 없음
		map.put("homerun", 31);
		
		// DTO 클래스의 인스턴스는 각각의 데이터를 하나씩 출력해야 한다면
		// 메소드를 일일이 호출, 반복문 사용 불가
		System.out.println(player.getNum());
		System.out.println(player.getName());
		System.out.println(player.getHitrate());
		
		// 그러나 Map의 인스턴스는 keySet()을 이용해서 반복문으로 출력 가능
		// 모든 Map은 아래 구문으로 전체 데이터 출력 가능
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}

	}

}
