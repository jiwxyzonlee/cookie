package consumer;

import java.util.ArrayList;
import java.util.List;

// 공유자원을 소유한 클래스
public class Product {
	// 공유자원 변수
	private List<Character> list;
	
	// 생성자 - list를 초기화
	public Product() {
		list = new ArrayList<Character>();
	}
	
	// 데이터 1개를 받아서 저장하는 메소드
	// Synchronized가 붙지 않으면 jvm이 모니터링을 하지 않기 때문에 신호를 보낼 수 없음
	public synchronized void put(Character ch) {
		// 2개가 넘으면 대기
		if (list.size() > 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		list.add(ch);
		// 데이터를 추가하고 신호를 보냄
		notify();
		System.out.println(ch + "가 입고 되었습니다.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println("입고 후 현재 수량 : " + list.size());
		
	}
	
	// 데이터 1개를 꺼내서 출력하는 메소드
	public synchronized void get() {
		// list 에 데이터가 없으면 대기
		if (list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 첫번째 데이터를 삭제하고 리턴
		Character ch = list.remove(0);
		System.out.println(ch + "가 출고되었습니다");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println("출고 후 현재 수량 : " + list.size());
	}

}
