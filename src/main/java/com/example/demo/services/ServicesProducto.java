package com.example.demo.services;

import com.example.demo.model.Producto;
import com.example.demo.repository.RepositoryProducto;
import jdk.jshell.spi.SPIResolutionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesProducto implements InterfacesProducto {
    private RepositoryProducto productoRepository;

    public ServicesProducto(RepositoryProducto productoRepository) { this.productoRepository = productoRepository; }

    @Override //Aquí parece que no está el fallo miro RepositoryProducto
    public List<Producto> getAllProductos() { return productoRepository.findAll(); }

    @Override
    public Optional<Producto> findById(int id) { return productoRepository.findById(id); }

    @Override
    public void addProducto(String nombre, double precio) { productoRepository.addProducto(nombre, precio); }

    @Override
    public void deleteProducto(int id) { productoRepository.deleteProducto(id); }

    @Override
    public void editProducto(int id, String nombre, double precio) { productoRepository.editProducto(id, nombre, precio); }

    public void save(Producto producto){ productoRepository.save(producto); }
}
