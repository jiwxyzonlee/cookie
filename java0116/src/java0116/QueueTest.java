package java0116;

import java.util.PriorityQueue;

public class QueueTest {

	public static void main(String[] args) {
		// 우선 순위 큐
		// : 데이터를 크기 순서대로 접근할 수 있도록 만든 큐
		// 데이터 내부에서는 정렬된 것이 아니고 정렬된 순서대로 이진 트리를 생성(접근 가능)
		PriorityQueue <String> pq = new PriorityQueue<>();
		pq.add("서울");
		pq.add("런던");
		pq.add("뉴욕");
		pq.add("블라디보스톡");
		pq.add("상트페테르부르크");
		
		// 트리의 순회를 이용하지 않기 때문에 데이터가 정렬된 순서가 아닐 수 있음
		// 빠른  열거를 이용해서 데이터를 1개씩 꺼내와서 출력
		for (String city : pq) {
			System.out.print(city + "\n");
		}
		System.out.print("\n");
		
		/*
		// 데이터 poll을 이용해서 1개씩 가져와서 출력
		for (int i = 0; i < 5; i = i + 1) {
			System.out.print(pq.poll() + "\t");
		}
		System.out.print("\n");
		*/
		
		// 지우면서 가져올 때는 데이터의 개수나 인덱스가 변할 수 있으므로 주의
		int len = pq.size();
		// 데이터를 poll을 이용해서 1개씩 가져와서 출력
		// 트리의 순회를 이용하기 때문에 데이터가 정렬된 순서대로 출력
		for (int i = 0; i < len; i++) {
			System.out.print(pq.poll() + "\t");
		}
		
	}

}
