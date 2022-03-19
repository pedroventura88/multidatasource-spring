package com.ventura.multidatasource.core.remediation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "remediation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Remediation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String problem;
    private String anomaly;
}
