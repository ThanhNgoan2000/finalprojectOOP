package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import controller.Controller;
import model.Music;

public class StartingGround extends JFrame {
	Music music;
	Controller controller;
	ImageSetting image;
	JPanel mainPanel;
	JTextField column, row;
	JButton lv1, startButton, lv3;
	JLabel labeltop, labelbot;
	JLabel labelRow, labelColumn;

//	public StartingGround(Controller controller, Music music) {
//
//		// TODO Auto-generated constructor stub
//		super("Cờ Caro");
//		this.music = music;
//		this.controller = controller;
//		this.image = new ImageSetting();
//		init();
//		controller.turnMusic();
//		setIconImage(image.gameImage());
//		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(520, 600);
//		setLocationRelativeTo(null);
//		setVisible(true);
//	}
	public StartingGround(Controller controller, Music music) {

		// TODO Auto-generated constructor stub
		super("Cờ Caro");
		this.image = new ImageSetting();
		this.music = music;
		this.controller = controller;
		init();
		setIconImage(image.gameImage());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(520, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void init() {
		// mainPanel
		add(mainPanel = new JPanel());
		mainPanel.setBackground(new Color(225, 228, 160));
		mainPanel.setLayout(new BorderLayout());

		mainPanel.add(
				labeltop = new JLabel(
						new ImageIcon(image.backgroundImage().getScaledInstance(500, 520, Image.SCALE_SMOOTH))),
				"Center");
		labeltop.add(labelRow = new JLabel("Row:"));
		labelRow.setBounds(30, 460, 100, 30);
		labelRow.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		labeltop.add(row = new JTextField(10));
		row.setBounds(80, 450, 120, 50);

		row.setBorder(new MatteBorder(-1, -1, -1, -1,
				new ImageIcon(this.image.labelXImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH))));
		row.setBackground(new Color(225, 228, 160));
		labeltop.add(labelColumn = new JLabel("Column:"));
		labelColumn.setBounds(250, 460, 120, 30);
		labelColumn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		labeltop.add(column = new JTextField(10));
		column.setBounds(320, 450, 120, 50);
		column.setBorder(new MatteBorder(-1, -1, -1, -1,
				new ImageIcon(this.image.labelOImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH))));
		column.setBackground(new Color(225, 228, 160));

		// button start
		labeltop.add(startButton = new JButton(new ImageIcon(image.startButtonImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH))));
		startButton.setBounds(180, 480, 150, 100);
		startButton.setBackground(Color.LIGHT_GRAY);
		startButton.setFocusable(false);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				Music music = new Music();
//				 controller = new Controller(music);
				controller.showView(Integer.parseInt(row.getText()), Integer.parseInt(column.getText()));
			}
		});

	}

}
