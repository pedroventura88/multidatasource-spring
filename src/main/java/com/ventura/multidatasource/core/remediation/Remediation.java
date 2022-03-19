package com.ventura.multidatasource.core.remediation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "remediation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Remediation {

    @Id
    private String id;
    private String problem;
    private String anomaly;
}
