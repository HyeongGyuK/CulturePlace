package com.culture.dto.BoardFreeDto;

import com.culture.entity.boardFree.BoardFree;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardFreeWriteDto {
    @Id
    @GeneratedValue
    private Long board_no;

    private String board_writer;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String board_title;

    @NotBlank(message = "내용은 필수 입력 사항입니다.")
    private String board_content;

    private LocalDateTime board_regdate;
    private Integer board_readhit;

    private static ModelMapper modelMapper = new ModelMapper();

    public BoardFree boardFreeWrite() {
        return modelMapper.map(this, BoardFree.class); // source는 boardFreeWrite 자신을 뜻한다.
    }

    public static BoardFreeDto of(BoardFree boardFree) {
        return modelMapper.map(boardFree, BoardFreeDto.class);
    }
}
