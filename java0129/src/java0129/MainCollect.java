package java0129;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {

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
		
		Stream<Student> stream = list.stream();
		// gender 값이 '남'인 데이터만 가지고 List를 생성
		List<Student> manList = 
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("남");
							}
						).collect(Collectors.toList());
		for (Student temp : manList) {
			System.out.println(temp);
		}
		System.out.println();
		
		stream = list.stream();
		// gender 값이 '여'인 데이터를 가지고 name을 key로 하고 전체를 value로 하는 Map을 생성
		Map<String, Student> womanMap =
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("여");
							}
						).collect(
								Collectors.toMap(Student::getName, (student) ->{return student;}));
		// Map의 모든 데이터 출력
		Set<String> keys = womanMap.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + womanMap.get(key));
		}
		System.out.println();
		
		stream = list.stream();
		// gender 값이 '여'인 데이터를 가지고 여자인원수 구하기
		long count =
				stream.filter(
						(student) -> {
							return student
									.getGender()
									.equals("여");
							}
						).collect(Collectors.counting());
		System.out.println("여자 인원수 : " + count);

	}

}
