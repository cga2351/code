package com.yandex.mobile.ads;

import android.content.Context;
import com.yandex.mobile.ads.impl.aj.a;

public final class AdSize extends c
{
  public static final AdSize BANNER_240x400 = new AdSize(240, 400);
  public static final AdSize BANNER_300x250 = new AdSize(300, 250);
  public static final AdSize BANNER_300x300 = new AdSize(300, 300);
  public static final AdSize BANNER_320x100 = new AdSize(320, 100);
  public static final AdSize BANNER_320x50 = new AdSize(320, 50);
  public static final AdSize BANNER_400x240 = new AdSize(400, 240);
  public static final AdSize BANNER_728x90 = new AdSize(728, 90);
  public static final int FULL_HEIGHT = -2;
  public static final AdSize FULL_SCREEN = new AdSize(-1, -2);
  public static final int FULL_WIDTH = -1;
  private static final long serialVersionUID = 2680092174282737642L;

  public AdSize(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, aj.a.a);
  }

  private AdSize(int paramInt1, int paramInt2, aj.a parama)
  {
    super(paramInt1, paramInt2, parama);
  }

  public static AdSize flexibleSize()
  {
    return new AdSize(-1, 0, aj.a.c);
  }

  public static AdSize flexibleSize(int paramInt)
  {
    return new AdSize(paramInt, 0, aj.a.b);
  }

  public static AdSize flexibleSize(int paramInt1, int paramInt2)
  {
    return new AdSize(paramInt1, paramInt2, aj.a.b);
  }

  public final int getHeight()
  {
    return super.getHeight();
  }

  public final int getHeight(Context paramContext)
  {
    return super.getHeight(paramContext);
  }

  public final int getHeightInPixels(Context paramContext)
  {
    return super.getHeightInPixels(paramContext);
  }

  public final int getWidth()
  {
    return super.getWidth();
  }

  public final int getWidth(Context paramContext)
  {
    return super.getWidth(paramContext);
  }

  public final int getWidthInPixels(Context paramContext)
  {
    return super.getWidthInPixels(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdSize
 * JD-Core Version:    0.6.2
 */