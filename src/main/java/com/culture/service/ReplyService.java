package com.culture.service;

import com.culture.dto.BoardFreeDto.BoardFreeReplyWriteDto;
import com.culture.entity.boardFree.BoardFreeReply;
import com.culture.repository.BoardFreeReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final BoardFreeReplyRepository boardFreeReplyRepository;

    public int savedBoardFreeReplyWrite(BoardFreeReplyWriteDto boardFreeReplyWriteDto) throws Exception{
        BoardFreeReply boardFreeReply = boardFreeReplyWriteDto.replyWrite();
        boardFreeReplyRepository.save(boardFreeReply);
        return boardFreeReply.getReply_no();
    }
}
