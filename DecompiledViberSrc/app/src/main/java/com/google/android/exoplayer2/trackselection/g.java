package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class g
{
  public final int a;
  private final e[] b;
  private int c;

  public g(e[] paramArrayOfe)
  {
    this.b = paramArrayOfe;
    this.a = paramArrayOfe.length;
  }

  public e a(int paramInt)
  {
    return this.b[paramInt];
  }

  public e[] a()
  {
    return (e[])this.b.clone();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    g localg = (g)paramObject;
    return Arrays.equals(this.b, localg.b);
  }

  public int hashCode()
  {
    if (this.c == 0)
      this.c = (527 + Arrays.hashCode(this.b));
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.g
 * JD-Core Version:    0.6.2
 */