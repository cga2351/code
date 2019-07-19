package com.my.target.common.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.my.target.h;

public final class b extends h<Bitmap>
{
  private static volatile LruCache<b, Bitmap> d = new a(31457280);
  private volatile boolean e;

  private b(String paramString)
  {
    super(paramString);
  }

  private b(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public static b a(String paramString)
  {
    return new b(paramString);
  }

  public static b a(String paramString, int paramInt1, int paramInt2)
  {
    return new b(paramString, paramInt1, paramInt2);
  }

  public void a(Bitmap paramBitmap)
  {
    if (this.e)
    {
      if (paramBitmap == null)
      {
        d.remove(this);
        return;
      }
      d.put(this, paramBitmap);
      return;
    }
    super.a(paramBitmap);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.e);
    Bitmap localBitmap;
    do
    {
      return;
      this.e = paramBoolean;
      if (!paramBoolean)
        break;
      localBitmap = (Bitmap)super.d();
    }
    while (localBitmap == null);
    super.a(null);
    d.put(this, localBitmap);
    return;
    super.a((Bitmap)d.remove(this));
  }

  public Bitmap e()
  {
    return f();
  }

  public Bitmap f()
  {
    if (this.e)
      return (Bitmap)d.get(this);
    return (Bitmap)super.d();
  }

  public String toString()
  {
    return "ImageData{url='" + this.a + '\'' + ", width=" + this.b + ", height=" + this.c + ", bitmap=" + f() + '}';
  }

  private static class a extends LruCache<b, Bitmap>
  {
    public a(int paramInt)
    {
      super();
    }

    protected int a(b paramb, Bitmap paramBitmap)
    {
      if (Build.VERSION.SDK_INT >= 19)
        return paramBitmap.getAllocationByteCount();
      return paramBitmap.getByteCount();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.common.a.b
 * JD-Core Version:    0.6.2
 */