package java0117;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		// seed 설정 없이 랜덤 인스턴스 생성
		// seed 가 현재 시간을 설정
		Random r1 = new Random();
		// seed를 1번으로 설정
		Random r2 = new Random(1);
		
		// 실행할 때마다 다르게 나옴
		int result1 = r1.nextInt();
		// 실행할 때마다 동일하게 나옴
		int result2 = r2.nextInt();
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		
		System.out.println();
		
		// 빨강, 파랑, 녹색을 랜덤하게 클릭
		System.out.println("== 빨강, 파랑, 녹색 랜덤 출력 ==");
		String [] colors = {"빨강", "파랑", "녹색"};
		
		// 빨강 나오게 할 가능성 높이려면 빨강 입력 개수 늘리면 됨
		// String [] colors = {"빨강", "파랑", "녹색", "빨강"};
		
		// 반복문 넣어 확인해보기
		for (int i = 0; i < 10; i++) {
			// 배열에서 배열 안의 인덱스가 랜덤하게 나오도록
			// r1.nextInt(colors.length) 배열의 인덱스에 적용
			String color = colors[r1.nextInt(colors.length)];
			// length 내에서만(0,1,2) 숫자 나오도록 제한 설정
			// r1.nextInt()만 할 시 숫자가 너무 커질 수 있음
			// String color = colors[r1.nextInt(4) % 3]; // 빨강 2개일 때 사용
			System.out.println("color : " + color);
			
		}
		System.out.println();
		
		// 비복원 추출
		// 훈련데이터와 테스트 데이터 샘플링, 로또, 고스톱, 포커 게임
		System.out.println("===== 비복원추출 =====");
		
		List<String> list = new ArrayList<String>();
		
		// 1-45까지 저장
		for (int i = 1; i <= 45; i++) {
			list.add(i + "");
		}
		
		/*
		// 20개의 숫자를 비복원 추출
		for (int i = 0; i <20; i++) {
			String x = list.get(r1.nextInt(list.size()));
			// 그 데이터 제거
			list.remove(x);
			System.out.print(x + "\t");
		}
		*/
		System.out.println();
		
		// 로또는 for문 바깥에 하나 더 만들고 5줄 생성, 6개 출력
		// 제대로 실행하려면 위에 주석 처리하고 다시 비복원 추출해야 함
		// 그래야 아랫줄도 동일하게 숫자 45개에서 6개 다시 나와야 하기 때문에 중복값 존재
		// 입력값 1000원은 1줄 ~ 5000원은 5줄 연습해도 좋을 듯함
		System.out.println("==== 로또 자동 시도 : 완전한 로또는 아님 ====");
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 6; i++) {
				// list 사이즈 내의 숫자 (0-44까지) 데이터 추출
				String x = list.get(r1.nextInt(list.size()));
				// 그 데이터 제거
				list.remove(x);
				System.out.print(x + "\t");
			}
			System.out.println();
		}

	}

}
