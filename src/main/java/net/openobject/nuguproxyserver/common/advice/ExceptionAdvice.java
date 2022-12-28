package net.openobject.nuguproxyserver.common.advice;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import net.openobject.nuguproxyserver.common.dto.ApiExceptionDTO;
import net.openobject.nuguproxyserver.common.dto.NuguExceptionDTO;
import net.openobject.nuguproxyserver.common.enums.ExceptionEnum;
import net.openobject.nuguproxyserver.common.exception.ApiException;
import net.openobject.nuguproxyserver.common.exception.NuguException;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(HttpServletRequest request, final ApiException e) {

        String message = StringUtils.defaultString(e.getMessage(), e.getError().getMessage());

        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiExceptionDTO.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(message)
                        .build());
    }

    @ExceptionHandler({NuguException.class})
    public ResponseEntity<NuguExceptionDTO> exceptionHandler(HttpServletRequest request, final NuguException e) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(NuguExceptionDTO.builder().version("2.0").resultCode(e.getError().getCode())
                        .build());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.BAD_REQUEST_EXCEPTION.getStatus())
                .body(ApiExceptionDTO.builder()
                        .errorCode(ExceptionEnum.BAD_REQUEST_EXCEPTION.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
                .body(ApiExceptionDTO.builder()
                        .errorCode(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }
    
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(HttpServletRequest request, final MethodArgumentNotValidException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ARGUMENT_NOT_VALIDATION_EXCEPTION.getStatus())
                .body(ApiExceptionDTO.builder()
                        .errorCode(ExceptionEnum.ARGUMENT_NOT_VALIDATION_EXCEPTION.getCode())
                        .errorMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(HttpServletRequest request, final Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiExceptionDTO.builder()
                        .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errorMessage(e.getMessage())
                        .build());
    }
}