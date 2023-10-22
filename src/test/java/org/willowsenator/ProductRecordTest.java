package org.willowsenator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRecordTest {
    @Test
    void createProduct(){
        var product = new ProductRecord("MONITOR SPORTS ROGSTRIX 24''",
                new BigDecimal("1200.4"), "MONITOR");

        System.out.println(product);

        assertEquals("MONITOR SPORTS ROGSTRIX 24''", product.name());
        assertEquals(new BigDecimal("1200.4").compareTo(product.cost()), 0);
        assertEquals("MONITOR", product.type());
    }

    @Test
    void createProductNameNotValid(){
       var exception = assertThrows(IllegalArgumentException.class,
               ()-> new ProductRecord("",
                       new BigDecimal("1200.4"), "MONITOR"));

       assertEquals("name is not valid!!", exception.getMessage());
    }

    @Test
    void createProductCostNotValid(){
        var exception = assertThrows(IllegalArgumentException.class,
                ()-> new ProductRecord("MONITOR SPORTS ROGSTRIX 24''",
                        new BigDecimal("-1200.4"), "MONITOR"));

        assertEquals("cost is not valid!!", exception.getMessage());
    }

    @Test
    void createProductCustomConstructor(){
        var product = new ProductRecord("MONITOR SPORTS ROGSTRIX 24''",
                new BigDecimal("1200.4"));


        System.out.println(product);

        assertEquals("MONITOR SPORTS ROGSTRIX 24''", product.name());
        assertEquals(new BigDecimal("1200.4").compareTo(product.cost()), 0);
        assertEquals("GENERAL", product.type());
    }

    @Test
    void createProductComparison(){
        var product = new ProductRecord("MONITOR SPORTS ROGSTRIX 24''",
                new BigDecimal("1200.4"), "MONITOR");

        var product1 = new ProductRecord("MONITOR SPORTS ROGSTRIX 24''",
                new BigDecimal("1200.4"), "MONITOR1");

        assertEquals(product, product1);

    }
}