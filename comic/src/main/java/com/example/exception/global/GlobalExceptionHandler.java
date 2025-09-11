package com.example.exception.global;

import com.example.dto.response.PageResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;  // Cho 403
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice // Áp dụng global cho tất cả controller
public class GlobalExceptionHandler {

    // Xử lý 403 Forbidden
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<PageResponse<Object>> handleAccessDenied(AccessDeniedException ex) {
        PageResponse<Object> errorResponse = PageResponse.builder()
                .status(403)
                .message("Truy cập bị từ chối! Bạn không có quyền thực hiện hành động này.")
                .data(null)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    // Xử lý 404 Not Found
    @ExceptionHandler(EntityNotFoundException.class)  // Giả sử bạn có class này
    public ResponseEntity<PageResponse<Object>> handleNotFound(EntityNotFoundException ex) {
        PageResponse<Object> errorResponse = PageResponse.builder()
                .status(404)
                .message("Không tìm thấy dữ liệu!")
                .data(null)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Xử lý ResponseStatusException chung (cho 400, 500, v.v.)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<PageResponse<Object>> handleResponseStatus(ResponseStatusException ex) {
        PageResponse<Object> errorResponse = PageResponse.builder()
                .status(ex.getStatusCode().value())
                .message(ex.getReason())
                .data(null)
                .build();
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    // Xử lý Exception chung (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<PageResponse<Object>> handleGenericException(Exception ex) {
        PageResponse<Object> errorResponse = PageResponse.builder()
                .status(500)
                .message("Lỗi hệ thống! Vui lòng thử lại sau.")
                .data(null)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
