package com.c.a.a.b;

import java.lang.ref.SoftReference;

public final class f
{
  protected static final ThreadLocal<SoftReference<f>> a = new ThreadLocal();
  private static final char[] d = b.g();
  private static final byte[] e = b.h();
  protected com.c.a.a.e.b b;
  protected final char[] c = new char[6];

  public f()
  {
    this.c[0] = '\\';
    this.c[2] = '0';
    this.c[3] = '0';
  }

  private int a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343))
      throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2) + "; illegal combination");
    return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
  }

  public static f a()
  {
    SoftReference localSoftReference = (SoftReference)a.get();
    if (localSoftReference == null);
    for (f localf = null; ; localf = (f)localSoftReference.get())
    {
      if (localf == null)
      {
        localf = new f();
        a.set(new SoftReference(localf));
      }
      return localf;
    }
  }

  private void a(int paramInt)
  {
    if (paramInt > 1114111)
      throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319)
        throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
      throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
    }
    throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
  }

  public byte[] a(String paramString)
  {
    com.c.a.a.e.b localb = this.b;
    if (localb == null)
    {
      localb = new com.c.a.a.e.b(null);
      this.b = localb;
    }
    int i = paramString.length();
    Object localObject1 = localb.c();
    int j = localObject1.length;
    int k = 0;
    int m = 0;
    int i1;
    int i2;
    Object localObject2;
    int i4;
    int i5;
    label81: int i18;
    if (m < i)
    {
      i1 = m + 1;
      i2 = paramString.charAt(m);
      int i3 = j;
      localObject2 = localObject1;
      i4 = k;
      i5 = i3;
      if (i2 <= 127)
      {
        if (i4 >= i5)
        {
          localObject2 = localb.d();
          i5 = localObject2.length;
          i4 = 0;
        }
        i18 = i4 + 1;
        localObject2[i4] = ((byte)i2);
        if (i1 < i);
      }
    }
    for (int n = i18; ; n = k)
    {
      return this.b.b(n);
      int i19 = i1 + 1;
      i2 = paramString.charAt(i1);
      i1 = i19;
      i4 = i18;
      break label81;
      if (i4 >= i5)
      {
        localObject2 = localb.d();
        i5 = localObject2.length;
      }
      for (int i6 = 0; ; i6 = i4)
      {
        int i9;
        int i10;
        if (i2 < 2048)
        {
          i9 = i6 + 1;
          localObject2[i6] = ((byte)(0xC0 | i2 >> 6));
          i10 = i2;
        }
        for (m = i1; ; m = i1)
        {
          if (i9 >= i5)
          {
            localObject2 = localb.d();
            i5 = localObject2.length;
            i9 = 0;
          }
          int i11 = i9 + 1;
          localObject2[i9] = ((byte)(0x80 | i10 & 0x3F));
          localObject1 = localObject2;
          j = i5;
          k = i11;
          break;
          if ((i2 >= 55296) && (i2 <= 57343))
            break label378;
          int i7 = i6 + 1;
          localObject2[i6] = ((byte)(0xE0 | i2 >> 12));
          if (i7 >= i5)
          {
            localObject2 = localb.d();
            i5 = localObject2.length;
            i7 = 0;
          }
          int i8 = i7 + 1;
          localObject2[i7] = ((byte)(0x80 | 0x3F & i2 >> 6));
          i9 = i8;
          i10 = i2;
        }
        label378: if (i2 > 56319)
          a(i2);
        if (i1 >= i)
          a(i2);
        int i12 = i1 + 1;
        int i13 = a(i2, paramString.charAt(i1));
        if (i13 > 1114111)
          a(i13);
        int i14 = i6 + 1;
        localObject2[i6] = ((byte)(0xF0 | i13 >> 18));
        if (i14 >= i5)
        {
          localObject2 = localb.d();
          i5 = localObject2.length;
          i14 = 0;
        }
        int i15 = i14 + 1;
        localObject2[i14] = ((byte)(0x80 | 0x3F & i13 >> 12));
        if (i15 >= i5)
        {
          localObject2 = localb.d();
          i5 = localObject2.length;
        }
        for (int i16 = 0; ; i16 = i15)
        {
          int i17 = i16 + 1;
          localObject2[i16] = ((byte)(0x80 | 0x3F & i13 >> 6));
          i9 = i17;
          i10 = i13;
          m = i12;
          break;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.b.f
 * JD-Core Version:    0.6.2
 */