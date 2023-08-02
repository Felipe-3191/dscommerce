package com.devsuperior.felipe.dscommerce.dto;

import com.devsuperior.felipe.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @Size(min =3, max=80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Nome é um campo Requerido")
    private String name;

    @Size (min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Descrição não pode ser vazia")
    private String description;

    @Positive(message = "o preço deve ser positivo")
    private Double price;

    private String imgUrl;

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO (Product product) {
       this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
