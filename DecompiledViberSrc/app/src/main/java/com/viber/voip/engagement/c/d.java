package com.viber.voip.engagement.c;

import com.google.d.f;
import com.google.d.g;
import com.google.d.p;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.t;
import com.viber.voip.util.da;

public class d
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final h b;
  private final f c;

  public d()
  {
    this(d.t.f);
  }

  d(h paramh)
  {
    this.b = paramh;
    this.c = new g().a();
  }

  public com.viber.voip.engagement.data.a a()
  {
    String str = this.b.d();
    if (!da.a(str))
      try
      {
        com.viber.voip.util.b.a locala = (com.viber.voip.util.b.a)this.c.a(str, com.viber.voip.util.b.a.class);
        if (locala != null)
        {
          com.viber.voip.engagement.data.a locala1 = new com.viber.voip.engagement.data.a(locala, null);
          return locala1;
        }
      }
      catch (p localp)
      {
      }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.c.d
 * JD-Core Version:    0.6.2
 */