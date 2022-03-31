package io.jegan.com.h2databaseexcercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private int priceId;
    private int productId;
    private double price;
    private double discount;
}
