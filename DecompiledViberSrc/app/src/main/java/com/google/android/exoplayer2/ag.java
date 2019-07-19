package com.google.android.exoplayer2;

public final class ag
{
  public static final ag a = new ag(0);
  public final int b;

  public ag(int paramInt)
  {
    this.b = paramInt;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ag localag;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localag = (ag)paramObject;
    }
    while (this.b == localag.b);
    return false;
  }

  public int hashCode()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ag
 * JD-Core Version:    0.6.2
 */