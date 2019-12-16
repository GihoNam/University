package gui_finaltest;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class StartPage extends JFrame{
	ImageIcon icon;
	String []movie_name = {"날씨의아이","터미네이터","신의한수","라스트크리스마스","쥬만지","포드v페라리"};
	public StartPage() {
		icon = new ImageIcon("MainBack.png");
		ImageIcon icon_2 = new ImageIcon("CenterBack2.png");
	this.setTitle("영화관 예매 프로그램");
	this.setSize(800,450);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel movie_main = new JPanel(){
        public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
        }
    };
    JPanel movie_list = new JPanel(){
        public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon_2.getImage(), 0, 0, null);
            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
        }
    };
    movie_main.setLayout(new FlowLayout(FlowLayout.LEFT,60,40));
	movie_list.setLayout(new GridLayout(2,4,0,13));
	//movie_list.setPreferredSize(new Dimension(800,450));
	movie_main.add(movie_list);
	this.add(movie_main);
	movie_list.setBackground(new Color(255,0,0,0));
	//gbc.fill = GridBagConstraints.VERTICAL;
	for(int i=0;i<4;i++) {
		String name = movie_name[i];
		String movie_name = "picture/"+ Integer.toString(i) + ".PNG";
		JLabel movie_Icon = new JLabel();
		movie_Icon.setIcon(new ImageIcon(movie_name));
		movie_list.add(movie_Icon);
		JButton book1 = new JButton();
		book1.setIcon(new ImageIcon("button.png"));
		book1.setBorderPainted(false);
		book1.setFocusPainted(false);
		book1.setContentAreaFilled(false);
		book1.setBackground(new Color(255,0,0,0));
		book1.setOpaque(false);
		book1.setPreferredSize(new Dimension(165,120));
		book1.addActionListener(new Movie1Event());
		book1.setText(name);
		movie_list.add(book1);
		JLabel blank = new JLabel();
		blank.setIcon(new ImageIcon("NullBox25,png"));
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
