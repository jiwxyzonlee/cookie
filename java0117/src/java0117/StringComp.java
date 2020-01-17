package java0117;

import java.util.Comparator;

// 문자열 비교를 위한 클래스
public class StringComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

}
