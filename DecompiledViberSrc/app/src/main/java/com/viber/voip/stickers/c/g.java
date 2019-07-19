package com.viber.voip.stickers.c;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.p;
import com.viber.voip.util.as;
import com.viber.voip.util.at;
import com.viber.voip.util.bj;
import com.viber.voip.util.cj;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.upload.b.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class g
{
  private static final Logger e = ViberEnv.getLogger();
  com.viber.voip.stickers.e.b a;
  b b = b.a;
  b c = b.b;
  b d = b.c;
  private SparseArray<b> f = new SparseArray();
  private SparseArray<h> g = new SparseArray();
  private ExecutorService h;
  private ExecutorService i;
  private i j;
  private int k = -1;

  public g(i parami, com.viber.voip.stickers.e.b paramb)
  {
    this.j = parami;
    this.a = paramb;
  }

  public static File a(Context paramContext)
  {
    return at.b(paramContext, ".stickers");
  }

  public static File a(Context paramContext, int paramInt)
  {
    return new File(a(paramContext), String.valueOf(paramInt));
  }

  public static String a(int paramInt1, int paramInt2)
  {
    return b(paramInt1, Integer.toString(paramInt2));
  }

  public static String a(int paramInt, String paramString)
  {
    int m = f(paramInt);
    String str = ap.c().D;
    as localas = as.c;
    if (paramString.equals("sound"));
    for (localas = as.j; ; localas = as.k)
      do
        return str.replaceAll("%RES%", paramString).replaceAll("%PKG%", Integer.toString(m)).replaceAll("%ID%", m(paramInt)).replaceAll("%EXT%", localas.a());
      while ((!paramString.equals("ASVG")) && (!paramString.equals("SVG")));
  }

  static void a(String paramString1, int paramInt, String paramString2)
    throws b.a
  {
    ZipInputStream localZipInputStream;
    try
    {
      localZipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
      try
      {
        if (paramInt != b.a(localZipInputStream.getNextEntry().getName()))
          throw new Exception("Wrong file");
      }
      finally
      {
        bj.a(localZipInputStream);
        at.f(new File(paramString1));
      }
    }
    catch (Exception localException)
    {
      throw new b.a(localException);
    }
    a(paramString2, localZipInputStream);
    bj.a(localZipInputStream);
    at.f(new File(paramString1));
  }

  static void a(String paramString, InputStream paramInputStream)
    throws IOException
  {
    String str = paramString + ".tmp";
    File localFile = new File(str);
    FileOutputStream localFileOutputStream = new FileOutputStream(str);
    try
    {
      bj.b(paramInputStream, localFileOutputStream);
      bj.a(localFileOutputStream);
      localFile.renameTo(new File(paramString));
      return;
    }
    finally
    {
      bj.a(localFileOutputStream);
    }
  }

  private boolean a(b paramb, int paramInt, Bundle paramBundle)
  {
    return paramb.a(paramInt, paramBundle, d());
  }

  public static boolean a(String paramString)
    throws Exception
  {
    return b(paramString) == 200;
  }

  public static int b(String paramString)
    throws Exception
  {
    if (!cj.b(ViberApplication.getApplication()))
      throw new NetworkErrorException("No internet connection");
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().connectTimeout(8000L, TimeUnit.MILLISECONDS).readTimeout(8000L, TimeUnit.MILLISECONDS);
    Request.Builder localBuilder1 = new Request.Builder().url(paramString);
    return localBuilder.build().newCall(localBuilder1.build()).execute().code();
  }

  public static String b(int paramInt1, int paramInt2)
  {
    return b(ap.c().A, paramInt1, Integer.toString(paramInt2));
  }

  public static String b(int paramInt, String paramString)
  {
    return b(ap.c().y, paramInt, paramString);
  }

  public static String b(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(a(ViberApplication.getApplication(), paramInt).getPath()).append("/");
    if (paramBoolean);
    for (String str = "thumb.svg"; ; str = "thumb.png")
      return str;
  }

  public static String b(String paramString1, int paramInt, String paramString2)
  {
    return paramString1.replaceAll("%RES%", paramString2).replaceAll("%PKG%", Integer.toString(paramInt));
  }

  public static File c()
  {
    return new File(at.a("media"), ".stickers");
  }

  public static boolean c(int paramInt, String paramString)
    throws Exception
  {
    return a(a(paramInt, paramString));
  }

  private ExecutorService d()
  {
    if (this.h == null)
      this.h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    return this.h;
  }

  public static boolean d(int paramInt, String paramString)
    throws Exception
  {
    return a(b(paramInt, paramString));
  }

  private ExecutorService e()
  {
    if (this.i == null)
    {
      PriorityBlockingQueue localPriorityBlockingQueue = new PriorityBlockingQueue(100, new Comparator()
      {
        public int a(Runnable paramAnonymousRunnable1, Runnable paramAnonymousRunnable2)
        {
          h localh = (h)paramAnonymousRunnable1;
          return (int)(((h)paramAnonymousRunnable2).a() - localh.a());
        }
      });
      this.i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, localPriorityBlockingQueue);
    }
    return this.i;
  }

  public static int f(int paramInt)
  {
    return paramInt - paramInt % 100;
  }

  public static String g(int paramInt)
  {
    return ap.c().C.replaceAll("%PKG%", Integer.toString(paramInt));
  }

  public static String h(int paramInt)
  {
    return ap.c().B.replaceAll("%PKG%", Integer.toString(paramInt));
  }

  public static boolean i(int paramInt)
    throws Exception
  {
    return c(paramInt, String.valueOf(p.f()));
  }

  public static String j(int paramInt)
  {
    return a(ViberApplication.getApplication(), paramInt).getPath() + "/" + "sound.mp3";
  }

  public static String k(int paramInt)
  {
    return a(ViberApplication.getApplication(), paramInt).getPath() + "/" + "color_icon.png";
  }

  public static String l(int paramInt)
  {
    return a(ViberApplication.getApplication(), paramInt).getPath() + "/" + "thumb.zip";
  }

  private static String m(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return String.format(localLocale, "%08d", arrayOfObject);
  }

  public void a()
  {
    int m = 0;
    int n = 0;
    try
    {
      while (n < this.f.size())
      {
        ((b)this.f.valueAt(n)).b();
        n++;
      }
      this.f.clear();
      while (m < this.g.size())
      {
        ((h)this.g.valueAt(m)).b();
        m++;
      }
      this.g.clear();
      return;
    }
    finally
    {
    }
  }

  public void a(int paramInt)
  {
    try
    {
      b localb = (b)this.f.get(paramInt);
      if (localb != null)
      {
        localb.b();
        this.g.remove(paramInt);
      }
      return;
    }
    finally
    {
    }
  }

  public void a(Sticker paramSticker)
  {
    try
    {
      if (this.g.get(paramSticker.id) == null)
      {
        h local3 = new h(paramSticker, this.j, this.a)
        {
          public void a(int paramAnonymousInt)
          {
            synchronized (g.this)
            {
              g.b(g.this).remove(paramAnonymousInt);
              return;
            }
          }
        };
        this.g.put(paramSticker.id, local3);
        e().execute(local3);
      }
      return;
    }
    finally
    {
    }
  }

  public boolean a(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = f.a(paramBoolean);
    return a(this.c, paramInt, localBundle);
  }

  public boolean a(a parama)
  {
    try
    {
      if (this.f.get(parama.e()) == null)
      {
        b local2 = new b((com.viber.voip.stickers.entity.b)parama, this.j, this.a)
        {
          public void a(int paramAnonymousInt)
          {
            synchronized (g.this)
            {
              g.a(g.this).remove(paramAnonymousInt);
              g.a(g.this, -1);
              return;
            }
          }

          public void b(int paramAnonymousInt)
          {
            synchronized (g.this)
            {
              g.a(g.this, paramAnonymousInt);
              return;
            }
          }
        };
        this.f.put(parama.e(), local2);
        d().execute(local2);
        if (parama.g())
          this.j.d();
        return true;
      }
      return false;
    }
    finally
    {
    }
  }

  public a b()
  {
    try
    {
      b localb;
      Object localObject2;
      if (this.k != -1)
      {
        localb = (b)this.f.get(this.k);
        if (localb == null)
          localObject2 = null;
      }
      while (true)
      {
        return localObject2;
        a locala = new a();
        locala.b = localb.d();
        locala.a = localb.c();
        localObject2 = locala;
        continue;
        localObject2 = null;
      }
    }
    finally
    {
    }
  }

  public boolean b(int paramInt)
  {
    return a(this.b, paramInt, null);
  }

  public boolean c(int paramInt)
  {
    return a(this.d, paramInt, null);
  }

  public boolean d(int paramInt)
  {
    try
    {
      int m = this.k;
      if (paramInt == m)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean e(int paramInt)
  {
    try
    {
      if (this.f.get(paramInt) != null)
      {
        boolean bool2 = d(paramInt);
        if (!bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public static class a
  {
    public a a;
    public int b;
  }

  static enum b
    implements c.a
  {
    SparseArray<c> d = new SparseArray();

    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }

    private c a(int paramInt, Bundle paramBundle)
    {
      switch (g.4.a[ordinal()])
      {
      default:
        return null;
      case 1:
        return new d(paramInt, paramBundle);
      case 2:
        return new f(paramInt, paramBundle);
      case 3:
      }
      return new e(paramInt, paramBundle);
    }

    public void a(int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean)
        return;
      while (true)
      {
        synchronized (this.d)
        {
          this.d.remove(paramInt);
          switch (g.4.a[ordinal()])
          {
          default:
            i.a().d();
            return;
          case 1:
          case 2:
          case 3:
          }
        }
        i.a().a(paramInt);
        continue;
        i.a().b(paramInt);
        continue;
        i.a().d(paramInt);
      }
    }

    public boolean a(int paramInt, Bundle paramBundle, Executor paramExecutor)
    {
      if (this.d.get(paramInt) == null)
      {
        c localc = a(paramInt, paramBundle);
        localc.a(this);
        synchronized (this.d)
        {
          this.d.put(paramInt, localc);
          paramExecutor.execute(localc);
          return true;
        }
      }
      return false;
    }
  }

  public static class c
  {
    private final int a;
    private final int b;

    public c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.g
 * JD-Core Version:    0.6.2
 */