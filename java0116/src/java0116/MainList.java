package java0116;

import java.util.ArrayList;
import java.util.Comparator;

public class MainList {

	public static void main(String[] args) {
		// 어제의 방식(200115)
		// 매개변수가 없는 생성자를 이용한 인스턴스 생성 및 필드값
		Player player1 = new Player();
		player1.setNum(1);
		player1.setName("백인천");
		player1.setHitrate(0.412);
		
		// 매개변수가 있는 생성자를 이용한 인스턴스 생성 및 필드값 설정
		Player player2 = new Player(2, "이종범", 0.393);
		Player player3 = new Player(3, "장효조", 0.387);
		Player player4 = new Player(4, "테임즈", 0.381);
		Player player5 = new Player(5, "최형우", 0.376);
		
		// 5개의 인스턴스를 소유한 ArrayList 인스턴스 생성
		ArrayList<Player> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		list.add(player4);
		list.add(player5);
		
		// Player 클래스의 인스턴스 비교 인스턴스
		// : 타율 오름차순
		Comparator <Player> comparator = new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				// return arg0.getHitrate() - arg1.getHitrate();
				if(arg0.getHitrate() > arg1.getHitrate()) {
					return 1;
				}else if (arg0.getHitrate() == arg1.getHitrate()) {
					return 0;
				}else {
					return -1;
				}
			}
			
		};
		
		/*
		// 이름 오름차순
		Comparator <Player> comparator = new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				// return arg0.getHitrate() - arg1.getHitrate();
				return arg0.getName().compareTo(arg1.getName()); // 내림차순 * -l;
						
			}
			
		};
		*/
		
		// 데이터 정렬
		list.sort(comparator);
		
		// 데이터 출력
		for (Player player : list) {
			System.out.println(player);
		}

	}

}
