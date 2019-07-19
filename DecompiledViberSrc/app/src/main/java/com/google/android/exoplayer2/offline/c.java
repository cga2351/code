package com.google.android.exoplayer2.offline;

public final class c
  implements Comparable<c>
{
  public final int a;
  public final int b;
  public final int c;

  public int a(c paramc)
  {
    int i = this.a - paramc.a;
    if (i == 0)
    {
      i = this.b - paramc.b;
      if (i == 0)
        i = this.c - paramc.c;
    }
    return i;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    c localc;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localc = (c)paramObject;
    }
    while ((this.a == localc.a) && (this.b == localc.b) && (this.c == localc.c));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * this.a + this.b) + this.c;
  }

  public String toString()
  {
    return this.a + "." + this.b + "." + this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.offline.c
 * JD-Core Version:    0.6.2
 */