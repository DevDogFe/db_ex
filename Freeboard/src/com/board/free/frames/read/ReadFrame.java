package com.board.free.frames.read;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.board.free.controller.BlogController;
import com.board.free.controller.UserController;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.dto.UserDTO;
import com.board.free.frames.LoginFrame;
import com.board.free.frames.boards.BoardFrame;
import com.board.free.frames.boards.BoardTable;
import com.board.free.frames.update.UpdateFrame;

public class ReadFrame extends JFrame{
	
	private UserDTO userDTO;
	private BlogDTO blogDTO;
	private JPanel logout;
	private JLabel logoutLetter;
	private JPanel header;
	private JPanel body;
	private ReadContent readContent;
	private JLabel title;
	private JButton back;
	private JButton update;
	
	public ReadFrame(UserDTO userDTO, BlogDTO blogDTO) {
		this.userDTO = userDTO;
		this.blogDTO = blogDTO;
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle(blogDTO.getTitle());
		setSize(1500, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		logout = new JPanel();
		logout.setSize(120, 60);
		logoutLetter = new JLabel();
		logoutLetter.setSize(120, 60);
		header = new JPanel();
		header.setSize(1500, 80);
		body = new JPanel();
		body.setSize(1500, 920);
		title = new JLabel();
		title.setSize(300, 50);
		back = new JButton("뒤로가기");
		back.setSize(150, 50);
		readContent = new ReadContent(blogDTO);
		
		
	}
	
	private void setInitLayout() {
		setLayout(null);
		header.setLayout(null);
		add(header);
		header.setLocation(0, 0);
		header.setBackground(Color.gray);
		header.add(logout);
		logout.setBackground(Color.darkGray);
		logout.setLocation(1340, 10);
		logout.add(logoutLetter);
		logoutLetter.setLocation(1340, 10);
		logoutLetter.setText("LOGOUT");
		logoutLetter.setFont(new Font("monospaced", Font.BOLD, 30));
		logoutLetter.setForeground(Color.white);
		header.add(title);
		title.setLocation(200, 20);
		title.setFont(new Font("monospaced", Font.BOLD, 30));
		title.setText("자 유 게 시 판");
		header.add(back);
		back.setLocation(20, 20);
		back.setFont(new Font("monospaced", Font.BOLD, 20));
		add(body);
		body.setLayout(null);
		body.setLocation(0, 80);
		body.setBackground(Color.LIGHT_GRAY);
		body.add(readContent);
		
		setVisible(true);
		
	}
	
	private void addEventListener() {
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new LoginFrame();
				dispose();
				super.mouseReleased(e);
			}
		});
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new BoardFrame(userDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		
		readContent.getUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(userDTO.getId() == blogDTO.getUserId()) {
					new UpdateFrame(userDTO, blogDTO);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "수정 권한이 없습니다.");
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
	}
	
	
}
