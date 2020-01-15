package java0115;

public class StringMain {

	public static void main(String[] args) {
		String requestURI = "/member/login";
		// 위와 같은 문자열이 있을 때 마지막 / 다음의 문자열을 추출 (login)
		// 위와 같은 형태는 파일 경로에서 파일이름만 추출하거나
		// 웹 요청 주소에서 공통되지 않은 부분을 추출할 때 많이 사용
		// split을 이용해서 해결, IndexOf와 substring 이용해서 해결
		
		// split을 이용해서 해결
		// '/'로 분할한 후 가장 마지막 데이터 출력
		
		//int a = requestURI.indexOf("login");
		//System.out.println(a);
		System.out.println();
		String [] sp = requestURI.split("/");
		System.out.println(sp[sp.length - 1]);
		
		// 마지막 '/'의 위치를 찾아서 그 다음부터 끝까지 분할
		int idx = requestURI.lastIndexOf("/");
		System.out.println(requestURI.substring(idx + 1));
		
		
		// 현재 운영체제가 windows인지 확인
		String os = System.getProperty("os.name");
		// os에서 windows 라는 문자열이 포함되어 있는지 확인
		// 예) 모바일에서 웹페이지 주소 적었을 때 자동으로 모바일버전 바꿀 때
		idx = os.toLowerCase().indexOf("windows");
		if(idx<0) {
			System.out.println("윈도우 아님");
		}else {
			System.out.println("현재 운영체제는 윈도우");
		}

	}

}
