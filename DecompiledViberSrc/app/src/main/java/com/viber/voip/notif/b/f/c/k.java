package com.viber.voip.notif.b.f.c;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

public class k extends com.viber.voip.notif.b.f.c
{
  public k(m paramm)
  {
    super(paramm, null);
  }

  private String h()
  {
    return dg.b(this.a.e().o());
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected void a(Context paramContext, o paramo)
  {
    super.a(paramContext, paramo);
    a(paramo.a(String.valueOf(this.a.j())));
  }

  public CharSequence b(Context paramContext)
  {
    if (this.a.e().b())
    {
      int j = R.string.message_notification_smart_messages_group;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = h();
      return paramContext.getString(j, arrayOfObject2);
    }
    int i = R.string.message_notification_smart_messages_one;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.c;
    return paramContext.getString(i, arrayOfObject1);
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.a.e().b())
      return h();
    return this.c;
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.k
 * JD-Core Version:    0.6.2
 */