package com.saleart.reporter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReportPagePropertiesDto implements Serializable {

    @Builder.Default
    private String size = "A4";

    @Builder.Default
    private String topMargin = "0";

    @Builder.Default
    private String leftMargin = "10mm";

    @Builder.Default
    private String rightMargin = "10mm";

    @Builder.Default
    private String bottomMargin = "0";

    @Builder.Default
    private String headerTopMargin = "0";

    @Builder.Default
    private String footerBottomMargin = "0";

}
