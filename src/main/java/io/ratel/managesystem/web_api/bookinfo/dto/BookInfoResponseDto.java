package io.ratel.managesystem.web_api.bookinfo.dto;

import io.ratel.managesystem.domain.bookinfo.model.BookInfo;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@RequiredArgsConstructor
public class BookInfoResponseDto {

    private final String title;
    private final String author;
    private final String publisher;
    private final String description;
    private final String link;

    @Size(min = 10, max = 10, message = "Field must be exactly 10 characters long")
    private final String isbn;

    @Size(min = 13, max = 13, message = "Field must be exactly 13 characters long")
    private final String isbn13;

    private final String cover;

    private final LocalDateTime publishedDate;

    public static BookInfoResponseDto convertToBookInfoResponseDto(BookInfo bookInfo) {
        return BookInfoResponseDto.builder()
                .title(bookInfo.getTitle())
                .author(bookInfo.getAuthor())
                .publisher(bookInfo.getPublisher())
                .description(bookInfo.getDescription())
                .link(bookInfo.getLink())
                .isbn(bookInfo.getIsbn())
                .isbn13(bookInfo.getIsbn13())
                .cover(bookInfo.getCover())
                .publishedDate(bookInfo.getPublishedDate())
                .build();
    }

    public static List<BookInfoResponseDto> convertToBookInfosResponseDtoList(List<BookInfo> books) {
        return books.stream().map(BookInfoResponseDto::convertToBookInfoResponseDto).collect(Collectors.toList());
    }
}
