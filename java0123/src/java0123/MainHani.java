package java0123;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MainHani {

	public static void main(String[] args) {
		// 문자명을 다운로드 받는 부분
		// 다운로드 받은 문자열을 저장할 변수
		String xml = null;
		try {
			URL url = new URL("http://www.hani.co.kr/rss/sports/");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			// 데이터를 문자열로 변환
			xml = sb.toString();
			// 중간 확인
			//System.out.println(xml);
			
		} catch (Exception e) {
			System.out.println("다운로드 예외 : " + e.getMessage());
			e.printStackTrace();
		}
		
		// xml 파싱을 해서 출력하는 부분
		if (xml == null) {
			System.out.println("데이터를 다운로드받지 못했습니다");
		} else {
			try {
				// String을  InputStream으로 변환
				InputStream is = new ByteArrayInputStream(xml.getBytes());
				
				// 파싱 객체를 생성
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				// 메모리에 펼치기 (org.w3c.dom.Document)
				Document document = builder.parse(is);
				// 루트 찾기 (org.w3c.dom.Element)
				Element root = document.getDocumentElement();
				// 원하는 태그 찾아오기 (title 태그와 link 태그의 데이터 찾아오기)
				NodeList titleList = root.getElementsByTagName("title");
				NodeList linkList = root.getElementsByTagName("link");
				
				// 데이터 개수 알아내기
				int len = titleList.getLength();
				
				ArrayList<String> titles = new ArrayList<String>();
				
				// 순회
				for (int i = 0; i < len; i++) {
					// 태그 하나의 항목 가져오기
					Node title = titleList.item(i);
					Node link = linkList.item(i);
					
					// 태그 하나의 텍스트 출력
					Node imsi = title.getFirstChild();
					//System.out.print(imsi.getNodeValue());
					//System.out.println();
					titles.add(imsi.getNodeValue());
					
					Node temp = link.getFirstChild();
					//System.out.print(" : " + temp.getNodeValue());
					//System.out.println();
				}
				int i = 0;
				while (true) {
					System.out.println(titles.get(i % titles.size()));
					Thread.sleep(3000);
					i++;
				}
				
			} catch (Exception e) {
				System.out.println("xml 파싱 예외 : " + e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
