package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class MainWindow extends Frame {
	public MainWindow() {
		// ���� ���� ������Ʈ���� �÷� ���� �� �ִ� �г��� ����
		Panel northPanel = new Panel();
		// ���̺�� �ؽ�Ʈ �ʵ带 ���� �гο� ��ġ
		// �г��� FlowLayout �̶� ������� ��ġ
		Label lblTitle = new Label("����");
		TextField txtTitle = new TextField(30); //�ʺ���
		// ȭ�鿡 ���̴� ���� ����
		txtTitle.setEchoChar('*');
		// setEchoChar ��� ���������� ����
		northPanel.add(lblTitle);
		northPanel.add(txtTitle);
		
		// �������� BorderLayout�̶� ����� �Բ� ��ġ
		// �г��� ���ʿ� ��ġ
		add("North", northPanel);
		
		Panel centerPanel = new Panel();
		Label lblContent = new Label("����");
		TextArea taContent = new TextArea(10, 30); //���
		centerPanel.add(lblContent);
		centerPanel.add(taContent);
		add("Center", centerPanel);
		
		Panel southPanel = new Panel();
		// �г��� ���̾ƿ� ����
		// ���� ������ �����ϸ� ���̳� ���� ������ �÷��� ��ġ
		southPanel.setLayout(new GridLayout(2, 2)); //���
		for (int i = 0; i < 2 ; i++) {
			Button button = new Button("��ư " + i);
			southPanel.add(button);
		}
		add("South", southPanel);
		
		setTitle("�Խ��� �Է�");
		setLocation(100, 100);
		setSize(400, 500);
		setResizable(false); // ũ�� ���� ���� ����
		setVisible(true);
	}

}
