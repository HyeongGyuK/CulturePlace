package com.culture.dto.BoardFreeDto;

import com.culture.entity.boardFree.Notice;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter @Setter
public class NoticeWriteDto {
    @Id
    @GeneratedValue
    private Long notice_no;

    private String notice_writer;

    @NotBlank(message = "제목은 필수 입력 사항입니다.")
    private String notice_title;

    @NotBlank(message = "내용은 필수 입력 사항입니다.")
    private String notice_content;

    private static ModelMapper modelMapper = new ModelMapper();

    public Notice noticeWrite(){
        return modelMapper.map(this, Notice.class);
    }
}
