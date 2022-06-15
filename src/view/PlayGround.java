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
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayGround extends JFrame implements MouseListener {
	 JPanel panel;
	 JButton[][] button;
	 JLabel playLabel, controlLabel, nameLabel, buttonLabel, iconLabel, markLabel;
	 JTextField nameX, nameO;
	 JButton play, about, home, undo, mute;
	public static boolean start = false;

	public PlayGround(int i, int j) {
		// TODO Auto-generated constructor stub
		button = new JButton[i][j];
		setTitle("Cờ Caro");
		setIconImage(new ImageIcon("image/game.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 550);
		setResizable(false);
		setLocationRelativeTo(null);


		init();
		createCursor();
//		try {
//			music();
//		} catch (UnsupportedOperationException | IOException | LineUnavailableException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}

//	public void music() throws UnsupportedOperationException , IOException , LineUnavailableException  {
//		// TODO Auto-generated method stub
//		File file = new File("muic/sound.wav");
//	}

	private void init() {
		// TODO Auto-generated method stub
		add(panel = new JPanel());
		panel.setLayout(new BorderLayout());
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

		playLabel.setPreferredSize(new Dimension(500, 500));
		playLabel.setBorder(BorderFactory.createEtchedBorder());
		controlLabel.setPreferredSize(new Dimension(250, 500));
		nameLabel.setPreferredSize(new Dimension(250, 100));
		buttonLabel.setPreferredSize(new Dimension(250, 180));
		iconLabel.setPreferredSize(new Dimension(250, 100));
		markLabel.setPreferredSize(new Dimension(250, 120));
		playLabel.setLayout(new GridLayout(button.length, button.length,1,1));

		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				button[i][j] = new JButton();
				button[i][j].setEnabled(false);
				playLabel.add(button[i][j]);
				button[i][j].setBackground(new Color(255, 208, 208));

			}
		}
		nameLabel.setLayout(new FlowLayout());
		Image imgX = new ImageIcon("image/x.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		nameLabel.add(new JLabel(new ImageIcon(imgX)));
		nameLabel.add(nameX = new JTextField());
		nameX.setPreferredSize(new Dimension(200, 25));

		Image imgO = new ImageIcon("image/o.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		nameLabel.add(new JLabel(new ImageIcon(imgO)));
		nameLabel.add(nameO = new JTextField());
		nameO.setPreferredSize(new Dimension(200, 25));

		buttonLabel.setLayout(new FlowLayout());
		Image imgPlay = new ImageIcon("image/play.png").getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		buttonLabel.add(play = new JButton(new ImageIcon(imgPlay)));
		play.setBackground(controlLabel.getBackground());
		play.setFocusable(false);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startGame();
			}
		});
		Image imgAbout = new ImageIcon("image/about.png").getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH);
		buttonLabel.add(about = new JButton(new ImageIcon(imgAbout)));
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
		Image imgUndo = new ImageIcon("image/undo.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		iconLabel.add(undo = new JButton(new ImageIcon(imgUndo)));
		undo.setFocusable(false);
		undo.setBorderPainted(false);
		undo.setContentAreaFilled(false);

		Image imgMute = new ImageIcon("image/onSound.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		iconLabel.add(mute = new JButton(new ImageIcon(imgMute)));
		mute.setFocusable(false);
		mute.setBorderPainted(false);
		mute.setContentAreaFilled(false);

		Image imgHome = new ImageIcon("image/homeicon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		iconLabel.add(home = new JButton(new ImageIcon(imgHome)));
		home.setFocusable(false);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);

		Image imgMarkLabel = new ImageIcon("image/xLabel.png").getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH);
		Image imgGame = new ImageIcon("image/game.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		markLabel.setLayout(new FlowLayout());
		markLabel.add(new JLabel(new ImageIcon(imgMarkLabel)));
		markLabel.add(new JLabel(new ImageIcon(imgGame)));

	}

	public static void main(String[] args) {
		new PlayGround(10, 10).setVisible(true);
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
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon("image/aboutImg.png"));

	}

	public void startGame() {
		checkNamePlayer();
	}

	public boolean checkNamePlayer() {
		String s1 = nameX.getText();
		String s2 = nameO.getText();
		if (s1.compareTo("") != 0 && s2.compareTo("") != 0) {// when both player input name, game starts
			play.setEnabled(false);
			nameX.setEditable(false);// we can't edit player name when game start
			nameO.setEditable(false);
			start = true;
			setBackGround();
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button.length; j++) {
					button[i][j].setEnabled(true);
				}
			}
		} else if (s1.compareTo("") == 0 && s2.compareTo("") != 0) {
			nameX.setBackground(Color.red);
			int joption = JOptionPane.showConfirmDialog(null, "Tên của người chơi X đâu rồi????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {

				nameX.setBackground(Color.white);
			}
		} else if (s1.compareTo("") != 0 && s2.compareTo("") == 0) {
			nameO.setBackground(Color.red);
			int joption = JOptionPane.showConfirmDialog(null, "Tên của người chơi O đâu rồi????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {

				nameO.setBackground(Color.white);
			}
		} else {
			nameX.setBackground(Color.red);
			nameO.setBackground(Color.red);

			int joption = JOptionPane.showConfirmDialog(null, "Tên của 2 người chơi đâu rồi bạn ơi?????", null,
					JOptionPane.DEFAULT_OPTION);
			if (joption == JOptionPane.OK_OPTION) {
				nameX.setBackground(Color.white);
				nameO.setBackground(Color.white);
			}
		}
		return true;
	}
	public void createCursor() {
		Image cursor = new ImageIcon("image/cursor.png").getImage();
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursor,new Point(0,20), "cursor  "));
	}

	public void setBackGround() {
		// tô 2 màu trên bàn cờ theo đường chéo
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {

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
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
