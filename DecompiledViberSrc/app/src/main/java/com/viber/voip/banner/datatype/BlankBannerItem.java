package com.viber.voip.banner.datatype;

public class BlankBannerItem extends BannerItem
{
  public BannerItem.Type getType()
  {
    return BannerItem.Type.BLANK;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getType();
    return String.format("[%s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.BlankBannerItem
 * JD-Core Version:    0.6.2
 */