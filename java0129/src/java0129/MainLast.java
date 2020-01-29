package java0129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MainLast {

	public static void main(String[] args) {
		String [] ar = {"Python", "Java", "Closure", "Scala"
				, "Kotlin", "Swifht", "C#", "C&C++", "JavaScript"};
		Stream<String> arStream = Arrays.stream(ar);
		// 배열의 모든 데이터가 3글자 이상인지 확인
		// C# 때문에 false
		// anyMatch는 true (any는 하나라도 만족하면 true)
		// noneMatch는 false (하나라도 만족하는 게 없으면 true)
		boolean r = 
				arStream.allMatch(
						(language) -> {
							return language.length() > 3;
							}
						);
		System.out.println("배열의 모든 데이터가 3글자 이상인지 확인 : " + r);
		System.out.println("=================================");
		
		// 집계함수를 사용
		// 샘플 데이터 작성
		Student student1 = new Student(1, "김가나", "남", 28, 93);
		Student student2 = new Student(2, "유다라", "여", 19, 89);
		Student student3 = new Student(3, "김마바", "남", 38, 95);
		Student student4 = new Student(4, "안사아", "남", 29, 100);
		Student student5 = new Student(5, "남자차", "여", 25, 97);
				
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		
		Stream<Student> stream = list.stream();
		// 정수의 합계 구하기
		int tot = stream.mapToInt(Student::getScore).sum();
		System.out.println("score 합계 : " + tot);
		
		System.out.println();
		
		// 남자 나이 합계
		stream = list.stream();
		tot = 
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("남");
							}
						).mapToInt(Student::getAge).sum();
		System.out.println("남자 나이 합계 : " + tot);
		System.out.println();
		
		// 데이터 개수
		stream = list.stream();
		long cnt = 
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("여");
							}
						).count();
		System.out.println("데이터 개수 : " + cnt);
		System.out.println();
		
		// gender가 '여'인 데이터의 score 평균
		stream = list.stream();
		// Optional은 기존 자료형의 데이터를 wrapping 한 자료형
		OptionalDouble avg = 
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("여");
							}
						).mapToInt(Student::getScore).average();
		// orElse에서 기본값을 설정하면 결과가 null일 때 기본값을 리턴
		System.out.println("여자 score 평균 : " + avg.orElse(0));
		System.out.println();
		
		// max나 min은 Comparator.comparing 자료형(비교형 데이터의 메소드) 를 대입하면
		// Optional<제너릭>으로 결과를 리턴
		// Score의 최댓값
		stream = list.stream();
		Optional<Student> result = 
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("남");
							}
						).max(Comparator.comparingInt(Student::getScore));
		System.out.println("남자 최저 점수 : " + result.get());
		

	}

}
