package java0128;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverLogin {

	public static void main(String[] args) {
		// 크롬 드라이버의 위치를 프로퍼티에 추가
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		// 크롬 실행
		WebDriver driver = new ChromeDriver();
		// 크롬에서 다음 로그인 사이트에 접속
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		// 아이디와 비밀번호 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
			
		// 아이디란과 비밀번호 입력란에 입력받은 내용을 입력하기
		//driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(id);
		driver.findElement(By.id("id")).sendKeys(id);
		driver.findElement(By.id("pw")).sendKeys(pw);
				
		// 로그인 버튼 클릭
		driver.findElement(By.id("log.login")).click();
		// JavaScript 쓰면 되긴 됨
		
		String html = driver.getPageSource();
		Document document = Jsoup.parse(html);

	}

}
