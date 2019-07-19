package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.b.f.c;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.t;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

public class j extends c
{
  private final boolean h = this.a.e().b();
  private final String i = dg.b(this.a.e().o());

  public j(com.viber.voip.notif.h.m paramm, e parame)
  {
    super(paramm, parame);
  }

  protected t b(Context paramContext, o paramo)
  {
    Resources localResources = paramContext.getResources();
    boolean bool = this.h;
    MessageEntity localMessageEntity = this.a.c();
    if (this.h);
    for (String str = da.e(this.c, this.i); ; str = da.j(this.c))
      return paramo.b(com.viber.voip.messages.m.a(localResources, bool, localMessageEntity, str));
  }

  public CharSequence b(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    boolean bool = this.h;
    MessageEntity localMessageEntity = this.a.c();
    if (this.h);
    for (String str = da.j(this.c); ; str = null)
      return com.viber.voip.messages.m.a(localResources, bool, localMessageEntity, str);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.h)
      return this.i;
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.j
 * JD-Core Version:    0.6.2
 */