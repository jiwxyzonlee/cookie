package eventprocessing;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class MyWindow extends Frame {
	private Button btn;
	private TextField tf;
	
	private Button btn1, btn2;
	//private Button [] buttons = new Button[2];
	
	public MyWindow() {
		
		// 여러 개의 컴포넌트를 묶어줄 Container 생성
		Panel p = new Panel();
		
		// 컴포넌트들을 생성
		btn = new Button("클릭");
		tf = new TextField(30);
		
		// 버튼의 이벤트 처리를 위한 ActionListener 인터페이스의 Anonymous Class 생성
		ActionListener listener = new ActionListener() {
			// Override 직접 쓸 필요 없이 Add implements (직접 타이핑은 에러 발생 가능성)
			// 버튼을 누르거나 텍스트필드에서 Return을 누르거나 메뉴를 누를 때 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 입력한 내용 가져오기
				String msg = tf.getText();
				// 출력
				System.out.println(msg);
				
			}
			
		};
		
		// btn에서 Action 이벤트가 발생하면 listener가 대신 처리하도록 위임(Delegation)
		//btn.addActionListener(listener); // 간단하게 끝
		// 주석 처리시 클릭 버튼 눌러도 반영 안 됨(다른 이벤트 처리방식을 위해 잠시 주석처리)
		
		// 이벤트 처리를 위한 인스턴스 생성
		EventHandler handler = new EventHandler(tf);
		// EventHanlder.java의  tf와 같아짐
		btn.addActionListener(handler); // 처리 완료
		
		// 컴포넌트들을 컨테이너에 배치
		p.add(tf);
		p.add(btn);
		
		// 버튼을 생성해서 패널에 추가
		btn1 = new Button("버튼1");
		p.add(btn1);
		
		btn2 = new Button("버튼2");
		p.add(btn2);
		
		/*
		// 버튼의 이벤트 처리 - 라우팅 이용하지 않는 경우
		ActionListener event1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1을 클릭했습니다.");
				
			}
			
		};
		btn1.addActionListener(event1);
		
		ActionListener event2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2를 클릭했습니다.");
				
			}
			
		};
		btn2.addActionListener(event2);
		*/
		
		// 버튼의 이벤트 처리 - 이벤트 라우팅을 이용하는 방법
		ActionListener eventRouting = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand() + " 예약");
				/*switch(arg0.getActionCommand()) {
				case "버튼1" :
					System.out.println("버튼1을 클릭했습니다.");
					break;
					
				case "버튼2" :
					System.out.println("버튼2를 클릭했습니다.");
					break;
				}*/
				
			}
			
		};
		btn1.addActionListener(eventRouting);
		btn2.addActionListener(eventRouting);
		
		// TextField나 TextArea의 문자열이 변경될 때 처리를 위한 메소드
		TextListener t1 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent arg0) {
				// TextField에 입력된 문자열 가져오기
				String msg = tf.getText();
				// 대소문자 숫자, 특수문자 개수를 저장할 변수 생성
				int dae = 0;
				int so = 0;
				int su = 0;
				int etc = 0;
				
				// 문자열을 문자단위로 접근
				for(int i = 0; i < msg.length(); i++) {
					// 앞에서부터 한글자씩 가져오기
					char ch = msg.charAt(i);
					//System.out.println(ch);
					if (ch >= 'A' && ch <= 'Z') {
						dae++;
					} else if (ch >= 'a' && ch <= 'z') {
						so++;
					} else if (ch >= '0' && ch <= '9') {
						su++;
					} else {
						etc++;
					}
				}
				if(dae*so*su*etc != 0) {
				 //(dae > 0 && so > 0 && su > 0 && etc > 0) {
					System.out.println("강함");
				} else {
					System.out.println("약함");
				}
				
			}
			
		};
		tf.addTextListener(t1); // tf의 TextListener 모두 처리
		
		
		// 컨테이너를 윈도우에 배치
		add(p);
		
		// Frame 기본 설정
		setTitle("이벤트 처리");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
	}

}
