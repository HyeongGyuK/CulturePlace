package com.culture.service;

import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.entity.boardFree.BoardFree;
import com.culture.entity.boardFree.BoardFreeReply;
import com.culture.repository.BoardFreeReplyRepository;
import com.culture.repository.BoardFreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final BoardFreeReplyRepository boardFreeReplyRepository;
    private final BoardFreeRepository boardFreeRepository;

    //    public int savedBoardFreeReplyWrite(BoardFreeReplyWriteDto boardFreeReplyWriteDto, Long board_no) throws Exception{
    public BoardFreeReply savedBoardFreeReplyWrite(BoardFreeReplyWriteDto boardFreeReplyWriteDto, Long board_no) throws Exception{
        BoardFreeReply boardFreeReply = boardFreeReplyWriteDto.replyWrite();
        boardFreeReply.setReply_content(boardFreeReply.getReply_content());
//        boardFreeReply.setBoard_no(board_no);
//        boardFreeReply.setBoard_no(board_no);
        BoardFree boardFree = boardFreeRepository.findById(board_no).orElseThrow(EntityNotFoundException::new);

        boardFreeReply.setBoardFree(boardFree);
        boardFreeReplyRepository.save(boardFreeReply);

//        BoardFreeReply boardFreeReply = new BoardFreeReply();



//        boardFreeReply.setReply_no(boardFreeReplyWriteDto.getReply_no());
//
//        boardFreeReply.setReply_regdate(boardFreeReplyWriteDto.getReply_regdate());
//        boardFreeReply.setReply_writer(boardFreeReply.getReply_writer());

//        return boardFreeReply.getReply_no();
        return boardFreeReply;
    }

    public List<BoardFreeReply> getReplyPage(Long board_no){
        return boardFreeReplyRepository.getBoardFreeReplyPage(board_no);
    }
}
