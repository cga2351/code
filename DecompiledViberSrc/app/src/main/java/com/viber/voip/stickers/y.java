package com.viber.voip.stickers;

import android.graphics.Bitmap;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a.a.a.d;
import com.viber.voip.stickers.entity.Sticker;
import java.util.Iterator;

class y
{
  private static final Logger a = ViberEnv.getLogger();
  private final f b;
  private final Handler c;
  private final d d;
  private volatile a e;
  private volatile a f;

  y(f paramf, Handler paramHandler, d paramd)
  {
    this.b = paramf;
    this.c = paramHandler;
    this.d = paramd;
  }

  private void a(a parama)
  {
    try
    {
      if (this.e == parama)
        this.e = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Bitmap a(Sticker paramSticker)
  {
    while (true)
    {
      Bitmap localBitmap;
      boolean bool;
      synchronized (this.d)
      {
        localBitmap = this.d.a(paramSticker);
        if (localBitmap == null)
        {
          f localf = this.b;
          if (paramSticker.isReady())
            break label94;
          bool = true;
          localBitmap = localf.c(paramSticker, bool, true, w.c);
          if (localBitmap == null);
        }
      }
      synchronized (this.d)
      {
        this.d.a(paramSticker, localBitmap);
        return localBitmap;
        localObject1 = finally;
        throw localObject1;
        label94: bool = false;
      }
    }
  }

  public void a()
  {
    synchronized (this.d)
    {
      this.d.evictAll();
      return;
    }
  }

  public void a(int[] paramArrayOfInt, z paramz)
  {
    try
    {
      int i = paramArrayOfInt.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          if (paramArrayOfInt[j] > 0)
            k = 1;
        }
        else
        {
          if (k != 0)
          {
            if (this.f != null)
              this.f.a();
            this.f = new a(paramArrayOfInt, paramz);
            this.f.b();
          }
          return;
        }
      }
    }
    finally
    {
    }
  }

  public void b(Sticker paramSticker)
  {
    if (this.d.a(paramSticker) != null)
    {
      Bitmap localBitmap = this.b.c(paramSticker, false, true, w.c);
      if (localBitmap != null)
        synchronized (this.d)
        {
          this.d.a(paramSticker, localBitmap);
          return;
        }
    }
  }

  private class a
    implements Runnable
  {
    private volatile boolean b;
    private Iterable<Sticker> c;
    private int[] d;
    private z e;

    public a(int[] paramz, z arg3)
    {
      this.d = paramz;
      Object localObject;
      this.e = localObject;
    }

    private void a(Sticker paramSticker)
    {
      while (true)
      {
        synchronized (y.b(y.this))
        {
          if (y.b(y.this).a(paramSticker) != null)
            return;
          f localf = y.c(y.this);
          if (!paramSticker.isReady())
          {
            bool = true;
            Bitmap localBitmap = localf.c(paramSticker, bool, true, w.c);
            if (localBitmap == null)
              break;
            synchronized (y.b(y.this))
            {
              y.b(y.this).a(paramSticker, localBitmap);
              return;
            }
          }
        }
        boolean bool = false;
      }
    }

    public void a()
    {
      this.b = true;
    }

    public void b()
    {
      new Thread(this).start();
    }

    public void run()
    {
      long l = System.currentTimeMillis();
      Sticker localSticker;
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          localSticker = (Sticker)localIterator.next();
          if (!this.b)
            break label92;
        }
      }
      while (true)
      {
        if (this.e != null)
          y.a(y.this).post(new Runnable()
          {
            public void run()
            {
              y.a.b(y.a.this).a(y.a.a(y.a.this));
            }
          });
        y.a(y.this, this);
        (System.currentTimeMillis() - l);
        return;
        label92: a(localSticker);
        break;
        if (this.d != null)
        {
          int[] arrayOfInt = this.d;
          int i = arrayOfInt.length;
          int j = 0;
          label120: int k;
          if (j < i)
          {
            k = arrayOfInt[j];
            if (k > 0)
              break label144;
          }
          label144: 
          do
          {
            j++;
            break label120;
            break;
            if (k > 0)
              a(i.a().u(k));
          }
          while (!this.b);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.y
 * JD-Core Version:    0.6.2
 */