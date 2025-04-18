package com.saleart.reporter.util;

import com.saleart.reporter.exception.ReporterInternalException;
import com.saleart.reporter.exception.guide.ReporterErrorGuide;
import com.saleart.reporter.wrapper.ReportFreemarkerObjectWrapper;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@UtilityClass
public class ReportFreemarkerUtil {

    public static final String ERROR_CODE = "TRNS_ERR_001";

    public static final String TRANSFORMER_ERROR_MESSAGE = "An error occurred while transforming the report into a template.";

    public static Template createTemplate(String template) {
        try {
            String name = UUID.randomUUID().toString();
            Configuration configuration = createConfiguration(template, name);
            return configuration.getTemplate(name);
        } catch (IOException e) {
            throw new ReporterInternalException(ReporterErrorGuide.FREEMARKER_UTIL_ERROR_DTO, e);
        }
    }

    public static Configuration createConfiguration(String template, String name) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_33);
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate(name, template);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setTemplateLoader(stringTemplateLoader);
        configuration.setLogTemplateExceptions(false);
        configuration.setObjectWrapper(new ReportFreemarkerObjectWrapper());
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return configuration;
    }

}
