package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a
  implements com.google.android.exoplayer2.metadata.a
{
  public static final a a = b.a;
  public static final int b = ag.g("ID3");
  private final a c;

  public a()
  {
    this(null);
  }

  public a(a parama)
  {
    this.c = parama;
  }

  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = b(paramArrayOfByte, paramInt1);
    if ((paramInt2 == 0) || (paramInt2 == 3))
      return i;
    do
    {
      i = b(paramArrayOfByte, i + 1);
      if (i >= -1 + paramArrayOfByte.length)
        break;
    }
    while ((i % 2 != 0) || (paramArrayOfByte[(i + 1)] != 0));
    return i;
    return paramArrayOfByte.length;
  }

  private static ApicFrame a(r paramr, int paramInt1, int paramInt2)
    throws UnsupportedEncodingException
  {
    int i = 2;
    int j = paramr.h();
    String str1 = a(j);
    byte[] arrayOfByte = new byte[paramInt1 - 1];
    paramr.a(arrayOfByte, 0, paramInt1 - 1);
    String str2;
    if (paramInt2 == i)
    {
      str2 = "image/" + ag.d(new String(arrayOfByte, 0, 3, "ISO-8859-1"));
      if ("image/jpg".equals(str2))
        str2 = "image/jpeg";
    }
    while (true)
    {
      int k = 0xFF & arrayOfByte[(i + 1)];
      int m = i + 2;
      int n = a(arrayOfByte, m, j);
      return new ApicFrame(str2, new String(arrayOfByte, m, n - m, str1), k, b(arrayOfByte, n + b(j), arrayOfByte.length));
      i = b(arrayOfByte, 0);
      str2 = ag.d(new String(arrayOfByte, 0, i, "ISO-8859-1"));
      if (str2.indexOf('/') == -1)
        str2 = "image/" + str2;
    }
  }

  private static ChapterFrame a(r paramr, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a parama)
    throws UnsupportedEncodingException
  {
    int i = paramr.d();
    int j = b(paramr.a, i);
    String str = new String(paramr.a, i, j - i, "ISO-8859-1");
    paramr.c(j + 1);
    int k = paramr.p();
    int m = paramr.p();
    long l1 = paramr.n();
    if (l1 == 4294967295L)
      l1 = -1L;
    long l2 = paramr.n();
    if (l2 == 4294967295L)
      l2 = -1L;
    ArrayList localArrayList = new ArrayList();
    int n = i + paramInt1;
    while (paramr.d() < n)
    {
      Id3Frame localId3Frame = a(paramInt2, paramr, paramBoolean, paramInt3, parama);
      if (localId3Frame != null)
        localArrayList.add(localId3Frame);
    }
    Id3Frame[] arrayOfId3Frame = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(arrayOfId3Frame);
    return new ChapterFrame(str, k, m, l1, l2, arrayOfId3Frame);
  }

  private static Id3Frame a(int paramInt1, r paramr, boolean paramBoolean, int paramInt2, a parama)
  {
    int i = paramr.h();
    int j = paramr.h();
    int k = paramr.h();
    int m;
    int n;
    if (paramInt1 >= 3)
    {
      m = paramr.h();
      if (paramInt1 != 4)
        break label148;
      n = paramr.v();
      if (!paramBoolean)
        n = n & 0xFF | (0xFF & n >> 8) << 7 | (0xFF & n >> 16) << 14 | (0xFF & n >> 24) << 21;
      label91: if (paramInt1 < 3)
        break label171;
    }
    label148: label171: for (int i1 = paramr.i(); ; i1 = 0)
    {
      if ((i != 0) || (j != 0) || (k != 0) || (m != 0) || (n != 0) || (i1 != 0))
        break label177;
      paramr.c(paramr.c());
      return null;
      m = 0;
      break;
      if (paramInt1 == 3)
      {
        n = paramr.v();
        break label91;
      }
      n = paramr.l();
      break label91;
    }
    label177: int i2 = n + paramr.d();
    if (i2 > paramr.c())
    {
      l.c("Id3Decoder", "Frame size exceeds remaining tag data");
      paramr.c(paramr.c());
      return null;
    }
    if ((parama != null) && (!parama.a(paramInt1, i, j, k, m)))
    {
      paramr.c(i2);
      return null;
    }
    int i3 = 0;
    int i5;
    int i6;
    label275: int i4;
    label286: int i7;
    if (paramInt1 == 3)
      if ((i1 & 0x80) != 0)
      {
        i5 = 1;
        if ((i1 & 0x40) == 0)
          break label321;
        i6 = 1;
        if ((i1 & 0x20) == 0)
          break label327;
        i4 = 1;
        i7 = i5;
      }
    while (true)
      if ((i7 != 0) || (i6 != 0))
      {
        l.c("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
        paramr.c(i2);
        return null;
        i5 = 0;
        break;
        label321: i6 = 0;
        break label275;
        label327: i4 = 0;
        break label286;
        i4 = 0;
        i5 = 0;
        i3 = 0;
        i6 = 0;
        i7 = 0;
        if (paramInt1 == 4)
        {
          int i8;
          if ((i1 & 0x40) != 0)
          {
            i8 = 1;
            label364: if ((i1 & 0x8) == 0)
              break label426;
            i7 = 1;
            label375: if ((i1 & 0x4) == 0)
              break label432;
            i6 = 1;
            label385: if ((i1 & 0x2) == 0)
              break label438;
            i3 = 1;
            label395: if ((i1 & 0x1) == 0)
              break label444;
          }
          label426: label432: label438: label444: for (int i9 = 1; ; i9 = 0)
          {
            int i10 = i8;
            i5 = i9;
            i4 = i10;
            break;
            i8 = 0;
            break label364;
            i7 = 0;
            break label375;
            i6 = 0;
            break label385;
            i3 = 0;
            break label395;
          }
        }
      }
    if (i4 != 0)
    {
      n--;
      paramr.d(1);
    }
    if (i5 != 0)
    {
      n -= 4;
      paramr.d(4);
    }
    if (i3 != 0)
      n = g(paramr, n);
    if ((i == 84) && (j == 88) && (k == 88) && ((paramInt1 == 2) || (m == 88)));
    while (true)
    {
      try
      {
        Object localObject2 = a(paramr, n);
        if (localObject2 == null)
          l.c("Id3Decoder", "Failed to decode frame: id=" + b(paramInt1, i, j, k, m) + ", frameSize=" + n);
        return localObject2;
        if (i == 84)
        {
          localObject2 = a(paramr, n, b(paramInt1, i, j, k, m));
          continue;
          localObject2 = b(paramr, n);
          continue;
          if (i == 87)
          {
            localObject2 = b(paramr, n, b(paramInt1, i, j, k, m));
            continue;
          }
          if ((i != 80) || (j != 82) || (k != 73) || (m != 86))
            break label951;
          localObject2 = c(paramr, n);
          continue;
          localObject2 = d(paramr, n);
          continue;
          localObject2 = a(paramr, n, paramInt1);
          continue;
          localObject2 = e(paramr, n);
          continue;
          if ((i == 67) && (j == 72) && (k == 65) && (m == 80))
          {
            localObject2 = a(paramr, n, paramInt1, paramBoolean, paramInt2, parama);
            continue;
          }
          if ((i == 67) && (j == 84) && (k == 79) && (m == 67))
          {
            localObject2 = b(paramr, n, paramInt1, paramBoolean, paramInt2, parama);
            continue;
          }
          if ((i == 77) && (j == 76) && (k == 76) && (m == 84))
          {
            localObject2 = f(paramr, n);
            continue;
          }
          BinaryFrame localBinaryFrame = c(paramr, n, b(paramInt1, i, j, k, m));
          localObject2 = localBinaryFrame;
          continue;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        l.c("Id3Decoder", "Unsupported character encoding");
        return null;
      }
      finally
      {
        paramr.c(i2);
      }
      if ((i == 87) && (j == 88) && (k == 88))
        if (paramInt1 != 2)
          if (m == 88)
          {
            continue;
            label951: if ((i != 71) || (j != 69) || (k != 79) || ((m != 66) && (paramInt1 != 2)))
              if (paramInt1 == 2 ? (i != 80) && (j != 73) && (k != 67) : (i != 65) || (j != 80) || (k != 73) || (m != 67))
                if ((i == 67) && (j == 79) && (k == 77))
                  if (m != 77)
                    if (paramInt1 != 2);
          }
    }
  }

  private static TextInformationFrame a(r paramr, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1)
      return null;
    int i = paramr.h();
    String str1 = a(i);
    byte[] arrayOfByte = new byte[paramInt - 1];
    paramr.a(arrayOfByte, 0, paramInt - 1);
    int j = a(arrayOfByte, 0, i);
    String str2 = new String(arrayOfByte, 0, j, str1);
    int k = j + b(i);
    return new TextInformationFrame("TXXX", str2, a(arrayOfByte, k, a(arrayOfByte, k, i), str1));
  }

  private static TextInformationFrame a(r paramr, int paramInt, String paramString)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1)
      return null;
    int i = paramr.h();
    String str = a(i);
    byte[] arrayOfByte = new byte[paramInt - 1];
    paramr.a(arrayOfByte, 0, paramInt - 1);
    return new TextInformationFrame(paramString, null, new String(arrayOfByte, 0, a(arrayOfByte, 0, i), str));
  }

  private static b a(r paramr)
  {
    if (paramr.b() < 10)
    {
      l.c("Id3Decoder", "Data too short to be an ID3 tag");
      return null;
    }
    int i = paramr.l();
    if (i != b)
    {
      l.c("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + i);
      return null;
    }
    int j = paramr.h();
    paramr.d(1);
    int k = paramr.h();
    int m = paramr.u();
    int i2;
    if (j == 2)
    {
      if ((k & 0x40) != 0);
      for (int i6 = 1; i6 != 0; i6 = 0)
      {
        l.c("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
        return null;
      }
      i2 = m;
      if ((j >= 4) || ((k & 0x80) == 0))
        break label303;
    }
    label271: label303: for (boolean bool = true; ; bool = false)
    {
      return new b(j, bool, i2);
      if (j == 3)
      {
        if ((k & 0x40) != 0);
        for (int i4 = 1; ; i4 = 0)
        {
          if (i4 != 0)
          {
            int i5 = paramr.p();
            paramr.d(i5);
            m -= i5 + 4;
          }
          i2 = m;
          break;
        }
      }
      if (j == 4)
      {
        int n;
        if ((k & 0x40) != 0)
        {
          n = 1;
          label214: if (n != 0)
          {
            int i3 = paramr.u();
            paramr.d(i3 - 4);
            m -= i3;
          }
          if ((k & 0x10) == 0)
            break label271;
        }
        for (int i1 = 1; ; i1 = 0)
        {
          if (i1 != 0)
            m -= 10;
          i2 = m;
          break;
          n = 0;
          break label214;
        }
      }
      l.c("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + j);
      return null;
    }
  }

  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "ISO-8859-1";
    case 1:
      return "UTF-16";
    case 2:
      return "UTF-16BE";
    case 3:
    }
    return "UTF-8";
  }

  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
    throws UnsupportedEncodingException
  {
    if ((paramInt2 <= paramInt1) || (paramInt2 > paramArrayOfByte.length))
      return "";
    return new String(paramArrayOfByte, paramInt1, paramInt2 - paramInt1, paramString);
  }

  private static boolean a(r paramr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramr.d();
    while (true)
    {
      long l2;
      try
      {
        if (paramr.b() >= paramInt2)
        {
          int m;
          int n;
          if (paramInt1 >= 3)
          {
            int j = paramr.p();
            long l1 = paramr.n();
            int k = paramr.i();
            m = k;
            n = j;
            l2 = l1;
            if ((n == 0) && (l2 == 0L) && (m == 0))
              return true;
          }
          else
          {
            int i10 = paramr.l();
            int i11 = paramr.l();
            long l4 = i11;
            n = i10;
            l2 = l4;
            m = 0;
            continue;
          }
          if ((paramInt1 != 4) || (paramBoolean))
            break label378;
          if ((0x808080 & l2) != 0L)
            return false;
          l3 = 0xFF & l2 | (0xFF & l2 >> 8) << 7 | (0xFF & l2 >> 16) << 14 | (0xFF & l2 >> 24) << 21;
          if (paramInt1 == 4)
          {
            int i8;
            if ((m & 0x40) != 0)
            {
              i8 = 1;
              if ((m & 0x1) != 0)
              {
                i9 = 1;
                i2 = i8;
                i1 = i9;
                int i3 = 0;
                if (i2 != 0)
                  i3 = 1;
                if (i1 != 0)
                  i3 += 4;
                if (l3 >= i3)
                  continue;
                return false;
              }
            }
            else
            {
              i8 = 0;
              continue;
            }
            int i9 = 0;
            continue;
          }
          else
          {
            if (paramInt1 != 3)
              break label369;
            if ((m & 0x20) != 0)
            {
              i6 = 1;
              if ((m & 0x80) == 0)
                continue;
              i7 = 1;
              i2 = i6;
              i1 = i7;
              continue;
            }
            int i6 = 0;
            continue;
            int i7 = 0;
            continue;
          }
          int i4 = paramr.b();
          if (i4 < l3)
            return false;
          int i5 = (int)l3;
          paramr.d(i5);
          continue;
        }
      }
      finally
      {
        paramr.c(i);
      }
      paramr.c(i);
      return true;
      label369: int i1 = 0;
      int i2 = 0;
      continue;
      label378: long l3 = l2;
    }
  }

  private static int b(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 3))
      return 1;
    return 2;
  }

  private static int b(byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt] == 0)
        return paramInt;
      paramInt++;
    }
    return paramArrayOfByte.length;
  }

  private static ChapterTocFrame b(r paramr, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, a parama)
    throws UnsupportedEncodingException
  {
    int i = paramr.d();
    int j = b(paramr.a, i);
    String str = new String(paramr.a, i, j - i, "ISO-8859-1");
    paramr.c(j + 1);
    int k = paramr.h();
    boolean bool1;
    if ((k & 0x2) != 0)
    {
      bool1 = true;
      if ((k & 0x1) == 0)
        break label158;
    }
    String[] arrayOfString;
    label158: for (boolean bool2 = true; ; bool2 = false)
    {
      int m = paramr.h();
      arrayOfString = new String[m];
      for (int n = 0; n < m; n++)
      {
        int i2 = paramr.d();
        int i3 = b(paramr.a, i2);
        arrayOfString[n] = new String(paramr.a, i2, i3 - i2, "ISO-8859-1");
        paramr.c(i3 + 1);
      }
      bool1 = false;
      break;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = i + paramInt1;
    while (paramr.d() < i1)
    {
      Id3Frame localId3Frame = a(paramInt2, paramr, paramBoolean, paramInt3, parama);
      if (localId3Frame != null)
        localArrayList.add(localId3Frame);
    }
    Id3Frame[] arrayOfId3Frame = new Id3Frame[localArrayList.size()];
    localArrayList.toArray(arrayOfId3Frame);
    return new ChapterTocFrame(str, bool1, bool2, arrayOfString, arrayOfId3Frame);
  }

  private static UrlLinkFrame b(r paramr, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1)
      return null;
    int i = paramr.h();
    String str1 = a(i);
    byte[] arrayOfByte = new byte[paramInt - 1];
    paramr.a(arrayOfByte, 0, paramInt - 1);
    int j = a(arrayOfByte, 0, i);
    String str2 = new String(arrayOfByte, 0, j, str1);
    int k = j + b(i);
    return new UrlLinkFrame("WXXX", str2, a(arrayOfByte, k, b(arrayOfByte, k), "ISO-8859-1"));
  }

  private static UrlLinkFrame b(r paramr, int paramInt, String paramString)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramr.a(arrayOfByte, 0, paramInt);
    return new UrlLinkFrame(paramString, null, new String(arrayOfByte, 0, b(arrayOfByte, 0), "ISO-8859-1"));
  }

  private static String b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 == 2)
    {
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Integer.valueOf(paramInt2);
      arrayOfObject2[1] = Integer.valueOf(paramInt3);
      arrayOfObject2[2] = Integer.valueOf(paramInt4);
      return String.format(localLocale2, "%c%c%c", arrayOfObject2);
    }
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Integer.valueOf(paramInt2);
    arrayOfObject1[1] = Integer.valueOf(paramInt3);
    arrayOfObject1[2] = Integer.valueOf(paramInt4);
    arrayOfObject1[3] = Integer.valueOf(paramInt5);
    return String.format(localLocale1, "%c%c%c%c", arrayOfObject1);
  }

  private static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1)
      return ag.f;
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
  }

  private static BinaryFrame c(r paramr, int paramInt, String paramString)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramr.a(arrayOfByte, 0, paramInt);
    return new BinaryFrame(paramString, arrayOfByte);
  }

  private static PrivFrame c(r paramr, int paramInt)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramr.a(arrayOfByte, 0, paramInt);
    int i = b(arrayOfByte, 0);
    return new PrivFrame(new String(arrayOfByte, 0, i, "ISO-8859-1"), b(arrayOfByte, i + 1, arrayOfByte.length));
  }

  private static GeobFrame d(r paramr, int paramInt)
    throws UnsupportedEncodingException
  {
    int i = paramr.h();
    String str1 = a(i);
    byte[] arrayOfByte = new byte[paramInt - 1];
    paramr.a(arrayOfByte, 0, paramInt - 1);
    int j = b(arrayOfByte, 0);
    String str2 = new String(arrayOfByte, 0, j, "ISO-8859-1");
    int k = j + 1;
    int m = a(arrayOfByte, k, i);
    String str3 = a(arrayOfByte, k, m, str1);
    int n = m + b(i);
    int i1 = a(arrayOfByte, n, i);
    return new GeobFrame(str2, str3, a(arrayOfByte, n, i1, str1), b(arrayOfByte, i1 + b(i), arrayOfByte.length));
  }

  private static CommentFrame e(r paramr, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 4)
      return null;
    int i = paramr.h();
    String str1 = a(i);
    byte[] arrayOfByte1 = new byte[3];
    paramr.a(arrayOfByte1, 0, 3);
    String str2 = new String(arrayOfByte1, 0, 3);
    byte[] arrayOfByte2 = new byte[paramInt - 4];
    paramr.a(arrayOfByte2, 0, paramInt - 4);
    int j = a(arrayOfByte2, 0, i);
    String str3 = new String(arrayOfByte2, 0, j, str1);
    int k = j + b(i);
    return new CommentFrame(str2, str3, a(arrayOfByte2, k, a(arrayOfByte2, k, i), str1));
  }

  private static MlltFrame f(r paramr, int paramInt)
  {
    int i = paramr.i();
    int j = paramr.l();
    int k = paramr.l();
    int m = paramr.h();
    int n = paramr.h();
    q localq = new q();
    localq.a(paramr);
    int i1 = 8 * (paramInt - 10) / (m + n);
    int[] arrayOfInt1 = new int[i1];
    int[] arrayOfInt2 = new int[i1];
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = localq.c(m);
      int i4 = localq.c(n);
      arrayOfInt1[i2] = i3;
      arrayOfInt2[i2] = i4;
    }
    return new MlltFrame(i, j, k, arrayOfInt1, arrayOfInt2);
  }

  private static int g(r paramr, int paramInt)
  {
    byte[] arrayOfByte = paramr.a;
    int i = paramr.d();
    int j = paramInt;
    while (i + 1 < j)
    {
      if (((0xFF & arrayOfByte[i]) == 255) && (arrayOfByte[(i + 1)] == 0))
      {
        System.arraycopy(arrayOfByte, i + 2, arrayOfByte, i + 1, -2 + (j - i));
        j--;
      }
      i++;
    }
    return j;
  }

  public Metadata a(c paramc)
  {
    ByteBuffer localByteBuffer = paramc.b;
    return a(localByteBuffer.array(), localByteBuffer.limit());
  }

  public Metadata a(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    r localr = new r(paramArrayOfByte, paramInt);
    b localb = a(localr);
    if (localb == null)
      return null;
    int i = localr.d();
    int j;
    boolean bool;
    if (b.a(localb) == 2)
    {
      j = 6;
      int k = b.b(localb);
      if (b.c(localb))
        k = g(localr, b.b(localb));
      localr.b(k + i);
      if (a(localr, b.a(localb), j, false))
        break label224;
      if ((b.a(localb) != 4) || (!a(localr, 4, j, true)))
        break label184;
      bool = true;
    }
    while (true)
    {
      if (localr.b() >= j)
      {
        Id3Frame localId3Frame = a(b.a(localb), localr, bool, j, this.c);
        if (localId3Frame == null)
          continue;
        localArrayList.add(localId3Frame);
        continue;
        j = 10;
        break;
        label184: l.c("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + b.a(localb));
        return null;
      }
      return new Metadata(localArrayList);
      label224: bool = false;
    }
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }

  private static final class b
  {
    private final int a;
    private final boolean b;
    private final int c;

    public b(int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.id3.a
 * JD-Core Version:    0.6.2
 */