package com.ventura.multidatasource.core.remediation;

import com.ventura.multidatasource.web.remediation.dto.RemediationDto;
import org.springframework.http.ResponseEntity;

public interface RemediationService {
    ResponseEntity<Void> createRemediation(RemediationDto remediation);
}
