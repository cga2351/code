package com.appboy.d;

import a.a.ae;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.LruCache;
import android.widget.ImageView;
import com.appboy.R.string;
import com.appboy.f.b;
import com.appboy.f.c;
import com.appboy.g;
import java.io.File;

public class a
  implements g
{
  private static final String a = c.a(a.class);
  private LruCache<String, Bitmap> b = new LruCache(b.a())
  {
    protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      return paramAnonymousBitmap.getByteCount();
    }
  };
  private ae c;
  private final Object d = new Object();
  private boolean e = true;
  private boolean f = false;

  public a(Context paramContext)
  {
    File localFile = a(paramContext, "appboy.imageloader.lru.cache");
    new a(null).execute(new File[] { localFile });
  }

  static File a(Context paramContext, String paramString)
  {
    return new File(paramContext.getCacheDir().getPath() + File.separator + paramString);
  }

  public static void a(Context paramContext)
  {
    try
    {
      File localFile = new File(paramContext.getCacheDir(), "appboy.imageloader.lru.cache");
      c.a(a, "Deleting lru image cache directory at: " + localFile.getAbsolutePath());
      com.appboy.f.a.a(localFile);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.d(a, "Failed to delete stored data in image loader", localThrowable);
    }
  }

  private void b(String paramString, Bitmap paramBitmap)
  {
    this.b.put(paramString, paramBitmap);
  }

  Bitmap a(Context paramContext, Uri paramUri, com.appboy.b.a parama)
  {
    return b.a(paramContext, paramUri, parama);
  }

  public Bitmap a(Context paramContext, String paramString, com.appboy.b.a parama)
  {
    Bitmap localBitmap1;
    try
    {
      Bitmap localBitmap2 = a(paramString);
      if (localBitmap2 != null)
        return localBitmap2;
      if (this.f)
      {
        c.b(a, "Cache is currently in offline mode. Not downloading bitmap.");
        return null;
      }
      localBitmap1 = a(paramContext, Uri.parse(paramString), parama);
      if (localBitmap1 != null)
      {
        a(paramString, localBitmap1);
        return localBitmap1;
      }
    }
    catch (Throwable localThrowable)
    {
      c.d(a, "Failed to get bitmap from url. Url: " + paramString, localThrowable);
      localBitmap1 = null;
    }
    return localBitmap1;
  }

  Bitmap a(String paramString)
  {
    Bitmap localBitmap1 = (Bitmap)this.b.get(paramString);
    if (localBitmap1 != null)
    {
      c.a(a, "Got bitmap from mem cache for key " + paramString);
      return localBitmap1;
    }
    Bitmap localBitmap2 = c(paramString);
    if (localBitmap2 != null)
    {
      c.a(a, "Got bitmap from disk cache for key " + paramString);
      b(paramString, localBitmap2);
      return localBitmap2;
    }
    c.b(a, "No cache hit for bitmap: " + paramString);
    return null;
  }

  public void a(Context paramContext, String paramString, ImageView paramImageView, com.appboy.b.a parama)
  {
    try
    {
      new b(paramContext, paramImageView, parama, paramString, null).execute(new Void[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.d(a, "Failed to render url into view. Url: " + paramString, localThrowable);
    }
  }

  void a(String paramString, Bitmap paramBitmap)
  {
    if (b(paramString) == null)
    {
      c.b(a, "Adding bitmap to mem cache for key " + paramString);
      this.b.put(paramString, paramBitmap);
    }
    synchronized (this.d)
    {
      if ((this.c != null) && (!this.c.b(paramString)))
      {
        c.b(a, "Adding bitmap to disk cache for key " + paramString);
        this.c.a(paramString, paramBitmap);
      }
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    String str1 = a;
    StringBuilder localStringBuilder = new StringBuilder().append("Appboy image loader outbound network requests are now ");
    if (paramBoolean);
    for (String str2 = "disabled"; ; str2 = "enabled")
    {
      c.c(str1, str2);
      this.f = paramBoolean;
      return;
    }
  }

  Bitmap b(String paramString)
  {
    return (Bitmap)this.b.get(paramString);
  }

  Bitmap c(String paramString)
  {
    synchronized (this.d)
    {
      if (this.e)
        return null;
      if ((this.c != null) && (this.c.b(paramString)))
      {
        Bitmap localBitmap = this.c.a(paramString);
        return localBitmap;
      }
    }
    return null;
  }

  class a extends AsyncTask<File, Void, Void>
  {
    private a()
    {
    }

    protected Void a(File[] paramArrayOfFile)
    {
      synchronized (a.a(a.this))
      {
        File localFile = paramArrayOfFile[0];
        try
        {
          c.b(a.a(), "Initializing disk cache");
          a.a(a.this, new ae(localFile, 1, 1, 52428800L));
          a.a(a.this, false);
          a.a(a.this).notifyAll();
          return null;
        }
        catch (Exception localException)
        {
          while (true)
            c.d(a.a(), "Caught exception creating new disk cache. Unable to create new disk cache", localException);
        }
      }
    }
  }

  class b extends AsyncTask<Void, Void, Bitmap>
  {
    private final ImageView b;
    private final Context c;
    private final com.appboy.b.a d;
    private final String e;

    private b(Context paramImageView, ImageView parama, com.appboy.b.a paramString, String arg5)
    {
      this.b = parama;
      this.c = paramImageView;
      this.d = paramString;
      Object localObject;
      this.e = localObject;
      parama.setTag(R.string.com_appboy_image_lru_cache_image_url_key, localObject);
    }

    protected Bitmap a(Void[] paramArrayOfVoid)
    {
      TrafficStats.setThreadStatsTag(1337);
      return a.this.a(this.c, this.e, this.d);
    }

    protected void a(Bitmap paramBitmap)
    {
      if ((this.b != null) && (((String)this.b.getTag(R.string.com_appboy_image_lru_cache_image_url_key)).equals(this.e)))
      {
        this.b.setImageBitmap(paramBitmap);
        if (this.d == com.appboy.b.a.d)
          b.a(paramBitmap, this.b);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.d.a
 * JD-Core Version:    0.6.2
 */