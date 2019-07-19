package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bx;
import com.yandex.metrica.impl.i;

public abstract class au
  implements ax
{
  private final Context a;
  private final an b;
  private final ij c;

  public au(Context paramContext, an paraman)
  {
    this(paramContext, paraman, new ij(hw.a(paramContext), np.a(paramContext), bx.a(paramContext), new fy(fj.a(paramContext).c())));
  }

  au(Context paramContext, an paraman, ij paramij)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paraman;
    this.c = paramij;
    this.b.a(this);
    this.c.b(this);
  }

  public void a()
  {
    this.b.b(this);
    this.c.a(this);
  }

  public void a(i parami, t paramt)
  {
    if (!b().d())
      b(parami, paramt);
  }

  public an b()
  {
    return this.b;
  }

  protected abstract void b(i parami, t paramt);

  public ij c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.au
 * JD-Core Version:    0.6.2
 */