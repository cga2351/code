package com.viber.service.contacts.sync.b;

import android.accounts.Account;
import android.app.Application;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.p;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private com.viber.service.contacts.sync.a.a c;

  public b(Application paramApplication, com.viber.service.contacts.sync.a.a parama)
  {
    this.b = new a(paramApplication);
    this.c = parama;
  }

  public void a()
  {
    Account localAccount = this.b.c();
    d.p.e.a(true);
    d.p.f.a(false);
    if (localAccount == null);
    while (true)
    {
      d.p.e.a(false);
      return;
      try
      {
        if (!this.c.a().a())
          this.b.a();
      }
      catch (Exception localException)
      {
        d.p.g.a(false);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.b.b
 * JD-Core Version:    0.6.2
 */