package com.board.free.frames.read;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import com.board.free.controller.BlogController;
import com.board.free.controller.UserController;
import com.board.free.dao.UserDAO;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.dto.UserDTO;

public class ReadContent extends JPanel {

	private JLabel title;
	private JLabel writer;
	private BlogDTO blogDTO;
	private UserDTO contentWriter;
	private JTextArea contents;
	private JButton update;
	
	public JButton getUpdate() {
		return update;
	}

	public void setUpdate(JButton update) {
		this.update = update;
	}

	public ReadContent(BlogDTO blogDTO) {
		this.blogDTO = blogDTO;
		contentWriter = new UserDAO().searchUserById(this.blogDTO.getUserId()); 
		initData();
		setInitLayout();
	}

	private void initData() {
		setSize(1000, 800);
		setLocation(250, 60);
		title = new JLabel();
		writer = new JLabel();
		contents = new JTextArea();
		update = new JButton("수정하기");
	}

	private void setInitLayout() {
		setLayout(null);
		add(title);
		title.setSize(500, 50);
		title.setLocation(50, 30);
		title.setText("제목 :  " + blogDTO.getTitle());
		title.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		add(writer);
		writer.setSize(300, 50);
		writer.setLocation(800, 30);
		writer.setText("작성자 :  " + contentWriter.getUsername());
		writer.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		add(contents);
		contents.setSize(900, 600);
		contents.setLocation(50, 100);
		contents.setEditable(false);
		contents.setText("\n" +blogDTO.getContent());
		add(update);
		update.setSize(150, 50);
		update.setLocation(425, 720);
		update.setFont(new Font("monospaced", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		setVisible(true);
	}

	public static void main(String[] args) {
	}

}
