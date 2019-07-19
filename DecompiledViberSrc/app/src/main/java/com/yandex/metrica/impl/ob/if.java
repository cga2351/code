package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import java.util.HashMap;
import java.util.Map;

class if
{
  private c a;
  private a b;
  private b c;
  private Context d;
  private hp e;
  private mw f;
  private ih g;
  private ii h;
  private hl i;
  private hq j;
  private Map<String, hy> k = new HashMap();

  if(Context paramContext, mw parammw, hp paramhp, c paramc, a parama, b paramb, ii paramii, hl paramhl)
  {
    this.d = paramContext;
    this.f = parammw;
    this.e = paramhp;
    this.a = paramc;
    this.b = parama;
    this.c = paramb;
    this.h = paramii;
    this.i = paramhl;
  }

  public if(Context paramContext, mw parammw, hp paramhp, ii paramii, hl paramhl)
  {
    this(paramContext, parammw, paramhp, new c(), new a(), new b(), paramii, paramhl);
  }

  public Location a()
  {
    if (this.j == null)
      return null;
    return this.j.a();
  }

  public void a(Location paramLocation)
  {
    String str = paramLocation.getProvider();
    hy localhy = (hy)this.k.get(str);
    if (localhy == null)
    {
      if (this.g == null)
        this.g = this.a.a(this.d, null);
      if (this.j == null)
        this.j = this.b.a(this.g);
      localhy = this.c.a(str, this.e, this.g, this.h, this.i);
      this.k.put(str, localhy);
    }
    while (true)
    {
      localhy.a(paramLocation);
      return;
      localhy.a(this.e);
    }
  }

  public void a(mw parammw, hp paramhp)
  {
    this.f = parammw;
    this.e = paramhp;
  }

  public static class a
  {
    public hq a(hm paramhm)
    {
      return new hq(paramhm);
    }
  }

  public static class b
  {
    public hy a(String paramString, hp paramhp, ih paramih, ii paramii, hl paramhl)
    {
      return new hy(paramString, paramhp, paramih, paramii, paramhl);
    }
  }

  public static class c
  {
    public ih a(Context paramContext, hm paramhm)
    {
      return new ih(paramContext, paramhm);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.if
 * JD-Core Version:    0.6.2
 */