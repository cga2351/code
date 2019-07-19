package com.viber.voip.stickers;

import android.graphics.Bitmap;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.b.a.a.a.b;
import com.viber.voip.b.c;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.e.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class f
{
  static int a = 0;
  private static final Logger d = ViberEnv.getLogger();
  private static boolean l = true;
  volatile long b = 0L;
  Handler c = av.a(av.e.a);
  private ThreadPoolExecutor e;
  private i f;
  private c<String, b> g;
  private int h;
  private y i;
  private y j;
  private q k;
  private Random m = new Random();
  private boolean n;

  f(i parami)
  {
    this.f = parami;
    this.k = parami.u();
    this.g = ViberApplication.getInstance().getCacheManager().a(com.viber.voip.b.a.d);
    this.i = new y(this, this.c, (com.viber.voip.b.a.a.a.d)ViberApplication.getInstance().getCacheManager().a(com.viber.voip.b.a.g));
    this.j = new y(this, this.c, (com.viber.voip.b.a.a.a.d)ViberApplication.getInstance().getCacheManager().a(com.viber.voip.b.a.e));
  }

  private Bitmap a(Sticker paramSticker, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    try
    {
      if ((!paramSticker.isSvg()) || ((!paramSticker.isOwned()) && (paramBoolean1)))
        return a(paramString1, paramString2, paramInt1, paramInt2);
      Bitmap localBitmap = b(paramSticker, paramString1, paramString2, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramw);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a(localOutOfMemoryError);
    }
    return null;
  }

  // ERROR //
  public static Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: iconst_0
    //   8: invokevirtual 142	java/lang/String:charAt	(I)C
    //   11: bipush 47
    //   13: if_icmpeq +111 -> 124
    //   16: new 144	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 6
    //   26: iload 4
    //   28: ifne +11 -> 39
    //   31: aload 6
    //   33: invokevirtual 150	java/io/File:exists	()Z
    //   36: ifeq +136 -> 172
    //   39: iload 4
    //   41: ifeq +89 -> 130
    //   44: invokestatic 154	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   47: invokevirtual 160	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   50: aload_0
    //   51: invokevirtual 166	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 15
    //   56: aload 15
    //   58: astore 7
    //   60: aload 7
    //   62: invokestatic 171	com/viber/voip/util/dq:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   65: astore 11
    //   67: aload 11
    //   69: ifnull +87 -> 156
    //   72: aload 11
    //   74: iload_2
    //   75: iload_3
    //   76: iconst_1
    //   77: invokestatic 177	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   80: astore 12
    //   82: aload 12
    //   84: ifnull +15 -> 99
    //   87: aload 12
    //   89: getstatic 183	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   92: bipush 100
    //   94: aload_1
    //   95: invokestatic 186	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   98: pop
    //   99: aload 11
    //   101: ifnull +15 -> 116
    //   104: aload 11
    //   106: aload 12
    //   108: if_acmpeq +8 -> 116
    //   111: aload 11
    //   113: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   116: aload 7
    //   118: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   121: aload 12
    //   123: areturn
    //   124: iconst_0
    //   125: istore 4
    //   127: goto -111 -> 16
    //   130: new 196	java/io/FileInputStream
    //   133: dup
    //   134: aload 6
    //   136: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 7
    //   141: goto -81 -> 60
    //   144: astore 14
    //   146: aconst_null
    //   147: astore 9
    //   149: aload 9
    //   151: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   154: aconst_null
    //   155: areturn
    //   156: aconst_null
    //   157: astore 12
    //   159: goto -77 -> 82
    //   162: astore 10
    //   164: aload 5
    //   166: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   169: aload 10
    //   171: athrow
    //   172: aconst_null
    //   173: areturn
    //   174: astore 10
    //   176: aload 7
    //   178: astore 5
    //   180: goto -16 -> 164
    //   183: astore 8
    //   185: aload 7
    //   187: astore 9
    //   189: goto -40 -> 149
    //
    // Exception table:
    //   from	to	target	type
    //   44	56	144	java/lang/Exception
    //   130	141	144	java/lang/Exception
    //   44	56	162	finally
    //   130	141	162	finally
    //   60	67	174	finally
    //   72	82	174	finally
    //   87	99	174	finally
    //   111	116	174	finally
    //   60	67	183	java/lang/Exception
    //   72	82	183	java/lang/Exception
    //   87	99	183	java/lang/Exception
    //   111	116	183	java/lang/Exception
  }

  private Object a(w paramw, c paramc)
  {
    a(paramw);
    this.b = System.currentTimeMillis();
    g().execute(paramc);
    return paramc;
  }

  public static void a(Sticker paramSticker, w paramw, boolean paramBoolean)
    throws i.c
  {
    if (paramw == w.c)
      a(paramSticker, false, true, w.c, paramBoolean);
  }

  public static void a(Sticker paramSticker, boolean paramBoolean)
    throws i.c
  {
    a(paramSticker, w.c, paramBoolean);
  }

  private static void a(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, w paramw, boolean paramBoolean3)
    throws i.c
  {
    String str = paramSticker.getScaledPath(paramBoolean1, paramw);
    if (str != null)
    {
      File localFile = new File(str);
      if (paramBoolean3)
        at.f(localFile);
      if ((paramBoolean3) || (!localFile.exists()))
      {
        if (!i.w())
          break label71;
        j.c(i.a().e().c(paramSticker, paramBoolean1, paramBoolean2, paramw));
      }
    }
    return;
    label71: throw new i.c();
  }

  private static void a(w paramw)
  {
    if (paramw == w.c)
      throw new IllegalArgumentException("Thumb requested");
  }

  private void a(OutOfMemoryError paramOutOfMemoryError)
  {
    d.a(paramOutOfMemoryError, "prepareBitmap, exception");
    ViberApplication.getInstance().onOutOfMemory();
  }

  private Bitmap b(Sticker paramSticker, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    if (w.c != paramw)
      return null;
    x localx = this.f.f();
    AndroidSvgObject localAndroidSvgObject = localx.b(paramString1);
    if (localAndroidSvgObject == null)
    {
      this.k.a(paramSticker, paramBoolean1, paramBoolean2, paramw, new FileNotFoundException());
      return null;
    }
    try
    {
      Bitmap localBitmap = localx.a(localAndroidSvgObject, paramString1, paramString2, paramInt1, paramInt2, paramBoolean2, paramw);
      return localBitmap;
    }
    finally
    {
      localAndroidSvgObject.destroy();
    }
  }

  private ThreadPoolExecutor g()
  {
    if (this.e == null)
    {
      PriorityBlockingQueue localPriorityBlockingQueue = new PriorityBlockingQueue(100, new d(null));
      this.e = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, localPriorityBlockingQueue);
    }
    return this.e;
  }

  public Bitmap a(Sticker paramSticker)
  {
    if (paramSticker.packageId == this.h)
      return this.i.a(paramSticker);
    return this.j.a(paramSticker);
  }

  public b a(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    String str = paramSticker.getScaledPathKey(paramBoolean1, paramBoolean2, paramw);
    b localb1 = (b)this.g.get(str);
    if (localb1 != null)
      return localb1;
    Bitmap localBitmap1 = c(paramSticker, paramBoolean1, paramBoolean2, paramw);
    int i1;
    int i2;
    label78: Bitmap localBitmap2;
    if (localBitmap1 != null)
      if (paramw == w.a)
        if (paramBoolean2)
        {
          i1 = paramSticker.getMenuPortWidth();
          if (!paramBoolean2)
            break label134;
          i2 = paramSticker.getMenuPortHeight();
          localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, i1, i2, true);
        }
    while (true)
    {
      b localb2 = new b(localBitmap2, str);
      a(paramw);
      this.g.put(str, localb2);
      return localb2;
      i1 = paramSticker.getMenuLandWidth();
      break;
      label134: i2 = paramSticker.getMenuLandHeight();
      break label78;
      if (paramw == w.b)
      {
        localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, paramSticker.getConversationWidth(), paramSticker.getConversationHeight(), true);
        continue;
        return null;
      }
      else
      {
        localBitmap2 = localBitmap1;
      }
    }
  }

  public Object a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, w paramw, e parame)
  {
    return a(paramw, new c(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramw, parame));
  }

  public Object a(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, w paramw, e parame)
  {
    return a(paramw, new c(paramSticker, paramBoolean1, paramBoolean2, paramBoolean3, paramw, parame));
  }

  void a()
  {
    g();
    e();
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
    this.i.a();
  }

  public void a(String paramString)
  {
    if (da.a(paramString))
      return;
    synchronized (this.g)
    {
      if (this.g.get(paramString) != null)
        this.g.remove(paramString);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public void a(int[] paramArrayOfInt, z paramz)
  {
    this.j.a(paramArrayOfInt, paramz);
  }

  public boolean a(Object paramObject)
  {
    if ((paramObject instanceof Runnable))
      return g().remove((Runnable)paramObject);
    return false;
  }

  public b b(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    a(paramw);
    return (b)this.g.get(paramSticker.getScaledPathKey(paramBoolean1, paramBoolean2, paramw));
  }

  void b()
  {
    if (this.e != null)
    {
      this.e.shutdownNow();
      this.e = null;
    }
  }

  public void b(Sticker paramSticker)
  {
    if (paramSticker.packageId == this.h)
    {
      this.i.b(paramSticker);
      return;
    }
    this.j.b(paramSticker);
  }

  public void b(Object paramObject)
  {
    ((c)paramObject).c();
  }

  // ERROR //
  Bitmap c(Sticker paramSticker, boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: aload 4
    //   4: invokevirtual 427	com/viber/voip/stickers/entity/Sticker:getPath	(ZLcom/viber/voip/stickers/w;)Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: invokestatic 399	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   14: istore 15
    //   16: iload 15
    //   18: ifeq +9 -> 27
    //   21: aconst_null
    //   22: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   25: aconst_null
    //   26: areturn
    //   27: aload 5
    //   29: iconst_0
    //   30: invokevirtual 142	java/lang/String:charAt	(I)C
    //   33: bipush 47
    //   35: if_icmpne +49 -> 84
    //   38: new 196	java/io/FileInputStream
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 428	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   47: astore 9
    //   49: new 430	android/graphics/BitmapFactory$Options
    //   52: dup
    //   53: invokespecial 431	android/graphics/BitmapFactory$Options:<init>	()V
    //   56: astore 16
    //   58: aload 16
    //   60: getstatic 437	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   63: putfield 440	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   66: aload 9
    //   68: aconst_null
    //   69: aload 16
    //   71: invokestatic 443	com/viber/voip/util/dq:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: astore 18
    //   76: aload 9
    //   78: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   81: aload 18
    //   83: areturn
    //   84: invokestatic 154	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   87: invokevirtual 447	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   90: invokevirtual 450	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   93: aload 5
    //   95: invokevirtual 166	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   98: astore 19
    //   100: aload 19
    //   102: astore 9
    //   104: goto -55 -> 49
    //   107: astore 11
    //   109: aconst_null
    //   110: astore 7
    //   112: getstatic 455	com/viber/voip/stickers/f$2:a	[I
    //   115: aload 4
    //   117: invokevirtual 458	com/viber/voip/stickers/w:ordinal	()I
    //   120: iaload
    //   121: tableswitch	default:+27 -> 148, 1:+39->160, 2:+39->160, 3:+60->181
    //   149: iconst_1
    //   150: invokestatic 461	com/viber/voip/stickers/entity/Sticker:invalidSize	(Lcom/viber/voip/stickers/w;)V
    //   153: aload 7
    //   155: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   158: aconst_null
    //   159: areturn
    //   160: aload_0
    //   161: getfield 77	com/viber/voip/stickers/f:k	Lcom/viber/voip/stickers/q;
    //   164: aload_1
    //   165: iload_2
    //   166: iload_3
    //   167: aload 4
    //   169: aload 11
    //   171: invokevirtual 291	com/viber/voip/stickers/q:a	(Lcom/viber/voip/stickers/entity/Sticker;ZZLcom/viber/voip/stickers/w;Ljava/io/IOException;)V
    //   174: aload 7
    //   176: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   179: aconst_null
    //   180: areturn
    //   181: iload_2
    //   182: ifeq +10 -> 192
    //   185: aload 7
    //   187: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   190: aconst_null
    //   191: areturn
    //   192: aload_1
    //   193: invokevirtual 464	com/viber/voip/stickers/entity/Sticker:getThumbWidth	()I
    //   196: istore 12
    //   198: aload_1
    //   199: invokevirtual 467	com/viber/voip/stickers/entity/Sticker:getThumbHeight	()I
    //   202: istore 13
    //   204: aload_1
    //   205: invokevirtual 470	com/viber/voip/stickers/entity/Sticker:createFolder	()V
    //   208: aload_0
    //   209: aload_1
    //   210: aload_1
    //   211: invokevirtual 474	com/viber/voip/stickers/entity/Sticker:getOrigPath	()Ljava/lang/String;
    //   214: aload 5
    //   216: iload 12
    //   218: iload 13
    //   220: iload_2
    //   221: iload_3
    //   222: aload 4
    //   224: invokespecial 476	com/viber/voip/stickers/f:a	(Lcom/viber/voip/stickers/entity/Sticker;Ljava/lang/String;Ljava/lang/String;IIZZLcom/viber/voip/stickers/w;)Landroid/graphics/Bitmap;
    //   227: astore 14
    //   229: aload 7
    //   231: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   234: aload 14
    //   236: areturn
    //   237: astore 10
    //   239: aconst_null
    //   240: astore 9
    //   242: aload_0
    //   243: aload 10
    //   245: invokespecial 134	com/viber/voip/stickers/f:a	(Ljava/lang/OutOfMemoryError;)V
    //   248: aload 9
    //   250: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   253: aconst_null
    //   254: areturn
    //   255: astore 8
    //   257: aconst_null
    //   258: astore 9
    //   260: aload 9
    //   262: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   265: aconst_null
    //   266: areturn
    //   267: astore 6
    //   269: aconst_null
    //   270: astore 7
    //   272: aload 7
    //   274: invokestatic 194	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   277: aload 6
    //   279: athrow
    //   280: astore 6
    //   282: aload 9
    //   284: astore 7
    //   286: goto -14 -> 272
    //   289: astore 6
    //   291: goto -19 -> 272
    //   294: astore 17
    //   296: goto -36 -> 260
    //   299: astore 10
    //   301: goto -59 -> 242
    //   304: astore 11
    //   306: aload 9
    //   308: astore 7
    //   310: goto -198 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   9	16	107	java/io/FileNotFoundException
    //   27	49	107	java/io/FileNotFoundException
    //   84	100	107	java/io/FileNotFoundException
    //   9	16	237	java/lang/OutOfMemoryError
    //   27	49	237	java/lang/OutOfMemoryError
    //   84	100	237	java/lang/OutOfMemoryError
    //   9	16	255	java/io/IOException
    //   27	49	255	java/io/IOException
    //   84	100	255	java/io/IOException
    //   9	16	267	finally
    //   27	49	267	finally
    //   84	100	267	finally
    //   49	76	280	finally
    //   242	248	280	finally
    //   112	148	289	finally
    //   148	153	289	finally
    //   160	174	289	finally
    //   192	229	289	finally
    //   49	76	294	java/io/IOException
    //   49	76	299	java/lang/OutOfMemoryError
    //   49	76	304	java/io/FileNotFoundException
  }

  public void c()
  {
    this.i.a();
    this.j.a();
  }

  public void d()
  {
    this.g.evictAll();
    c();
  }

  public void e()
  {
    if (!l)
    {
      l = true;
      av.a(av.e.g).post(new Runnable()
      {
        public void run()
        {
          try
          {
            f.this.f();
            return;
          }
          catch (i.c localc)
          {
          }
        }
      });
    }
  }

  public void f()
    throws i.c
  {
    Iterator localIterator1 = this.f.h().iterator();
    while (localIterator1.hasNext())
    {
      com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator1.next();
      if (!locala.g())
      {
        Iterator localIterator2 = this.f.s(locala.e()).iterator();
        while (localIterator2.hasNext())
          a((Sticker)localIterator2.next(), false);
      }
    }
  }

  public static abstract interface a extends Runnable
  {
    public abstract int a();
  }

  public static abstract interface b
  {
    public abstract void b();
  }

  class c
    implements f.a, f.b, Runnable
  {
    public final int a;
    public final int b;
    private int d;
    private Sticker e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final w i;
    private final f.e j;
    private volatile boolean k;
    private b l;
    private int m;
    private Runnable n = new Runnable()
    {
      public void run()
      {
        if ((f.c.a(f.c.this)) || ((f.c(f.this)) && (f.c.b(f.c.this))))
          return;
        if (f.c.c(f.c.this) == null)
        {
          f.c.e(f.c.this).a(f.c.d(f.c.this), f.c.this);
          return;
        }
        f.c.e(f.c.this).a(f.c.d(f.c.this), f.c.this, f.c.c(f.c.this));
      }
    };

    public c(int paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramw, w parame, f.e arg7)
    {
      this(null, paramBoolean2, paramBoolean3, paramw, parame, locale);
      this.d = paramBoolean1;
    }

    public c(Sticker paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramw, w parame, f.e arg7)
    {
      this.e = paramBoolean1;
      this.f = paramBoolean3;
      this.h = paramw;
      this.i = parame;
      this.g = paramBoolean2;
      Object localObject;
      this.j = localObject;
      this.b = f.a(f.this).nextInt();
      int i1 = 1 + f.a;
      f.a = i1;
      this.m = i1;
      if (this.m == 1073741824)
        this.m = 0;
      int i2 = 1073741824 - this.m;
      if (paramBoolean3)
        i2 |= 1073741824;
      this.a = i2;
    }

    private boolean d()
    {
      if (this.k);
      return this.k;
    }

    public int a()
    {
      return this.a;
    }

    public void b()
    {
      this.k = true;
      f.this.c.removeCallbacks(this.n);
    }

    public void c()
    {
      this.k = true;
    }

    public void run()
    {
      if (d());
      b localb;
      do
      {
        return;
        if (this.e == null)
          this.e = f.b(f.this).u(this.d);
        localb = f.this.a(this.e, this.f, this.h, this.i);
        this.l = localb;
      }
      while ((localb != null) && ((d()) || ((f.c(f.this)) && (this.g))));
      Handler localHandler = f.this.c;
      Runnable localRunnable = this.n;
      if (this.g);
      for (long l1 = 20L; ; l1 = 0L)
      {
        localHandler.postDelayed(localRunnable, l1);
        return;
      }
    }

    public String toString()
    {
      return "L" + this.m;
    }
  }

  private static class d
    implements Comparator<Runnable>
  {
    public int a(Runnable paramRunnable1, Runnable paramRunnable2)
    {
      f.a locala1 = (f.a)paramRunnable1;
      f.a locala2 = (f.a)paramRunnable2;
      return locala1.a() - locala2.a();
    }
  }

  public static abstract interface e
  {
    public abstract void a(Sticker paramSticker, Object paramObject);

    public abstract void a(Sticker paramSticker, Object paramObject, b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.f
 * JD-Core Version:    0.6.2
 */