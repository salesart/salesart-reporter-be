package com.saleart.reporter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saleart.reporter.constant.ReportConstant;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReportPreviewDto implements Serializable {

    private String htmlHeaderPart;

    private String htmlMainPart;

    private String htmlFooterPart;

    @Builder.Default
    private ReportPagePropertiesDto pageProperties = new ReportPagePropertiesDto();

    private Map<String, ? extends Serializable> parameterMap;

    @JsonIgnore
    public Map<String, Serializable> getAttributeAndValue() {
        Map<String, Serializable> attributeAndValueMap = new HashMap<>();
        if (MapUtils.isNotEmpty(parameterMap)) {
            attributeAndValueMap.putAll(parameterMap);
        }
        attributeAndValueMap.put(ReportConstant.PAGE_SIZE_ATTRIBUTE, pageProperties.getSize());
        attributeAndValueMap.put(ReportConstant.PAGE_TOP_MARGIN_ATTRIBUTE, pageProperties.getTopMargin());
        attributeAndValueMap.put(ReportConstant.PAGE_LEFT_MARGIN_ATTRIBUTE, pageProperties.getLeftMargin());
        attributeAndValueMap.put(ReportConstant.PAGE_RIGHT_MARGIN_ATTRIBUTE, pageProperties.getRightMargin());
        attributeAndValueMap.put(ReportConstant.PAGE_BOTTOM_MARGIN_ATTRIBUTE, pageProperties.getBottomMargin());
        attributeAndValueMap.put(ReportConstant.HEADER_TOP_MARGIN_ATTRIBUTE, pageProperties.getHeaderTopMargin());
        attributeAndValueMap.put(ReportConstant.FOOTER_BOTTOM_MARGIN_ATTRIBUTE, pageProperties.getFooterBottomMargin());
        attributeAndValueMap.put(ReportConstant.CSS_PART_ATTRIBUTE, ReportConstant.TEMPLATE_CSS);
        if (StringUtils.isNotBlank(htmlHeaderPart)) {
            htmlHeaderPart = ReportConstant.FREEMARKER_TR_SETTING + htmlHeaderPart;
            attributeAndValueMap.put(ReportConstant.HEADER_PART_ATTRIBUTE, htmlHeaderPart);
        }
        if (StringUtils.isNotBlank(htmlMainPart)) {
            htmlMainPart = ReportConstant.FREEMARKER_TR_SETTING + htmlMainPart;
            attributeAndValueMap.put(ReportConstant.MAIN_PART_ATTRIBUTE, htmlMainPart);
        }
        if (StringUtils.isNotBlank(htmlFooterPart)) {
            htmlFooterPart = ReportConstant.FREEMARKER_TR_SETTING + htmlFooterPart;
            attributeAndValueMap.put(ReportConstant.FOOTER_PART_ATTRIBUTE, htmlFooterPart);
        }
        attributeAndValueMap.put(ReportConstant.FOOTER_PART_PAGE_ATTRIBUTE, ReportConstant.FOOTER_PART_PAGE_VALUE);
        return attributeAndValueMap;
    }

}
