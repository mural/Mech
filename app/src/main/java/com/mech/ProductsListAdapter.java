package com.mech;

import java.util.Collection;
import java.util.List;

/**
 * Created by Agustin on 15/7/2017.
 */

public class ProductsListAdapter extends CustomListAdapter<ProductsListAdapterItem, Product> {

    public ProductsListAdapter(Collection<Product> products) {
        super(products);
    }

    public ProductsListAdapter(List<Product> products) {
        super(products);
    }

    public ProductsListAdapterItem createAdapterItem(Product product) {
        return new ProductsListAdapterItem(product, this);
    }
}
