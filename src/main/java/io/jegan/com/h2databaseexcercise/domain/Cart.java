package io.jegan.com.h2databaseexcercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private List<Product> items;
    private double cartTotal;
    private double cartDiscount;
    private double checkoutPrices;


}
