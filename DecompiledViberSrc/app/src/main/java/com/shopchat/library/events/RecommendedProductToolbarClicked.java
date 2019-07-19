package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;

public class RecommendedProductToolbarClicked
{
  public final int position;
  public final ProductModel product;

  public RecommendedProductToolbarClicked(ProductModel paramProductModel, int paramInt)
  {
    this.product = paramProductModel;
    this.position = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.RecommendedProductToolbarClicked
 * JD-Core Version:    0.6.2
 */