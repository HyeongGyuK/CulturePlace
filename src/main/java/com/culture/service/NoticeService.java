//package com.culture.service;
//
//import com.culture.entity.boardFree.Notice;
//import com.culture.repository.NoticeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class NoticeService {
//    private final NoticeRepository noticeRepository;
//
//    public Page<Notice> getNoticePage(Pageable pageable) {
//        return noticeRepository.getNoticePage(pageable);
//    }
//}
