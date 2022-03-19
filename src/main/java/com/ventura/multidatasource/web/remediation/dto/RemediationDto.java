package com.ventura.multidatasource.web.remediation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemediationDto {
    private String problem;
    private String anomaly;
}
