package com.culture.service;

import com.culture.dto.BoardFreeDto.BoardFreeReplyDto;
import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.entity.boardFree.BoardFree;
import com.culture.entity.boardFree.BoardFreeReply;
import com.culture.repository.BoardFreeReplyRepository;
import com.culture.repository.BoardFreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;
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

    public List<BoardFreeReplyDto> getReplyPage(Long board_no){

        BoardFree boardFree = boardFreeRepository.getById(board_no);

        BoardFreeReply boardFreeReply = null;
        List<BoardFreeReplyDto> boardFreeReplyDtoList = new ArrayList<>();
        try {
            boardFreeReply = boardFreeReplyRepository.findByBoardFree(boardFree);

            if(boardFreeReply == null){
                return boardFreeReplyDtoList;
            }else{
//            BoardFree boardNo = boardFreeReply.getBoardFree();
                boardFreeReplyDtoList = boardFreeReplyRepository.findByBoardFreeReplyDtoList(board_no);
                return boardFreeReplyDtoList;
            }

        }catch ( Exception e){
            boardFreeReplyDtoList = boardFreeReplyRepository.findByBoardFreeReplyDtoList(board_no);
            return boardFreeReplyDtoList;
        }

//        List<BoardFreeReplyDto> boardFreeReplyDtoList = new ArrayList<>();

//        if(boardFreeReply == null){
//            return boardFreeReplyDtoList;
//        }else{
////            BoardFree boardNo = boardFreeReply.getBoardFree();
//            boardFreeReplyDtoList = boardFreeReplyRepository.findByBoardFreeReplyDtoList(board_no);
//            return boardFreeReplyDtoList;
//        }





//        return boardFreeReplyRepository.getBoardFreeReplyPage(board_no);
    }
}
