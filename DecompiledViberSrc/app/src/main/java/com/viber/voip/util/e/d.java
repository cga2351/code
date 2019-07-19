package com.viber.voip.util.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import com.viber.common.d.i;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a;
import com.viber.voip.util.bu;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.IOException;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Bitmap.CompressFormat b = Bitmap.CompressFormat.JPEG;
  private com.viber.voip.b.b c;
  private com.viber.voip.b.a.b<String> d;
  private a e;
  private final Object f = new Object();
  private boolean g = true;

  d(a parama)
  {
    a(parama);
  }

  public static File a(Context paramContext)
  {
    return paramContext.getExternalCacheDir();
  }

  public static File a(Context paramContext, String paramString)
  {
    if (("mounted".equals(o.e())) || (!Environment.isExternalStorageRemovable()));
    for (File localFile = a(paramContext); ; localFile = paramContext.getCacheDir())
    {
      if (localFile == null)
        localFile = paramContext.getCacheDir();
      return new File(localFile.getPath() + File.separator + paramString);
    }
  }

  private void a(a parama)
  {
    this.e = parama;
    this.g = this.e.f;
    if (this.e.e)
      this.d = ((com.viber.voip.b.a.b)ViberApplication.getInstance().getCacheManager().a(this.e.a()));
    if ((this.e.f) && (parama.g))
      a();
  }

  public static String e(String paramString)
  {
    return bu.a(paramString).toUpperCase();
  }

  public void a()
  {
    if (!this.e.f)
      return;
    i.a();
    File localFile;
    synchronized (this.f)
    {
      if ((this.c == null) || (this.c.a()))
      {
        localFile = this.e.b;
        if ((this.e.f) && (localFile != null))
        {
          if (!localFile.exists())
            localFile.mkdirs();
          long l = localFile.getUsableSpace();
          int i = this.e.a;
          if (l <= i);
        }
      }
    }
    try
    {
      this.c = com.viber.voip.b.b.a(localFile, 1, 1, this.e.a);
      this.g = false;
      this.f.notifyAll();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.e.b = null;
        a.a(localIOException, "initDiskCache(): unable to initialize disk cache");
      }
    }
  }

  public void a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramString == null) || (paramBitmap == null));
    while ((this.d == null) || ((this.d.a(paramString) != null) && (!paramBoolean)))
      return;
    this.d.a(paramString, paramBitmap);
  }

  public boolean a(String paramString)
  {
    if (paramString == null);
    while ((this.d == null) || (this.d.b(paramString) == null))
      return false;
    return true;
  }

  public void b()
  {
    if (this.d != null)
      this.d.evictAll();
  }

  // ERROR //
  public void b(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 102	com/viber/voip/util/e/d:e	Lcom/viber/voip/util/e/d$a;
    //   13: getfield 106	com/viber/voip/util/e/d$a:f	Z
    //   16: ifeq -8 -> 8
    //   19: aload_0
    //   20: getfield 42	com/viber/voip/util/e/d:f	Ljava/lang/Object;
    //   23: astore 4
    //   25: aload 4
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 151	com/viber/voip/util/e/d:c	Lcom/viber/voip/b/b;
    //   32: ifnull +113 -> 145
    //   35: aload_1
    //   36: invokestatic 201	com/viber/voip/util/e/d:e	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 6
    //   41: aconst_null
    //   42: astore 7
    //   44: aload_0
    //   45: getfield 151	com/viber/voip/util/e/d:c	Lcom/viber/voip/b/b;
    //   48: aload 6
    //   50: invokevirtual 204	com/viber/voip/b/b:a	(Ljava/lang/String;)Lcom/viber/voip/b/b$c;
    //   53: astore 13
    //   55: aload 13
    //   57: ifnull +7 -> 64
    //   60: iload_3
    //   61: ifeq +96 -> 157
    //   64: aload_0
    //   65: getfield 151	com/viber/voip/util/e/d:c	Lcom/viber/voip/b/b;
    //   68: aload 6
    //   70: invokevirtual 207	com/viber/voip/b/b:b	(Ljava/lang/String;)Lcom/viber/voip/b/b$a;
    //   73: astore 14
    //   75: aconst_null
    //   76: astore 7
    //   78: aload 14
    //   80: ifnull +46 -> 126
    //   83: aload 14
    //   85: iconst_0
    //   86: invokevirtual 212	com/viber/voip/b/b$a:a	(I)Ljava/io/OutputStream;
    //   89: astore 15
    //   91: aload 15
    //   93: astore 7
    //   95: aload_2
    //   96: aload_0
    //   97: getfield 102	com/viber/voip/util/e/d:e	Lcom/viber/voip/util/e/d$a;
    //   100: getfield 214	com/viber/voip/util/e/d$a:c	Landroid/graphics/Bitmap$CompressFormat;
    //   103: aload_0
    //   104: getfield 102	com/viber/voip/util/e/d:e	Lcom/viber/voip/util/e/d$a;
    //   107: getfield 216	com/viber/voip/util/e/d$a:d	I
    //   110: aload 7
    //   112: invokestatic 221	com/viber/voip/util/dq:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   115: pop
    //   116: aload 14
    //   118: invokevirtual 222	com/viber/voip/b/b$a:a	()V
    //   121: aload 7
    //   123: invokevirtual 227	java/io/OutputStream:close	()V
    //   126: aload 13
    //   128: ifnull +12 -> 140
    //   131: aload 13
    //   133: iconst_0
    //   134: invokevirtual 232	com/viber/voip/b/b$c:a	(I)Ljava/io/InputStream;
    //   137: invokevirtual 235	java/io/InputStream:close	()V
    //   140: aload 7
    //   142: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   145: aload 4
    //   147: monitorexit
    //   148: return
    //   149: astore 5
    //   151: aload 4
    //   153: monitorexit
    //   154: aload 5
    //   156: athrow
    //   157: aload 13
    //   159: iconst_0
    //   160: invokevirtual 232	com/viber/voip/b/b$c:a	(I)Ljava/io/InputStream;
    //   163: invokevirtual 235	java/io/InputStream:close	()V
    //   166: aconst_null
    //   167: astore 7
    //   169: goto -29 -> 140
    //   172: astore 12
    //   174: aload 7
    //   176: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   179: goto -34 -> 145
    //   182: astore 11
    //   184: aload 7
    //   186: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   189: goto -44 -> 145
    //   192: aload 10
    //   194: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   197: aload 9
    //   199: athrow
    //   200: astore 16
    //   202: aload 7
    //   204: astore 10
    //   206: aload 16
    //   208: astore 9
    //   210: goto -18 -> 192
    //   213: astore 8
    //   215: aload 8
    //   217: astore 9
    //   219: aconst_null
    //   220: astore 10
    //   222: goto -30 -> 192
    //
    // Exception table:
    //   from	to	target	type
    //   28	41	149	finally
    //   140	145	149	finally
    //   145	148	149	finally
    //   151	154	149	finally
    //   174	179	149	finally
    //   184	189	149	finally
    //   192	200	149	finally
    //   44	55	172	java/io/IOException
    //   64	75	172	java/io/IOException
    //   83	91	172	java/io/IOException
    //   95	126	172	java/io/IOException
    //   131	140	172	java/io/IOException
    //   157	166	172	java/io/IOException
    //   44	55	182	java/lang/Exception
    //   64	75	182	java/lang/Exception
    //   83	91	182	java/lang/Exception
    //   95	126	182	java/lang/Exception
    //   131	140	182	java/lang/Exception
    //   157	166	182	java/lang/Exception
    //   95	126	200	finally
    //   131	140	200	finally
    //   44	55	213	finally
    //   64	75	213	finally
    //   83	91	213	finally
    //   157	166	213	finally
  }

  public boolean b(String paramString)
  {
    if ((paramString == null) || (!this.e.f))
      return false;
    boolean bool1;
    String str;
    synchronized (this.f)
    {
      com.viber.voip.b.b localb = this.c;
      bool1 = false;
      if (localb != null)
        str = e(paramString);
    }
    try
    {
      boolean bool2 = this.c.c(str);
      bool1 = bool2;
      return bool1;
      localObject2 = finally;
      throw localObject2;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        a.a(localIOException, "Unable to remove bitmap from cache.");
        bool1 = false;
      }
    }
  }

  public Bitmap c(String paramString)
  {
    if (this.d != null);
    for (Bitmap localBitmap = this.d.a(paramString); ; localBitmap = null)
    {
      if ((localBitmap != null) && (localBitmap.isRecycled()))
      {
        this.d.b(paramString);
        return null;
      }
      return localBitmap;
    }
  }

  // ERROR //
  public Bitmap d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/viber/voip/util/e/d:e	Lcom/viber/voip/util/e/d$a;
    //   4: getfield 106	com/viber/voip/util/e/d$a:f	Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: getfield 42	com/viber/voip/util/e/d:f	Ljava/lang/Object;
    //   16: astore_2
    //   17: aload_2
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 44	com/viber/voip/util/e/d:g	Z
    //   23: istore 4
    //   25: iload 4
    //   27: ifeq +36 -> 63
    //   30: aload_0
    //   31: getfield 42	com/viber/voip/util/e/d:f	Ljava/lang/Object;
    //   34: invokevirtual 255	java/lang/Object:wait	()V
    //   37: goto -18 -> 19
    //   40: astore 14
    //   42: getstatic 29	com/viber/voip/util/e/d:a	Lcom/viber/dexshared/Logger;
    //   45: aload 14
    //   47: ldc_w 257
    //   50: invokeinterface 184 3 0
    //   55: goto -36 -> 19
    //   58: astore_3
    //   59: aload_2
    //   60: monitorexit
    //   61: aload_3
    //   62: athrow
    //   63: aload_0
    //   64: getfield 151	com/viber/voip/util/e/d:c	Lcom/viber/voip/b/b;
    //   67: ifnull +132 -> 199
    //   70: aload_1
    //   71: invokestatic 201	com/viber/voip/util/e/d:e	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 6
    //   76: aload_0
    //   77: getfield 151	com/viber/voip/util/e/d:c	Lcom/viber/voip/b/b;
    //   80: aload 6
    //   82: invokevirtual 204	com/viber/voip/b/b:a	(Ljava/lang/String;)Lcom/viber/voip/b/b$c;
    //   85: astore 10
    //   87: aload 10
    //   89: ifnull +101 -> 190
    //   92: aload 10
    //   94: iconst_0
    //   95: invokevirtual 232	com/viber/voip/b/b$c:a	(I)Ljava/io/InputStream;
    //   98: astore 11
    //   100: aload 11
    //   102: astore 8
    //   104: aconst_null
    //   105: astore 12
    //   107: aload 8
    //   109: ifnull +20 -> 129
    //   112: aload 8
    //   114: checkcast 259	java/io/FileInputStream
    //   117: invokevirtual 263	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   120: invokestatic 268	com/viber/voip/util/e/i:a	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
    //   123: astore 13
    //   125: aload 13
    //   127: astore 12
    //   129: aload 8
    //   131: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   134: aload 12
    //   136: astore 5
    //   138: aload_2
    //   139: monitorexit
    //   140: aload 5
    //   142: areturn
    //   143: astore 9
    //   145: aconst_null
    //   146: astore 8
    //   148: getstatic 29	com/viber/voip/util/e/d:a	Lcom/viber/dexshared/Logger;
    //   151: aload 9
    //   153: ldc_w 270
    //   156: invokeinterface 184 3 0
    //   161: aload 8
    //   163: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   166: aconst_null
    //   167: astore 5
    //   169: goto -31 -> 138
    //   172: aload 8
    //   174: invokestatic 240	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   177: aload 7
    //   179: athrow
    //   180: astore 7
    //   182: goto -10 -> 172
    //   185: astore 9
    //   187: goto -39 -> 148
    //   190: aconst_null
    //   191: astore 8
    //   193: aconst_null
    //   194: astore 12
    //   196: goto -67 -> 129
    //   199: aconst_null
    //   200: astore 5
    //   202: goto -64 -> 138
    //   205: astore 7
    //   207: aconst_null
    //   208: astore 8
    //   210: goto -38 -> 172
    //
    // Exception table:
    //   from	to	target	type
    //   30	37	40	java/lang/InterruptedException
    //   19	25	58	finally
    //   30	37	58	finally
    //   42	55	58	finally
    //   59	61	58	finally
    //   63	76	58	finally
    //   129	134	58	finally
    //   138	140	58	finally
    //   161	166	58	finally
    //   172	180	58	finally
    //   76	87	143	java/io/IOException
    //   92	100	143	java/io/IOException
    //   112	125	180	finally
    //   148	161	180	finally
    //   112	125	185	java/io/IOException
    //   76	87	205	finally
    //   92	100	205	finally
  }

  public static class a
  {
    public int a = 15728640;
    public File b;
    public Bitmap.CompressFormat c = d.c();
    public int d = 70;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public a h = a.a;

    public a(Context paramContext, String paramString, boolean paramBoolean)
    {
      this.f = paramBoolean;
      if (this.f)
        this.b = d.a(paramContext, paramString);
    }

    public a a()
    {
      return this.h;
    }

    public void a(a parama)
    {
      this.h = parama;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.d
 * JD-Core Version:    0.6.2
 */