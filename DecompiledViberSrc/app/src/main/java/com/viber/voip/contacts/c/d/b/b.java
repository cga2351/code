package com.viber.voip.contacts.c.d.b;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.f;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.i;
import com.viber.voip.contacts.c.f.b.c;
import com.viber.voip.memberid.Member;

public class b extends i
{
  private static final Logger k = ViberEnv.getLogger("ContactsManagerSecondaryImpl [Secondary]");
  private static b l;
  private a m = new a(paramContext, this.f);
  private com.viber.voip.contacts.c.f.b.b.a n = new com.viber.voip.contacts.c.f.b.b.a(paramContext, this.d, this, this.f);

  protected b(Context paramContext, ViberApplication paramViberApplication)
  {
    super(paramContext, paramViberApplication);
    this.d.getEngine(false).addInitializedListener(this);
  }

  public static g a(Context paramContext, ViberApplication paramViberApplication)
  {
    if ((l == null) && (com.viber.voip.o.a.a == com.viber.voip.o.a.a()));
    try
    {
      if (l == null)
        l = new b(paramContext, paramViberApplication);
      return l;
    }
    finally
    {
    }
  }

  public void a()
  {
    super.a();
    try
    {
      l = null;
      return;
    }
    finally
    {
    }
  }

  public void a(Member paramMember)
  {
  }

  public void b()
  {
  }

  public c d()
  {
    return this.n;
  }

  protected f k()
  {
    return this.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.b.b
 * JD-Core Version:    0.6.2
 */