package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;

public class ProductOpenNative
{
  private ProductModel mProductModel;

  public ProductOpenNative(ProductModel paramProductModel)
  {
    this.mProductModel = paramProductModel;
  }

  public ProductModel getProductModel()
  {
    return this.mProductModel;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.ProductOpenNative
 * JD-Core Version:    0.6.2
 */