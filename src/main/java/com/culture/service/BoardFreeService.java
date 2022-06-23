package com.culture.service;


import com.culture.dto.BoardFreeDto;
import com.culture.dto.BoardFreeSearchDto;
import com.culture.entity.BoardFree;
import com.culture.repository.BoardFreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardFreeService {

	private final BoardFreeRepository boardFreeRepository;

	// 글 작성
	public Long savedBoardWrite(BoardFreeDto boardFreeDto) throws Exception {
		BoardFree boardFree = boardFreeDto.boardWrite();
		boardFreeRepository.save(boardFree);

		return boardFree.getBoard_no();
	}

	// 전체 글 목록 출력
	public Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable) {
		return boardFreeRepository.getBoardFreePage(boardFreeSearchDto, pageable);
	}

	// board_free_detail 화면에서 보여줄 Service입니다.
	@Transactional(readOnly = true)
    public BoardFreeDto getBoardDetail(Long board_no) {
		BoardFree boardFree = boardFreeRepository.findById(board_no).orElseThrow(EntityNotFoundException::new);

		BoardFreeDto boardFreeDto = BoardFreeDto.of(boardFree);

		return boardFreeDto;
    }
}
