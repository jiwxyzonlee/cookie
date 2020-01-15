package java0115;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int [] ar = {100, 300, 200, 500, 400};
		// 이분 검색은 정렬이 된 상태에서 수행해야 정확한 결과가 나옴
		// 데이터가 없으면 음수가 나옴
		System.out.println(Arrays.binarySearch(ar, 300)); // -4
		Arrays.sort(ar);
		// 정렬을 했기 때문에 데이터는 100 200 300 400 500
		System.out.println(Arrays.binarySearch(ar, 300)); // 2

	}

}
