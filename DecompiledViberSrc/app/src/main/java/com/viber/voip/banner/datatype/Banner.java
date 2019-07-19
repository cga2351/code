package com.viber.voip.banner.datatype;

import com.viber.voip.util.e.j;
import java.util.List;

public class Banner
{
  public static final BannerItem BLANK_BANNER_ITEM = new BlankBannerItem();
  public static final BannerItem INVALID_BANNER_ITEM = new InvalidBannerItem();
  String action;
  Background background;
  private Integer gravity;
  List<BannerItem> items;
  boolean mShouldSetClickListeners = true;
  Size size = Size.SMALL;

  public String getAction()
  {
    return this.action;
  }

  public Background getBackground()
  {
    return this.background;
  }

  public Integer getGravity()
  {
    return this.gravity;
  }

  public List<BannerItem> getItems()
  {
    return this.items;
  }

  public Size getSize()
  {
    return this.size;
  }

  public boolean hasActionSupport()
  {
    return true;
  }

  public boolean isOrientedVertically()
  {
    return false;
  }

  public void setBackground(Background paramBackground)
  {
    this.background = paramBackground;
  }

  public void setGravity(Integer paramInteger)
  {
    this.gravity = paramInteger;
  }

  public void setItems(List<BannerItem> paramList)
  {
    this.items = paramList;
  }

  public void setShouldSetClickListeners(boolean paramBoolean)
  {
    this.mShouldSetClickListeners = paramBoolean;
  }

  public void setSize(Size paramSize)
  {
    this.size = paramSize;
  }

  public boolean shouldSetClickListeners()
  {
    return this.mShouldSetClickListeners;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = getAction();
    arrayOfObject[1] = getSize();
    arrayOfObject[2] = getBackground();
    arrayOfObject[3] = getItems();
    return String.format("[Banner: action = %s, size = %s, background = %s, items = %s]", arrayOfObject);
  }

  public static class Background
  {
    String color;
    Float opacity;
    String url;

    public static Background transparent()
    {
      Background localBackground = new Background();
      localBackground.setColor("#000000");
      localBackground.setOpacity(0.0F);
      return localBackground;
    }

    public String getColor()
    {
      return this.color;
    }

    public String getImage()
    {
      return this.url;
    }

    public Float getOpacity()
    {
      return this.opacity;
    }

    public void setColor(String paramString)
    {
      this.color = paramString;
    }

    public void setImage(String paramString)
    {
      this.url = paramString;
    }

    public void setOpacity(float paramFloat)
    {
      this.opacity = Float.valueOf(paramFloat);
    }

    public String toString()
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = getColor();
      arrayOfObject[1] = getImage();
      arrayOfObject[2] = getOpacity();
      return String.format("[color = %s, url = %s, opacity = %s]", arrayOfObject);
    }
  }

  public static enum Size
  {
    private int heightSizeInDp;
    private String sizeName;
    private int verticalHeightSizeInDp;
    private int verticalWidthSizeInDp;
    private int widthSizeInDp;

    static
    {
      MEDIUM = new Size("MEDIUM", 1, "medium", -1, 60);
      LARGE = new Size("LARGE", 2, "large", -1, 75);
      ADS_AFTER_CALL_INTERNAL = new Size("ADS_AFTER_CALL_INTERNAL", 3, "ads after call internal", -2147483648, -2147483648, -1, -2);
      Size[] arrayOfSize = new Size[4];
      arrayOfSize[0] = SMALL;
      arrayOfSize[1] = MEDIUM;
      arrayOfSize[2] = LARGE;
      arrayOfSize[3] = ADS_AFTER_CALL_INTERNAL;
    }

    private Size(String paramString, int paramInt1, int paramInt2)
    {
      this(paramString, paramInt1, paramInt2, -2147483648, -2147483648);
    }

    private Size(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.sizeName = paramString;
      this.widthSizeInDp = paramInt1;
      this.heightSizeInDp = paramInt2;
      this.verticalWidthSizeInDp = paramInt3;
      this.verticalHeightSizeInDp = paramInt4;
    }

    public static Size fromName(String paramString)
    {
      for (Size localSize : values())
        if (localSize.sizeName.equalsIgnoreCase(paramString))
          return localSize;
      return SMALL;
    }

    private int getSizeInPx(int paramInt)
    {
      if (-2147483648 == paramInt)
        return -2147483648;
      if (-1 == paramInt)
        return -1;
      if (-2 == paramInt)
        return -2;
      return j.a(paramInt);
    }

    public int getHeightSizeInPx()
    {
      return getSizeInPx(this.heightSizeInDp);
    }

    public int getVerticalHeightSizeInPx()
    {
      return getSizeInPx(this.verticalHeightSizeInDp);
    }

    public int getVerticalWidthSizeInPx()
    {
      return getSizeInPx(this.verticalWidthSizeInDp);
    }

    public int getWidthSizeInPx()
    {
      return getSizeInPx(this.widthSizeInDp);
    }

    public static abstract interface Dimensions
    {
      public static final int UNDEFINED = -2147483648;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.Banner
 * JD-Core Version:    0.6.2
 */