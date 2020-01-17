package java0117;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Cherries {

	public static void main(String[] args) {
		String [] image = {"!", "@", "#", "$", "%", "^"};
		// Random 생성
		Random r = new Random();
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 3; i++) {
			String temp = image[r.nextInt(image.length)];
			System.out.print(temp);
			list.add(temp);
		}
		System.out.println();
		
		if(list.get(0) == list.get(1) && list.get(1) == list.get(2)) {
			System.out.println("3개가 모두 일치");
		} else if (list.get(0) == list.get(1)) {
			System.out.println("앞의 2개가 일치");
		} else {
			System.out.println("꽝");
		}
		
		// 랜덤한 문자열 만들기
		// 이미지 파일 등을 업로드 했을 때 파일이름과 유저를 구분
		// 등의 용도로 이용됨
		String name = UUID.randomUUID().toString();
		System.out.println(name); // 32자리 랜덤 문자열 출력됨
		

	}

}
