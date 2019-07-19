package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;

class ih extends hn
{
  private fm a;
  private ho b;
  private om c;

  public ih(Context paramContext, hm paramhm)
  {
    this(paramhm, fj.a(paramContext).g(), new ho(paramContext), new om());
  }

  ih(hm paramhm, fm paramfm, ho paramho, om paramom)
  {
    super(paramhm);
    this.a = paramfm;
    this.b = paramho;
    this.c = paramom;
  }

  public void a(Location paramLocation, hp paramhp)
  {
    if ((paramhp != null) && (paramLocation != null))
    {
      ic localic = new ic(paramhp.a(), this.c.a(), paramLocation);
      String str = this.b.a(localic);
      if (!TextUtils.isEmpty(str))
        this.a.a(localic.b(), str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ih
 * JD-Core Version:    0.6.2
 */