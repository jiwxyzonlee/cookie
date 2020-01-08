package study;

// 게시판 작업을 위판 메소드
public class BoardService {
	/* Board 100개를 저장할 수 있는 
	 * 공간을 100개 생성해서 이름을 list라고 붙임 */
	Board [] list = new Board[100];
	// 0 ~ 99
	
	// 전체 목록이나 일부 목록을 return하는 메소드
	// return type은 배열이나 list
	/* 일부 목록을 가져올 때는 매개변수로
	 * 페이지 번호를 갖는 경우가 많음*/
	public Board[] getList() {
		return list;
	}
	
	// 페이지 번호에 해당하는 데이터를 가져오는 메소드
	public Board[] getList(int pageNo) {
		Board [] r = new Board[10];
		// 한 페이지에 10개씩 있다고 가정
		// pageNo가 1일 때 0~9, 2일 때 10~19
		int start = (pageNo - 1) * 10;
		int end = pageNo * 10 - 1;
		// start와 end의 차이는 9
		
		for (int i = 0; i < 10; i = i + 1) {
			r[i] = list[start + i];
		}
		
		return r;
	}
	
	// 글번호에 해당하는 데이터를 1개 가져오는 메소드
	// 기본키를 매개변수로 받아 처리
	// (상세보기를 처리하는 메소드)
	public Board getBoard(int num) {
		// list에서 글번호(num)를 가진 데이터를 찾아서 return
		Board board = null;
		
		/* list를 순회하면서 
		 * num과 같은 글번호를 가진 데이터를 board에 대입 */
		for (Board temp : list) {
			if (temp != null) {
				/* 동일한 글번호를 찾으면 
				 * 더 이상 반복문을 수행할 필요가 없어서
				 * break */
				if (temp.getNum() == num) {
					board = temp;
					break;
				}
			}
		}
		// 동일한 글번호가 없을 시 null return
		// id 중복검사할 때 이용할 수 있는 방법
		return board;
	}
	
	// 글쓰기를 처리하는 메소드
	// 데이터 삽입을 처리하는 메소드
	/* 수행 결과를 알려주고자 할 때는
	 * boolean 이나 int로 return*/
	/* 수행 결과를 알려주지 않고자 할 때는 
	 * void(실패는 없다라는 가정)*/
	// 매개변수는 데이터 1개
	
	/* 현재 작성된 글의 개수를 저장하는 변수 생성
	 * (List 사용하게 되면 필요 없음) */
	private int cnt;
	public boolean insertBoard(Board board) {
		// 맨 마지막 위치에 데이터를 대입
		list[cnt] = board;
		cnt = cnt + 1;
		return true;
	}
	
	// 글 수정을 처리하는 메소드
	// return type은 삽입과 동일
	// 매개변수도 삽입과 동일
	/* 수정시 기본키(글번호)의 값이 
	 * 자동으로 설정되는 것 외에는 차이 거의 없음 */
	public boolean updateBoard(Board board) {
		/* 글번호에 해당하는 데이터를 찾아서 
		 * 데이터 찾았을 때 board로 대체 */
		for (int i = 0; i < cnt; i = i + 1) {
			Board imsi = list[i];
			// 글번호 비교
			if (imsi != null) {
				if (imsi.getNum() == board.getNum()) {
					list[i] = board;
					break;
				}
			}
		}
		return true;
	}
	
	// 삭제를 처리하는 메소드
	/* 삭제 시 데이터 전체가 필요하지 않고 
	 * 일반적으로 기본키만 필요 */
	public boolean deleteBoard(int num) {
		/* list의 모든 데이터를 순회하여 
		 * 글번호가 num인 데이터를 찾아서 그 위치에 null 대입 */
		for(int i = 0; i < cnt; i = i + 1) {
			Board imsi = list[i];
			// 글번호 비교
			if (imsi != null) {
				if (imsi.getNum() == num) {
					list[i] = null;
					break;
				}
			}
		}
		return true;
	}

}
