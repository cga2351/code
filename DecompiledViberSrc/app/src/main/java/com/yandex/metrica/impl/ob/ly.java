package com.yandex.metrica.impl.ob;

import android.content.Context;

public class ly
{
  private ge<mb> a;
  private mb b;
  private om c;
  private md d;

  public ly(Context paramContext, ge<mb> paramge)
  {
    this(paramge, new om(), new md(paramContext, paramge));
  }

  ly(ge<mb> paramge, om paramom, md parammd)
  {
    this.a = paramge;
    this.b = ((mb)this.a.a());
    this.c = paramom;
    this.d = parammd;
  }

  public void a()
  {
    mb localmb = new mb(this.b.a, this.b.b, this.c.a(), true, true);
    this.a.a(localmb);
    this.b = localmb;
  }

  public void a(mb parammb)
  {
    this.a.a(parammb);
    this.b = parammb;
    this.d.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ly
 * JD-Core Version:    0.6.2
 */