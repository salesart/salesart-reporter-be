package com.saleart.reporter.service;

import com.saleart.reporter.constant.ReportConstant;
import com.saleart.reporter.dto.ReportPreviewDto;
import com.saleart.reporter.generator.ReportITextPdfGenerator;
import com.saleart.reporter.transformer.ReportFreemarkerTransformer;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportITextPdfGenerator reportITextPdfGenerator;

    private final ReportFreemarkerTransformer reportFreemarkerTransformer;

    @Override
    public byte[] pdfPreview(@NotNull ReportPreviewDto reportPreviewDto) {
        Map<String, Serializable> attributeAndValueMap = reportPreviewDto.getAttributeAndValue();
        return reportITextPdfGenerator.generate(
                reportFreemarkerTransformer.transform(
                        reportFreemarkerTransformer.transform(
                                ReportConstant.TEMPLATE,
                                attributeAndValueMap
                        ),
                        attributeAndValueMap
                )
        );
    }

}
