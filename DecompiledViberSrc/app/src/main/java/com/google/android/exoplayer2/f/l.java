package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

public final class l
{
  public final Uri a;
  public final int b;
  public final byte[] c;

  @Deprecated
  public final byte[] d;
  public final long e;
  public final long f;
  public final long g;
  public final String h;
  public final int i;

  public l(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, paramInt);
  }

  public l(Uri paramUri, int paramInt1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2)
  {
    boolean bool1;
    boolean bool2;
    label29: boolean bool3;
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      a.a(bool1);
      if (paramLong2 < 0L)
        break label127;
      bool2 = true;
      a.a(bool2);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L))
        break label133;
      bool3 = true;
      label53: a.a(bool3);
      this.a = paramUri;
      this.b = paramInt1;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        break label139;
    }
    while (true)
    {
      this.c = paramArrayOfByte;
      this.d = this.c;
      this.e = paramLong1;
      this.f = paramLong2;
      this.g = paramLong3;
      this.h = paramString;
      this.i = paramInt2;
      return;
      bool1 = false;
      break;
      label127: bool2 = false;
      break label29;
      label133: bool3 = false;
      break label53;
      label139: paramArrayOfByte = null;
    }
  }

  public l(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }

  public l(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
  }

  public l(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, paramInt);
  }

  public l(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
  }

  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new AssertionError(paramInt);
    case 1:
      return "GET";
    case 2:
      return "POST";
    case 3:
    }
    return "HEAD";
  }

  public l a(long paramLong)
  {
    long l = -1L;
    if (this.g == l);
    while (true)
    {
      return a(paramLong, l);
      l = this.g - paramLong;
    }
  }

  public l a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.g == paramLong2))
      return this;
    return new l(this.a, this.b, this.c, paramLong1 + this.e, paramLong1 + this.f, paramLong2, this.h, this.i);
  }

  public final String a()
  {
    return b(this.b);
  }

  public boolean a(int paramInt)
  {
    return (paramInt & this.i) == paramInt;
  }

  public String toString()
  {
    return "DataSpec[" + a() + " " + this.a + ", " + Arrays.toString(this.c) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.i + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.l
 * JD-Core Version:    0.6.2
 */