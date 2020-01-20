package java0115;

import java.util.Scanner;

public class ExampleMain2 {
	
	public static void main (String [] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String s1 = sc.nextLine();
		System.out.println("비교할 문자열 입력 : ");
		String s2 = sc.nextLine();
		
		boolean result = areAnagram(s1, s2);
		System.out.println(result);
	}
		
	public static boolean areAnagram(String active, String control) {
		boolean areAnagram = false;
		
		active = active.replaceAll(" ", "").toLowerCase();
		control = control.replaceAll(" ", "").toLowerCase();
		
		if (active != null && control != null && active.length() == control.length()) {
			char [] arr = active.toCharArray();
			StringBuilder temp = new StringBuilder(control);
			int activeLength = active.length();
			for (char ch : arr) {
				int index = temp.indexOf("" + ch);
				if (index != -1) {
					temp.deleteCharAt(index);
				}
			}
			areAnagram = temp.toString().isEmpty();
		}
		return areAnagram;
		
		
	}

}
