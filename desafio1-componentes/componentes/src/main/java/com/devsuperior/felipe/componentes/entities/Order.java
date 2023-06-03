package com.devsuperior.felipe.componentes.entities;

public class Order {

    private Integer code;

    private Double basic;

    private Double discount;


    public Order() {
    }

    public Order(int code, double basic, double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    //cálculo do valor movido para cá, dessa forma evitando de ferir o DRY e mantendo a resposabilidade com a entidade
    public double getValueWDiscount() {
        return (this.getBasic() * (100.00 - this.getDiscount()) / 100);
    }
}
