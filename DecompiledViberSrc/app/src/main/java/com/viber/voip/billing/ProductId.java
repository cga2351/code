package com.viber.voip.billing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductId
{
  private static Pattern sPattern;
  ProductCategory mCategory;
  int mPackageId;
  String mStringId;

  static
  {
    if (!ProductId.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      sPattern = Pattern.compile("^([a-zA-Z_]+)\\.([0-9]+)$");
      return;
    }
  }

  private ProductId(ProductCategory paramProductCategory, int paramInt, String paramString)
  {
    assert (paramProductCategory != null);
    this.mCategory = paramProductCategory;
    this.mPackageId = paramInt;
    this.mStringId = paramString;
  }

  public static ProductId fromCustomProductId(String paramString, ProductCategory paramProductCategory)
  {
    return new ProductId(paramProductCategory, 0, paramString);
  }

  public static ProductId fromStickerPackageId(int paramInt)
  {
    return new ProductId(ProductCategory.STICKER_PACKAGE, paramInt, "stickers." + paramInt);
  }

  public static ProductId fromString(String paramString)
  {
    Matcher localMatcher = sPattern.matcher(paramString);
    if ((localMatcher.matches()) && ("stickers".equals(localMatcher.group(1))))
    {
      int i = Integer.parseInt(localMatcher.group(2));
      return new ProductId(ProductCategory.STICKER_PACKAGE, i, paramString);
    }
    return fromViberOutProductId(paramString);
  }

  public static ProductId fromViberOutProductId(String paramString)
  {
    return new ProductId(ProductCategory.VIBER_OUT_CREDIT, 0, paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ProductId))
      return false;
    return this.mStringId.equals(paramObject.toString());
  }

  public ProductCategory getCategory()
  {
    return this.mCategory;
  }

  public int getPackageId()
  {
    return this.mPackageId;
  }

  public String getStringId()
  {
    return this.mStringId;
  }

  public int hashCode()
  {
    return this.mStringId.hashCode();
  }

  public String toString()
  {
    return this.mStringId;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.ProductId
 * JD-Core Version:    0.6.2
 */