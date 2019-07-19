package com.shopchat.library.events;

public class FirstCategory
{
  String brandName;
  String categoryLink;
  String id;
  String name;

  public FirstCategory(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.categoryLink = paramString1;
    this.name = paramString2;
    this.id = paramString3;
    this.brandName = paramString4;
  }

  public String getBrandName()
  {
    return this.brandName;
  }

  public String getCategoryLink()
  {
    return this.categoryLink;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.FirstCategory
 * JD-Core Version:    0.6.2
 */