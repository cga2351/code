package com.viber.voip.api.a.b;

import com.viber.voip.api.a.b.a.e;
import com.viber.voip.api.a.b.a.g;
import g.b;
import g.b.t;
import g.b.u;
import java.util.Map;

public abstract interface a
{
  @g.b.f(a="1/rates/destinations")
  public abstract b<com.viber.voip.api.a.b.a.f> a(@t(a="lang") String paramString);

  @g.b.f(a="1/account/balance")
  public abstract b<e> a(@t(a="phone") String paramString1, @t(a="token") String paramString2, @t(a="ts") long paramLong, @t(a="lang") String paramString3);

  @g.b.f(a="2/products/android")
  public abstract b<g> a(@u Map<String, String> paramMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.b.a
 * JD-Core Version:    0.6.2
 */