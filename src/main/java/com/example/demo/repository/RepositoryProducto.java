package com.example.demo.repository;

import com.example.demo.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryProducto extends JpaRepository<Producto, Long> { //Loong es una reserva de memoria

    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    public List<Producto> findAll();

    @Query(value = "SELECT * FROM productos WHERE  ID = ?1", nativeQuery = true) //Extrae lo que hay en esa consulta, el native query lo que dice es que estamos escribiendo igual que en la consola
    public Optional<Producto> findById(int id);

    @Modifying//Para modificar ncesitas escribir esto y @Transactional justo debajo
    @Transactional
    @Query(
        value =
                "INSERT INTO productos (nombre, precio) values (:Nombre, :Precio)", //Se usa lo que he comentado dos líneas abajo
        nativeQuery = true)

    void addProducto(@Param("Nombre") String first_name, @Param("Precio") double precio ); //Aquí se le da los nombres a los parámetros para usarlos dos líneas arriba

    @Modifying //para modificar necesitas escribir esto y la de abajo
    @Transactional //esta tambien
    @Query(value = "DELETE FROM productos WHERE ID=:id", nativeQuery = true)
    void deleteProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:Nombre, precio=:Precio WHERE ID=:id", nativeQuery = true)
    void editProducto(@Param("id") int id, @Param("Nombre") String nombre, @Param("Precio") double precio);

}
