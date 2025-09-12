package com.example.exception.global;

import com.example.dto.response.BaseResponse;
import com.example.dto.response.PageResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;  // Cho 403
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice // Áp dụng global cho tất cả controller
public class GlobalExceptionHandler {

    @ExceptionHandler(TokenException.class)
    public ResponseEntity<BaseResponse<Void>> handleTokenExpired(TokenException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(BaseResponse.<Void>builder()
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .message(ex.getMessage())
                        .data(null)
                        .build());
    }

    // ✅ Truy cập bị từ chối (403)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<Void>> handleAccessDenied(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(BaseResponse.<Void>builder()
                        .status(HttpStatus.FORBIDDEN.value())
                        .message("Truy cập bị từ chối! Bạn không có quyền thực hiện hành động này.")
                        .data(null)
                        .build());
    }

    // ✅ Không tìm thấy dữ liệu (404)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponse<Void>> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(BaseResponse.<Void>builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage() != null ? ex.getMessage() : "Không tìm thấy dữ liệu!")
                        .data(null)
                        .build());
    }

    // ✅ Lỗi chung (400, 500...)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseResponse<Void>> handleResponseStatus(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(BaseResponse.<Void>builder()
                        .status(ex.getStatusCode().value())
                        .message(ex.getReason())
                        .data(null)
                        .build());
    }

    // ✅ Bắt tất cả các lỗi không xử lý riêng (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Void>> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponse.<Void>builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("Lỗi hệ thống! Vui lòng thử lại sau.")
                        .data(null)
                        .build());
    }

}
