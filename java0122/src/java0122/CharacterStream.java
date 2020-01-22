package java0122;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class CharacterStream {

	public static void main(String[] args) {
		try(
				//파일에 문자 단위로 기록하기 위한 스트림
				PrintWriter pw = new PrintWriter("./data.txt");
				BufferedReader br = new BufferedReader(
						new FileReader("./data.txt"));
			)
		{
			pw.println("안녕하세요, 반갑습니다.");
			pw.println("벌써 설날입니다.");
			pw.flush();
			while (true) {
				// 한 줄 읽기
				String line = br.readLine();
				// 다 읽었으면 중지
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("예외  : " + e.getMessage());
		}

	}

}
