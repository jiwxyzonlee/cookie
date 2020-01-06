package java0103;

public class Loop {

	public static void main(String[] args) {
		// Hello Java 3번 출력하기
		
		// while문
		int i = 0;
		while (i<3) {
			System.out.println("Hello Java");
			i = i + 1;
		}
		/* while문은 한 번만 수행할 내요을 적고 
		/ while(조건)을  적고
		/ {} 내에 반복 수행할 내용을 적는다 */
		System.out.println("==================");
		
		/* do~while은 한번만 수행할 내용을 적고
		 * do{반복 수행할 내용}을 적고 while(조건);
		 */
		i = 0;
		do {
			System.out.println("Hello Java");
			i = i + 1;
		} while(i < 3);
		System.out.println("=================");
		
		/* for
		 * for(한 번 수행할 내용; 조건; 두 번째부터 수행할 내용)
		 * 그리고 뒤에 {반복 수행할 내용}
		 */
		for (i = 0; i < 3; i = i + 1) {
			System.out.println("Hello Java");
		}
		
		
		
	}

}
 