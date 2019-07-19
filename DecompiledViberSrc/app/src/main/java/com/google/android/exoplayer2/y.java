package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.a;

public final class y
{
  public static final y a = new y(1.0F);
  public final float b;
  public final float c;
  public final boolean d;
  private final int e;

  public y(float paramFloat)
  {
    this(paramFloat, 1.0F, false);
  }

  public y(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2;
    if (paramFloat1 > 0.0F)
    {
      bool2 = bool1;
      a.a(bool2);
      if (paramFloat2 <= 0.0F)
        break label66;
    }
    while (true)
    {
      a.a(bool1);
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramBoolean;
      this.e = Math.round(1000.0F * paramFloat1);
      return;
      bool2 = false;
      break;
      label66: bool1 = false;
    }
  }

  public long a(long paramLong)
  {
    return paramLong * this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    y localy;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localy = (y)paramObject;
    }
    while ((this.b == localy.b) && (this.c == localy.c) && (this.d == localy.d));
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (527 + Float.floatToRawIntBits(this.b)) + Float.floatToRawIntBits(this.c));
    if (this.d);
    for (int j = 1; ; j = 0)
      return j + i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.y
 * JD-Core Version:    0.6.2
 */