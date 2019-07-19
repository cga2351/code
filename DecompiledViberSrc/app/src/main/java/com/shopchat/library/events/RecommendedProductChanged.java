package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;

public class RecommendedProductChanged
{
  public final int position;
  public final ProductModel product;
  public final SwipeDirection swipeDirection;

  public RecommendedProductChanged(ProductModel paramProductModel, int paramInt, SwipeDirection paramSwipeDirection)
  {
    this.product = paramProductModel;
    this.position = paramInt;
    this.swipeDirection = paramSwipeDirection;
  }

  public int getPosition()
  {
    return this.position;
  }

  public ProductModel getProduct()
  {
    return this.product;
  }

  public SwipeDirection getSwipeDirection()
  {
    return this.swipeDirection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.RecommendedProductChanged
 * JD-Core Version:    0.6.2
 */