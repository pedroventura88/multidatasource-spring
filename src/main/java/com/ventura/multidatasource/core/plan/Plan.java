package com.ventura.multidatasource.core.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "plan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String type;

}
