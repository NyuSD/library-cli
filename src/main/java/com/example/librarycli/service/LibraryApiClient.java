package com.example.librarycli.service;

import com.example.librarycli.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class LibraryApiClient {

    private final String       baseUrl;
    private final HttpClient   http;
    private final ObjectMapper mapper;

    public LibraryApiClient(String baseUrl) {
        this(
            baseUrl,
            HttpClient.newBuilder()
                      .connectTimeout(Duration.ofSeconds(3))
                      .build(),
            new ObjectMapper()
        );
    }

    LibraryApiClient(String baseUrl, HttpClient http, ObjectMapper mapper) {
        this.baseUrl = baseUrl;
        this.http    = http;
        this.mapper  = mapper;
    }

    public List<BranchDto> getBranchesInCity(long cityId) throws Exception {
        return readList(
            "/api/cities/%d/branches".formatted(cityId),
            mapper.getTypeFactory().constructCollectionType(List.class, BranchDto.class)
        );
    }

    public List<BookDto> getBooksBorrowedByMember(long memberId) throws Exception {
        return readList(
            "/api/members/%d/books".formatted(memberId),
            mapper.getTypeFactory().constructCollectionType(List.class, BookDto.class)
        );
    }

    public List<BranchDto> getBranchesStockingBook(long bookId) throws Exception {
        return readList(
            "/api/books/%d/branches".formatted(bookId),
            mapper.getTypeFactory().constructCollectionType(List.class, BranchDto.class)
        );
    }

    public List<BranchDto> getBranchesVisitedByMember(long memberId) throws Exception {
        return readList(
            "/api/members/%d/branches".formatted(memberId),
            mapper.getTypeFactory().constructCollectionType(List.class, BranchDto.class)
        );
    }

    private <T> List<T> readList(String path,
                                 com.fasterxml.jackson.databind.JavaType type) throws Exception {

        HttpRequest req = HttpRequest.newBuilder()
                                     .uri(URI.create(baseUrl + path))
                                     .timeout(Duration.ofSeconds(5))
                                     .GET()
                                     .build();

        HttpResponse<String> resp =
            http.send(req, HttpResponse.BodyHandlers.ofString());

        if (resp.statusCode() >= 200 && resp.statusCode() < 300) {
            return mapper.readValue(resp.body(), type);
        }
        throw new IllegalStateException(
            "API returned " + resp.statusCode() + ": " + resp.body());
    }
}
