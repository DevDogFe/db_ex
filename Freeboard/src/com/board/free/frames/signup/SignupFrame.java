package com.board.free.frames.signup;

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
import com.board.free.frames.LoginFrame;
import com.board.free.frames.boards.BoardFrame;

public class SignupFrame extends JFrame {

	private JPanel panel;
	private JLabel title;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JLabel pwCheckLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;
	private JTextField idField;
	private JPasswordField pwField;
	private JPasswordField pwCheckField;
	private JTextField emailField;
	private JTextField addressField;
	private JButton button;

	public SignupFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("회원가입");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		panel = new JPanel();
		title = new JLabel();
		idLabel = new JLabel();
		pwLabel = new JLabel();
		pwCheckLabel = new JLabel();
		emailLabel = new JLabel();
		addressLabel = new JLabel();
		idField = new JTextField();
		pwField = new JPasswordField();
		pwCheckField = new JPasswordField();
		emailField = new JTextField();
		addressField = new JTextField();
		button = new JButton("회원가입하기");

	}

	private void setInitLayout() {
		add(panel);
		panel.setBackground(Color.lightGray);
		panel.setLayout(null);
		panel.add(title);
		title.setSize(200, 30);
		title.setText("회 원 가 입 하 기");
		title.setLocation(170, 20);
		title.setFont(new Font("monospaced", Font.BOLD, 15));
		panel.add(idLabel);
		idLabel.setSize(100, 15);
		idLabel.setText("아이디*");
		idLabel.setLocation(30, 100);
		panel.add(pwLabel);
		pwLabel.setSize(150, 15);
		pwLabel.setText("비밀번호(4자이상)*");
		pwLabel.setLocation(30, 150);
		panel.add(pwCheckLabel);
		pwCheckLabel.setSize(150, 15);
		pwCheckLabel.setText("비밀번호확인*");
		pwCheckLabel.setLocation(30, 200);
		panel.add(emailLabel);
		emailLabel.setSize(100, 15);
		emailLabel.setText("email*");
		emailLabel.setLocation(30, 250);
		panel.add(addressLabel);
		addressLabel.setSize(100, 15);
		addressLabel.setText("주소");
		addressLabel.setLocation(30, 300);
		panel.add(idField);
		idField.setSize(150, 20);
		idField.setLocation(150, 96);
		panel.add(pwField);
		pwField.setSize(150, 20);
		pwField.setLocation(150, 146);
		panel.add(pwCheckField);
		pwCheckField.setSize(150, 20);
		pwCheckField.setLocation(150, 196);
		panel.add(emailField);
		emailField.setSize(250, 20);
		emailField.setLocation(150, 246);
		panel.add(addressField);
		addressField.setSize(300, 20);
		addressField.setLocation(150, 296);
		panel.add(button);
		button.setSize(150, 40);
		button.setLocation(170, 500);

		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String pw = new String(pwField.getPassword());
				String pwCheck = new String(pwCheckField.getPassword());
				String email = emailField.getText();
				String address = addressField.getText();
				if (id == "" || pw == "" || email == "") {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다. \n 필수입력창을 확인하세요.");
				} else if (!pw.equals(pwCheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호확인란은 비밀번호란에 입력한 비밀번호를 똑같이 입력해야합니다.");
				} else {
					JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.");
					new UserController().requestCreateUser(new UserDTO(id, pw, email, address));
					new LoginFrame();
					dispose();
				}

			}
		});
	}

	public static void main(String[] args) {
		new SignupFrame();
	}

}
