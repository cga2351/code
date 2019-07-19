package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.aq;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s;

public class an<COMPONENT extends ai,  extends ag>
  implements ac
{
  private final Context a;
  private final y b;
  private final ap c;
  private final ba<COMPONENT> d;
  private t e;
  private COMPONENT f;
  private ah g;
  private final z<ax> h;

  public an(Context paramContext, y paramy, t paramt, ba<COMPONENT> paramba)
  {
    this(paramContext, paramy, paramt, paramba, new aq(), new z());
  }

  public an(Context paramContext, y paramy, t paramt, ba<COMPONENT> paramba, aq paramaq, z<ax> paramz)
  {
    this.a = paramContext;
    this.b = paramy;
    this.e = paramt;
    this.c = paramaq.a(this.a, this.b);
    this.d = paramba;
    this.h = paramz;
  }

  private ah a()
  {
    if (this.g == null)
      this.g = this.d.b(this.a, this.b, this.e, this.c);
    return this.g;
  }

  public void a(i parami, t paramt)
  {
    a().d();
    if (s.d(parami.e()));
    for (Object localObject = a(); ; localObject = this.f)
    {
      if (!s.a(parami.e()))
        a(paramt);
      ((ai)localObject).a(parami);
      return;
      if (this.f == null)
        this.f = this.d.a(this.a, this.b, this.e, this.c);
    }
  }

  public void a(ax paramax)
  {
    try
    {
      this.h.a(paramax);
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
    try
    {
      this.e = paramt;
      if (this.g != null)
        this.g.a(paramt);
      if (this.f != null)
        this.f.a(paramt);
      return;
    }
    finally
    {
    }
  }

  public void b(ax paramax)
  {
    try
    {
      this.h.b(paramax);
      if (this.h.b())
      {
        if (this.f != null)
          this.f.h();
        if (this.g != null)
          this.g.h();
      }
      return;
    }
    finally
    {
    }
  }

  public boolean d()
  {
    try
    {
      boolean bool = this.h.b();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.an
 * JD-Core Version:    0.6.2
 */