package com.viber.voip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.voip.b.a.a.a;
import com.viber.voip.messages.m;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import pl.droidsonroids.gif.b;

public class an
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = 5 * j.a(0.5F);
  private static final int c;
  private b d;
  private a<Uri> e;
  private Pair<Integer, c> f;
  private int g;
  private float h;
  private float i;
  private Context j;
  private Handler k;
  private Handler l;
  private final ReadWriteLock m = new ReentrantReadWriteLock();
  private final Object n = new Object();
  private List<d> o = new ArrayList();

  static
  {
    if (b == 0);
    for (int i1 = 4; ; i1 = b)
    {
      c = j.a(1280 / i1);
      return;
    }
  }

  public an(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.e = new a("View media cache", paramFloat3);
    this.d = new b(null);
    this.j = paramContext;
    this.k = av.a(av.e.g);
    this.l = av.a(av.e.a);
    this.h = paramFloat1;
    this.i = paramFloat2;
  }

  private Bitmap a(Uri paramUri)
  {
    Lock localLock = this.m.readLock();
    try
    {
      localLock.lock();
      Bitmap localBitmap = (Bitmap)this.e.get(paramUri);
      return localBitmap;
    }
    finally
    {
      localLock.unlock();
    }
  }

  // ERROR //
  private a a(Uri paramUri, String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 144	com/viber/voip/util/e/j:e	(Landroid/net/Uri;)Z
    //   4: ifeq +106 -> 110
    //   7: aload_1
    //   8: invokevirtual 150	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   11: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   14: lstore 17
    //   16: invokestatic 162	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   19: invokevirtual 168	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   22: lload 17
    //   24: iconst_1
    //   25: aconst_null
    //   26: invokestatic 173	com/viber/voip/util/dq:a	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: iload_3
    //   30: iconst_m1
    //   31: iconst_1
    //   32: invokestatic 176	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   35: astore 19
    //   37: aconst_null
    //   38: astore 12
    //   40: aload 19
    //   42: astore 11
    //   44: aload 11
    //   46: ifnull +51 -> 97
    //   49: iload 4
    //   51: ifeq +10 -> 61
    //   54: aload_2
    //   55: invokestatic 181	com/viber/voip/messages/m:e	(Ljava/lang/String;)Z
    //   58: ifeq +39 -> 97
    //   61: aload_0
    //   62: getfield 62	com/viber/voip/an:m	Ljava/util/concurrent/locks/ReadWriteLock;
    //   65: invokeinterface 184 1 0
    //   70: astore 13
    //   72: aload 13
    //   74: invokeinterface 119 1 0
    //   79: aload_0
    //   80: getfield 78	com/viber/voip/an:e	Lcom/viber/voip/b/a/a/a;
    //   83: aload_1
    //   84: aload 11
    //   86: invokevirtual 188	com/viber/voip/b/a/a/a:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 13
    //   92: invokeinterface 128 1 0
    //   97: new 190	com/viber/voip/an$a
    //   100: dup
    //   101: aload 11
    //   103: aload 12
    //   105: aload_2
    //   106: invokespecial 193	com/viber/voip/an$a:<init>	(Landroid/graphics/Bitmap;Lpl/droidsonroids/gif/b;Ljava/lang/String;)V
    //   109: areturn
    //   110: aload_2
    //   111: invokestatic 181	com/viber/voip/messages/m:e	(Ljava/lang/String;)Z
    //   114: ifne +23 -> 137
    //   117: aload_0
    //   118: getfield 87	com/viber/voip/an:j	Landroid/content/Context;
    //   121: aload_1
    //   122: iload_3
    //   123: iload_3
    //   124: iload 4
    //   126: invokestatic 196	com/viber/voip/util/e/j:a	(Landroid/content/Context;Landroid/net/Uri;IIZ)Landroid/graphics/Bitmap;
    //   129: astore 11
    //   131: aconst_null
    //   132: astore 12
    //   134: goto -90 -> 44
    //   137: new 198	com/viber/voip/util/e/m
    //   140: dup
    //   141: invokespecial 199	com/viber/voip/util/e/m:<init>	()V
    //   144: astore 8
    //   146: aload 8
    //   148: invokestatic 162	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   151: invokevirtual 168	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   154: aload_1
    //   155: invokevirtual 202	com/viber/voip/util/e/m:a	(Landroid/content/ContentResolver;Landroid/net/Uri;)Lpl/droidsonroids/gif/d;
    //   158: checkcast 204	pl/droidsonroids/gif/c
    //   161: invokevirtual 207	pl/droidsonroids/gif/c:c	()Lpl/droidsonroids/gif/b;
    //   164: astore 16
    //   166: aload 16
    //   168: astore 10
    //   170: aload 10
    //   172: ifnull +24 -> 196
    //   175: aload 10
    //   177: iconst_0
    //   178: invokevirtual 212	pl/droidsonroids/gif/b:b	(I)Landroid/graphics/Bitmap;
    //   181: iload_3
    //   182: iconst_m1
    //   183: iconst_0
    //   184: invokestatic 176	com/viber/voip/util/e/j:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   187: astore 11
    //   189: aload 10
    //   191: astore 12
    //   193: goto -149 -> 44
    //   196: aload_0
    //   197: getfield 87	com/viber/voip/an:j	Landroid/content/Context;
    //   200: aload_1
    //   201: iload_3
    //   202: iload_3
    //   203: iload 4
    //   205: invokestatic 196	com/viber/voip/util/e/j:a	(Landroid/content/Context;Landroid/net/Uri;IIZ)Landroid/graphics/Bitmap;
    //   208: astore 11
    //   210: aload 10
    //   212: astore 12
    //   214: goto -170 -> 44
    //   217: astore 14
    //   219: aload 13
    //   221: invokeinterface 128 1 0
    //   226: aload 14
    //   228: athrow
    //   229: astore 7
    //   231: new 190	com/viber/voip/an$a
    //   234: dup
    //   235: aconst_null
    //   236: aconst_null
    //   237: aload_2
    //   238: invokespecial 193	com/viber/voip/an$a:<init>	(Landroid/graphics/Bitmap;Lpl/droidsonroids/gif/b;Ljava/lang/String;)V
    //   241: areturn
    //   242: astore 6
    //   244: goto -13 -> 231
    //   247: astore 5
    //   249: goto -18 -> 231
    //   252: astore 9
    //   254: aconst_null
    //   255: astore 10
    //   257: goto -87 -> 170
    //
    // Exception table:
    //   from	to	target	type
    //   72	90	217	finally
    //   0	37	229	java/io/IOException
    //   54	61	229	java/io/IOException
    //   61	72	229	java/io/IOException
    //   90	97	229	java/io/IOException
    //   97	110	229	java/io/IOException
    //   110	131	229	java/io/IOException
    //   137	146	229	java/io/IOException
    //   175	189	229	java/io/IOException
    //   196	210	229	java/io/IOException
    //   219	229	229	java/io/IOException
    //   0	37	242	java/lang/OutOfMemoryError
    //   54	61	242	java/lang/OutOfMemoryError
    //   61	72	242	java/lang/OutOfMemoryError
    //   90	97	242	java/lang/OutOfMemoryError
    //   97	110	242	java/lang/OutOfMemoryError
    //   110	131	242	java/lang/OutOfMemoryError
    //   137	146	242	java/lang/OutOfMemoryError
    //   146	166	242	java/lang/OutOfMemoryError
    //   175	189	242	java/lang/OutOfMemoryError
    //   196	210	242	java/lang/OutOfMemoryError
    //   219	229	242	java/lang/OutOfMemoryError
    //   0	37	247	java/lang/SecurityException
    //   54	61	247	java/lang/SecurityException
    //   61	72	247	java/lang/SecurityException
    //   90	97	247	java/lang/SecurityException
    //   97	110	247	java/lang/SecurityException
    //   110	131	247	java/lang/SecurityException
    //   137	146	247	java/lang/SecurityException
    //   146	166	247	java/lang/SecurityException
    //   175	189	247	java/lang/SecurityException
    //   196	210	247	java/lang/SecurityException
    //   219	229	247	java/lang/SecurityException
    //   146	166	252	java/io/IOException
  }

  private void a(final int paramInt, final c paramc)
  {
    this.l.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = an.d(an.this).iterator();
        while (localIterator.hasNext())
          ((an.d)localIterator.next()).b(paramInt, paramc);
      }
    });
  }

  private void a(Uri paramUri, c paramc)
  {
    BitmapFactory.Options localOptions = j.a(this.j, paramUri, j.a);
    if (localOptions != null)
    {
      float f1 = localOptions.outWidth;
      float f2 = localOptions.outHeight;
      float f3 = Math.min(Math.min(this.h / f1, 2.0F), Math.min(this.i / f2, 2.0F));
      paramc.c = ((int)(f2 * f3));
      paramc.b = ((int)(f1 * f3));
    }
  }

  private void b(final int paramInt, final Uri paramUri)
  {
    this.l.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = an.d(an.this).iterator();
        while (localIterator.hasNext())
          ((an.d)localIterator.next()).a(paramInt, paramUri);
      }
    });
  }

  private void e()
  {
    this.l.post(new Runnable()
    {
      public void run()
      {
        synchronized (an.a(an.this))
        {
          if ((an.b(an.this) != -1) && (an.c(an.this) != null) && (((Integer)an.c(an.this).first).intValue() == an.b(an.this)))
          {
            Iterator localIterator = an.d(an.this).iterator();
            if (localIterator.hasNext())
              ((an.d)localIterator.next()).a(((Integer)an.c(an.this).first).intValue(), (an.c)an.c(an.this).second);
          }
        }
      }
    });
  }

  public c a(int paramInt, Uri paramUri, String paramString)
  {
    if (paramUri == null)
      return null;
    synchronized (this.n)
    {
      if ((this.f != null) && (((Integer)this.f.first).intValue() == paramInt))
      {
        c localc2 = (c)this.f.second;
        return localc2;
      }
    }
    Bitmap localBitmap = a(paramUri);
    if (localBitmap != null)
    {
      c localc1 = new c(new a(localBitmap, null, paramString), false);
      a(paramUri, localc1);
      return localc1;
    }
    return null;
  }

  public void a()
  {
    this.f = null;
    c();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    this.h = paramFloat1;
    this.i = paramFloat2;
  }

  public void a(int paramInt, Bitmap paramBitmap, String paramString)
  {
    synchronized (this.n)
    {
      this.g = paramInt;
      a locala = new a(paramBitmap, null, paramString);
      this.f = new Pair(Integer.valueOf(paramInt), new c(locala, true));
      Iterator localIterator = this.o.iterator();
      if (localIterator.hasNext())
        ((d)localIterator.next()).a(((Integer)this.f.first).intValue(), (c)this.f.second);
    }
  }

  public void a(int paramInt, Uri paramUri)
  {
    if (paramUri == null)
      return;
    this.k.post(new f(paramUri, paramInt));
  }

  public void a(d paramd)
  {
    if (paramd != null)
      this.o.add(paramd);
  }

  public void b()
  {
    this.f = null;
    Lock localLock = this.m.writeLock();
    try
    {
      localLock.lock();
      this.e.evictAll();
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public void b(int paramInt, Uri paramUri, String paramString)
  {
    if (paramUri == null)
      return;
    Bitmap localBitmap = a(paramUri);
    if (localBitmap == null)
    {
      this.k.post(new e(paramInt, paramUri, paramString));
      return;
    }
    c localc = new c(new a(localBitmap, null, paramString), false);
    a(paramUri, localc);
    a(paramInt, localc);
  }

  public void b(d paramd)
  {
    if (paramd != null)
      this.o.remove(paramd);
  }

  public c c(int paramInt, Uri paramUri, String paramString)
  {
    if (paramUri == null)
      return null;
    while (true)
    {
      Bitmap localBitmap;
      synchronized (this.n)
      {
        if ((this.f != null) && (((Integer)this.f.first).intValue() == paramInt) && (this.f.second != null) && (paramUri.equals(((c)this.f.second).d)))
        {
          c localc2 = new c(((c)this.f.second).e, true);
          return localc2;
        }
        localBitmap = a(paramUri);
        if (localBitmap == null)
        {
          locala = a(paramUri, paramString, c, false);
          c localc1 = new c(locala, false);
          a(paramUri, localc1);
          return localc1;
        }
      }
      a locala = new a(localBitmap, null, paramString);
    }
  }

  public void c()
  {
    this.g = -1;
    this.k.removeCallbacks(this.d);
  }

  public void d(int paramInt, Uri paramUri, String paramString)
  {
    if (j.e(paramUri))
      return;
    synchronized (this.n)
    {
      if ((this.f != null) && (((Integer)this.f.first).intValue() == paramInt) && (this.f.second != null) && (paramUri != null) && (paramUri.equals(((c)this.f.second).d)))
      {
        if ((((c)this.f.second).a) && (((c)this.f.second).e.b != null) && (!((c)this.f.second).e.b.isPlaying()))
          ((c)this.f.second).e.b.start();
        return;
      }
    }
    this.d.a(paramInt);
    this.d.a(paramUri);
    this.d.a(paramString);
    this.g = paramInt;
    this.k.removeCallbacks(this.d);
    this.k.postDelayed(this.d, 300L);
  }

  public static class a
  {
    public Bitmap a;
    public b b;
    public String c;

    public a(Bitmap paramBitmap, b paramb, String paramString)
    {
      this.a = paramBitmap;
      this.b = paramb;
      this.c = paramString;
    }

    public boolean a()
    {
      return m.e(this.c);
    }
  }

  private class b
    implements Runnable
  {
    private Uri b;
    private String c;
    private int d;

    private b()
    {
    }

    public void a(int paramInt)
    {
      this.d = paramInt;
    }

    public void a(Uri paramUri)
    {
      this.b = paramUri;
    }

    public void a(String paramString)
    {
      this.c = paramString;
    }

    public void run()
    {
      int i = this.d;
      if (an.b(an.this) != this.d);
      an.a locala;
      do
      {
        return;
        locala = an.a(an.this, this.b, this.c, j.a, true);
      }
      while (locala.a == null);
      an.c localc = new an.c(locala, true);
      localc.d = this.b;
      synchronized (an.a(an.this))
      {
        an.a(an.this, new Pair(Integer.valueOf(i), localc));
        an.e(an.this);
        return;
      }
    }
  }

  public static class c
  {
    public boolean a;
    public int b;
    public int c;
    public Uri d;
    public an.a e;

    public c(an.a parama, boolean paramBoolean)
    {
      this.e = parama;
      this.a = paramBoolean;
      if ((parama.a != null) && (paramBoolean))
      {
        this.b = parama.a.getWidth();
        this.c = parama.a.getHeight();
      }
    }
  }

  public static abstract interface d
  {
    public abstract void a(int paramInt, Uri paramUri);

    public abstract void a(int paramInt, an.c paramc);

    public abstract void b(int paramInt, an.c paramc);
  }

  private class e
    implements Runnable
  {
    final Uri a;
    final String b;
    final int c;

    public e(int paramUri, Uri paramString, String arg4)
    {
      this.a = paramString;
      Object localObject;
      this.b = localObject;
      this.c = paramUri;
    }

    public void run()
    {
      Bitmap localBitmap = an.a(an.this, this.a);
      if (localBitmap == null);
      for (an.a locala = an.a(an.this, this.a, this.b, an.d(), false); ; locala = new an.a(localBitmap, null, this.b))
      {
        an.c localc = new an.c(locala, false);
        an.a(an.this, this.a, localc);
        an.a(an.this, this.c, localc);
        return;
      }
    }
  }

  private class f
    implements Runnable
  {
    private final Uri b;
    private final int c;

    public f(Uri paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      this.c = i;
    }

    public void run()
    {
      if (at.a(dv.n.b(an.f(an.this).getApplicationContext(), this.b.toString(), false)));
      while (true)
      {
        return;
        String str = e.a(this.b);
        if (str != null);
        for (File localFile = new File(str); at.a(localFile); localFile = null)
        {
          an.a(an.this, this.c, Uri.fromFile(localFile));
          return;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.an
 * JD-Core Version:    0.6.2
 */