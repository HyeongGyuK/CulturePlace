package com.culture.repository;

import com.culture.dto.BoardFreeSearchDto;
import com.culture.entity.BoardFree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardFreeRepositoryCustom {
	Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable);
}
