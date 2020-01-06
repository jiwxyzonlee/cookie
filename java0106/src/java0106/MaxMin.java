package java0106;

public class MaxMin {

	public static void main(String[] args) {
		int [] ar = {40, 37, 51, 65, 29};
		// 최댓값과 모든 데이터를 비교하여
		// 최댓값보다 큰 데이터를 만나면 그 값을 최댓값으로 변경
		int max = ar[0];
		for (int data : ar) {
			if (max < data) {
				max = data;
			}
		}
		System.out.print("최댓값 : " + max + "\n");
		
		// 최솟값
		int min = ar[0];
		for (int data : ar) {
			if (min > data) {
				min = data;
			}
		}
		System.out.print("최솟값 : " + min + "\n");
		
		// 50과 가장 가까운 수 찾기
		int prox = ar[0];
		for (int data : ar) {
			if ((prox-50)*(prox-50) > (data-50)*(data-50)){
				prox = data;
			}
			/*if (Math.abs(prox - 50) > Math.abs(data - 50)) {
				prox = data;
			}*/
		}
		System.out.print("근접값 : " + prox);

	}

}
 