package com.adsnative.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v4.util.LruCache;
import java.io.IOException;

public class e
{
  private static e b = null;
  private final a a;

  private e(a parama)
  {
    this.a = parama;
  }

  public static e a(Context paramContext)
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new e(new a()
        {
          public Bitmap a(String paramAnonymousString)
          {
            return (Bitmap)this.a.get(paramAnonymousString);
          }

          public boolean a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
          {
            if ((paramAnonymousString != null) && (paramAnonymousBitmap != null))
            {
              this.a.put(paramAnonymousString, paramAnonymousBitmap);
              return true;
            }
            i.e("ImageLoader key or bitmap is null !!");
            return false;
          }
        });
      return b;
    }
    finally
    {
    }
  }

  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    return 12 + paramString.length() + "#W" + paramInt1 + "#H" + paramInt2 + paramString;
  }

  private void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
  }

  private void a(Bitmap paramBitmap, String paramString, c paramc)
  {
    paramc.a(new b(paramBitmap, paramString));
  }

  public void a(String paramString, c paramc)
    throws IOException
  {
    a(paramString, paramc, 0, 0);
  }

  public void a(String paramString, c paramc, int paramInt1, int paramInt2)
    throws IOException
  {
    a();
    if ((paramString == null) || (paramString.length() <= 0))
    {
      paramc.a();
      return;
    }
    String str = a(paramString, paramInt1, paramInt2);
    Bitmap localBitmap = this.a.a(str);
    if (localBitmap != null)
    {
      a(localBitmap, paramString, paramc);
      return;
    }
    new d(paramString, str, paramc).execute(new String[0]);
  }

  public static abstract interface a
  {
    public abstract Bitmap a(String paramString);

    public abstract boolean a(String paramString, Bitmap paramBitmap);
  }

  public class b
  {
    private Bitmap b;
    private final String c;

    public b(Bitmap paramString, String arg3)
    {
      this.b = paramString;
      Object localObject;
      this.c = localObject;
    }

    public Bitmap a()
    {
      return this.b;
    }
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(e.b paramb);
  }

  private class d extends AsyncTask<String, Void, Bitmap>
  {
    private String b;
    private String c;
    private e.c d;

    public d(String paramString1, String paramc, e.c arg4)
    {
      this.b = paramString1;
      this.c = paramc;
      Object localObject;
      this.d = localObject;
    }

    protected Bitmap a(String[] paramArrayOfString)
    {
      try
      {
        Bitmap localBitmap = o.a(this.b);
        return localBitmap;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      return null;
    }

    protected void a(Bitmap paramBitmap)
    {
      super.onPostExecute(paramBitmap);
      if (e.a(e.this).a(this.c, paramBitmap))
      {
        e.a(e.this, paramBitmap, this.b, this.d);
        return;
      }
      this.d.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.e
 * JD-Core Version:    0.6.2
 */