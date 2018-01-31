package com.xt.message;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.xt.message.tcp.TcpClient;
import com.xt.message.tuxedo.TuxedoClient;
import com.xt.message.vo.ParamVO;

/**
 * 
 * Copyright: Copyright (c) 2011 Company: xiongtao
 * 
 * @author ���� tao.xiong  E-mail:yiwang3_26@163.com
 * @date 2018��1��29������11:45:34
 * @version 1.0
 * @description ��������: 
 */
public class Main extends JFrame implements WindowListener{

	private static final long serialVersionUID = 3832422801288560154L;
	
	final static String TCP = "TCP";
	final static String TUXEDO = "TUXEDO";
	final static String UTF_8 = "UTF-8";
	final static String GBK = "GBK";

	JFrame f = new JFrame();
	JPanel p1 = null;
	JTextField t1 = null;
	JTextField t2 = null;
	JTextField t3 = null;
	JTextField t4 = null;
	JTextArea t7 = null;
	JTextArea t8 = null;
	
	JComboBox<String> c5 = null;
	JComboBox<String> c6 = null;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		
		//����windows����look and feel
	    try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
//			e.printStackTrace();
			t8.setText(e.toString());
		}
	    
		f.setTitle("Java Tuxdeo And Tcp ���Թ���");	// ���˴���ı�������Ϊָ�����ַ���
		f.setResizable(false);	// ���ô˴����Ƿ�����û�������С
		f.setSize(1702, 1000);	// ��������Ĵ�С��ʹ����Ϊ 1700���߶�Ϊ 1000
