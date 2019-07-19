package com.viber.voip.ads.b.a.c;

import com.viber.voip.ads.b.a.a.m;
import com.viber.voip.ads.b.b.b.c.a;
import java.util.HashMap;
import java.util.Map;

public class a
  implements com.viber.voip.ads.b.b.c.b<com.viber.voip.ads.b.a.a.a.b>
{
  private final m a;
  private final c.a b;
  private final Map<com.viber.voip.ads.b.b.b.c, com.viber.voip.ads.b.b.c.a<com.viber.voip.ads.b.a.a.a.b>> c = new HashMap();

  public a(m paramm, c.a parama)
  {
    this.a = paramm;
    this.b = parama;
  }

  private com.viber.voip.ads.b.b.c.a<com.viber.voip.ads.b.a.a.a.b> b(com.viber.voip.ads.b.b.b.c paramc)
  {
    switch (1.a[paramc.ordinal()])
    {
    default:
      return null;
    case 1:
      return new c(com.viber.voip.ads.b.b.b.c.e, this.b, this.a);
    case 2:
      return new c(com.viber.voip.ads.b.b.b.c.h, this.b, this.a);
    case 3:
      return new c(com.viber.voip.ads.b.b.b.c.i, this.b, this.a);
    case 4:
    }
    return new c(com.viber.voip.ads.b.b.b.c.j, this.b, this.a);
  }

  public com.viber.voip.ads.b.b.c.a<com.viber.voip.ads.b.a.a.a.b> a(com.viber.voip.ads.b.b.b.c paramc)
  {
    com.viber.voip.ads.b.b.c.a locala = (com.viber.voip.ads.b.b.c.a)this.c.get(paramc);
    if (locala == null)
    {
      locala = b(paramc);
      if (locala != null)
        this.c.put(paramc, locala);
    }
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.c.a
 * JD-Core Version:    0.6.2
 */