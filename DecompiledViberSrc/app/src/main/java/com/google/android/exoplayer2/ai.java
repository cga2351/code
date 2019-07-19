package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.a;

public final class ai
{
  public static final ai a = new ai(0L, 0L);
  public static final ai b = new ai(9223372036854775807L, 9223372036854775807L);
  public static final ai c = new ai(9223372036854775807L, 0L);
  public static final ai d = new ai(0L, 9223372036854775807L);
  public static final ai e = a;
  public final long f;
  public final long g;

  public ai(long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool2 = bool1;
      a.a(bool2);
      if (paramLong2 < 0L)
        break label50;
    }
    while (true)
    {
      a.a(bool1);
      this.f = paramLong1;
      this.g = paramLong2;
      return;
      bool2 = false;
      break;
      label50: bool1 = false;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ai localai;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localai = (ai)paramObject;
    }
    while ((this.f == localai.f) && (this.g == localai.g));
    return false;
  }

  public int hashCode()
  {
    return 31 * (int)this.f + (int)this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ai
 * JD-Core Version:    0.6.2
 */