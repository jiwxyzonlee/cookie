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
		
		// 게시판 작업을 수행할 인스턴스 생성
		BoardService boardService = new BoardService();
		
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
				// BoardService 클래스의 getList 메소드가 처리 가능
				// BoardService Constructor(C)
				// static이 아닌 메소드 사용을 위해 인스턴스 생성
				// 클래스이름 인스턴스이름 = new 생성자이름();
				// BoardService boardService = new BoardService();
				// (다른 메뉴에서도 사용하기 때문에 코드를 밖으로 내보냄)
				Board [] boards = boardService.getList();
				// 배열의 데이터 출력  (board 쪼개기)
				for (Board board : boards) {
					if(board != null) {
						System.out.println(board);
					} // 아직까진 번호 눌러도 값 안 나옴
				}
				System.out.println("전체보기 선택");
				break;
			case 상세보기:
				// System.out.println("상세보기 선택");
				// 글번호를 입력받아서 상세보기 메소드 호출
				/* 상세보기는 글번호에 해당하는 데이터가 
				 * 있으면 데이터가 return되고 없으면 null return */
				
				//글번호 입력
				System.out.print("상세보기 할 글 번호 : ");
				int num = sc.nextInt();
				
				Board board1 = boardService.getBoard(num);
				if (board1 == null) {
					System.out.println("해당되는 데이터가 없습니다");
					continue;
				}else {
					System.out.println(board1);
				}
				
				break;
			case 삽입하기:
				// 삽입하기는 BoardService 클래스의 insertBoard가 처리
				// 인스턴스 메소드이며 매개변수는 Board,
				// return type은 boolean
				// BoardService boardService = new BoardService();
				// (다른 메뉴에서도 사용하기 때문에 코드를 밖으로 내보냄)
				Board board = new Board();
				
				System.out.print("제목 입력 : ");
				// 이전에 정수 입력을 받고 엔터가 남아있어서 이 라인이 엔터를 입력받고 넘어감
				sc.nextLine();
				String temp = sc.nextLine();
				board.setTitle(temp);
				
				System.out.print("내용 입력: ");
				temp = sc.nextLine();
				board.setContent(temp);
				
				boolean r = boardService.insertBoard(board);
				
				System.out.println("삽입하기 선택");
				break;
			case 수정하기:
				// 수정할 글번호 입력받기
				System.out.print("수정할 글번호 : ");
				int n = sc.nextInt();
				// 글번호가 n인 데이터 찾기
				Board b = boardService.getBoard(n);
				if ( b == null) {
					System.out.println("해당되는 데이터가 없습니다");
					continue;
				}else {
					System.out.print("수정할 제목 : ");
					sc.nextLine();
					b.setTitle(sc.nextLine());
					System.out.print("수정할 내용 : ");
					b.setContent(sc.nextLine());
					
					// 입력받은 내용으로 데이터 수정하기
					boardService.updateBoard(b);
				}
				break;
			case 삭제하기:
				// 삭제할 글번호 입력
				// 해당하는 데이터가 있는지 확인하고
				// 정말로 삭제할 것인지 재차 확인 후 삭제
				
				System.out.print("삭제할 글번호: ");
				int x = sc.nextInt();
				
				Board y = boardService.getBoard(x);
				if (y == null) {
					System.out.println("해당되는 글이 없습니다");
					continue;
				}else {
					System.out.print("정말로 삭제하시겠습니까? 1(삭제)");
					int del = sc.nextInt();
					if (del == 1) {
						boardService.deleteBoard(x);
					}
				}
				
				break;
			case 종료:
				sc.close();
				System.err.println("[Good Bye]");
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
