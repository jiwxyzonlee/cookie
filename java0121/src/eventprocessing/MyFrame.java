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
	// global ������ �ڵ��ʱ�ȭ��(local �ۼ��� null �ݵ�� ����� ��)
	JLabel lbl;
	ImageIcon icon;
	JButton btn;
	// �ִϸ��̼��� ������ ������ ����
	Thread th;
	public MyFrame() {
		// �ܼ��� �޽��� ��� : ���ϰ� ����
		/*JOptionPane.showMessageDialog(this, "�޽���", "����"
				, JOptionPane.ERROR_MESSAGE);*/
		
		/*
		// 2�� �̻��� ��ư�� ��ġ�ؼ� confirm�� �޴� �޼ҵ�
		int result = JOptionPane.showConfirmDialog(this, "������ ����", "����"
				, JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			
		} else if (result == JOptionPane.NO_OPTION) {
			
		} else if (result == JOptionPane.CANCEL_OPTION) {
			
		}
		*/
		
		// �� ���� �ؽ�Ʈ�� �Է¹޴� ��ȭ���ڸ� ���
		// �Է��� ������ ���� ���¿��� Ȯ���� ������ ""
		// null�� ������ �߸��� ��
		String name = JOptionPane.showInputDialog(this
				, "�̸��� �Է��ϼ���", "");
		System.out.println(name);
		
		JPanel p = new JPanel();
		//JLabel lbl = new JLabel("���ڿ�");
		
		
		// �̹����� ������ �������� ����
		// �̹��� ���� ũ�� �״�� ����
		icon = new ImageIcon("C:\\Users\\admin\\Documents\\java\\"
				+ "200121\\1.png");
		JLabel lbl = new JLabel(icon);
		p.add(lbl);
		
		// ��ư�� ���� �гο� �߰�
		btn = new JButton("����");
		p.add(btn);
		
		// ��ư�� ���� �� �̺�Ʈ ó���� ���� �ν��Ͻ� ����
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(arg0.getActionCommand()) {
				case "����" :
					btn.setText("����");
					
					// �����带 �����켭 ����
					th = new Thread() {
						// �̹��� ������ ��Ģ���� ���׹����� ����
						// String [] images = {"���⿡ �����ϱ�", "�ҷ������ �Ʒ���"};
						public void run() {
							try {
								int i = 0;
								while (true) {
									// 0.1�ʸ��� ���
									Thread.sleep(100);
									// ������ ����
									icon = new ImageIcon("C:\\Users\\admin"
											+ "\\Documents\\java\\200121"
											+ "\\image\\" + (i % 10) + ".png");
									
									/*// ���׹����� �̹��� �ҷ�����
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
				case "����" :
					btn.setText("����");
					
					// �����带 ����
					th.interrupt();
					
					break;
				}
				
			}
			
		};
		btn.addActionListener(listener);
		
		
		// ���̺� ����� �÷� �̸� �迭
		String [] columnNames = {"�̸�", "��ȭ��ȣ", "�ּ�"};
		String [][] data = {{"�谽��", "01012538253", "����� ���빮�� ������"},
				{"�̻л�", "01052528282", "����� ������ �Ͽսʸ���"}};
		
		// �����͸� ������ ���̺� ���� ����
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		// ���̺� ���� ������ ���̺� ����
		JTable table = new JTable(model);
		
		// ���̺��� �����Ͱ� �������� �þ�� �� �����ؼ� ���� �����̳��� ũ�⸦ �Ѿ ���� ����
		// ���� �ٷ� �г��̳� �����ӿ� ��ġ���� �ʰ� JScrollPane�� ��ġ�ϴ� ���� ����
		JScrollPane sp = new JScrollPane(table);
		p.add(sp);
		
		add(p);
		
		// �޴��� ���� ���� visible ������ ��ġ
		// �޴��� -> �޴� -> �޴������� ��
		JMenuBar bar = new JMenuBar();
		
		JMenu menu = new JMenu("�޴�(T)");
		// ALT + t�� ������ ����Ű�� �����ϸ� ����Ű�� �������� ����
		// ����Ű ����
		menu.setMnemonic('t');
		
		// �޴� �׸� �����
		JMenuItem item = new JMenuItem("�޽��� ���");
		// �޴� �������� �̺�Ʈ ó���� ��ư�� ����
		// ActionListener �̿�
		// Anonymous Class �ȿ��� this�� �ڱ� �ڽ���
		ActionListener itemListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� Ŭ�������� �ܺ� Ŭ������ �ν��Ͻ��� ȣ���� ����
				// �ܺ� Ŭ�����̸�.this��� ��
				// �ȵ���̵忡���� �̺�Ʈ ó���� ���� �ϰ�
				// �޸� ������ ���ؼ� anonymous�� ���� ����ϱ� ������
				// �ܺ� Ŭ������ �ν��Ͻ��� ȣ���ؾ� �ϴ� ��Ȳ�� ���Ƽ� �� ���� �� ���
				JOptionPane.showMessageDialog(MyFrame.this, "�޴��� ����");
				// �ܼ��� this�� ���� �� �ȵ�
			}
		};
		item.addActionListener(itemListener);
		item.setToolTipText("�޽��� �ڽ��� ����մϴ�.");
		
		menu.add(item);
		bar.add(menu);
		this.setJMenuBar(bar);
		
		setTitle("�̹��� ���̺�");
		setLocation(100, 100);
		setSize(1000, 1000);
		setVisible(true);
		
		// ���� ��� �ο� ( <<new!>> )
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
				// �׸� 0,1,2 �� ���� ����� ���� ���� ����
				lbl.setIcon(icon);
				i++;
			} catch (Exception e) {}
		}
		
		// �̹��� ��ü �ִϸ��̼�
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
