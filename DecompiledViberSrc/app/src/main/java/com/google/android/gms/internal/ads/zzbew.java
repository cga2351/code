package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

@zzare
final class zzbew
  implements zzrv
{
  private static final Pattern zzapl = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> zzapm = new AtomicReference();
  private boolean zzapd;
  private final int zzapo;
  private final int zzapp;
  private final String zzapq;
  private HttpURLConnection zzapu;
  private InputStream zzapv;
  private long zzapw;
  private long zzapx;
  private long zzapy;
  private final zzsd zzbmm;
  private final zzsj<? super zzbew> zzbmn;
  private zzry zzbmo;
  private long zzce;
  private SSLSocketFactory zzegn = new zzbex(this);
  private int zzego;
  private Set<Socket> zzegp = new HashSet();

  zzbew(String paramString, zzsj<? super zzbew> paramzzsj, int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzapq = zzsk.checkNotEmpty(paramString);
    this.zzbmn = paramzzsj;
    this.zzbmm = new zzsd();
    this.zzapo = paramInt1;
    this.zzapp = paramInt2;
    this.zzego = paramInt3;
  }

  private final void zza(Socket paramSocket)
  {
    this.zzegp.add(paramSocket);
  }

  // ERROR //
  private static long zzc(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 112
    //   3: lstore_1
    //   4: aload_0
    //   5: ldc 115
    //   7: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +12 -> 27
    //   18: aload_3
    //   19: invokestatic 132	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   22: lstore 16
    //   24: lload 16
    //   26: lstore_1
    //   27: aload_0
    //   28: ldc 134
    //   30: invokevirtual 120	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +61 -> 101
    //   43: getstatic 53	com/google/android/gms/internal/ads/zzbew:zzapl	Ljava/util/regex/Pattern;
    //   46: aload 4
    //   48: invokevirtual 138	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 144	java/util/regex/Matcher:find	()Z
    //   58: ifeq +43 -> 101
    //   61: aload 5
    //   63: iconst_2
    //   64: invokevirtual 148	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   67: invokestatic 132	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   70: lstore 7
    //   72: aload 5
    //   74: iconst_1
    //   75: invokevirtual 148	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   78: invokestatic 132	java/lang/Long:parseLong	(Ljava/lang/String;)J
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
    //   95: ifge +50 -> 145
    //   98: lload 11
    //   100: lstore_1
    //   101: lload_1
    //   102: lreturn
    //   103: astore 15
    //   105: new 150	java/lang/StringBuilder
    //   108: dup
    //   109: bipush 28
    //   111: aload_3
    //   112: invokestatic 156	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 160	java/lang/String:length	()I
    //   118: iadd
    //   119: invokespecial 163	java/lang/StringBuilder:<init>	(I)V
    //   122: ldc 165
    //   124: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 171
    //   133: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 181	com/google/android/gms/internal/ads/zzaxa:zzen	(Ljava/lang/String;)V
    //   142: goto -115 -> 27
    //   145: lload_1
    //   146: lload 11
    //   148: lcmp
    //   149: ifeq -48 -> 101
    //   152: new 150	java/lang/StringBuilder
    //   155: dup
    //   156: bipush 26
    //   158: aload_3
    //   159: invokestatic 156	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 160	java/lang/String:length	()I
    //   165: iadd
    //   166: aload 4
    //   168: invokestatic 156	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   171: invokevirtual 160	java/lang/String:length	()I
    //   174: iadd
    //   175: invokespecial 163	java/lang/StringBuilder:<init>	(I)V
    //   178: ldc 183
    //   180: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_3
    //   184: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 185
    //   189: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 4
    //   194: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 171
    //   199: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 188	com/google/android/gms/internal/ads/zzaxa:zzep	(Ljava/lang/String;)V
    //   208: lload_1
    //   209: lload 11
    //   211: invokestatic 194	java/lang/Math:max	(JJ)J
    //   214: lstore 13
    //   216: lload 13
    //   218: lreturn
    //   219: astore 6
    //   221: new 150	java/lang/StringBuilder
    //   224: dup
    //   225: bipush 27
    //   227: aload 4
    //   229: invokestatic 156	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   232: invokevirtual 160	java/lang/String:length	()I
    //   235: iadd
    //   236: invokespecial 163	java/lang/StringBuilder:<init>	(I)V
    //   239: ldc 196
    //   241: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 4
    //   246: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 171
    //   251: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 181	com/google/android/gms/internal/ads/zzaxa:zzen	(Ljava/lang/String;)V
    //   260: lload_1
    //   261: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	103	java/lang/NumberFormatException
    //   61	83	219	java/lang/NumberFormatException
    //   152	216	219	java/lang/NumberFormatException
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
        zzaxa.zzc("Unexpected error while disconnecting", localException);
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
          break label132;
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
              break label161;
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
              label132: long l1 = this.zzapx;
              long l2 = this.zzce;
              l3 = l1 - l2;
              break;
              if (l3 > 2048L)
              {
                label161: String str = localInputStream.getClass().getName();
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
      this.zzegp.clear();
    }
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

  final void setReceiveBufferSize(int paramInt)
  {
    this.zzego = paramInt;
    Iterator localIterator = this.zzegp.iterator();
    while (localIterator.hasNext())
    {
      Socket localSocket = (Socket)localIterator.next();
      if (!localSocket.isClosed())
        try
        {
          localSocket.setReceiveBufferSize(this.zzego);
        }
        catch (SocketException localSocketException)
        {
          zzaxa.zzd("Failed to update receive buffer size.", localSocketException);
        }
    }
  }

  public final long zza(zzry paramzzry)
    throws zzsb
  {
    this.zzbmo = paramzzry;
    this.zzce = 0L;
    this.zzapy = 0L;
    try
    {
      URL localURL1 = new URL(paramzzry.uri.toString());
      byte[] arrayOfByte1 = paramzzry.zzbmd;
      l1 = paramzzry.zzahv;
      l2 = paramzzry.zzcd;
      bool1 = paramzzry.zzbk(1);
      i = 0;
      arrayOfByte2 = arrayOfByte1;
      localObject = localURL1;
      j = i + 1;
      if (i <= 20)
      {
        localHttpURLConnection = (HttpURLConnection)((URL)localObject).openConnection();
        if ((localHttpURLConnection instanceof HttpsURLConnection))
          ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.zzegn);
        localHttpURLConnection.setConnectTimeout(this.zzapo);
        localHttpURLConnection.setReadTimeout(this.zzapp);
        Iterator localIterator = this.zzbmm.zzjw().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
      {
        long l1;
        long l2;
        boolean bool1;
        int j;
        HttpURLConnection localHttpURLConnection;
        String str1 = String.valueOf(paramzzry.uri.toString());
        String str2;
        if (str1.length() != 0)
        {
          str2 = "Unable to connect to ".concat(str1);
          throw new zzsb(str2, localIOException1, paramzzry, 1);
          if ((l1 != 0L) || (l2 != -1L))
          {
            String str3 = 27 + "bytes=" + l1 + "-";
            if (l2 != -1L)
            {
              String str4 = String.valueOf(str3);
              long l3 = l1 + l2 - 1L;
              str3 = 20 + String.valueOf(str4).length() + str4 + l3;
            }
            localHttpURLConnection.setRequestProperty("Range", str3);
          }
          localHttpURLConnection.setRequestProperty("User-Agent", this.zzapq);
          if (!bool1)
            localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
          localHttpURLConnection.setInstanceFollowRedirects(false);
          if (arrayOfByte2 == null)
            break label1013;
        }
        URL localURL2;
        label676: label1013: for (boolean bool2 = true; ; bool2 = false)
          while (true)
          {
            localHttpURLConnection.setDoOutput(bool2);
            if (arrayOfByte2 != null)
            {
              localHttpURLConnection.setRequestMethod("POST");
              if (arrayOfByte2.length != 0)
              {
                localHttpURLConnection.setFixedLengthStreamingMode(arrayOfByte2.length);
                localHttpURLConnection.connect();
                OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
                localOutputStream.write(arrayOfByte2);
                localOutputStream.close();
              }
            }
            String str5;
            while (true)
            {
              int k = localHttpURLConnection.getResponseCode();
              if ((k != 300) && (k != 301) && (k != 302) && (k != 303) && ((arrayOfByte2 != null) || ((k != 307) && (k != 308))))
                break label676;
              str5 = localHttpURLConnection.getHeaderField("Location");
              localHttpURLConnection.disconnect();
              if (str5 != null)
                break;
              throw new ProtocolException("Null location redirect");
              localHttpURLConnection.connect();
            }
            localURL2 = new URL((URL)localObject, str5);
            String str6 = localURL2.getProtocol();
            if (("https".equals(str6)) || ("http".equals(str6)))
              break label1019;
            String str7 = String.valueOf(str6);
            if (str7.length() != 0);
            for (String str8 = "Unsupported protocol redirect: ".concat(str7); ; str8 = new String("Unsupported protocol redirect: "))
              throw new ProtocolException(str8);
            throw new NoRouteToHostException(31 + "Too many redirects: " + j);
            this.zzapu = localHttpURLConnection;
            try
            {
              m = this.zzapu.getResponseCode();
              if ((m < 200) || (m > 299))
              {
                Map localMap = this.zzapu.getHeaderFields();
                zzjv();
                zzsc localzzsc = new zzsc(m, localMap, paramzzry);
                if (m == 416)
                  localzzsc.initCause(new zzrx(0));
                throw localzzsc;
                str2 = new String("Unable to connect to ");
              }
            }
            catch (IOException localIOException2)
            {
              int m;
              zzjv();
              String str9 = String.valueOf(paramzzry.uri.toString());
              if (str9.length() != 0);
              for (String str10 = "Unable to connect to ".concat(str9); ; str10 = new String("Unable to connect to "))
                throw new zzsb(str10, localIOException2, paramzzry, 1);
              long l4;
              if ((m == 200) && (paramzzry.zzahv != 0L))
                l4 = paramzzry.zzahv;
              while (true)
              {
                this.zzapw = l4;
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
                    l4 = 0L;
                    break;
                    long l5 = zzc(this.zzapu);
                    if (l5 != -1L);
                    for (long l6 = l5 - this.zzapw; ; l6 = -1L)
                    {
                      this.zzapx = l6;
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
            }
          }
        label1019: Object localObject = localURL2;
        int i = j;
        byte[] arrayOfByte2 = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbew
 * JD-Core Version:    0.6.2
 */