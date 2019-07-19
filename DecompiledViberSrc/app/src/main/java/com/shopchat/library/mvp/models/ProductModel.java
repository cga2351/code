package com.shopchat.library.mvp.models;

import com.google.d.a.c;

public class ProductModel
{
  BrandModel brand;
  String description;

  @c(a="image_url")
  String imageUrl;

  @c(a="image_url_original")
  String imageUrlOriginal;

  @c(a="image_url_short")
  String imageUrlShort;

  @c(a="is_sale")
  boolean isSale = false;
  Float price;

  @c(a="product_id")
  String productId;

  @c(a="redirect_url")
  String redirectUrl;

  @c(a="share_msg")
  String shareMsg;
  String title;
  String url;

  public BrandModel getBrand()
  {
    return this.brand;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getImageUrl()
  {
    return this.imageUrl;
  }

  public String getImageUrlOriginal()
  {
    return this.imageUrlOriginal;
  }

  public String getImageUrlShort()
  {
    return this.imageUrlShort;
  }

  public Float getPrice()
  {
    return this.price;
  }

  public String getProductId()
  {
    return this.productId;
  }

  public String getRedirectUrl()
  {
    return this.redirectUrl;
  }

  public String getShareMsg()
  {
    return this.shareMsg;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getUrl()
  {
    return this.url;
  }

  public boolean isSale()
  {
    return this.isSale;
  }

  public void setBrand(BrandModel paramBrandModel)
  {
    this.brand = paramBrandModel;
  }

  public void setImageUrlOriginal(String paramString)
  {
    this.imageUrlOriginal = paramString;
  }

  public void setRedirectUrl(String paramString)
  {
    this.redirectUrl = paramString;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("product id: [").append(this.productId).append("]\n");
    localStringBuffer.append("image url: [").append(this.imageUrl).append("]\n");
    localStringBuffer.append("image url short: [").append(this.imageUrlShort).append("]\n");
    localStringBuffer.append("url: [").append(this.url).append("]\n");
    localStringBuffer.append("title: [").append(this.title).append("]\n");
    localStringBuffer.append("price: [").append(this.price).append("]\n");
    localStringBuffer.append("desc: [").append(this.description).append("]\n");
    localStringBuffer.append("share msg: [").append(this.shareMsg).append("]\n");
    return localStringBuffer.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.models.ProductModel
 * JD-Core Version:    0.6.2
 */