package com.mysite.rentbooks.models;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String card;
    private Integer totalBuyAmount;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Integer getTotalBuyAmount() {
        return totalBuyAmount;
    }

    public void setTotalBuyAmount(Integer totalBuyAmount) {
        this.totalBuyAmount = totalBuyAmount;
    }
}
