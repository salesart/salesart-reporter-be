package com.saleart.reporter.service;

import com.saleart.reporter.dto.ReportPreviewDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ReportService {

    byte[] pdfPreview(@NotNull ReportPreviewDto reportPreviewDto);

}
