package eventprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {
	// global 변수는 자동초기화됨(local 작성시 null 반드시 써줘야 함)
	JLabel lbl;
	ImageIcon icon;
	JButton btn;
	// 애니메이션을 수행할 스레드 변수
	Thread th;
	public MyFrame() {
		// 단순한 메시지 출력 : 리턴값 없음
		/*JOptionPane.showMessageDialog(this, "메시지", "제목"
				, JOptionPane.ERROR_MESSAGE);*/
		
		/*
		// 2개 이상의 버튼을 배치해서 confirm을 받는 메소드
		int result = JOptionPane.showConfirmDialog(this, "정말로 삭제", "삭제"
				, JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			
		} else if (result == JOptionPane.NO_OPTION) {
			
		} else if (result == JOptionPane.CANCEL_OPTION) {
			
		}
		*/
		
		// 한 줄의 텍스트를 입력받는 대화상자를 출력
		// 입력한 내용이 없는 상태에서 확인을 누르면 ""
		// null이 나오면 잘못된 것
		String name = JOptionPane.showInputDialog(this
				, "이름을 입력하세요", "");
		System.out.println(name);
		
		JPanel p = new JPanel();
		//JLabel lbl = new JLabel("문자열");
		
		
		// 이미지를 가지고 아이콘을 생성
		// 이미지 파일 크기 그대로 생성
		icon = new ImageIcon("C:\\Users\\admin\\Documents\\java\\"
				+ "200121\\1.png");
		JLabel lbl = new JLabel(icon);
		p.add(lbl);
		
		// 버튼을 만들어서 패널에 추가
		btn = new JButton("시작");
		p.add(btn);
		
		// 버튼을 누를 때 이벤트 처리를 위한 인스턴스 생성
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(arg0.getActionCommand()) {
				case "시작" :
					btn.setText("중지");
					
					// 스레드를 생성헤서 시작
					th = new Thread() {
						// 이미지 파일이 규칙없이 뒤죽박죽일 때는
						// String [] images = {"여기에 나열하기", "불러내기는 아래에"};
						public void run() {
							try {
								int i = 0;
								while (true) {
									// 0.1초마다 대기
									Thread.sleep(100);
									// 아이콘 생성
									icon = new ImageIcon("C:\\Users\\admin"
											+ "\\Documents\\java\\200121"
											+ "\\image\\" + (i % 10) + ".png");
									
									/*// 뒤죽박죽인 이미지 불러내기
									icon = new ImageIcon("C:\\Users\\admin"
											+ "\\Documents\\java\\200121\\" 
											+ images[i % images.length]);*/
									
									lbl.setIcon(icon);
									i++;
								}
							}catch (InterruptedException e) {
								return;
							}
						}
					};
					th.start();
					break;
				case "중지" :
					btn.setText("시작");
					
					// 스레드를 중지
					th.interrupt();
					
					break;
				}
				
			}
			
		};
		btn.addActionListener(listener);
		
		
		// 테이블에 출력할 컬럼 이름 배열
		String [] columnNames = {"이름", "전화번호", "주소"};
		String [][] data = {{"김갹갹", "01012538253", "서울시 서대문구 대현동"},
				{"이뿅뿅", "01052528282", "서울시 성동구 하왕십리동"}};
		
		// 데이터를 가지고 테이블 모델을 생성
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		// 테이블 모델을 가지고 테이블 생성
		JTable table = new JTable(model);
		
		// 테이블은 데이터가 무한으로 늘어나는 게 가능해서 상위 컨테이너의 크기를 넘어설 수도 있음
		// 따라서 바로 패널이나 프레임에 배치하지 않고 JScrollPane과 배치하는 것을 권장
		JScrollPane sp = new JScrollPane(table);
		p.add(sp);
		
		add(p);
		
		// 메뉴를 만들 때는 visible 이전에 위치
		// 메뉴바 -> 메뉴 -> 메뉴아이템 순
		JMenuBar bar = new JMenuBar();
		
		JMenu menu = new JMenu("메뉴(T)");
		// ALT + t를 별도의 단축키로 설정하면 단축키는 동작하지 않음
		// 단축키 설정
		menu.setMnemonic('t');
		
		// 메뉴 항목 만들기
		JMenuItem item = new JMenuItem("메시지 출력");
		// 메뉴 아이템의 이벤트 처리는 버튼과 같음
		// ActionListener 이용
		// Anonymous Class 안에서 this는 자기 자신임
		ActionListener itemListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 내부 클래스에서 외부 클래스의 인스턴스를 호출할 때는
				// 외부 클래스이름.this라고 함
				// 안드로이드에서는 이벤트 처리를 많이 하고
				// 메모리 절약을 위해서 anonymous를 많이 사용하기 때문에
				// 외부 클래스의 인스턴스를 호출해야 하는 상황이 많아서 이 문법 꼭 명심
				JOptionPane.showMessageDialog(MyFrame.this, "메뉴를 누름");
				// 단순히 this만 쓰는 건 안됨
			}
		};
		item.addActionListener(itemListener);
		item.setToolTipText("메시지 박스를 출력합니다.");
		
		menu.add(item);
		bar.add(menu);
		this.setJMenuBar(bar);
		
		setTitle("이미지 레이블");
		setLocation(100, 100);
		setSize(1000, 1000);
		setVisible(true);
		
		// 종료 기능 부여 ( <<new!>> )
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		int i = 0;
		while (true) {
			try {
				Thread.sleep(1000);
				icon = new ImageIcon("C:\\Users\\admin\\Documents"
						+ "\\java\\200121\\image\\" + (i % 10) + ".png");
				icon = new ImageIcon("C:\\Users\\admin\\Documents"
						+ "\\java\\200121\\" + (i % 3) + ".png");
				// 그림 0,1,2 로 제목 지어야 끊김 없이 나옴
				lbl.setIcon(icon);
				i++;
			} catch (Exception e) {}
		}
		
		// 이미지 교체 애니메이션
		String [] images = {"1.png", "2.png", "3.png"};
		
		while (true) {
			int i = 0;
			try {
				Thread.sleep(50);
				i++;
				icon = new ImageIcon("C:\\Users\\admin\\Documents"
						+ "\\java\\200121\\" + images[i % images.length]);
				lbl.setIcon(icon);
				
			} catch (Exception e) {}
		}*/
	}

}
