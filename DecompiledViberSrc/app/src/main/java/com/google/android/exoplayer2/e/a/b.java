package com.google.android.exoplayer2.e.a;

import android.text.Layout.Alignment;

final class b extends com.google.android.exoplayer2.e.b
  implements Comparable<b>
{
  public final int o;

  public b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramBoolean, paramInt4);
    this.o = paramInt5;
  }

  public int a(b paramb)
  {
    if (paramb.o < this.o)
      return -1;
    if (paramb.o > this.o)
      return 1;
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a.b
 * JD-Core Version:    0.6.2
 */