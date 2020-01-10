package algorithm;

public class Quicksort {
	// left는 정렬시작위치, right는 정렬 종료 위치, data는 정렬할 배열
	public static void quickSort(int left, int right, int [] data) {
		/* // 과정 출력
		for (int e : data) {
			System.out.print(e + "\t");
		}
		System.out.print("\n");
		*/
		
		// 기준위치 생성
		int pivot = left;
		// 기준위치의 데이터보다 작은 데이터를 만났을 때 변경할 위치
		int j = pivot;
		// 데이터가 2개 이상일 때만 정렬을 수행하도록 하기 위한 조건
		if(left < right) {
			// pivot 위치의 데이터와 오른쪽에 있는 모든 데이터를
			// 비교하기 위해서 반복문 생성
			for(int i = pivot + 1; i < right + 1; i = i + 1) {
				// pivot 위치의 데이터보다 오른쪽 데이터가 작으면
				// j값을 증가시키고 j번째 데이터와  i번째 데이터를 swap
				if(data[pivot] > data[i]) {
					j = j + 1;
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
			// pivot 위치의 데이터와 j번째 데이터를 swap
			int temp = data[pivot];
			data[pivot] = data[j];
			data[j] = temp;
			
			// pivot의 값을 j로 변경
			pivot = j;
			
			// left부터 pivot - 1까지 다시 수행
			quickSort(left, pivot - 1, data);
			// pivot + 1부터 right까지 다시 수행
			quickSort(pivot + 1, right, data);
		}
	}

	public static void main(String[] args) {
		int [] ar = { 70, 40, 50, 20, 90, 80, 60, 10, 30};
		
		// 첫번째부터 마지막까지 데이터 정렬 - quickSort함수 호출
		quickSort(0, ar.length - 1, ar);
		
		for (int e : ar) {
			System.out.print(e + "\t");
		}

	}

}
