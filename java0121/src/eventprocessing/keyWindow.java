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
		
		// ������Ʈ���� ��ġ �����̳� ũ�� ������ �����ϵ���
		// ���̾ƿ��� null�� ����
		setLayout(null);
		
		// ���̺��� �����ϰ� ��ġ
		lbl = new Label("@");
		lbl.setLocation(20, 30);
		lbl.setSize(15, 15);
		add(lbl);
		
		// ��Ʈ����ó�� �ڵ����� �������� �����
		// ���̺��� 1�ʸ��� �Ʒ��� 5��ŭ�� �̵��ϴ� ������
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
		
		// Ű���� �̺�Ʈ ó���� ���� �ν��Ͻ� ����
		KeyListener listener = new KeyListener() {

			// Ű���� ������ �� ȣ��
			@Override
			public void keyPressed(KeyEvent arg0) {
				// ����Ű Ȯ��
				int modifiers = arg0.getModifiers();
				// control + X �̸� ����
				// control Ű�� ���������� Ȯ��
				if ((modifiers & 2)!= 0) {
					// ������ ���� Ű�� X���� Ȯ��
					// ��ҹ��� �����ϰ� �ʹٸ� getKeyChar() ���
					int key = arg0.getKeyCode();
					if ( key == KeyEvent.VK_X) {
						System.exit(0);
					}
				}
				System.out.println(modifiers);
				
				//System.out.println("�ƹ� Ű�� ������ ȣ��˴ϴ�.");
				// keyChar�� ��ҹ��� ����(a->a, A->A)
				//System.out.println(arg0.getKeyChar());
				// keyCode�� ��ҹ��� ���� �� ��(a->65, A->65)
				//System.out.println(arg0.getKeyCode());
				
				// ���� ���̺��� ��ġ ��������
				int x = lbl.getLocation().x;
				int y = lbl.getLocation().y;
				
				// ���� Ű���� �� ��������
				int code = arg0.getKeyCode();
				
				switch(code) {
				case KeyEvent.VK_UP:  // �� ȭ��ǥ
					y = y - 5;
					break;
				case KeyEvent.VK_DOWN: // �Ʒ� ȭ��ǥ
					y = y + 5;
					break;
				case KeyEvent.VK_LEFT: // ���� ȭ��ǥ
					x = x - 5;
					break;
				case KeyEvent.VK_RIGHT: // ������ ȭ��ǥ
					x = x + 5;
					break;
				}
				lbl.setLocation(x, y);
				
			}

			// Ű���忡�� ���� �� �� ȣ��
			@Override
			public void keyReleased(KeyEvent arg0) {
				//System.out.println("Ű���忡�� ���� ���� ������ ȣ��");
				
			}

			// ���� Ű�� ������ �� ȣ��
			@Override
			public void keyTyped(KeyEvent arg0) {
				//System.out.println("���� Ű�� ������ �� ȣ��");
				
			}
			
		};
		// �����쿡 Ű���� �̺�Ʈ ������ ����
		this.addKeyListener(listener);
		
		setTitle("Ű���� �̺�Ʈ");
		setLocation(100, 100);
		setSize(400, 400);
		setVisible(true);
		
		WindowAdapter windowListener = new WindowAdapter() {
			// Listener�� �������̽��̱� ������ �޼ҵ� �ϳ��� ����� ���� ��
			// Listener�� �������̽��� ��� �޼ҵ带 �����ؾ� ������
			// Adapter�� �߻�Ŭ������ �߻�޼ҵ�� �ʿ��� �޼ҵ常 �����ϸ� ��
			// ���� ��ư�� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {
				// ���α׷� ����
				System.exit(0);
				
			}
			
		};
		// ������ �̺�Ʈ ����
		this.addWindowListener(windowListener);
	}

}
