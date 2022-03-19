package com.ventura.multidatasource.core.remediation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemediationRepository extends JpaRepository<Remediation, String> {
}
