package com.viber.voip.notif.b.f.c;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.c;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.f.b;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;
import dagger.a;

public class o extends c
{
  private final a<ak> h;
  private com.viber.voip.model.entity.m i;

  public o(com.viber.voip.notif.h.m paramm, a<ak> parama)
  {
    super(paramm, null);
    this.h = parama;
  }

  private String h()
  {
    if (this.a.e().b())
      return dg.b(this.a.e().o());
    return dg.a(i(), this.a.e().j(), this.a.e().p());
  }

  private com.viber.voip.model.entity.m i()
  {
    if (this.i == null)
    {
      h localh = this.a.e();
      this.i = ((ak)this.h.get()).c(new Member(this.a.c().getMemberId()), cd.j(localh.j()));
    }
    return this.i;
  }

  public String R_()
  {
    return "unsent_message";
  }

  public int a()
  {
    return (int)this.a.c().getConversationId();
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected void a(Context paramContext, com.viber.voip.notif.c.o paramo)
  {
    super.a(paramContext, paramo);
    if (this.a.j() > 1)
    {
      n[] arrayOfn = new n[1];
      arrayOfn[0] = paramo.a(String.valueOf(this.a.j()));
      a(arrayOfn);
    }
  }

  protected n b(Context paramContext, com.viber.voip.notif.c.o paramo, e parame)
  {
    if (this.a.e().b())
      return super.b(paramContext, paramo, parame);
    return paramo.a(((b)parame.a(3)).a(this.a.e(), i()));
  }

  public CharSequence b(Context paramContext)
  {
    if (this.a.j() > 1);
    for (int j = R.string.notification_unsent_msg_plural; ; j = R.string.notification_unsent_msg)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = h();
      return paramContext.getString(j, arrayOfObject);
    }
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getString(R.string.notification_unsent_msg_title);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.o
 * JD-Core Version:    0.6.2
 */