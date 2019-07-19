package com.viber.voip.notif.b.f.d.a;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.b;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.dg;
import dagger.a;

public class d extends com.viber.voip.notif.b.f.d
{
  private final String h;
  private final String i;
  private a<ak> j;
  private com.viber.voip.model.entity.m k;

  public d(com.viber.voip.notif.h.m paramm, a<ak> parama)
  {
    super(paramm);
    this.j = parama;
    h localh = paramm.e();
    this.h = dg.b(localh.o());
    this.i = dg.a(paramm.d(), localh.j(), localh.p());
  }

  private com.viber.voip.model.entity.m h()
  {
    if (this.k == null)
      this.k = ((ak)this.j.get()).b();
    return this.k;
  }

  public String R_()
  {
    return "you_join";
  }

  protected n b(Context paramContext, o paramo, e parame)
  {
    return paramo.a(((b)parame.a(3)).a(this.a.e(), h()));
  }

  public CharSequence b(Context paramContext)
  {
    int m = R.string.message_notification_you_added_group;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.i;
    arrayOfObject[1] = this.h;
    return paramContext.getString(m, arrayOfObject);
  }

  public CharSequence b_(Context paramContext)
  {
    int m = R.string.message_notification_you_added_welcome;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.h;
    return paramContext.getString(m, arrayOfObject);
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a.d
 * JD-Core Version:    0.6.2
 */