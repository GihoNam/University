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
	String []movie_name = {"������ ����","�͹̳�����","�����Ѽ�"};
	public StartPage() {
		icon = new ImageIcon("MoveiBack.png");
	this.setTitle("��ȭ�� ���� ���α׷�");
	this.setSize(800,450);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel movie_main = new JPanel(){
        public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
            super.paintComponent(g);
        }
    };
    JPanel movie_list = new JPanel();
	movie_list.setLayout(new GridBagLayout());
	//movie_list.setPreferredSize(new Dimension(800,450));
	movie_main.add(movie_list);
	this.add(movie_main);
	movie_list.setBackground(new Color(255,0,0,0));
	GridBagConstraints gbc = new GridBagConstraints();
	for(int i=0;i<3;i++) {
		gbc.gridx = 0;
		gbc.gridy = i;
		String name = movie_name[i];
		String movie_name = "picture/"+ Integer.toString(i) + ".PNG";
		JLabel movie_Icon = new JLabel();
		movie_Icon.setIcon(new ImageIcon(movie_name));
		movie_list.add(movie_Icon,gbc);
		gbc.gridx = 1;
		JLabel text = new JLabel("�����Ϸ� ���� : ");
		movie_list.add(text,gbc);
		gbc.gridx = 2;
		JButton book1 = new JButton(name);
		book1.addActionListener(new Movie1Event());
		movie_list.add(book1,gbc);
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
    	contentPane.removeAll();//��� ������Ʈ�� ����
    	contentPane.revalidate();
    	contentPane.repaint();//�ٽ� �׷���
        */
		
			StartPage.this.setVisible(false);
			String b = e.getActionCommand();
		
			new MiddlePage(b);
		}
	}

}
