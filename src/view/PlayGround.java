package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controller;
import model.Board;
import model.Music;
import model.Player;

public class PlayGround extends JFrame implements Observer {
	Controller controller;
	Music music;
	Board board;
	Player playingControll;
	JPanel panel;
	ImageSetting image = new ImageSetting();// chưa khai báo sẽ không update được

	JButton[][] button;
	JLabel playLabel, controlLabel, nameLabel, buttonLabel, iconLabel, markLabel;
	JLabel turnLabel = new JLabel();// chưa khai báo sẽ không update được
	JTextField nameX = new JTextField(), nameO = new JTextField();
	JScrollPane scrollPane;
	public static JButton play, about, home, undo,mute, surrender;
	public static boolean start = false;
	public boolean sound = true;
	public int value = 1;

	public PlayGround(Controller controller, Board board, Player playingControll, Music music, int row,
			int column) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
		this.music = music;
		this.board = board;
		this.playingControll = playingControll;
		board.registerObs(this);// đăng kí cho màn hình
//		playingControll.registerObs(this);
		button = new JButton[row][column];
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j] = new JButton();
			}
		}
		controller.setArr(row, column);
		image = new ImageSetting();
		setTitle("Cờ Caro");
		setIconImage(new ImageIcon("image/game.png").getImage());
		setSize(850, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
//		controller.turnMusic();
		createCursor();
		setVisible(true);

	}

	public PlayGround(int row, int column) {
		// TODO Auto-generated constructor stub
		image = new ImageSetting();
		button = new JButton[row][column];
		setTitle("Cờ Caro");
		setIconImage(new ImageIcon("image/game.png").getImage());
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
		createCursor();
		setVisible(true);
	}

	public JButton[][] setBoard(int row, int column) {
		// TODO Auto-generated method stub
		button = new JButton[row][column];
		return button;
	}

	private void init() {
		// TODO Auto-generated method stub
		add(panel = new JPanel());
		panel.setLayout(new BorderLayout());
//		panel.add(playLabel = new JLabel(), "Center");
//		panel.add(scrollPane = new JScrollPane(), "Center");
		panel.add(playLabel = new JLabel(), "Center");
		panel.add(controlLabel = new JLabel(), "East");
		panel.setBackground(new Color(246, 201, 163));
		controlLabel.setLayout(new FlowLayout());
		controlLabel.add(nameLabel = new JLabel());
		nameLabel.setBorder(BorderFactory.createRaisedBevelBorder());
		controlLabel.add(buttonLabel = new JLabel());
		buttonLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		controlLabel.add(iconLabel = new JLabel());
		iconLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		controlLabel.add(markLabel = new JLabel());

//		scrollPane.add(playLabel = new JLabel());
//		scrollPane.setPreferredSize(new Dimension(600, 500));
		playLabel.setPreferredSize(new Dimension(500, 500));
		playLabel.setBorder(BorderFactory.createEtchedBorder());
		controlLabel.setPreferredSize(new Dimension(250, 500));
		nameLabel.setPreferredSize(new Dimension(250, 100));
		buttonLabel.setPreferredSize(new Dimension(250, 180));
		iconLabel.setPreferredSize(new Dimension(250, 100));
		markLabel.setPreferredSize(new Dimension(250, 120));

		playLabel.setLayout(new GridLayout(button.length, button[0].length, 1, 1));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j] = new JButton();
