package com.saleart.reporter.transformer;

import freemarker.template.Template;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Map;

@Validated
public interface ReportFreemarkerTransformer {

    String transform(@NotBlank String html, Map<String, ? extends Serializable> parameterMap);

    String transform(@NotNull Template template, Map<String, ? extends Serializable> parameterMap);

}
