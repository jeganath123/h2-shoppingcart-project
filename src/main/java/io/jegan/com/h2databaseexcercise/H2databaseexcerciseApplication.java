package io.jegan.com.h2databaseexcercise;

import io.jegan.com.h2databaseexcercise.dao.CartDAO;
import io.jegan.com.h2databaseexcercise.domain.Price;
import io.jegan.com.h2databaseexcercise.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class H2databaseexcerciseApplication {
    private JdbcTemplate jdbcTemplate;
    private CartDAO cartDAO;

    public H2databaseexcerciseApplication(JdbcTemplate jdbcTemplate, CartDAO cartDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.cartDAO = cartDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(H2databaseexcerciseApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            init();
            cartDAO.addPrice(new Price(11,1,50,10));
            cartDAO.addPrice(new Price(12,2,80,20));
            cartDAO.addPrice(new Price(13,3,150,40));
            cartDAO.addPrice(new Price(14,4,200,50));
            cartDAO.addProduct(new Product(1,"Candle","Gives light"));
            cartDAO.addProduct(new Product(2,"Cycle","Ride to anywhere"));
            cartDAO.addProduct(new Product(3,"Watch","Show Time"));
            cartDAO.listAllProduct().forEach(System.out::println);

            List<Price> prices = cartDAO.listAllPrice();
            prices.forEach(System.out::println);

            Iterator<Double> iterator = prices.stream().map(s -> s.getPrice()-s.getDiscount()).iterator();
            double sum=0;
            while (iterator.hasNext()) {
                Double next = iterator.next();

                sum = sum + next;
            }
            System.out.println("Final payable amount is : "+sum);


        };
    }
  public void init(){
      System.out.println("creating table");
        String sql="CREATE TABLE Product (id int PRIMARY KEY,name VARCHAR(50), description VARCHAR(50))";
        jdbcTemplate.execute(sql);
         sql="CREATE TABLE Price (priceId int PRIMARY KEY,productId int ,price int,discount int)";
        jdbcTemplate.execute(sql);
  }
}
