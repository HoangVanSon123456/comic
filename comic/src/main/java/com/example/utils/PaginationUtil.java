package com.example.utils;

import com.example.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    public static <T> PageResponse<T> buildPaginatedResponse(
            Page<?> springPage,
            Integer status,
            String message) {

        // Extract List<T> từ content (giả sử content là List<T>)
        @SuppressWarnings("unchecked")
        T content = (T) springPage.getContent();  // Cast an toàn vì T là List<DTO>

        return PageResponse.<T>builder()
                .status(status)
                .message(message)
                .data(PageResponse.PageContent.<T>builder()
                        .content(content)
                        .page(springPage.getNumber())
                        .size(springPage.getSize())
                        .totalElements(springPage.getTotalElements())
                        .totalPages(springPage.getTotalPages())
                        .sort("createdAt: DESC")
                        .numberOfElements(springPage.getNumberOfElements())
                        .build())
                .build();
    }
}
