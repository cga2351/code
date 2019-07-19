package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.q;
import com.yandex.metrica.impl.s;

public class bi
  implements ag, ah, bn, mt
{
  private final Context a;
  private final y b;
  private final q c;
  private bj d;
  private at e;

  public bi(Context paramContext, y paramy, ap paramap, t paramt, mo parammo, mz parammz)
  {
    this(paramContext, paramy, paramap, paramt, parammo, parammz, new bo(), new b(), new a(), new at(paramContext, paramy));
  }

  public bi(Context paramContext, y paramy, ap paramap, t paramt, mo parammo, mz parammz, bo parambo, b paramb, a parama, at paramat)
  {
    this.a = paramContext;
    this.b = paramy;
    this.e = paramat;
    this.c = paramb.a(this, parammz, parammo, paramap, parambo);
    try
    {
      mw localmw = parammo.d(this, paramt).f();
      this.e.a(localmw.x);
      this.d = parama.a(paramContext, paramy, localmw, paramt);
      return;
    }
    finally
    {
    }
  }

  public t a()
  {
    return this.d.a();
  }

  public void a(i parami)
  {
    this.c.a(parami);
  }

  public void a(mq parammq)
  {
  }

  public void a(mw parammw)
  {
    try
    {
      this.d.a(parammw);
      this.e.a(parammw.x);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(t paramt)
  {
    this.d.a(paramt);
  }

  public y b()
  {
    return this.b;
  }

  public Context c()
  {
    return this.a;
  }

  public void d()
  {
    if (this.e.a(this.d.a()))
    {
      a(s.a());
      this.e.a();
    }
  }

  public mt e()
  {
    return this;
  }

  public bm f()
  {
    return (bm)this.d.e();
  }

  public void h()
  {
    bw.a(this.c);
  }

  static class a
  {
    public bj a(Context paramContext, y paramy, mw parammw, t paramt)
    {
      return new bj(new bm.b(paramContext, paramy.b()), parammw, paramt);
    }
  }

  static class b
  {
    public q<bi> a(bi parambi, mz parammz, mo parammo, ap paramap, bo parambo)
    {
      return new q(parambi, parammz.a(parambi, parammo), paramap, parambo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bi
 * JD-Core Version:    0.6.2
 */