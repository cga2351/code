package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView.ScaleType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class pc
{
  private final oj a;
  private int b = 100;
  private final b c;
  private final HashMap<String, a> d = new HashMap();
  private final HashMap<String, a> e = new HashMap();
  private final Handler f = new Handler(Looper.getMainLooper());
  private Runnable g;

  public pc(oj paramoj, b paramb)
  {
    this.a = paramoj;
    this.c = paramb;
  }

  private void a(String paramString, a parama)
  {
    this.e.put(paramString, parama);
    if (this.g == null)
    {
      this.g = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator1 = pc.a(pc.this).values().iterator();
          while (localIterator1.hasNext())
          {
            pc.a locala = (pc.a)localIterator1.next();
            Iterator localIterator2 = pc.a.a(locala).iterator();
            while (localIterator2.hasNext())
            {
              pc.c localc = (pc.c)localIterator2.next();
              if (pc.c.a(localc) != null)
                if (locala.a() == null)
                {
                  pc.c.a(localc, pc.a.b(locala));
                  pc.c.a(localc).a(localc);
                }
                else
                {
                  pc.c.a(localc).a(locala.a());
                }
            }
          }
          pc.a(pc.this).clear();
          pc.b(pc.this);
        }
      };
      this.f.postDelayed(this.g, this.b);
    }
  }

  public c a(String paramString, d paramd, int paramInt1, int paramInt2)
  {
    ImageView.ScaleType localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
    final String str = a(paramString, paramInt1, paramInt2, localScaleType);
    Bitmap localBitmap = this.c.a(str);
    if (localBitmap != null)
    {
      c localc1 = new c(localBitmap, paramString, null, null);
      paramd.a(localc1);
      return localc1;
    }
    c localc2 = new c(null, paramString, str, paramd);
    paramd.a(localc2);
    a locala = (a)this.d.get(str);
    if (locala != null)
    {
      locala.a(localc2);
      return localc2;
    }
    ok.b local1 = new ok.b()
    {
    };
    Bitmap.Config localConfig = Bitmap.Config.RGB_565;
    ok.a local2 = new ok.a()
    {
      public final void a(ov paramAnonymousov)
      {
        pc.this.a(str, paramAnonymousov);
      }
    };
    pd localpd = new pd(paramString, local1, paramInt1, paramInt2, localScaleType, localConfig, local2);
    this.a.a(localpd);
    this.d.put(str, new a(localpd, localc2));
    return localc2;
  }

  public String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    return 12 + paramString.length() + "#W" + paramInt1 + "#H" + paramInt2 + "#S" + paramScaleType.ordinal() + paramString;
  }

  protected final void a(String paramString, Bitmap paramBitmap)
  {
    this.c.a(paramString, paramBitmap);
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      a.a(locala, paramBitmap);
      a(paramString, locala);
    }
  }

  protected final void a(String paramString, ov paramov)
  {
    a locala = (a)this.d.remove(paramString);
    if (locala != null)
    {
      locala.a(paramov);
      a(paramString, locala);
    }
  }

  private final class a
  {
    private final oi<?> b;
    private Bitmap c;
    private ov d;
    private final LinkedList<pc.c> e = new LinkedList();

    public a(pc.c arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.e.add(localObject2);
    }

    public final ov a()
    {
      return this.d;
    }

    public final void a(ov paramov)
    {
      this.d = paramov;
    }

    public final void a(pc.c paramc)
    {
      this.e.add(paramc);
    }
  }

  public static abstract interface b
  {
    public abstract Bitmap a(String paramString);

    public abstract void a(String paramString, Bitmap paramBitmap);
  }

  public final class c
  {
    private Bitmap b;
    private final pc.d c;
    private final String d;
    private final String e;

    public c(Bitmap paramString1, String paramString2, String paramd, pc.d arg5)
    {
      this.b = paramString1;
      this.e = paramString2;
      this.d = paramd;
      Object localObject;
      this.c = localObject;
    }

    public final Bitmap a()
    {
      return this.b;
    }
  }

  public static abstract interface d extends ok.a
  {
    public abstract void a(pc.c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pc
 * JD-Core Version:    0.6.2
 */