package com.ater.shoppingapp.product.domain;

public enum Currency {
    USD("Dolar", "$"),
    EUR("Euro", "€"),
    TL("Lira", "t");

    private String label;
    private String symbol;

    Currency(String label, String symbol) {
        this.label = label;
        this.symbol = symbol;
    }
}
