package org.willowsenator;

import java.math.BigDecimal;
import java.util.Objects;

public record ProductRecord(String name, BigDecimal cost, String type) {
    public ProductRecord {
        if (name != null && name.isBlank()) {
            throw new IllegalArgumentException("name is not valid!!");
        }

        if (cost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("cost is not valid!!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof ProductRecord product)) return false;
        return Objects.equals(name, product.name)
                && Objects.equals(cost, product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, type);
    }

    public ProductRecord(String name, BigDecimal cost){
        this(name, cost, "GENERAL");
    }
}
