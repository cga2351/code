package com.shopchat.library.events;

public class ProductListScroll
{
  String brandName;
  String categoryName;

  public ProductListScroll(String paramString1, String paramString2)
  {
    this.brandName = paramString1;
    this.categoryName = paramString2;
  }

  public String getBrandName()
  {
    return this.brandName;
  }

  public String getCategoryName()
  {
    return this.categoryName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.ProductListScroll
 * JD-Core Version:    0.6.2
 */