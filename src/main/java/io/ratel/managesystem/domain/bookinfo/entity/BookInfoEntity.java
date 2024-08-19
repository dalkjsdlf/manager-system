package io.ratel.managesystem.domain.bookinfo.entity;

import io.ratel.managesystem.common.entity.AuditableFields;
import io.ratel.managesystem.domain.bookinfo.model.Category;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Table(name="BOOK_INFO")
@Entity
@Getter
public class BookInfoEntity extends AuditableFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 255)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "PUBLISHER", nullable = false)
    private String publisher;

    @Column(name = "DESCRIPTION", nullable = true, length = 4000)
    private String description;

    @Column(name = "CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "LINK", nullable = true)
    private String link;

    @Column(name = "ISBN", nullable = false, length = 10)
    private String isbn;

    @Column(name = "ISBN13", nullable = false, length = 13)
    private String isbn13;

    @Column(name = "COVER", nullable = true)
    private String cover;

    @Column(name = "PUBLISHED_DATE", nullable = false)
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
