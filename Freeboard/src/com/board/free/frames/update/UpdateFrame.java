package com.board.free.frames.update;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

public class UpdateFrame extends JFrame{
	
	private UserDTO user;
	private BlogDTO blogDTO;
	private JPanel logout;
	private JLabel logoutLetter;
	private JPanel header;
	private JPanel body;
	private UpdateContent updateContent;
	
	public UpdateFrame(UserDTO user, BlogDTO blogDTO) {
		this.user = user;
		this.blogDTO = blogDTO;
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("글 수정");
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
		updateContent = new UpdateContent(user, blogDTO);
		
		
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
		add(body);
		body.setLayout(null);
		body.setLocation(0, 80);
		body.setBackground(Color.LIGHT_GRAY);
		body.add(updateContent);
		
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
		
		updateContent.getUpdate().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int resultRow = -1;
				System.out.println("click");
				String titleText = updateContent.getTitleField().getText(); 
				String ContentText = updateContent.getContents().getText();
				if(titleText != "") {
					resultRow = new BlogController().requestUpdateById(new BlogDTO(titleText, ContentText), blogDTO.getId(), blogDTO.getUserId());
					System.out.println("성공");
				} else {
					JOptionPane.showMessageDialog(null, "글 수정 실패\n제목을 입력해주세요.");
					System.out.println("실패");
				}
				if(resultRow == 1) {
					JOptionPane.showMessageDialog(null, "글 수정에 성공하셨습니다.");
					System.out.println("resultRow: " + resultRow);
					new BoardFrame(user);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "글 수정에 실패하였습니다.");
				}
			
				
				super.mouseReleased(e);
			}
		});
	}
	
	public static void main(String[] args) {
		UserDTO dto = new UserController().requestSignIn("홍길동", "1234");
	}
	
	
}
