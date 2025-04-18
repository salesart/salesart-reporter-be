package com.saleart.reporter.exception;

import com.saleart.reporter.dto.ReportErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ReporterExceptionHandler extends ResponseEntityExceptionHandler {

    private static final HttpHeaders HTTP_HEADERS = new HttpHeaders();

    static {
        HTTP_HEADERS.setContentType(MediaType.APPLICATION_JSON);
    }

    @ExceptionHandler(value = ReporterInternalException.class)
    protected ResponseEntity<Object> handleReporterInternalException(ReporterInternalException exception, WebRequest webRequest) {
        ReportErrorDto reportErrorDto = exception.getErrorMessage();
        Throwable throwable = exception.getCause();
        logger.error(reportErrorDto.getMessage(), throwable);
        return handleExceptionInternal(exception,
                reportErrorDto,
                HTTP_HEADERS,
                HttpStatus.BAD_REQUEST,
                webRequest);
    }

}
