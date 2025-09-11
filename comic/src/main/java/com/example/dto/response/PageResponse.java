package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {
    public Integer status;
    public String message;
    public PageContent<T> data;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PageContent<T> {
        private T content;
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
        @JsonProperty("numberOfElements")
        private int numberOfElements;
        @JsonProperty("sort")
        private String sort;

    }

}
