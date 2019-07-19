package com.viber.voip.ads.b.a.c;

import com.viber.voip.ads.b.a.a.l;
import com.viber.voip.ads.b.a.a.l.a;
import com.viber.voip.ads.b.a.a.m;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.b.b.c.a;

public abstract class b
  implements a<com.viber.voip.ads.b.a.a.a.b>
{
  private final com.viber.voip.ads.b.b.b.c a;
  private final c.a b;
  private final m c;

  public b(com.viber.voip.ads.b.b.b.c paramc, c.a parama, m paramm)
  {
    this.a = paramc;
    this.c = paramm;
    this.b = parama;
  }

  private l a()
  {
    return a(this.b.a(this.a));
  }

  protected l a(int paramInt)
  {
    return this.c.a(paramInt);
  }

  public void a(com.viber.voip.ads.b.a.a.a.b paramb, com.viber.voip.ads.b.b.a.c paramc)
  {
    Integer localInteger = paramb.a();
    l locall;
    if (localInteger == null)
    {
      locall = a();
      if (locall != null)
        break label34;
    }
    label34: l.a locala;
    do
    {
      return;
      locall = a(localInteger.intValue());
      break;
      locala = paramb.a(locall.a());
    }
    while (locala == null);
    a(locall, locala, paramc);
  }

  protected void a(l paraml, l.a parama, com.viber.voip.ads.b.b.a.c paramc)
  {
    paraml.a(parama, paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.c.b
 * JD-Core Version:    0.6.2
 */