//				scrollPane.add(button[i][j]);

				button[i][j].setPreferredSize(new Dimension(30, 30));
				button[i][j].setEnabled(false);
				playLabel.add(button[i][j]);
				button[i][j].setBackground(new Color(255, 208, 208));
				button[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for (int i = 0; i < button.length; i++) {
							for (int j = 0; j < button[i].length; j++) {
								if (e.getSource() == button[i][j]) {
									controller.setTurn();
									controller.setArrValue(i, j, value++);
									button[i][j].setEnabled(false);
									System.out.println(i + " " + j + " " + value);
								}
							}
						}
					}
				});

			}
		}

		nameLabel.setLayout(new FlowLayout());

		nameLabel.add(new JLabel(new ImageIcon(image.labelXImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))));
		nameLabel.add(nameX);
		nameX.setPreferredSize(new Dimension(200, 25));

		nameLabel.add(new JLabel(new ImageIcon(image.labelOImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))));
		nameLabel.add(nameO);
		nameO.setPreferredSize(new Dimension(200, 25));

		buttonLabel.setLayout(new FlowLayout());
		buttonLabel.add(play = new JButton(
				new ImageIcon(image.playButtonImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH))));
		play.setBackground(controlLabel.getBackground());
		play.setFocusable(false);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				startGame();
//				board.setArr(button.length,button[0].length);
				controller.setNameXO(nameX.getText(), nameO.getText());
				controller.setArr(button.length, button[0].length);
