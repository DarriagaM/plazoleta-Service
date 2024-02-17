package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empleados_restaurante")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado", nullable = false)
    private Long id;
    @Column(name = "id_restaurante",nullable = false)
    private String idRestaurant;
    @Column(name = "id_user_empleado",nullable = false)
    private String idEmployee;
}
