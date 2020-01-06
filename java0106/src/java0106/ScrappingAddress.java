package java0106;

public class ScrappingAddress {

	public static void main(String[] args) {
		// 첫번째 페이지 URL
		// http://www.donga.com/news/search?p=1&query=자바
		
		// 각 페이지마다 기사가 15개씩 존재, p의 값은 15씩 증가
		// 총 데이터 건수 1164개
		int total = 1164;
		
		// 페이지 개수 만들 때는 나누어 떨어지지 않으면 몫 + 1
		int pagesu = 1164/15;
		if(total % 15 != 0) {
			pagesu = pagesu + 1;
		}
		System.out.println(pagesu);

		for(int i = 0; i < pagesu; i = i + 1) {
			// 페이지 별 기사의 시작 번호
			int p = 15 * i + 1;
			// 기사의 url만들기
			System.out.println("http://www.donga.com/news/search?p="
			+ p + "&query=자바");
		}
		
	}

}
 