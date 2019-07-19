package com.amazon.device.iap.model;

public enum ProductType
{
  static
  {
    ProductType[] arrayOfProductType = new ProductType[3];
    arrayOfProductType[0] = CONSUMABLE;
    arrayOfProductType[1] = ENTITLED;
    arrayOfProductType[2] = SUBSCRIPTION;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.model.ProductType
 * JD-Core Version:    0.6.2
 */