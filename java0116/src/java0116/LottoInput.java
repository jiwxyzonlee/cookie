package java0116;

import java.util.Scanner;
import java.util.TreeSet;

public class LottoInput {

	public static void main(String[] args) {
		// 1-45까지의 정수를 저장할 자료구조 생성
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		// 키보드로부터 입력받기 위한 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		
		while (lotto.size() < 6) {
			
			// java.util.InputMismatchException 방지
			 try {
				System.out.print("1-45까지의 중복되지 않는 숫자 : ");
				int su = sc.nextInt();
				//System.out.println();
			
				// 1부터 45사이의 숫자인지 검사
				if (su < 1 || su > 45) {
					System.out.println("1-45 사이의 숫자만 입력하십시오");
					//System.out.println();
					continue;
				}
			
			
				// 입력받은 숫자를 Set에 추가
				// 숫자가 중복되면 false
				boolean result = lotto.add(su);
				if (result == false) {
					System.out.println("중복된 숫자는 안 됩니다");
				}

			}
			catch(Exception e) {
				System.out.println("슷자만 입력하십시오");
				sc.nextLine();
			}

		}
		
		// 중괄호 위치 유의하기
		// lotto 데이터 출력
		for (Integer su : lotto) {
			System.out.print(su + "\t");
		}
		sc.close();
	}

}
