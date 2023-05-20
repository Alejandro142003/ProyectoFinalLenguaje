package com.example.demo.controllers;

import com.example.demo.model.Producto;
import com.example.demo.services.ServicesProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller //Todos estas clausulas que empizan con @ se llaman beam
public class ControllerProducto {

    @Autowired
    private final ServicesProducto productoServices;//Mirar registroAlumnos y student

    public ControllerProducto(ServicesProducto productoService){
        this.productoServices = productoService;
    }

   /* @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

    @GetMapping("/")
    public String inicio(){
        return "index";
    }

    @GetMapping("/greeting/{nombre}/{edad}")
    public String Greentings(Model model, @PathVariable(name = "nombre") String nombre,
                       @PathVariable(name = "edad") int edad) {
        model.addAttribute("name", nombre);
        model.addAttribute("edad", edad);
        model.addAttribute("hola", "hola soy Alejandro");
        return "greeting";
    }

    @GetMapping("/productos")
    public String AllProductos(Model model) {
        List<Producto> productos = productoServices.getAllProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    //Añadir un producto GetMapping
    @GetMapping("/productos/add")
    public String formProductos(Model model){
        Producto producto = new Producto();
        model.addAttribute("Producto", producto);
        return "registroProducto";
    }

    //Añadir un producto PostMapping
    @PostMapping("/productos/add")
    public Object saveStudent(@ModelAttribute("producto") Producto producto) {
        productoServices.save(producto);
        return new RedirectView("/");
    }
}