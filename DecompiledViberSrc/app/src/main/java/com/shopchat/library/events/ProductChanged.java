package com.shopchat.library.events;

import com.shopchat.library.mvp.models.ProductModel;

public class ProductChanged
{
  private ProductModel _model;
  private int _position;
  private SwipeDirection _swipeDirection;

  public ProductChanged(ProductModel paramProductModel, SwipeDirection paramSwipeDirection, int paramInt)
  {
    this._model = paramProductModel;
    this._swipeDirection = paramSwipeDirection;
    this._position = paramInt;
  }

  public int getPosition()
  {
    return this._position;
  }

  public ProductModel getProduct()
  {
    return this._model;
  }

  public SwipeDirection getSwipeDirection()
  {
    return this._swipeDirection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.ProductChanged
 * JD-Core Version:    0.6.2
 */