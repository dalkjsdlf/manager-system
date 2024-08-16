package io.fds.managesystem.web_api.bookinfo.usecase;

import io.fds.managesystem.domain.bookinfo.service.BookInfoService;
import io.fds.managesystem.web_api.bookinfo.dto.BookInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetBooksUseCase {

    private final BookInfoService bookInfoService;

    public List<BookInfoResponseDto> executor() {
        return BookInfoResponseDto.convertToBookInfosResponseDtoList(bookInfoService.getBooks());
    }
}
