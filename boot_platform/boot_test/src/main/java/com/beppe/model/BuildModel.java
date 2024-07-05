package com.beppe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildModel {

    @Builder.Default
    private ProductDomain productDomain = new ProductDomain();

    @Getter
    @Setter
    public static class ProductDomain {
        private int aa;
    }

    public ProductDomain getProductDomain() {
        return productDomain;
    }

    public void setProductDomain(ProductDomain productDomain) {
        this.productDomain = productDomain;
    }
}
