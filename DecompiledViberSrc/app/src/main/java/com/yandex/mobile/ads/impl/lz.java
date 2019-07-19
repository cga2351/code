package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public final class lz
{
  private static final Object a = new Object();
  private static volatile lz b;
  private final pc c;
  private final LruCache<String, Bitmap> d;
  private final lw e;
  private final ly f;

  private lz(Context paramContext)
  {
    this.d = new LruCache(db.a(paramContext))
    {
    };
    oj localoj = bl.a(paramContext);
    localoj.a();
    a locala = new a(this.d);
    this.e = new lw();
    this.f = new ly(dd.i(paramContext));
    this.c = new lx(localoj, locala, this.e, this.f);
  }

  @TargetApi(12)
  public static lz a(Context paramContext)
  {
    if (b == null);
    synchronized (a)
    {
      if (b == null)
        b = new lz(paramContext);
      return b;
    }
  }

  public final LruCache<String, Bitmap> a()
  {
    return this.d;
  }

  public final pc b()
  {
    return this.c;
  }

  @TargetApi(12)
  static final class a
    implements pc.b
  {
    private final LruCache<String, Bitmap> a;

    a(LruCache<String, Bitmap> paramLruCache)
    {
      this.a = paramLruCache;
    }

    public final Bitmap a(String paramString)
    {
      return (Bitmap)this.a.get(paramString);
    }

    public final void a(String paramString, Bitmap paramBitmap)
    {
      this.a.put(paramString, paramBitmap);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lz
 * JD-Core Version:    0.6.2
 */