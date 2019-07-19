package com.viber.voip.util.upload;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.f;
import com.viber.voip.b.c.a.o;
import com.viber.voip.util.at;
import com.viber.voip.util.bg;
import com.viber.voip.util.bg.b;
import com.viber.voip.util.bj;
import com.viber.voip.util.de;
import com.viber.voip.util.dl;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.http.OkHttpClientFactory.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
{
  protected static boolean b = true;
  public static int c = 0;
  private static final AtomicInteger p = new AtomicInteger(0);
  private d A;
  protected Logger a = ViberEnv.getLogger();
  protected String d;
  protected String e;
  protected String f;
  protected int g;
  protected int h = 0;
  protected volatile boolean i;
  protected int j = p.incrementAndGet();
  protected InputStream k;
  protected boolean l = false;
  protected File m;
  public boolean n;
  protected e o;
  private String q;
  private int r;
  private int s = 1;
  private String t;
  private boolean u;
  private m v;
  private c w;
  private int x;
  private int y;
  private long z = 600000L;

  public b(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, -1);
  }

  public b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.d = dl.n(paramString1);
    this.f = paramString2;
    this.e = paramString3;
    if (paramInt >= 0);
    while (true)
    {
      this.y = paramInt;
      return;
      paramInt = 2147483647;
    }
  }

  public b(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this(paramString1, paramString2, paramString3, -1);
    this.z = paramLong;
  }

  private void a(long paramLong)
  {
    de.a(c(), paramLong);
    if (this.w != null)
      this.w.a(paramLong);
  }

  // ERROR //
  private void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException, b.a
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   4: ifeq +14 -> 18
    //   7: new 122	com/viber/voip/util/upload/b$a
    //   10: dup
    //   11: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   14: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   17: athrow
    //   18: ldc 136
    //   20: invokestatic 140	com/viber/voip/util/upload/o:e	()Ljava/lang/String;
    //   23: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +13 -> 39
    //   29: new 120	java/io/IOException
    //   32: dup
    //   33: ldc 148
    //   35: invokespecial 151	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   38: athrow
    //   39: aload_1
    //   40: ifnonnull +13 -> 53
    //   43: new 120	java/io/IOException
    //   46: dup
    //   47: ldc 153
    //   49: invokespecial 151	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: iconst_0
    //   54: istore 4
    //   56: aload_0
    //   57: getfield 155	com/viber/voip/util/upload/b:g	I
    //   60: ifle +185 -> 245
    //   63: aload_0
    //   64: getfield 155	com/viber/voip/util/upload/b:g	I
    //   67: aload_0
    //   68: getfield 67	com/viber/voip/util/upload/b:h	I
    //   71: isub
    //   72: istore 5
    //   74: aload_0
    //   75: getfield 157	com/viber/voip/util/upload/b:m	Ljava/io/File;
    //   78: invokestatic 163	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   81: astore 6
    //   83: ldc 164
    //   85: invokestatic 169	com/viber/voip/b/b/a:a	(I)[B
    //   88: astore 7
    //   90: iconst_0
    //   91: istore 8
    //   93: iload 5
    //   95: istore 9
    //   97: iconst_0
    //   98: istore 10
    //   100: iload 4
    //   102: iconst_m1
    //   103: if_icmpeq +552 -> 655
    //   106: iload 9
    //   108: ifle +547 -> 655
    //   111: iconst_0
    //   112: istore 14
    //   114: ldc 164
    //   116: istore 15
    //   118: iload 8
    //   120: istore 16
    //   122: iload 9
    //   124: istore 17
    //   126: iload 4
    //   128: istore 18
    //   130: iload 10
    //   132: istore 19
    //   134: iload 16
    //   136: istore 20
    //   138: iload 15
    //   140: ifeq +522 -> 662
    //   143: iload 17
    //   145: ifle +517 -> 662
    //   148: sipush 2048
    //   151: istore 22
    //   153: iload 22
    //   155: iload 15
    //   157: if_icmple +7 -> 164
    //   160: iload 15
    //   162: istore 22
    //   164: iload 22
    //   166: iload 17
    //   168: if_icmple +7 -> 175
    //   171: iload 17
    //   173: istore 22
    //   175: aload_0
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   181: ifeq +71 -> 252
    //   184: new 122	com/viber/voip/util/upload/b$a
    //   187: dup
    //   188: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   191: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   194: athrow
    //   195: astore 24
    //   197: aload_0
    //   198: monitorexit
    //   199: aload 24
    //   201: athrow
    //   202: astore 23
    //   204: iload 14
    //   206: ifle +26 -> 232
    //   209: aload_2
    //   210: aload 7
    //   212: iconst_0
    //   213: iload 14
    //   215: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   218: aload_0
    //   219: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   222: ifnull +10 -> 232
    //   225: aload_0
    //   226: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   229: invokevirtual 181	com/viber/voip/util/upload/e:a	()V
    //   232: aload 23
    //   234: athrow
    //   235: astore 13
    //   237: aload 7
    //   239: invokestatic 184	com/viber/voip/b/b/a:a	([B)V
    //   242: aload 13
    //   244: athrow
    //   245: ldc 101
    //   247: istore 5
    //   249: goto -175 -> 74
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_1
    //   255: aload 7
    //   257: iload 14
    //   259: iload 22
    //   261: invokevirtual 190	java/io/InputStream:read	([BII)I
    //   264: istore 25
    //   266: iload 25
    //   268: istore 18
    //   270: iload 18
    //   272: ifgt +133 -> 405
    //   275: iload 20
    //   277: istore 33
    //   279: iload 19
    //   281: istore 10
    //   283: iload 18
    //   285: istore 4
    //   287: iload 17
    //   289: istore 9
    //   291: iload 33
    //   293: istore 8
    //   295: iload 14
    //   297: ifle +26 -> 323
    //   300: aload_2
    //   301: aload 7
    //   303: iconst_0
    //   304: iload 14
    //   306: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   309: aload_0
    //   310: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   313: ifnull +10 -> 323
    //   316: aload_0
    //   317: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   320: invokevirtual 181	com/viber/voip/util/upload/e:a	()V
    //   323: aload_0
    //   324: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   327: ifne +328 -> 655
    //   330: iload 10
    //   332: iload_3
    //   333: if_icmplt -233 -> 100
    //   336: iload 10
    //   338: istore 11
    //   340: aload_2
    //   341: invokevirtual 193	java/io/OutputStream:flush	()V
    //   344: aload_2
    //   345: invokevirtual 196	java/io/OutputStream:close	()V
    //   348: aload_1
    //   349: invokevirtual 197	java/io/InputStream:close	()V
    //   352: aload 7
    //   354: invokestatic 184	com/viber/voip/b/b/a:a	([B)V
    //   357: aload_0
    //   358: aload_0
    //   359: getfield 155	com/viber/voip/util/upload/b:g	I
    //   362: invokevirtual 200	com/viber/voip/util/upload/b:a	(I)Z
    //   365: ifeq +238 -> 603
    //   368: aload_0
    //   369: getfield 67	com/viber/voip/util/upload/b:h	I
    //   372: aload_0
    //   373: getfield 155	com/viber/voip/util/upload/b:g	I
    //   376: if_icmpne +221 -> 597
    //   379: iconst_1
    //   380: istore 12
    //   382: iload 12
    //   384: ifne +270 -> 654
    //   387: aload_0
    //   388: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   391: ifeq +231 -> 622
    //   394: new 122	com/viber/voip/util/upload/b$a
    //   397: dup
    //   398: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   401: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   404: athrow
    //   405: getstatic 57	com/viber/voip/util/upload/b:c	I
    //   408: istore 26
    //   410: iload 26
    //   412: ifle +10 -> 422
    //   415: getstatic 57	com/viber/voip/util/upload/b:c	I
    //   418: i2l
    //   419: invokestatic 205	java/lang/Thread:sleep	(J)V
    //   422: aload_0
    //   423: getfield 207	com/viber/voip/util/upload/b:n	Z
    //   426: ifeq +53 -> 479
    //   429: aload_0
    //   430: getfield 67	com/viber/voip/util/upload/b:h	I
    //   433: ldc 208
    //   435: if_icmple +44 -> 479
    //   438: iconst_0
    //   439: istore 31
    //   441: iload 31
    //   443: aload 7
    //   445: arraylength
    //   446: if_icmpge +33 -> 479
    //   449: aload 7
    //   451: iload 31
    //   453: iload 31
    //   455: sipush 255
    //   458: iand
    //   459: i2b
    //   460: bastore
    //   461: iinc 31 1
    //   464: goto -23 -> 441
    //   467: astore 32
    //   469: new 122	com/viber/voip/util/upload/b$a
    //   472: dup
    //   473: aload 32
    //   475: invokespecial 211	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   478: athrow
    //   479: iload 14
    //   481: iload 18
    //   483: iadd
    //   484: istore 14
    //   486: iload 15
    //   488: iload 18
    //   490: isub
    //   491: istore 15
    //   493: iload 17
    //   495: iload 18
    //   497: isub
    //   498: istore 17
    //   500: aload_0
    //   501: iload 18
    //   503: aload_0
    //   504: getfield 67	com/viber/voip/util/upload/b:h	I
    //   507: iadd
    //   508: putfield 67	com/viber/voip/util/upload/b:h	I
    //   511: iload 19
    //   513: iload 18
    //   515: iadd
    //   516: istore 19
    //   518: aload_0
    //   519: getfield 213	com/viber/voip/util/upload/b:v	Lcom/viber/voip/util/upload/m;
    //   522: ifnull +163 -> 685
    //   525: ldc2_w 214
    //   528: aload_0
    //   529: invokevirtual 218	com/viber/voip/util/upload/b:m	()D
    //   532: dmul
    //   533: d2i
    //   534: istore 30
    //   536: iload 30
    //   538: iload 20
    //   540: if_icmple +145 -> 685
    //   543: aload_0
    //   544: getfield 213	com/viber/voip/util/upload/b:v	Lcom/viber/voip/util/upload/m;
    //   547: aload 6
    //   549: iload 30
    //   551: invokeinterface 223 3 0
    //   556: iload 30
    //   558: istore 20
    //   560: goto +125 -> 685
    //   563: aload_0
    //   564: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   567: istore 27
    //   569: iload 27
    //   571: ifeq -433 -> 138
    //   574: iload 20
    //   576: istore 28
    //   578: iload 19
    //   580: istore 10
    //   582: iload 18
    //   584: istore 4
    //   586: iload 17
    //   588: istore 9
    //   590: iload 28
    //   592: istore 8
    //   594: goto -299 -> 295
    //   597: iconst_0
    //   598: istore 12
    //   600: goto -218 -> 382
    //   603: aload_0
    //   604: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   607: ifne +9 -> 616
    //   610: iconst_1
    //   611: istore 12
    //   613: goto -231 -> 382
    //   616: iconst_0
    //   617: istore 12
    //   619: goto -237 -> 382
    //   622: iload 11
    //   624: iload_3
    //   625: if_icmplt +16 -> 641
    //   628: new 122	com/viber/voip/util/upload/b$a
    //   631: dup
    //   632: getstatic 225	com/viber/voip/util/upload/b$b:f	Lcom/viber/voip/util/upload/b$b;
    //   635: ldc 227
    //   637: invokespecial 230	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;Ljava/lang/String;)V
    //   640: athrow
    //   641: new 122	com/viber/voip/util/upload/b$a
    //   644: dup
    //   645: getstatic 232	com/viber/voip/util/upload/b$b:e	Lcom/viber/voip/util/upload/b$b;
    //   648: ldc 234
    //   650: invokespecial 230	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;Ljava/lang/String;)V
    //   653: athrow
    //   654: return
    //   655: iload 10
    //   657: istore 11
    //   659: goto -319 -> 340
    //   662: iload 20
    //   664: istore 21
    //   666: iload 19
    //   668: istore 10
    //   670: iload 18
    //   672: istore 4
    //   674: iload 17
    //   676: istore 9
    //   678: iload 21
    //   680: istore 8
    //   682: goto -387 -> 295
    //   685: iload 19
    //   687: iload_3
    //   688: if_icmplt -125 -> 563
    //   691: iload 20
    //   693: istore 29
    //   695: iload 19
    //   697: istore 10
    //   699: iload 18
    //   701: istore 4
    //   703: iload 17
    //   705: istore 9
    //   707: iload 29
    //   709: istore 8
    //   711: goto -416 -> 295
    //
    // Exception table:
    //   from	to	target	type
    //   177	195	195	finally
    //   197	199	195	finally
    //   252	254	195	finally
    //   175	177	202	finally
    //   199	202	202	finally
    //   254	266	202	finally
    //   405	410	202	finally
    //   415	422	202	finally
    //   422	438	202	finally
    //   441	461	202	finally
    //   469	479	202	finally
    //   500	511	202	finally
    //   518	536	202	finally
    //   543	556	202	finally
    //   563	569	202	finally
    //   209	232	235	finally
    //   232	235	235	finally
    //   300	323	235	finally
    //   323	330	235	finally
    //   340	352	235	finally
    //   415	422	467	java/lang/InterruptedException
  }

  private void c(URL paramURL)
    throws b.a
  {
    if ((a(this.g)) && (this.y < this.g))
      throw new a(b.f, "Media size too large");
  }

  protected static ContentResolver l()
  {
    return ViberApplication.getApplication().getContentResolver();
  }

  private void o()
  {
    new o(ViberApplication.getApplication())
    {
      public void a()
      {
        super.a();
        this.b.a(5);
        this.b.b(20);
      }
    }
    .c();
  }

  private void p()
  {
    long l1 = at.a();
    if (l1 >= 1024L)
    {
      long l2 = l1 / 1024L;
      if (l2 >= 1024L)
        (l2 / 1024L);
    }
    try
    {
      if (this.m != null);
      for (String str = this.m.getParent(); ; str = null)
      {
        if (str != null)
        {
          boolean bool = new File(str).isDirectory();
          if (!bool);
        }
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  protected OutputStream a(Uri paramUri)
    throws FileNotFoundException
  {
    if (this.l)
      return l().openOutputStream(paramUri, "wa");
    return l().openOutputStream(paramUri);
  }

  protected String a()
    throws IOException
  {
    return this.d;
  }

  public void a(d paramd)
  {
    this.A = paramd;
  }

  public void a(c paramc)
  {
    this.w = paramc;
  }

  public void a(m paramm)
  {
    this.v = paramm;
  }

  protected void a(File paramFile)
    throws IOException
  {
    File localFile = new File(this.f);
    if ((!paramFile.renameTo(new File(this.f))) && (bj.a(paramFile, localFile)))
      at.f(paramFile);
  }

  public void a(String paramString)
  {
    this.a = ViberEnv.getLogger(this.a, paramString);
  }

  protected void a(URL paramURL)
    throws IOException, b.a
  {
    int i1 = 0;
    int i2;
    if (this.e != null)
    {
      this.m = new File(this.e);
      this.l = false;
      if ((b) && (this.m.exists()) && (this.m.length() > 0L))
      {
        i2 = (int)this.m.length();
        this.l = true;
      }
    }
    while (true)
    {
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder(OkHttpClientFactory.Type.DEFAULT).connectTimeout(this.z, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS);
      while (true)
      {
        Response localResponse;
        int i3;
        try
        {
          Request.Builder localBuilder1 = new Request.Builder().url(paramURL);
          if (this.l)
            localBuilder1.header("Range", "bytes=" + i2 + "-");
          a(localBuilder, localBuilder1);
          localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
          i3 = localResponse.code();
          this.t = localResponse.header("Content-Type");
          switch (i3)
          {
          default:
            try
            {
              Object[] arrayOfObject = new Object[2];
              arrayOfObject[0] = Integer.valueOf(i3);
              arrayOfObject[1] = paramURL;
              throw new IOException(String.format("Wrong server response: %d for URL = %s", arrayOfObject));
            }
            finally
            {
              if (i1 == 0)
                this.x = i3;
            }
          case 200:
          case 203:
          case 206:
          case 416:
          case 301:
          case 302:
          case 303:
          case 307:
          case 403:
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new MalformedURLException(localIllegalArgumentException.getMessage());
        }
        if (this.A != null)
          this.A.a(this.d, localResponse);
        a(localResponse, i2);
        for (this.k = localResponse.body().byteStream(); ; this.k = new InputStream()
        {
          public int read()
            throws IOException
          {
            return -1;
          }
        })
        {
          this.x = i3;
          a(this.g);
          return;
          this.g = i2;
          this.h = this.g;
        }
        try
        {
          this.r = (1 + this.r);
          throw new c(localResponse.header("location"));
        }
        finally
        {
        }
      }
      throw new a(b.f, "HTTP Status-Code 403: Forbidden");
      i2 = 0;
    }
  }

  protected void a(OkHttpClient.Builder paramBuilder, Request.Builder paramBuilder1)
  {
  }

  void a(Response paramResponse, int paramInt)
    throws IOException
  {
    if (this.l)
    {
      String str = paramResponse.header("Content-Range");
      if (str == null)
      {
        this.l = false;
        if (paramResponse.body().contentLength() != -1L)
        {
          this.g = ((int)paramResponse.body().contentLength());
          return;
        }
        this.g = 2147483647;
        return;
      }
      bg.b localb = bg.a(str);
      if ((localb == null) || (localb.a() != paramInt))
        throw new IOException("Invalid range header: " + str);
      this.g = localb.b();
      this.h = paramInt;
      return;
    }
    if (paramResponse.body().contentLength() != -1L)
    {
      this.g = ((int)paramResponse.body().contentLength());
      return;
    }
    this.g = 2147483647;
  }

  public boolean a(int paramInt)
  {
    return paramInt < 2147483647;
  }

  public String b()
  {
    return this.d;
  }

  protected void b(int paramInt)
    throws IOException, b.a
  {
    if ((this.m != null) && (!e()));
    try
    {
      OutputStream localOutputStream = a(Uri.fromFile(this.m));
      if (this.o != null)
        this.o.a(this.m.getAbsolutePath());
      a(this.k, localOutputStream, paramInt);
      this.k = null;
      a(this.m);
      this.u = true;
      return;
    }
    finally
    {
      if (!b)
        at.f(this.m);
    }
  }

  protected void b(URL paramURL)
    throws IOException, b.a
  {
    a(paramURL);
    c(paramURL);
    k();
  }

  public String c()
  {
    return this.q;
  }

  public String d()
  {
    return this.f;
  }

  public boolean e()
  {
    return this.i;
  }

  // ERROR //
  public void f()
    throws b.a
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: lconst_0
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 460	com/viber/voip/util/upload/b:r	I
    //   8: iconst_2
    //   9: if_icmpgt +352 -> 361
    //   12: aload_0
    //   13: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   16: istore 5
    //   18: iload 5
    //   20: ifne +341 -> 361
    //   23: aload_1
    //   24: ifnonnull +22 -> 46
    //   27: invokestatic 519	android/os/SystemClock:elapsedRealtime	()J
    //   30: lstore_2
    //   31: aload_0
    //   32: invokevirtual 521	com/viber/voip/util/upload/b:a	()Ljava/lang/String;
    //   35: astore 13
    //   37: aload_0
    //   38: aload 13
    //   40: putfield 94	com/viber/voip/util/upload/b:d	Ljava/lang/String;
    //   43: aload 13
    //   45: astore_1
    //   46: new 523	java/net/URL
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 524	java/net/URL:<init>	(Ljava/lang/String;)V
    //   54: astore 6
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 510	com/viber/voip/util/upload/b:q	Ljava/lang/String;
    //   61: invokestatic 519	android/os/SystemClock:elapsedRealtime	()J
    //   64: lstore_2
    //   65: aload_0
    //   66: aload 6
    //   68: invokevirtual 526	com/viber/voip/util/upload/b:b	(Ljava/net/URL;)V
    //   71: aload_0
    //   72: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   75: ifeq +66 -> 141
    //   78: new 122	com/viber/voip/util/upload/b$a
    //   81: dup
    //   82: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   85: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   88: athrow
    //   89: astore 12
    //   91: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   94: ldc_w 533
    //   97: aload 12
    //   99: invokevirtual 534	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   102: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   105: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   108: new 122	com/viber/voip/util/upload/b$a
    //   111: dup
    //   112: aload 12
    //   114: invokespecial 211	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   117: athrow
    //   118: astore 4
    //   120: aload_0
    //   121: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   124: ifnull +14 -> 138
    //   127: aload_0
    //   128: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   131: aload_0
    //   132: getfield 502	com/viber/voip/util/upload/b:u	Z
    //   135: invokevirtual 545	com/viber/voip/util/upload/e:a	(Z)V
    //   138: aload 4
    //   140: athrow
    //   141: aload_0
    //   142: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   145: ifnull +14 -> 159
    //   148: aload_0
    //   149: getfield 177	com/viber/voip/util/upload/b:o	Lcom/viber/voip/util/upload/e;
    //   152: aload_0
    //   153: getfield 502	com/viber/voip/util/upload/b:u	Z
    //   156: invokevirtual 545	com/viber/voip/util/upload/e:a	(Z)V
    //   159: return
    //   160: astore 11
    //   162: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   165: ldc_w 547
    //   168: aload 11
    //   170: invokevirtual 548	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   173: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   176: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   179: invokestatic 519	android/os/SystemClock:elapsedRealtime	()J
    //   182: lload_2
    //   183: lsub
    //   184: aload_0
    //   185: getfield 73	com/viber/voip/util/upload/b:z	J
    //   188: ldc2_w 345
    //   191: invokestatic 554	java/lang/Math:min	(JJ)J
    //   194: ldc2_w 555
    //   197: lsub
    //   198: lcmp
    //   199: ifle +16 -> 215
    //   202: new 122	com/viber/voip/util/upload/b$a
    //   205: dup
    //   206: getstatic 558	com/viber/voip/util/upload/b$b:d	Lcom/viber/voip/util/upload/b$b;
    //   209: aload 11
    //   211: invokespecial 561	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;Ljava/lang/Throwable;)V
    //   214: athrow
    //   215: new 122	com/viber/voip/util/upload/b$a
    //   218: dup
    //   219: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   222: aload 11
    //   224: invokespecial 561	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;Ljava/lang/Throwable;)V
    //   227: athrow
    //   228: astore 10
    //   230: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   233: ldc_w 563
    //   236: aload 10
    //   238: invokevirtual 564	java/io/InterruptedIOException:getMessage	()Ljava/lang/String;
    //   241: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   244: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   247: new 122	com/viber/voip/util/upload/b$a
    //   250: dup
    //   251: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   254: aload 10
    //   256: invokespecial 561	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;Ljava/lang/Throwable;)V
    //   259: athrow
    //   260: astore 9
    //   262: aload 9
    //   264: instanceof 276
    //   267: ifeq +11 -> 278
    //   270: aload_0
    //   271: invokespecial 566	com/viber/voip/util/upload/b:o	()V
    //   274: aload_0
    //   275: invokespecial 568	com/viber/voip/util/upload/b:p	()V
    //   278: aload_0
    //   279: iconst_1
    //   280: aload_0
    //   281: getfield 65	com/viber/voip/util/upload/b:s	I
    //   284: iadd
    //   285: putfield 65	com/viber/voip/util/upload/b:s	I
    //   288: aload_0
    //   289: getfield 65	com/viber/voip/util/upload/b:s	I
    //   292: iconst_3
    //   293: if_icmple -289 -> 4
    //   296: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   299: ldc_w 570
    //   302: aload 9
    //   304: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   307: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   310: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   313: new 122	com/viber/voip/util/upload/b$a
    //   316: dup
    //   317: aload 9
    //   319: invokespecial 211	com/viber/voip/util/upload/b$a:<init>	(Ljava/lang/Throwable;)V
    //   322: athrow
    //   323: astore 8
    //   325: aload 8
    //   327: invokevirtual 573	com/viber/voip/util/upload/b$c:b	()Ljava/lang/String;
    //   330: astore_1
    //   331: aload_0
    //   332: iconst_1
    //   333: putfield 65	com/viber/voip/util/upload/b:s	I
    //   336: goto -332 -> 4
    //   339: astore 7
    //   341: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   344: ldc_w 575
    //   347: aload 7
    //   349: invokevirtual 576	com/viber/voip/util/upload/b$a:getMessage	()Ljava/lang/String;
    //   352: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   355: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   358: aload 7
    //   360: athrow
    //   361: aload_0
    //   362: getfield 126	com/viber/voip/util/upload/b:i	Z
    //   365: ifeq +14 -> 379
    //   368: new 122	com/viber/voip/util/upload/b$a
    //   371: dup
    //   372: getstatic 131	com/viber/voip/util/upload/b$b:c	Lcom/viber/voip/util/upload/b$b;
    //   375: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   378: athrow
    //   379: invokestatic 531	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   382: ldc_w 575
    //   385: ldc_w 578
    //   388: invokestatic 539	com/viber/voip/analytics/story/l/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/analytics/story/e;
    //   391: invokevirtual 542	com/viber/voip/analytics/g:a	(Lcom/viber/voip/analytics/story/e;)V
    //   394: new 122	com/viber/voip/util/upload/b$a
    //   397: dup
    //   398: getstatic 580	com/viber/voip/util/upload/b$b:b	Lcom/viber/voip/util/upload/b$b;
    //   401: invokespecial 134	com/viber/voip/util/upload/b$a:<init>	(Lcom/viber/voip/util/upload/b$b;)V
    //   404: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   27	43	89	java/net/MalformedURLException
    //   46	89	89	java/net/MalformedURLException
    //   4	18	118	finally
    //   27	43	118	finally
    //   46	89	118	finally
    //   91	118	118	finally
    //   162	215	118	finally
    //   215	228	118	finally
    //   230	260	118	finally
    //   262	278	118	finally
    //   278	323	118	finally
    //   325	336	118	finally
    //   341	361	118	finally
    //   361	379	118	finally
    //   379	405	118	finally
    //   27	43	160	java/net/SocketTimeoutException
    //   46	89	160	java/net/SocketTimeoutException
    //   27	43	228	java/io/InterruptedIOException
    //   46	89	228	java/io/InterruptedIOException
    //   27	43	260	java/io/IOException
    //   46	89	260	java/io/IOException
    //   27	43	323	com/viber/voip/util/upload/b$c
    //   46	89	323	com/viber/voip/util/upload/b$c
    //   27	43	339	com/viber/voip/util/upload/b$a
    //   46	89	339	com/viber/voip/util/upload/b$a
  }

  public void g()
  {
    this.i = true;
  }

  public String h()
  {
    return this.t;
  }

  public int i()
  {
    return this.x;
  }

  public boolean j()
  {
    return this.u;
  }

  protected void k()
    throws IOException, b.a
  {
    b(this.y);
  }

  protected double m()
  {
    return this.h / this.g;
  }

  public e n()
  {
    try
    {
      if (this.o == null)
        this.o = new e();
      e locale = this.o;
      return locale;
    }
    finally
    {
    }
  }

  public static class a extends Exception
  {
    private b.b a;
    private String b;

    public a(b.b paramb)
    {
      super();
      this.a = paramb;
    }

    public a(b.b paramb, String paramString)
    {
      super();
      this.a = paramb;
      this.b = paramString;
    }

    public a(b.b paramb, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.a = paramb;
    }

    public a(Throwable paramThrowable)
    {
      this(b.b.g, paramThrowable);
    }

    public a(Throwable paramThrowable, String paramString)
    {
      this(b.b.g, paramThrowable);
      this.b = paramString;
    }

    public b.b a()
    {
      return this.a;
    }
  }

  public static enum b
  {
    private boolean k;

    static
    {
      b[] arrayOfb = new b[10];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      arrayOfb[8] = i;
      arrayOfb[9] = j;
    }

    private b(boolean paramBoolean)
    {
      this.k = paramBoolean;
    }

    public boolean a()
    {
      return this.k;
    }
  }

  public static class c extends b.a
  {
    private String a;

    public c(String paramString)
    {
      super();
      this.a = paramString;
    }

    public String b()
    {
      return this.a;
    }
  }

  public static abstract interface d
  {
    public abstract void a(String paramString, Response paramResponse)
      throws b.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.b
 * JD-Core Version:    0.6.2
 */