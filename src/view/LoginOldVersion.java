package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import service.AccountService;
import service.AccountServiceImpl;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LoginOldVersion {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel userTipLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    LoginOldVersion window = new LoginOldVersion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

    public LoginOldVersion() {
		try {
			Class.forName("utils.HibernateUtils");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("超市收银系统");
		frame.setBounds(100, 100, 466, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton pwdVisibelBtn = new JButton("New button");
		pwdVisibelBtn.setIcon(new ImageIcon("images/eye.png"));
		pwdVisibelBtn.setContentAreaFilled(true);
		pwdVisibelBtn.setIconTextGap(0);
		pwdVisibelBtn.setText(null);
		pwdVisibelBtn.setContentAreaFilled(false);// 除去默认的背景填充
		pwdVisibelBtn.setBounds(306, 196, 21, 21);
		pwdVisibelBtn.addMouseListener(new MouseAdapter() {
			boolean isVisible = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (isVisible == false) {
					isVisible = true;
					passwordField.setEchoChar((char) 0);
				} else {
					isVisible = false;
					passwordField.setEchoChar('•');
				}
			}
		});
		frame.getContentPane().add(pwdVisibelBtn);

		JButton loginBtn = new JButton("登录");
		loginBtn.setBounds(176, 256, 109, 29);
		frame.getContentPane().add(loginBtn);

		userField = new JTextField();
		userField.setBounds(130, 140, 196, 23);
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				AccountService as = new AccountServiceImpl();
				Boolean isExist = as.isExist(userField.getText());
				if (!isExist) {
					userTipLabel.setVisible(true);
				}else {
					userTipLabel.setVisible(false);
				}
			}
		});
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(isChinese(c)) {
					e.consume();
					return;
				}
				if (Character.isDigit(c) ||	Character.isLetter(c) 
						||  c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					return;
				}
				e.consume();
			}
			public boolean isChinese(char c) {
		        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
		            return true;
		        } else if (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
		            return true;
		        }
		        return false;
		    }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown())
					e.consume();
			}
		});

		frame.getContentPane().add(userField);
		userField.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "收银员", "管理员" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("");
		comboBox.setBounds(130, 96, 196, 21);
		frame.getContentPane().add(comboBox);

		JLabel typeLabel = new JLabel("身份");
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setBounds(55, 96, 83, 21);
		frame.getContentPane().add(typeLabel);

		JLabel userLabel = new JLabel("账号");
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setBounds(55, 140, 83, 23);
		frame.getContentPane().add(userLabel);

		JLabel pwdLabel = new JLabel("密码");
		pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLabel.setBounds(55, 195, 83, 23);
		frame.getContentPane().add(pwdLabel);

		JLabel titleLabel = new JLabel("超市收银系统");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		titleLabel.setBounds(0, 28, 452, 37);
		frame.getContentPane().add(titleLabel);

		userTipLabel = new JLabel("账号不存在", 0);
		userTipLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		userTipLabel.setVerticalAlignment(SwingConstants.TOP);
		userTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userTipLabel.setForeground(Color.RED);
		userTipLabel.setBounds(331, 143, 83, 15);
		userTipLabel.setVisible(false);
		frame.getContentPane().add(userTipLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(130, 195, 177, 23);
		frame.getContentPane().add(passwordField);
	}
}
