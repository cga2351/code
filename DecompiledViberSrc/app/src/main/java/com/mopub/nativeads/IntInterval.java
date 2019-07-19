package com.mopub.nativeads;

public class IntInterval
  implements Comparable<IntInterval>
{
  private int a;
  private int b;

  public IntInterval(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int compareTo(IntInterval paramIntInterval)
  {
    if (this.a == paramIntInterval.a)
      return this.b - paramIntInterval.b;
    return this.a - paramIntInterval.a;
  }

  public boolean equals(int paramInt1, int paramInt2)
  {
    return (this.a == paramInt1) && (this.b == paramInt2);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    IntInterval localIntInterval;
    do
    {
      return true;
      if (!(paramObject instanceof IntInterval))
        return false;
      localIntInterval = (IntInterval)paramObject;
    }
    while ((this.a == localIntInterval.a) && (this.b == localIntInterval.b));
    return false;
  }

  public int getLength()
  {
    return this.b;
  }

  public int getStart()
  {
    return this.a;
  }

  public int hashCode()
  {
    return 31 * (899 + this.a) + this.b;
  }

  public void setLength(int paramInt)
  {
    this.b = paramInt;
  }

  public void setStart(int paramInt)
  {
    this.a = paramInt;
  }

  public String toString()
  {
    return "{start : " + this.a + ", length : " + this.b + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.IntInterval
 * JD-Core Version:    0.6.2
 */