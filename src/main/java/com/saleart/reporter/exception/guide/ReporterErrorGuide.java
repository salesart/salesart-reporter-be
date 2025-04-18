package com.saleart.reporter.exception.guide;

import com.saleart.reporter.dto.ReportErrorDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReporterErrorGuide {

    private static final String TRANSFORMER_ERROR_CODE = "TRNS_ERR_001";

    private static final String TRANSFORMER_ERROR_MESSAGE = "An error occurred while transforming the report into a template.";

    public static final ReportErrorDto TRANSFORMER_ERROR_DTO = ReportErrorDto.builder()
            .code(TRANSFORMER_ERROR_CODE)
            .message(TRANSFORMER_ERROR_MESSAGE)
            .build();

    private static final String FREEMARKER_UTIL_ERROR_CODE = "FRMKR_UTL_ERR_001";

    private static final String FREEMARKER_UTIL_ERROR_MESSAGE = "An error occurred while creating the report into a template.";

    public static final ReportErrorDto FREEMARKER_UTIL_ERROR_DTO = ReportErrorDto.builder()
            .code(FREEMARKER_UTIL_ERROR_CODE)
            .message(FREEMARKER_UTIL_ERROR_MESSAGE)
            .build();

    private static final String ITEXT_PDF_GENERATOR_ERROR_CODE = "ITEXT_PDF_GNR_ERR_001";

    private static final String ITEXT_PDF_GENERATOR_ERROR_MESSAGE = "An error occurred while generating the pdf.";

    public static final ReportErrorDto ITEXT_PDF_GENERATOR_ERROR_DTO = ReportErrorDto.builder()
            .code(ITEXT_PDF_GENERATOR_ERROR_CODE)
            .message(ITEXT_PDF_GENERATOR_ERROR_MESSAGE)
            .build();

    private static final String ITEXT_PDF_AREA_BREAKER_ERROR_CODE = "ITEXT_PDF_GNR_ERR_002";

    private static final String ITEXT_PDF_AREA_BREAKER_ERROR_MESSAGE = "An error occurred while generating the pdf by area breaker.";

    public static final ReportErrorDto ITEXT_PDF_AREA_BREAKER_ERROR_DTO = ReportErrorDto.builder()
            .code(ITEXT_PDF_AREA_BREAKER_ERROR_CODE)
            .message(ITEXT_PDF_AREA_BREAKER_ERROR_MESSAGE)
            .build();

}
