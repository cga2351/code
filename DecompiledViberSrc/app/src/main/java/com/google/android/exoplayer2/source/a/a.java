package com.google.android.exoplayer2.source.a;

import android.net.Uri;
import java.util.Arrays;

public final class a
{
  public static final a a = new a(new long[0]);
  public final int b;
  public final long[] c;
  public final a[] d;
  public final long e;
  public final long f;

  public a(long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    this.b = i;
    this.c = Arrays.copyOf(paramArrayOfLong, i);
    this.d = new a[i];
    for (int j = 0; j < i; j++)
      this.d[j] = new a();
    this.e = 0L;
    this.f = -9223372036854775807L;
  }

  private boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = true;
    long l = this.c[paramInt];
    if (l == -9223372036854775808L)
    {
      boolean bool2;
      if (this.f != -9223372036854775807L)
      {
        boolean bool3 = paramLong < this.f;
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramLong < l);
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public int a(long paramLong)
  {
    for (int i = -1 + this.c.length; (i >= 0) && (a(paramLong, i)); i--);
    if ((i >= 0) && (this.d[i].b()))
      return i;
    return -1;
  }

  public int b(long paramLong)
  {
    for (int i = 0; (i < this.c.length) && (this.c[i] != -9223372036854775808L) && ((paramLong >= this.c[i]) || (!this.d[i].b())); i++);
    if (i < this.c.length)
      return i;
    return -1;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    a locala;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      locala = (a)paramObject;
    }
    while ((this.b == locala.b) && (this.e == locala.e) && (this.f == locala.f) && (Arrays.equals(this.c, locala.c)) && (Arrays.equals(this.d, locala.d)));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * this.b + (int)this.e) + (int)this.f) + Arrays.hashCode(this.c)) + Arrays.hashCode(this.d);
  }

  public static final class a
  {
    public final int a;
    public final Uri[] b;
    public final int[] c;
    public final long[] d;

    public a()
    {
      this(-1, new int[0], new Uri[0], new long[0]);
    }

    private a(int paramInt, int[] paramArrayOfInt, Uri[] paramArrayOfUri, long[] paramArrayOfLong)
    {
      if (paramArrayOfInt.length == paramArrayOfUri.length);
      for (boolean bool = true; ; bool = false)
      {
        com.google.android.exoplayer2.g.a.a(bool);
        this.a = paramInt;
        this.c = paramArrayOfInt;
        this.b = paramArrayOfUri;
        this.d = paramArrayOfLong;
        return;
      }
    }

    public int a()
    {
      return a(-1);
    }

    public int a(int paramInt)
    {
      for (int i = paramInt + 1; ; i++)
        if ((i >= this.c.length) || (this.c[i] == 0) || (this.c[i] == 1))
          return i;
    }

    public boolean b()
    {
      return (this.a == -1) || (a() < this.a);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.a == locala.a) && (Arrays.equals(this.b, locala.b)) && (Arrays.equals(this.c, locala.c)) && (Arrays.equals(this.d, locala.d)));
      return false;
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * this.a + Arrays.hashCode(this.b)) + Arrays.hashCode(this.c)) + Arrays.hashCode(this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.a
 * JD-Core Version:    0.6.2
 */