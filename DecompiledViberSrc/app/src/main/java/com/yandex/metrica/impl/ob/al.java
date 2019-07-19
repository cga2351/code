package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ap;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.s.a;

public class al extends ab
{
  private final li a;
  private final a b;
  private final com.yandex.metrica.impl.bt c;

  public al(Context paramContext, mo parammo, ap paramap, y paramy, t paramt, li paramli, com.yandex.metrica.impl.bt parambt)
  {
    super(paramContext, parammo, paramap, paramy, paramt, new ak(parambt), new na());
    this.a = paramli;
    bt localbt = f();
    localbt.a(s.a.c, new di(localbt.a()));
    this.b = new a();
    this.a.a(this.b);
    this.c = parambt;
  }

  public void a(t paramt)
  {
    try
    {
      super.a(paramt);
      this.c.a(paramt.b().o());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void i()
  {
    try
    {
      this.a.b(this.b);
      super.i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  class a
    implements li.a
  {
    a()
    {
    }

    public boolean a(lj paramlj)
    {
      i locali = new i().a(paramlj.a()).a(s.a.v.a());
      al.this.a(locali);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.al
 * JD-Core Version:    0.6.2
 */