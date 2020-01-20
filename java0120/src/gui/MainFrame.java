package gui;

import java.awt.Color;
import java.awt.Frame;

public class MainFrame {

	public static void main(String[] args) {
		// 윈도우 생성
		Frame f = new Frame();
		
		// 좌표 설정
		f.setLocation(100, 100);
		
		// 윈도우 크기 설정
		// 기본 크기가 0,0이므로 크기를 설정하지 않으면 출력 안 됨
		f.setSize(500, 500);
		
		// 윈도우 이름 설정
		f.setTitle("처음 만들어 본 윈도우");
		// 윈도우 색 설정
		//f.setBackground(Color.GREEN);
		// new Color(int r, int g, int b)
		f.setBackground(new Color(225, 200, 250));
		
		// 윈도우를 화면에 출력
		// 기본적으로 보이지 않게 설정되어 잇으므로 이 메소드를 호출해야 보임
		f.setVisible(true);

	}

}