//				checkNamePlayer();

			}
		});

		buttonLabel.add(about = new JButton(
				new ImageIcon(image.aboutButtonImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH))));
		about.setBackground(controlLabel.getBackground());
		about.setFocusable(false);
		about.setBorderPainted(false);
		about.setContentAreaFilled(false);
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				about();
			}
		});

		iconLabel.setLayout(new GridLayout(1, 3));
		iconLabel.add(
				undo = new JButton(new ImageIcon(image.undoImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		undo.setFocusable(false);
		undo.setBorderPainted(false);
		undo.setContentAreaFilled(false);

		iconLabel.add(mute= new JButton(new ImageIcon(image.onSoundImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		mute.setFocusable(false);
		mute.setBorderPainted(false);
		mute.setContentAreaFilled(false);
		mute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sound == false) {
					mute.setIcon(new ImageIcon(image.onSoundImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					controller.turnMusic();
					sound = true;
				} else {
					controller.offMusic();
					mute.setIcon(new ImageIcon(image.offSoundImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					sound = false;
				}

			}
		});

		iconLabel
				.add(home = new JButton(new ImageIcon(image.homeIcon().getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
		home.setFocusable(false);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int joption = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát game chứ??", null,
						JOptionPane.DEFAULT_OPTION);
				if (joption == JOptionPane.OK_OPTION) {
					dispose();
				}
			}
		});

		markLabel.setLayout(new FlowLayout());
//		turnLabel.setIcon(new ImageIcon(image.xLabelImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

		markLabel.add(turnLabel);
		surrender = new JButton(new ImageIcon(image.surrenderImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
		surrender.setBackground(markLabel.getBackground());
		surrender.setFocusable(false);
		surrender.setBorderPainted(false);
		surrender.setContentAreaFilled(false);
		surrender.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int joption = JOptionPane.showConfirmDialog(null, "Đầu hàng sớm thế??", null,
						JOptionPane.DEFAULT_OPTION);
				if (joption == JOptionPane.OK_OPTION) {
					board.setArr(button.length, button[0].length);
					for (int i = 0; i < button.length; i++) {
						for (int j = 0; j < button[i].length; j++) {
							button[i][j].setEnabled(true);
						}
					}

				}

			}

		});
		markLabel.add(surrender);

	}

	public void about() {
		// TODO Auto-generated method stub
		String s = "";
		s = s + "1. Game có 3 mức độ bàn cờ  ( Có thể chọn ở màn hình đầu tiên).\n";
		s = s + "2. Để bắt đầu game, trước hết bạn phải nhập tên của 2 người chơi vào 2 ô textField ở bên phải màn hình, sau đó nhất Start hoặc phím ENTER để bắt đầu chơi.\n";
		s = s + "3. Người nào tạo được 5 ô cùng hàng(chéo , ngang , dọc) và không bị người kia chặn 2 đầu thì sẽ thắng.\n";
		s = s + "4. Thời gian suy nghĩ là 20 giây, hết thời gian suy nghĩ mà không đưa ra nước đi thì bị xử thua ván đó.\n";
		s = s + "5. Ai thua thì ván sau sẽ được đánh trước để đảm bảo công bằng :D.\n";
		s = s + "6. Nhấn vào reset để khởi tạo lại chò chơi (Nhập tên người chơi mới, đặt lại số điểm,....).\n";
		s = s + "7. Game có tích hợp Undo ( Ctrl Z ) và Redo ( Ctrl Y ) để dùng khi đánh nhầm chẳng hạn :D.\n";
		int joption = JOptionPane.showConfirmDialog(null, s, "About?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image.aboutImage()));

	}

	public boolean checkNamePlayer() {
		String s1 = nameX.getText();
		String s2 = nameO.getText();
		if (s1.compareTo("") != 0 && s2.compareTo("") != 0) {// when both player input name, game starts
			play.setEnabled(false);
			nameX.setEditable(false);// we can't edit player name when game start
			nameO.setEditable(false);
			start = true;
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button[i].length; j++) {
					button[i][j].setEnabled(true);
				}
			}
			return true;
		} else if (s1.compareTo("") == 0 && s2.compareTo("") != 0) {
			nameX.setBackground(Color.red);
			int joption = JOptionPane.showConfirmDialog(null, "Tên của người chơi X đâu rồi????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {

				nameX.setBackground(Color.white);
			}
			start = false;
			return false;
		} else if (s1.compareTo("") != 0 && s2.compareTo("") == 0) {
			nameO.setBackground(Color.red);
			int joption = JOptionPane.showConfirmDialog(null, "Tên của người chơi O đâu rồi????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {

				nameO.setBackground(Color.white);
			}
			start = false;
			return false;
		} else if (s1.compareTo("") != 0 && s2.compareTo("") != 0) {
			nameX.setBackground(Color.red);
			nameO.setBackground(Color.red);

			int joption = JOptionPane.showConfirmDialog(null, "Tên của 2 người chơi đâu rồi bạn ơi?????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {
				nameX.setBackground(Color.white);
				nameO.setBackground(Color.white);
			}
			start = false;
			return false;
		}
		return false;
	}

	public void createCursor() {

		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image.cursorImage(), new Point(0, 20), "cursor  "));
	}

	@Override
	public void update() {


		nameX.setText(playingControll.getNameX());
		nameO.setText(playingControll.getNameO());

//		System.out.println(playingControll.getNameX() + "  , " + playingControll.getNameO());

		int[][] playArr = board.getArr();
//		System.out.print(Arrays.deepToString(playArr));)
		if (checkNamePlayer() == true) {// paint color for checkerBoard
			for (int i = 0; i < playArr.length; i++) {
				for (int j = 0; j < playArr[i].length; j++) {
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							button[i][j].setBackground(new Color(255, 230, 230));
						} else {
							button[i][j].setBackground(new Color(188, 200, 250));
						}
					} else if (j % 2 == 0) {
						button[i][j].setBackground(new Color(188, 200, 250));
					} else {
						button[i][j].setBackground(new Color(255, 230, 230));
					}
				}
			}
			start = false;
		}

		if (playingControll.getTurn() == 1) {// thay đổi label để biết quân nào sẽ được đánh tiếp theo
			turnLabel.setIcon(new ImageIcon(image.xLabelImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		} else {
			turnLabel.setIcon(new ImageIcon(image.oLabelImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		}

		for (int i = 0; i < playArr.length; i++) {
			for (int j = 0; j < playArr[i].length; j++) {
				if (playArr[i][j] == 0) {
					button[i][j].setText("");
				} else if (playArr[i][j] % 2 == 0) {
					button[i][j].setText("o");
					button[i][j].setEnabled(false);
//					System.out.println("x");

				} else if (playArr[i][j] % 2 != 0) {
					button[i][j].setText("x");
					button[i][j].setEnabled(false);
//				System.out.println("o");
				}
			}

		}

//		System.out.println(board.getSize());
	}

}
