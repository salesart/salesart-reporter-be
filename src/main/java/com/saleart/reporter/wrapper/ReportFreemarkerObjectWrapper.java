package com.saleart.reporter.wrapper;

import freemarker.template.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReportFreemarkerObjectWrapper extends DefaultObjectWrapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ReportFreemarkerObjectWrapper() {
        super(new Version(2, 3, 34));
    }

    @Override
    public TemplateModel wrap(Object object) throws TemplateModelException {
        if (object instanceof LocalDateTime localDateTime) {
            return new SimpleScalar(localDateTime.format(DATE_TIME_FORMATTER));
        }
        if (object instanceof LocalDate localDate) {
            return new SimpleScalar(localDate.format(DATE_FORMATTER));
        }
        if (object instanceof LocalTime localTime) {
            return new SimpleScalar(localTime.format(TIME_FORMATTER));
        }
        return super.wrap(object);
    }

}
