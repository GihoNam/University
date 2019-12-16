package gui_finaltest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MiddlePage extends JFrame {
	
	//String date_month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};		// 날짜 가져오기
	String date_month[] = {"11"};
	String date_day[] = {"1","2","3","4","5","6","7","8","9"						// 날짜 가져오기
			,"10","11","12","13","14","15","16","17","18"
			,"19","20","21","22","23","24","25","26","27"
			,"28","29","30","31"};
	String Remainingseat = "24/100";			// 남은 좌석 가져오기
	String time = "10:00 ~ 12:20";				// 날짜별 영화 상영시간 가져오기
	
	JComboBox<String> month = new JComboBox<String>(date_month);
	JComboBox<String> day = new JComboBox<String>(date_day);
	JLabel month1 = new JLabel("월 ");
	JLabel day1 = new JLabel("일 ");
	JLabel chair = new JLabel("남은 좌석 수 : "+Remainingseat);
	JLabel time1 = new JLabel("시간 : " + time);
	
	public MiddlePage(String b) {
		ActionPage(b, true);
	}
	
	public void ActionPage(String movie,boolean select) {
		System.out.println(movie);
		ImageIcon icon = new ImageIcon("MainBack.png");
		JPanel backgorund = new JPanel(){
	        public void paintComponent(Graphics g) {
	            // Approach 1: Dispaly image at at full size
	            g.drawImage(icon.getImage(), 0, 0, null);
	            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	            super.paintComponent(g);
	        }
	    };
		JPanel mainpanel = new JPanel();
		JPanel uppanel = new JPanel();
		JPanel rightpanel = new JPanel();
		JPanel leftpanel = new JPanel();
		

		rightpanel.setPreferredSize(new Dimension(300,250));
		leftpanel.setPreferredSize(new Dimension(300,250));
		mainpanel.setLayout(new BorderLayout());
		mainpanel.setOpaque(false);
		uppanel.setOpaque(false);
		leftpanel.setOpaque(false);
		rightpanel.setOpaque(false);
		month.addActionListener(new ComboEvent(movie));
		uppanel.add(month1);
		uppanel.add(month);
		
		day.addActionListener(new ComboEvent(movie));
		uppanel.add(day1);
		uppanel.add(day);
		
		//StartPage.contentPane.add(panel);		// StartPage에 붙이는 방법을 모르겠다.
		mainpanel.add(uppanel, "North");
		mainpanel.add(leftpanel, "West");
		mainpanel.add(rightpanel, "East");
		backgorund.add(mainpanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 450);
		this.add(backgorund);
		this.setVisible(true);
	}
	class ComboEvent implements ActionListener{
		
		String name;
		
		public ComboEvent(String movie_name) {
			name = movie_name;
		}

		@Override
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String combo = e.getActionCommand();
			MiddlePage.this.setVisible(false);
			new FinalPage(name);
		}
	}

}