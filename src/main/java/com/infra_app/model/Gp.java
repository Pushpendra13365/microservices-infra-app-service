package com.infra_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gp")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mandal_id", nullable = false)
    private Mandal mandal;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
}

