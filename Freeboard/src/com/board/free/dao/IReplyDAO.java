package com.board.free.dao;

import java.util.ArrayList;

import com.board.free.dto.ReplyDTO;

public interface IReplyDAO {
	
	int createReply(ReplyDTO replyDTO);
	
	int updateReply(ReplyDTO replyDTO);
	
	int deleteReply(int id);
	
	ArrayList<ReplyDTO> showReply();
	
}
