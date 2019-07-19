package com.google.e.h.a;

import com.google.e.c.c;
import com.google.e.c.l;
import com.google.e.g;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };

  private static char a(int paramInt)
    throws g
  {
    if (paramInt >= a.length)
      throw g.a();
    return a[paramInt];
  }

  private static int a(c paramc)
    throws g
  {
    int i = paramc.a(8);
    if ((i & 0x80) == 0)
      return i & 0x7F;
    if ((i & 0xC0) == 128)
      return paramc.a(8) | (i & 0x3F) << 8;
    if ((i & 0xE0) == 192)
      return paramc.a(16) | (i & 0x1F) << 16;
    throw g.a();
  }

  static com.google.e.c.e a(byte[] paramArrayOfByte, j paramj, f paramf, Map<com.google.e.e, ?> paramMap)
    throws g
  {
    c localc = new c(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    ArrayList localArrayList = new ArrayList(1);
    com.google.e.c.d locald = null;
    int i = -1;
    int j = -1;
    boolean bool1 = false;
    while (true)
    {
      h localh1;
      Object localObject;
      String str2;
      try
      {
        if (localc.c() < 4)
        {
          localh1 = h.a;
          if (localh1 == h.a)
            break label459;
          if (localh1 == h.h)
            break label489;
          if (localh1 == h.i)
          {
            break label489;
            h localh2 = h.a;
            if (localh1 != localh2)
              break label474;
            String str1 = localStringBuilder.toString();
            if (!localArrayList.isEmpty())
              break label443;
            localObject = null;
            if (paramf != null)
              break label450;
            str2 = null;
            return new com.google.e.c.e(paramArrayOfByte, str1, (List)localObject, str2, k, m);
          }
        }
        else
        {
          localh1 = h.a(localc.a(4));
          continue;
        }
        if (localh1 != h.d)
          break label217;
        if (localc.c() < 16)
          throw g.a();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw g.a();
      }
      int i3 = localc.a(8);
      int i4 = localc.a(8);
      boolean bool2 = bool1;
      int k = i3;
      int m = i4;
      continue;
      label217: if (localh1 == h.f)
      {
        locald = com.google.e.c.d.a(a(localc));
        if (locald == null)
          throw g.a();
      }
      else
      {
        if (localh1 == h.j)
        {
          int i1 = localc.a(4);
          int i2 = localc.a(localh1.a(paramj));
          if (i1 != 1)
            break label518;
          a(localc, localStringBuilder, i2);
          break label518;
        }
        int n = localc.a(localh1.a(paramj));
        if (localh1 == h.b)
        {
          c(localc, localStringBuilder, n);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localh1 == h.c)
        {
          a(localc, localStringBuilder, n, bool1);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localh1 == h.e)
        {
          a(localc, localStringBuilder, n, locald, localArrayList, paramMap);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        if (localh1 == h.g)
        {
          b(localc, localStringBuilder, n);
          bool2 = bool1;
          k = j;
          m = i;
          continue;
        }
        throw g.a();
        localObject = localArrayList;
        continue;
        str2 = paramf.toString();
        continue;
        bool2 = bool1;
        k = j;
        m = i;
        continue;
        label474: i = m;
        j = k;
        bool1 = bool2;
        continue;
        label489: bool2 = true;
        k = j;
        m = i;
        continue;
      }
      label443: label450: label459: bool2 = bool1;
      k = j;
      m = i;
      continue;
      label518: bool2 = bool1;
      k = j;
      m = i;
    }
  }

  private static void a(c paramc, StringBuilder paramStringBuilder, int paramInt)
    throws g
  {
    if (paramInt * 13 > paramc.c())
      throw g.a();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramc.a(13);
      int k = j / 96 << 8 | j % 96;
      if (k < 959);
      for (int m = k + 41377; ; m = k + 42657)
      {
        arrayOfByte[i] = ((byte)(0xFF & m >> 8));
        arrayOfByte[(i + 1)] = ((byte)(m & 0xFF));
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw g.a();
  }

  private static void a(c paramc, StringBuilder paramStringBuilder, int paramInt, com.google.e.c.d paramd, Collection<byte[]> paramCollection, Map<com.google.e.e, ?> paramMap)
    throws g
  {
    if (paramInt * 8 > paramc.c())
      throw g.a();
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfByte[i] = ((byte)paramc.a(8));
    String str;
    if (paramd == null)
      str = l.a(arrayOfByte, paramMap);
    try
    {
      while (true)
      {
        paramStringBuilder.append(new String(arrayOfByte, str));
        paramCollection.add(arrayOfByte);
        return;
        str = paramd.name();
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw g.a();
  }

  private static void a(c paramc, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
    throws g
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      if (paramc.c() < 11)
        throw g.a();
      int j = paramc.a(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
    {
      if (paramc.c() < 6)
        throw g.a();
      paramStringBuilder.append(a(paramc.a(6)));
    }
    if (paramBoolean)
      if (i < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(i) == '%')
        {
          if ((i >= -1 + paramStringBuilder.length()) || (paramStringBuilder.charAt(i + 1) != '%'))
            break label159;
          paramStringBuilder.deleteCharAt(i + 1);
        }
        while (true)
        {
          i++;
          break;
          label159: paramStringBuilder.setCharAt(i, '\035');
        }
      }
  }

  private static void b(c paramc, StringBuilder paramStringBuilder, int paramInt)
    throws g
  {
    if (paramInt * 13 > paramc.c())
      throw g.a();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramc.a(13);
      int k = j / 192 << 8 | j % 192;
      if (k < 7936);
      for (int m = k + 33088; ; m = k + 49472)
      {
        arrayOfByte[i] = ((byte)(m >> 8));
        arrayOfByte[(i + 1)] = ((byte)m);
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw g.a();
  }

  private static void c(c paramc, StringBuilder paramStringBuilder, int paramInt)
    throws g
  {
    while (paramInt >= 3)
    {
      if (paramc.c() < 10)
        throw g.a();
      int k = paramc.a(10);
      if (k >= 1000)
        throw g.a();
      paramStringBuilder.append(a(k / 100));
      paramStringBuilder.append(a(k / 10 % 10));
      paramStringBuilder.append(a(k % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramc.c() < 7)
        throw g.a();
      j = paramc.a(7);
      if (j >= 100)
        throw g.a();
      paramStringBuilder.append(a(j / 10));
      paramStringBuilder.append(a(j % 10));
    }
    while (paramInt != 1)
    {
      int j;
      return;
    }
    if (paramc.c() < 4)
      throw g.a();
    int i = paramc.a(4);
    if (i >= 10)
      throw g.a();
    paramStringBuilder.append(a(i));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.d
 * JD-Core Version:    0.6.2
 */