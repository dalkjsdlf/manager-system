package io.fds.managesystem.web_api.bookinfo.controller;

import io.fds.managesystem.web_api.bookinfo.dto.BookInfoResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/books")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BookInfoController {

    @GetMapping("")
    public ResponseEntity<List<BookInfoResponseDto>> getBooks(){

      log.debug("책 정보");
      return ResponseEntity.ok(
              List.of(BookInfoResponseDto.builder()
              .title("책 제목")
              .author("저자")
              .cover("https://edit.org/images/cat/book-covers-big-2019101610.jpg")
              .build()));
    }
}
