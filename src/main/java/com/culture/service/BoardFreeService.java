package com.culture.service;


import com.culture.dto.BoardFreeDto.BoardFreeDto;
import com.culture.dto.BoardFreeDto.BoardFreeSearchDto;
import com.culture.dto.BoardFreeDto.BoardFreeWriteDto;
import com.culture.entity.boardFree.BoardFree;
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
	@Transactional
	public Long savedBoardFreeWrite(BoardFreeWriteDto boardFreeWriteDto) throws Exception {
		BoardFree boardWrite = boardFreeWriteDto.boardFreeWrite();
		boardFreeRepository.save(boardWrite);

		return boardWrite.getBoard_no();
	}

	// 전체 글 목록 출력
	public Page<BoardFree> getBoardFreePage(BoardFreeSearchDto boardFreeSearchDto, Pageable pageable) {
		return boardFreeRepository.getBoardFreePage(boardFreeSearchDto, pageable);
	}

	// board_free_detail 화면에서 보여줄 Service입니다.
	@Transactional(readOnly = true)
	public BoardFreeDto getBoardDetail(Long board_no) {
		BoardFree boardFree = boardFreeRepository.findById(board_no).orElseThrow(EntityNotFoundException::new);

		BoardFreeDto boardFreeDto = BoardFreeWriteDto.of(boardFree);

		return boardFreeDto;
	}

	public Long boardFreeUpdate(BoardFreeWriteDto boardFreeWriteDto) throws Exception{
		BoardFree boardFree = boardFreeRepository.findById(boardFreeWriteDto.getBoard_no())
				.orElseThrow(EntityNotFoundException::new);
		boardFree.updateBoardFree(boardFreeWriteDto);

		return boardFree.getBoard_no();
	}

	public void boardFreeDelete(Long board_no) throws Exception{
		boardFreeRepository.deleteById(board_no);
	}

	// 조회수 증가
	@Transactional
	public int updateBoardFreeReadHit(Long board_no){
		return boardFreeRepository.updateBoardFreeReadHit(board_no);
	}
}
