package java0117;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMain {

	public static void main(String[] args) {
		Date wrongDate = new Date(2020, 1, 17); //Error
		System.out.println("Wrong Date : " + wrongDate);
		// Tue Feb 17 00:00:00 KST 3920
		// (3920년 2월 17일)
		
		// java.util.Date는
		// 1900년 이후 지나온 연도, 월은 0부터 시작, 일은 1부터 시작
		Date date = new Date(120, 0, 17);
		System.out.println("Date : " + date);
		// Fri Jan 17 00:00:00 KST 2020
		
		// Calendar 클래스의 인스턴스를 생성
		// Calendar 클래스는 추상 클래스
		// (추상 클래스는 인스턴스 생성 불가능)
		
		// Calendar 클래스의 인스턴스를 만드는 것이 아니고
		// Calendar 클래스를 상속받은 클래스의
		// Anonymous 클래스를 생성해서 인스턴스 만들고 리턴
		// Java에서 인터페이스나 추상클래스를 리턴 타입으로 하는 모든 메소드는 이 원리가 적용됨
		Calendar cal = Calendar.getInstance();
		
		// toString 이 너무 많은 양의 데이터를 리턴하도록 만들어져서 보기 어려움
		// System.out.println(cal);
		
		// 필요한 데이터만 추출
		System.out.println("Month : " + cal.get(Calendar.MONTH) + 1);
		// Month는 0부터 시작해서 출력시 1을 더해야 함
		
		// 1월부터 12월까지의 날수를 배열에 저장 (프로그래밍할 때 팁)
		/*
		int [] months = {31,29,31,30,31,30,31,31,30,31,30,31};
		// 2월의 날수
		System.out.println(months[1]);*/
		
		// 프로그래밍 편의상 첫번째 위치에 의미없는 값을 ㅅㅂ입해서
		// 인덱스와 데이터의 위치를 맞출 수 있있음
		int [] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 2월의 날수
		System.out.println("Februrary has " + months[2] + "days");
		// 0을 미리 집어넣어서 데이터 추출 때 편하도록
		
		
		Date today = new Date();
		// 날짜를 문자열로 변경해주는 클래스
		SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mm:dd");
		String msg = sdf.format(today);
		System.out.println("Todat : " + msg);

	}

}
