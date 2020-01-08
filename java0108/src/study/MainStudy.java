package study;

import java.util.Scanner;

public class MainStudy {

	public static void main(String[] args) {
		final int 전체보기 = 1;
		final int 상세보기 = 2;
		final int 삽입하기 = 3;
		final int 수정하기 = 4;
		final int 삭제하기 = 5;
		final int 종료 = 6;
		
		// 키보드로부터 입력받기 위한 객체 생성
		Scanner sc = new Scanner(System.in);
		while(true) { //무한반복
			System.out.println("1. 전체보기 "
					+ "2. 상세보기 3. 삽입하기"
					+ " 4. 수정하기 5. 삭제하기"
					+ " 6. 종료");
			System.out.println("메뉴 입력 : ");
			int menu = sc.nextInt();
			
			// menu에 따른 분기
			switch(menu) {
			case 전체보기:
				System.out.println("전체보기 선택");
				break;
			case 상세보기:
				System.out.println("상세보기 선택");
				break;
			case 삽입하기:
				System.out.println("삽입하기 선택");
				break;
			case 수정하기:
				System.out.println("수정하기 선택");
				break;
			case 삭제하기:
				System.out.println("삭제하기 선택");
				break;
			case 종료:
				sc.close();
				System.err.println("프로그램 종료");
				System.exit(0); // 프로그램 종료
				break;
			default:
				System.out.println("----------");
				System.out.println("메뉴 재확인 요망");
				System.out.println("----------");
				break;
			}
		
		}

	}

}
