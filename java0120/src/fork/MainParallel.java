package fork;

import java.util.concurrent.ForkJoinPool;

public class MainParallel {

	public static void main(String[] args) {
		ParallelProcessing p = new ParallelProcessing(1, 60);
		
		// 위의 작업을 나누어서 할 수 있는 Pool 생성
		ForkJoinPool pool = new ForkJoinPool();
		
		// Pool에 작업을 대입해서 실행
		System.out.println(pool.invoke(p));

	}

}
