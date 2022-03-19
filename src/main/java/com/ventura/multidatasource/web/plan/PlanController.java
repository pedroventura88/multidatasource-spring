package com.ventura.multidatasource.web.plan;

import com.ventura.multidatasource.core.plan.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> savePlan(@RequestBody PlanDto dto) {
        return service.save(dto);
    }
}
