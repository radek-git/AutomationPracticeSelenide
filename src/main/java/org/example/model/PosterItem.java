package org.example.model;

import lombok.Data;

import java.math.BigDecimal;

public class PosterItem extends Item {

    private String imgUrl;


    public PosterItem(String name, BigDecimal price, String imgUrl) {
        super(name, price);
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
