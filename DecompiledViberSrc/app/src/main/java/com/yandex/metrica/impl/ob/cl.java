package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.i;

public class cl extends ci
{
  private final ds a;

  public cl(ab paramab)
  {
    this(paramab, paramab.I());
  }

  cl(ab paramab, ds paramds)
  {
    super(paramab);
    this.a = paramds;
  }

  public boolean a(i parami)
  {
    if (!TextUtils.isEmpty(parami.b()))
      parami.a(this.a.a(parami.b()));
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cl
 * JD-Core Version:    0.6.2
 */