package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StartingGround2 extends JFrame {
	protected JPanel mainPanel;
	protected JButton lv1, lv2, lv3;
	JTextField column, row;
	protected JLabel labeltop, labelbot;
	JLabel labelColumn, labelRow;

	public StartingGround2() {

		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (javax.swing.UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		init();
		setIconImage(new ImageIcon("image/game.png").getImage());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(520, 600);
		setLocationRelativeTo(null);
            }
            });
	}

	public void init() {
		// mainPanel
		add(mainPanel = new JPanel());
		mainPanel.setBackground(new Color(225,228,160));
		mainPanel.setLayout(new FlowLayout());
		Image image = new ImageIcon("image/background.png").getImage().getScaledInstance(500,550, Image.SCALE_SMOOTH);
//		mainPanel.add(labeltop = new JLabel(new ImageIcon(image)), "North");
		mainPanel.add(labelbot = new JLabel(new ImageIcon(image)));
		labelbot.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		labelbot.add(labelRow= new JLabel("Input row: "),gbc);
		gbc.gridx+=2;
		labelbot.add(labelColumn = new JLabel("Input column:"),gbc);
		gbc.gridy++;
		gbc.gridx = 0;

		gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        row = new JTextField(10);
        add(row , gbc);
        gbc.gridx += 2;
        column = new JTextField(10);
        add(column , gbc);
	}


	public static void main(String[] args) {
		new StartingGround2().setVisible(true);
	}

}
