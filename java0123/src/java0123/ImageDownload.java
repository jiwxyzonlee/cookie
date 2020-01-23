package java0123;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownload {

	public static void main(String[] args) {
		Thread th = new Thread() {
			public void run() {
				try {
					// 다운로드 받을 주소 생성
					String addr = "https://upload.wikimedia.org/wikipedia/"
							+ "en/thumb/e/ec/Lisa_Simpson.png/220px-Lisa_Simpson.png";
					// 파일명을 만드릭 위해서 마지막 / 다음의 문자열가져오기
					int len = addr.lastIndexOf('/');
					String filename = addr.substring(len + 1);
					//System.out.println(filename);
					
					// 현재 디렉토리 위 파일이 있으면 있다고 출력하고 없다면 다운로드 받아서 저장
					File f = new File("./" + filename);
					if (f.exists() == true) {
						System.out.println("파일이 이미 존재합니다");
						return;
					} else {
						URL url = new URL(addr);
						HttpURLConnection con = (HttpURLConnection)url.openConnection();
						con.setConnectTimeout(30000);
						con.setUseCaches(false);
						
						/*// 한꺼번에 읽어서 다운 받기
						// 다운로드 받을 파일의 크기 가져오기
						int length = con.getContentLength();
						byte [] b = new byte[length];
						
						// 바이트 단위의 데이터 읽어올 스트림 생성
						BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
						// 데이터를 읽어서 b에 저장
						bis.read(b);
						// 읽어온 내용을 파일에 저장
						PrintStream ps = new PrintStream(new FileOutputStream("./" + filename));
						ps.write(b);
						// flush 안 하면 이미지 깨질 수 있음
						ps.flush();
						*/
						
						// 나눠 읽어서 기록
						// 바이트 단위의 데이터 읽어올 스트림 생성
						BufferedInputStream bis = 
								new BufferedInputStream(
										con.getInputStream());
						
						PrintStream ps = 
								new PrintStream(
										new FileOutputStream("./" + filename));
						
						while (true) {
							// 512 바이트 배열
							byte [] b = new byte[512];
							// 내용을 읽어서 b에 저장
							// 읽은 개수를 r에 저장
							int r = bis.read(b);
							// 읽은 게 없으면 중단
							if (r <= 0) {
								break;
							}
							// 읽은 데이터가 있으면 기록
							ps.write(b, 0, r);
							// 버퍼에 내용이 남아있는 것을 방지하기 위해서 마지막에 flush 호출
							ps.flush();
						}
						
						// 사용한 스트림 닫기
						ps.close();
						bis.close();
						// 연결 끊기
						con.disconnect();
					}
					
				} catch (Exception e) {
					System.out.println("다운로드 예외" + e.getMessage());
					e.printStackTrace();
				}
			}
		};
		th.start();
		
		// 스레드 동작 중 쉬는 시간에 동작
		System.out.println("스레드와 상관 없는 코드");

	}

}
