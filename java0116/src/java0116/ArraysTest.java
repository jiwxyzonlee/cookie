package java0116;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysTest {

	public static void main(String[] args) {
		// int -> Integer와 String은 크기 비교 가능
		// 바로 정렬 가능
		// Comparable interface 가 구현되어 있는지 확인
		
		// 정수 배열 생성
		int [] ar = {30, 40, 20, 50, 10};
		
		// 문자열 배열 생성
		String [] br = {"엘사", "안나", "올라프", "크리스토퍼", "스벤"};
		
		// ar 배열을 정렬
		Arrays.sort(ar);
		for(int temp : ar) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		
		// br 배열을 정렬
		Arrays.sort(br);
		for(String temp : br) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		
		// User 클래스의 배열 생성
		User user1 = new User();
		user1.setNum(1);
		user1.setName("조 몬타나");
		user1.setScore(88);
		
		User user2 = new User();
		user2.setNum(2);
		user2.setName("마르티나 나브라틸로바");
		user2.setScore(97);
		
		User user3 = new User();
		user3.setNum(3);
		user3.setName("웨인 그레츠키");
		user3.setScore(87);
		
		User [] users = {user1, user2, user3};
		
		/*
		 // 배열을 만들고 인스턴스를 대입
		User [] users = new Users[3];
		users[0] = new User();
		users[0].setNumber(1);
		 */
		
		/*
		// 데이터 정렬
		Arrays.sort(users);
		*/
		
		/*
		Comparator <User> comp = new Comparator<User>() {

			@Override
			public int compare(User arg0, User arg1) {
				if(arg0.getScore( )> arg1.getScore()) {
					return 1;
				}else if(arg0.getScore() == arg1.getScore()){
					return 0;
				}else {
					return -1;
				}
			}
		};
		*/
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정렬 조건 선택(1.번호  2.이름  3.점수) : ");
		String menu = sc.nextLine();
		
		
		// 자바는 지역변수를 만들면 자동 초기화를 하지 않음
		// 만들기만 하고 값을 대입해두지 않으면 없는 것으로 간주함
		Comparator<User> comp = null;
		switch(menu) {
		case "1":
			comp = new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					if(o1.getNum() > o2.getNum()) {
						return 1;
					}else if(o1.getNum() == o2.getNum()){
						return 0;
					}else {
						return 1;
					}
				}
				
			};
			break;
			
		case "2":
			comp = new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			};
			break;
		
		case "3":
			comp = new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					return o1.getScore() - o2.getScore();
				}
				
			};
			break;
			
		default :
			System.out.println("잘못된 메뉴를 선택하셨습니다.");
			//프로그램 종료
			System.exit(0);
		}
		
		Arrays.sort(users, comp);
		
		// 데이터 출력
		for(User user : users) {
			System.out.println(user);
		}
		// 문법상 에러 표시는 안 나나 출력에서 에러 발생
		// ClassCastException
		// : Comparable 으로 타입변환이 안 됨

	}

}
