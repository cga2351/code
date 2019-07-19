package com.viber.voip.market.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.ac;
import com.viber.voip.billing.ad;
import com.viber.voip.billing.ae;
import com.viber.voip.billing.af;
import com.viber.voip.billing.b;
import com.viber.voip.billing.g;
import com.viber.voip.market.MarketApi.c;

public class d
{
  private static final Logger a = ViberEnv.getLogger();

  public void a(MarketApi.c paramc)
  {
    a(paramc, false);
  }

  public void a(final MarketApi.c paramc, boolean paramBoolean)
  {
    final String str = b.b();
    if (paramBoolean)
      g.a().c();
    g.a().a(new ad()
    {
      public void a(ac paramAnonymousac)
      {
        paramc.a(str, str, paramAnonymousac.a);
      }

      public void a(ae paramAnonymousae)
      {
        paramc.a(str);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.d
 * JD-Core Version:    0.6.2
 */