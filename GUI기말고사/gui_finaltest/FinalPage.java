package gui_finaltest;

import java.awt.*;


import javax.swing.*;

public class FinalPage extends JFrame{
	public FinalPage(String b) {
		ActionPage(b,true);
	}
	public void ActionPage(String name,boolean a) {
		this.setTitle("üũ�ڽ�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,450);
	//	Container c = getContentPane(); 
		String filename1 = "chairnumber/";
		String filename2 = "abc/";
		String filename3 = "chair/";
		
		//Container panel2 = new Container();
		JPanel mainpanel = new JPanel();
		JPanel panel = new JPanel();			// ��ü ȭ��
		JPanel leftchair = new JPanel();		// ���� ����
		JPanel rightchair = new JPanel();		// ����������
		JPanel screan = new JPanel();			// ��ũ�� ȭ��
		JPanel centerwall = new JPanel();		// �߰���
		JPanel leftabc = new JPanel();			// �¼����ĺ�����
		JPanel server = new JPanel();
		JPanel number = new JPanel();			// ����
		
		
		//leftchair.setBackground(Color.blue); 
		//rightchair.setBackground(Color.green);
		 
		
		
		number.setLayout(new GridLayout(1,10,5,5));
		leftchair.setLayout(new GridLayout(10,5,5,5));
		rightchair.setLayout(new GridLayout(10,5,5,5));
		panel.setLayout(new GridLayout(1,2));
		mainpanel.setLayout(new FlowLayout());
		leftabc.setLayout(new GridLayout(10,1,5,5));
		server.setLayout(new BorderLayout());
		
		ImageIcon selectchair = new ImageIcon("chair/selectedchair.png");	// ���� ���É��� �� ������
		ImageIcon screanicon = new ImageIcon("chairnumber/Screan.png");			// ��ũ�� ������
		
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5;j++) {
				ImageIcon chair1 = new ImageIcon(filename3 + Integer.toString(j)+ ".png");
				JLabel l = new JLabel(chair1);
				leftchair.add(l);
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 5; j < 10;j++) {
				ImageIcon chair1 = new ImageIcon(filename3 + Integer.toString(j)+ ".png");
				JLabel l = new JLabel(chair1);
				rightchair.add(l);
			}
		}
		
		// abc �� ���� �ڱ�
		
		for(int i = 0; i < 10; i++) {
			ImageIcon chair1 = new ImageIcon(filename2 + Integer.toString(i)+ ".png");
			JLabel l = new JLabel(chair1);
			leftabc.add(l);
		}
		
		// ���� ������ ��
		
		for(int i = 0; i < 10; i++) {
			ImageIcon chair1 = new ImageIcon(filename1 + Integer.toString(i)+ ".png");
			JLabel l = new JLabel(chair1);
			number.add(l);
		}
		
		//panel.setLocation(0,0);
		
		
	//	panel.setBounds(100,200,250,250);
		//panel3.setBounds(450,200,250,250);
		
		leftchair.setPreferredSize(new Dimension(250,250));
		rightchair.setPreferredSize(new Dimension(250,250));
		
		server.add(number,"North");
		screan.add(new JLabel(screanicon));
		server.add(leftabc,"West");
	//	panel.add(screan,"North");
		panel.add(leftchair);
		panel.add(rightchair);
		server.add(screan,"North");
		server.add(panel,"Center");
		mainpanel.add(server,"CENTER");
		this.add(mainpanel);
		
		
		
		
		this.setVisible(a);
	}
	public static void main(String[] args) {
		new StartPage();
	}
	
}