package com.culture.repository;

import com.culture.dto.BoardFreeDto.BoardFreeReplyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardFreeReplyRepositoryCustom {

    @Query(value = " select * from board_free_reply b where b.board_no = ?1 order by b.reply_no asc ", nativeQuery = true)
    List<BoardFreeReplyDto> getBoardFreeReplyPage(@Param("board_no") Long board_no);
}
