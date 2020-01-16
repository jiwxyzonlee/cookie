package java0116;

import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		// 문자열을 저장하는 스택 생성
		Stack <String> stack = new Stack<>();
		// 데이터 저장은  push
		stack.push("김갹갹");
		stack.push("김뿅뿅");
		stack.push("김귤귤");
		
		// 마지막 데이터 제거하면서 가져오기
		String human = stack.pop();
		System.out.println(human);
		
		// 마지막 데이터 제거하지 않고 가져오기
		human = stack.peek();
		System.out.println(human);
		human = stack.peek();
		System.out.println(human);
		
	}

}
