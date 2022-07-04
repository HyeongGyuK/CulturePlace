package com.culture.dto.BoardFreeDto;//package com.culture.dto;

import com.culture.entity.boardFree.BoardFreeReply;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardFreeReplyWriteDto {
    private Long board_no;
    private int reply_no;

    @NotBlank(message = "댓글의 내용을 입력하여 주세요.")
    private String reply_content;
    private String reply_writer;
    private LocalDateTime reply_regdate;

    private static ModelMapper modelMapper = new ModelMapper();

    public BoardFreeReply replyWrite() {
        return modelMapper.map(this,BoardFreeReply.class);
    }
}