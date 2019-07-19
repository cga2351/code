package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.bv;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.v;
import java.util.Iterator;
import java.util.List;

public class w
  implements ac, ag, mt
{
  private final Context a;
  private final y b;
  private mo c;
  private mx d;
  private t e;
  private ap f;
  private by<bx, w> g;
  private bv<w> h;
  private final z<az> i = new z();
  private li j;
  private final li.a k;
  private ku l;

  public w(Context paramContext, mo parammo, y paramy, t paramt, li paramli, ap paramap)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramy;
    this.e = paramt;
    this.c = parammo;
    this.f = paramap;
    this.g = new by(new bq(this), this);
    this.h = new bv(this, new nb(this, this.c), this.f);
    this.d = this.c.d(this, paramt);
    this.j = paramli;
    this.k = new li.a()
    {
      public boolean a(lj paramAnonymouslj)
      {
        if (!TextUtils.isEmpty(paramAnonymouslj.a))
          w.a(w.this).a(paramAnonymouslj.a);
        return false;
      }
    };
    this.j.a(this.k);
  }

  public t a()
  {
    return this.e;
  }

  public void a(i parami, az paramaz)
  {
    this.g.a(parami, paramaz);
  }

  public void a(az paramaz)
  {
    try
    {
      this.i.a(paramaz);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(mq parammq)
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
      ((mt)localIterator.next()).a(parammq);
  }

  public void a(mt parammt)
  {
    if (this.d.d())
    {
      this.h.d();
      return;
    }
    parammt.a(this.d.f());
  }

  public void a(mw parammw)
  {
    Iterator localIterator = this.i.a().iterator();
    while (localIterator.hasNext())
      ((mt)localIterator.next()).a(parammw);
    if (parammw != null)
    {
      if (this.l == null)
        this.l = v.a().e();
      this.l.a(parammw);
    }
  }

  public void a(t paramt)
  {
    this.e = paramt;
  }

  public y b()
  {
    return this.b;
  }

  public void b(az paramaz)
  {
    try
    {
      this.i.b(paramaz);
      if (this.i.b())
      {
        this.j.b(this.k);
        this.c.a(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Context c()
  {
    return this.a;
  }

  public boolean d()
  {
    try
    {
      boolean bool = this.i.b();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public mt e()
  {
    return this;
  }

  public li f()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.w
 * JD-Core Version:    0.6.2
 */