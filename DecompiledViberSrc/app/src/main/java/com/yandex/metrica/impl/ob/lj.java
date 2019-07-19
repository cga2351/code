package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bw;

public final class lj
{
  public final String a;
  public final long b;
  public final long c;

  public lj(String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
  }

  private lj(byte[] paramArrayOfByte)
    throws d
  {
    km localkm = (km)e.a(new km(), paramArrayOfByte);
    this.a = localkm.b;
    this.b = localkm.d;
    this.c = localkm.c;
  }

  public static lj a(byte[] paramArrayOfByte)
    throws d
  {
    if (bw.a(paramArrayOfByte))
      return null;
    return new lj(paramArrayOfByte);
  }

  public byte[] a()
  {
    km localkm = new km();
    localkm.b = this.a;
    localkm.d = this.b;
    localkm.c = this.c;
    return e.a(localkm);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    lj locallj;
    boolean bool3;
    do
    {
      boolean bool2;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool1 = false;
        }
        while (localClass1 != localClass2);
        locallj = (lj)paramObject;
        bool2 = this.b < locallj.b;
        bool1 = false;
      }
      while (bool2);
      bool3 = this.c < locallj.c;
      bool1 = false;
    }
    while (bool3);
    return this.a.equals(locallj.a);
  }

  public int hashCode()
  {
    return 31 * (31 * this.a.hashCode() + (int)(this.b ^ this.b >>> 32)) + (int)(this.c ^ this.c >>> 32);
  }

  public String toString()
  {
    return "ReferrerInfo{installReferrer='" + this.a + '\'' + ", referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lj
 * JD-Core Version:    0.6.2
 */