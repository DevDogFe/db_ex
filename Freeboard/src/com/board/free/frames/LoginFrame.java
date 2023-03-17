package com.board.free.frames;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.board.free.controller.UserController;
import com.board.free.dto.UserDTO;
import com.board.free.frames.boards.BoardFrame;
import com.board.free.frames.signup.SignupFrame;

public class LoginFrame extends JFrame {

	private JPanel panel;
	private JLabel title;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JTextField idField;
	private JPasswordField pwField;
	private JButton login;
	private JButton signUp;

	public LoginFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("로그인");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		title = new JLabel();
		idLabel = new JLabel();
		pwLabel = new JLabel();
		idField = new JTextField();
		pwField = new JPasswordField();
		login = new JButton("로그인");
		signUp = new JButton("회원가입");

	}

	private void setInitLayout() {
		add(panel);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.add(title);
		title.setSize(200, 30);
		title.setText("자유 게시판");
		title.setLocation(145, 20);
		title.setFont(new Font("monospaced", Font.BOLD, 15));
		panel.add(idLabel);
		idLabel.setSize(100, 10);
		idLabel.setText("아이디");
		idLabel.setLocation(30, 100);
		panel.add(pwLabel);
		pwLabel.setSize(100, 10);
		pwLabel.setText("비밀번호");
		pwLabel.setLocation(30, 150);
		panel.add(idField);
		idField.setSize(150, 20);
		idField.setLocation(100, 96);
		panel.add(pwField);
		pwField.setSize(150, 20);
		pwField.setLocation(100, 146);
		panel.add(login);
		login.setSize(100, 30);
		login.setLocation(270, 96);
		panel.add(signUp);
		signUp.setSize(100, 30);
		signUp.setLocation(270, 136);

		setVisible(true);
	}

	private void addEventListener() {
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String pw = new String(pwField.getPassword());
				UserController userController = new UserController();
				UserDTO userDTO = userController.requestSignIn(id, pw);
				if (userDTO != null) {
					new BoardFrame(userDTO);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패\n아이디와 비밀번호를 확인해주세요.");
				}
			}
		});

		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SignupFrame();
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new LoginFrame();
	}

}
