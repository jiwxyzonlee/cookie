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
	// ��ư ����
	private Button btn;
	// ��ư ���� ���� Button [] btn
	
	
	// ������ üũ�ϴ� ���� ��ư
	private Checkbox man, woman;
	public ButtonWindow() {
		
		setTitle("��ư ������");
		setLocation(100, 100);
		setSize(300, 300);
		
		Panel p = new Panel();
		
		btn = new Button("��ư");
		//btn = new Button("��ư ��ư ��ư ��ư");
		//btn.setLabel("��ư1");
		// ��ư�� �гο� �߰�		
		// �ѱ� ������ window-preferences-workspace-ms949
		p.add(btn);
		
		CheckboxGroup group = new CheckboxGroup();
		
		man = new Checkbox("����", group, true);
		woman = new Checkbox("����", group, false);
		p.add(man);
		p.add(woman);
		
		// ���̺� �߰�
		Label label = new Label("�ȳ��ϼ���");
		p.add(label);
		
		// ��ư 200�� �־��(��ũ�ѹ� ������ �ؼ�)
		for (int i = 0; i < 200; i++) {
			Button button = new Button("��ư (" + i + ")");
			p.add(button);
		}
		// ����� ������ �θ��� ū ��� ��ũ���� ������ ������Ʈ�� ��ġ�ϰ�
		// ��ũ���� ������ ������Ʈ�� �θ� ��ġ
		
		/* ��ũ�ѹٴ� �׳� add(p)�ϸ� �ȵ�
		// �г��� �����쿡 �߰�
		add(p); */
		
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.add(p);
		
		add(sp);
		
		// �޴��� ����
		MenuBar menuBar = new MenuBar();
		//�޴� ����
		Menu menu = new Menu("����");
		// �޴� ������ ����
		MenuItem item = new MenuItem("����");
		menu.add(item);
		
		// ��Ʃ�ٿ� �޴� ����
		menuBar.add(menu);
		// �����ӿ� �޴��� ����
		setMenuBar(menuBar);
		
		FileDialog open = new FileDialog(this, "����", FileDialog.LOAD);
		// �⺻ ���丮 ����
		open.setDirectory("C:\\");
		open.setVisible(true);
		// ������ ���� ��� ����ϱ�
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
		
		String [] lbls = {"�ȳ��ϼ���", "���ϼ����", "�ϼ���ȳ�", "����ȳ���", "��ȳ��ϼ�"};
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
		// 5�� �Ŀ� ��ư�� ���̺� ����
		try {
			Thread.sleep(5000);
			btn.setLabel("��ư ���� ����");
			// �ش� ���� ���� ���� "��ư"�κ� �ٲ� ���� ����Ȯ��
			// "��ư" -> "��ư��ư��ư"
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
