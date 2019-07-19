package f;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c
  implements d, e, Cloneable, ByteChannel
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

  @Nullable
  p a;
  long b;

  private boolean a(p paramp, int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    int i = paramp.c;
    byte[] arrayOfByte = paramp.a;
    int j = paramInt1;
    p localp = paramp;
    while (paramInt2 < paramInt3)
    {
      if (j == i)
      {
        localp = localp.f;
        arrayOfByte = localp.a;
        j = localp.b;
        i = localp.c;
      }
      if (arrayOfByte[j] != paramf.a(paramInt2))
        return false;
      j++;
      paramInt2++;
    }
    return true;
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    v.a(paramArrayOfByte.length, paramInt1, paramInt2);
    p localp = this.a;
    int i;
    if (localp == null)
      i = -1;
    do
    {
      return i;
      i = Math.min(paramInt2, localp.c - localp.b);
      System.arraycopy(localp.a, localp.b, paramArrayOfByte, paramInt1, i);
      localp.b = (i + localp.b);
      this.b -= i;
    }
    while (localp.b != localp.c);
    this.a = localp.c();
    q.a(localp);
    return i;
  }

  public long a()
  {
    return this.b;
  }

  public long a(byte paramByte)
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }

  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.b);
      arrayOfObject[1] = Long.valueOf(paramLong1);
      arrayOfObject[2] = Long.valueOf(paramLong2);
      throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", arrayOfObject));
    }
    if (paramLong2 > this.b)
      paramLong2 = this.b;
    if (paramLong1 == paramLong2)
      return -1L;
    p localp1 = this.a;
    if (localp1 == null)
      return -1L;
    if (this.b - paramLong1 < paramLong1)
    {
      l1 = this.b;
      localp2 = localp1;
      while (l1 > paramLong1)
      {
        localp2 = localp2.g;
        l1 -= localp2.c - localp2.b;
      }
    }
    long l1 = 0L;
    p localp2 = localp1;
    while (true)
    {
      long l2 = l1 + (localp2.c - localp2.b);
      if (l2 >= paramLong1)
        break;
      localp2 = localp2.f;
      l1 = l2;
    }
    Object localObject;
    long l4 = localObject + (localp2.c - localp2.b);
    localp2 = localp2.f;
    long l3 = l4;
    paramLong1 = l4;
    while (true)
    {
      if (l3 < paramLong2)
      {
        byte[] arrayOfByte = localp2.a;
        int i = (int)Math.min(localp2.c, paramLong2 + localp2.b - l3);
        for (int j = (int)(paramLong1 + localp2.b - l3); j < i; j++)
          if (arrayOfByte[j] == paramByte)
            return l3 + (j - localp2.b);
        break;
      }
      return -1L;
      l3 = l1;
    }
  }

  public long a(f paramf, long paramLong)
    throws IOException
  {
    if (paramf.h() == 0)
      throw new IllegalArgumentException("bytes is empty");
    if (paramLong < 0L)
      throw new IllegalArgumentException("fromIndex < 0");
    p localp1 = this.a;
    if (localp1 == null)
      return -1L;
    if (this.b - paramLong < paramLong)
    {
      l1 = this.b;
      localp2 = localp1;
      while (l1 > paramLong)
      {
        localp2 = localp2.g;
        l1 -= localp2.c - localp2.b;
      }
    }
    long l1 = 0L;
    p localp2 = localp1;
    while (true)
    {
      long l2 = l1 + (localp2.c - localp2.b);
      if (l2 >= paramLong)
        break;
      localp2 = localp2.f;
      l1 = l2;
    }
    int i = paramf.a(0);
    int j = paramf.h();
    long l3 = 1L + (this.b - j);
    long l4 = l1;
    p localp3 = localp2;
    while (l4 < l3)
    {
      byte[] arrayOfByte = localp3.a;
      int k = (int)Math.min(localp3.c, l3 + localp3.b - l4);
      for (int m = (int)(paramLong + localp3.b - l4); m < k; m++)
        if ((arrayOfByte[m] == i) && (a(localp3, m + 1, paramf, 1, j)))
          return l4 + (m - localp3.b);
      long l5 = l4 + (localp3.c - localp3.b);
      localp3 = localp3.f;
      l4 = l5;
      paramLong = l5;
    }
    return -1L;
  }

  public long a(s params)
    throws IOException
  {
    long l = this.b;
    if (l > 0L)
      params.write(this, l);
    return l;
  }

  public long a(t paramt)
    throws IOException
  {
    if (paramt == null)
      throw new IllegalArgumentException("source == null");
    long l2;
    for (long l1 = 0L; ; l1 += l2)
    {
      l2 = paramt.read(this, 8192L);
      if (l2 == -1L)
        break;
    }
    return l1;
  }

  public a a(a parama)
  {
    if (parama.a != null)
      throw new IllegalStateException("already attached to a buffer");
    parama.a = this;
    parama.b = true;
    return parama;
  }

  public c a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(0xC0 | paramInt >> 6);
      b(0x80 | paramInt & 0x3F);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        b(63);
        return this;
      }
      b(0xE0 | paramInt >> 12);
      b(0x80 | 0x3F & paramInt >> 6);
      b(0x80 | paramInt & 0x3F);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(0xF0 | paramInt >> 18);
      b(0x80 | 0x3F & paramInt >> 12);
      b(0x80 | 0x3F & paramInt >> 6);
      b(0x80 | paramInt & 0x3F);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }

  public c a(c paramc, long paramLong1, long paramLong2)
  {
    if (paramc == null)
      throw new IllegalArgumentException("out == null");
    v.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L)
      return this;
    paramc.b = (paramLong2 + paramc.b);
    for (p localp1 = this.a; paramLong1 >= localp1.c - localp1.b; localp1 = localp1.f)
      paramLong1 -= localp1.c - localp1.b;
    label92: p localp2;
    if (paramLong2 > 0L)
    {
      localp2 = localp1.a();
      localp2.b = ((int)(paramLong1 + localp2.b));
      localp2.c = Math.min(localp2.b + (int)paramLong2, localp2.c);
      if (paramc.a != null)
        break label198;
      localp2.g = localp2;
      localp2.f = localp2;
      paramc.a = localp2;
    }
    while (true)
    {
      paramLong2 -= localp2.c - localp2.b;
      localp1 = localp1.f;
      paramLong1 = 0L;
      break label92;
      break;
      label198: paramc.a.g.a(localp2);
    }
  }

  public c a(f paramf)
  {
    if (paramf == null)
      throw new IllegalArgumentException("byteString == null");
    paramf.a(this);
    return this;
  }

  public c a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }

  public c a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      throw new IllegalArgumentException("string == null");
    if (paramInt1 < 0)
      throw new IllegalArgumentException("beginIndex < 0: " + paramInt1);
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    int k;
    label136: int i;
    label167: byte[] arrayOfByte;
    int n;
    int j;
    label237: int i3;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      k = 0;
      if ((i > 56319) || (k < 56320) || (k > 57343))
      {
        b(63);
        paramInt1++;
      }
    }
    else
    {
      if (paramInt1 >= paramInt2)
        break label547;
      i = paramString.charAt(paramInt1);
      if (i < 128)
      {
        p localp = e(1);
        arrayOfByte = localp.a;
        n = localp.c - paramInt1;
        int i1 = Math.min(paramInt2, 8192 - n);
        j = paramInt1 + 1;
        arrayOfByte[(n + paramInt1)] = ((byte)i);
        if (j < i1)
        {
          i3 = paramString.charAt(j);
          if (i3 < 128);
        }
        else
        {
          int i2 = j + n - localp.c;
          localp.c = (i2 + localp.c);
          this.b += i2;
        }
      }
    }
    while (true)
    {
      paramInt1 = j;
      break label167;
      int i4 = j + 1;
      arrayOfByte[(j + n)] = ((byte)i3);
      j = i4;
      break label237;
      if (i < 2048)
      {
        b(0xC0 | i >> 6);
        b(0x80 | i & 0x3F);
        j = paramInt1 + 1;
      }
      else if ((i < 55296) || (i > 57343))
      {
        b(0xE0 | i >> 12);
        b(0x80 | 0x3F & i >> 6);
        b(0x80 | i & 0x3F);
        j = paramInt1 + 1;
      }
      else
      {
        if (paramInt1 + 1 >= paramInt2)
          break;
        k = paramString.charAt(paramInt1 + 1);
        break label136;
        int m = 65536 + ((i & 0xFFFF27FF) << 10 | k & 0xFFFF23FF);
        b(0xF0 | m >> 18);
        b(0x80 | 0x3F & m >> 12);
        b(0x80 | 0x3F & m >> 6);
        b(0x80 | m & 0x3F);
        j = paramInt1 + 2;
      }
    }
    label547: return this;
  }

  public c a(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString == null)
      throw new IllegalArgumentException("string == null");
    if (paramInt1 < 0)
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    if (paramInt2 > paramString.length())
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    if (paramCharset.equals(v.a))
      return a(paramString, paramInt1, paramInt2);
    byte[] arrayOfByte = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
    return b(arrayOfByte, 0, arrayOfByte.length);
  }

  public c a(String paramString, Charset paramCharset)
  {
    return a(paramString, 0, paramString.length(), paramCharset);
  }

  public String a(long paramLong, Charset paramCharset)
    throws EOFException
  {
    v.a(this.b, 0L, paramLong);
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    String str;
    if (paramLong == 0L)
      str = "";
    p localp;
    do
    {
      return str;
      localp = this.a;
      if (paramLong + localp.b > localp.c)
        return new String(h(paramLong), paramCharset);
      str = new String(localp.a, localp.b, (int)paramLong, paramCharset);
      localp.b = ((int)(paramLong + localp.b));
      this.b -= paramLong;
    }
    while (localp.b != localp.c);
    this.a = localp.c();
    q.a(localp);
    return str;
  }

  public String a(Charset paramCharset)
  {
    try
    {
      String str = a(this.b, paramCharset);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }

  public void a(long paramLong)
    throws EOFException
  {
    if (this.b < paramLong)
      throw new EOFException();
  }

  public void a(c paramc, long paramLong)
    throws EOFException
  {
    if (this.b < paramLong)
    {
      paramc.write(this, this.b);
      throw new EOFException();
    }
    paramc.write(this, paramLong);
  }

  public void a(byte[] paramArrayOfByte)
    throws EOFException
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1)
        throw new EOFException();
      i += j;
    }
  }

  public boolean a(long paramLong, f paramf)
  {
    return a(paramLong, paramf, 0, paramf.h());
  }

  public boolean a(long paramLong, f paramf, int paramInt1, int paramInt2)
  {
    if ((paramLong < 0L) || (paramInt1 < 0) || (paramInt2 < 0) || (this.b - paramLong < paramInt2) || (paramf.h() - paramInt1 < paramInt2))
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramInt2)
        break label80;
      if (c(paramLong + i) != paramf.a(paramInt1 + i))
        break;
    }
    label80: return true;
  }

  public long b(f paramf)
    throws IOException
  {
    return a(paramf, 0L);
  }

  public c b()
  {
    return this;
  }

  public c b(int paramInt)
  {
    p localp = e(1);
    byte[] arrayOfByte = localp.a;
    int i = localp.c;
    localp.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b = (1L + this.b);
    return this;
  }

  public c b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("source == null");
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public c b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("source == null");
    v.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      p localp = e(1);
      int j = Math.min(i - paramInt1, 8192 - localp.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localp.a, localp.c, j);
      paramInt1 += j;
      localp.c = (j + localp.c);
    }
    this.b += paramInt2;
    return this;
  }

  public boolean b(long paramLong)
  {
    return this.b >= paramLong;
  }

  public byte c(long paramLong)
  {
    v.a(this.b, paramLong, 1L);
    if (this.b - paramLong > paramLong)
      for (p localp2 = this.a; ; localp2 = localp2.f)
      {
        int i = localp2.c - localp2.b;
        if (paramLong < i)
          return localp2.a[(localp2.b + (int)paramLong)];
        paramLong -= i;
      }
    long l = paramLong - this.b;
    for (p localp1 = this.a.g; ; localp1 = localp1.g)
    {
      l += localp1.c - localp1.b;
      if (l >= 0L)
        return localp1.a[(localp1.b + (int)l)];
    }
  }

  public c c(int paramInt)
  {
    p localp = e(2);
    byte[] arrayOfByte = localp.a;
    int i = localp.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 8));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localp.c = k;
    this.b = (2L + this.b);
    return this;
  }

  public OutputStream c()
  {
    return new OutputStream()
    {
      public void close()
      {
      }

      public void flush()
      {
      }

      public String toString()
      {
        return c.this + ".outputStream()";
      }

      public void write(int paramAnonymousInt)
      {
        c.this.b((byte)paramAnonymousInt);
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        c.this.b(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }

  public void close()
  {
  }

  public c d()
  {
    return this;
  }

  public c d(int paramInt)
  {
    p localp = e(4);
    byte[] arrayOfByte = localp.a;
    int i = localp.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 24));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(0xFF & paramInt >>> 16));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(0xFF & paramInt >>> 8));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(paramInt & 0xFF));
    localp.c = n;
    this.b = (4L + this.b);
    return this;
  }

  public f d(long paramLong)
    throws EOFException
  {
    return new f(h(paramLong));
  }

  public d e()
  {
    return this;
  }

  p e(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 8192))
      throw new IllegalArgumentException();
    p localp1;
    if (this.a == null)
    {
      this.a = q.a();
      p localp2 = this.a;
      p localp3 = this.a;
      localp1 = this.a;
      localp3.g = localp1;
      localp2.f = localp1;
    }
    do
    {
      return localp1;
      localp1 = this.a.g;
    }
    while ((paramInt + localp1.c <= 8192) && (localp1.e));
    return localp1.a(q.a());
  }

  public String e(long paramLong)
    throws EOFException
  {
    return a(paramLong, v.a);
  }

  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof c))
      return false;
    c localc = (c)paramObject;
    if (this.b != localc.b)
      return false;
    if (this.b == l1)
      return true;
    p localp1 = this.a;
    p localp2 = localc.a;
    int i = localp1.b;
    int j = localp2.b;
    while (l1 < this.b)
    {
      long l2 = Math.min(localp1.c - i, localp2.c - j);
      int k = 0;
      while (k < l2)
      {
        byte[] arrayOfByte1 = localp1.a;
        int m = i + 1;
        int n = arrayOfByte1[i];
        byte[] arrayOfByte2 = localp2.a;
        int i1 = j + 1;
        if (n != arrayOfByte2[j])
          return false;
        k++;
        j = i1;
        i = m;
      }
      if (i == localp1.c)
      {
        localp1 = localp1.f;
        i = localp1.b;
      }
      if (j == localp2.c)
      {
        localp2 = localp2.f;
        j = localp2.b;
      }
      l1 += l2;
    }
    return true;
  }

  public f f(int paramInt)
  {
    if (paramInt == 0)
      return f.b;
    return new r(this, paramInt);
  }

  public String f(long paramLong)
    throws EOFException
  {
    long l1 = 9223372036854775807L;
    if (paramLong < 0L)
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    if (paramLong == l1);
    while (true)
    {
      long l2 = a((byte)10, 0L, l1);
      if (l2 == -1L)
        break;
      return g(l2);
      l1 = paramLong + 1L;
    }
    if ((l1 < a()) && (c(l1 - 1L) == 13) && (c(l1) == 10))
      return g(l1);
    c localc = new c();
    a(localc, 0L, Math.min(32L, a()));
    throw new EOFException("\\n not found: limit=" + Math.min(a(), paramLong) + " content=" + localc.q().f() + '…');
  }

  public boolean f()
  {
    return this.b == 0L;
  }

  public void flush()
  {
  }

  public InputStream g()
  {
    return new InputStream()
    {
      public int available()
      {
        return (int)Math.min(c.this.b, 2147483647L);
      }

      public void close()
      {
      }

      public int read()
      {
        if (c.this.b > 0L)
          return 0xFF & c.this.i();
        return -1;
      }

      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return c.this.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }

      public String toString()
      {
        return c.this + ".inputStream()";
      }
    };
  }

  String g(long paramLong)
    throws EOFException
  {
    if ((paramLong > 0L) && (c(paramLong - 1L) == 13))
    {
      String str2 = e(paramLong - 1L);
      i(2L);
      return str2;
    }
    String str1 = e(paramLong);
    i(1L);
    return str1;
  }

  public long h()
  {
    long l = this.b;
    if (l == 0L)
      l = 0L;
    p localp;
    do
    {
      return l;
      localp = this.a.g;
    }
    while ((localp.c >= 8192) || (!localp.e));
    return l - (localp.c - localp.b);
  }

  public byte[] h(long paramLong)
    throws EOFException
  {
    v.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }

  public int hashCode()
  {
    p localp = this.a;
    if (localp == null)
      return 0;
    int i = 1;
    do
    {
      int j = localp.b;
      int k = localp.c;
      while (j < k)
      {
        int m = i * 31 + localp.a[j];
        j++;
        i = m;
      }
      localp = localp.f;
    }
    while (localp != this.a);
    return i;
  }

  public byte i()
  {
    if (this.b == 0L)
      throw new IllegalStateException("size == 0");
    p localp = this.a;
    int i = localp.b;
    int j = localp.c;
    byte[] arrayOfByte = localp.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localp.c();
      q.a(localp);
      return b1;
    }
    localp.b = k;
    return b1;
  }

  public void i(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      if (this.a == null)
        throw new EOFException();
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      paramLong -= i;
      p localp1 = this.a;
      localp1.b = (i + localp1.b);
      if (this.a.b == this.a.c)
      {
        p localp2 = this.a;
        this.a = localp2.c();
        q.a(localp2);
      }
    }
  }

  public boolean isOpen()
  {
    return true;
  }

  public c j(long paramLong)
  {
    p localp = e(8);
    byte[] arrayOfByte = localp.a;
    int i = localp.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(int)(0xFF & paramLong >>> 56));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(int)(0xFF & paramLong >>> 48));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(int)(0xFF & paramLong >>> 40));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(int)(0xFF & paramLong >>> 32));
    int i1 = n + 1;
    arrayOfByte[n] = ((byte)(int)(0xFF & paramLong >>> 24));
    int i2 = i1 + 1;
    arrayOfByte[i1] = ((byte)(int)(0xFF & paramLong >>> 16));
    int i3 = i2 + 1;
    arrayOfByte[i2] = ((byte)(int)(0xFF & paramLong >>> 8));
    int i4 = i3 + 1;
    arrayOfByte[i3] = ((byte)(int)(paramLong & 0xFF));
    localp.c = i4;
    this.b = (8L + this.b);
    return this;
  }

  public short j()
  {
    if (this.b < 2L)
      throw new IllegalStateException("size < 2: " + this.b);
    p localp = this.a;
    int i = localp.b;
    int j = localp.c;
    if (j - i < 2)
      return (short)((0xFF & i()) << 8 | 0xFF & i());
    byte[] arrayOfByte = localp.a;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 8;
    int n = k + 1;
    int i1 = m | 0xFF & arrayOfByte[k];
    this.b -= 2L;
    if (n == j)
    {
      this.a = localp.c();
      q.a(localp);
    }
    while (true)
    {
      return (short)i1;
      localp.b = n;
    }
  }

  public int k()
  {
    if (this.b < 4L)
      throw new IllegalStateException("size < 4: " + this.b);
    p localp = this.a;
    int i = localp.b;
    int j = localp.c;
    if (j - i < 4)
      return (0xFF & i()) << 24 | (0xFF & i()) << 16 | (0xFF & i()) << 8 | 0xFF & i();
    byte[] arrayOfByte = localp.a;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 24;
    int n = k + 1;
    int i1 = m | (0xFF & arrayOfByte[k]) << 16;
    int i2 = n + 1;
    int i3 = i1 | (0xFF & arrayOfByte[n]) << 8;
    int i4 = i2 + 1;
    int i5 = i3 | 0xFF & arrayOfByte[i2];
    this.b -= 4L;
    if (i4 == j)
    {
      this.a = localp.c();
      q.a(localp);
      return i5;
    }
    localp.b = i4;
    return i5;
  }

  public c k(long paramLong)
  {
    if (paramLong == 0L)
      return b(48);
    long l;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L)
        return a("-9223372036854775808");
    }
    for (int i = 1; ; i = 0)
    {
      int j;
      if (l < 100000000L)
        if (l < 10000L)
          if (l < 100L)
            if (l < 10L)
              j = 1;
      p localp;
      byte[] arrayOfByte;
      int k;
      while (true)
      {
        if (i != 0)
          j++;
        localp = e(j);
        arrayOfByte = localp.a;
        k = j + localp.c;
        while (l != 0L)
        {
          int m = (int)(l % 10L);
          k--;
          arrayOfByte[k] = c[m];
          l /= 10L;
        }
        j = 2;
        continue;
        if (l < 1000L)
        {
          j = 3;
        }
        else
        {
          j = 4;
          continue;
          if (l < 1000000L)
          {
            if (l < 100000L)
              j = 5;
            else
              j = 6;
          }
          else if (l < 10000000L)
          {
            j = 7;
          }
          else
          {
            j = 8;
            continue;
            if (l < 1000000000000L)
            {
              if (l < 10000000000L)
              {
                if (l < 1000000000L)
                  j = 9;
                else
                  j = 10;
              }
              else if (l < 100000000000L)
                j = 11;
              else
                j = 12;
            }
            else if (l < 1000000000000000L)
            {
              if (l < 10000000000000L)
                j = 13;
              else if (l < 100000000000000L)
                j = 14;
              else
                j = 15;
            }
            else if (l < 100000000000000000L)
            {
              if (l < 10000000000000000L)
                j = 16;
              else
                j = 17;
            }
            else if (l < 1000000000000000000L)
              j = 18;
            else
              j = 19;
          }
        }
      }
      if (i != 0)
        arrayOfByte[(k - 1)] = 45;
      localp.c = (j + localp.c);
      this.b += j;
      return this;
      l = paramLong;
    }
  }

  public long l()
  {
    if (this.b < 8L)
      throw new IllegalStateException("size < 8: " + this.b);
    p localp = this.a;
    int i = localp.b;
    int j = localp.c;
    if (j - i < 8)
      return (0xFFFFFFFF & k()) << 32 | 0xFFFFFFFF & k();
    byte[] arrayOfByte = localp.a;
    int k = i + 1;
    long l1 = (0xFF & arrayOfByte[i]) << 56;
    int m = k + 1;
    long l2 = l1 | (0xFF & arrayOfByte[k]) << 48;
    int n = m + 1;
    long l3 = l2 | (0xFF & arrayOfByte[m]) << 40;
    int i1 = n + 1;
    long l4 = l3 | (0xFF & arrayOfByte[n]) << 32;
    int i2 = i1 + 1;
    long l5 = l4 | (0xFF & arrayOfByte[i1]) << 24;
    int i3 = i2 + 1;
    long l6 = l5 | (0xFF & arrayOfByte[i2]) << 16;
    int i4 = i3 + 1;
    long l7 = l6 | (0xFF & arrayOfByte[i3]) << 8;
    int i5 = i4 + 1;
    long l8 = l7 | 0xFF & arrayOfByte[i4];
    this.b -= 8L;
    if (i5 == j)
    {
      this.a = localp.c();
      q.a(localp);
      return l8;
    }
    localp.b = i5;
    return l8;
  }

  public c l(long paramLong)
  {
    if (paramLong == 0L)
      return b(48);
    int i = 1 + Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4;
    p localp = e(i);
    byte[] arrayOfByte = localp.a;
    int j = -1 + (i + localp.c);
    int k = localp.c;
    while (j >= k)
    {
      arrayOfByte[j] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      j--;
    }
    localp.c = (i + localp.c);
    this.b += i;
    return this;
  }

  public short m()
  {
    return v.a(j());
  }

  public int n()
  {
    return v.a(k());
  }

  public long o()
  {
    if (this.b == 0L)
      throw new IllegalStateException("size == 0");
    long l1 = 0L;
    int i = 0;
    int j = 0;
    int k = 0;
    long l2 = -7L;
    while (true)
    {
      p localp = this.a;
      byte[] arrayOfByte = localp.a;
      int m = localp.b;
      int n = localp.c;
      if (m < n)
      {
        int i1 = arrayOfByte[m];
        if ((i1 >= 48) && (i1 <= 57))
        {
          int i2 = 48 - i1;
          if ((l1 < -922337203685477580L) || ((l1 == -922337203685477580L) && (i2 < l2)))
          {
            c localc = new c().k(l1).b(i1);
            if (j == 0)
              localc.i();
            throw new NumberFormatException("Number too large: " + localc.r());
          }
          l1 = l1 * 10L + i2;
        }
        while (true)
        {
          m++;
          i++;
          break;
          if ((i1 != 45) || (i != 0))
            break label225;
          j = 1;
          l2 -= 1L;
        }
        label225: if (i == 0)
          throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i1));
        k = 1;
      }
      if (m == n)
      {
        this.a = localp.c();
        q.a(localp);
      }
      while ((k != 0) || (this.a == null))
      {
        this.b -= i;
        if (j == 0)
          break label325;
        return l1;
        localp.b = m;
      }
    }
    label325: return -l1;
  }

  public long p()
  {
    if (this.b == 0L)
      throw new IllegalStateException("size == 0");
    long l1 = 0L;
    int i = 0;
    int j = 0;
    label292: label328: 
    while (true)
    {
      p localp = this.a;
      byte[] arrayOfByte = localp.a;
      int k = localp.b;
      int m = localp.c;
      int n = k;
      int i2;
      if (n < m)
      {
        int i1 = arrayOfByte[n];
        if ((i1 >= 48) && (i1 <= 57))
          i2 = i1 - 48;
        while (true)
        {
          if ((0x0 & l1) == 0L)
            break label292;
          c localc = new c().l(l1).b(i1);
          throw new NumberFormatException("Number too large: " + localc.r());
          if ((i1 >= 97) && (i1 <= 102))
          {
            i2 = 10 + (i1 - 97);
          }
          else
          {
            if ((i1 < 65) || (i1 > 70))
              break;
            i2 = 10 + (i1 - 65);
          }
        }
        if (i == 0)
          throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
        j = 1;
      }
      if (n == m)
      {
        this.a = localp.c();
        q.a(localp);
      }
      while (true)
      {
        if ((j == 0) && (this.a != null))
          break label328;
        this.b -= i;
        return l1;
        long l2 = l1 << 4 | i2;
        int i3 = n + 1;
        i++;
        n = i3;
        l1 = l2;
        break;
        localp.b = n;
      }
    }
  }

  public f q()
  {
    return new f(u());
  }

  public String r()
  {
    try
    {
      String str = a(this.b, v.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }

  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    p localp = this.a;
    int i;
    if (localp == null)
      i = -1;
    do
    {
      return i;
      i = Math.min(paramByteBuffer.remaining(), localp.c - localp.b);
      paramByteBuffer.put(localp.a, localp.b, i);
      localp.b = (i + localp.b);
      this.b -= i;
    }
    while (localp.b != localp.c);
    this.a = localp.c();
    q.a(localp);
    return i;
  }

  public long read(c paramc, long paramLong)
  {
    if (paramc == null)
      throw new IllegalArgumentException("sink == null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.b == 0L)
      return -1L;
    if (paramLong > this.b)
      paramLong = this.b;
    paramc.write(this, paramLong);
    return paramLong;
  }

  public String s()
    throws EOFException
  {
    return f(9223372036854775807L);
  }

  public int t()
    throws EOFException
  {
    if (this.b == 0L)
      throw new EOFException();
    int i = c(0L);
    int m;
    int j;
    int k;
    if ((i & 0x80) == 0)
    {
      int i4 = i & 0x7F;
      m = 0;
      j = i4;
      k = 1;
    }
    while (this.b < k)
    {
      throw new EOFException("size < " + k + ": " + this.b + " (to read code point prefixed 0x" + Integer.toHexString(i) + ")");
      if ((i & 0xE0) == 192)
      {
        j = i & 0x1F;
        k = 2;
        m = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        j = i & 0xF;
        k = 3;
        m = 2048;
      }
      else if ((i & 0xF8) == 240)
      {
        j = i & 0x7;
        k = 4;
        m = 65536;
      }
      else
      {
        i(1L);
        return 65533;
      }
    }
    int n = j;
    int i1 = 1;
    while (i1 < k)
    {
      int i2 = c(i1);
      if ((i2 & 0xC0) == 128)
      {
        int i3 = n << 6 | i2 & 0x3F;
        i1++;
        n = i3;
      }
      else
      {
        i(i1);
        return 65533;
      }
    }
    i(k);
    if (n > 1114111)
      return 65533;
    if ((n >= 55296) && (n <= 57343))
      return 65533;
    if (n < m)
      return 65533;
    return n;
  }

  public u timeout()
  {
    return u.NONE;
  }

  public String toString()
  {
    return x().toString();
  }

  public byte[] u()
  {
    try
    {
      byte[] arrayOfByte = h(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }

  public void v()
  {
    try
    {
      i(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }

  public c w()
  {
    c localc = new c();
    if (this.b == 0L)
      return localc;
    localc.a = this.a.a();
    p localp1 = localc.a;
    p localp2 = localc.a;
    p localp3 = localc.a;
    localp2.g = localp3;
    localp1.f = localp3;
    for (p localp4 = this.a.f; localp4 != this.a; localp4 = localp4.f)
      localc.a.g.a(localp4.a());
    localc.b = this.b;
    return localc;
  }

  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("source == null");
    int i = paramByteBuffer.remaining();
    int j = i;
    while (j > 0)
    {
      p localp = e(1);
      int k = Math.min(j, 8192 - localp.c);
      paramByteBuffer.get(localp.a, localp.c, k);
      j -= k;
      localp.c = (k + localp.c);
    }
    this.b += i;
    return i;
  }

  public void write(c paramc, long paramLong)
  {
    if (paramc == null)
      throw new IllegalArgumentException("source == null");
    if (paramc == this)
      throw new IllegalArgumentException("source == this");
    v.a(paramc.b, 0L, paramLong);
    p localp5;
    long l2;
    if (paramLong > 0L)
    {
      if (paramLong >= paramc.a.c - paramc.a.b)
        break label190;
      if (this.a == null)
        break label161;
      localp5 = this.a.g;
      if ((localp5 == null) || (!localp5.e))
        break label177;
      l2 = paramLong + localp5.c;
      if (!localp5.d)
        break label167;
    }
    label161: label167: for (int i = 0; ; i = localp5.b)
    {
      if (l2 - i > 8192L)
        break label177;
      paramc.a.a(localp5, (int)paramLong);
      paramc.b -= paramLong;
      this.b = (paramLong + this.b);
      return;
      localp5 = null;
      break;
    }
    label177: paramc.a = paramc.a.a((int)paramLong);
    label190: p localp1 = paramc.a;
    long l1 = localp1.c - localp1.b;
    paramc.a = localp1.c();
    if (this.a == null)
    {
      this.a = localp1;
      p localp2 = this.a;
      p localp3 = this.a;
      p localp4 = this.a;
      localp3.g = localp4;
      localp2.f = localp4;
    }
    while (true)
    {
      paramc.b -= l1;
      this.b = (l1 + this.b);
      paramLong -= l1;
      break;
      this.a.g.a(localp1).d();
    }
  }

  public f x()
  {
    if (this.b > 2147483647L)
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    return f((int)this.b);
  }

  public static final class a
    implements Closeable
  {
    public c a;
    public boolean b;
    public long c = -1L;
    public byte[] d;
    public int e = -1;
    public int f = -1;
    private p g;

    public int a()
    {
      if (this.c == this.a.b)
        throw new IllegalStateException();
      if (this.c == -1L)
        return a(0L);
      return a(this.c + (this.f - this.e));
    }

    public int a(long paramLong)
    {
      if ((paramLong < -1L) || (paramLong > this.a.b))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Long.valueOf(paramLong);
        arrayOfObject[1] = Long.valueOf(this.a.b);
        throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", arrayOfObject));
      }
      if ((paramLong == -1L) || (paramLong == this.a.b))
      {
        this.g = null;
        this.c = paramLong;
        this.d = null;
        this.e = -1;
        this.f = -1;
        return -1;
      }
      long l1 = this.a.b;
      Object localObject = this.a.a;
      p localp1 = this.a.a;
      long l2;
      long l3;
      if (this.g != null)
      {
        l2 = this.c - (this.e - this.g.b);
        if (l2 > paramLong)
        {
          localp1 = this.g;
          l3 = 0L;
        }
      }
      while (true)
        if (l2 - paramLong > paramLong - l3)
        {
          while (paramLong >= l3 + (((p)localObject).c - ((p)localObject).b))
          {
            l3 += ((p)localObject).c - ((p)localObject).b;
            localObject = ((p)localObject).f;
          }
          localObject = this.g;
          l3 = l2;
          l2 = l1;
        }
        else
        {
          l3 = l2;
          localObject = localp1;
          while (l3 > paramLong)
          {
            localObject = ((p)localObject).g;
            l3 -= ((p)localObject).c - ((p)localObject).b;
          }
          if ((this.b) && (((p)localObject).d))
          {
            p localp2 = ((p)localObject).b();
            if (this.a.a == localObject)
              this.a.a = localp2;
            localObject = ((p)localObject).a(localp2);
            ((p)localObject).g.c();
          }
          this.g = ((p)localObject);
          this.c = paramLong;
          this.d = ((p)localObject).a;
          this.e = (((p)localObject).b + (int)(paramLong - l3));
          this.f = ((p)localObject).c;
          return this.f - this.e;
          l2 = l1;
          l3 = 0L;
        }
    }

    public void close()
    {
      if (this.a == null)
        throw new IllegalStateException("not attached to a buffer");
      this.a = null;
      this.g = null;
      this.c = -1L;
      this.d = null;
      this.e = -1;
      this.f = -1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.c
 * JD-Core Version:    0.6.2
 */