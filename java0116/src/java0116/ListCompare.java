package java0116;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListCompare {

	public static void main(String[] args) {
		// 정수 데이터를 저장하는 ArrayList 생성
		// 제너릭에서는 기본형을 사용할 수 없음
		// -> 기본형을 대체하는 Wrapper클래스 사용
		ArrayList<Integer> al = new ArrayList<>();
		
		// 데이터삽입
		al.add(10);
		al.add(30);
		
		// 데이터 1개 가져오기
		Integer e = al.get(0);
		System.out.println(e);
		
		// 데이터 1개 삭제
		al.remove(0);
		
		// 데이터 전체 출력
		for (Integer imsi : al) {
			System.out.println(imsi);
		}
		
		// 현재 시간 저장
		long start = System.currentTimeMillis();
		
		// 20이라는 데이터를 10만번만 2번째 칸에 삽입
		// 크기 늘어날수록 느리고 값 차이도 커짐 (100만)
		for(int i = 0; i < 100000; i = i + 1) {
			al.add(1, 20);
		}
		
		// 현재 시간 저장
		long end = System.currentTimeMillis();
		System.out.println("al : " + (end - start));
		
		
		// LinkedList 생성
		LinkedList<Integer> li = new LinkedList<>();
		
		// 데이터삽입
		li.add(10);
		li.add(30);
		
		// 현재 시간 저장
		start = System.currentTimeMillis();
				
		// 20이라는 데이터를 10만번만 2번째 칸에 삽입
		for(int i = 0; i < 100000; i = i + 1) {
			li.add(1, 20);
		}
				
		// 현재 시간 저장
		end = System.currentTimeMillis();
		System.out.println("li : " + (end - start));
		
		// ArrayList
		// 현재 시간 저장
		start = System.currentTimeMillis();
						
		// 모든 데이터 읽어서 출력
		for(int i = 0; i < al.size(); i = i + 1) {
			System.out.println(al.get(i));
		}
					
		// 현재 시간 저장
		end = System.currentTimeMillis();
		System.out.println("al : " + (end - start));
		
		
		// LinkedList
		// 현재 시간 저장
		start = System.currentTimeMillis();
						
		// 모든 데이터 읽어서 출력
		for(int i = 0; i < li.size(); i = i + 1) {
			System.out.println(li.get(i));
		}
						
		// 현재 시간 저장
		end = System.currentTimeMillis();
		System.out.println("li : " + (end - start));

	}

}
