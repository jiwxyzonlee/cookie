package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Directory implements Entry {

	private String name;
	// File이나 Directory를 소유할 수 있기 때문에
	// Entry를 여러 개 저장할 수 있는 자료구조를 소유
	List<Entry> list;
	// Composite이 될 수 있는 이유
	
	public Directory(String name) {
		this.name = name;
		list = new ArrayList<Entry>();
	}

	@Override
	public void add(Entry entry) {
		list.add(entry);

	}

	@Override
	public void remove() {
		
		// Iterator를 이용해서 데이터 접근
		Iterator<Entry> iter = list.iterator();
		while (iter.hasNext()) {
			Entry entry = iter.next();
			if (entry.getClass().getName().equals("composite.Directory")) {
				System.out.print("하위 디렉토리 내용도 삭제하시겠습니까? (삭제는 Y 또는 y) : ");
				Scanner sc = new Scanner(System.in);
				String reply = sc.nextLine();
				sc.close();
				if (reply.equals("Y") || reply.equals("y")) {
					System.out.println("삭제 진행");
				} else {
					System.out.println("삭제 중단");
					return;
				}
			}
			// 디렉토리인지 확인해서 작업을 수행하지 않을 수도 있음
			// File이 있으면 File의 remove를 호출
			// Directory이면 Directory의 remove 호출
			// -> 다형성(Polymorphism)
			entry.remove();
		}
		System.out.println("내부 데이터는 전부 삭제되었습니다!!");
		
		// list가 null일 시 NullPointerException 발생
		// list가 인스턴스 생성은 됐는데 멤버가 없으면 수행 안 함
		/*
		for (Entry entry : list) {
			// 디렉토리인지 확인해서 작업을 수행하지 않을 수도 있음
			
			// File이 있으면 File의 remove를 호출
			// Directory이면 Directory의 remove 호출
			// -> 다형성(Polymorphism)
			entry.remove();
		}
		*/

	}

	@Override
	public void rename(String name) {
		this.name = name;

	}

}
