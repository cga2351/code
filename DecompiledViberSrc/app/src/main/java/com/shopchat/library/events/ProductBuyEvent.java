package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;

public class ProductBuyEvent
{
  public final boolean isRecommendedProduct;
  public final ProductModel product;

  public ProductBuyEvent(ProductModel paramProductModel, boolean paramBoolean)
  {
    this.product = paramProductModel;
    this.isRecommendedProduct = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.ProductBuyEvent
 * JD-Core Version:    0.6.2
 */