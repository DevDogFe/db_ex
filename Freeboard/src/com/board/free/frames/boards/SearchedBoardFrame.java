package com.board.free.frames.boards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.board.free.controller.BlogController;
import com.board.free.controller.UserController;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.dto.UserDTO;
import com.board.free.frames.LoginFrame;
import com.board.free.frames.read.ReadFrame;
import com.board.free.frames.write.WriteFrame;

public class SearchedBoardFrame extends JFrame{
	
	private UserDTO user;
	private JPanel usernamePanel;
	private JLabel username;
	private JPanel logout;
	private JLabel logoutLetter;
	private JPanel header;
	private JPanel body;
	private ArrayList<BlogListDTO> list;
	private BoardTable boardTable;
	private JLabel title;
	private JLabel write;
	private JPanel writePanel;
	private JLabel main;
	private JPanel mainPanel;
	private SearchedBoardFrame mContext = this;
	private int userId;
	
	public SearchedBoardFrame(UserDTO userDTO, int userId) {
		this.user = userDTO;
		this.userId = userId;
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setTitle("메인");
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
		list = new BlogController().requestBoardByUserId(userId, 0);
		boardTable = new BoardTable(user, list);
		title = new JLabel();
		writePanel = new JPanel();
		write = new JLabel();
		mainPanel = new JPanel();
		main = new JLabel();
		usernamePanel = new JPanel();
		username = new JLabel();
		
	}
	
	private void setInitLayout() {
		setLayout(null);
		header.setLayout(null);
		add(header);
		header.setLocation(0, 0);
		header.setBackground(Color.gray);
		header.add(title);
		title.setLocation(120, 20);
		title.setSize(300, 50);
		title.setFont(new Font("monospaced", Font.BOLD, 30));
		title.setText("자 유 게 시 판");
		header.add(usernamePanel);
		usernamePanel.add(username);
		usernamePanel.setSize(130, 50);
		usernamePanel.setLocation(1200, 20);
		usernamePanel.setBackground(Color.GRAY);
		username.setFont(new Font("monospaced", Font.CENTER_BASELINE, 25));
		username.setText(user.getUsername() + "님");
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
		body.add(writePanel);
		writePanel.setLocation(1200, 100);
		writePanel.setSize(200, 50);
		writePanel.setBackground(Color.DARK_GRAY);
		writePanel.add(write, BorderLayout.CENTER);
		write.setText("글쓰기");
		write.setFont(new Font("monospaced", Font.BOLD, 30));
		write.setForeground(Color.white);
		body.add(mainPanel);
		mainPanel.setLocation(1200, 200);
		mainPanel.setSize(200, 50);
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.add(main, BorderLayout.CENTER);
		main.setText("전체글보기");
		main.setFont(new Font("monospaced", Font.BOLD, 30));
		main.setForeground(Color.white);
		body.add(boardTable);
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
		write.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new WriteFrame(user);
				dispose();
				super.mouseReleased(e);
			}
		});
		
		usernamePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new UserInfoFrame(user, user.getId(), getMousePosition().x, getMousePosition().y, mContext);
				super.mouseReleased(e);
			}
		});
		
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new BoardFrame(user);
				super.mouseReleased(e);
			}
		});
		
		
		boardTable.getTitles()[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[0].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[1].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[2].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[3].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[4].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[5].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[6].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[7].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[8].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[9].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[10].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[11].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[12].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[13].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[13].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[14].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[14].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[15].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[15].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[16].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[16].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[17].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[17].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[18].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[18].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		boardTable.getTitles()[19].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				BlogController blogController = new BlogController();
				BlogDTO blogDTO = blogController.requestBoardContentById(Integer.parseInt(boardTable.getIds()[19].getText()), user.getId());
				new ReadFrame(user, blogDTO);
				dispose();
				super.mouseReleased(e);
			}
		});
		
	}
	
	public static void main(String[] args) {
		UserDTO dto = new UserController().requestSignIn("홍길동", "1234");
		new SearchedBoardFrame(dto, 1);
	}
	
	
}
