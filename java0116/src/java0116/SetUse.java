package java0116;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUse {

	public static void main(String[] args) {
		 Set<Integer> set = new TreeSet<Integer>();
		// Set<Integer> set = new LinkedHashSet<Integer>();
		// Set<Integer> set = new HashSet<Integer>();
		// Set에 데이터 추가
		set.add(100);
		set.add(300);
		set.add(200);
		set.add(500);
		set.add(400);
		// 데이터 전부 출력
		for(Integer temp : set) {
			System.out.println(temp);
		}

	}

}
