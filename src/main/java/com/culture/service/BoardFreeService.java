package com.culture.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culture.dto.BoardFreeDto;
import com.culture.entity.BoardFree;
import com.culture.repository.BoardFreeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardFreeService {
	private final BoardFreeRepository boardFreeRepository;
	
	// 글 작성
	public Long savedBoardWrite(BoardFreeDto boardFreeDto) throws Exception {
		BoardFree boardFree = boardFreeDto.boardwrite();
		
		boardFreeRepository.save(boardFree);
		
		return boardFree.getBoard_no();
	}

//	public Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable) {
//		
//		return boardFreeRepository.getBoardFreePage(boardFreeSearchDto, pageable);
//	}
	
	

}
