package com.culture.repository;

import com.culture.dto.BoardFreeDto.BoardFreeReplyDto;
import com.culture.dto.BoardFreeDto.QBoardFreeReplyDto;
import com.culture.entity.boardFree.QBoardFree;
import com.culture.entity.boardFree.QBoardFreeReply;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class BoardFreeReplyRepositoryCustomImpl implements BoardFreeReplyRepositoryCustom{

    private JPAQueryFactory queryFactory;

    @Override
    public List<BoardFreeReplyDto> getBoardFreeReplyPage(Long board_no) {
        QBoardFreeReply boardFreeReply = QBoardFreeReply.boardFreeReply;
        QBoardFree boardFree = QBoardFree.boardFree;

        QueryResults<BoardFreeReplyDto> results = queryFactory
                .select(
                        new QBoardFreeReplyDto(
                                boardFree.board_no,
                                boardFreeReply.reply_no,
                                boardFreeReply.reply_content,
                                boardFreeReply.reply_writer,
                                boardFreeReply.reply_regdate)
                )
                .from(boardFreeReply)
                .where(boardFree.board_no.eq(board_no))
                .orderBy(boardFreeReply.reply_no.desc())
                .fetchResults();

        List<BoardFreeReplyDto> content = results.getResults();

        return content;
    }
}
