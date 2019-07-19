package com.google.android.exoplayer2.b;

public final class q
{
  public final int a;
  public final float b;

  public q(int paramInt, float paramFloat)
  {
    this.a = paramInt;
    this.b = paramFloat;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    q localq;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localq = (q)paramObject;
    }
    while ((this.a == localq.a) && (Float.compare(localq.b, this.b) == 0));
    return false;
  }

  public int hashCode()
  {
    return 31 * (527 + this.a) + Float.floatToIntBits(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.q
 * JD-Core Version:    0.6.2
 */