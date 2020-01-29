package java0129;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainParellel {
	
	// 문자열을 매개변수로 받아서 2초 후에 출력하는 메소드
	public static void work(String str) {
		try {
			Thread.sleep(2000);
			System.out.print(str);
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		String [] ar = {"일", "이", "삼", "사", "오"};
		List<String> list = Arrays.asList(ar);
		
		Stream<String> arStream = list.stream();
		// 일반 스트림을 생성해서 ar에 work를 수행 (10초 정도 소요)
		long start = System.currentTimeMillis();
		
		arStream.forEach((data) -> {work(data);});
		
		long end =  System.currentTimeMillis();
		System.out.print("\t");
		System.out.println("순차 처리 : " + (end - start));
		// 출력(println에서 print로 수정함, 순서 잘 보고 싶으면 이전으로 수정하길)
		// 일이삼사오	순차 처리 : 10031
		
		// 병렬 스트림을 생성해서 work를 수행 (cpu 코어 개수에 따라 걸리는 시간이 다름)
		// 코어가 5개 이상이면 한 번에 수행하므로 2초 정도 소요)
		// 데이터의 모임을 가지고 작업을 수행하는 경우 다른 데이터의 영향을 전혀 받지 않고
		// 수행되는 경우에는 병렬처리를 하는 것이 시간적으로 이득
		// 앞의 데이터의 연산 결과를 가지고 다음 작업을 수행하는 작업에 병렬처리하는 것은 곤란
		// 필터링 같은 경우 병렬처리 수행하기 좋은 작업 (Map-Reduce)
		// 각각의 데이터에서 작업을 처리한 후 그 결과를 모아서 리턴
		Stream<String> parallelStream = list.parallelStream();
		start = System.currentTimeMillis();
		
		parallelStream.forEach((data) -> {work(data);});
		
		end = System.currentTimeMillis();
		System.out.print("\t");
		System.out.println("병렬 처리 : " + (end - start));
		// 출력(println -> print)
		// 삼오이일사	병렬 처리 : 2008

	}

}
