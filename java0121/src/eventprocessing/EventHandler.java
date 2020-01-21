package eventprocessing;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	private TextField tf;
	
	// ������: TextField 1���� ���Թ޴� ������
	// ���� : �ٸ� ������ �����͸� �������� ��
	public EventHandler(TextField tf) {
		this.tf = tf;
	}

	@Override
	// �̺�Ʈ ó���ϴ� �޼ҵ��� �Ű������� �̺�Ʈ�� �߻��� ��ü�� ���� ������
	// �̺�Ʈ ó���� �ʿ��� ������ �����ϰ� ����
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getModifiers());
		if((arg0.getModifiers() & 512) == 512) { //== ActionEvent.ALT_MASK) {
			System.out.println("ALT�� �Բ� �������ϴ�.");
		} else {
			System.out.println("ALT�� �Բ� ������ �ʾҽ��ϴ�.");
		}
		String msg = tf.getText(); // Error
		//MyWindow.java�� private TextField tf; �־ �����;� ��
		System.out.println(msg);

	}

}
