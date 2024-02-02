package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "restaurantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante",nullable = false)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "nit",unique = true,nullable = false)
    private String nit;
    @Column(name = "direccion",nullable = false)
    private String direccion;
    @Column(name = "telefono",nullable = false)
    private String telefono;
    @Column(name = "urlLogo",nullable = false)
    private String urlLogo;
    @Column(name = "id_propietario",nullable = false)
    private Long idPropietario;
}
