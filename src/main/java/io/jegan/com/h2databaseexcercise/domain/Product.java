package io.jegan.com.h2databaseexcercise.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
private int id;
private String name;
private String description;
}
