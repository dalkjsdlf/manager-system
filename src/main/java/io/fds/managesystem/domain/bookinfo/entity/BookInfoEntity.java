package io.fds.managesystem.domain.bookinfo.entity;

import io.fds.managesystem.common.entity.AuditableFields;
import io.fds.managesystem.domain.bookinfo.model.Category;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Table
@Entity
@Getter
public class BookInfoEntity extends AuditableFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = true, length = 4000)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = true)
    private String link;

    @Column(nullable = false, length = 10)
    private String isbn;

    @Column(nullable = false, length = 13)
    private String isbn13;

    @Column(nullable = true)
    private String cover;

    @Column(nullable = false)
    private LocalDateTime publishedDate;

    protected BookInfoEntity() {}

    public BookInfoEntity(LocalDateTime publishedDate, String cover, String isbn13, String isbn, String link, String description, String publisher, String author, String title) {
        this.publishedDate = publishedDate;
        this.cover = cover;
        this.isbn13 = isbn13;
        this.isbn = isbn;
        this.link = link;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
    }
}
