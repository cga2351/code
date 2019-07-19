package com.viber.voip.billing;

public enum ProductCategory
{
  public final int order;

  static
  {
    STICKER_PACKAGE = new ProductCategory("STICKER_PACKAGE", 1, 1);
    UNKNOWN = new ProductCategory("UNKNOWN", 2, 2);
    VLN = new ProductCategory("VLN", 3, 3);
    ProductCategory[] arrayOfProductCategory = new ProductCategory[4];
    arrayOfProductCategory[0] = VIBER_OUT_CREDIT;
    arrayOfProductCategory[1] = STICKER_PACKAGE;
    arrayOfProductCategory[2] = UNKNOWN;
    arrayOfProductCategory[3] = VLN;
  }

  private ProductCategory(int paramInt)
  {
    this.order = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ProductCategory
 * JD-Core Version:    0.6.2
 */