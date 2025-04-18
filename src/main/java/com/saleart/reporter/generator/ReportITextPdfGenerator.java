package com.saleart.reporter.generator;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ReportITextPdfGenerator {

    void generate(@NotBlank String html, @NotBlank String outputFilePath);

    byte[] generate(@NotBlank String html);

}
