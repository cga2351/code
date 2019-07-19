package com.google.a.a.c;

import com.google.a.a.f.ad;
import com.google.a.a.f.g;
import com.google.a.a.f.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class s
{
  aa a;
  private InputStream b;
  private final String c;
  private final String d;
  private final o e;
  private final int f;
  private final String g;
  private final p h;
  private int i;
  private boolean j;
  private boolean k;

  s(p paramp, aa paramaa)
    throws IOException
  {
    this.h = paramp;
    this.i = paramp.e();
    this.j = paramp.f();
    this.a = paramaa;
    this.c = paramaa.b();
    int m = paramaa.e();
    if (m < 0)
      m = 0;
    this.f = m;
    String str1 = paramaa.f();
    this.g = str1;
    Logger localLogger = w.a;
    int n;
    StringBuilder localStringBuilder1;
    if ((this.j) && (localLogger.isLoggable(Level.CONFIG)))
    {
      n = 1;
      if (n == 0)
        break label284;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("-------------- RESPONSE --------------").append(ad.a);
      String str2 = paramaa.d();
      if (str2 == null)
        break label233;
      localStringBuilder1.append(str2);
      label139: localStringBuilder1.append(ad.a);
    }
    while (true)
    {
      m localm = paramp.h();
      StringBuilder localStringBuilder2;
      label163: String str3;
      o localo;
      if (n != 0)
      {
        localStringBuilder2 = localStringBuilder1;
        localm.a(paramaa, localStringBuilder2);
        str3 = paramaa.c();
        if (str3 == null)
          str3 = paramp.h().d();
        this.d = str3;
        localo = null;
        if (str3 != null)
          break label270;
      }
      while (true)
      {
        this.e = localo;
        if (n != 0)
          localLogger.config(localStringBuilder1.toString());
        return;
        n = 0;
        break;
        label233: localStringBuilder1.append(this.f);
        if (str1 == null)
          break label139;
        localStringBuilder1.append(' ').append(str1);
        break label139;
        localStringBuilder2 = null;
        break label163;
        label270: localo = new o(str3);
      }
      label284: localStringBuilder1 = null;
    }
  }

  private boolean l()
    throws IOException
  {
    int m = 1;
    int n = d();
    if ((f().b().equals("HEAD")) || (n / 100 == m) || (n == 204) || (n == 304))
    {
      h();
      m = 0;
    }
    return m;
  }

  public <T> T a(Class<T> paramClass)
    throws IOException
  {
    if (!l())
      return null;
    return this.h.l().a(g(), k(), paramClass);
  }

  public String a()
  {
    return this.d;
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    com.google.a.a.f.o.a(g(), paramOutputStream);
  }

  public m b()
  {
    return this.h.h();
  }

  public boolean c()
  {
    return v.a(this.f);
  }

  public int d()
  {
    return this.f;
  }

  public String e()
  {
    return this.g;
  }

  public p f()
  {
    return this.h;
  }

  // ERROR //
  public InputStream g()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 172	com/google/a/a/c/s:k	Z
    //   4: ifne +100 -> 104
    //   7: aload_0
    //   8: getfield 45	com/google/a/a/c/s:a	Lcom/google/a/a/c/aa;
    //   11: invokevirtual 174	com/google/a/a/c/aa:a	()Ljava/io/InputStream;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +83 -> 99
    //   19: aload_0
    //   20: getfield 52	com/google/a/a/c/s:c	Ljava/lang/String;
    //   23: astore 6
    //   25: aload 6
    //   27: ifnull +26 -> 53
    //   30: aload 6
    //   32: ldc 176
    //   34: invokevirtual 180	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +16 -> 53
    //   40: new 182	java/util/zip/GZIPInputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 185	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore 7
    //   50: aload 7
    //   52: astore_1
    //   53: getstatic 64	com/google/a/a/c/w:a	Ljava/util/logging/Logger;
    //   56: astore 9
    //   58: aload_0
    //   59: getfield 43	com/google/a/a/c/s:j	Z
    //   62: ifeq +32 -> 94
    //   65: aload 9
    //   67: getstatic 70	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   70: invokevirtual 76	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   73: ifeq +21 -> 94
    //   76: new 187	com/google/a/a/f/s
    //   79: dup
    //   80: aload_1
    //   81: aload 9
    //   83: getstatic 70	java/util/logging/Level:CONFIG	Ljava/util/logging/Level;
    //   86: aload_0
    //   87: getfield 38	com/google/a/a/c/s:i	I
    //   90: invokespecial 190	com/google/a/a/f/s:<init>	(Ljava/io/InputStream;Ljava/util/logging/Logger;Ljava/util/logging/Level;I)V
    //   93: astore_1
    //   94: aload_0
    //   95: aload_1
    //   96: putfield 192	com/google/a/a/c/s:b	Ljava/io/InputStream;
    //   99: aload_0
    //   100: iconst_1
    //   101: putfield 172	com/google/a/a/c/s:k	Z
    //   104: aload_0
    //   105: getfield 192	com/google/a/a/c/s:b	Ljava/io/InputStream;
    //   108: areturn
    //   109: astore 5
    //   111: aload_1
    //   112: invokevirtual 197	java/io/InputStream:close	()V
    //   115: goto -16 -> 99
    //   118: astore_2
    //   119: aload_1
    //   120: astore_3
    //   121: aload_2
    //   122: astore 4
    //   124: aload_3
    //   125: invokevirtual 197	java/io/InputStream:close	()V
    //   128: aload 4
    //   130: athrow
    //   131: astore 8
    //   133: aload_1
    //   134: astore_3
    //   135: aload 8
    //   137: astore 4
    //   139: goto -15 -> 124
    //
    // Exception table:
    //   from	to	target	type
    //   19	25	109	java/io/EOFException
    //   30	50	109	java/io/EOFException
    //   53	94	109	java/io/EOFException
    //   94	99	109	java/io/EOFException
    //   19	25	118	finally
    //   30	50	118	finally
    //   53	94	131	finally
    //   94	99	131	finally
  }

  public void h()
    throws IOException
  {
    InputStream localInputStream = g();
    if (localInputStream != null)
      localInputStream.close();
  }

  public void i()
    throws IOException
  {
    h();
    this.a.h();
  }

  public String j()
    throws IOException
  {
    InputStream localInputStream = g();
    if (localInputStream == null)
      return "";
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    com.google.a.a.f.o.a(localInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toString(k().name());
  }

  public Charset k()
  {
    if ((this.e == null) || (this.e.d() == null))
      return g.b;
    return this.e.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.s
 * JD-Core Version:    0.6.2
 */