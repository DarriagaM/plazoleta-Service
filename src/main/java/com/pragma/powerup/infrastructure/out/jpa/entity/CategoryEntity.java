package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria")
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;


}
