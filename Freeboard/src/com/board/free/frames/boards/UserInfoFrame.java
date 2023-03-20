package com.board.free.frames.boards;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.board.free.controller.UserController;
import com.board.free.dao.UserDAO;
import com.board.free.dto.UserDTO;

public class UserInfoFrame extends JFrame {

	private UserDTO user;
	private UserDTO showedUser;
	private JPanel head;
	private JPanel body;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel dateLabel;
	private JLabel usersBlog;
	private JFrame parentFrame;

	public UserInfoFrame(UserDTO user, int userId, int x, int y, JFrame parentFrame) {
		this.user = user;
		this.showedUser = new UserDAO().searchUserById(userId);
		this.parentFrame = parentFrame;
		initData();
		setInitLayout();
		addEventListener();
		setLocation(x, y);
	}
	public UserInfoFrame(UserDTO user, int userId, int x, int y, BoardFrame boardFrame) {
		this.user = user;
		this.showedUser = new UserDAO().searchUserById(userId);
		this.parentFrame = boardFrame;
		initData();
		setInitLayout();
		setLocation(x, y);
	}
	
	private void initData() {
		setSize(300, 300);
		setBackground(Color.YELLOW);
		setLayout(null);
		head = new JPanel();
		head.setSize(300, 50);
		body = new JPanel();
		body.setSize(300, 250);
		titleLabel = new JLabel();
		nameLabel = new JLabel();
		emailLabel = new JLabel();
		dateLabel = new JLabel();
		usersBlog = new JLabel();
	}
	
	private void setInitLayout() {
		add(head);
		add(body);
		head.setLocation(0, 0);
		head.setBackground(Color.GRAY);
		body.setBackground(Color.LIGHT_GRAY);
		body.setLocation(0, 50);
		body.setLayout(null);
		head.add(titleLabel);
		body.add(nameLabel);
		body.add(emailLabel);
		body.add(dateLabel);
		body.add(usersBlog);
		nameLabel.setText("유저이름: " + showedUser.getUsername());
		nameLabel.setSize(450, 20);
		nameLabel.setLocation(50, 20);
		emailLabel.setText("이메일: " + showedUser.getEmail());
		emailLabel.setSize(450, 20);
		emailLabel.setLocation(50, 50);
		dateLabel.setText("계정 생성일: " + showedUser.getCreateDate());
		dateLabel.setSize(450, 20);
		dateLabel.setLocation(50, 80);
		if(user.getId() == showedUser.getId()) {
			titleLabel.setText("내 정보");
			usersBlog.setText("내 글 보러가기");
		} else {
			titleLabel.setText(showedUser.getUsername() + "님의 정보");
			usersBlog.setText(showedUser.getUsername() + "님의 글 보러가기");
		}
		usersBlog.setSize(450, 20);
		usersBlog.setLocation(50, 150);
		usersBlog.setForeground(Color.BLUE);
		titleLabel.setFont(new Font("monospaced", Font.CENTER_BASELINE, 25));
		
		setVisible(true);
	}
	
	private void addEventListener() {
		usersBlog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(parentFrame != null) {
					parentFrame.dispose();
				}
				new SearchedBoardFrame(user, showedUser.getId());
				dispose();
				super.mouseReleased(e);
			}
		});

	}
	
	public static void main(String[] args) {
		
		UserDTO dto = new UserDAO().searchUserById(1);
	}

}
