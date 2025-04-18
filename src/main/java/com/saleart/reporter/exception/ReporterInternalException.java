package com.saleart.reporter.exception;

import com.saleart.reporter.dto.ReportErrorDto;
import lombok.Getter;

@Getter
public class ReporterInternalException extends RuntimeException {

    private final ReportErrorDto errorMessage;

    public ReporterInternalException(ReportErrorDto errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ReporterInternalException(ReportErrorDto errorMessage, Throwable cause) {
        super(cause);
        this.errorMessage = errorMessage;
    }

}
