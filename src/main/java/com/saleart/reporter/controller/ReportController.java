package com.saleart.reporter.controller;

import com.saleart.reporter.dto.ReportPreviewDto;
import com.saleart.reporter.service.ReportService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping(path = "/report")
@CrossOrigin(origins = "*")
@Slf4j
public class ReportController {

    private final ReportService reportService;

    private final HttpHeaders pdfPreviewHeader;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
        this.pdfPreviewHeader = new HttpHeaders();
        this.pdfPreviewHeader.setContentType(MediaType.APPLICATION_PDF);
        this.pdfPreviewHeader.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
        this.pdfPreviewHeader.setContentDispositionFormData("attachment", System.currentTimeMillis() + ".pdf");
    }

    @PostMapping(path = "/pdf/preview")
    public ResponseEntity<StreamingResponseBody> pdfPreview(@RequestBody @NotNull ReportPreviewDto reportPreviewDto) {
        return new ResponseEntity<>(
                outputStream -> outputStream.write(reportService.pdfPreview(reportPreviewDto)),
                pdfPreviewHeader,
                HttpStatus.OK
        );
    }

}