//		f.setIconImage(new ImageIcon("imgs/title.png").getImage());
		f.setIconImage(new ImageIcon(getClass().getResource("/imgs/title.png")).getImage());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ����Ĭ���˳�����
		
		p1 = new JPanel() {
			
			private static final long serialVersionUID = -3402624751240156291L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
//				ImageIcon ii = new ImageIcon("imgs/home.jpg");
				ImageIcon ii = new ImageIcon(getClass().getResource("/imgs/home.jpg"));
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
			
		};
		p1.setSize(1700, 1000);
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		UIManager.put("Label.font", new FontUIResource("�����п�", Font.PLAIN, 27));
		UIManager.put("Label.foreground", Color.BLACK);
		UIManager.put("TextField.font", new FontUIResource("����", Font.PLAIN, 26));
		UIManager.put("ComboBox.font", new FontUIResource("����", Font.PLAIN, 26));
		UIManager.put("Button.font", new FontUIResource("��������", Font.BOLD, 30));
		UIManager.put("TextArea.font", new FontUIResource("����", Font.PLAIN, 26));
		
		JLabel l1 = new JLabel("IP��ַ��", JLabel.RIGHT);
		l1.setBounds(40, 40, 140, 40);
		t1 = new JTextField(40);
		t1.setBounds(180, 40, 240, 40);
		t1.setText("9.1.11.53");
		
		JLabel l2 = new JLabel("�˿ڣ�", JLabel.RIGHT);
		l2.setBounds(520, 40, 120, 40);
		t2 = new JTextField(40);
		t2.setBounds(640, 40, 240, 40);
		t2.setText("60001");
		
		JLabel l3 = new JLabel("�����룺", JLabel.RIGHT);
		l3.setBounds(1000, 40, 140, 40);
		t3 = new JTextField(40);
		t3.setBounds(1140, 40, 240, 40);
		
		JLabel l4 = new JLabel("��ʱʱ�䣺", JLabel.RIGHT);
		l4.setBounds(40, 100, 140, 40);
		t4 = new JTextField(40);
		t4.setBounds(180, 100, 240, 40);
		t4.setText("2000");
		
		JLabel l5 = new JLabel("�ַ�����", JLabel.RIGHT);
		l5.setBounds(520, 100, 120, 40);
		c5 = new JComboBox<String>();
		c5.setBounds(640, 100, 240, 40);
		c5.addItem(GBK);
		c5.addItem(UTF_8);
		
		JLabel l6 = new JLabel("���ӷ�ʽ��", JLabel.RIGHT);
		l6.setBounds(1000, 100, 140, 40);
		c6 = new JComboBox<String>();
		c6.addItem(TCP);
		c6.addItem(TUXEDO);
		c6.setBounds(1140, 100, 240, 40);
		c6.addItemListener(new c6Listen());
		
		JLabel l7 = new JLabel("�����ģ�", JLabel.RIGHT);
		l7.setBounds(5, 160, 140, 40);
		t7 = new JTextArea("", 40, 160);
		t7.setLineWrap(true);		// �����Զ����й���
		t7.setWrapStyleWord(true);	// ������в����ֹ���
		
		JLabel l8 = new JLabel("Ӧ���ģ�", JLabel.RIGHT);
		l8.setBounds(855, 160, 140, 40);
		t8 = new JTextArea("Ӧ������Ϣ...", 40, 160);
		t8.setForeground(Color.GRAY);
		t8.setLineWrap(true);		// �����Զ����й���
		t8.setWrapStyleWord(true);	// ������в����ֹ���
		
		JScrollPane s1 = new JScrollPane();
		s1.setBounds(0, 200, 845, 749);
		s1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		s1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s1.setViewportView(t7);
		
		
		JScrollPane s2 = new JScrollPane();
		s2.setBounds(850, 200, 846, 749);
		s2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		s2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s2.setViewportView(t8);
		
		JButton b1 = new JButton("����");
		b1.setBounds(1480, 35, 100, 50);
		b1.addActionListener(new b1Listen());
		
		JButton b2 = new JButton("�ر�");
		b2.setBounds(1480, 95, 100, 50);
		b2.addActionListener(new b2Listen());

		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(c5);
		p1.add(l6);
		p1.add(c6);
		p1.add(l7);
		p1.add(l8);
		
		p1.add(s1);
		p1.add(s2);
		
		p1.add(b1);
		p1.add(b2);

		f.setLocationRelativeTo(null);	// ������ʾ
		f.setVisible(true);	// ��ʾ����
		f.add(p1);
		
	}
	
	private class b1Listen implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String reqMsg = t7.getText();
			if(null == reqMsg || "".equals(reqMsg)) {
				// ���ð�ť��ʾЧ��
				UIManager.put("OptionPane.buttonFont", new FontUIResource("����", Font.PLAIN, 25));
				// �����ı���ʾЧ��
				UIManager.put("OptionPane.messageFont", new FontUIResource("����", Font.PLAIN, 22));
				JOptionPane.showMessageDialog(f, "<html><h1 color='red'>��ʾ��</h1><b color='GRAY'>���������Ĳ���Ϊ��...</b></html>");
				return;
			}
			
			String txType = c6.getSelectedItem().toString();
			ParamVO param = new ParamVO();
			param.setIp(t1.getText().trim());
			param.setPort(Integer.parseInt(t2.getText()));
			param.setOutTime(t4.getText().trim());
			param.setCharSet(c5.getSelectedItem().toString());
			param.setReqMsg(reqMsg);
			t8.setText("");
			t8.setForeground(Color.BLACK);
			if(TCP.equals(txType)) {
				t8.setText(new TcpClient().callClient(param));
			}else if (TUXEDO.equals(txType)) {
				param.setSvrName(t3.getText().trim());
				t8.setText(new TuxedoClient().callClient(param));
			}
			
		}
		
	}
	
	private class b2Listen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	public class c6Listen implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(TCP.equals(c6.getSelectedItem())) {
				t1.setText("9.1.11.53");
				t2.setText("60001");
				t3.setText("");
				c5.setSelectedItem(GBK);
				t7.setText("");
				t8.setForeground(Color.GRAY);
				t8.setText("Ӧ������Ϣ...");
			}else if (TUXEDO.equals(c6.getSelectedItem())) {
				t1.setText("//9.1.11.49:16931");
				t2.setText("16931");
				t3.setText("NCS2");
				c5.setSelectedItem(UTF_8);
				t7.setText("");
				t8.setForeground(Color.GRAY);
				t8.setText("Ӧ������Ϣ...");
			}
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
