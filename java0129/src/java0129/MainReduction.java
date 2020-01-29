package java0129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class MainReduction {

	public static void main(String[] args) {
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
		
		// distinct (중복을 제거해주는 메소드)
		System.out.println("====================== distinct ======================");
		String [] ar = {"데니스 리치히", "귀도 반 로섬", "제임스 고슬링", "데니스 리치히"};
		Stream<String> arStream = Arrays.stream(ar);
		//arStream.forEach(System.out::println); // 같이 출력하면 아래 distinct구문 error
		arStream.distinct().forEach(System.out::println);
		// 출력 차이 비교 (데니스 리치히 중복 제거돼서 출력됨)
		
		// filter (조건에 맞는 데이터만 추출하는 중간 연산)
		// filter에는 매개변수 1개를 갖고 boolean을 리턴하는 람다식을 대입
		System.out.println("======================= filter =======================");
		Stream<Student> stream = list.parallelStream();
		
		//stream.filter(predicate).forEach(System.out::println);
		
		// score가 90보다 큰 데이터만 추출해서 출력
		//stream.filter((student)->{return student.getScore() > 90;}).forEach(System.out::println);
		
		// gender가 '여'(여자)인 데이터만 추출해서 출력 (아랫값 출력하려면 위에 주석처리 해야 함)(스트림은 한 번 사용하면 소멸되기 때문에)
		stream.filter((student)->{return student.getGender().equals("여");}).forEach(System.out::println);
		
		// map()은 데이터를 변환할 때 사용하는 메소드
		System.out.println("======================== map =========================");
		// 숫자->문자열, 문자열->숫자, 날짜->문자열, 인스턴스->기본형
		// Student를 score로 변환
		stream = list.stream();
		// 스트림은 한 번 사용하면 소멸되기 때문에 다시 사용할 때는 새로 생성해야 함
		//stream.forEach(System.out::println);
		//stream.mapToInt((student)->{return student.getScore();}).forEach(System.out::println);
		// 어떤 메소드를 수행만 하는 경우 클래스이름::메소드이름만 입력해도 됨
		stream.mapToInt(Student::getScore).forEach(System.out::println);
		
		// sorted() (데이터 정렬)
		System.out.println("======================= sorted =======================");
		// 각 요소가 크기 비교가 가능하다면 바로 오름차순 정렬을 수행
		// 요소 크기 비교가 불가능하다면 크기 비교가 가능한 메소드를 대입해야 함
		// 크기 비교가 가능한 데이터는 속성을 하나만 가진 데이터임
		// 기본 자료형, 문자열, 날짜 정도
		// C언어는 예외
		
		// String은 크기 비교가 가능하기 때문에 바로 오름차순 정렬
		arStream = Arrays.stream(ar);
		arStream.sorted().forEach(System.out::println);
		
		System.out.println("---------------------- 점수 오름 차순 ----------------------");
		stream = list.stream();
		// Student는 여러 개의 항목을 소유하고 있기 때문에 어떤 항목으로 크기 비교할지 알지 못하기 때문에 예외가 발생
		//stream.sorted().forEach(System.out::println);
		
		// 크기 비교 메소드를 만들어서 정렬
		// 비교 전에 2개의 매개변수를 가지고 정수를 리턴하는 메소드를 만들어야 함
		// A>B는 양수, A==B는 0, A<B는 음수 리턴
		// 점수의 오름차순
		stream.sorted((a, b)-> {return a.getScore() - b.getScore();}).forEach(System.out::println);
		// 점수의 내림차순
		//stream.sorted((a, b)-> {return b.getScore() - a.getScore();}).forEach(System.out::println);
		
		System.out.println("---------------------- 이름 오름 차순 ----------------------");
		stream = list.stream();
		// 문자열 (compareTo 를 이용) 오름 차순(내림 차순은 앞뒤 순서 변경하면 됨)
		stream.sorted((a, b)-> {return a.getName().compareTo(b.getName());}).forEach(System.out::println);

	}

}
