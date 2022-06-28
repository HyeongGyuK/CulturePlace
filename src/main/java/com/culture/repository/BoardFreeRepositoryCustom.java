package com.culture.repository;

import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;
import com.culture.entity.boardFree.BoardFree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardFreeRepositoryCustom {
	Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable);
}
