package com.viber.voip.banner.datatype;

import android.view.View;
import com.viber.voip.banner.view.b.f;

public abstract class BannerItem
{
  private int mViewId;
  private f<? extends View> mWidgetTuner;
  private int[] margins = { 0, 0 };

  public BannerItem()
  {
    setMargins(getDefaultMargins());
  }

  protected int[] getDefaultMargins()
  {
    return new int[] { 0, 0 };
  }

  public int[] getMargins()
  {
    return this.margins;
  }

  public abstract Type getType();

  public int getViewId()
  {
    return this.mViewId;
  }

  public f<? extends View> getWidgetTuner()
  {
    return this.mWidgetTuner;
  }

  public void setMargins(int[] paramArrayOfInt)
  {
    this.margins = paramArrayOfInt;
  }

  public void setViewId(int paramInt)
  {
    this.mViewId = paramInt;
  }

  public void setWidgetTuner(f<? extends View> paramf)
  {
    this.mWidgetTuner = paramf;
  }

  public static enum Type
  {
    Class cls;
    String typeName;

    static
    {
      BUTTON = new Type("BUTTON", 2, "button", ButtonBannerItem.class);
      DISMISS_BUTTON = new Type("DISMISS_BUTTON", 3, "dismiss_button", DismissBannerItem.class);
      INVALID = new Type("INVALID", 4, "invalid", ImageBannerItem.class);
      BLANK = new Type("BLANK", 5, "blank", ImageBannerItem.class);
      MEDIA = new Type("MEDIA", 6, "media", MediaBannerItem.class);
      Type[] arrayOfType = new Type[7];
      arrayOfType[0] = IMAGE;
      arrayOfType[1] = TEXT;
      arrayOfType[2] = BUTTON;
      arrayOfType[3] = DISMISS_BUTTON;
      arrayOfType[4] = INVALID;
      arrayOfType[5] = BLANK;
      arrayOfType[6] = MEDIA;
    }

    private Type(String paramString, Class paramClass)
    {
      this.typeName = paramString;
      this.cls = paramClass;
    }

    public static Type fromName(String paramString)
    {
      for (Type localType : values())
        if (localType.typeName.equalsIgnoreCase(paramString))
          return localType;
      return INVALID;
    }

    public Class getCls()
    {
      return this.cls;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.BannerItem
 * JD-Core Version:    0.6.2
 */