package gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ButtonWindow extends Frame {
	// 버튼 변수
	private Button btn;
	// 버튼 여러 개는 Button [] btn
	
	
	// 성별을 체크하는 라디오 버튼
	private Checkbox man, woman;
	public ButtonWindow() {
		
		setTitle("버튼 윈도우");
		setLocation(100, 100);
		setSize(300, 300);
		
		Panel p = new Panel();
		
		btn = new Button("버튼");
		//btn = new Button("버튼 버튼 버튼 버튼");
		//btn.setLabel("버튼1");
		// 버튼을 패널에 추가		
		// 한글 깨지면 window-preferences-workspace-ms949
		p.add(btn);
		
		CheckboxGroup group = new CheckboxGroup();
		
		man = new Checkbox("남자", group, true);
		woman = new Checkbox("여자", group, false);
		p.add(man);
		p.add(woman);
		
		// 레이블 추가
		Label label = new Label("안녕하세요");
		p.add(label);
		
		// 버튼 200개 넣어보기(스크롤바 만들어야 해서)
		for (int i = 0; i < 200; i++) {
			Button button = new Button("버튼 (" + i + ")");
			p.add(button);
		}
		// 출력할 내용이 부모모다 큰 경우 스크롤이 가능한 컴포넌트에 배치하고
		// 스크롤이 가능한 컴포넌트를 부모에 배치
		
		/* 스크롤바는 그냥 add(p)하면 안됨
		// 패널은 윈도우에 추가
		add(p); */
		
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		
		add(sp);
		
		// 메뉴바 생성
		MenuBar menuBar = new MenuBar();
		//메뉴 생성
		Menu menu = new Menu("파일");
		// 메뉴 아이템 생성
		MenuItem item = new MenuItem("열기");
		menu.add(item);
		
		// 메튜바에 메뉴 부착
		menuBar.add(menu);
		// 프레임에 메뉴바 부착
		setMenuBar(menuBar);
		
		FileDialog open = new FileDialog(this, "열기", FileDialog.LOAD);
		// 기본 디렉토리 설정
		open.setDirectory("C:\\");
		open.setVisible(true);
		// 선택한 파일 경로 출력하기
		System.out.println(open.getDirectory() + open.getFile());
		try {
			BufferedReader br = new BufferedReader(
		
				new InputStreamReader(
						new FileInputStream(
								open.getDirectory() + open.getFile())));
		String line = br.readLine();
		System.out.println(line);
		}catch (Exception e) {}
		
		setVisible(true);
		
		String [] lbls = {"안녕하세요", "녕하세요안", "하세요안녕", "세요안녕하", "요안녕하세"};
		Color [] colors = {Color.RED, Color.BLUE, Color.GREEN};
		int j = 0;
		while(true) {
			Random r = new Random();
			try {
				Thread.sleep(1000);
				j++;
				label.setText(lbls[j % lbls.length]);
				//btn.setBackground(colors[j % colors.length]);
				btn.setBackground(colors[r.nextInt(colors.length)]);
			} catch(Exception e) {}
		}
		
		//Color [] colors = {Color.RED, Color.BLUE, Color.GREEN};
		
		/*
		// 5초 후에 버튼의 레이블 변경
		try {
			Thread.sleep(5000);
			btn.setLabel("버튼 글자 변경");
			// 해당 구문 수행 전에 "버튼"부분 바뀔 글자 공간확보
			// "버튼" -> "버튼버튼버튼"
		} catch (Exception e) {}*/
		
		/*
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000);
				btn.setBackground(colors[i%colors.length]);
				i++;
			} catch (Exception e) {}
		}*/
		
	}

}
