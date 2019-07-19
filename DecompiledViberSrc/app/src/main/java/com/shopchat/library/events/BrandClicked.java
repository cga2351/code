package com.shopchat.library.events;

import com.shopchat.library.mvp.models.BrandModel;

public class BrandClicked
{
  private BrandModel _brandModel;
  private int _position = -1;

  public BrandClicked(BrandModel paramBrandModel, int paramInt)
  {
    this._brandModel = paramBrandModel;
    this._position = paramInt;
  }

  public BrandModel getBrandsModel()
  {
    return this._brandModel;
  }

  public int getPosition()
  {
    return this._position;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.BrandClicked
 * JD-Core Version:    0.6.2
 */