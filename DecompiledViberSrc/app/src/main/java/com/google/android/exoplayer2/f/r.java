package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class r extends e
  implements v
{
  private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> c = new AtomicReference();
  private final boolean d;
  private final int e;
  private final int f;
  private final String g;
  private final t<String> h;
  private final v.f i;
  private final v.f j;
  private l k;
  private HttpURLConnection l;
  private InputStream m;
  private boolean n;
  private long o;
  private long p;
  private long q;
  private long r;

  public r(String paramString, t<String> paramt, int paramInt1, int paramInt2, boolean paramBoolean, v.f paramf)
  {
    super(true);
    this.g = a.a(paramString);
    this.h = paramt;
    this.j = new v.f();
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramBoolean;
    this.i = paramf;
  }

  // ERROR //
  private static long a(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 86
    //   3: lstore_1
    //   4: aload_0
    //   5: ldc 89
    //   7: invokevirtual 94	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +12 -> 27
    //   18: aload_3
    //   19: invokestatic 106	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   22: lstore 16
    //   24: lload 16
    //   26: lstore_1
    //   27: aload_0
    //   28: ldc 108
    //   30: invokevirtual 94	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +61 -> 101
    //   43: getstatic 48	com/google/android/exoplayer2/f/r:b	Ljava/util/regex/Pattern;
    //   46: aload 4
    //   48: invokevirtual 112	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 118	java/util/regex/Matcher:find	()Z
    //   58: ifeq +43 -> 101
    //   61: aload 5
    //   63: iconst_2
    //   64: invokevirtual 122	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   67: invokestatic 106	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore 7
    //   72: aload 5
    //   74: iconst_1
    //   75: invokevirtual 122	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   78: invokestatic 106	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 9
    //   83: lconst_1
    //   84: lload 7
    //   86: lload 9
    //   88: lsub
    //   89: ladd
    //   90: lstore 11
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +42 -> 137
    //   98: lload 11
    //   100: lstore_1
    //   101: lload_1
    //   102: lreturn
    //   103: astore 15
    //   105: ldc 124
    //   107: new 126	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   114: ldc 129
    //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 135
    //   125: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 144	com/google/android/exoplayer2/g/l:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: goto -107 -> 27
    //   137: lload_1
    //   138: lload 11
    //   140: lcmp
    //   141: ifeq -40 -> 101
    //   144: ldc 124
    //   146: new 126	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   153: ldc 146
    //   155: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_3
    //   159: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 148
    //   164: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 4
    //   169: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 135
    //   174: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 150	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: lload_1
    //   184: lload 11
    //   186: invokestatic 156	java/lang/Math:max	(JJ)J
    //   189: lstore 13
    //   191: lload 13
    //   193: lreturn
    //   194: astore 6
    //   196: ldc 124
    //   198: new 126	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   205: ldc 158
    //   207: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 4
    //   212: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 135
    //   217: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 144	com/google/android/exoplayer2/g/l:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: lload_1
    //   227: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	103	java/lang/NumberFormatException
    //   61	83	194	java/lang/NumberFormatException
    //   144	191	194	java/lang/NumberFormatException
  }

  private HttpURLConnection a(URL paramURL, int paramInt, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.e);
    localHttpURLConnection.setReadTimeout(this.f);
    if (this.i != null)
    {
      Iterator localIterator2 = this.i.a().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        localHttpURLConnection.setRequestProperty((String)localEntry2.getKey(), (String)localEntry2.getValue());
      }
    }
    Iterator localIterator1 = this.j.a().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      localHttpURLConnection.setRequestProperty((String)localEntry1.getKey(), (String)localEntry1.getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      String str = "bytes=" + paramLong1 + "-";
      if (paramLong2 != -1L)
        str = str + (paramLong1 + paramLong2 - 1L);
      localHttpURLConnection.setRequestProperty("Range", str);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.g);
    if (!paramBoolean1)
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null);
    for (boolean bool = true; ; bool = false)
    {
      localHttpURLConnection.setDoOutput(bool);
      localHttpURLConnection.setRequestMethod(l.b(paramInt));
      if (paramArrayOfByte == null)
        break;
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
      localOutputStream.write(paramArrayOfByte);
      localOutputStream.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }

  private static URL a(URL paramURL, String paramString)
    throws IOException
  {
    if (paramString == null)
      throw new ProtocolException("Null location redirect");
    URL localURL = new URL(paramURL, paramString);
    String str = localURL.getProtocol();
    if ((!"https".equals(str)) && (!"http".equals(str)))
      throw new ProtocolException("Unsupported protocol redirect: " + str);
    return localURL;
  }

  private static void a(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((ag.a != 19) && (ag.a != 20))
      return;
    do
      try
      {
        InputStream localInputStream = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (localInputStream.read() == -1)
            break;
          String str = localInputStream.getClass().getName();
          if ((!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(str)) && (!"com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(str)))
            break;
          Method localMethod = localInputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
          localMethod.setAccessible(true);
          localMethod.invoke(localInputStream, new Object[0]);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    while (paramLong > 2048L);
  }

  private int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i1 = -1;
    if (paramInt2 == 0)
      i1 = 0;
    int i2;
    do
    {
      long l1;
      do
      {
        return i1;
        if (this.p == -1L)
          break;
        l1 = this.p - this.r;
      }
      while (l1 == 0L);
      paramInt2 = (int)Math.min(paramInt2, l1);
      i2 = this.m.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i2 != i1)
        break;
    }
    while (this.p == -1L);
    throw new EOFException();
    this.r += i2;
    a(i2);
    return i2;
  }

  private HttpURLConnection d(l paraml)
    throws IOException
  {
    Object localObject = new URL(paraml.a.toString());
    int i1 = paraml.b;
    byte[] arrayOfByte = paraml.c;
    long l1 = paraml.f;
    long l2 = paraml.g;
    boolean bool = paraml.a(1);
    HttpURLConnection localHttpURLConnection;
    if (!this.d)
    {
      localHttpURLConnection = a((URL)localObject, i1, arrayOfByte, l1, l2, bool, true);
      return localHttpURLConnection;
    }
    int i2 = 0;
    label75: int i3 = i2 + 1;
    if (i2 <= 20)
    {
      localHttpURLConnection = a((URL)localObject, i1, arrayOfByte, l1, l2, bool, false);
      int i4 = localHttpURLConnection.getResponseCode();
      String str = localHttpURLConnection.getHeaderField("Location");
      URL localURL;
      if (((i1 == 1) || (i1 == 3)) && ((i4 == 300) || (i4 == 301) || (i4 == 302) || (i4 == 303) || (i4 == 307) || (i4 == 308)))
      {
        localHttpURLConnection.disconnect();
        localURL = a((URL)localObject, str);
      }
      while (true)
      {
        localObject = localURL;
        i2 = i3;
        break label75;
        if ((i1 != 2) || ((i4 != 300) && (i4 != 301) && (i4 != 302) && (i4 != 303)))
          break;
        localHttpURLConnection.disconnect();
        i1 = 1;
        localURL = a((URL)localObject, str);
        arrayOfByte = null;
      }
    }
    throw new NoRouteToHostException("Too many redirects: " + i3);
  }

  private void f()
    throws IOException
  {
    if (this.q == this.o)
      return;
    byte[] arrayOfByte = (byte[])c.getAndSet(null);
    if (arrayOfByte == null)
      arrayOfByte = new byte[4096];
    while (this.q != this.o)
    {
      int i1 = (int)Math.min(this.o - this.q, arrayOfByte.length);
      int i2 = this.m.read(arrayOfByte, 0, i1);
      if (Thread.currentThread().isInterrupted())
        throw new InterruptedIOException();
      if (i2 == -1)
        throw new EOFException();
      this.q += i2;
      a(i2);
    }
    c.set(arrayOfByte);
  }

  private void g()
  {
    if (this.l != null);
    try
    {
      this.l.disconnect();
      this.l = null;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        com.google.android.exoplayer2.g.l.b("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
    }
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws v.c
  {
    try
    {
      f();
      int i1 = b(paramArrayOfByte, paramInt1, paramInt2);
      return i1;
    }
    catch (IOException localIOException)
    {
      throw new v.c(localIOException, this.k, 2);
    }
  }

  // ERROR //
  public long a(l paraml)
    throws v.c
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 431	com/google/android/exoplayer2/f/r:k	Lcom/google/android/exoplayer2/f/l;
    //   7: aload_0
    //   8: lload_2
    //   9: putfield 339	com/google/android/exoplayer2/f/r:r	J
    //   12: aload_0
    //   13: lload_2
    //   14: putfield 393	com/google/android/exoplayer2/f/r:q	J
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 438	com/google/android/exoplayer2/f/r:b	(Lcom/google/android/exoplayer2/f/l;)V
    //   22: aload_0
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 440	com/google/android/exoplayer2/f/r:d	(Lcom/google/android/exoplayer2/f/l;)Ljava/net/HttpURLConnection;
    //   28: putfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   31: aload_0
    //   32: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   35: invokevirtual 376	java/net/HttpURLConnection:getResponseCode	()I
    //   38: istore 6
    //   40: aload_0
    //   41: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   44: invokevirtual 443	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   47: astore 7
    //   49: iload 6
    //   51: sipush 200
    //   54: if_icmplt +11 -> 65
    //   57: iload 6
    //   59: sipush 299
    //   62: if_icmple +141 -> 203
    //   65: aload_0
    //   66: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   69: invokevirtual 446	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   72: astore 8
    //   74: aload_0
    //   75: invokespecial 448	com/google/android/exoplayer2/f/r:g	()V
    //   78: new 450	com/google/android/exoplayer2/f/v$e
    //   81: dup
    //   82: iload 6
    //   84: aload 7
    //   86: aload 8
    //   88: aload_1
    //   89: invokespecial 453	com/google/android/exoplayer2/f/v$e:<init>	(ILjava/lang/String;Ljava/util/Map;Lcom/google/android/exoplayer2/f/l;)V
    //   92: astore 9
    //   94: iload 6
    //   96: sipush 416
    //   99: if_icmpne +17 -> 116
    //   102: aload 9
    //   104: new 455	com/google/android/exoplayer2/f/j
    //   107: dup
    //   108: iconst_0
    //   109: invokespecial 457	com/google/android/exoplayer2/f/j:<init>	(I)V
    //   112: invokevirtual 461	com/google/android/exoplayer2/f/v$e:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   115: pop
    //   116: aload 9
    //   118: athrow
    //   119: astore 4
    //   121: new 425	com/google/android/exoplayer2/f/v$c
    //   124: dup
    //   125: new 126	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 463
    //   135: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: getfield 355	com/google/android/exoplayer2/f/l:a	Landroid/net/Uri;
    //   142: invokevirtual 358	android/net/Uri:toString	()Ljava/lang/String;
    //   145: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: aload 4
    //   153: aload_1
    //   154: iconst_1
    //   155: invokespecial 466	com/google/android/exoplayer2/f/v$c:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/google/android/exoplayer2/f/l;I)V
    //   158: athrow
    //   159: astore 5
    //   161: aload_0
    //   162: invokespecial 448	com/google/android/exoplayer2/f/r:g	()V
    //   165: new 425	com/google/android/exoplayer2/f/v$c
    //   168: dup
    //   169: new 126	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 463
    //   179: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: getfield 355	com/google/android/exoplayer2/f/l:a	Landroid/net/Uri;
    //   186: invokevirtual 358	android/net/Uri:toString	()Ljava/lang/String;
    //   189: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 5
    //   197: aload_1
    //   198: iconst_1
    //   199: invokespecial 466	com/google/android/exoplayer2/f/v$c:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/google/android/exoplayer2/f/l;I)V
    //   202: athrow
    //   203: aload_0
    //   204: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   207: invokevirtual 469	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   210: astore 11
    //   212: aload_0
    //   213: getfield 69	com/google/android/exoplayer2/f/r:h	Lcom/google/android/exoplayer2/g/t;
    //   216: ifnull +32 -> 248
    //   219: aload_0
    //   220: getfield 69	com/google/android/exoplayer2/f/r:h	Lcom/google/android/exoplayer2/g/t;
    //   223: aload 11
    //   225: invokeinterface 473 2 0
    //   230: ifne +18 -> 248
    //   233: aload_0
    //   234: invokespecial 448	com/google/android/exoplayer2/f/r:g	()V
    //   237: new 475	com/google/android/exoplayer2/f/v$d
    //   240: dup
    //   241: aload 11
    //   243: aload_1
    //   244: invokespecial 478	com/google/android/exoplayer2/f/v$d:<init>	(Ljava/lang/String;Lcom/google/android/exoplayer2/f/l;)V
    //   247: athrow
    //   248: iload 6
    //   250: sipush 200
    //   253: if_icmpne +17 -> 270
    //   256: aload_1
    //   257: getfield 366	com/google/android/exoplayer2/f/l:f	J
    //   260: lload_2
    //   261: lcmp
    //   262: ifeq +8 -> 270
    //   265: aload_1
    //   266: getfield 366	com/google/android/exoplayer2/f/l:f	J
    //   269: lstore_2
    //   270: aload_0
    //   271: lload_2
    //   272: putfield 395	com/google/android/exoplayer2/f/r:o	J
    //   275: aload_1
    //   276: iconst_1
    //   277: invokevirtual 371	com/google/android/exoplayer2/f/l:a	(I)Z
    //   280: ifne +92 -> 372
    //   283: aload_1
    //   284: getfield 368	com/google/android/exoplayer2/f/l:g	J
    //   287: ldc2_w 86
    //   290: lcmp
    //   291: ifeq +37 -> 328
    //   294: aload_0
    //   295: aload_1
    //   296: getfield 368	com/google/android/exoplayer2/f/l:g	J
    //   299: putfield 337	com/google/android/exoplayer2/f/r:p	J
    //   302: aload_0
    //   303: aload_0
    //   304: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   307: invokevirtual 293	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   310: putfield 344	com/google/android/exoplayer2/f/r:m	Ljava/io/InputStream;
    //   313: aload_0
    //   314: iconst_1
    //   315: putfield 480	com/google/android/exoplayer2/f/r:n	Z
    //   318: aload_0
    //   319: aload_1
    //   320: invokevirtual 482	com/google/android/exoplayer2/f/r:c	(Lcom/google/android/exoplayer2/f/l;)V
    //   323: aload_0
    //   324: getfield 337	com/google/android/exoplayer2/f/r:p	J
    //   327: lreturn
    //   328: aload_0
    //   329: getfield 418	com/google/android/exoplayer2/f/r:l	Ljava/net/HttpURLConnection;
    //   332: invokestatic 484	com/google/android/exoplayer2/f/r:a	(Ljava/net/HttpURLConnection;)J
    //   335: lstore 13
    //   337: lload 13
    //   339: ldc2_w 86
    //   342: lcmp
    //   343: ifeq +21 -> 364
    //   346: lload 13
    //   348: aload_0
    //   349: getfield 395	com/google/android/exoplayer2/f/r:o	J
    //   352: lsub
    //   353: lstore 15
    //   355: aload_0
    //   356: lload 15
    //   358: putfield 337	com/google/android/exoplayer2/f/r:p	J
    //   361: goto -59 -> 302
    //   364: ldc2_w 86
    //   367: lstore 15
    //   369: goto -14 -> 355
    //   372: aload_0
    //   373: aload_1
    //   374: getfield 368	com/google/android/exoplayer2/f/l:g	J
    //   377: putfield 337	com/google/android/exoplayer2/f/r:p	J
    //   380: goto -78 -> 302
    //   383: astore 12
    //   385: aload_0
    //   386: invokespecial 448	com/google/android/exoplayer2/f/r:g	()V
    //   389: new 425	com/google/android/exoplayer2/f/v$c
    //   392: dup
    //   393: aload 12
    //   395: aload_1
    //   396: iconst_1
    //   397: invokespecial 434	com/google/android/exoplayer2/f/v$c:<init>	(Ljava/io/IOException;Lcom/google/android/exoplayer2/f/l;I)V
    //   400: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   22	31	119	java/io/IOException
    //   31	49	159	java/io/IOException
    //   302	313	383	java/io/IOException
  }

  public Uri a()
  {
    if (this.l == null)
      return null;
    return Uri.parse(this.l.getURL().toString());
  }

  public Map<String, List<String>> b()
  {
    if (this.l == null)
      return Collections.emptyMap();
    return this.l.getHeaderFields();
  }

  public void c()
    throws v.c
  {
    try
    {
      if (this.m != null)
        a(this.l, e());
      try
      {
        this.m.close();
        return;
      }
      catch (IOException localIOException)
      {
        throw new v.c(localIOException, this.k, 3);
      }
    }
    finally
    {
      this.m = null;
      g();
      if (this.n)
      {
        this.n = false;
        d();
      }
    }
  }

  protected final long e()
  {
    if (this.p == -1L)
      return this.p;
    return this.p - this.r;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.r
 * JD-Core Version:    0.6.2
 */