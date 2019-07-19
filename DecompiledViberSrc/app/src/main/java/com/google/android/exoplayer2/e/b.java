package com.google.android.exoplayer2.e;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;

public class b
{
  public final CharSequence a;
  public final Layout.Alignment b;
  public final Bitmap c;
  public final float d;
  public final int e;
  public final int f;
  public final float g;
  public final int h;
  public final float i;
  public final float j;
  public final boolean k;
  public final int l;
  public final int m;
  public final float n;

  public b(Bitmap paramBitmap, float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    this(null, null, paramBitmap, paramFloat2, 0, paramInt2, paramFloat1, paramInt1, -2147483648, 1.4E-45F, paramFloat3, paramFloat4, false, -16777216);
  }

  public b(CharSequence paramCharSequence)
  {
    this(paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }

  public b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    this(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, false, -16777216);
  }

  public b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    this(paramCharSequence, paramAlignment, null, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramInt4, paramFloat4, paramFloat3, 1.4E-45F, false, -16777216);
  }

  public b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4)
  {
    this(paramCharSequence, paramAlignment, null, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, -2147483648, 1.4E-45F, paramFloat3, 1.4E-45F, paramBoolean, paramInt4);
  }

  private b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, Bitmap paramBitmap, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean, int paramInt5)
  {
    this.a = paramCharSequence;
    this.b = paramAlignment;
    this.c = paramBitmap;
    this.d = paramFloat1;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramFloat2;
    this.h = paramInt3;
    this.i = paramFloat4;
    this.j = paramFloat5;
    this.k = paramBoolean;
    this.l = paramInt5;
    this.m = paramInt4;
    this.n = paramFloat3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b
 * JD-Core Version:    0.6.2
 */