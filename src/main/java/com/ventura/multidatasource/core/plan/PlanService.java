package com.ventura.multidatasource.core.plan;

import com.ventura.multidatasource.web.plan.PlanDto;
import org.springframework.http.ResponseEntity;

public interface PlanService {
    ResponseEntity<Void> save(PlanDto dto);
}
