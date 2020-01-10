package interfaceUse;

// Service라는 단어로 끝나는 인터페이스는
// 클라이언트의 요청을 처리하는 메소드를 소유한 인터페이스
public interface UserService {
	// 고객의 요청을 처리하는 인터페이스의 메소드를 설계할 때는
	// 요청 하나당 메소드 1개 연결
	// 2개 이상 연결 시 순서 개념을 염두해야
	public void disp();

}
