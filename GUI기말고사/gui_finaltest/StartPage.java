package gui_finaltest;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class StartPage extends JFrame{
	String []movie_name = {"날씨의 아이","터미네이터","신의한수"};
	
	public StartPage() {
	
	this.setTitle("영화관 예매 프로그램");
	this.setSize(800,450);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel movie_list = new JPanel();
	movie_list.setLayout(new BoxLayout(movie_list,BoxLayout.Y_AXIS));
	movie_list.setPreferredSize(new Dimension(800,450));
	//movie1.setLayout(new GridLayout());
	//movie2.setLayout(new GridLayout());
	//movie2.setPreferredSize(new Dimension(650,150));
	this.add(movie_list);
	
	for(int i=0;i<3;i++) {
		JPanel movie_panel = new JPanel();
		//movie_panel.setLayout();
		String name = movie_name[i];
		String movie_name = "picture/"+ Integer.toString(i) + ".PNG";
		JLabel movie_Icon = new JLabel("");
		movie_Icon.setIcon(new ImageIcon(movie_name));
		movie_panel.add(movie_Icon);
		JLabel text = new JLabel("예약하러 가기 : ");
		movie_panel.add(text);
		JButton book1 = new JButton(name);
		book1.addActionListener(new Movie1Event());
		movie_panel.add(book1);
		movie_list.add(movie_panel);
	}
    
    this.setVisible(true);
}
public static void main(String[] args) {
	new StartPage();
}

class Movie1Event implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
    	contentPane.removeAll();//모든 컴포넌트를 지움
    	contentPane.revalidate();
    	contentPane.repaint();//다시 그려줌
        */
		
			StartPage.this.setVisible(false);
			String b = e.getActionCommand();
		
			new MiddlePage(b);
		}
	}

}
