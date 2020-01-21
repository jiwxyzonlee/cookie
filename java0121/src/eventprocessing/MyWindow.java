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
		
		// ���� ���� ������Ʈ�� ������ Container ����
		Panel p = new Panel();
		
		// ������Ʈ���� ����
		btn = new Button("Ŭ��");
		tf = new TextField(30);
		
		// ��ư�� �̺�Ʈ ó���� ���� ActionListener �������̽��� Anonymous Class ����
		ActionListener listener = new ActionListener() {
			// Override ���� �� �ʿ� ���� Add implements (���� Ÿ������ ���� �߻� ���ɼ�)
			// ��ư�� �����ų� �ؽ�Ʈ�ʵ忡�� Return�� �����ų� �޴��� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// �Է��� ���� ��������
				String msg = tf.getText();
				// ���
				System.out.println(msg);
				
			}
			
		};
		
		// btn���� Action �̺�Ʈ�� �߻��ϸ� listener�� ��� ó���ϵ��� ����(Delegation)
		//btn.addActionListener(listener); // �����ϰ� ��
		// �ּ� ó���� Ŭ�� ��ư ������ �ݿ� �� ��(�ٸ� �̺�Ʈ ó������� ���� ��� �ּ�ó��)
		
		// �̺�Ʈ ó���� ���� �ν��Ͻ� ����
		EventHandler handler = new EventHandler(tf);
		// EventHanlder.java��  tf�� ������
		btn.addActionListener(handler); // ó�� �Ϸ�
		
		// ������Ʈ���� �����̳ʿ� ��ġ
		p.add(tf);
		p.add(btn);
		
		// ��ư�� �����ؼ� �гο� �߰�
		btn1 = new Button("��ư1");
		p.add(btn1);
		
		btn2 = new Button("��ư2");
		p.add(btn2);
		
		/*
		// ��ư�� �̺�Ʈ ó�� - ����� �̿����� �ʴ� ���
		ActionListener event1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư1�� Ŭ���߽��ϴ�.");
				
			}
			
		};
		btn1.addActionListener(event1);
		
		ActionListener event2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư2�� Ŭ���߽��ϴ�.");
				
			}
			
		};
		btn2.addActionListener(event2);
		*/
		
		// ��ư�� �̺�Ʈ ó�� - �̺�Ʈ ������� �̿��ϴ� ���
		ActionListener eventRouting = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand() + " ����");
				/*switch(arg0.getActionCommand()) {
				case "��ư1" :
					System.out.println("��ư1�� Ŭ���߽��ϴ�.");
					break;
					
				case "��ư2" :
					System.out.println("��ư2�� Ŭ���߽��ϴ�.");
					break;
				}*/
				
			}
			
		};
		btn1.addActionListener(eventRouting);
		btn2.addActionListener(eventRouting);
		
		// TextField�� TextArea�� ���ڿ��� ����� �� ó���� ���� �޼ҵ�
		TextListener t1 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent arg0) {
				// TextField�� �Էµ� ���ڿ� ��������
				String msg = tf.getText();
				// ��ҹ��� ����, Ư������ ������ ������ ���� ����
				int dae = 0;
				int so = 0;
				int su = 0;
				int etc = 0;
				
				// ���ڿ��� ���ڴ����� ����
				for(int i = 0; i < msg.length(); i++) {
					// �տ������� �ѱ��ھ� ��������
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
					System.out.println("����");
				} else {
					System.out.println("����");
				}
				
			}
			
		};
		tf.addTextListener(t1); // tf�� TextListener ��� ó��
		
		
		// �����̳ʸ� �����쿡 ��ġ
		add(p);
		
		// Frame �⺻ ����
		setTitle("�̺�Ʈ ó��");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
	}

}
