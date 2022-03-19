package com.ventura.multidatasource.core.remediation.impl;

import com.ventura.multidatasource.core.remediation.Remediation;
import com.ventura.multidatasource.core.remediation.RemediationRepository;
import com.ventura.multidatasource.core.remediation.RemediationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RemediationServiceImpl implements RemediationService {

    private RemediationRepository repository;

    public RemediationServiceImpl(RemediationRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Void> createRemediation(Remediation remediation) {
        repository.save(Remediation.builder()
                .anomaly(remediation.getAnomaly())
                .build());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
