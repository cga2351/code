package com.viber.voip.banner.datatype;

public class ButtonBannerItem extends BannerItem
{
  String action;
  String caption;

  public String getAction()
  {
    return this.action;
  }

  public String getCaption()
  {
    return this.caption;
  }

  protected int[] getDefaultMargins()
  {
    return new int[] { 14, 14 };
  }

  public BannerItem.Type getType()
  {
    return BannerItem.Type.BUTTON;
  }

  public void setCaption(String paramString)
  {
    this.caption = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = getType();
    arrayOfObject[1] = getCaption();
    arrayOfObject[2] = getAction();
    return String.format("[%s, caption = %s, action = %s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.ButtonBannerItem
 * JD-Core Version:    0.6.2
 */