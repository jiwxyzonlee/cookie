package java0106;

public class DoubleArray {

	public static void main(String[] args) {
		// 초기 데이터를 가지고 이차원 배열 생성
		String [][] players = {{"이종범", "윤석민", "안치홍"}, 
				{"박병호", "김하성", "이정후"}};
		
		// 인덱스를 이용하여 배열의 모든 데이터 접근
		// 행의 개수 가져오기
		int rowCnt = players.length;
		for (int i = 0; i < rowCnt; i = i + 1) {
			// 각 행별 열의 개수 가져오기
			int colCnt = players[i].length;
			for (int j = 0; j < colCnt; j = j + 1) {
				System.out.print(players[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("====================");
		
		// 빠른 열거를 이용한 접근
		// 이차원 배열을 일차원 배열로 접근
		for(String [] row : players ) {
			// 일차원 배열 내의 데이터를 열 단위로 접근
			for(String col : row) {
				System.out.print(col + "\t");
			}
			System.out.print("\n");
		}
		
		// 이차원 배열 중에서 모든 행의 열 개수가 동일하다면
		// 하나의 반복문으로 모든 데이터에 접근 가능
		// players 배열처럼 모든 행의 열 개수가 3개로 동일하다면
		// 하나의 반복문으로 접근 가능
		
		// 전체 데이터 개수를 구한 후 열의 개수를 이용하면
		// 전체 데이터 개수
		int tot = players.length * players[0].length;
		// 하나의 행에 해당하는 열의 개수
		int colCnt = players[0].length;
		// 하나의 반복문으로 전체 데이터 접근
		for (int i = 0; i < tot; i = i + 1) {
			System.out.print(players[i/colCnt][i%colCnt] + "\t");
			if (i % colCnt == colCnt - 1) {
				System.out.print("\n");
			}
		}

	}

} 
