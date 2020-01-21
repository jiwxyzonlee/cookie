package eventprocessing;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	private TextField tf;
	
	// 생성자: TextField 1개를 주입받는 생성자
	// 주입 : 다른 곳에서 데이터를 가져오는 것
	public EventHandler(TextField tf) {
		this.tf = tf;
	}

	@Override
	// 이벤트 처리하는 메소드의 매개변수는 이벤트가 발생한 객체에 대한 정보와
	// 이벤트 처리에 필요한 정보를 소유하고 있음
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getModifiers());
		if((arg0.getModifiers() & 512) == 512) { //== ActionEvent.ALT_MASK) {
			System.out.println("ALT와 함께 눌렀습니다.");
		} else {
			System.out.println("ALT와 함께 누르지 않았습니다.");
		}
		String msg = tf.getText(); // Error
		//MyWindow.java에 private TextField tf; 있어서 가져와야 함
		System.out.println(msg);

	}

}
