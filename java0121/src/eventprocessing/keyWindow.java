package eventprocessing;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class keyWindow extends Frame {
	
	private Label lbl;
	
	public keyWindow() {
		
		// 컴포넌트들의 위치 변경이나 크기 변경이 가능하도록
		// 레이아웃을 null로 설정
		setLayout(null);
		
		// 레이블을 생성하고 배치
		lbl = new Label("@");
		lbl.setLocation(20, 30);
		lbl.setSize(15, 15);
		add(lbl);
		
		// 테트리스처럼 자동으로 내려가게 만들기
		// 레이블을 1초마다 아래로 5만큼씩 이동하는 스레드
		Thread th = new Thread () {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						int x = lbl.getLocation().x;
						int y = lbl.getLocation().y;
						y = y + 5;
						lbl.setLocation(x, y);
					} catch (Exception e) {}
				}
			}
		};
		th.start();
		
		// 키보드 이벤트 처리를 위한 인스턴스 생성
		KeyListener listener = new KeyListener() {

			// 키보드 눌렀을 때 호출
			@Override
			public void keyPressed(KeyEvent arg0) {
				// 조합키 확인
				int modifiers = arg0.getModifiers();
				// control + X 이면 종료
				// control 키가 눌러졌는지 확인
				if ((modifiers & 2)!= 0) {
					// 별도로 누른 키가 X인지 확인
					// 대소문자 구분하고 싶다면 getKeyChar() 사용
					int key = arg0.getKeyCode();
					if ( key == KeyEvent.VK_X) {
						System.exit(0);
					}
				}
				System.out.println(modifiers);
				
				//System.out.println("아무 키나 누르면 호출됩니다.");
				// keyChar는 대소문자 구분(a->a, A->A)
				//System.out.println(arg0.getKeyChar());
				// keyCode는 대소문자 구분 안 함(a->65, A->65)
				//System.out.println(arg0.getKeyCode());
				
				// 현재 레이블의 위치 가져오기
				int x = lbl.getLocation().x;
				int y = lbl.getLocation().y;
				
				// 누른 키보드 값 가져오기
				int code = arg0.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_UP:  // 위 화살표
					y = y - 5;
					break;
				case KeyEvent.VK_DOWN: // 아래 화살표
					y = y + 5;
					break;
				case KeyEvent.VK_LEFT: // 왼쪽 화살표
					x = x - 5;
					break;
				case KeyEvent.VK_RIGHT: // 오른쪽 화살표
					x = x + 5;
					break;
				}
				lbl.setLocation(x, y);
				
			}

			// 키보드에서 손을 뗄 대 호출
			@Override
			public void keyReleased(KeyEvent arg0) {
				//System.out.println("키보드에서 손을 떼면 무조건 호출");
				
			}

			// 문자 키를 눌렀을 때 호출
			@Override
			public void keyTyped(KeyEvent arg0) {
				//System.out.println("문자 키를 눌렀을 때 호출");
				
			}
			
		};
		// 윈도우에 키보드 이벤트 리스너 연결
		this.addKeyListener(listener);
		
		setTitle("키보드 이벤트");
		setLocation(100, 100);
		setSize(400, 400);
		setVisible(true);
		
		WindowAdapter windowListener = new WindowAdapter() {
			// Listener는 인터페이스이기 때문에 메소드 하나라도 지우면 에러 뜸
			// Listener는 인터페이스라서 모든 메소드를 구현해야 하지만
			// Adapter는 추상클래스라서 추상메소드와 필요한 메소드만 구현하면 됨
			// 종료 버튼을 누를 때 호출되는 메소드
			@Override
			public void windowClosing(WindowEvent e) {
				// 프로그램 종료
				System.exit(0);
				
			}
			
		};
		// 윈도우 이벤트 연결
		this.addWindowListener(windowListener);
	}

}
