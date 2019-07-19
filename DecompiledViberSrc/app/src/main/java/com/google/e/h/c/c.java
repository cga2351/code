package com.google.e.h.c;

import com.google.e.h.a.h;
import com.google.e.h.a.j;
import com.google.e.h.a.j.b;
import com.google.e.r;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class c
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };

  static int a(int paramInt)
  {
    if (paramInt < a.length)
      return a[paramInt];
    return -1;
  }

  private static int a(com.google.e.c.a parama, com.google.e.h.a.f paramf, j paramj, b paramb)
    throws r
  {
    int i = 2147483647;
    int j = -1;
    int k = 0;
    int m;
    if (k < 8)
    {
      e.a(parama, paramf, paramj, k, paramb);
      m = a(paramb);
      if (m >= i)
        break label56;
      j = k;
    }
    while (true)
    {
      k++;
      i = m;
      break;
      return j;
      label56: m = i;
    }
  }

  private static int a(b paramb)
  {
    return d.a(paramb) + d.b(paramb) + d.c(paramb) + d.d(paramb);
  }

  static com.google.e.c.a a(com.google.e.c.a parama, int paramInt1, int paramInt2, int paramInt3)
    throws r
  {
    if (parama.b() != paramInt2)
      throw new r("Number of bits and data bytes does not match");
    ArrayList localArrayList = new ArrayList(paramInt3);
    int i = 0;
    int j = 0;
    int k = 0;
    int i5;
    for (int m = 0; i < paramInt3; m = i5)
    {
      int[] arrayOfInt1 = new int[1];
      int[] arrayOfInt2 = new int[1];
      a(paramInt1, paramInt2, paramInt3, i, arrayOfInt1, arrayOfInt2);
      int i2 = arrayOfInt1[0];
      byte[] arrayOfByte3 = new byte[i2];
      parama.a(m * 8, arrayOfByte3, 0, i2);
      byte[] arrayOfByte4 = a(arrayOfByte3, arrayOfInt2[0]);
      localArrayList.add(new a(arrayOfByte3, arrayOfByte4));
      int i3 = Math.max(k, i2);
      int i4 = Math.max(j, arrayOfByte4.length);
      i5 = m + arrayOfInt1[0];
      i++;
      j = i4;
      k = i3;
    }
    if (paramInt2 != m)
      throw new r("Data bytes does not match offset");
    com.google.e.c.a locala = new com.google.e.c.a();
    for (int n = 0; n < k; n++)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        byte[] arrayOfByte2 = ((a)localIterator2.next()).a();
        if (n < arrayOfByte2.length)
          locala.b(arrayOfByte2[n], 8);
      }
    }
    for (int i1 = 0; i1 < j; i1++)
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        byte[] arrayOfByte1 = ((a)localIterator1.next()).b();
        if (i1 < arrayOfByte1.length)
          locala.b(arrayOfByte1[i1], 8);
      }
    }
    if (paramInt1 != locala.b())
      throw new r("Interleaving error: " + paramInt1 + " and " + locala.b() + " differ.");
    return locala;
  }

  private static h a(String paramString1, String paramString2)
  {
    int i = 0;
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1))
        return h.g;
      return h.e;
    }
    int j = 0;
    int k = 0;
    if (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57))
        k = 1;
      while (true)
      {
        i++;
        break;
        if (a(m) == -1)
          break label83;
        j = 1;
      }
      label83: return h.e;
    }
    if (j != 0)
      return h.c;
    if (k != 0)
      return h.b;
    return h.e;
  }

  private static j a(int paramInt, com.google.e.h.a.f paramf)
    throws r
  {
    for (int i = 1; i <= 40; i++)
    {
      j localj = j.b(i);
      if (localj.c() - localj.a(paramf).c() >= (paramInt + 7) / 8)
        return localj;
    }
    throw new r("Data too big");
  }

  public static f a(String paramString, com.google.e.h.a.f paramf, Map<com.google.e.f, ?> paramMap)
    throws r
  {
    String str;
    h localh;
    com.google.e.c.a locala2;
    j localj2;
    com.google.e.c.a locala3;
    if (paramMap == null)
    {
      str = null;
      if (str == null)
        str = "ISO-8859-1";
      localh = a(paramString, str);
      com.google.e.c.a locala1 = new com.google.e.c.a();
      if ((localh == h.e) && (!"ISO-8859-1".equals(str)))
      {
        com.google.e.c.d locald = com.google.e.c.d.a(str);
        if (locald != null)
          a(locald, locala1);
      }
      a(localh, locala1);
      locala2 = new com.google.e.c.a();
      a(paramString, localh, locala2, str);
      j localj1 = a(locala1.a() + localh.a(j.b(1)) + locala2.a(), paramf);
      localj2 = a(locala1.a() + localh.a(localj1) + locala2.a(), paramf);
      locala3 = new com.google.e.c.a();
      locala3.a(locala1);
      if (localh != h.e)
        break label343;
    }
    label343: for (int i = locala2.b(); ; i = paramString.length())
    {
      a(i, localj2, localh, locala3);
      locala3.a(locala2);
      j.b localb = localj2.a(paramf);
      int j = localj2.c() - localb.c();
      a(j, locala3);
      com.google.e.c.a locala4 = a(locala3, localj2.c(), j, localb.b());
      f localf = new f();
      localf.a(paramf);
      localf.a(localh);
      localf.a(localj2);
      int k = localj2.d();
      b localb1 = new b(k, k);
      int m = a(locala4, paramf, localj2, localb1);
      localf.a(m);
      e.a(locala4, paramf, localj2, m, localb1);
      localf.a(localb1);
      return localf;
      str = (String)paramMap.get(com.google.e.f.b);
      break;
    }
  }

  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    throws r
  {
    if (paramInt4 >= paramInt3)
      throw new r("Block ID too large");
    int i = paramInt1 % paramInt3;
    int j = paramInt3 - i;
    int k = paramInt1 / paramInt3;
    int m = k + 1;
    int n = paramInt2 / paramInt3;
    int i1 = n + 1;
    int i2 = k - n;
    int i3 = m - i1;
    if (i2 != i3)
      throw new r("EC bytes mismatch");
    if (paramInt3 != j + i)
      throw new r("RS blocks mismatch");
    if (paramInt1 != j * (n + i2) + i * (i1 + i3))
      throw new r("Total bytes mismatch");
    if (paramInt4 < j)
    {
      paramArrayOfInt1[0] = n;
      paramArrayOfInt2[0] = i2;
      return;
    }
    paramArrayOfInt1[0] = i1;
    paramArrayOfInt2[0] = i3;
  }

  static void a(int paramInt, com.google.e.c.a parama)
    throws r
  {
    int i = paramInt * 8;
    if (parama.a() > i)
      throw new r("data bits cannot fit in the QR Code" + parama.a() + " > " + i);
    for (int j = 0; (j < 4) && (parama.a() < i); j++)
      parama.a(false);
    int k = 0x7 & parama.a();
    if (k > 0)
      while (k < 8)
      {
        parama.a(false);
        k++;
      }
    int m = paramInt - parama.b();
    int n = 0;
    if (n < m)
    {
      if ((n & 0x1) == 0);
      for (int i1 = 236; ; i1 = 17)
      {
        parama.b(i1, 8);
        n++;
        break;
      }
    }
    if (parama.a() != i)
      throw new r("Bits size does not equal capacity");
  }

  static void a(int paramInt, j paramj, h paramh, com.google.e.c.a parama)
    throws r
  {
    int i = paramh.a(paramj);
    if (paramInt >= 1 << i)
      throw new r(paramInt + " is bigger than " + (-1 + (1 << i)));
    parama.b(paramInt, i);
  }

  private static void a(com.google.e.c.d paramd, com.google.e.c.a parama)
  {
    parama.b(h.f.a(), 4);
    parama.b(paramd.a(), 8);
  }

  static void a(h paramh, com.google.e.c.a parama)
  {
    parama.b(paramh.a(), 4);
  }

  static void a(CharSequence paramCharSequence, com.google.e.c.a parama)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = '￐' + paramCharSequence.charAt(j);
      if (j + 2 < i)
      {
        int m = '￐' + paramCharSequence.charAt(j + 1);
        parama.b('￐' + paramCharSequence.charAt(j + 2) + (k * 100 + m * 10), 10);
        j += 3;
      }
      else if (j + 1 < i)
      {
        parama.b('￐' + paramCharSequence.charAt(j + 1) + k * 10, 7);
        j += 2;
      }
      else
      {
        parama.b(k, 4);
        j++;
      }
    }
  }

  static void a(String paramString, com.google.e.c.a parama)
    throws r
  {
    while (true)
    {
      int j;
      int m;
      int n;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
        int i = arrayOfByte.length;
        j = 0;
        if (j >= i)
          break label155;
        int k = 0xFF & arrayOfByte[j];
        m = 0xFF & arrayOfByte[(j + 1)] | k << 8;
        if ((m >= 33088) && (m <= 40956))
        {
          n = m - 33088;
          if (n != -1)
            break label127;
          throw new r("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new r(localUnsupportedEncodingException);
      }
      if ((m >= 57408) && (m <= 60351))
      {
        n = m - 49472;
        continue;
        label127: parama.b(192 * (n >> 8) + (n & 0xFF), 13);
        j += 2;
      }
      else
      {
        label155: n = -1;
      }
    }
  }

  static void a(String paramString1, com.google.e.c.a parama, String paramString2)
    throws r
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes(paramString2);
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
        parama.b(arrayOfByte[j], 8);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new r(localUnsupportedEncodingException);
    }
  }

  static void a(String paramString1, h paramh, com.google.e.c.a parama, String paramString2)
    throws r
  {
    switch (1.a[paramh.ordinal()])
    {
    default:
      throw new r("Invalid mode: " + paramh);
    case 1:
      a(paramString1, parama);
      return;
    case 2:
      b(paramString1, parama);
      return;
    case 3:
      a(paramString1, parama, paramString2);
      return;
    case 4:
    }
    a(paramString1, parama);
  }

  private static boolean a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
      int i = arrayOfByte.length;
      if (i % 2 != 0)
        return false;
      for (int j = 0; ; j += 2)
      {
        if (j >= i)
          break label75;
        int k = 0xFF & arrayOfByte[j];
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235)))
          break;
      }
      label75: return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return false;
  }

  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j + paramInt];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    new com.google.e.c.b.d(com.google.e.c.b.a.e).a(arrayOfInt, paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)arrayOfInt[(j + i)]);
      i++;
    }
    return arrayOfByte;
  }

  static void b(CharSequence paramCharSequence, com.google.e.c.a parama)
    throws r
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = a(paramCharSequence.charAt(j));
      if (k == -1)
        throw new r();
      if (j + 1 < i)
      {
        int m = a(paramCharSequence.charAt(j + 1));
        if (m == -1)
          throw new r();
        parama.b(m + k * 45, 11);
        j += 2;
      }
      else
      {
        parama.b(k, 6);
        j++;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.c.c
 * JD-Core Version:    0.6.2
 */