package com.culture.service;

import com.culture.dto.BoardFreeDto.NoticeDto;
import com.culture.dto.BoardFreeDto.NoticeWriteDto;
import com.culture.entity.boardFree.Notice;
import com.culture.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public Page<Notice> getNoticePage(Pageable pageable) {
        return noticeRepository.getNoticePage(pageable);
    }

    @Transactional
    public Long savedNoticeWrite(NoticeWriteDto noticeWriteDto) throws Exception{
        Notice noticeWrite = noticeWriteDto.noticeWrite();
        noticeRepository.save(noticeWrite);

        return noticeWrite.getNotice_no();
    }

    @Transactional(readOnly = true)
    public NoticeDto getNoticeDetail(Long notice_no) {
        Notice notice = noticeRepository.findById(notice_no).orElseThrow(EntityNotFoundException::new);
        NoticeDto noticeDto = NoticeWriteDto.of(notice);

        return noticeDto;
    }

    public Long noticeUpdate(NoticeWriteDto noticeWriteDto) throws Exception{
        Notice notice = noticeRepository.findById(noticeWriteDto.getNotice_no())
                .orElseThrow(EntityNotFoundException::new);
        notice.updateNotice(noticeWriteDto);

        return notice.getNotice_no();
    }

    public void noticeDelete(Long notice_no) {
        noticeRepository.deleteById(notice_no);
    }

    // 조회수 증가
    @Transactional
    public int updateNoticeReadHit(Long notice_no) {
        return noticeRepository.updateNoticeReadHit(notice_no);
    }
}
