package com.viber.service.contacts.sync.a.a.a.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.service.contacts.sync.a.a.a.f.a;
import com.viber.service.contacts.sync.a.a.a.i.a;
import com.viber.voip.ViberEnv;

public class c extends com.viber.service.contacts.sync.a.a.a
{
  private static final Logger a = ViberEnv.getLogger();

  public c(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, new a(), paramString1, paramString2);
  }

  protected String a(a.f.a parama)
  {
    return parama.a + "." + parama.c;
  }

  protected String a(a.i.a parama)
  {
    return parama.b + "." + parama.c;
  }

  protected Logger g()
  {
    return a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.a.a.a.a.c
 * JD-Core Version:    0.6.2
 */