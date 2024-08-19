package io.ratel.managesystem.domain.bookinfo.service;

import io.ratel.managesystem.domain.bookinfo.component.BookInfoSupporter;
import io.ratel.managesystem.domain.bookinfo.model.BookInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookInfoService {

    private BookInfoSupporter bookInfoSupportor;
    private WebClient webClient;

    @Value("${aladin.api.key}")
    String aladinApiKey;

    public List<BookInfo> getBooks(){
        Flux<BookInfo> books = webClient.get().
                uri(uriBuilder -> uriBuilder.
                        path("ItemList.aspx").
                        queryParam("ttbkey",aladinApiKey).
                        queryParam("QueryType","ItemNewAll").
                        queryParam("MaxResults",10).
                        queryParam("start",1).
                        queryParam("SearchTarget","Book").
                        queryParam("output","xml").
                        queryParam("Version","20131101").
                        build()).
                retrieve().
                bodyToFlux(BookInfo.class);
        Mono<List<BookInfo>> monoBooks = books.collectList();
        return monoBooks.block();
    }
}
