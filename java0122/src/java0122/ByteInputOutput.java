package java0122;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteInputOutput {

	public static void main(String[] args) {
		// try() 안에서 만든 자원은 close를 호출하지 않아도 됨
		try(
				// 파일에 기록하기 위한 인스턴스 생성
				// 파일 경로만 설정하면 기록할 때마다 새로 기록(without true)
				// 두 번째 매개변수로 true를 설정하면 이어쓰기를 함 (with true)
				FileOutputStream fos 
				= new FileOutputStream("./file.dat", true);
				// 파일에서 읽어오기 위한 인스턴스 생성
				FileInputStream fis = new FileInputStream("./file.dat");
				
			){
			// 기록할 내용 만들기
			String msg = "Hello Stream";
			
			// 문자열을 바이트 배열로 만들기
			byte [] b = msg.getBytes();
			// 기록
			fos.write(b);
			fos.flush();
			
			/*
			// 한번에 읽기
			// 읽을 데이터 개수를 가져오기
			int len = fis.available();
			// 읽은 데이터를 저장할 배열을 생성
			b = new byte[len];
			// 데이터 읽기
			fis.read(b);
			// 바이트 배열을 문자열로 변환(생략할 시 아무것도 안 나옴)
			String data = new String(b);
			System.out.println(data);
			*/
			// 용량이 큰  경우 한번에 읽으면 메모리 부족으로 예외가 생기거나
			// 시간이 오래 걸릴 수 있기 때문에 나눠 읽는 게 효율적
			// 저장할 배열 생성 - 크기는 보통 8의 배수로
			byte [] split = new byte[8];
			while (true) {
				// split 크기만큼 읽고 읽은 개수를 리턴
				int r = fis.read(split);
				// r이 0보다 작을 시 읽은 게 없는 것
				if (r <= 0) {
					break;
				}
				// 읽은 데이터가 있으면 처리
				// 문자를 바이트로 읽어서 변환하지는 않음
				// 데이터를 사용할 때 배열을 바로 사용하지 말고 0부터 읽은 개수만큼 사용해야 함
				// 전체를 사용하는 경우 읽은 개수가 부족하면 이상한 결과가 도출됨
				String str = new String(split, 0, r);
				System.out.println(str);
			}
			
		} catch (Exception e) {
			System.out.println("예외내용" + e.getMessage());
		}

	}

}
