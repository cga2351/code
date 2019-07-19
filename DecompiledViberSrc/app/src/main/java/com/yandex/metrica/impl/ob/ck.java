package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;

public class ck extends ci
{
  private fu a;
  private ok b;

  public ck(ab paramab)
  {
    this(paramab, paramab.B(), ok.a());
  }

  ck(ab paramab, fu paramfu, ok paramok)
  {
    super(paramab);
    this.a = paramfu;
    this.b = paramok;
  }

  public boolean a(i parami)
  {
    ab localab = a();
    lr locallr = localab.l();
    if (!this.a.d())
    {
      if (!this.a.c())
      {
        if (locallr.L())
          this.b.c();
        String str = parami.c();
        this.a.c(str);
        localab.c(i.a(parami, s.a.B).c(str));
        localab.a(true);
        this.a.a(locallr.M());
        a().I().a();
      }
      this.a.b();
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ck
 * JD-Core Version:    0.6.2
 */