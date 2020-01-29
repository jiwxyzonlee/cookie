package java0129;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainGroup {

	public static void main(String[] args) {
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
		
		// List를 Stream으로 변환
		Stream<Student> stream = list.stream();
		
		// Stream으로 그룹화
		//stream.collect(Collectors.groupingBy(Student::getGender));
		// 리턴 타입은 기본적으로 Map
		Map<String, List<Student>> map =
				stream.collect(
						Collectors.groupingBy(
								Student::getGender));
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();
		
		// 스트림은 한 번 소모하면 소멸됨
		// 새로운 작업을 수행할 때마다 스트림 다시 생성
		stream = list.stream();
		// gender별로 그룹화한 후 score의 평균을 구함
		Map<String, Double> result = 
				stream.collect(
						Collectors.groupingBy(Student::getGender
								, Collectors.averagingDouble(Student::getScore)));
		for (String key : keys) {
			System.out.println(key + " : " + result.get(key));
		}
		System.out.println();
		
		stream = list.stream();
		// 그륩화는 존재하는 메소드를 이용해도 되지만 람다로 직접 만들어도 됨
		// 하나의 매개변수 (스트림의 제너릭)를 받아서 데이터를 리턴하는 람다식이면 됨
		Map<String, Integer> result1 = 
				stream.collect(
						// Collectors.groupingBy(Student::getName
						Collectors.groupingBy(
								(student) -> {return student.getName();} // 이름별
								, Collectors.summingInt(Student::getScore))); //score 합계
		keys = result1.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + result1.get(key));
		}
		System.out.println();
		
		stream = list.stream();
		// 성별별로 최댓값을 가진 데이터 추출
		Map<String, Optional<Student>> result2 = 
				stream.collect(
						// Collectors.groupingBy(Student::getName
						Collectors.groupingBy(
								Student::getGender, Collectors.maxBy(
										Comparator.comparingInt(Student::getScore)))); //score 합계
		keys = result2.keySet();
		// Optional은 출력할 때 Optional과 함께 출력되기 때문에 이를 벗겨내기 위해서는 get()이나 orElse()를 이용
		for (String key : keys) {
			System.out.println(key + " : " + result2.get(key).get());
		}
		System.out.println();
		

	}

}
