package com.board.free.frames.write;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.board.free.controller.BlogController;
import com.board.free.controller.UserController;
import com.board.free.dao.UserDAO;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.dto.UserDTO;
import com.board.free.frames.boards.BoardFrame;
import com.board.free.frames.read.ReadFrame;

public class WriteContent extends JPanel {

	private JLabel title;
	private JTextField titleField;
	private JTextArea contents;
	private JButton submit;
	private UserDTO user;
	
	

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JTextField getTitleField() {
		return titleField;
	}

	public void setTitleField(JTextField titleField) {
		this.titleField = titleField;
	}

	public JTextArea getContents() {
		return contents;
	}

	public void setContents(JTextArea contents) {
		this.contents = contents;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public WriteContent(UserDTO user) {
		this.user = user;
		initData();
		setInitLayout();
	}

	private void initData() {
		title = new JLabel();
		contents = new JTextArea();
		titleField = new JTextField();
		submit = new JButton("등록");
	}

	private void setInitLayout() {
		setSize(1000, 800);
		setLocation(250, 60);
		setLayout(null);
		add(title);
		title.setSize(80, 30);
		title.setLocation(50, 30);
		title.setText("제목 : ");
		title.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		add(titleField);
		titleField.setSize(700, 30);
		titleField.setLocation(120, 30);
		titleField.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		add(contents);
		contents.setSize(900, 600);
		contents.setLocation(50, 100);
		contents.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		add(submit);
		submit.setSize(100, 30);
		submit.setLocation(450, 730);
		submit.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		setVisible(true);
	}
	

	public static void main(String[] args) {
		UserDTO dto = new UserController().requestSignIn("홍길동", "1234");
		new WriteFrame(dto);
	}

}
