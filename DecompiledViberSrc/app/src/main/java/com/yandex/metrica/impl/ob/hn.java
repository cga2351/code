package com.yandex.metrica.impl.ob;

import android.location.Location;

abstract class hn
  implements hm
{
  private hm a;

  public hn(hm paramhm)
  {
    this.a = paramhm;
  }

  public abstract void a(Location paramLocation, hp paramhp);

  public void a(String paramString, Location paramLocation, hp paramhp)
  {
    a(paramLocation, paramhp);
    if (this.a != null)
      this.a.a(paramString, paramLocation, paramhp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hn
 * JD-Core Version:    0.6.2
 */