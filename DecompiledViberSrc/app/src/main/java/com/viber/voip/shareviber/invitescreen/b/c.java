package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.f;
import com.viber.voip.registration.af;
import java.util.Iterator;

public class c
  implements j
{
  private static final Logger a = ViberEnv.getLogger();
  private final PhoneController b;
  private final af c;

  public c(PhoneController paramPhoneController, af paramaf)
  {
    this.b = paramPhoneController;
    this.c = paramaf;
  }

  public void a(h paramh)
  {
    int i = this.c.d();
    Iterator localIterator = paramh.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (i != this.b.getCountryCode(locali.w().b()))
        paramh.a(locali.c(), -10);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.c
 * JD-Core Version:    0.6.2
 */