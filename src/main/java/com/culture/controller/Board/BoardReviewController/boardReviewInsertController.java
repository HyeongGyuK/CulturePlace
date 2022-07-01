package com.culture.controller.Board.BoardReviewController;

import com.culture.dto.BoardReviewFormDto;
import com.culture.service.BoardReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class boardReviewInsertController {

	@GetMapping(value = "/insert/new")
	public String reviewInsertForm(Model model){
		model.addAttribute("boardReviewFormDto", new BoardReviewFormDto());
		return "thymeleaf/boardReview/boardReview_insert" ;
	}

	private final BoardReviewService boardReviewService;

	@PostMapping(value = "/insert/new")
	public String boardReviewNew(@Valid BoardReviewFormDto boardReviewFormDto, BindingResult bindingResult, Model model,
								 @RequestParam("boardReviewImgFile")List<MultipartFile> boardReviewImgFileList){
		if(bindingResult.hasErrors()){
			System.out.println("에러1");

			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<>();

			for(int i=0;i<list.size();i++) {
				String field = list.get(i).getField();
				String message = list.get(i).getDefaultMessage();

				System.out.println("필드 = " + field);
				System.out.println("메세지 = " +message);

				errorMsg.put(field, message);
			}

			return "thymeleaf/boardReview/boardReview_insert";
		}

		if(boardReviewImgFileList.get(0).isEmpty() && boardReviewFormDto.getBno() == null){
			System.out.println("에러2");
			model.addAttribute("errorMessage", "이미지를 첨부해주세요.");
			return "thymeleaf/boardReview/boardReview_insert";
		}

		try{
			boardReviewService.saveBoardReview(boardReviewFormDto, boardReviewImgFileList);
		}catch (Exception e){
			System.out.println("에러3");
			model.addAttribute("errorMessage", "리뷰 등록중 오류가 발생했습니다.");
			return "thymeleaf/boardReview/boardReview_insert";
		}

		return "redirect:/board/main";
	}
}