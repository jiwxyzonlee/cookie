package java0122;

import java.io.File;
import java.util.Date;

public class FileInfo {

	public static void main(String[] args) {
		
		// 절대 경로를 이용해서 파일 인스턴스 생성
		//File f = new File("C:\\Users\\admin"
		//		+ "\\Documents\\java\\200121\\2.png");
		
		// 프로젝트 디렉토리 보기
		// [Switch Workspace] - [Other] 현재 디렉토리 볼 수 있음
		System.out.println("Current Working Directory = " + 
				System.getProperty("user.dir"));
		// 상대 경로를 이용해서 파일 인스턴스 생성
		File f = new File("./src/2.png");
		// cmd 창에서는 드래그 뒤 enter 치면 경로 복사됨
		
		// 파일 존재 여부 확인
		// 서버&클라이언트 환경에서 클라이언트에 파일 존재여부 확인하여 다운로드
		boolean isExists = f.exists();
		System.out.println("존재여부: " + isExists);
		
		// 파일 마지막 수정시간 확인
		// 업데이트할 때 시간이 서로 다르면 다운로드
		long modify = f.lastModified();
		System.out.println("마지막 수정시간 : " + modify);
		
		// 수정시간을 알아보기 쉽게 변경
		Date date = new Date(modify);
		System.out.println("마지막 수정시간 : " + date);
		
		// 파일의 크기 확인
		// 업데이트할 때도 사용할 수 있고 다운로드 여부를 판정하는 데에도 이용
		// 파일의 크기를 알려주어 다운로드 여부를 판단하도록 하는 경우 존재
		long size = f.length();
		System.out.println("파일크기 : " + size);

	}

}
