package com.viber.voip.banner.datatype;

public class DismissBannerItem extends BannerItem
{
  public static final int[] MARGINS_WHEN_4_ITEMS = { 18, 5 };
  public static final int[] MARGINS_WHEN_ON_LEFT = { 18, 14 };

  protected int[] getDefaultMargins()
  {
    return new int[] { 30, 18 };
  }

  public BannerItem.Type getType()
  {
    return BannerItem.Type.DISMISS_BUTTON;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getType();
    return String.format("[%s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.DismissBannerItem
 * JD-Core Version:    0.6.2
 */