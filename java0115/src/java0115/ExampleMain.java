package java0115;

import java.util.Arrays;
import java.util.Scanner;

public class ExampleMain {
		
	public static void areAnagram (String munja1, String munja2) {
		// 공백 제거
		String s1 = munja1.replaceAll(" ", "");
		String s2 = munja2.replaceAll(" ", "");
		boolean result = true;
		
		// 글자 길이 확인 & 비교
		if (s1.length() != s2.length()) {
			result =  false;
		}
		
		// 소문자 변경 & char 변환
		char [] character1 = s1.toLowerCase().toCharArray();
		char [] character2 = s2.toLowerCase().toCharArray();
		
		// 정렬
		Arrays.sort(character1);
		Arrays.sort(character2);
		
		// Char를  String 변환
		String compare1 = new String(character1);
		//System.out.println(compare1);
		String compare2 = new String(character2);
		//System.out.println(compare2);
		result = compare1.equals(compare2);
		//result = Arrays.equals(character1, character2);
		
		// 문자열 비교 결과 확인
		if (result) {
			System.out.println(munja1 + " and " + munja2 + " are anagrams");
		}
		else {
			System.out.println(munja1 + " and " + munja2 + " are not anagrams");
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력 : ");
		String munja1 = sc.nextLine();
		
		System.out.println("비교 문자열 입력 : ");
		String munja2 = sc.nextLine();
		
		areAnagram(munja1, munja2);
		
		sc.close();
	}

}
