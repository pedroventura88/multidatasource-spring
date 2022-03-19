package com.ventura.multidatasource.core.remediation;

import org.springframework.http.ResponseEntity;

public interface RemediationService {
    ResponseEntity<Void> createRemediation(Remediation remediation);
}
