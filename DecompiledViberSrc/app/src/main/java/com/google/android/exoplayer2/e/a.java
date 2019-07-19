package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.g.ag;

public final class a
{
  public static final a a = new a(-1, -16777216, 0, 0, -1, null);
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final Typeface g;

  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Typeface paramTypeface)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramTypeface;
  }

  @TargetApi(19)
  public static a a(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    if (ag.a >= 21)
      return c(paramCaptionStyle);
    return b(paramCaptionStyle);
  }

  @TargetApi(19)
  private static a b(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    return new a(paramCaptionStyle.foregroundColor, paramCaptionStyle.backgroundColor, 0, paramCaptionStyle.edgeType, paramCaptionStyle.edgeColor, paramCaptionStyle.getTypeface());
  }

  @TargetApi(21)
  private static a c(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    int i;
    int j;
    label24: int k;
    label36: int m;
    if (paramCaptionStyle.hasForegroundColor())
    {
      i = paramCaptionStyle.foregroundColor;
      if (!paramCaptionStyle.hasBackgroundColor())
        break label91;
      j = paramCaptionStyle.backgroundColor;
      if (!paramCaptionStyle.hasWindowColor())
        break label101;
      k = paramCaptionStyle.windowColor;
      if (!paramCaptionStyle.hasEdgeType())
        break label111;
      m = paramCaptionStyle.edgeType;
      label49: if (!paramCaptionStyle.hasEdgeColor())
        break label122;
    }
    label91: label101: label111: label122: for (int n = paramCaptionStyle.edgeColor; ; n = a.f)
    {
      return new a(i, j, k, m, n, paramCaptionStyle.getTypeface());
      i = a.b;
      break;
      j = a.c;
      break label24;
      k = a.d;
      break label36;
      m = a.e;
      break label49;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a
 * JD-Core Version:    0.6.2
 */