package java0123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class KakaoOpenAPI {

	public static void main(String[] args) {
		// 데이터를 다운로드 받는 부분
		String json = null;
		try {
			// 검색할 도서이름 입력
			System.out.print("검색할 도서명 : ");
			Scanner sc = new Scanner(System.in);
			String book = sc.nextLine();
			
			// book을 한글 입력 경우를 생각해서 인코딩
			book = URLEncoder.encode(book, "utf-8");
			
			// 다운로드 받을 URL 생성
			URL url = new URL("https://dapi.kakao.com/v3/search/book?sort=latest&target=title&query=" + book);
			// 정렬 옵션 줄 수 있음
			// 최신순: book?sort=latest&target=title&query=
			// 50개만 보이기 : book?size=50&
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// 옵션 설정
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			// 헤더 설정
			con.addRequestProperty("Authorization"
					, "KakaoAK 8cf374dcd0067d13e1fa5a9396b5a5e3");
			
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			json = sb.toString();
			
			br.close();
			con.disconnect();
			sc.close();
			
			//System.out.println(json);
			
		} catch (Exception e) {
			System.out.println("다운로드 예외 : " + e.getMessage());
			e.printStackTrace();
		}
		
		// 데이터를 파싱하는 부분
		if (json == null) {
			System.out.println("읽어온 데이터가 없습니다");
		} else {
			// 전체 문자열을 JSON 객체로 변환
			JSONObject root = new JSONObject(json);
			//System.out.println(root);
			
			// meta 키의 내용을 JSONObject로 가져오기
			//JSONObject meta = root.getJSONObject("meta");
			//System.out.println(meta);
			
			// documents(대괄호로 들어있으므로 배열로) 키의 내용을 JSONArray로 가져오기
			JSONArray documents = root.getJSONArray("documents");
			//System.out.println(documents);
			
			// 배열의 데이터 개수 찾아오기&순회
			int len = documents.length();
			for (int i = 0;i < len; i++) {
				JSONObject document = documents.getJSONObject(i);
				//System.out.println(document);
				try {
					String title= document.getString("title");
					int price = document.getInt("price");
					String thumb = document.getString("thumbnail");
					System.out.println(
						title + " : " 
							+ price + " 원, " 
								+ URLDecoder.decode(thumb, "utf-8"));
					// 가격(sale_price)이 없는 경우가 있으므로 try-catch구문으로 처리
					// thumbnail 인코딩 된 거 디코딩 해서 출력하기
					// 인코딩은 문자열을 메모리에 저장되는 코드로 변환하는 것이고
					// 디코딩은 메모리에 저장된 코드를 원래의 문자열로 복원하는 것
					// utf-8 = UTF8
					// CP949, MS949
					// euc-kr = EUCKR
				} catch(Exception e) {}
			}
			
		}

	}

}
