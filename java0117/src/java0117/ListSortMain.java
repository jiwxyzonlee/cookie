package java0117;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSortMain {

	public static void main(String[] args) {
		// 문자열 List를 생성하고 데이터를 저정
		List<String> list = new ArrayList<String>();
		list.add("야구");
		list.add("농구");
		list.add("축구");
		list.add("배구");
		
		// 데이터 정렬
		// Comparator를 매개변수로 요구
		// Comparator를 implements한 클래스를 생성해야 함
		// New class ([Add] interface comparator)
		// StringComp.java
		// Comparator Interface를 implements한 클래스의 인스턴스를 만들어서 정렬
		StringComp comp = new StringComp();
		list.sort(comp);
		// StringComp의 default가 오름차순 => return o1.compareTo(o2);
		// 농구	배구	야구	축구
		
		
		// Comparator의 Anonymous Class 만들기
		// 클래스 없이 Comparator 인터페이스를 구현한 클래스의 인스턴스 바로 만들기
		// 이 문법의 확장인 lambda가 Java의 함수형 프로그래밍을 지원
		
		//Comparator c = new Comparator(); //Error
		// Comparator가 인터페이스라서 에러남
		// 올바른 작성방법
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
				// 내림차순 축구	야구	배구	농구
			}
			
		};
		list.sort(c);
		
		// 데이터 출력
		for (String temp : list) {
			System.out.print(temp + "\t");
		}

	}

}
