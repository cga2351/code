package com.viber.voip.banner.datatype;

import com.viber.voip.util.e.j;

public class ImageBannerItem extends BannerItem
{
  public static final int[] MARGINS_WHEN_4_ITEMS = { 5, 10 };
  Size size = Size.SMALL;
  String url;

  protected int[] getDefaultMargins()
  {
    return new int[] { 18, 14 };
  }

  public Size getSize()
  {
    return this.size;
  }

  public BannerItem.Type getType()
  {
    return BannerItem.Type.IMAGE;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setSize(Size paramSize)
  {
    this.size = paramSize;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = getType();
    arrayOfObject[1] = getSize();
    arrayOfObject[2] = getUrl();
    return String.format("[%s, size = %s, url = %s]", arrayOfObject);
  }

  public static enum Size
  {
    float heightSizeInDp;
    int maxHeightInPx;
    int maxWidthInPx;
    private String sizeName;
    float widthSizeInDp;

    static
    {
      MEDIUM = new Size("MEDIUM", 1, "medium", 40.0F, 40.0F);
      LARGE = new Size("LARGE", 2, "large", 75.0F, 75.0F);
      ADS_AFTER_CALL_INTERNAL = new Size("ADS_AFTER_CALL_INTERNAL", 3, "ads after call internal", -1.0F, -2.0F, -1, -2);
      Size[] arrayOfSize = new Size[4];
      arrayOfSize[0] = SMALL;
      arrayOfSize[1] = MEDIUM;
      arrayOfSize[2] = LARGE;
      arrayOfSize[3] = ADS_AFTER_CALL_INTERNAL;
    }

    private Size(String paramString, float paramFloat1, float paramFloat2)
    {
      this(paramString, paramFloat1, paramFloat2, -1, -1);
    }

    private Size(String paramString, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.sizeName = paramString;
      this.maxWidthInPx = paramInt1;
      this.maxHeightInPx = paramInt2;
      if (paramInt1 >= 0);
      for (this.widthSizeInDp = -2.0F; paramInt2 >= 0; this.widthSizeInDp = paramFloat1)
      {
        this.heightSizeInDp = -2.0F;
        return;
      }
      this.heightSizeInDp = paramFloat2;
    }

    public static Size fromName(String paramString)
    {
      for (Size localSize : values())
        if (localSize.sizeName.equalsIgnoreCase(paramString))
          return localSize;
      return SMALL;
    }

    public int getHeightSizeInPx()
    {
      if (-1.0F == this.heightSizeInDp)
        return -1;
      return j.a(this.heightSizeInDp);
    }

    public int getMaxHeightInPx()
    {
      return this.maxHeightInPx;
    }

    public int getMaxWidthInPx()
    {
      return this.maxWidthInPx;
    }

    public int getWidthSizeInPx()
    {
      if (-1.0F == this.widthSizeInDp)
        return -1;
      return j.a(this.widthSizeInDp);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.ImageBannerItem
 * JD-Core Version:    0.6.2
 */