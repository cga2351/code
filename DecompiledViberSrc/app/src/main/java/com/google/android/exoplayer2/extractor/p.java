package com.google.android.exoplayer2.extractor;

public final class p
{
  public static final p a = new p(0L, 0L);
  public final long b;
  public final long c;

  public p(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    p localp;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localp = (p)paramObject;
    }
    while ((this.b == localp.b) && (this.c == localp.c));
    return false;
  }

  public int hashCode()
  {
    return 31 * (int)this.b + (int)this.c;
  }

  public String toString()
  {
    return "[timeUs=" + this.b + ", position=" + this.c + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.p
 * JD-Core Version:    0.6.2
 */