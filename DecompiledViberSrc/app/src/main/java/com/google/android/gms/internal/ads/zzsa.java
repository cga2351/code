package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzsa
  implements zzrv
{
  private static final Pattern zzapl = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> zzapm = new AtomicReference();
  private boolean zzapd;
  private final boolean zzapn;
  private final int zzapo;
  private final int zzapp;
  private final String zzapq;
  private HttpURLConnection zzapu;
  private InputStream zzapv;
  private long zzapw;
  private long zzapx;
  private long zzapy;
  private final zzsv<String> zzbmk;
  private final zzsd zzbml;
  private final zzsd zzbmm;
  private final zzsj<? super zzsa> zzbmn;
  private zzry zzbmo;
  private long zzce;

  public zzsa(String paramString, zzsv<String> paramzzsv, zzsj<? super zzsa> paramzzsj, int paramInt1, int paramInt2, boolean paramBoolean, zzsd paramzzsd)
  {
    this.zzapq = zzsk.checkNotEmpty(paramString);
    this.zzbmk = null;
    this.zzbmn = paramzzsj;
    this.zzbmm = new zzsd();
    this.zzapo = paramInt1;
    this.zzapp = paramInt2;
    this.zzapn = true;
    this.zzbml = null;
  }

  private final HttpURLConnection zza(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.zzapo);
    localHttpURLConnection.setReadTimeout(this.zzapp);
    Iterator localIterator = this.zzbmm.zzjw().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
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
    if (!paramBoolean1)
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null);
    for (boolean bool = true; ; bool = false)
    {
      localHttpURLConnection.setDoOutput(bool);
      if (paramArrayOfByte == null)
        break;
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0)
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

  // ERROR //
  private static long zzc(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 145
    //   3: lstore_1
    //   4: aload_0
    //   5: ldc 219
    //   7: invokevirtual 222	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +12 -> 27
    //   18: aload_3
    //   19: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   22: lstore 19
    //   24: lload 19
    //   26: lstore_1
    //   27: aload_0
    //   28: ldc 236
    //   30: invokevirtual 222	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +61 -> 101
    //   43: getstatic 51	com/google/android/gms/internal/ads/zzsa:zzapl	Ljava/util/regex/Pattern;
    //   46: aload 4
    //   48: invokevirtual 240	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 245	java/util/regex/Matcher:find	()Z
    //   58: ifeq +43 -> 101
    //   61: aload 5
    //   63: iconst_2
    //   64: invokevirtual 249	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   67: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore 8
    //   72: aload 5
    //   74: iconst_1
    //   75: invokevirtual 249	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   78: invokestatic 234	java/lang/Long:parseLong	(Ljava/lang/String;)J
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
    //   105: ldc 251
    //   107: new 148	java/lang/StringBuilder
    //   110: dup
    //   111: bipush 28
    //   113: aload_3
    //   114: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 173	java/lang/String:length	()I
    //   120: iadd
    //   121: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   124: ldc 253
    //   126: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 255
    //   135: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 261	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   144: pop
    //   145: goto -118 -> 27
    //   148: lload_1
    //   149: lload 12
    //   151: lcmp
    //   152: ifeq -51 -> 101
    //   155: ldc 251
    //   157: new 148	java/lang/StringBuilder
    //   160: dup
    //   161: bipush 26
    //   163: aload_3
    //   164: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 173	java/lang/String:length	()I
    //   170: iadd
    //   171: aload 4
    //   173: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 173	java/lang/String:length	()I
    //   179: iadd
    //   180: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   183: ldc_w 263
    //   186: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_3
    //   190: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 265
    //   196: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 4
    //   201: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 255
    //   206: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 268	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   215: pop
    //   216: lload_1
    //   217: lload 12
    //   219: invokestatic 274	java/lang/Math:max	(JJ)J
    //   222: lstore 15
    //   224: lload 15
    //   226: lreturn
    //   227: astore 6
    //   229: ldc 251
    //   231: new 148	java/lang/StringBuilder
    //   234: dup
    //   235: bipush 27
    //   237: aload 4
    //   239: invokestatic 169	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   242: invokevirtual 173	java/lang/String:length	()I
    //   245: iadd
    //   246: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   249: ldc_w 276
    //   252: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 4
    //   257: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 255
    //   262: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 261	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   271: pop
    //   272: lload_1
    //   273: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	103	java/lang/NumberFormatException
    //   61	83	227	java/lang/NumberFormatException
    //   155	224	227	java/lang/NumberFormatException
  }

  private final void zzjv()
  {
    if (this.zzapu != null);
    try
    {
      this.zzapu.disconnect();
      this.zzapu = null;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", localException);
    }
  }

  public final void close()
    throws zzsb
  {
    try
    {
      HttpURLConnection localHttpURLConnection;
      long l3;
      if (this.zzapv != null)
      {
        localHttpURLConnection = this.zzapu;
        if (this.zzapx != -1L)
          break label123;
        l3 = this.zzapx;
      }
      while (true)
      {
        if (zzsy.SDK_INT != 19)
        {
          int j = zzsy.SDK_INT;
          if (j != 20)
            break label77;
        }
        try
        {
          localInputStream = localHttpURLConnection.getInputStream();
          if (l3 == -1L)
          {
            int i = localInputStream.read();
            if (i != -1)
              break label152;
          }
        }
        catch (Exception localException)
        {
          try
          {
            while (true)
            {
              InputStream localInputStream;
              label77: this.zzapv.close();
              return;
              label123: long l1 = this.zzapx;
              long l2 = this.zzce;
              l3 = l1 - l2;
              break;
              if (l3 > 2048L)
              {
                label152: String str = localInputStream.getClass().getName();
                if ((str.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (str.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
                {
                  Method localMethod = localInputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                  localMethod.setAccessible(true);
                  localMethod.invoke(localInputStream, new Object[0]);
                  continue;
                  localException = localException;
                }
              }
            }
          }
          catch (IOException localIOException)
          {
            throw new zzsb(localIOException, this.zzbmo, 3);
          }
        }
      }
    }
    finally
    {
      this.zzapv = null;
      zzjv();
      if (this.zzapd)
      {
        this.zzapd = false;
        if (this.zzbmn != null)
          this.zzbmn.zze(this);
      }
    }
  }

  public final Map<String, List<String>> getResponseHeaders()
  {
    if (this.zzapu == null)
      return null;
    return this.zzapu.getHeaderFields();
  }

  public final Uri getUri()
  {
    if (this.zzapu == null)
      return null;
    return Uri.parse(this.zzapu.getURL().toString());
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzsb
  {
    byte[] arrayOfByte;
    while (true)
    {
      int k;
      try
      {
        if (this.zzapy == this.zzapw)
          break label282;
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
        throw new zzsb(localIOException, this.zzbmo, 2);
      }
      if (k == -1)
        throw new EOFException();
      this.zzapy += k;
      if (this.zzbmn != null)
        this.zzbmn.zzc(this, k);
    }
    zzapm.set(arrayOfByte);
    label282: 
    while (paramInt2 != 0)
    {
      if (this.zzapx != -1L)
      {
        long l = this.zzapx - this.zzce;
        if (l == 0L)
          return -1;
        paramInt2 = (int)Math.min(paramInt2, l);
      }
      i = this.zzapv.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i == -1)
      {
        if (this.zzapx == -1L)
          break label292;
        throw new EOFException();
      }
      this.zzce += i;
      if (this.zzbmn == null)
        break;
      this.zzbmn.zzc(this, i);
      return i;
    }
    int i = 0;
    return i;
    label292: return -1;
  }

  public final long zza(zzry paramzzry)
    throws zzsb
  {
    this.zzbmo = paramzzry;
    this.zzce = 0L;
    this.zzapy = 0L;
    try
    {
      localObject = new URL(paramzzry.uri.toString());
      arrayOfByte = paramzzry.zzbmd;
      l1 = paramzzry.zzahv;
      l2 = paramzzry.zzcd;
      bool = paramzzry.zzbk(1);
      if (!this.zzapn)
      {
        localHttpURLConnection = zza((URL)localObject, arrayOfByte, l1, l2, bool, true);
        this.zzapu = localHttpURLConnection;
      }
    }
    catch (IOException localIOException1)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        int k;
        do
        {
          long l1;
          long l2;
          boolean bool;
          m = this.zzapu.getResponseCode();
          if ((m >= 200) && (m <= 299))
            break label530;
          Map localMap = this.zzapu.getHeaderFields();
          zzjv();
          zzsc localzzsc = new zzsc(m, localMap, paramzzry);
          if (m == 416)
            localzzsc.initCause(new zzrx(0));
          throw localzzsc;
          i = 0;
          j = i + 1;
          if (i > 20)
            break;
          localHttpURLConnection = zza((URL)localObject, arrayOfByte, l1, l2, bool, false);
          k = localHttpURLConnection.getResponseCode();
        }
        while ((k != 300) && (k != 301) && (k != 302) && (k != 303) && ((arrayOfByte != null) || ((k != 307) && (k != 308))));
        String str3 = localHttpURLConnection.getHeaderField("Location");
        localHttpURLConnection.disconnect();
        String str1;
        if (str3 == null)
        {
          throw new ProtocolException("Null location redirect");
          localIOException1 = localIOException1;
          str1 = String.valueOf(paramzzry.uri.toString());
          if (str1.length() == 0)
            break label450;
        }
        label450: for (String str2 = "Unable to connect to ".concat(str1); ; str2 = new String("Unable to connect to "))
        {
          throw new zzsb(str2, localIOException1, paramzzry, 1);
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
          zzjv();
          String str7 = String.valueOf(paramzzry.uri.toString());
          if (str7.length() != 0);
          for (String str8 = "Unable to connect to ".concat(str7); ; str8 = new String("Unable to connect to "))
            throw new zzsb(str8, localIOException2, paramzzry, 1);
          label530: this.zzapu.getContentType();
          long l3;
          if ((m == 200) && (paramzzry.zzahv != 0L))
            l3 = paramzzry.zzahv;
          while (true)
          {
            this.zzapw = l3;
            if (!paramzzry.zzbk(1))
              if (paramzzry.zzcd != -1L)
                this.zzapx = paramzzry.zzcd;
            try
            {
              while (true)
              {
                this.zzapv = this.zzapu.getInputStream();
                this.zzapd = true;
                if (this.zzbmn != null)
                  this.zzbmn.zza(this, paramzzry);
                return this.zzapx;
                l3 = 0L;
                break;
                long l4 = zzc(this.zzapu);
                if (l4 != -1L);
                for (long l5 = l4 - this.zzapw; ; l5 = -1L)
                {
                  this.zzapx = l5;
                  break;
                }
                this.zzapx = paramzzry.zzcd;
              }
            }
            catch (IOException localIOException3)
            {
              zzjv();
              throw new zzsb(localIOException3, paramzzry, 1);
            }
          }
          Object localObject = localURL;
          int i = j;
          byte[] arrayOfByte = null;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsa
 * JD-Core Version:    0.6.2
 */