package com.viber.voip.g.a;

import com.viber.voip.ap;
import com.viber.voip.api.a.a.a;
import com.viber.voip.report.a.b;
import javax.inject.Singleton;

public abstract class fb
{
  @Singleton
  static b a(a parama)
  {
    return new b(parama, "prod".equals(ap.d()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fb
 * JD-Core Version:    0.6.2
 */