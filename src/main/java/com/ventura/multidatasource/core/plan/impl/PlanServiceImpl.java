package com.ventura.multidatasource.core.plan.impl;

import com.ventura.multidatasource.core.plan.Plan;
import com.ventura.multidatasource.core.plan.PlanRepository;
import com.ventura.multidatasource.core.plan.PlanService;
import com.ventura.multidatasource.web.plan.PlanDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanRepository repository;

    public PlanServiceImpl(PlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Void> save(PlanDto dto) {
        repository.save(Plan.builder()
                .type(dto.getType())
                .build());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
