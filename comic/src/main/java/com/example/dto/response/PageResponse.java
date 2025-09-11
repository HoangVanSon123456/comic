package com.example.dto.response;

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
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;
        private boolean last;
        private T content;
    }

}
