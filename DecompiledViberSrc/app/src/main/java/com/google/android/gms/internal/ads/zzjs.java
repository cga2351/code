package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzjs
  implements zzkf
{
  private static final Pattern zzapl = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> zzapm = new AtomicReference();
  private final zzke zzaoz;
  private boolean zzapd;
  private final boolean zzapn;
  private final int zzapo;
  private final int zzapp;
  private final String zzapq;
  private final zzkn<String> zzapr;
  private final HashMap<String, String> zzaps;
  private zzjq zzapt;
  private HttpURLConnection zzapu;
  private InputStream zzapv;
  private long zzapw;
  private long zzapx;
  private long zzapy;
  private long zzce;

  public zzjs(String paramString, zzkn<String> paramzzkn, zzke paramzzke, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException();
    this.zzapq = paramString;
    this.zzapr = null;
    this.zzaoz = null;
    this.zzaps = new HashMap();
    this.zzapo = paramInt1;
    this.zzapp = paramInt2;
    this.zzapn = paramBoolean;
  }

  private final void closeConnection()
  {
    if (this.zzapu != null)
    {
      this.zzapu.disconnect();
      this.zzapu = null;
    }
  }

  private final HttpURLConnection zza(URL paramURL, long paramLong1, long paramLong2, boolean paramBoolean)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.zzapo);
    localHttpURLConnection.setReadTimeout(this.zzapp);
    localHttpURLConnection.setDoOutput(false);
    synchronized (this.zzaps)
    {
      Iterator localIterator = this.zzaps.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      String str1 = 27 + "bytes=" + paramLong1 + "-";
      if (paramLong2 != -1L)
      {
        String str2 = String.valueOf(str1);
        long l = paramLong1 + paramLong2 - 1L;
        str1 = 20 + String.valueOf(str2).length() + str2 + l;
      }
      localHttpURLConnection.setRequestProperty("Range", str1);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.zzapq);
    if (!paramBoolean)
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    return localHttpURLConnection;
  }

  // ERROR //
  private static long zzc(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 149
    //   3: lstore_1
    //   4: aload_0
    //   5: ldc 191
    //   7: invokevirtual 195	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +12 -> 27
    //   18: aload_3
    //   19: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   22: lstore 19
    //   24: lload 19
    //   26: lstore_1
    //   27: aload_0
    //   28: ldc 203
    //   30: invokevirtual 195	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +61 -> 101
    //   43: getstatic 50	com/google/android/gms/internal/ads/zzjs:zzapl	Ljava/util/regex/Pattern;
    //   46: aload 4
    //   48: invokevirtual 207	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 212	java/util/regex/Matcher:find	()Z
    //   58: ifeq +43 -> 101
    //   61: aload 5
    //   63: iconst_2
    //   64: invokevirtual 216	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   67: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore 8
    //   72: aload 5
    //   74: iconst_1
    //   75: invokevirtual 216	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   78: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 10
    //   83: lconst_1
    //   84: lload 8
    //   86: lload 10
    //   88: lsub
    //   89: ladd
    //   90: lstore 12
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +53 -> 148
    //   98: lload 12
    //   100: lstore_1
    //   101: lload_1
    //   102: lreturn
    //   103: astore 17
    //   105: ldc 218
    //   107: new 152	java/lang/StringBuilder
    //   110: dup
    //   111: bipush 28
    //   113: aload_3
    //   114: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 177	java/lang/String:length	()I
    //   120: iadd
    //   121: invokespecial 154	java/lang/StringBuilder:<init>	(I)V
    //   124: ldc 220
    //   126: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 222
    //   135: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   144: pop
    //   145: goto -118 -> 27
    //   148: lload_1
    //   149: lload 12
    //   151: lcmp
    //   152: ifeq -51 -> 101
    //   155: ldc 218
    //   157: new 152	java/lang/StringBuilder
    //   160: dup
    //   161: bipush 26
    //   163: aload_3
    //   164: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 177	java/lang/String:length	()I
    //   170: iadd
    //   171: aload 4
    //   173: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 177	java/lang/String:length	()I
    //   179: iadd
    //   180: invokespecial 154	java/lang/StringBuilder:<init>	(I)V
    //   183: ldc 230
    //   185: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 232
    //   194: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 4
    //   199: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 222
    //   204: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 235	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: lload_1
    //   215: lload 12
    //   217: invokestatic 241	java/lang/Math:max	(JJ)J
    //   220: lstore 15
    //   222: lload 15
    //   224: lreturn
    //   225: astore 6
    //   227: ldc 218
    //   229: new 152	java/lang/StringBuilder
    //   232: dup
    //   233: bipush 27
    //   235: aload 4
    //   237: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: invokevirtual 177	java/lang/String:length	()I
    //   243: iadd
    //   244: invokespecial 154	java/lang/StringBuilder:<init>	(I)V
    //   247: ldc 243
    //   249: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 4
    //   254: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 222
    //   259: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 228	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   268: pop
    //   269: lload_1
    //   270: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	103	java/lang/NumberFormatException
    //   61	83	225	java/lang/NumberFormatException
    //   155	222	225	java/lang/NumberFormatException
  }

  // ERROR //
  public final void close()
    throws zzjx
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 250	com/google/android/gms/internal/ads/zzjs:zzapv	Ljava/io/InputStream;
    //   4: ifnull +85 -> 89
    //   7: aload_0
    //   8: getfield 88	com/google/android/gms/internal/ads/zzjs:zzapu	Ljava/net/HttpURLConnection;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 252	com/google/android/gms/internal/ads/zzjs:zzapx	J
    //   16: ldc2_w 149
    //   19: lcmp
    //   20: ifne +102 -> 122
    //   23: aload_0
    //   24: getfield 252	com/google/android/gms/internal/ads/zzjs:zzapx	J
    //   27: lstore 7
    //   29: getstatic 257	com/google/android/gms/internal/ads/zzkq:SDK_INT	I
    //   32: bipush 19
    //   34: if_icmpeq +15 -> 49
    //   37: getstatic 257	com/google/android/gms/internal/ads/zzkq:SDK_INT	I
    //   40: istore 17
    //   42: iload 17
    //   44: bipush 20
    //   46: if_icmpne +31 -> 77
    //   49: aload_2
    //   50: invokevirtual 261	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   53: astore 12
    //   55: lload 7
    //   57: ldc2_w 149
    //   60: lcmp
    //   61: ifne +81 -> 142
    //   64: aload 12
    //   66: invokevirtual 266	java/io/InputStream:read	()I
    //   69: istore 13
    //   71: iload 13
    //   73: iconst_m1
    //   74: if_icmpne +77 -> 151
    //   77: aload_0
    //   78: getfield 250	com/google/android/gms/internal/ads/zzjs:zzapv	Ljava/io/InputStream;
    //   81: invokevirtual 268	java/io/InputStream:close	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 250	com/google/android/gms/internal/ads/zzjs:zzapv	Ljava/io/InputStream;
    //   89: aload_0
    //   90: getfield 270	com/google/android/gms/internal/ads/zzjs:zzapd	Z
    //   93: ifeq +28 -> 121
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 270	com/google/android/gms/internal/ads/zzjs:zzapd	Z
    //   101: aload_0
    //   102: getfield 74	com/google/android/gms/internal/ads/zzjs:zzaoz	Lcom/google/android/gms/internal/ads/zzke;
    //   105: ifnull +12 -> 117
    //   108: aload_0
    //   109: getfield 74	com/google/android/gms/internal/ads/zzjs:zzaoz	Lcom/google/android/gms/internal/ads/zzke;
    //   112: invokeinterface 275 1 0
    //   117: aload_0
    //   118: invokespecial 277	com/google/android/gms/internal/ads/zzjs:closeConnection	()V
    //   121: return
    //   122: aload_0
    //   123: getfield 252	com/google/android/gms/internal/ads/zzjs:zzapx	J
    //   126: lstore_3
    //   127: aload_0
    //   128: getfield 279	com/google/android/gms/internal/ads/zzjs:zzce	J
    //   131: lstore 5
    //   133: lload_3
    //   134: lload 5
    //   136: lsub
    //   137: lstore 7
    //   139: goto -110 -> 29
    //   142: lload 7
    //   144: ldc2_w 280
    //   147: lcmp
    //   148: ifle -71 -> 77
    //   151: aload 12
    //   153: invokevirtual 285	java/lang/Object:getClass	()Ljava/lang/Class;
    //   156: invokevirtual 290	java/lang/Class:getName	()Ljava/lang/String;
    //   159: astore 14
    //   161: aload 14
    //   163: ldc_w 292
    //   166: invokevirtual 296	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +14 -> 183
    //   172: aload 14
    //   174: ldc_w 298
    //   177: invokevirtual 296	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq -103 -> 77
    //   183: aload 12
    //   185: invokevirtual 285	java/lang/Object:getClass	()Ljava/lang/Class;
    //   188: invokevirtual 301	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   191: ldc_w 303
    //   194: iconst_0
    //   195: anewarray 287	java/lang/Class
    //   198: invokevirtual 307	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   201: astore 15
    //   203: aload 15
    //   205: iconst_1
    //   206: invokevirtual 312	java/lang/reflect/Method:setAccessible	(Z)V
    //   209: aload 15
    //   211: aload 12
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokevirtual 316	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: goto -144 -> 77
    //   224: astore 11
    //   226: goto -149 -> 77
    //   229: astore 10
    //   231: new 246	com/google/android/gms/internal/ads/zzjx
    //   234: dup
    //   235: aload 10
    //   237: aload_0
    //   238: getfield 318	com/google/android/gms/internal/ads/zzjs:zzapt	Lcom/google/android/gms/internal/ads/zzjq;
    //   241: invokespecial 321	com/google/android/gms/internal/ads/zzjx:<init>	(Ljava/io/IOException;Lcom/google/android/gms/internal/ads/zzjq;)V
    //   244: athrow
    //   245: astore_1
    //   246: aload_0
    //   247: getfield 270	com/google/android/gms/internal/ads/zzjs:zzapd	Z
    //   250: ifeq +28 -> 278
    //   253: aload_0
    //   254: iconst_0
    //   255: putfield 270	com/google/android/gms/internal/ads/zzjs:zzapd	Z
    //   258: aload_0
    //   259: getfield 74	com/google/android/gms/internal/ads/zzjs:zzaoz	Lcom/google/android/gms/internal/ads/zzke;
    //   262: ifnull +12 -> 274
    //   265: aload_0
    //   266: getfield 74	com/google/android/gms/internal/ads/zzjs:zzaoz	Lcom/google/android/gms/internal/ads/zzke;
    //   269: invokeinterface 275 1 0
    //   274: aload_0
    //   275: invokespecial 277	com/google/android/gms/internal/ads/zzjs:closeConnection	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore 9
    //   282: goto -205 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   49	55	224	java/io/IOException
    //   64	71	224	java/io/IOException
    //   151	183	224	java/io/IOException
    //   183	221	224	java/io/IOException
    //   77	84	229	java/io/IOException
    //   0	29	245	finally
    //   29	42	245	finally
    //   49	55	245	finally
    //   64	71	245	finally
    //   77	84	245	finally
    //   84	89	245	finally
    //   122	133	245	finally
    //   151	183	245	finally
    //   183	221	245	finally
    //   231	245	245	finally
    //   49	55	280	java/lang/Exception
    //   64	71	280	java/lang/Exception
    //   151	183	280	java/lang/Exception
    //   183	221	280	java/lang/Exception
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzjx
  {
    byte[] arrayOfByte;
    while (true)
    {
      int k;
      try
      {
        if (this.zzapy == this.zzapw)
          break label166;
        arrayOfByte = (byte[])zzapm.getAndSet(null);
        if (arrayOfByte == null)
          arrayOfByte = new byte[4096];
        if (this.zzapy == this.zzapw)
          break;
        int j = (int)Math.min(this.zzapw - this.zzapy, arrayOfByte.length);
        k = this.zzapv.read(arrayOfByte, 0, j);
        if (Thread.interrupted())
          throw new InterruptedIOException();
      }
      catch (IOException localIOException)
      {
        throw new zzjx(localIOException, this.zzapt);
      }
      if (k == -1)
        throw new EOFException();
      this.zzapy += k;
      if (this.zzaoz != null)
        this.zzaoz.zzab(k);
    }
    zzapm.set(arrayOfByte);
    label166: if (this.zzapx != -1L)
      paramInt2 = (int)Math.min(paramInt2, this.zzapx - this.zzce);
    while (paramInt2 != 0)
    {
      i = this.zzapv.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i == -1)
      {
        if ((this.zzapx == -1L) || (this.zzapx == this.zzce))
          break label291;
        throw new EOFException();
      }
      this.zzce += i;
      if (this.zzaoz == null)
        break;
      this.zzaoz.zzab(i);
      return i;
    }
    int i = -1;
    return i;
    label291: return -1;
  }

  public final long zza(zzjq paramzzjq)
    throws zzjx
  {
    this.zzapt = paramzzjq;
    this.zzce = 0L;
    this.zzapy = 0L;
    try
    {
      localObject = new URL(paramzzjq.uri.toString());
      l1 = paramzzjq.zzahv;
      l2 = paramzzjq.zzcd;
      if ((0x1 & paramzzjq.flags) != 0)
      {
        bool = true;
        if (this.zzapn)
          break label142;
        localHttpURLConnection = zza((URL)localObject, l1, l2, bool);
        localHttpURLConnection.connect();
        this.zzapu = localHttpURLConnection;
      }
    }
    catch (IOException localIOException1)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        label142: int k;
        do
        {
          long l1;
          long l2;
          boolean bool;
          while (true)
          {
            m = this.zzapu.getResponseCode();
            if ((m >= 200) && (m <= 299))
              break;
            Map localMap = this.zzapu.getHeaderFields();
            closeConnection();
            throw new zzjy(m, localMap, paramzzjq);
            bool = false;
          }
          i = 0;
          j = i + 1;
          if (i > 20)
            break;
          localHttpURLConnection = zza((URL)localObject, l1, l2, bool);
          localHttpURLConnection.setInstanceFollowRedirects(false);
          localHttpURLConnection.connect();
          k = localHttpURLConnection.getResponseCode();
        }
        while ((k != 300) && (k != 301) && (k != 302) && (k != 303) && (k != 307) && (k != 308));
        String str3 = localHttpURLConnection.getHeaderField("Location");
        localHttpURLConnection.disconnect();
        String str1;
        if (str3 == null)
        {
          throw new ProtocolException("Null location redirect");
          localIOException1 = localIOException1;
          str1 = String.valueOf(paramzzjq.uri.toString());
          if (str1.length() == 0)
            break label433;
        }
        label433: for (String str2 = "Unable to connect to ".concat(str1); ; str2 = new String("Unable to connect to "))
        {
          throw new zzjx(str2, localIOException1, paramzzjq);
          localURL = new URL((URL)localObject, str3);
          String str4 = localURL.getProtocol();
          if (("https".equals(str4)) || ("http".equals(str4)))
            break;
          String str5 = String.valueOf(str4);
          if (str5.length() != 0);
          for (String str6 = "Unsupported protocol redirect: ".concat(str5); ; str6 = new String("Unsupported protocol redirect: "))
            throw new ProtocolException(str6);
          throw new NoRouteToHostException(31 + "Too many redirects: " + j);
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
        {
          int m;
          int j;
          URL localURL;
          closeConnection();
          String str7 = String.valueOf(paramzzjq.uri.toString());
          if (str7.length() != 0);
          for (String str8 = "Unable to connect to ".concat(str7); ; str8 = new String("Unable to connect to "))
            throw new zzjx(str8, localIOException2, paramzzjq);
          this.zzapu.getContentType();
          long l3;
          if ((m == 200) && (paramzzjq.zzahv != 0L))
            l3 = paramzzjq.zzahv;
          while (true)
          {
            this.zzapw = l3;
            long l4;
            long l5;
            if ((0x1 & paramzzjq.flags) == 0)
            {
              l4 = zzc(this.zzapu);
              if (paramzzjq.zzcd != -1L)
              {
                l5 = paramzzjq.zzcd;
                label584: this.zzapx = l5;
              }
            }
            try
            {
              while (true)
              {
                this.zzapv = this.zzapu.getInputStream();
                this.zzapd = true;
                if (this.zzaoz != null)
                  this.zzaoz.zzgc();
                return this.zzapx;
                l3 = 0L;
                break;
                if (l4 != -1L)
                {
                  l5 = l4 - this.zzapw;
                  break label584;
                }
                l5 = -1L;
                break label584;
                this.zzapx = paramzzjq.zzcd;
              }
            }
            catch (IOException localIOException3)
            {
              closeConnection();
              throw new zzjx(localIOException3, paramzzjq);
            }
          }
          Object localObject = localURL;
          int i = j;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjs
 * JD-Core Version:    0.6.2
 */