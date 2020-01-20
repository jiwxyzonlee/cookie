package gui;

import java.awt.Frame;
import java.awt.Label;

public class MoveComponent extends Frame {
	public MoveComponent() {
		// 레이아웃 null 설정
		setLayout(null);
		
		// 레이아웃이 null이기 때문에 좌표와 크기를 전부 설정해야 함
		Label lbl = new Label("@");
		lbl.setLocation(20, 100);
		lbl.setSize(20, 20);
		add(lbl);
		
		
		setTitle("컴포넌트 이동");
		setLocation(100, 100);
		setSize(400, 500);
		setResizable(false); // 크기 변경 제한 설정
		setVisible(true);
		
		// lbl 움직이기
		int sign = 20;
		while(true) {
			int x = lbl.getLocation().x;
			int y = lbl.getLocation().y;
			if (x == 400) {
				sign = -20;
			} else if (x==0) {
				sign = 20;
			}
			x = x + sign;
			
			try {
				Thread.sleep(1000);
				lbl.setLocation(x, y);
			} catch (Exception e) {}
			
		}
		
	}

}
