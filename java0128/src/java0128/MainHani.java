package java0128;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainHani {

	public static void main(String[] args) {
		// 한겨레 신문사 웹 페이지에서 코로나로 검색된 기사 내용을 전부 파일에 저장하기
		
		// 1. 코로나로 검색된 기사 개수 파악함
		// 기사개수를 지정할 변수
		int cnt = 0;
		try {
			// 한글인 검색어를 인코딩
			String keyword = URLEncoder.encode("코로나", "utf-8");
			// 한겨레 신문사 뉴스 검색 URL 만들기
			String addr = "http://search.hani.co.kr/Search?command=query&keyword=" 
							+ keyword 
							+ "&media=news&submedia=&sort=d&period=all"
							+ "&datefrom=2000.01.01&dateto=2020.01.28&pageseq=0";
			URL url = new URL(addr);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(20000);
			con.setUseCaches(false);
			
			// 문자열을 전부 읽어서 sb에 저장하기
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
			String html = sb.toString();
			br.close();
			con.disconnect();
			// 데이터 확인(확인 후 주석 처리)
			//System.out.println(html);
			
			// html을 DOM으로 펼치기
			Document document = Jsoup.parse(html);
			// 태그이름으로 찾기
			//Elements spans = document.getElementsByTag("span");
			
			// 클래스 이름으로 찾기
			//Elements spans = document.getElementsByClass("total");
			
			// 선택자(selector)를 이용해서 찾기
			Elements spans = document.select(
					"#contents > div.search-result-section.first-child > div > span");
			/*for (int i = 0; i < spans.size(); i++) {
				System.out.println(spans.get(i).text());
			}*/
			String temp = spans.get(0).text();
			// 240 건이라고  temp에 저장
			// 240만 추출 후 정수로 변환해서 cnt에 저장
			String [] ar = temp.split(" ");
			cnt = Integer.parseInt(ar[0]);
			//System.out.println(cnt); // 240만 출력(확인 후 주석처리)
			// 건수가 없는 게시판은 까다로운 케이스로 날짜를 가져와서 해야 함 아니면 마지막 페이지까지 가거나
			
		} catch (Exception e) {
			System.out.println("기사 개수 파악 예외" + e.getMessage());
			e.printStackTrace();
		}
		
		if (cnt <= 0) {
			System.out.println("검색된 기사가 없습니다.");
			return;
		}
		
		// 검색된 데이터에 링크를 전부 찾아서 list에 삽입
		ArrayList<String> list = new ArrayList<String>();
		try {
			// 페이지 개수 구하기
			int pagesu = cnt / 10;
			if(pagesu % 10 != 0) {
				pagesu++;
			}
			
			// 페이지 단위로 순회
			for (int i = 0; i < pagesu; i++) {
				// 한글인 검색어를 인코딩
				String keyword = URLEncoder.encode("코로나", "utf-8");
				// 한겨레 신문사 뉴스 검색 URL 만들기
				String addr = "http://search.hani.co.kr/Search?command=query&keyword=" 
							+ keyword 
							+ "&media=news&submedia=&sort=d&period=all"
							+ "&datefrom=2000.01.01&dateto=2020.01.28&pageseq=" + i;
				URL url = new URL(addr);
				
				// 연결 객체 만들기
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setConnectTimeout(10000);
				con.setUseCaches(false);
				
				// 특정 페이지의 데이터를 읽지 못하더라도 다음 페이지의 데이터를 읽기 위해서 반복문 안에 예외처리문장 삽입
				// 예외 발생해도 계속 읽어오고 싶다면 for문 안에서도 try-catch구문 작성해줘야 함
				// (가장 가까운 구문으로부터 영향)
				// for 반복문 바깥에서 예외문 처리해줘도 예외 발생시 종료되므로 안에서도 예외 처리 필요
				try {
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
					String html = sb.toString();
					br.close();
					con.disconnect();
					
					Document document = Jsoup.parse(html);
					Elements links = document.select("dl > dt > a");
					for (int j = 0; j < links.size(); j++) {
						// a 태그 안에 있는 문자열 가져오기
						//System.out.println(links.get(j).text());
						
						// a 태그의 link 가져오기
						//System.out.println(links.get(j).attr("href"));
						// a 태그의 href 속성 값 가져오기
						list.add(links.get(j).attr("href"));
					}
					//System.out.println(list.size());
					
				} catch (Exception e) {
					System.out.println("링크 수집 실패" + e.getMessage());
					e.printStackTrace();
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("링크 수집 예외 : " + e.getMessage());
			e.printStackTrace();
		}
		
		// list에 저장된 링크의 데이터를 전부 읽어서 파일에 저장
		try {
			for (String addr : list) {
				try {
					URL url = new URL(addr);
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setConnectTimeout(10000);
					con.setUseCaches(false);
					
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
					String html = sb.toString();
					br.close();
					con.disconnect();
					//System.out.println(html);
					
					// 파일에 기록
					Document document = Jsoup.parse(html);
					//Elements articles = document.select("dl > dt > a");
					//Elements articles = document.getElementsByClass("title");
					// 기사 내용 가져오기
					Elements articles = document.getElementsByClass("text");
					
					for (int i = 0; i <articles.size(); i++) {
						PrintWriter pw = 
								new PrintWriter(
										new FileOutputStream(
												"./코로나.txt", true));
						// true 명시 안 하면 매번 새로 씀
						pw.println(articles.get(i).text());
						pw.flush();
						pw.close();
					}
					
					// 실무에서 여러 개의 페이지에서 스크래핑할 때는 딜레이를 주는 것이 좋음
					// 슬립 없으면 프로그램 죽을 수도 있음
					//Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("기사 읽기 메모 : " + e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("링크 읽기 메모 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}