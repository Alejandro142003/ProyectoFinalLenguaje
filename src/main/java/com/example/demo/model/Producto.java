package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data//lombok
@Entity//Es una entidad
@Table(name="productos")//Como quiereas que se llame la tabla

public class Producto implements Serializable{
    @Id//Establece que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Hace que se genere de manera automática
    public int id;

    @Column(name = "nombre", nullable=false)
    public String nombre;

    @Column(name = "precio", nullable=false)
    public double precio;

}