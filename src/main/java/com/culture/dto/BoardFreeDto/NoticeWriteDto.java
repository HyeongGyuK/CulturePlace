package com.culture.dto.BoardFreeDto;

import com.culture.entity.boardFree.Notice;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class NoticeWriteDto {
    private Long notice_no;

    private String notice_write;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String notice_title;

    @NotBlank(message = "내용은 필수 입력 사항입니다.")
    private String notice_content;

    private LocalDateTime notice_regdate;

    private static ModelMapper modelMapper = new ModelMapper();

    public Notice noticeWrite(){
        return modelMapper.map(this, Notice.class);
    }

    public static NoticeDto of(Notice notice) {
        return modelMapper.map(notice, NoticeDto.class);
    }
}
