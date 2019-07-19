package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.widget.ImageView.ScaleType;

final class lx extends pc
{
  private final lw a;
  private final ly b;

  @TargetApi(13)
  lx(oj paramoj, pc.b paramb, lw paramlw, ly paramly)
  {
    super(paramoj, paramb);
    this.a = paramlw;
    this.b = paramly;
  }

  public final pc.c a(String paramString, pc.d paramd, int paramInt1, int paramInt2)
  {
    return super.a(paramString, paramd, this.b.a(paramInt1), paramInt2);
  }

  public final String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    return lw.a(paramString, paramScaleType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lx
 * JD-Core Version:    0.6.2
 */