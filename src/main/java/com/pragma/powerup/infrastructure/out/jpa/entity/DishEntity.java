package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.pragma.powerup.domain.model.RestaurantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "platos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private String precio;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "url_imagen", nullable = false)
    private String urlImagen;
    @Column(name = "categoria", nullable = false)
    private String categoria;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_restaurante")
    private RestaurantEntity idRestaurantModel;
}
