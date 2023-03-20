package com.board.free.frames.boards;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.board.free.controller.BlogController;
import com.board.free.controller.UserController;
import com.board.free.dao.BlogDAO;
import com.board.free.dto.BlogDTO;
import com.board.free.dto.BlogListDTO;
import com.board.free.dto.UserDTO;
import com.board.free.frames.read.ReadFrame;

public class BoardTable extends JPanel {

	private ArrayList<BlogListDTO> list;
	private final int LIST_ROWS = 20;
	private JLabel[] headers = new JLabel[LIST_ROWS];
	private JLabel[] ids = new JLabel[LIST_ROWS];
	private JLabel[] titles = new JLabel[LIST_ROWS];
	private JLabel[] readCounts = new JLabel[LIST_ROWS];
	private JLabel[] writers = new JLabel[LIST_ROWS];
	private UserDTO user;
	private MouseListener listener;
	private JButton prev;
	private JButton next;
	private int offset;
	private int rowCount;
	private int userId = -1;

	public ArrayList<BlogListDTO> getList() {
		return list;
	}

	public void setList(ArrayList<BlogListDTO> list) {
		this.list = list;
	}

	public JLabel[] getHeaders() {
		return headers;
	}

	public void setHeaders(JLabel[] headers) {
		this.headers = headers;
	}

	public JLabel[] getIds() {
		return ids;
	}

	public void setIds(JLabel[] ids) {
		this.ids = ids;
	}

	public JLabel[] getTitles() {
		return titles;
	}

	public void setTitles(JLabel[] titles) {
		this.titles = titles;
	}

	public JLabel[] getReadCounts() {
		return readCounts;
	}

	public void setReadCounts(JLabel[] readCounts) {
		this.readCounts = readCounts;
	}

	public JLabel[] getWriters() {
		return writers;
	}

	public void setWriters(JLabel[] writers) {
		this.writers = writers;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public MouseListener getListener() {
		return listener;
	}

	public void setListener(MouseListener listener) {
		this.listener = listener;
	}

	public int getLIST_ROWS() {
		return LIST_ROWS;
	}

	public BoardTable(UserDTO user, ArrayList<BlogListDTO> list) {
		this.list = list;
		this.user = user;
		initData();
		setInitLayout();
		addEventListener();
	}
	public BoardTable(UserDTO user, ArrayList<BlogListDTO> list, int userId) {
		this.list = list;
		this.user = user;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		for (int i = 0; i < headers.length; i++) {
			headers[i] = new JLabel();
		}
		for (int i = 0; i < LIST_ROWS; i++) {
			ids[i] = new JLabel();
			titles[i] = new JLabel();
			readCounts[i] = new JLabel();
			writers[i] = new JLabel();
		}
		prev = new JButton("이전");
		next = new JButton("다음");
		offset = 0;
	}

	private void setInitLayout() {
		setSize(1000, 800);
		setLocation(100, 10);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		for (int i = 0; i < headers.length; i++) {
			add(headers[i]);
			headers[i].setSize(200, 20);
		}
		headers[0].setLocation(100, 50);
		headers[1].setLocation(300, 50);
		headers[2].setLocation(800, 50);
		headers[3].setLocation(900, 50);
		headers[0].setText("글번호");
		headers[1].setText("제  목");
		headers[2].setText("조회수");
		headers[3].setText("작성자");

		for (int i = 0; i < LIST_ROWS; i++) {
			add(ids[i]);
			add(titles[i]);
			add(readCounts[i]);
			add(writers[i]);
			ids[i].setSize(100, 20);
			titles[i].setSize(500, 20);
			readCounts[i].setSize(100, 20);
			writers[i].setSize(200, 20);
			ids[i].setLocation(100, 100 + i * 30);
			titles[i].setLocation(300, 100 + i * 30);
			readCounts[i].setLocation(815, 100 + i * 30);
			writers[i].setLocation(900, 100 + i * 30);
			if(i<list.size()) {
				ids[i].setText(list.get(i).getId() + "");
				titles[i].setText(list.get(i).getTitle());
				readCounts[i].setText(list.get(i).getReadCount() + "");
				writers[i].setText(list.get(i).getUsername());
			}
		}
		add(prev);
		prev.setLocation(450, 750);
		prev.setSize(80, 30);
		add(next);
		next.setLocation(550, 750);
		next.setSize(80, 30);
		setVisible(true);
	}
	
	private void addEventListener() {
		prev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(offset >= 20 && userId == -1) {
					offset -= 20;
					list = new BlogController().requestBoardAll(offset);
					for (int i = 0; i < LIST_ROWS; i++) {
						if(i<list.size()) {
							ids[i].setText(list.get(i).getId() + "");
							titles[i].setText(list.get(i).getTitle());
							readCounts[i].setText(list.get(i).getReadCount() + "");
							writers[i].setText(list.get(i).getUsername());
						}
					}
				}
				if(offset >= 20 && userId != -1) {
					offset -= 20;
					list = new BlogController().requestBoardByUserId(userId, offset);
					for (int i = 0; i < LIST_ROWS; i++) {
						if(i<list.size()) {
							ids[i].setText(list.get(i).getId() + "");
							titles[i].setText(list.get(i).getTitle());
							readCounts[i].setText(list.get(i).getReadCount() + "");
							writers[i].setText(list.get(i).getUsername());
						}
					}
				}
				repaint();
			}
		});
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rowCount = new BlogDAO().rowCount();
				if(offset + 20 < rowCount && userId == -1) {
					offset += 20;
					list = new BlogController().requestBoardAll(offset);
					for (int i = 0; i < LIST_ROWS; i++) {
						if(i<list.size()) {
							ids[i].setText(list.get(i).getId() + "");
							titles[i].setText(list.get(i).getTitle());
							readCounts[i].setText(list.get(i).getReadCount() + "");
							writers[i].setText(list.get(i).getUsername());
						} else {
							ids[i].setText("");
							titles[i].setText("");
							readCounts[i].setText("");
							writers[i].setText("");
						}
					}
				}
				if(offset + 20 < rowCount && userId != -1) {
					rowCount = new BlogDAO().rowCount(userId);
					offset += 20;
					list = new BlogController().requestBoardByUserId(userId, offset);
					for (int i = 0; i < LIST_ROWS; i++) {
						if(i<list.size()) {
							ids[i].setText(list.get(i).getId() + "");
							titles[i].setText(list.get(i).getTitle());
							readCounts[i].setText(list.get(i).getReadCount() + "");
							writers[i].setText(list.get(i).getUsername());
						} else {
							ids[i].setText("");
							titles[i].setText("");
							readCounts[i].setText("");
							writers[i].setText("");
						}
					}
				}
				repaint();
			}
		});
	}

	public static void main(String[] args) {
		UserDTO dto = new UserController().requestSignIn("홍길동", "1234");
		new BoardFrame(dto);
	}

}
