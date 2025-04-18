package com.saleart.reporter.transformer;

import com.saleart.reporter.exception.ReporterInternalException;
import com.saleart.reporter.exception.guide.ReporterErrorGuide;
import com.saleart.reporter.util.ReportFreemarkerUtil;
import freemarker.core.Environment;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class ReportFreemarkerTransformerImpl implements ReportFreemarkerTransformer {

    @Override
    public String transform(@NotBlank String html, Map<String, ? extends Serializable> parameterMap) {
        return process(ReportFreemarkerUtil.createTemplate(html), parameterMap);
    }

    @Override
    public String transform(@NotNull Template template, Map<String, ? extends Serializable> parameterMap) {
        return process(template, parameterMap);
    }

    private String process(Template template, Map<String, ? extends Serializable> parameterMap) {
        try (StringWriter stringWriter = new StringWriter()) {
            Environment environment = template.createProcessingEnvironment(parameterMap, stringWriter);
            environment.setOutputEncoding(StandardCharsets.UTF_8.name());
            environment.process();
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new ReporterInternalException(ReporterErrorGuide.TRANSFORMER_ERROR_DTO, e);
        }
    }

}
