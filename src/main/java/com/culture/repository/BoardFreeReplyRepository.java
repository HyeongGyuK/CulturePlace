package com.culture.repository;

import com.culture.dto.BoardFreeDto.BoardFreeReplyDto;
import com.culture.entity.boardFree.BoardFree;
import com.culture.entity.boardFree.BoardFreeReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardFreeReplyRepository extends JpaRepository<BoardFreeReply, Long>,
        QuerydslPredicateExecutor<BoardFreeReply>, BoardFreeReplyRepositoryCustom {

    BoardFreeReply findByBoardFree(BoardFree board_no);

    @Query(" select new com.culture.dto.BoardFreeDto.BoardFreeReplyDto(bf.board_no, bfr.reply_no, bfr.reply_content, bf.board_writer, bf.board_regdate) " +
            " from BoardFreeReply bfr, BoardFree bf" +
            " where bf.board_no = :board_no  and bfr.boardFree = :board_no" +
            " order by bfr.reply_no desc ")
    List<BoardFreeReplyDto> findByBoardFreeReplyDtoList(Long board_no);
}
