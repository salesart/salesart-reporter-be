package com.saleart.reporter.generator;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.renderer.AreaBreakRenderer;
import com.saleart.reporter.exception.ReporterInternalException;
import com.saleart.reporter.exception.guide.ReporterErrorGuide;
import jakarta.validation.constraints.NotBlank;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class ReportITextPdfGeneratorImpl implements ReportITextPdfGenerator {

    private static final String FONTS_RESOURCE_PATH = "classpath:fonts/*.ttf";

    private final ConverterProperties converterProperties;

    public ReportITextPdfGeneratorImpl() throws IOException {
        this.converterProperties = new ConverterProperties();
        this.converterProperties.setCharset(StandardCharsets.UTF_8.name());
        loadFont(this.converterProperties);
    }

    @Override
    public void generate(@NotBlank String html, @NotBlank String outputFilePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
            HtmlConverter.convertToPdf(html, fileOutputStream, converterProperties);
        } catch (UnsupportedOperationException e) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            if (stackTraceElement.getClassName().equals(AreaBreakRenderer.class.getName())) {
                throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_AREA_BREAKER_ERROR_DTO, e);
            }
            throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_GENERATOR_ERROR_DTO, e);
        } catch (IOException e) {
            throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_GENERATOR_ERROR_DTO, e);
        }
    }

    @Override
    public byte[] generate(@NotBlank String html) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            HtmlConverter.convertToPdf(html, byteArrayOutputStream, converterProperties);
            return byteArrayOutputStream.toByteArray();
        } catch (UnsupportedOperationException e) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            if (stackTraceElement.getClassName().equals(AreaBreakRenderer.class.getName())) {
                throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_AREA_BREAKER_ERROR_DTO);
            }
            throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_GENERATOR_ERROR_DTO, e);
        } catch (IOException e) {
            throw new ReporterInternalException(ReporterErrorGuide.ITEXT_PDF_GENERATOR_ERROR_DTO, e);
        }
    }

    private static void loadFont(ConverterProperties converterProperties) throws IOException {
        FontProvider fontProvider = new FontProvider();
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(FONTS_RESOURCE_PATH);
        for (Resource resource : resources) {
            try (InputStream fontStream = resource.getInputStream()) {
                fontProvider.addFont(fontStream.readAllBytes());
            }
        }
        converterProperties.setFontProvider(fontProvider);
    }

}
