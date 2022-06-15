package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartingGround extends JFrame {
	 JPanel mainPanel;
	 JButton lv1, lv2, lv3;
	 JLabel labeltop, labelbot;

	public StartingGround() {

		// TODO Auto-generated constructor stub
		super("Cờ Caro");
		init();
		setIconImage(new ImageIcon("image/game.png").getImage());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(520, 600);
		setLocationRelativeTo(null);
	}

	public void init() {
		// mainPanel
		add(mainPanel = new JPanel());
		mainPanel.setBackground(new Color(225,228,160));
		mainPanel.setLayout(new BorderLayout());
		Image image = new ImageIcon("image/background.png").getImage().getScaledInstance(510, 370, Image.SCALE_SMOOTH);
		mainPanel.add(labeltop = new JLabel(new ImageIcon(image)), "North");
		mainPanel.add(labelbot = new JLabel(), "Center");

		labelbot.setLayout(new GridLayout(3, 1));

		// button easy
		Image img1 = new ImageIcon("image/easy.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		labelbot.add(lv1 = new JButton(new ImageIcon(img1)));
		lv1.setFocusable(false);
		lv1.setBorderPainted(false);
		lv1.setContentAreaFilled(false);
		lv1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new PlayGround(3, 3).setVisible(true);
			}
		});
		// button normal
		Image img2 = new ImageIcon("image/normal.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		labelbot.add(lv2 = new JButton(new ImageIcon(img2)));

		lv2.setBackground(Color.LIGHT_GRAY);
		lv2.setFocusable(false);
		lv2.setBorderPainted(false);
		lv2.setContentAreaFilled(false);
		lv2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new PlayGround(9, 9).setVisible(true);
			}
		});
		// button hard
		Image img3 = new ImageIcon("image/hard.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		labelbot.add(lv3 = new JButton(new ImageIcon(img3)));

		lv3.setBackground(Color.LIGHT_GRAY);
		lv3.setFocusable(false);
		lv3.setBorderPainted(false);
		lv3.setContentAreaFilled(false);
		lv3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new PlayGround(13, 13).setVisible(true);
			}
		});

	}

//	public static void main(String[] args) {
//		new StartingGround().setVisible(true);
//	}

}
