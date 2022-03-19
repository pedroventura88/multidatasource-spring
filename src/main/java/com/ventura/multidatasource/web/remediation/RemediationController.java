package com.ventura.multidatasource.web.remediation;

import com.ventura.multidatasource.core.remediation.Remediation;
import com.ventura.multidatasource.core.remediation.RemediationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remediation")
public class RemediationController {
    private RemediationService service;

    public RemediationController(RemediationService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveRemediation(@RequestBody Remediation remediation) {
        return service.createRemediation(remediation);
    }
}
