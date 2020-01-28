package java0128;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainNaver {

	public static void main(String[] args) {
		String html = null;
		// 필요한 HTML 다운로드 : https://www.naver.com에서 다운로드
		try {
			// 다운로드 받을 URL 생성
			// URL에 한글이 있으면 URLEncoder.encode 이용해서 인코딩해야 함
			String addr = "https://www.naver.com";
			URL url = new URL(addr);
			
			// 연결
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			
			// 데이터를 다운로드
			StringBuilder sb = new StringBuilder();
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									con.getInputStream()));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			
			// 사용한 스트림 정리
			br.close();
			con.disconnect();
			
			// 데이터 확인
			html = sb.toString();
			//System.out.println(html);
			
		} catch (Exception e){
			System.out.println("다운로드 예외 : " + e.getMessage());
			e.printStackTrace();
		}
		
		if (html == null) {
			System.out.println("다운로드 받을 문자열이 없습니다.");
			return;
		}
		
		// HTML 파싱해서 원하는 자료구조 만들기
		try {
			// 문자열을 메모리에 DOM(Document Object Model)으로 펼치기
			Document document = Jsoup.parse(html);
			// import org.jsoup.nodes.Document 필요
			/*
			// span 태그 가져오기 - 태그는 중복될 수 있으므로 여러 개 리턴
			Elements span = document.getElementsByTag("span");
			// import org.jsoup.select.Elements 필요
			// 가져온 데이터를 순회하면서 출력
			for (int i = 0; i < span.size(); i++) {
				Element element = span.get(i);
				System.out.println(element.text());
			}
			*/
			
			//Element id = document.getElementById("PM_ID_serviceNavi");
			// id는 중복이 없으므로 getElement 에 s 붙이면 안 됨
			
			/*
			// 클래스 이름을 이용해서 찾아오기
			Elements span = document.getElementsByClass("an_txt");
			// 가져온 데이터를 순회하면서 출력
			for (int i = 0; i < span.size(); i++) {
				Element element = span.get(i);
				System.out.println(element.text());
			}
			*/
			Elements span = document.select("#PM_ID_serviceNavi > li:nth-child(9) > a > span.an_txt");
			// 가져온 데이터를 순회하면서 출력
			for (int i = 0; i < span.size(); i++) {
				Element element = span.get(i);
				System.out.println(element.text());
			}
			// 만화 / 웹툰 << 출력
			
		} catch (Exception e){
			System.out.println("파싱 예외 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
