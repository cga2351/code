package f;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;

public class f
  implements Serializable, Comparable<f>
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final f b = a(new byte[0]);
  final byte[] c;
  transient int d;
  transient String e;

  f(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }

  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return paramChar - '0';
    if ((paramChar >= 'a') && (paramChar <= 'f'))
      return 10 + (paramChar - 'a');
    if ((paramChar >= 'A') && (paramChar <= 'F'))
      return 10 + (paramChar - 'A');
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }

  static int a(String paramString, int paramInt)
  {
    int i = 0;
    int j = paramString.length();
    int k = 0;
    while (i < j)
    {
      if (k == paramInt)
        return i;
      int m = paramString.codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533))
        return -1;
      k++;
      i += Character.charCount(m);
    }
    return paramString.length();
  }

  public static f a(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    f localf = new f(paramString.getBytes(v.a));
    localf.e = paramString;
    return localf;
  }

  public static f a(String paramString, Charset paramCharset)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    return new f(paramString.getBytes(paramCharset));
  }

  public static f a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    return new f((byte[])paramArrayOfByte.clone());
  }

  @Nullable
  public static f b(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("base64 == null");
    byte[] arrayOfByte = b.a(paramString);
    if (arrayOfByte != null)
      return new f(arrayOfByte);
    return null;
  }

  public static f c(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("hex == null");
    if (paramString.length() % 2 != 0)
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = ((byte)((a(paramString.charAt(i * 2)) << 4) + a(paramString.charAt(1 + i * 2))));
    return a(arrayOfByte);
  }

  private f d(String paramString)
  {
    try
    {
      f localf = a(MessageDigest.getInstance(paramString).digest(this.c));
      return localf;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
  }

  public byte a(int paramInt)
  {
    return this.c[paramInt];
  }

  public f a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("beginIndex < 0");
    if (paramInt2 > this.c.length)
      throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
    int i = paramInt2 - paramInt1;
    if (i < 0)
      throw new IllegalArgumentException("endIndex < beginIndex");
    if ((paramInt1 == 0) && (paramInt2 == this.c.length))
      return this;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.c, paramInt1, arrayOfByte, 0, i);
    return new f(arrayOfByte);
  }

  public String a()
  {
    String str1 = this.e;
    if (str1 != null)
      return str1;
    String str2 = new String(this.c, v.a);
    this.e = str2;
    return str2;
  }

  void a(c paramc)
  {
    paramc.b(this.c, 0, this.c.length);
  }

  public boolean a(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    return paramf.a(paramInt2, this.c, paramInt1, paramInt3);
  }

  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.c.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (v.a(this.c, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }

  public final boolean a(f paramf)
  {
    return a(0, paramf, 0, paramf.h());
  }

  public int b(f paramf)
  {
    int i = h();
    int j = paramf.h();
    int k = Math.min(i, j);
    int m = 0;
    while (true)
      if (m < k)
      {
        int n = 0xFF & a(m);
        int i1 = 0xFF & paramf.a(m);
        if (n == i1)
          m++;
        else
          if (n >= i1)
            break;
      }
    do
    {
      return -1;
      return 1;
      if (i == j)
        return 0;
    }
    while (i < j);
    return 1;
  }

  public String b()
  {
    return b.a(this.c);
  }

  public f c()
  {
    return d("MD5");
  }

  public f d()
  {
    return d("SHA-1");
  }

  public f e()
  {
    return d("SHA-256");
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (((paramObject instanceof f)) && (((f)paramObject).h() == this.c.length) && (((f)paramObject).a(0, this.c, 0, this.c.length)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String f()
  {
    int i = 0;
    char[] arrayOfChar = new char[2 * this.c.length];
    byte[] arrayOfByte = this.c;
    int j = arrayOfByte.length;
    int k = 0;
    while (i < j)
    {
      int m = arrayOfByte[i];
      int n = k + 1;
      arrayOfChar[k] = a[(0xF & m >> 4)];
      k = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i++;
    }
    return new String(arrayOfChar);
  }

  public f g()
  {
    int i = 0;
    while (i < this.c.length)
    {
      int j = this.c[i];
      if ((j < 65) || (j > 90))
      {
        i++;
      }
      else
      {
        byte[] arrayOfByte = (byte[])this.c.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(j + 32));
        int m = k;
        if (m < arrayOfByte.length)
        {
          int n = arrayOfByte[m];
          if ((n < 65) || (n > 90));
          while (true)
          {
            m++;
            break;
            arrayOfByte[m] = ((byte)(n + 32));
          }
        }
        this = new f(arrayOfByte);
      }
    }
    return this;
  }

  public int h()
  {
    return this.c.length;
  }

  public int hashCode()
  {
    int i = this.d;
    if (i != 0)
      return i;
    int j = Arrays.hashCode(this.c);
    this.d = j;
    return j;
  }

  public byte[] i()
  {
    return (byte[])this.c.clone();
  }

  public String toString()
  {
    if (this.c.length == 0)
      return "[size=0]";
    String str1 = a();
    int i = a(str1, 64);
    if (i == -1)
    {
      if (this.c.length <= 64)
        return "[hex=" + f() + "]";
      return "[size=" + this.c.length + " hex=" + a(0, 64).f() + "…]";
    }
    String str2 = str1.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < str1.length())
      return "[size=" + this.c.length + " text=" + str2 + "…]";
    return "[text=" + str2 + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.f
 * JD-Core Version:    0.6.2
 */