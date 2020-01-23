package java0123;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPInfo {

	public static void main(String[] args) {
		// 자신의 컴퓨터 IP확인
		try {
			// 자신의 컴퓨터 IP 정보 확인
			// 자신의 컴퓨터 이름(도메인)과 IP 주소
			InetAddress local = InetAddress.getLocalHost();
			// surround with try/catch
			System.out.println(local);
			
			// 구글의 IP 정보 확인
			InetAddress [] googles = InetAddress.getAllByName("www.google.com");
			for (InetAddress imsi : googles) {
				System.out.println(imsi);
			}
			// naver의 IP 정보 확인
			InetAddress [] navers = InetAddress.getAllByName("www.naver.com");
			for (InetAddress imsi : navers) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			System.out.println("예외 : " + e.getMessage());
		}

	}

}
