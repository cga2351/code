package com.viber.voip.stickers.d;

import android.os.Handler;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.n;
import com.viber.voip.util.cl;
import java.util.HashSet;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final b b = (b)cl.b(b.class);
  private final SparseArray<Sticker> c = new SparseArray();
  private final Set<Integer> d = new HashSet();
  private final Handler e;
  private final Handler f;
  private final i g;
  private b h = b;
  private final b i = new n()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
      a.this.a(paramAnonymousSticker);
    }
  };

  public a(i parami, Handler paramHandler1, Handler paramHandler2)
  {
    this.g = parami;
    this.e = paramHandler1;
    this.f = paramHandler2;
  }

  public Sticker a(int paramInt)
  {
    Sticker localSticker = (Sticker)this.c.get(paramInt);
    if (localSticker != null)
      return localSticker;
    this.d.add(Integer.valueOf(paramInt));
    this.e.post(new a(paramInt));
    return null;
  }

  public void a()
  {
    this.g.a(this.i);
  }

  public void a(b paramb)
  {
    if (paramb == null)
    {
      this.h = b;
      return;
    }
    this.h = paramb;
  }

  void a(Sticker paramSticker)
  {
    if (this.d.contains(Integer.valueOf(paramSticker.id)))
    {
      this.d.remove(Integer.valueOf(paramSticker.id));
      this.c.put(paramSticker.id, paramSticker);
      this.h.a(paramSticker);
    }
  }

  public void b()
  {
    this.g.b(this.i);
  }

  void b(int paramInt)
  {
    Sticker localSticker = this.g.u(paramInt);
    if ((localSticker.isReady()) && (localSticker.isInDatabase()))
      this.f.post(new c(localSticker));
  }

  private class a
    implements Runnable
  {
    private final int b;

    a(int arg2)
    {
      int i;
      this.b = i;
    }

    public void run()
    {
      a.this.b(this.b);
    }
  }

  public static abstract interface b
  {
    public abstract void a(Sticker paramSticker);
  }

  private class c
    implements Runnable
  {
    private final Sticker b;

    c(Sticker arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      a.this.a(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.d.a
 * JD-Core Version:    0.6.2
 */